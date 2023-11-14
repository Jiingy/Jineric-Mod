package jingy.jineric.mixin;

import jingy.jineric.item.JinericItems;
import jingy.jineric.registry.JinericBoatTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.RideableInventory;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.entity.vehicle.VehicleInventory;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBoatEntity.class)
public abstract class ChestBoatEntityMixin extends BoatEntity implements RideableInventory, VehicleInventory {

   public ChestBoatEntityMixin(EntityType<?extends BoatEntity> entityType, World world) {
      super(entityType, world);
   }

   @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
   private void dropJinericBoats(CallbackInfoReturnable<Item> cir) {
      if (this.getVariant() == JinericBoatTypes.PETRIFIED_OAK) {
         cir.setReturnValue(JinericItems.PETRIFIED_OAK_CHEST_BOAT);
      }
   }
}
