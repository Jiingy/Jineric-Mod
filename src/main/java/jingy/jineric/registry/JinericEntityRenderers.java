package jingy.jineric.registry;

import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class JinericEntityRenderers {

   public static void register() {
      EntityRendererRegistry.register(JinericEntities.MANX_LOAGHTAN, ManxLoaghtanRenderer::new);
   }
}
