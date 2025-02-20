package jingy.jineric.registry;

import jingy.jineric.entity.JinericEntityType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.BoatEntityRenderer;

@Environment(EnvType.CLIENT)
public class JinericEntityRenderers {
	
	public static void registerEntityRenderers() {
		EntityRendererRegistry.register(JinericEntityType.PETRIFIED_OAK_BOAT, context -> new BoatEntityRenderer(context, JinericEntityModelLayers.PETRIFIED_OAK_BOAT));
		EntityRendererRegistry.register(JinericEntityType.PETRIFIED_OAK_CHEST_BOAT, context -> new BoatEntityRenderer(context, JinericEntityModelLayers.PETRIFIED_OAK_CHEST_BOAT));
	}
}
