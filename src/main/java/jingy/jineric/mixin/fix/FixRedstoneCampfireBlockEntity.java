package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.block.RedstoneCampfireBlock;
import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CampfireBlockEntity.class)
public abstract class FixRedstoneCampfireBlockEntity extends BlockEntity {
	public FixRedstoneCampfireBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}
	
	@ModifyArg(
			method = "<init>",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/entity/BlockEntity;<init>(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V"
			),
			index = 0
	)
	private static BlockEntityType<?> setBlockEntityType(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		if (state.getBlock() instanceof RedstoneCampfireBlock) {
			return JinericBlockEntityType.REDSTONE_CAMPFIRE;
		} else {
			return BlockEntityTypes.CAMPFIRE;
		}
	}
	
	@Inject(
			method = "placeFood",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/server/level/ServerLevel;gameEvent(Lnet/minecraft/core/Holder;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/gameevent/GameEvent$Context;)V"
			)
	)
	private void setPoweredStateOnAddItem(ServerLevel world, LivingEntity entity, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		if (world.getBlockEntity(this.getBlockPos()) instanceof RedstoneCampfireBlockEntity redstoneCampfireBlockEntity) {
			world.setBlockAndUpdate(this.getBlockPos(), redstoneCampfireBlockEntity.getBlockState().setValue(BlockStateProperties.POWERED, true));
		}
	}
	
	@Inject(
			method = "cookTick",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/server/level/ServerLevel;gameEvent(Lnet/minecraft/core/Holder;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/gameevent/GameEvent$Context;)V"
			)
	)
	private static void unpowerIfEmpty(
			ServerLevel world, BlockPos pos, BlockState state, CampfireBlockEntity blockEntity, RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> recipeMatchGetter, CallbackInfo ci,
			@Local(index = 6)int index
	) {
		if (blockEntity instanceof RedstoneCampfireBlockEntity && index == 0) {
			world.setBlockAndUpdate(pos, state.setValue(BlockStateProperties.POWERED, false));
		}
	}
}
