package net.jineric.jineric_mod.registry;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

@Environment(EnvType.CLIENT)
public class JinericBlockRenderLayerMap {
	
	public static void registerBlockRenderLayerMaps() {
		BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT,
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
		BlockRenderLayerMap.putBlock(JinericBlocks.GRASS_BLOCK, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.REDSTONE_LANTERN, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.REDSTONE_CAMPFIRE, ChunkSectionLayer.CUTOUT);
	}
}
