package net.jineric.jineric_mod.registry;

import jingy.jineric.screen.JinericScreenHandlerType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.gui.screen.ingame.RefineryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class JinericHandledScreens {
	
	public static void registerHandledScreens() {
		HandledScreens.register(JinericScreenHandlerType.REFINERY, RefineryScreen::new);
	}
}
