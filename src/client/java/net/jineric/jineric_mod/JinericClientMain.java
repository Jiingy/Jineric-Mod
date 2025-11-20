package net.jineric.jineric_mod;

import jingy.jineric.recipe.book.JinericRecipeBookType;
import net.jineric.jineric_mod.block.entity.state.JinericChestBlockEntityRenderStateVariant;
import net.jineric.jineric_mod.data.JinericModels;
import net.jineric.jineric_mod.data.JinericTextureKey;
import net.jineric.jineric_mod.recipe.JinericClientRecipeBookTypes;
import jingy.jineric.recipe.JinericRecipePropertySet;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.registry.*;

@Environment(EnvType.CLIENT)
public class JinericClientMain implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		JinericTextureKey.initialize();
		JinericModels.initialize();
		JinericRecipeBookType.initialize();
		JinericRecipePropertySet.initialize();
		JinericEntityModels.registerEntityModels();
		JinericHandledScreens.registerHandledScreens();
		JinericColorProviders.registerColorProviders();
		JinericBlockEntityRenderer.registerBlockEntityRenderers();
		JinericBlockRenderLayerMap.registerBlockRenderLayerMaps();
		//  Enum Adders
		JinericChestBlockEntityRenderStateVariant.initialize();
		JinericClientRecipeBookTypes.initialize();
	}
}