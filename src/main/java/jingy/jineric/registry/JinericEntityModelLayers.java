package jingy.jineric.registry;

import com.google.common.collect.Sets;
import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class JinericEntityModelLayers {
   private static final String MAIN = "main";
   private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();

   private static EntityModelLayer registerMain(String id) {
      return register(id, MAIN);
   }

   private static EntityModelLayer register(String id, String layer) {
      EntityModelLayer entityModelLayer = create(id, layer);
      if (!LAYERS.add(entityModelLayer)) {
         throw new IllegalStateException("Duplicate registration for " + entityModelLayer);
      } else {
         return entityModelLayer;
      }
   }

   private static EntityModelLayer create(String id, String layer) {
      return new EntityModelLayer(JinericMain.ofJineric(id), layer);
   }
}
