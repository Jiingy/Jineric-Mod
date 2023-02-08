package jingy.jineric.registry;

import jingy.jineric.client.render.blockentity.RedstoneCampfireBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;

public class JinericBlockEntityRenderer {

   public static void register() {
      BlockEntityRendererFactories.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.ACACIA_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.BIRCH_CHEST, ChestBlockEntityRenderer::new);
//		BlockEntityRendererRegistry.register(JinericBlockEntityType.BOREAL_CHEST, GenericChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.CRIMSON_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.DARK_OAK_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.JUNGLE_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.SPRUCE_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.WARPED_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.MANGROVE_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.SHULKER_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntityRenderer::new);
   }
}
