package net.jineric.jineric_mod.registry;

import jingy.jineric.registry.JinericBlockEntityType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.CampfireBlockEntityRenderer;

@Environment(EnvType.CLIENT)
public class JinericBlockEntityRenderer {
	
	public static void registerBlockEntityRenderers() {
		BlockEntityRendererFactories.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, CampfireBlockEntityRenderer::new);
	}
}
