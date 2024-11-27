package jingy.jineric.base;

import jingy.jineric.client.render.entity.model.TurtleSaddleModel;
import jingy.jineric.registry.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.TurtleEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class JinericClientMain implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		registerFeatureRenderers();
		JinericColorProviders.register();
		JinericBlockEntityRenderer.register();
		JinericEntityRenderers.register();
		JinericScreenHandlerTypes.register();
		JinericBlockRenderLayerMap.register();
		JinericEntityModels.register();
	}

	private void registerFeatureRenderers() {
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register(((entityType, entityRenderer, registrationHelper, context) -> {
			if (entityRenderer instanceof TurtleEntityRenderer turtleEntityRenderer) {
				registrationHelper.register(new SaddleFeatureRenderer(
						turtleEntityRenderer, new TurtleSaddleModel(context.getPart(JinericEntityModelLayers.TURTLE_SADDLE)), Identifier.of(JinericMain.MOD_ID, "textures/entity/turtle/big_sea_turtle_saddle.png"))
				);

			}
		}));
	}
}