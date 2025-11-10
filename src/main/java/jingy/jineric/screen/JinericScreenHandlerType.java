package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

public class JinericScreenHandlerType {
	public final static ScreenHandlerType<RefineryScreenHandler> REFINERY = Registry.register(
			Registries.SCREEN_HANDLER,
			JinericMain.ofJineric("refinery"),
			new ScreenHandlerType<>(RefineryScreenHandler::new, FeatureSet.empty())
	);
	
	public static void initialize() {
	}
}
