package jingy.jineric.base;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.client.render.JinericElytraFeatureRenderer;
import jingy.jineric.client.render.blockentity.GenericChestBlockEntityRenderer;
import jingy.jineric.client.render.blockentity.JinericCampfireBlockEntityRenderer;
import jingy.jineric.client.render.entity.model.JinericEntityModelLayer;
import jingy.jineric.client.render.entity.model.TurtleSaddleModel;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanModel;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanWoolModel;
import jingy.jineric.registry.ColorProviders;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.registry.JinericEntityModelLayers;
import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.screen.RefineryScreen;
import jingy.jineric.screen.ShulkerChestScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.impl.client.rendering.BlockEntityRendererRegistryImpl;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.TurtleEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class JinericClientMain implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		registerFeatureRenderers();

		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.CAMPFIRE, JinericCampfireBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.ACACIA_CHEST, GenericChestBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.BIRCH_CHEST, GenericChestBlockEntityRenderer::new);
//		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.BOREAL_CHEST, GenericChestBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.CRIMSON_CHEST, GenericChestBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.DARK_OAK_CHEST, GenericChestBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.JUNGLE_CHEST, GenericChestBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.SPRUCE_CHEST, GenericChestBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.WARPED_CHEST, GenericChestBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.MANGROVE_CHEST, GenericChestBlockEntityRenderer::new);
		BlockEntityRendererRegistryImpl.register(JinericBlockEntityType.SHULKER_CHEST, GenericChestBlockEntityRenderer::new);

		//TexturedModelData.of(TurtleEntityModel.getModelData(0, new Dilation(0.5F)), 128, 64)

		//ENTITY MODEL LAYERS
		EntityModelLayerRegistry.TexturedModelDataProvider turtleSaddle = () -> TexturedModelData.of(TurtleSaddleModel.getModelData(0, new Dilation(0.5F)), 128, 64);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.TURTLE_SADDLE, turtleSaddle);
//		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.TURTLE_SADDLE, TurtleEntityModel::getTexturedModelData);
//		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.TURTLE_SADDLE, TurtleSaddleModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.MANX_LOAGHTAN, ManxLoaghtanModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.MANX_LOAGHTAN_WOOL, ManxLoaghtanWoolModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.ACACIA_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_ACACIA_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_ACACIA_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.BIRCH_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_BIRCH_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_BIRCH_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.BOREAL_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_BOREAL_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_BOREAL_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.CRIMSON_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_CRIMSON_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_CRIMSON_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DARK_OAK_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_DARK_OAK_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_DARK_OAK_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.JUNGLE_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_JUNGLE_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_JUNGLE_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.SPRUCE_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_SPRUCE_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_SPRUCE_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.WARPED_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_WARPED_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_WARPED_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.MANGROVE_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_MANGROVE_CHEST_LEFT, GenericChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_MANGROVE_CHEST_RIGHT, GenericChestBlockEntityRenderer::getRightDoubleTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.SHULKER_CHEST, GenericChestBlockEntityRenderer::getSingleTexturedModelData);

		//BLOCK RENDER LAYER MAPS
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.FIREWEED, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_TRAPDOOR, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.FULL_GRASS_BLOCK, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_LEAVES, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.REDSTONE_CAMPFIRE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.SPRUCE_LADDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BIRCH_LADDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.MANGROVE_LADDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.JUNGLE_LADDER, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.ACACIA_LADDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.WARPED_LADDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.CRIMSON_LADDER, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.BOREAL_LADDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(JinericBlocks.DARK_OAK_LADDER, RenderLayer.getCutout());

//		ClientSpriteRegistryCallback.event(TexturedRenderLayers.CHEST_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
//			registry.register(JinericChestType.ACACIA.texture);
//			registry.register(JinericChestType.ACACIA.textureLeft);
//			registry.register(JinericChestType.ACACIA.textureRight);
//			registry.register(JinericChestType.BIRCH.texture);
//			registry.register(JinericChestType.BIRCH.textureLeft);
//			registry.register(JinericChestType.BIRCH.textureRight);
//			registry.register(JinericChestType.BOREAL.texture);
//			registry.register(JinericChestType.BOREAL.textureLeft);
//			registry.register(JinericChestType.BOREAL.textureRight);
//			registry.register(JinericChestType.CRIMSON.texture);
//			registry.register(JinericChestType.CRIMSON.textureLeft);
//			registry.register(JinericChestType.CRIMSON.textureRight);
//			registry.register(JinericChestType.DARK_OAK.texture);
//			registry.register(JinericChestType.DARK_OAK.textureLeft);
//			registry.register(JinericChestType.DARK_OAK.textureRight);
//			registry.register(JinericChestType.JUNGLE.texture);
//			registry.register(JinericChestType.JUNGLE.textureLeft);
//			registry.register(JinericChestType.JUNGLE.textureRight);
//			registry.register(JinericChestType.SPRUCE.texture);
//			registry.register(JinericChestType.SPRUCE.textureLeft);
//			registry.register(JinericChestType.SPRUCE.textureRight);
//			registry.register(JinericChestType.WARPED.texture);
//			registry.register(JinericChestType.WARPED.textureLeft);
//			registry.register(JinericChestType.WARPED.textureRight);
//			registry.register(JinericChestType.MANGROVE.texture);
//			registry.register(JinericChestType.MANGROVE.textureLeft);
//			registry.register(JinericChestType.MANGROVE.textureRight);
//			registry.register(JinericChestType.SHULKER.texture);
//		}));

		//SCREEN HANDLERS
		HandledScreens.register(JinericScreenHandlerType.SHULKER_CHEST, ShulkerChestScreen::new);
		HandledScreens.register(JinericScreenHandlerType.REFINERY, RefineryScreen::new);

		// COLOR PROVIDERS
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
						world != null && pos != null
								? BiomeColors.getGrassColor(world, pos)
								: GrassColors.getColor(0.5D, 1.0D),
				JinericBlocks.FULL_GRASS_BLOCK);
		ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D)),
				JinericItems.FULL_GRASS_BLOCK);

		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
						world != null && pos != null
								? BiomeColors.getGrassColor(world, pos)
								: GrassColors.getColor(0.5D, 1.0D),
				JinericBlocks.JUNGLE_LADDER);
		ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D)),
				JinericItems.JUNGLE_LADDER);

	}


	private void registerFeatureRenderers() {
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
			if (entityRenderer instanceof ArmorStandEntityRenderer || entityRenderer instanceof PlayerEntityRenderer) {
				registrationHelper.register(
						new JinericElytraFeatureRenderer<>(entityRenderer, context.getModelLoader()));
			}
		});

		LivingEntityFeatureRendererRegistrationCallback.EVENT.register(((entityType, entityRenderer, registrationHelper, context) -> {
			if (entityRenderer instanceof TurtleEntityRenderer turtleEntityRenderer) {
				registrationHelper.register(new SaddleFeatureRenderer(
						turtleEntityRenderer, new TurtleSaddleModel(context.getPart(JinericEntityModelLayer.TURTLE_SADDLE)),new Identifier(JinericMain.MOD_ID, "textures/entity/turtle/big_sea_turtle_saddle.png"))
				);

			}
		}));
	}
}
//(EntityModel<? extends Entity & Saddleable>)
//new TurtleEntityModel<>(context.getPart(JinericEntityModelLayer.TURTLE_SADDLE))
//(FeatureRendererContext<Saddleable, ? super TurtleEntityModel<Saddleable>>) entityRenderer