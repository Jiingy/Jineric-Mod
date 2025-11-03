package jingy.jineric.client.render;

import jingy.jineric.base.JinericMain;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

public class JinericTextureRenderLayers extends TexturedRenderLayers {
	public static final SpriteIdentifier ACACIA_CHEST = mapJineric("acacia_chest");
	public static final SpriteIdentifier ACACIA_CHEST_LEFT = mapJineric("acacia_chest_left");
	public static final SpriteIdentifier ACACIA_CHEST_RIGHT = mapJineric("acacia_chest_right");
	public static final SpriteIdentifier TRAPPED_ACACIA_CHEST = mapJineric("trapped_acacia_chest");
	public static final SpriteIdentifier TRAPPED_ACACIA_CHEST_LEFT = mapJineric("trapped_acacia_chest_left");
	public static final SpriteIdentifier TRAPPED_ACACIA_CHEST_RIGHT = mapJineric("trapped_acacia_chest_right");
	public static final SpriteIdentifier BIRCH_CHEST = mapJineric("birch_chest");
	public static final SpriteIdentifier BIRCH_CHEST_LEFT = mapJineric("birch_chest_left");
	public static final SpriteIdentifier BIRCH_CHEST_RIGHT = mapJineric("birch_chest_right");
	public static final SpriteIdentifier CRIMSON_CHEST = mapJineric("crimson_chest");
	public static final SpriteIdentifier CRIMSON_CHEST_LEFT = mapJineric("crimson_chest_left");
	public static final SpriteIdentifier CRIMSON_CHEST_RIGHT = mapJineric("crimson_chest_right");
	public static final SpriteIdentifier DARK_OAK_CHEST = mapJineric("dark_oak_chest");
	public static final SpriteIdentifier DARK_OAK_CHEST_LEFT = mapJineric("dark_oak_chest_left");
	public static final SpriteIdentifier DARK_OAK_CHEST_RIGHT = mapJineric("dark_oak_chest_right");
	public static final SpriteIdentifier JUNGLE_CHEST = mapJineric("jungle_chest");
	public static final SpriteIdentifier JUNGLE_CHEST_LEFT = mapJineric("jungle_chest_left");
	public static final SpriteIdentifier JUNGLE_CHEST_RIGHT = mapJineric("jungle_chest_right");
	public static final SpriteIdentifier SPRUCE_CHEST = mapJineric("spruce_chest");
	public static final SpriteIdentifier SPRUCE_CHEST_LEFT = mapJineric("spruce_chest_left");
	public static final SpriteIdentifier SPRUCE_CHEST_RIGHT = mapJineric("spruce_chest_right");
	public static final SpriteIdentifier WARPED_CHEST = mapJineric("warped_chest");
	public static final SpriteIdentifier WARPED_CHEST_LEFT = mapJineric("warped_chest_left");
	public static final SpriteIdentifier WARPED_CHEST_RIGHT = mapJineric("warped_chest_right");
	public static final SpriteIdentifier MANGROVE_CHEST = mapJineric("mangrove_chest");
	public static final SpriteIdentifier MANGROVE_CHEST_LEFT = mapJineric("mangrove_chest_left");
	public static final SpriteIdentifier MANGROVE_CHEST_RIGHT = mapJineric("mangrove_chest_right");
	public static final SpriteIdentifier CHERRY_CHEST = mapJineric("cherry_chest");
	public static final SpriteIdentifier CHERRY_CHEST_LEFT = mapJineric("cherry_chest_left");
	public static final SpriteIdentifier CHERRY_CHEST_RIGHT = mapJineric("cherry_chest_right");
	public static final SpriteIdentifier BAMBOO_CHEST = mapJineric("bamboo_chest");
	public static final SpriteIdentifier BAMBOO_CHEST_LEFT = mapJineric("bamboo_chest_left");
	public static final SpriteIdentifier BAMBOO_CHEST_RIGHT = mapJineric("bamboo_chest_right");
	public static final SpriteIdentifier TRAPPED_BIRCH_CHEST = mapJineric("trapped_birch_chest");
	public static final SpriteIdentifier TRAPPED_BIRCH_CHEST_LEFT = mapJineric("trapped_birch_chest_left");
	public static final SpriteIdentifier TRAPPED_BIRCH_CHEST_RIGHT = mapJineric("trapped_birch_chest_right");
	public static final SpriteIdentifier TRAPPED_CRIMSON_CHEST = mapJineric("trapped_crimson_chest");
	public static final SpriteIdentifier TRAPPED_CRIMSON_CHEST_LEFT = mapJineric("trapped_crimson_chest_left");
	public static final SpriteIdentifier TRAPPED_CRIMSON_CHEST_RIGHT = mapJineric("trapped_crimson_chest_right");
	public static final SpriteIdentifier TRAPPED_DARK_OAK_CHEST = mapJineric("trapped_dark_oak_chest");
	public static final SpriteIdentifier TRAPPED_DARK_OAK_CHEST_LEFT = mapJineric("trapped_dark_oak_chest_left");
	public static final SpriteIdentifier TRAPPED_DARK_OAK_CHEST_RIGHT = mapJineric("trapped_dark_oak_chest_right");
	public static final SpriteIdentifier TRAPPED_JUNGLE_CHEST = mapJineric("trapped_jungle_chest");
	public static final SpriteIdentifier TRAPPED_JUNGLE_CHEST_LEFT = mapJineric("trapped_jungle_chest_left");
	public static final SpriteIdentifier TRAPPED_JUNGLE_CHEST_RIGHT = mapJineric("trapped_jungle_chest_right");
	public static final SpriteIdentifier TRAPPED_SPRUCE_CHEST = mapJineric("trapped_spruce_chest");
	public static final SpriteIdentifier TRAPPED_SPRUCE_CHEST_LEFT = mapJineric("trapped_spruce_chest_left");
	public static final SpriteIdentifier TRAPPED_SPRUCE_CHEST_RIGHT = mapJineric("trapped_spruce_chest_right");
	public static final SpriteIdentifier TRAPPED_WARPED_CHEST = mapJineric("trapped_warped_chest");
	public static final SpriteIdentifier TRAPPED_WARPED_CHEST_LEFT = mapJineric("trapped_warped_chest_left");
	public static final SpriteIdentifier TRAPPED_WARPED_CHEST_RIGHT = mapJineric("trapped_warped_chest_right");
	public static final SpriteIdentifier TRAPPED_MANGROVE_CHEST = mapJineric("trapped_mangrove_chest");
	public static final SpriteIdentifier TRAPPED_MANGROVE_CHEST_LEFT = mapJineric("trapped_mangrove_chest_left");
	public static final SpriteIdentifier TRAPPED_MANGROVE_CHEST_RIGHT = mapJineric("trapped_mangrove_chest_right");
	public static final SpriteIdentifier TRAPPED_CHERRY_CHEST = mapJineric("trapped_cherry_chest");
	public static final SpriteIdentifier TRAPPED_CHERRY_CHEST_LEFT = mapJineric("trapped_cherry_chest_left");
	public static final SpriteIdentifier TRAPPED_CHERRY_CHEST_RIGHT = mapJineric("trapped_cherry_chest_right");
	public static final SpriteIdentifier TRAPPED_BAMBOO_CHEST = mapJineric("trapped_bamboo_chest");
	public static final SpriteIdentifier TRAPPED_BAMBOO_CHEST_LEFT = mapJineric("trapped_bamboo_chest_left");
	public static final SpriteIdentifier TRAPPED_BAMBOO_CHEST_RIGHT = mapJineric("trapped_bamboo_chest_right");
	
	public static SpriteIdentifier mapJineric(String id) {
		return CHEST_SPRITE_MAPPER.map(JinericMain.ofJineric(id));
	}
}
