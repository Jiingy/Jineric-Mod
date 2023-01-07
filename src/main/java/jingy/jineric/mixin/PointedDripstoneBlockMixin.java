package jingy.jineric.mixin;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.state.property.BooleanProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PointedDripstoneBlock.class)
public abstract class PointedDripstoneBlockMixin extends Block implements LandingBlock, Waterloggable {
   @Shadow @Final public static BooleanProperty WATERLOGGED;

   public PointedDripstoneBlockMixin(Settings settings) {
      super(settings);
   }

   @Inject(method = "canGrow(Lnet/minecraft/block/BlockState;Lnet/minecraft/block/BlockState;)Z", at = @At("HEAD"), cancellable = true)
   private static void jineric$canGrow(BlockState dripstoneBlockState, BlockState waterState, CallbackInfoReturnable<Boolean> cir) {
      //Checks if block is == to DRIPSTONE_SLAB which is water logged and type.BOTTOM
      if (dripstoneBlockState.isOf(JinericBlocks.DRIPSTONE_SLAB)
              && (dripstoneBlockState.get(WATERLOGGED)
              && (dripstoneBlockState.get(SlabBlock.TYPE) == SlabType.BOTTOM))) {
         cir.setReturnValue(true);
      }
      //Checks if block is == to DRIPSTONE_STAIRS
      if (dripstoneBlockState.isOf((JinericBlocks.DRIPSTONE_STAIRS))) {
         cir.setReturnValue(true);

      }
   }
}