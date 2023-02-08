package jingy.jineric.base;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.entity.JinericPaintingMotive;
import jingy.jineric.entity.effect.JinericStatusEffects;
import jingy.jineric.item.JinericItemGroups;
import jingy.jineric.item.JinericItems;
import jingy.jineric.potion.JinericPotions;
import jingy.jineric.recipe.JinericRecipeType;
import jingy.jineric.recipe.RefiningRecipe;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.registry.JinericRegistries;
import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.sound.JinericSoundEvents;
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
//		JinericSoundGroups.register();
		JinericSoundEvents.init();
		JinericPotions.registerPotions();
		JinericBlockEntityType.registerBlockEntities();
		RefiningRecipe.register();
		JinericRecipeType.register();
		JinericStatusEffects.registerStatusEffect();
		JinericScreenHandlerType.registerScreenHandlers();

		System.out.println("Jineric Mod Main - Finished initialization");
	}
}
