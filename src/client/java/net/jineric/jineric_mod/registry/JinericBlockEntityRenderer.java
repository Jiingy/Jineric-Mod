package net.jineric.jineric_mod.registry;

import jingy.jineric.registry.JinericBlockEntityType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.CampfireRenderer;

@Environment(EnvType.CLIENT)
public class JinericBlockEntityRenderer {
	
	public static void registerBlockEntityRenderers() {
		BlockEntityRenderers.register(JinericBlockEntityType.REDSTONE_CAMPFIRE, CampfireRenderer::new);
	}
}
