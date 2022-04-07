package jingy.jineric.registry;

import com.google.common.collect.ImmutableMap;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanModel;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanWoolModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Environment(EnvType.CLIENT)
public class JinericEntityModels {

   public static Map<EntityModelLayer, TexturedModelData> getModels() {
      ImmutableMap.Builder<EntityModelLayer, TexturedModelData> builder = ImmutableMap.builder();
      builder.put(JinericEntityModelLayers.MANX_LOAGHTAN, ManxLoaghtanModel.getTexturedModelData());
      builder.put(JinericEntityModelLayers.MANX_LOAGHTAN_WOOL, ManxLoaghtanWoolModel.getTexturedModelData());


      ImmutableMap<EntityModelLayer, TexturedModelData> immutableMap = builder.build();
      List<EntityModelLayer> list = (List) EntityModelLayers.getLayers().filter(layer -> !immutableMap.containsKey(layer)).collect(Collectors.toList());
         return immutableMap;
   }

   public static void init() {

   }
}
