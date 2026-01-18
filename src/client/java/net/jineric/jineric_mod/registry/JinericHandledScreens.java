package net.jineric.jineric_mod.registry;

import jingy.jineric.screen.JinericScreenHandlerType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.gui.screen.ingame.CampfireScreen;
import net.jineric.jineric_mod.gui.screen.ingame.CrucibleScreen;
import net.jineric.jineric_mod.gui.screen.ingame.FoundryScreen;
import net.jineric.jineric_mod.gui.screen.ingame.KilnScreen;
import net.minecraft.client.gui.screens.MenuScreens;

@Environment(EnvType.CLIENT)
public class JinericHandledScreens {
	
	public static void registerMenuScreens() {
		MenuScreens.register(JinericScreenHandlerType.REFINERY, RefineryScreen::new);
		//  TODO: RENAME
		MenuScreens.register(JinericScreenHandlerType.CAMPFIRE_SCREEN_HANDLER, CampfireScreen::new);
		MenuScreens.register(JinericScreenHandlerType.CRUCIBLE_SCREEN_HANDLER, CrucibleScreen::new);
		MenuScreens.register(JinericScreenHandlerType.FOUNDRY, FoundryScreen::new);
		MenuScreens.register(JinericScreenHandlerType.KILN, KilnScreen::new);
	}
}
