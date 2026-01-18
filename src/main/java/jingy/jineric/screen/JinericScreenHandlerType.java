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
	public final static MenuType<CampfireScreenHandler> CAMPFIRE_SCREEN_HANDLER = Registry.register(
			BuiltInRegistries.MENU,
			JinericMain.ofJineric("campfire"),
			new MenuType<>(CampfireScreenHandler::new, null)
	);
	public final static MenuType<CrucibleScreenHandler> CRUCIBLE_SCREEN_HANDLER = Registry.register(
			BuiltInRegistries.MENU,
			JinericMain.ofJineric("crucible"),
			new MenuType<>(CrucibleScreenHandler::new, null)
	);
	public final static MenuType<FoundryScreenHandler> FOUNDRY = Registry.register(
			BuiltInRegistries.MENU,
			JinericMain.ofJineric("foundry"),
			new MenuType<>(FoundryScreenHandler::new, FeatureFlagSet.of())
	);
	public final static ScreenHandlerType<KilnScreenHandler> KILN = Registry.register(
			Registries.SCREEN_HANDLER,
			JinericMain.ofJineric("kiln"),
			new ScreenHandlerType<>(KilnScreenHandler::new, FeatureSet.empty())
	);
	
	public static void initialize() {
	}
}
