package jingy.jineric.registry;

import com.google.common.collect.Sets;
import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.WoodType;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class JinericEntityModelLayers extends EntityModelLayers {
   private static final Set<EntityModelLayer> LAYERS = Sets.<EntityModelLayer>newHashSet();

   public static final EntityModelLayer SHULKER_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "shulker_chest"), "main");
   public static final EntityModelLayer TURTLE_SADDLE = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "turtle"), "saddle");

   private static EntityModelLayer registerMain(String id) {
      return register(id, "main");
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

   public static EntityModelLayer createChest(WoodType woodType) {
      return create(woodType.name() + "_chest", "main");
   }

   public static EntityModelLayer createRightDoubleChest(WoodType woodType) {
      return create("double_" + woodType.name() + "_chest_right","main");
   }

   public static EntityModelLayer createLeftDoubleChest(WoodType woodType) {
      return create("double_" + woodType.name() + "_chest_left", "main");
   }

   public static EntityModelLayer createTrappedChest(WoodType woodType) {
      return create("trapped_" + woodType.name() + "_chest", "main");
   }

   public static EntityModelLayer createRightDoubleTrappedChest(WoodType woodType) {
      return create("trapped_double_" + woodType.name() + "_chest_right","main");
   }

   public static EntityModelLayer createLeftDoubleTrappedChest(WoodType woodType) {
      return create("trapped_double_" + woodType.name() + "_chest_left","main");
   }
}
