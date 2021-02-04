package jingy.jineric;

import jingy.jineric.blocks.JinericBlocks;
import jingy.jineric.screenhandlers.ShulkerChestScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;

public class JinericClient  implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.<ShulkerChestContainer>registerFactory(JinericBlocks.SHULKER_CHEST, (container) -> new ShulkerChestScreen(container, MinecraftClient.getInstance().player.inventory, new TranslatableText(Jineric.SHULKER_CHEST_TRANSLATION_KEY)));
    }
}
