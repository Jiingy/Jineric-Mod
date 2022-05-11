package jingy.jineric.block.enums;

import jingy.jineric.base.JinericMain;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public enum JinericChestType {

   ACACIA(27, 9,
           new Identifier(JinericMain.MOD_ID, "entity/chest/acacia_chest"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/acacia_left"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/acacia_right")),

   BIRCH(27, 9,
           new Identifier(JinericMain.MOD_ID, "entity/chest/birch_chest"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/birch_left"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/birch_right")),

   BOREAL(27, 9,
           new Identifier(JinericMain.MOD_ID, "entity/chest/boreal_chest"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/boreal_left"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/boreal_right")),

   CRIMSON(27, 9,
           new Identifier(JinericMain.MOD_ID, "entity/chest/crimson_chest"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/crimson_left"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/crimson_right")),

   DARK_OAK(27, 9,
           new Identifier(JinericMain.MOD_ID, "entity/chest/dark_oak_chest"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/dark_oak_left"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/dark_oak_right")),

   JUNGLE(27, 9,
           new Identifier(JinericMain.MOD_ID, "entity/chest/jungle_chest"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/jungle_left"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/jungle_right")),

   SPRUCE(27, 9,
           new Identifier(JinericMain.MOD_ID, "entity/chest/spruce_chest"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/spruce_left"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/spruce_right")),

   WARPED(27, 9,
           new Identifier(JinericMain.MOD_ID, "entity/chest/warped_chest"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/warped_left"),
           new Identifier(JinericMain.MOD_ID, "entity/chest/warped_right")),

   SHULKER(81, 9, new Identifier(JinericMain.MOD_ID, "entity/chest/shulker_chest"));

   public final int size;
   public final int rowLength;
   public final Identifier texture;
   public final Identifier textureRight;
   public final Identifier textureLeft;

   JinericChestType(int size, int rowLength, Identifier texture, Identifier textureRight, Identifier textureLeft) {
      this.size = size;
      this.rowLength = rowLength;
      this.texture = texture;
      this.textureRight = textureRight;
      this.textureLeft = textureLeft;
   }

   JinericChestType(int size, int rowLength, Identifier texture) {
      this.size = size;
      this.rowLength = rowLength;
      this.texture = texture;
      this.textureLeft = null;
      this.textureRight = null;
   }

   public int getRowCount() {
      return this.size / this.rowLength;
   }

   public ChestBlockEntity getEntity(BlockPos pos, BlockState state) {
      return switch (this) {
         case ACACIA -> JinericBlockEntityType.ACACIA_CHEST.instantiate(pos, state);
         case BIRCH -> JinericBlockEntityType.BIRCH_CHEST.instantiate(pos, state);
         case BOREAL -> JinericBlockEntityType.BOREAL_CHEST.instantiate(pos, state);
         case CRIMSON -> JinericBlockEntityType.CRIMSON_CHEST.instantiate(pos, state);
         case DARK_OAK -> JinericBlockEntityType.DARK_OAK_CHEST.instantiate(pos, state);
         case JUNGLE -> JinericBlockEntityType.JUNGLE_CHEST.instantiate(pos, state);
         case SPRUCE -> JinericBlockEntityType.SPRUCE_CHEST.instantiate(pos, state);
         case WARPED -> JinericBlockEntityType.WARPED_CHEST.instantiate(pos, state);
         case SHULKER -> JinericBlockEntityType.SHULKER_CHEST.instantiate(pos, state);
         default -> new ChestBlockEntity(pos, state);
      };
   }

   public BlockEntityType<? extends ChestBlockEntity> getBlockEntityType() {
      return switch (this) {
         case ACACIA -> JinericBlockEntityType.ACACIA_CHEST;
         case BIRCH -> JinericBlockEntityType.BIRCH_CHEST;
         case BOREAL -> JinericBlockEntityType.BOREAL_CHEST;
         case CRIMSON -> JinericBlockEntityType.CRIMSON_CHEST;
         case DARK_OAK -> JinericBlockEntityType.DARK_OAK_CHEST;
         case JUNGLE -> JinericBlockEntityType.JUNGLE_CHEST;
         case SPRUCE -> JinericBlockEntityType.SPRUCE_CHEST;
         case WARPED -> JinericBlockEntityType.WARPED_CHEST;
         case SHULKER -> JinericBlockEntityType.SHULKER_CHEST;
         default -> BlockEntityType.CHEST;
      };
   }
}
