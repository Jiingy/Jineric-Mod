package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.block.RedstoneCampfireBlock;
import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CampfireBlockEntity.class)
public abstract class FixRedstoneCampfireBlockEntity extends BlockEntity implements Clearable {
	public FixRedstoneCampfireBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}
	
	@ModifyArg(
			method = "<init>",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/block/entity/BlockEntity;<init>(Lnet/minecraft/block/entity/BlockEntityType;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"
			),
			index = 0
	)
	private static BlockEntityType<?> setBlockEntityType(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		if (state.getBlock() instanceof RedstoneCampfireBlock) {
			System.out.println("TRUTH NUKE");
			return JinericBlockEntityType.REDSTONE_CAMPFIRE;
		} else {
			return BlockEntityType.CAMPFIRE;
		}
	}
	
	@Inject(
			method = "addItem",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/server/world/ServerWorld;emitGameEvent(Lnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/event/GameEvent$Emitter;)V"
			)
	)
	private void setPoweredStateOnAddItem(ServerWorld world, LivingEntity entity, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		if (world.getBlockEntity(this.getPos()) instanceof RedstoneCampfireBlockEntity redstoneCampfireBlockEntity) {
			world.setBlockState(this.getPos(), redstoneCampfireBlockEntity.getCachedState().with(Properties.POWERED, true));
		}
	}
	
	@Inject(
			method = "litServerTick",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/server/world/ServerWorld;emitGameEvent(Lnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/event/GameEvent$Emitter;)V"
			)
	)
	private static void unpowerIfEmpty(
			ServerWorld world, BlockPos pos, BlockState state, CampfireBlockEntity blockEntity, ServerRecipeManager.MatchGetter<SingleStackRecipeInput, CampfireCookingRecipe> recipeMatchGetter, CallbackInfo ci,
			@Local(index = 6)int index
	) {
		if (blockEntity instanceof RedstoneCampfireBlockEntity && index == 0) {
			world.setBlockState(pos, state.with(Properties.POWERED, false));
		}
	}
}
