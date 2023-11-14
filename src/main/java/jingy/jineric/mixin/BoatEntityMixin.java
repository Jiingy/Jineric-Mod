package jingy.jineric.mixin;

import jingy.jineric.item.JinericItems;
import jingy.jineric.registry.JinericBoatTypes;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatEntity.class)
public abstract class BoatEntityMixin {
   @Shadow public abstract BoatEntity.Type getVariant();

   @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
   private void dropJinericBoats(CallbackInfoReturnable<Item> cir) {
      if (this.getVariant() == JinericBoatTypes.PETRIFIED_OAK) {
         cir.setReturnValue(JinericItems.PETRIFIED_OAK_BOAT);
      }
   }
}
