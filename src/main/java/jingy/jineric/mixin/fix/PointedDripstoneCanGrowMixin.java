package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.block.JinericBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SpeleothemBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SpeleothemBlock.class)
public abstract class PointedDripstoneCanGrowMixin {

	@ModifyReturnValue(
			method = "canGrow",
			at = @At("RETURN")
	)
	private boolean canGrowFromPartialBlocks(
            boolean original,
            final LevelReader level, final BlockPos pos
    ) {
		BlockState stateAbove = level.getBlockState(pos.above());
		if (level.getBlockState(pos).getBlock() instanceof PointedDripstoneBlock) {
			if (stateAbove.is(JinericBlocks.DRIPSTONE_SLAB) && stateAbove.getValue(SlabBlock.TYPE).equals(SlabType.BOTTOM)) {
				return true;
			} else if (stateAbove.is(JinericBlocks.DRIPSTONE_STAIRS)) {
				return true;
			}  else {
				return original;
			}
		} else {
			return original;
		}
	}
}