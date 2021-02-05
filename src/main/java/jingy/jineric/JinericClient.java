package jingy.jineric;

import jingy.jineric.screenhandlers.ShulkerChestScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class JinericClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Jineric.SHULKER_CHEST_SCREEN_HANDLER, ShulkerChestScreen::new);
    }
}