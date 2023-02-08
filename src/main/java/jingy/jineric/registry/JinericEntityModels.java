package jingy.jineric.registry;

import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanModel;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanWoolModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.model.TurtleEntityModel;

public class JinericEntityModels {

   public static void register() {
      //TexturedModelData.of(TurtleEntityModel.getModelData(0, new Dilation(0.5F)), 128, 64)
      EntityModelLayerRegistry.TexturedModelDataProvider turtleSaddle = () -> TexturedModelData.of(TurtleEntityModel.getModelData(0, new Dilation(0.5F)), 128, 64);
      EntityModelLayerRegistry.registerModelLayer(jingy.jineric.client.render.entity.model.JinericEntityModelLayer.TURTLE_SADDLE, turtleSaddle);
//		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.TURTLE_SADDLE, TurtleEntityModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(jingy.jineric.client.render.entity.model.JinericEntityModelLayer.MANX_LOAGHTAN, ManxLoaghtanModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(jingy.jineric.client.render.entity.model.JinericEntityModelLayer.MANX_LOAGHTAN_WOOL, ManxLoaghtanWoolModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.ACACIA_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_ACACIA_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_ACACIA_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.BIRCH_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_BIRCH_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_BIRCH_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.BOREAL_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_BOREAL_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_BOREAL_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.CRIMSON_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_CRIMSON_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_CRIMSON_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DARK_OAK_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_DARK_OAK_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_DARK_OAK_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.JUNGLE_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_JUNGLE_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_JUNGLE_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.SPRUCE_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_SPRUCE_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_SPRUCE_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.WARPED_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_WARPED_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_WARPED_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.MANGROVE_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_MANGROVE_CHEST_LEFT, ChestBlockEntityRenderer::getLeftDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.DOUBLE_MANGROVE_CHEST_RIGHT, ChestBlockEntityRenderer::getRightDoubleTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.SHULKER_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
   }
}
