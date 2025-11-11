package net.jineric.jineric_mod.registry;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;

@Environment(EnvType.CLIENT)
public class JinericBlockRenderLayerMap {
	
	public static void registerBlockRenderLayerMaps() {
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT,
				JinericBlocks.SPRUCE_LADDER,
				JinericBlocks.BIRCH_LADDER,
				JinericBlocks.JUNGLE_LADDER,
				JinericBlocks.ACACIA_LADDER,
				JinericBlocks.MANGROVE_LADDER,
				JinericBlocks.CHERRY_LADDER,
				JinericBlocks.BAMBOO_LADDER,
				JinericBlocks.DARK_OAK_LADDER,
				JinericBlocks.WARPED_LADDER,
				JinericBlocks.CRIMSON_LADDER
		);
		BlockRenderLayerMap.putBlock(JinericBlocks.GRASS_BLOCK, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.REDSTONE_LANTERN, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.REDSTONE_CAMPFIRE, BlockRenderLayer.CUTOUT);
	}
}
