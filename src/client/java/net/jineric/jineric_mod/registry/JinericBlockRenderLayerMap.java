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
		BlockRenderLayerMap.putBlock(JinericBlocks.FULL_GRASS_BLOCK, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.REDSTONE_LANTERN, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.REDSTONE_CAMPFIRE, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.BLOSSOMED_DANDELION, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.POTTED_BLOSSOMED_DANDELION, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.ROSE, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.POTTED_ROSE, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.PETRIFIED_OAK_TRAPDOOR, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.PETRIFIED_OAK_DOOR, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.PETRIFIED_OAK_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.PETRIFIED_OAK_SAPLING, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.POTTED_PETRIFIED_OAK_SAPLING, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.FULL_GRASS_BLOCK, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.REDSTONE_LANTERN, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.REDSTONE_CAMPFIRE, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.SPRUCE_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.BIRCH_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.MANGROVE_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.CHERRY_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.BAMBOO_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.JUNGLE_LADDER, BlockRenderLayer.CUTOUT_MIPPED);
		BlockRenderLayerMap.putBlock(JinericBlocks.ACACIA_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.WARPED_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.CRIMSON_LADDER, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(JinericBlocks.DARK_OAK_LADDER, BlockRenderLayer.CUTOUT);
	}
}
