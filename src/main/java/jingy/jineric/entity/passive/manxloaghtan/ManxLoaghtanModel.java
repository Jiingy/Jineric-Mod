package jingy.jineric.entity.passive.manxloaghtan;

import jingy.jineric.client.render.entity.model.JinericEntityModelPartNames;
import jingy.jineric.client.render.entity.state.ManxLoaghtanRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanModel extends QuadrupedEntityModel<ManxLoaghtanRenderState> {
   private float headPitchModifier;

   protected ManxLoaghtanModel(ModelPart root) {
      super(root);
   }


   public static TexturedModelData getTexturedModelData() {
      ModelData modelData = getModelData(12, Dilation.NONE);
      ModelPartData modelPartData = modelData.getRoot();
      Dilation dilation = new Dilation(0.001F);
//HEAD
      ModelPartData modelPartData2 = modelPartData.addChild(
              EntityModelPartNames.HEAD,
              ModelPartBuilder.create()
                      .uv(0, 0)
                      .cuboid(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F),
              ModelTransform.pivot(0.0F, 6.0F, -8.0F)
      );
   //UPPER HORNS
      modelPartData2.addChild(
              EntityModelPartNames.RIGHT_HORN,
              ModelPartBuilder.create().uv(51, 28).cuboid(-0.5F, -10.30F, -1.5F, 2.0F, 7.0F, 2.0F),
              ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2F, 0.0F, -0.5F)
      );

      modelPartData2.addChild(
              EntityModelPartNames.LEFT_HORN,
              ModelPartBuilder.create().uv(51, 18).cuboid(-1.5F, -10.30F, -1.5F, 2.0F, 7.0F, 2.0F),
              ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F)
      );
   //LOWER HORNS
      ModelPartBuilder rightFlatHornPartBuilder = ModelPartBuilder.create().uv(23, 18)
              .cuboid(-7.0F, 0.0F, 0.0F, 7.0F, 0.0F, 9.0F, dilation);

      ModelPartBuilder leftFlatHornPartBuilder = ModelPartBuilder.create().uv(23, 28)
              .cuboid(0.0F, 0.0F, 0.0F, 7.0F, 0.0F, 9.0F, dilation);

      modelPartData2.addChild(JinericEntityModelPartNames.RIGHT_FLAT_HORN,
              rightFlatHornPartBuilder, ModelTransform.of(-3.0F, -3.5F, -7.001F, 0.0F, 0.0F, -0.5F));

      modelPartData2.addChild(JinericEntityModelPartNames.LEFT_FLAT_HORN,
              leftFlatHornPartBuilder, ModelTransform.of(3.0F, -3.5F, -7.001F, 0.0F, 0.0F, 0.5F));
//BODY
      modelPartData.addChild(
              EntityModelPartNames.BODY,
              ModelPartBuilder.create().uv(0, 15).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F),
              ModelTransform.of(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
      );
   //LEGS
      ModelPartBuilder leftLegPartBuilder = ModelPartBuilder.create().uv(29, 0)
              .cuboid(2.0F, 0.5F, -1.0F, 4, 12, 4, dilation);
      ModelPartBuilder rightLegPartBuilder = ModelPartBuilder.create().uv(47, 0)
              .cuboid(2.0F, 0.5F, -1.0F, 4, 12, 4, dilation);

      modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, rightLegPartBuilder, ModelTransform.pivot(-7.0F, 11.5F, -6.0F));
      modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, leftLegPartBuilder, ModelTransform.pivot(-1.0F, 11.5F, -6.0F));
      modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, rightLegPartBuilder, ModelTransform.pivot(-7.0F, 11.5F, 6));
      modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, leftLegPartBuilder, ModelTransform.pivot(-1.0F, 11.5F, 6));

      return TexturedModelData.of(modelData, 64, 48);
   }
}
