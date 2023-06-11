package jingy.jineric.base;

import jingy.jineric.client.render.JinericElytraFeatureRenderer;
import jingy.jineric.client.render.entity.model.TurtleSaddleModel;
import jingy.jineric.registry.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.TurtleEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class JinericClientMain implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		registerFeatureRenderers();
		ColorProviders.register();
		JinericBlockEntityRenderer.register();
		JinericEntityRenderers.register();
		JinericScreenHandlerTypes.register();
		JinericBlockRenderLayerMap.register();
		JinericEntityModels.register();
	}

	private void registerFeatureRenderers() {
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
			if (entityRenderer instanceof ArmorStandEntityRenderer || entityRenderer instanceof PlayerEntityRenderer) {
				registrationHelper.register(
						new JinericElytraFeatureRenderer<>(entityRenderer, context.getModelLoader()));
			}
		});

		LivingEntityFeatureRendererRegistrationCallback.EVENT.register(((entityType, entityRenderer, registrationHelper, context) -> {
			if (entityRenderer instanceof TurtleEntityRenderer turtleEntityRenderer) {
				registrationHelper.register(new SaddleFeatureRenderer(
						turtleEntityRenderer, new TurtleSaddleModel(context.getPart(JinericEntityModelLayers.TURTLE_SADDLE)),new Identifier(JinericMain.MOD_ID, "textures/entity/turtle/big_sea_turtle_saddle.png"))
				);

			}
		}));
	}
}