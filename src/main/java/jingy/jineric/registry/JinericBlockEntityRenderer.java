package jingy.jineric.registry;

import jingy.jineric.client.render.blockentity.RedstoneCampfireBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;

public class JinericBlockEntityRenderer {

   public static void register() {
      BlockEntityRendererFactories.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.JINERIC_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntityRenderer::new);
   }
}
