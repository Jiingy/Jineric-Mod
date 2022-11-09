package jingy.jineric.registry;

import com.google.common.collect.Sets;
import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class JinericEntityModelLayers extends EntityModelLayers {

   private static final Set<EntityModelLayer> LAYERS = Sets.<EntityModelLayer>newHashSet();

   public static final EntityModelLayer ACACIA_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "acacia_chest"), "main");
   public static final EntityModelLayer DOUBLE_ACACIA_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_acacia_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_ACACIA_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_acacia_chest_right"), "main");
   public static final EntityModelLayer BIRCH_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "birch_chest"), "main");
   public static final EntityModelLayer DOUBLE_BIRCH_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_birch_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_BIRCH_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_birch_chest_right"), "main");
   public static final EntityModelLayer BOREAL_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "boreal_chest"), "main");
   public static final EntityModelLayer DOUBLE_BOREAL_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_boreal_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_BOREAL_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_boreal_chest_right"), "main");
   public static final EntityModelLayer CRIMSON_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "crimson_chest"), "main");
   public static final EntityModelLayer DOUBLE_CRIMSON_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_crimson_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_CRIMSON_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_crimson_chest_right"), "main");
   public static final EntityModelLayer DARK_OAK_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "dark_oak_chest"), "main");
   public static final EntityModelLayer DOUBLE_DARK_OAK_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_dark_oak_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_DARK_OAK_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_dark_oak_chest_right"), "main");
   public static final EntityModelLayer JUNGLE_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "jungle_chest"), "main");
   public static final EntityModelLayer DOUBLE_JUNGLE_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_jungle_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_JUNGLE_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_jungle_chest_right"), "main");
   public static final EntityModelLayer SPRUCE_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "spruce_chest"), "main");
   public static final EntityModelLayer DOUBLE_SPRUCE_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_spruce_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_SPRUCE_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_spruce_chest_right"), "main");
   public static final EntityModelLayer WARPED_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "warped_chest"), "main");
   public static final EntityModelLayer DOUBLE_WARPED_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_warped_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_WARPED_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_warped_chest_right"), "main");
   public static final EntityModelLayer MANGROVE_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "mangrove_chest"), "main");
   public static final EntityModelLayer DOUBLE_MANGROVE_CHEST_LEFT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_mangrove_chest_left"), "main");
   public static final EntityModelLayer DOUBLE_MANGROVE_CHEST_RIGHT = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "double_mangrove_chest_right"), "main");

   public static final EntityModelLayer SHULKER_CHEST = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "shulker_chest"), "main");

   public static final EntityModelLayer FROZEN_ELYTRA = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "frozen_elytra"), "main");

   public static final EntityModelLayer TURTLE_SADDLE = new EntityModelLayer(new Identifier(JinericMain.MOD_ID, "turtle"), "saddle");
}
