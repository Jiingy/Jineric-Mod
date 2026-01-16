package jingy.jineric.mixin.fix;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpreadingSnowyDirtBlock.class)
public abstract class BlocksForGrassSurvivingMixin {
	
	@Inject(
			method = "canBeGrass",
			at = @At(value = "HEAD"),
			cancellable = true
	)
	private static void canSurviveIfJmGrassBlock(BlockState state, LevelReader world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		BlockPos blockPos = pos.above();
		BlockState blockState = world.getBlockState(blockPos);
		if (blockState.is(JinericBlocks.GRASS_BLOCK)) {
			cir.setReturnValue(true);
		}
	}
}
