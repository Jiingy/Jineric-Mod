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
	public final static ScreenHandlerType<CampfireScreenHandler> CAMPFIRE_SCREEN_HANDLER = Registry.register(
			Registries.SCREEN_HANDLER,
			JinericMain.ofJineric("campfire"),
			new ScreenHandlerType<>(CampfireScreenHandler::new, null)
	);
	public final static ScreenHandlerType<CrucibleScreenHandler> CRUCIBLE_SCREEN_HANDLER = Registry.register(
			Registries.SCREEN_HANDLER,
			JinericMain.ofJineric("crucible"),
			new ScreenHandlerType<>(CrucibleScreenHandler::new, null)
	);
	public final static ScreenHandlerType<FoundryScreenHandler> FOUNDRY = Registry.register(
			Registries.SCREEN_HANDLER,
			JinericMain.ofJineric("foundry"),
			new ScreenHandlerType<>(FoundryScreenHandler::new, FeatureSet.empty())
	);
	
	public static void initialize() {
	}
}
