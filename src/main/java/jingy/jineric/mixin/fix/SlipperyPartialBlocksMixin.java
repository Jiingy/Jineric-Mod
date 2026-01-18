package jingy.jineric.mixin.fix;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(LivingEntity.class)
public abstract class SlipperyPartialBlocksMixin extends Entity {
	public SlipperyPartialBlocksMixin(EntityType<?> type, Level world) {
		super(type, world);
	}

	@ModifyArg(
			method = "travelInAir",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;"
			)
	)
	private BlockPos modifyPositionToFixSlipperyPartialBlocks(BlockPos originalBlockPos) {
		BlockState blockState = this.getBlockStateOn();
		if (JinericBlocks.isSlipperyBlock(blockState)) {
			return this.getOnPos();
		} else {
			return originalBlockPos;
		}
	}
}
