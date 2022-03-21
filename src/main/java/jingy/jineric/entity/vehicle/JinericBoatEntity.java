/*package jingy.jineric.entity.vehicle;

import jingy.jineric.registry.JinericBlocks;
import jingy.jineric.registry.JinericItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class JinericBoatEntity extends BoatEntity {
   public JinericBoatEntity(EntityType<? extends BoatEntity> entityType, World world) {
      super(entityType, world);
   }
      public static enum Type {
      BOREAL(JinericBlocks.BOREAL_PLANKS, "boreal");

      private final String name;
      private final Block baseBlock;

      private Type(Block baseBlock, String name) {
         this.name = name;
         this.baseBlock = baseBlock;
      }

      public String getName() {
         return this.name;
      }

      public Block getBaseBlock() {
         return this.baseBlock;
      }

      public String toString() {
         return this.name;
      }

      public static JinericBoatEntity.Type getType(int type) {
         JinericBoatEntity.Type[] types = values();
         if (type < 0 || type >= types.length) {
            type = 0;
         }

         return types[type];
      }

      public static JinericBoatEntity.Type getType(String name) {
         JinericBoatEntity.Type[] types = values();

         for(int i = 0; i < types.length; ++i) {
            if (types[i].getName().equals(name)) {
               return types[i];
            }
         }

         return types[0];
      }
   }

   @Override
   public Item asItem() {
      return JinericItems.BOREAL_BOAT;
   }
}
*/