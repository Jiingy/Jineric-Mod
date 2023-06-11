package jingy.jineric.registry;

import com.google.common.collect.Sets;
import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class JinericEntityModelLayers {
   private static final String MAIN = "main";
   private static final Set<EntityModelLayer> LAYERS = Sets.<EntityModelLayer>newHashSet();
   public static final EntityModelLayer MANX_LOAGHTAN = registerMain("manx_loaghtan");
   public static final EntityModelLayer MANX_LOAGHTAN_WOOL = register("manx_loaghtan", "wool");
   public static final EntityModelLayer SHULKER_CHEST = registerMain("shulker_chest");
   public static final EntityModelLayer TURTLE_SADDLE = register("turtle", "saddle");

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
      return new EntityModelLayer(new Identifier(JinericMain.MOD_ID, id), layer);
   }
}
