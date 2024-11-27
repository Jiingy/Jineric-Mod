package jingy.jineric.registry;

import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanModel;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanWoolModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.TurtleEntityModel;

@Environment(EnvType.CLIENT)
public class JinericEntityModels {

   public static void register() {
      EntityModelLayerRegistry.TexturedModelDataProvider turtleSaddle = () -> TexturedModelData.of(TurtleEntityModel.getModelData(0, new Dilation(0.5F)), 128, 64);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.TURTLE_SADDLE, turtleSaddle);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.MANX_LOAGHTAN, ManxLoaghtanModel::getTexturedModelData);
      EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.MANX_LOAGHTAN_WOOL, ManxLoaghtanWoolModel::getTexturedModelData);
   }
}
