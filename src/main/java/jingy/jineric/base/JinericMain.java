package jingy.jineric.base;

import jingy.jineric.block.JinericCauldronBehaviors;
import jingy.jineric.entity.JinericPaintingVariant;
import jingy.jineric.entity.effect.JinericStatusEffects;
import jingy.jineric.item.JinericItemGroups;
import jingy.jineric.recipe.JinericRecipeSerializers;
import jingy.jineric.recipe.JinericRecipeTypes;
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

	public static Identifier jinericId(String path) {
		return new Identifier(MOD_ID, path);
	}

	// TODO: FIX EMI PLUGIN
	@Override
	public void onInitialize() {
		LOGGER.info("Jineric Mod Main - Starting initialization");
		this.initRegistries();
		System.out.println("Jineric Mod Main - Finished initialization");
	}

	private void initRegistries() {
		JinericRegistries.initJinericRegistries();
		JinericItemGroups.registerItemGroups();
		JinericItemGroups.registerJinericItemGroups();
		JinericPaintingVariant.registerPaintingMotives();
		JinericStats.registerStats();
		JinericBlockEntityType.registerBlockEntities();
		JinericStatusEffects.registerStatusEffects();
		JinericScreenHandlerType.registerScreenHandlers();
		JinericCauldronBehaviors.registerCauldronBehaviors();
		JinericRecipeTypes.registerRecipeTypes();
		JinericRecipeSerializers.registerRefiningRecipe();
	}
}
