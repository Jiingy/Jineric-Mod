package jingy.jineric.registry;

import jingy.jineric.client.render.blockentity.RedstoneCampfireBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

public class JinericBlockEntityRenderer {

   public static void register() {
      BlockEntityRendererFactories.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.JINERIC_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.JINERIC_TRAPPED_CHEST, ChestBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.JINERIC_SIGN, SignBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.JINERIC_HANGING_SIGN, HangingSignBlockEntityRenderer::new);
      BlockEntityRendererFactories.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntityRenderer::new);
   }
}
