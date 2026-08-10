package net.jineric.jineric_mod;

import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.book.JinericRecipeBookType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.data.JinericModels;
import net.jineric.jineric_mod.data.JinericTextureKey;
import net.jineric.jineric_mod.recipe.JinericClientRecipeBookTypes;
import net.jineric.jineric_mod.registry.JinericBlockEntityRenderer;
import net.jineric.jineric_mod.registry.JinericColorProviders;
import net.jineric.jineric_mod.registry.JinericEntityModels;
import net.jineric.jineric_mod.registry.JinericHandledScreens;
import net.jineric.jineric_mod.render.block.JmBuiltInBlockModels;

@Environment(EnvType.CLIENT)
public class JinericClientMain implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		JinericTextureKey.initialize();
		JinericModels.initialize();
		JinericRecipeBookType.initialize();
		JinericRecipePropertySet.initialize();
		JinericEntityModels.registerEntityModels();
		JinericHandledScreens.registerMenuScreens();
		JinericColorProviders.registerColorProviders();
		JinericBlockEntityRenderer.registerBlockEntityRenderers();
		JmBuiltInBlockModels.addJmDefaults();
		//  Enum Adders
		JinericClientRecipeBookTypes.initialize();
	}
}