package jingy.jineric.block.custom.chest;

import jingy.jineric.base.JinericMain;
import net.minecraft.util.Identifier;

public enum JinericChestTypes {

   SHULKER(new Identifier(JinericMain.MOD_ID, "entity/chest/shulker_chest")),
   BOREAL(new Identifier(JinericMain.MOD_ID, "entity/chest/shulker_chest"));

   public final Identifier texture;

   JinericChestTypes(Identifier texture) {
      this.texture = texture;
   }

   /*
   public static Block get(JinericChestTypes type) {
      return switch (type) {
         case SHULKER -> JinericBlocks.SHULKER_CHEST;
         case BOREAL -> null;
         default -> Blocks.CHEST;
      };
   }

   public ChestBlockEntity getEntity(BlockPos pos, BlockState state) {
      return switch (this) {
         case SHULKER -> JinericBlockEntityType.SHULKER_CHEST.instantiate(pos, state);
         case BOREAL -> JinericBlockEntityType.BOREAL_CHEST.instantiate(pos, state);
         default -> new ChestBlockEntity(pos, state);
      };
   }

   public BlockEntityType<? extends ChestBlockEntity> getBlockEntityType() {
      return switch (this) {
         case SHULKER -> JinericBlockEntityType.SHULKER_CHEST;
         case BOREAL ->
         default -> BlockEntityType.CHEST;
      };
   }*/
}

