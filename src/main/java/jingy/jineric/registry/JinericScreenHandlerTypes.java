package jingy.jineric.registry;

import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.screen.RefineryScreen;
import jingy.jineric.screen.ShulkerChestScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class JinericScreenHandlerTypes {
   public static void register() {
      HandledScreens.register(JinericScreenHandlerType.SHULKER_CHEST, ShulkerChestScreen::new);
      HandledScreens.register(JinericScreenHandlerType.REFINERY, RefineryScreen::new);
   }
}
