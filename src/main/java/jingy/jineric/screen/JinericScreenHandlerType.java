package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;

public class JinericScreenHandlerType {
	public final static MenuType<RefineryScreenHandler> REFINERY = Registry.register(
			BuiltInRegistries.MENU,
			JinericMain.ofJineric("refinery"),
			new MenuType<>(RefineryScreenHandler::new, FeatureFlagSet.of())
	);
	
	public static void initialize() {
	}
}
