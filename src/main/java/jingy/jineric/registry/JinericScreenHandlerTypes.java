package jingy.jineric.registry;

import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.screen.RefineryScreen;
import jingy.jineric.screen.ShulkerChestScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class JinericScreenHandlerTypes {

   public static void register() {
      HandledScreens.register(JinericScreenHandlerType.SHULKER_CHEST, ShulkerChestScreen::new);
      HandledScreens.register(JinericScreenHandlerType.REFINERY, RefineryScreen::new);
   }
}
