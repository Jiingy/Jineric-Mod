package jingy.jineric.registry;

import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class JinericEntityRenderers {
   public static void register() {
      EntityRendererRegistry.register(JinericEntities.MANX_LOAGHTAN, ManxLoaghtanRenderer::new);
   }
}
