package jingy.jineric.registry;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class JinericBlockRenderLayerMap {

   //TODO: Move to JinericRegistries
   public static void register() {
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.FIREWEED, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.PETRIFIED_OAK_TRAPDOOR, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.PETRIFIED_OAK_DOOR, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.PETRIFIED_OAK_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.PETRIFIED_OAK_SAPLING, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.POTTED_PETRIFIED_OAK_SAPLING, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.FULL_GRASS_BLOCK, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.REDSTONE_LANTERN, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.REDSTONE_CAMPFIRE, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.SPRUCE_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BIRCH_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.MANGROVE_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.CHERRY_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BAMBOO_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.JUNGLE_LADDER, RenderLayer.getCutoutMipped());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.ACACIA_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.WARPED_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.CRIMSON_LADDER, RenderLayer.getCutout());
      BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.DARK_OAK_LADDER, RenderLayer.getCutout());
   }
}
