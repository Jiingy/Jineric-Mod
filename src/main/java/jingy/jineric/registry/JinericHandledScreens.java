package jingy.jineric.registry;

import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.screen.RefineryScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class JinericHandledScreens {

   public static void registerHandledScreens() {
      HandledScreens.register(JinericScreenHandlerType.REFINERY_SCREEN_HANDLER, RefineryScreen::new);
   }
}
