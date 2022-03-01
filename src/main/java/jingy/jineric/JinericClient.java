package jingy.jineric;

import jingy.jineric.blocks.JinericBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class JinericClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_TRAPDOOR, RenderLayer.getCutout());
	}
}
