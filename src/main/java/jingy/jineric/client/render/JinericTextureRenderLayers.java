package jingy.jineric.client.render;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.entity.ShulkerChestBlockEntity;
import jingy.jineric.block.entity.chests.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class JinericTextureRenderLayers extends TexturedRenderLayers {

   public static final SpriteIdentifier ACACIA_CHEST = getChestTextureId("acacia_chest");
   public static final SpriteIdentifier ACACIA_CHEST_LEFT = getChestTextureId("acacia_left");
   public static final SpriteIdentifier ACACIA_CHEST_RIGHT = getChestTextureId("acacia_right");
   public static final SpriteIdentifier BOREAL_CHEST = getChestTextureId("boreal_chest");
   public static final SpriteIdentifier BOREAL_CHEST_LEFT = getChestTextureId("boreal_left");
   public static final SpriteIdentifier BOREAL_CHEST_RIGHT = getChestTextureId("boreal_right");
   public static final SpriteIdentifier BIRCH_CHEST = getChestTextureId("birch_chest");
   public static final SpriteIdentifier BIRCH_CHEST_LEFT = getChestTextureId("birch_left");
   public static final SpriteIdentifier BIRCH_CHEST_RIGHT = getChestTextureId("birch_right");
   public static final SpriteIdentifier CRIMSON_CHEST = getChestTextureId("crimson_chest");
   public static final SpriteIdentifier CRIMSON_CHEST_LEFT = getChestTextureId("crimson_left");
   public static final SpriteIdentifier CRIMSON_CHEST_RIGHT = getChestTextureId("crimson_right");
   public static final SpriteIdentifier DARK_OAK_CHEST = getChestTextureId("dark_oak_chest");
   public static final SpriteIdentifier DARK_OAK_CHEST_LEFT = getChestTextureId("dark_oak_left");
   public static final SpriteIdentifier DARK_OAK_CHEST_RIGHT = getChestTextureId("dark_oak_right");
   public static final SpriteIdentifier JUNGLE_CHEST = getChestTextureId("jungle_chest");
   public static final SpriteIdentifier JUNGLE_CHEST_LEFT = getChestTextureId("jungle_left");
   public static final SpriteIdentifier JUNGLE_CHEST_RIGHT = getChestTextureId("jungle_right");
   public static final SpriteIdentifier SHULKER = getChestTextureId("shulker_chest");
   public static final SpriteIdentifier SPRUCE_CHEST = getChestTextureId("spruce_chest");
   public static final SpriteIdentifier SPRUCE_CHEST_LEFT = getChestTextureId("spruce_left");
   public static final SpriteIdentifier SPRUCE_CHEST_RIGHT = getChestTextureId("spruce_right");
   public static final SpriteIdentifier WARPED_CHEST = getChestTextureId("warped_chest");
   public static final SpriteIdentifier WARPED_CHEST_LEFT = getChestTextureId("warped_left");
   public static final SpriteIdentifier WARPED_CHEST_RIGHT = getChestTextureId("warped_right");
   public static final SpriteIdentifier MANGROVE_CHEST = getChestTextureId("mangrove_chest");
   public static final SpriteIdentifier MANGROVE_CHEST_LEFT = getChestTextureId("mangrove_left");
   public static final SpriteIdentifier MANGROVE_CHEST_RIGHT = getChestTextureId("mangrove_right");

   private static SpriteIdentifier getChestTextureId(String variant) {
      return new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(JinericMain.MOD_ID, "entity/chest/" + variant));
   }

   public static SpriteIdentifier getChestTexture(BlockEntity blockEntity, ChestType chestType, boolean christmas) {
      if (blockEntity instanceof ShulkerChestBlockEntity) {
         return SHULKER;
      } else if (christmas) {
         return getChestTexture(chestType, CHRISTMAS, CHRISTMAS_LEFT, CHRISTMAS_RIGHT);

      } else if (blockEntity instanceof AcaciaChestBlockEntity) {
         return getChestTexture(chestType, ACACIA_CHEST, ACACIA_CHEST_LEFT, ACACIA_CHEST_RIGHT);

      } else if (blockEntity instanceof BirchChestBlockEntity) {
         return getChestTexture(chestType, BIRCH_CHEST, BIRCH_CHEST_LEFT, BIRCH_CHEST_RIGHT);

      } else if (blockEntity instanceof BorealChestBlockEntity) {
         return getChestTexture(chestType, BOREAL_CHEST, BOREAL_CHEST_LEFT, BOREAL_CHEST_RIGHT);

      } else if (blockEntity instanceof CrimsonChestBlockEntity) {
         return getChestTexture(chestType, CRIMSON_CHEST, CRIMSON_CHEST_LEFT, CRIMSON_CHEST_RIGHT);

      } else if (blockEntity instanceof DarkOakChestBlockEntity) {
         return getChestTexture(chestType, DARK_OAK_CHEST, DARK_OAK_CHEST_LEFT, DARK_OAK_CHEST_RIGHT);

      } else if (blockEntity instanceof JungleChestBlockEntity) {
         return getChestTexture(chestType, JUNGLE_CHEST, JUNGLE_CHEST_LEFT, JUNGLE_CHEST_RIGHT);

      } else if (blockEntity instanceof SpruceChestBlockEntity) {
         return getChestTexture(chestType, SPRUCE_CHEST, SPRUCE_CHEST_LEFT, SPRUCE_CHEST_RIGHT);

      } else if (blockEntity instanceof WarpedChestBlockEntity) {
         return getChestTexture(chestType, WARPED_CHEST, WARPED_CHEST_LEFT, WARPED_CHEST_RIGHT);

      } else if (blockEntity instanceof MangroveChestBlockEntity) {
         return getChestTexture(chestType, MANGROVE_CHEST, MANGROVE_CHEST_LEFT, MANGROVE_CHEST_RIGHT);

      } else {
         return getChestTexture(chestType, NORMAL, NORMAL_LEFT, NORMAL_RIGHT);
      }
   }

   public static SpriteIdentifier getChestTexture(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right) {
      switch(type) {
         case LEFT:
            return left;
         case RIGHT:
            return right;
         case SINGLE:
         default:
            return single;
      }
   }
}
