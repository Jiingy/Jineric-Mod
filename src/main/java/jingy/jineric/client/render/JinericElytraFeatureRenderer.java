package jingy.jineric.client.render;

import jingy.jineric.base.JinericMain;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.equipment.EquipmentRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class JinericElytraFeatureRenderer<S extends BipedEntityRenderState, M extends EntityModel<S>> extends FeatureRenderer<S, M> {
   private static final Identifier SKIN = JinericMain.ofJineric("jineric:textures/entity/frozen_elytra.png");
//   private final ElytraEntityModel model;
//   private final ElytraEntityModel babyModel;
//   private final EquipmentRenderer equipmentRenderer;

   public JinericElytraFeatureRenderer(FeatureRendererContext<S, M> context, EntityModelLoader loader, EquipmentRenderer equipmentRenderer) {
      super(context);
   }

   @Override
   public void render(
           MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, S bipedEntityRenderState, float f, float g
   ) {

   }
}
