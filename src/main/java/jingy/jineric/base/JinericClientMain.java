package jingy.jineric.base;

import jingy.jineric.client.gui.screen.ingame.ShulkerChestScreen;
import jingy.jineric.client.render.entity.feature.JinericElytraFeatureRenderer;
import jingy.jineric.registry.JinericBlocks;
import jingy.jineric.registry.JinericItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;

@Environment(EnvType.CLIENT)
public class JinericClientMain implements ClientModInitializer {

	//public static final EntityType<BoatEntity> BOREAL_BOAT

	@Override
	public void onInitializeClient() {
		registerFeatureRenderers();


		//BLOCK RENDER LAYER MAPS
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.FULL_GRASS_BLOCK, RenderLayer.getCutout());

		//SCREEN HANDLERS
		HandledScreens.register(JinericMain.SHULKER_CHEST_SCREEN_HANDLER, ShulkerChestScreen::new);
		//FabricDefaultAttributeRegistry.register(BOREAL_BOAT, JinericBoatEntity.createMobAttributes());


		// COLOR PROVIDERS
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
						world != null && pos != null
								? BiomeColors.getGrassColor(world, pos)
								: GrassColors.getColor(0.5D, 1.0D),
				JinericBlocks.FULL_GRASS_BLOCK);

		ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D)),
				JinericItems.FULL_GRASS_BLOCK);
	}

	private void registerFeatureRenderers() {
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
			if (entityRenderer instanceof ArmorStandEntityRenderer || entityRenderer instanceof PlayerEntityRenderer) {
				registrationHelper.register(new JinericElytraFeatureRenderer<>(entityRenderer, context.getModelLoader()));
			}
		});
	}
}