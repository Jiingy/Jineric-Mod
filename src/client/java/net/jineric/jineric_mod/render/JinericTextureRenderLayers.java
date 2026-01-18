package net.jineric.jineric_mod.render;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;

@Environment(EnvType.CLIENT)
public class JinericTextureRenderLayers extends Sheets {
	public static final Material ACACIA_CHEST = mapJineric("acacia_chest");
	public static final Material ACACIA_CHEST_LEFT = mapJineric("acacia_chest_left");
	public static final Material ACACIA_CHEST_RIGHT = mapJineric("acacia_chest_right");
	public static final Material TRAPPED_ACACIA_CHEST = mapJineric("trapped_acacia_chest");
	public static final Material TRAPPED_ACACIA_CHEST_LEFT = mapJineric("trapped_acacia_chest_left");
	public static final Material TRAPPED_ACACIA_CHEST_RIGHT = mapJineric("trapped_acacia_chest_right");
	public static final Material BIRCH_CHEST = mapJineric("birch_chest");
	public static final Material BIRCH_CHEST_LEFT = mapJineric("birch_chest_left");
	public static final Material BIRCH_CHEST_RIGHT = mapJineric("birch_chest_right");
	public static final Material CRIMSON_CHEST = mapJineric("crimson_chest");
	public static final Material CRIMSON_CHEST_LEFT = mapJineric("crimson_chest_left");
	public static final Material CRIMSON_CHEST_RIGHT = mapJineric("crimson_chest_right");
	public static final Material DARK_OAK_CHEST = mapJineric("dark_oak_chest");
	public static final Material DARK_OAK_CHEST_LEFT = mapJineric("dark_oak_chest_left");
	public static final Material DARK_OAK_CHEST_RIGHT = mapJineric("dark_oak_chest_right");
	public static final Material JUNGLE_CHEST = mapJineric("jungle_chest");
	public static final Material JUNGLE_CHEST_LEFT = mapJineric("jungle_chest_left");
	public static final Material JUNGLE_CHEST_RIGHT = mapJineric("jungle_chest_right");
	public static final Material SPRUCE_CHEST = mapJineric("spruce_chest");
	public static final Material SPRUCE_CHEST_LEFT = mapJineric("spruce_chest_left");
	public static final Material SPRUCE_CHEST_RIGHT = mapJineric("spruce_chest_right");
	public static final Material WARPED_CHEST = mapJineric("warped_chest");
	public static final Material WARPED_CHEST_LEFT = mapJineric("warped_chest_left");
	public static final Material WARPED_CHEST_RIGHT = mapJineric("warped_chest_right");
	public static final Material MANGROVE_CHEST = mapJineric("mangrove_chest");
	public static final Material MANGROVE_CHEST_LEFT = mapJineric("mangrove_chest_left");
	public static final Material MANGROVE_CHEST_RIGHT = mapJineric("mangrove_chest_right");
	public static final Material CHERRY_CHEST = mapJineric("cherry_chest");
	public static final Material CHERRY_CHEST_LEFT = mapJineric("cherry_chest_left");
	public static final Material CHERRY_CHEST_RIGHT = mapJineric("cherry_chest_right");
	public static final Material BAMBOO_CHEST = mapJineric("bamboo_chest");
	public static final Material BAMBOO_CHEST_LEFT = mapJineric("bamboo_chest_left");
	public static final Material BAMBOO_CHEST_RIGHT = mapJineric("bamboo_chest_right");
	public static final Material TRAPPED_BIRCH_CHEST = mapJineric("trapped_birch_chest");
	public static final Material TRAPPED_BIRCH_CHEST_LEFT = mapJineric("trapped_birch_chest_left");
	public static final Material TRAPPED_BIRCH_CHEST_RIGHT = mapJineric("trapped_birch_chest_right");
	public static final Material TRAPPED_CRIMSON_CHEST = mapJineric("trapped_crimson_chest");
	public static final Material TRAPPED_CRIMSON_CHEST_LEFT = mapJineric("trapped_crimson_chest_left");
	public static final Material TRAPPED_CRIMSON_CHEST_RIGHT = mapJineric("trapped_crimson_chest_right");
	public static final Material TRAPPED_DARK_OAK_CHEST = mapJineric("trapped_dark_oak_chest");
	public static final Material TRAPPED_DARK_OAK_CHEST_LEFT = mapJineric("trapped_dark_oak_chest_left");
	public static final Material TRAPPED_DARK_OAK_CHEST_RIGHT = mapJineric("trapped_dark_oak_chest_right");
	public static final Material TRAPPED_JUNGLE_CHEST = mapJineric("trapped_jungle_chest");
	public static final Material TRAPPED_JUNGLE_CHEST_LEFT = mapJineric("trapped_jungle_chest_left");
	public static final Material TRAPPED_JUNGLE_CHEST_RIGHT = mapJineric("trapped_jungle_chest_right");
	public static final Material TRAPPED_SPRUCE_CHEST = mapJineric("trapped_spruce_chest");
	public static final Material TRAPPED_SPRUCE_CHEST_LEFT = mapJineric("trapped_spruce_chest_left");
	public static final Material TRAPPED_SPRUCE_CHEST_RIGHT = mapJineric("trapped_spruce_chest_right");
	public static final Material TRAPPED_WARPED_CHEST = mapJineric("trapped_warped_chest");
	public static final Material TRAPPED_WARPED_CHEST_LEFT = mapJineric("trapped_warped_chest_left");
	public static final Material TRAPPED_WARPED_CHEST_RIGHT = mapJineric("trapped_warped_chest_right");
	public static final Material TRAPPED_MANGROVE_CHEST = mapJineric("trapped_mangrove_chest");
	public static final Material TRAPPED_MANGROVE_CHEST_LEFT = mapJineric("trapped_mangrove_chest_left");
	public static final Material TRAPPED_MANGROVE_CHEST_RIGHT = mapJineric("trapped_mangrove_chest_right");
	public static final Material TRAPPED_CHERRY_CHEST = mapJineric("trapped_cherry_chest");
	public static final Material TRAPPED_CHERRY_CHEST_LEFT = mapJineric("trapped_cherry_chest_left");
	public static final Material TRAPPED_CHERRY_CHEST_RIGHT = mapJineric("trapped_cherry_chest_right");
	public static final Material TRAPPED_BAMBOO_CHEST = mapJineric("trapped_bamboo_chest");
	public static final Material TRAPPED_BAMBOO_CHEST_LEFT = mapJineric("trapped_bamboo_chest_left");
	public static final Material TRAPPED_BAMBOO_CHEST_RIGHT = mapJineric("trapped_bamboo_chest_right");
	
	public static Material mapJineric(String id) {
		return CHEST_MAPPER.apply(JinericMain.ofJineric(id));
	}
}
