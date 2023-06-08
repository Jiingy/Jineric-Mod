package jingy.jineric.base;

import jingy.jineric.block.JinericCauldronBehaviors;
import jingy.jineric.entity.JinericPaintingVariant;
import jingy.jineric.entity.effect.JinericStatusEffects;
import jingy.jineric.item.JinericItemGroups;
import jingy.jineric.recipe.JinericRecipeType;
import jingy.jineric.recipe.RefiningRecipe;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.registry.JinericRegistries;
import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.stat.JinericStats;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JinericMain implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("Jineric Mod");
	public static final String MOD_ID = "jineric";

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
	LOGGER.info("Jineric Mod Main - Starting initialization");
		JinericRegistries.registerJinericMod();
		JinericItemGroups.registerItemGroups();
		JinericPaintingVariant.registerPaintingMotives();
		JinericStats.registerStats();
		JinericBlockEntityType.registerBlockEntities();
		RefiningRecipe.registerRefiningRecipe();
		JinericRecipeType.registerRecipeTypes();
		JinericStatusEffects.registerStatusEffects();
		JinericScreenHandlerType.registerScreenHandlers();
		JinericCauldronBehaviors.registerCauldronBehaviors();

		System.out.println("Jineric Mod Main - Finished initialization");
	}
}
