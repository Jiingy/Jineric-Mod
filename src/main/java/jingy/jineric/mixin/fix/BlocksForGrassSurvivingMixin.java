package jingy.jineric.mixin.fix;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpreadableBlock.class)
public abstract class BlocksForGrassSurvivingMixin {
	
	@Inject(
			method = "canSurvive",
			at = @At(value = "HEAD"),
			cancellable = true
	)
	private static void jineric$canSurviveIfFullGrassBlock(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		BlockPos blockPos = pos.up();
		BlockState blockState = world.getBlockState(blockPos);
		if (blockState.isOf(JinericBlocks.FULL_GRASS_BLOCK)) {
			cir.setReturnValue(true);
		}
	}
}
