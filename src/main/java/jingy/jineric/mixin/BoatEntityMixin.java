package jingy.jineric.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.item.JinericItems;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatEntity.class)
public abstract class BoatEntityMixin {
   @Shadow public abstract BoatEntity.Type getVariant();

   @Unique private static final BoatEntity.Type PETRIFIED_OAK = ClassTinkerers.getEnum(BoatEntity.Type.class, "PETRIFIED_OAK");

   @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
   private void dropJinericBoats(CallbackInfoReturnable<Item> cir) {
      if (this.getVariant() == PETRIFIED_OAK) {
         cir.setReturnValue(JinericItems.PETRIFIED_OAK_BOAT);
      }
   }
}
