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
public abstract class BlocksForGrassSpreadingMixin {
	
	@Inject(
			method = "canPropagate",
			at = @At(value = "RETURN", target = "net/minecraft/block/SpreadableBlock.canSurvive(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z"),
			cancellable = true
	)
	private static void jineric$cannotSpreadIfJmGrassBlock(BlockState state, LevelReader world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		BlockPos posAbove = pos.above();
		if (world.getBlockState(posAbove).is(JinericBlocks.GRASS_BLOCK)) {
			cir.setReturnValue(false);
		}
	}
}
