package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class JinericScreenHandlerType<T extends ScreenHandler> {

   public static ScreenHandlerType<ShulkerChestScreenHandler> SHULKER_CHEST;
   public static ScreenHandlerType<RefineryScreenHandler> REFINERY;

   //CHANGED THIS STUFF!!!!!!!! HEWREERERER SHULEKR HCDEST

   public static void registerScreenHandlers() {
      SHULKER_CHEST = ScreenHandlerRegistry.registerSimple(
              new Identifier(JinericMain.MOD_ID, "shulker_chest"), ShulkerChestScreenHandler::new);

      REFINERY = ScreenHandlerRegistry.registerSimple(
              new Identifier(JinericMain.MOD_ID, "refinery"), RefineryScreenHandler::new);

   }
}
