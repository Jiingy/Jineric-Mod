package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.authlib.GameProfile;
import com.mojang.serialization.Codec;
import jingy.jineric.access.JmServerPlayer;
import jingy.jineric.config.JmConfig;
import jingy.jineric.server.network.JmServerRecipeBook;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.ServerRecipeBook;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.Optional;
import java.util.function.Consumer;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player implements JmServerPlayer {
	public ServerPlayerMixin(Level world, GameProfile profile) {
		super(world, profile);
	}
	@Shadow @Final private MinecraftServer server;
	@Mutable @Shadow @Final private ServerRecipeBook recipeBook;
	@Unique private final boolean moddedRecipeBook = JmConfig.REPLACE_VANILLA_RECIPE_BOOK;
	
	@Inject(
			method = "<init>",
			at = @At("CTOR_HEAD")
	)
	private void setJmRecipeBookInstance(MinecraftServer server, ServerLevel world, GameProfile profile, ClientInformation clientOptions, CallbackInfo ci) {
		if (this.moddedRecipeBook) {
			this.jineric$setRecipeBook(new JmServerRecipeBook((recipeKey, adder) -> server.getRecipeManager().listDisplaysForRecipe(recipeKey, adder)));
		}
	}
	
	@Inject(
			method = "<init>",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;updateOptions(Lnet/minecraft/server/level/ClientInformation;)V")
	)
	private void replaceVanillaRecipeBookInstance(MinecraftServer server, ServerLevel world, GameProfile profile, ClientInformation clientOptions, CallbackInfo ci) {
		if (this.moddedRecipeBook) {
			this.recipeBook = this.jineric$getRecipeBook();
		}
	}
	
	@Unique private Optional<JmServerRecipeBook.Packed> packedCodec;
	@WrapOperation(
			method = "readAdditionalSaveData",
			slice = @Slice(
					from = @At(
							value = "INVOKE",
							target = "Lnet/minecraft/world/level/storage/ValueInput;getBooleanOr(Ljava/lang/String;Z)Z"
					)
			),
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/storage/ValueInput;read(Ljava/lang/String;Lcom/mojang/serialization/Codec;)Ljava/util/Optional;",
					ordinal = 0
			)
	)
	private Optional readModdedRecipeBook(ValueInput view, String key, Codec<Object> codec, Operation<Optional> original) {
		if (this.moddedRecipeBook) {
			this.packedCodec = view.read("recipeBook", JmServerRecipeBook.Packed.CODEC);
			return this.packedCodec;
		} else {
			return original.call(view, key, codec);
		}
	}
	
	@WrapWithCondition(
			method = "readAdditionalSaveData",
			at = @At(
					value = "INVOKE",
					target = "Ljava/util/Optional;ifPresent(Ljava/util/function/Consumer;)V"
			)
	)
	private boolean readJmRecipeBookInstead(Optional instance, Consumer<? super Codec<Object>> action, ValueInput view) {
		if (this.moddedRecipeBook) {
			this.packedCodec.ifPresent(
					packed -> this.jineric$getRecipeBook().unpack(
							packed, key -> this.server.getRecipeManager().byKey(key).isPresent()
					)
			);
			return false;
		} else {
			return true;
		}
	}
	
	@ModifyArgs(
			method = "addAdditionalSaveData",
			slice = @Slice(
					from = @At(
							value = "INVOKE",
							target = "Lnet/minecraft/server/level/ServerPlayer;saveParentVehicle(Lnet/minecraft/world/level/storage/ValueOutput;)V"
					)
			),
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/storage/ValueOutput;store(Ljava/lang/String;Lcom/mojang/serialization/Codec;Ljava/lang/Object;)V",
					ordinal = 0
			)
	)
	private void writeJmRecipeBookInstead(Args args) {
		if (this.moddedRecipeBook) {
			args.set(0, "recipeBook");
			args.set(1, JmServerRecipeBook.Packed.CODEC);
			args.set(2, this.jineric$getRecipeBook().jmPack());
		}
	}
	
	@WrapOperation(
			method = "restoreFrom",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/ServerRecipeBook;copyOverData(Lnet/minecraft/stats/ServerRecipeBook;)V"
			)
	)
	private void copyFromJmRecipeBook(ServerRecipeBook instance, ServerRecipeBook recipeBook, Operation<Void> original, ServerPlayer oldPlayer) {
		if (this.moddedRecipeBook) {
			this.jineric$getRecipeBook().copyFrom(((JmServerPlayer) oldPlayer).jineric$getRecipeBook());
		} else {
			original.call(instance, recipeBook);
		}
	}
	
	@ModifyReturnValue(
			method = "getRecipeBook",
			at = @At("RETURN")
	)
	private ServerRecipeBook returnJmRecipeBook(ServerRecipeBook original) {
		if (this.moddedRecipeBook) {
			return this.jineric$getRecipeBook();
		} else {
			return original;
		}
	}
}
