package jingy.jineric.base;

import jingy.jineric.recipe.JinericClientRecipeBookTypes;
import jingy.jineric.recipe.JinericRecipeBookTypes;
import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.registry.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class JinericClientMain implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		JinericRecipeBookTypes.initialize();
		JinericClientRecipeBookTypes.initialize();
		JinericRecipePropertySet.initialize();
		JinericEntityModels.registerEntityModels();
		JinericHandledScreens.registerHandledScreens();
		JinericColorProviders.registerColorProviders();
		JinericBlockEntityRenderer.registerBlockEntityRenderers();
		JinericBlockRenderLayerMap.registerBlockRenderLayerMaps();
	}
}