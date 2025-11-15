package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.authlib.GameProfile;
import com.mojang.serialization.Codec;
import jingy.jineric.access.ServerPlayerEntityAccess;
import jingy.jineric.config.JmConfig;
import jingy.jineric.server.network.JmServerRecipeBook;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.common.SyncedClientOptions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerRecipeBook;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.Optional;
import java.util.function.Consumer;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity implements ServerPlayerEntityAccess {
	public ServerPlayerEntityMixin(World world, GameProfile profile) {
		super(world, profile);
	}
	@Shadow @Final private MinecraftServer server;
	@Mutable @Shadow @Final private ServerRecipeBook recipeBook;
	@Unique private final boolean moddedRecipeBook = JmConfig.REPLACE_VANILLA_RECIPE_BOOK;
	
	@Inject(
			method = "<init>",
			at = @At("CTOR_HEAD")
	)
	private void setJmRecipeBookInstance(MinecraftServer server, ServerWorld world, GameProfile profile, SyncedClientOptions clientOptions, CallbackInfo ci) {
		if (this.moddedRecipeBook) {
			this.jineric$setRecipeBook(new JmServerRecipeBook((recipeKey, adder) -> server.getRecipeManager().forEachRecipeDisplay(recipeKey, adder)));
		}
	}
	
	@Inject(
			method = "<init>",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;setClientOptions(Lnet/minecraft/network/packet/c2s/common/SyncedClientOptions;)V")
	)
	private void replaceVanillaRecipeBookInstance(MinecraftServer server, ServerWorld world, GameProfile profile, SyncedClientOptions clientOptions, CallbackInfo ci) {
		if (this.moddedRecipeBook) {
			this.recipeBook = this.jineric$getRecipeBook();
		}
	}
	
	@Unique private Optional<JmServerRecipeBook.Packed> packedCodec;
	@WrapOperation(
			method = "readCustomData",
			slice = @Slice(
					from = @At(
							value = "INVOKE",
							target = "Lnet/minecraft/storage/ReadView;getBoolean(Ljava/lang/String;Z)Z"
					)
			),
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/storage/ReadView;read(Ljava/lang/String;Lcom/mojang/serialization/Codec;)Ljava/util/Optional;",
					ordinal = 0
			)
	)
	private Optional readModdedRecipeBook(ReadView view, String key, Codec<Object> codec, Operation<Optional> original) {
		if (this.moddedRecipeBook) {
			this.packedCodec = view.read("recipeBook", JmServerRecipeBook.Packed.CODEC);
			return this.packedCodec;
		} else {
			return original.call(view, key, codec);
		}
	}
	
	@WrapWithCondition(
			method = "readCustomData",
			at = @At(
					value = "INVOKE",
					target = "Ljava/util/Optional;ifPresent(Ljava/util/function/Consumer;)V"
			)
	)
	private boolean hbkujb(Optional instance, Consumer<? super Codec<Object>> action, ReadView view) {
		if (this.moddedRecipeBook) {
			this.packedCodec.ifPresent(
					packed -> this.jineric$getRecipeBook().unpack(
							packed, key -> this.server.getRecipeManager().get(key).isPresent()
					)
			);
			return false;
		} else {
			return true;
		}
	}
	
	@ModifyArgs(
			method = "writeCustomData",
			slice = @Slice(
					from = @At(
							value = "INVOKE",
							target = "Lnet/minecraft/server/network/ServerPlayerEntity;writeRootVehicle(Lnet/minecraft/storage/WriteView;)V"
					)
			),
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/storage/WriteView;put(Ljava/lang/String;Lcom/mojang/serialization/Codec;Ljava/lang/Object;)V",
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
			method = "copyFrom",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/server/network/ServerRecipeBook;copyFrom(Lnet/minecraft/server/network/ServerRecipeBook;)V"
			)
	)
	private void copyFromJmRecipeBook(ServerRecipeBook instance, ServerRecipeBook recipeBook, Operation<Void> original, ServerPlayerEntity oldPlayer) {
		if (this.moddedRecipeBook) {
			this.jineric$getRecipeBook().copyFrom(((ServerPlayerEntityAccess) oldPlayer).jineric$getRecipeBook());
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
