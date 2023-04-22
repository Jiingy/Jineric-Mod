package jingy.jineric.registry;

import com.google.common.collect.ImmutableMap;
import jingy.jineric.client.render.entity.model.JinericEntityModelLayer;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanModel;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanWoolModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.block.WoodType;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.TurtleEntityModel;

public class JinericEntityModels {

   public static void register() {
      ImmutableMap.Builder<EntityModelLayer, TexturedModelData> builder = ImmutableMap.builder();
      EntityModelLayerRegistry.TexturedModelDataProvider turtleSaddle = () -> TexturedModelData.of(TurtleEntityModel.getModelData(0, new Dilation(0.5F)), 128, 64);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.TURTLE_SADDLE, turtleSaddle);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.MANX_LOAGHTAN, ManxLoaghtanModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayer.MANX_LOAGHTAN_WOOL, ManxLoaghtanWoolModel::getTexturedModelData);
      TexturedModelData jinericChestBlock = ChestBlockEntityRenderer.getSingleTexturedModelData();
      WoodType.stream().forEach(chestType -> builder.put(JinericEntityModelLayers.createChest(chestType), jinericChestBlock));
      TexturedModelData jinericDoubleRightChestBlock = ChestBlockEntityRenderer.getRightDoubleTexturedModelData();
      WoodType.stream().forEach(chestType -> builder.put(JinericEntityModelLayers.createRightDoubleChest(chestType), jinericDoubleRightChestBlock));
      TexturedModelData jinericDoubleLeftChestBlock = ChestBlockEntityRenderer.getLeftDoubleTexturedModelData();
      WoodType.stream().forEach(chestType -> builder.put(JinericEntityModelLayers.createLeftDoubleChest(chestType), jinericDoubleLeftChestBlock));
      WoodType.stream().forEach(chestType -> builder.put(JinericEntityModelLayers.createTrappedChest(chestType), jinericChestBlock));
      WoodType.stream().forEach(chestType -> builder.put(JinericEntityModelLayers.createRightDoubleTrappedChest(chestType), jinericDoubleRightChestBlock));
      WoodType.stream().forEach(chestType -> builder.put(JinericEntityModelLayers.createLeftDoubleTrappedChest(chestType), jinericDoubleLeftChestBlock));
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.SHULKER_CHEST, ChestBlockEntityRenderer::getSingleTexturedModelData);
   }
}
