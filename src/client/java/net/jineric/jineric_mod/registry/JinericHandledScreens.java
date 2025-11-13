package net.jineric.jineric_mod.registry;

import jingy.jineric.screen.JinericScreenHandlerType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.gui.screen.ingame.CampfireScreen;
import net.jineric.jineric_mod.gui.screen.ingame.CrucibleScreen;
import net.jineric.jineric_mod.gui.screen.ingame.FoundryScreen;
import net.jineric.jineric_mod.gui.screen.ingame.RefineryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class JinericHandledScreens {
	
	public static void registerHandledScreens() {
		HandledScreens.register(JinericScreenHandlerType.REFINERY, RefineryScreen::new);
		//  TODO: RENAME
		HandledScreens.register(JinericScreenHandlerType.CAMPFIRE_SCREEN_HANDLER, CampfireScreen::new);
		HandledScreens.register(JinericScreenHandlerType.CRUCIBLE_SCREEN_HANDLER, CrucibleScreen::new);
		HandledScreens.register(JinericScreenHandlerType.FOUNDRY, FoundryScreen::new);
	}
}
