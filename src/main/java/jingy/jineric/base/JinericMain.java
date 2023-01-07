package jingy.jineric.base;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.entity.JinericPaintingMotive;
import jingy.jineric.item.JinericItemGroups;
import jingy.jineric.item.JinericItems;
import jingy.jineric.potion.JinericPotions;
import jingy.jineric.recipe.JinericRecipeType;
import jingy.jineric.recipe.RefiningRecipe;
import jingy.jineric.registry.*;
import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.sound.JinericSounds;
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
		JinericPaintingMotive.init();
		JinericBlocks.blockRegistry();
		JinericItems.itemRegistry();
		JinericItemGroups.onInitialize();
		JinericSounds.register();
		JinericPotions.registerPotions();
		JinericBlockEntityType.registerBlockEntities();
		RefiningRecipe.registerRefiningRecipe();
		JinericRecipeType.register();
		JinericScreenHandlerType.registerScreenHandlers();

		System.out.println("Jineric Mod Main - Finished initialization");
	}
}
