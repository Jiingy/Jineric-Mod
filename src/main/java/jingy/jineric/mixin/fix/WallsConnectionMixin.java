package jingy.jineric.mixin.fix;

import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WallBlock.class)
public abstract class WallsConnectionMixin extends Block implements Waterloggable {
   public WallsConnectionMixin(Settings settings) {
      super(settings);
   }

   @Inject(
           method = "shouldConnectTo",
           at = @At("RETURN"), cancellable = true
   )
   private void jineric$shouldConnectTo(BlockState state, boolean faceFullSquare, Direction side, CallbackInfoReturnable<Boolean> cir) {
      cir.setReturnValue(cir.getReturnValueZ() || state.isIn(JinericBlockTags.NOT_PICKAXE_WALL));
   }
}
