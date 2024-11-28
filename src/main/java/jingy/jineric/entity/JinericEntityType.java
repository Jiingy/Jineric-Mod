package jingy.jineric.entity;

import jingy.jineric.base.JinericMain;
import jingy.jineric.item.JinericItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public class JinericEntityType {
   public static final EntityType<BoatEntity> PETRIFIED_OAK_BOAT = register(
           "petrified_oak_boat",
           EntityType.Builder.create(getBoatFactory(() -> JinericItems.PETRIFIED_OAK_BOAT), SpawnGroup.MISC)
                   .dropsNothing()
                   .dimensions(1.375F, 0.5625F)
                   .eyeHeight(0.5625F)
                   .maxTrackingRange(10)
   );
   public static final EntityType<ChestBoatEntity> PETRIFIED_OAK_CHEST_BOAT = register(
           "petrified_oak_chest_boat",
           EntityType.Builder.create(getChestBoatFactory(() -> JinericItems.PETRIFIED_OAK_CHEST_BOAT), SpawnGroup.MISC)
                   .dropsNothing()
                   .dimensions(1.375F, 0.5625F)
                   .eyeHeight(0.5625F)
                   .maxTrackingRange(10)
   );

   private static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, EntityType.Builder<T> type) {
      return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
   }

   private static RegistryKey<EntityType<?>> keyOf(String id) {
      return RegistryKey.of(RegistryKeys.ENTITY_TYPE, JinericMain.ofJineric(id));
   }

   private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
      return register(keyOf(id), type);
   }

   private static EntityType.EntityFactory<BoatEntity> getBoatFactory(Supplier<Item> itemSupplier) {
      return (type, world) -> new BoatEntity(type, world, itemSupplier);
   }

   private static EntityType.EntityFactory<ChestBoatEntity> getChestBoatFactory(Supplier<Item> itemSupplier) {
      return (type, world) -> new ChestBoatEntity(type, world, itemSupplier);
   }
}
