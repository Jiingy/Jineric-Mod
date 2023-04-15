package jingy.jineric.client.render;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.entity.ShulkerChestBlockEntity;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class JinericTextureRenderLayers extends TexturedRenderLayers {

   public static final SpriteIdentifier ACACIA_CHEST = createChestTextureId("acacia_chest");
   public static final SpriteIdentifier ACACIA_CHEST_LEFT = createChestTextureId("acacia_left");
   public static final SpriteIdentifier ACACIA_CHEST_RIGHT = createChestTextureId("acacia_right");
   public static final SpriteIdentifier BOREAL_CHEST = createChestTextureId("boreal_chest");
   public static final SpriteIdentifier BOREAL_CHEST_LEFT = createChestTextureId("boreal_left");
   public static final SpriteIdentifier BOREAL_CHEST_RIGHT = createChestTextureId("boreal_right");
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
   public static final SpriteIdentifier SHULKER = createChestTextureId("shulker_chest");
   public static final SpriteIdentifier SPRUCE_CHEST = createChestTextureId("spruce_chest");
   public static final SpriteIdentifier SPRUCE_CHEST_LEFT = createChestTextureId("spruce_left");
   public static final SpriteIdentifier SPRUCE_CHEST_RIGHT = createChestTextureId("spruce_right");
   public static final SpriteIdentifier WARPED_CHEST = createChestTextureId("warped_chest");
   public static final SpriteIdentifier WARPED_CHEST_LEFT = createChestTextureId("warped_left");
   public static final SpriteIdentifier WARPED_CHEST_RIGHT = createChestTextureId("warped_right");
   public static final SpriteIdentifier MANGROVE_CHEST = createChestTextureId("mangrove_chest");
   public static final SpriteIdentifier MANGROVE_CHEST_LEFT = createChestTextureId("mangrove_left");
   public static final SpriteIdentifier MANGROVE_CHEST_RIGHT = createChestTextureId("mangrove_right");

   private static SpriteIdentifier createChestTextureId(String variant) {
      return new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(JinericMain.MOD_ID, "entity/chest/" + variant));
   }

   public static SpriteIdentifier getChestTexture(BlockEntity blockEntity, ChestType chestType, boolean christmas, WoodType woodType) {
      if (christmas) {
         return getChestTexture(chestType, CHRISTMAS, CHRISTMAS_LEFT, CHRISTMAS_RIGHT);
      }
      else if (blockEntity instanceof ShulkerChestBlockEntity) {
         return SHULKER;
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
      }
      return null;
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
