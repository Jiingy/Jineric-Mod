package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class JinericScreenHandlerType<T extends ScreenHandler> {

   public static final Identifier SHULKER_CHEST_SCREEN_ID = new Identifier(JinericMain.MOD_ID, "shulker_chest");
   public static final Identifier REFINERY_SCREEN_ID = new Identifier(JinericMain.MOD_ID, "refinery");

   public static ScreenHandlerType<ShulkerChestScreenHandler> SHULKER_CHEST;
   public static ScreenHandlerType<RefineryScreenHandler> REFINERY;

   public static void registerScreenHandlers() {
//      SHULKER_CHEST = Registry.register(Registries.SCREEN_HANDLER, SHULKER_CHEST_SCREEN_ID, new ScreenHandlerType<>(ShulkerChestScreenHandler::new, null));
      SHULKER_CHEST = Registry.register(Registries.SCREEN_HANDLER, SHULKER_CHEST_SCREEN_ID, new ScreenHandlerType<>(ShulkerChestScreenHandler::new, null));
      REFINERY = Registry.register(Registries.SCREEN_HANDLER, REFINERY_SCREEN_ID, new ScreenHandlerType<>(RefineryScreenHandler::new, null));
   }
}
