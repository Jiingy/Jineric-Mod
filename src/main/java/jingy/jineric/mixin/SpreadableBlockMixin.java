package jingy.jineric.mixin;

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
public abstract class SpreadableBlockMixin {

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

   @Inject(
           method = "canSpread",
           at = @At(value = "RETURN", target = "net/minecraft/block/SpreadableBlock.canSurvive(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z"),
           cancellable = true
   )
   private static void jineric$cannotSpreadIfFullGrassBlock(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
      BlockPos posAbove = pos.up();
      if (world.getBlockState(posAbove).isOf(JinericBlocks.FULL_GRASS_BLOCK)) {
         cir.setReturnValue(false);
      }
   }
}
