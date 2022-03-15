package jingy.jineric.base;

import jingy.jineric.client.gui.screen.ingame.ShulkerChestScreen;
import jingy.jineric.registry.JinericBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class JinericClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_TRAPDOOR, RenderLayer.getCutout());

		ScreenRegistry.register(Jineric.SHULKER_CHEST_SCREEN_HANDLER, ShulkerChestScreen::new);
	}
}
