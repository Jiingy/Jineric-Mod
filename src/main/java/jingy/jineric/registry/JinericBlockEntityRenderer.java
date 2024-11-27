package jingy.jineric.registry;

import jingy.jineric.client.render.blockentity.RedstoneCampfireBlockEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;

@Environment(EnvType.CLIENT)
public class JinericBlockEntityRenderer {

   public static void registerBlockEntityRenderers() {
      BlockEntityRendererFactories.register(JinericBlockEntityType.JINERIC_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.JINERIC_TRAPPED_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntityRenderer::new);
   }
}
