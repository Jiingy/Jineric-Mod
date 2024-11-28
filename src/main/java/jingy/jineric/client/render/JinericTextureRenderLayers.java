package jingy.jineric.client.render;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.entity.JinericTrappedChestBlockEntity;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

public class JinericTextureRenderLayers extends TexturedRenderLayers {
   public static final SpriteIdentifier ACACIA_CHEST = createChestTextureId("acacia_chest");
   public static final SpriteIdentifier ACACIA_CHEST_LEFT = createChestTextureId("acacia_left");
   public static final SpriteIdentifier ACACIA_CHEST_RIGHT = createChestTextureId("acacia_right");
   public static final SpriteIdentifier TRAPPED_ACACIA_CHEST = createChestTextureId("trapped_acacia_chest");
   public static final SpriteIdentifier TRAPPED_ACACIA_CHEST_LEFT = createChestTextureId("trapped_acacia_left");
   public static final SpriteIdentifier TRAPPED_ACACIA_CHEST_RIGHT = createChestTextureId("trapped_acacia_right");
   public static final SpriteIdentifier BIRCH_CHEST = createChestTextureId("birch_chest");
   public static final SpriteIdentifier BIRCH_CHEST_LEFT = createChestTextureId("birch_left");
   public static final SpriteIdentifier BIRCH_CHEST_RIGHT = createChestTextureId("birch_right");
   public static final SpriteIdentifier CRIMSON_CHEST = createChestTextureId("crimson_chest");
   public static final SpriteIdentifier CRIMSON_CHEST_LEFT = createChestTextureId("crimson_left");
   public static final SpriteIdentifier CRIMSON_CHEST_RIGHT = createChestTextureId("crimson_right");
   public static final SpriteIdentifier DARK_OAK_CHEST = createChestTextureId("dark_oak_chest");
   public static final SpriteIdentifier DARK_OAK_CHEST_LEFT = createChestTextureId("dark_oak_left");
   public static final SpriteIdentifier DARK_OAK_CHEST_RIGHT = createChestTextureId("dark_oak_right");
   public static final SpriteIdentifier JUNGLE_CHEST = createChestTextureId("jungle_chest");
   public static final SpriteIdentifier JUNGLE_CHEST_LEFT = createChestTextureId("jungle_left");
   public static final SpriteIdentifier JUNGLE_CHEST_RIGHT = createChestTextureId("jungle_right");
   public static final SpriteIdentifier SPRUCE_CHEST = createChestTextureId("spruce_chest");
   public static final SpriteIdentifier SPRUCE_CHEST_LEFT = createChestTextureId("spruce_left");
   public static final SpriteIdentifier SPRUCE_CHEST_RIGHT = createChestTextureId("spruce_right");
   public static final SpriteIdentifier WARPED_CHEST = createChestTextureId("warped_chest");
   public static final SpriteIdentifier WARPED_CHEST_LEFT = createChestTextureId("warped_left");
   public static final SpriteIdentifier WARPED_CHEST_RIGHT = createChestTextureId("warped_right");
   public static final SpriteIdentifier MANGROVE_CHEST = createChestTextureId("mangrove_chest");
   public static final SpriteIdentifier MANGROVE_CHEST_LEFT = createChestTextureId("mangrove_left");
   public static final SpriteIdentifier MANGROVE_CHEST_RIGHT = createChestTextureId("mangrove_right");
   public static final SpriteIdentifier CHERRY_CHEST = createChestTextureId("cherry_chest");
   public static final SpriteIdentifier CHERRY_CHEST_LEFT = createChestTextureId("cherry_left");
   public static final SpriteIdentifier CHERRY_CHEST_RIGHT = createChestTextureId("cherry_right");
   public static final SpriteIdentifier BAMBOO_CHEST = createChestTextureId("bamboo_chest");
   public static final SpriteIdentifier BAMBOO_CHEST_LEFT = createChestTextureId("bamboo_left");
   public static final SpriteIdentifier BAMBOO_CHEST_RIGHT = createChestTextureId("bamboo_right");
   public static final SpriteIdentifier TRAPPED_BIRCH_CHEST = createChestTextureId("trapped_birch_chest");
   public static final SpriteIdentifier TRAPPED_BIRCH_CHEST_LEFT = createChestTextureId("trapped_birch_left");
   public static final SpriteIdentifier TRAPPED_BIRCH_CHEST_RIGHT = createChestTextureId("trapped_birch_right");
   public static final SpriteIdentifier TRAPPED_CRIMSON_CHEST = createChestTextureId("trapped_crimson_chest");
   public static final SpriteIdentifier TRAPPED_CRIMSON_CHEST_LEFT = createChestTextureId("trapped_crimson_left");
   public static final SpriteIdentifier TRAPPED_CRIMSON_CHEST_RIGHT = createChestTextureId("trapped_crimson_right");
   public static final SpriteIdentifier TRAPPED_DARK_OAK_CHEST = createChestTextureId("trapped_dark_oak_chest");
   public static final SpriteIdentifier TRAPPED_DARK_OAK_CHEST_LEFT = createChestTextureId("trapped_dark_oak_left");
   public static final SpriteIdentifier TRAPPED_DARK_OAK_CHEST_RIGHT = createChestTextureId("trapped_dark_oak_right");
   public static final SpriteIdentifier TRAPPED_JUNGLE_CHEST = createChestTextureId("trapped_jungle_chest");
   public static final SpriteIdentifier TRAPPED_JUNGLE_CHEST_LEFT = createChestTextureId("trapped_jungle_left");
   public static final SpriteIdentifier TRAPPED_JUNGLE_CHEST_RIGHT = createChestTextureId("trapped_jungle_right");
   public static final SpriteIdentifier TRAPPED_SPRUCE_CHEST = createChestTextureId("trapped_spruce_chest");
   public static final SpriteIdentifier TRAPPED_SPRUCE_CHEST_LEFT = createChestTextureId("trapped_spruce_left");
   public static final SpriteIdentifier TRAPPED_SPRUCE_CHEST_RIGHT = createChestTextureId("trapped_spruce_right");
   public static final SpriteIdentifier TRAPPED_WARPED_CHEST = createChestTextureId("trapped_warped_chest");
   public static final SpriteIdentifier TRAPPED_WARPED_CHEST_LEFT = createChestTextureId("trapped_warped_left");
   public static final SpriteIdentifier TRAPPED_WARPED_CHEST_RIGHT = createChestTextureId("trapped_warped_right");
   public static final SpriteIdentifier TRAPPED_MANGROVE_CHEST = createChestTextureId("trapped_mangrove_chest");
   public static final SpriteIdentifier TRAPPED_MANGROVE_CHEST_LEFT = createChestTextureId("trapped_mangrove_left");
   public static final SpriteIdentifier TRAPPED_MANGROVE_CHEST_RIGHT = createChestTextureId("trapped_mangrove_right");
   public static final SpriteIdentifier TRAPPED_CHERRY_CHEST = createChestTextureId("trapped_cherry_chest");
   public static final SpriteIdentifier TRAPPED_CHERRY_CHEST_LEFT = createChestTextureId("trapped_cherry_left");
   public static final SpriteIdentifier TRAPPED_CHERRY_CHEST_RIGHT = createChestTextureId("trapped_cherry_right");
   public static final SpriteIdentifier TRAPPED_BAMBOO_CHEST = createChestTextureId("trapped_bamboo_chest");
   public static final SpriteIdentifier TRAPPED_BAMBOO_CHEST_LEFT = createChestTextureId("trapped_bamboo_left");
   public static final SpriteIdentifier TRAPPED_BAMBOO_CHEST_RIGHT = createChestTextureId("trapped_bamboo_right");

   private static SpriteIdentifier createChestTextureId(String variant) {
      return new SpriteIdentifier(CHEST_ATLAS_TEXTURE, JinericMain.ofJineric("entity/chest/" + variant));
   }

   public static SpriteIdentifier getChestTexture(BlockEntity blockEntity, ChestType chestType, boolean christmas, WoodType woodType) {
      if (christmas) {
         return getChestTexture(chestType, CHRISTMAS, CHRISTMAS_LEFT, CHRISTMAS_RIGHT);
      }
      else if (blockEntity instanceof JinericTrappedChestBlockEntity) {
         if (woodType == WoodType.SPRUCE) {
            return getChestTexture(chestType, TRAPPED_SPRUCE_CHEST, TRAPPED_SPRUCE_CHEST_LEFT, TRAPPED_SPRUCE_CHEST_RIGHT);
         }
         else if (woodType == WoodType.BIRCH) {
            return getChestTexture(chestType, TRAPPED_BIRCH_CHEST, TRAPPED_BIRCH_CHEST_LEFT, TRAPPED_BIRCH_CHEST_RIGHT);
         }
         else if (woodType == WoodType.ACACIA) {
            return getChestTexture(chestType, TRAPPED_ACACIA_CHEST, TRAPPED_ACACIA_CHEST_LEFT, TRAPPED_ACACIA_CHEST_RIGHT);
         }
         else if (woodType == WoodType.JUNGLE) {
            return getChestTexture(chestType, TRAPPED_JUNGLE_CHEST, TRAPPED_JUNGLE_CHEST_LEFT, TRAPPED_JUNGLE_CHEST_RIGHT);
         }
         else if (woodType == WoodType.DARK_OAK) {
            return getChestTexture(chestType, TRAPPED_DARK_OAK_CHEST, TRAPPED_DARK_OAK_CHEST_LEFT, TRAPPED_DARK_OAK_CHEST_RIGHT);
         }
         else if (woodType == WoodType.MANGROVE) {
            return getChestTexture(chestType, TRAPPED_MANGROVE_CHEST, TRAPPED_MANGROVE_CHEST_LEFT, TRAPPED_MANGROVE_CHEST_RIGHT);
         }
         else if (woodType == WoodType.CHERRY) {
            return getChestTexture(chestType, TRAPPED_CHERRY_CHEST, TRAPPED_CHERRY_CHEST_LEFT, TRAPPED_CHERRY_CHEST_RIGHT);
         }
         else if (woodType == WoodType.BAMBOO) {
            return getChestTexture(chestType, TRAPPED_BAMBOO_CHEST, TRAPPED_BAMBOO_CHEST_LEFT, TRAPPED_BAMBOO_CHEST_RIGHT);
         }
         else if (woodType == WoodType.CRIMSON) {
            return getChestTexture(chestType, TRAPPED_CRIMSON_CHEST, TRAPPED_CRIMSON_CHEST_LEFT, TRAPPED_CRIMSON_CHEST_RIGHT);
         }
         else if (woodType == WoodType.WARPED) {
            return getChestTexture(chestType, TRAPPED_WARPED_CHEST, TRAPPED_WARPED_CHEST_LEFT, TRAPPED_WARPED_CHEST_RIGHT);
         }
      }
      else if (blockEntity instanceof JinericChestBlockEntity) {
         if (woodType == WoodType.ACACIA) {
            return getChestTexture(chestType, ACACIA_CHEST, ACACIA_CHEST_LEFT, ACACIA_CHEST_RIGHT);
         }
         else if (woodType == WoodType.BIRCH) {
            return getChestTexture(chestType, BIRCH_CHEST, BIRCH_CHEST_LEFT, BIRCH_CHEST_RIGHT);
         }
         else if (woodType == WoodType.CRIMSON) {
            return getChestTexture(chestType, CRIMSON_CHEST, CRIMSON_CHEST_LEFT, CRIMSON_CHEST_RIGHT);
         }
         else if (woodType == WoodType.DARK_OAK) {
            return getChestTexture(chestType, DARK_OAK_CHEST, DARK_OAK_CHEST_LEFT, DARK_OAK_CHEST_RIGHT);
         }
         else if (woodType == WoodType.JUNGLE) {
            return getChestTexture(chestType, JUNGLE_CHEST, JUNGLE_CHEST_LEFT, JUNGLE_CHEST_RIGHT);
         }
         else if (woodType == WoodType.SPRUCE) {
            return getChestTexture(chestType, SPRUCE_CHEST, SPRUCE_CHEST_LEFT, SPRUCE_CHEST_RIGHT);
         }
         else if (woodType == WoodType.WARPED) {
            return getChestTexture(chestType, WARPED_CHEST, WARPED_CHEST_LEFT, WARPED_CHEST_RIGHT);
         }
         else if (woodType == WoodType.MANGROVE) {
            return getChestTexture(chestType, MANGROVE_CHEST, MANGROVE_CHEST_LEFT, MANGROVE_CHEST_RIGHT);
         }
         else if (woodType == WoodType.CHERRY) {
            return getChestTexture(chestType, CHERRY_CHEST, CHERRY_CHEST_LEFT, CHERRY_CHEST_RIGHT);
         }
         else if (woodType == WoodType.BAMBOO) {
            return getChestTexture(chestType, BAMBOO_CHEST, BAMBOO_CHEST_LEFT, BAMBOO_CHEST_RIGHT);
         }
      }
      return null;
   }

   public static SpriteIdentifier getChestTexture(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right) {
      return switch (type) {
         case LEFT -> left;
         case RIGHT -> right;
         default -> single;
      };
   }
}
