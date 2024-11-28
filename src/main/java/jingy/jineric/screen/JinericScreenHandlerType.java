package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class JinericScreenHandlerType {
   public static final Identifier REFINERY_SCREEN_ID = JinericMain.ofJineric("refinery");
   public final static ScreenHandlerType<RefineryScreenHandler> REFINERY_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, REFINERY_SCREEN_ID, new ScreenHandlerType<>(RefineryScreenHandler::new, FeatureSet.empty()));

   public static void initialize() {
   }
}
