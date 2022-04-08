package jingy.jineric.base;

import jingy.jineric.block.blockentity.shulkerchest.ShulkerChestScreen;
import jingy.jineric.block.custom.campfire.JinericCampfireBlockEntityRenderer;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanModel;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanWoolModel;
import jingy.jineric.registry.JinericBlocks;
import jingy.jineric.registry.JinericItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.impl.client.rendering.BlockEntityRendererRegistryImpl;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class JinericClientMain implements ClientModInitializer {

	public static final EntityModelLayer MANX_LOAGHTAN = new EntityModelLayer(
			new Identifier("jineric", "manx_loaghtan"), "main");

	public static final EntityModelLayer MANX_LOAGHTAN_WOOL = new EntityModelLayer(new Identifier("jineric", "manx_loaghtan"), "wool");

	@Override
	public void onInitializeClient() {
		registerFeatureRenderers();

		//ENTITY MODEL LAYERS
		EntityModelLayerRegistry.registerModelLayer(JinericClientMain.MANX_LOAGHTAN, ManxLoaghtanModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericClientMain.MANX_LOAGHTAN_WOOL, ManxLoaghtanWoolModel::getTexturedModelData);

		//BLOCK RENDER LAYER MAPS
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.FULL_GRASS_BLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.REDSTONE_CAMPFIRE, RenderLayer.getCutout());


		//SCREEN HANDLERS
		HandledScreens.register(JinericMain.SHULKER_CHEST_SCREEN_HANDLER, ShulkerChestScreen::new);

		// COLOR PROVIDERS
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
						world != null && pos != null
								? BiomeColors.getGrassColor(world, pos)
								: GrassColors.getColor(0.5D, 1.0D),
				JinericBlocks.FULL_GRASS_BLOCK);

		ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D)),
				JinericItems.FULL_GRASS_BLOCK);


		BlockEntityRendererRegistryImpl.register(JinericBlocks.JINERIC_CAMPFIRE_ENTITY, JinericCampfireBlockEntityRenderer::new);
		//BlockEntityRendererRegistryImpl.register(JinericBlocks.SHULKER_CHEST_ENTITY, JinericChestBlockEntityRenderer::new, JinericBlocks.SHULKER_CHEST_ENTITY);
	}

	private void registerFeatureRenderers() {
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
			if (entityRenderer instanceof ArmorStandEntityRenderer || entityRenderer instanceof PlayerEntityRenderer) {
				registrationHelper.register(new ElytraFeatureRenderer<>(entityRenderer, context.getModelLoader()));
			}
		});
	}
}