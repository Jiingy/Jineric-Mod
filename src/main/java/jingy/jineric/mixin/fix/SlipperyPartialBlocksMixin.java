package jingy.jineric.mixin.fix;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(LivingEntity.class)
public abstract class SlipperyPartialBlocksMixin extends Entity {
	public SlipperyPartialBlocksMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@ModifyArg(
			method = "travelMidAir",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/World;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;"
			)
	)
	private BlockPos modifyPositionToFixSlipperyPartialBlocks(BlockPos originalBlockPos) {
		BlockState blockState = this.getSteppingBlockState();
		if (JinericBlocks.isSlipperyBlock(blockState)) {
			return this.getSteppingPos();
		} else {
			return originalBlockPos;
		}
	}
}
