package jingy.jineric.mixin;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(BoatEntity.Type.class)
public abstract class BoatEntityTypeMixin {
   @Shadow public abstract String getName();

   @Inject(method = "getBaseBlock", at = @At(value = "HEAD"), cancellable = true)
   private void replaceBaseBlocks(CallbackInfoReturnable<Block> cir) {
      if (Objects.equals(getName(), "petrified_oak")) {
         cir.setReturnValue(JinericBlocks.PETRIFIED_OAK_PLANKS);
      }
   }
}
