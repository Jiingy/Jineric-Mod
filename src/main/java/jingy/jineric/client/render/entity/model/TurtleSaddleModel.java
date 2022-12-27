package jingy.jineric.client.render.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.TurtleEntity;

public class TurtleSaddleModel<T extends TurtleEntity> extends QuadrupedEntityModel<T> {

   public TurtleSaddleModel(ModelPart root) {
      super(root, true, 120.0F, 0.0F, 9.0F, 6.0F, 120);
   }

   public static TexturedModelData getTexturedModelData() {
      ModelData modelData = new ModelData();
      ModelPartData modelPartData = modelData.getRoot();
      modelPartData.addChild(
              EntityModelPartNames.BONE,
              ModelPartBuilder.create()
                      .uv(7, 37)
                      .cuboid("saddle", -9.5F, 3.0F, -10.0F, 19.0F, 20.0F, 6.0F, new Dilation(0.5F)),
              ModelTransform.of(0.0F, 11.0F, -10.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
      );
//      modelPartData.addChild(
//              EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(3, 0).cuboid(-3.0F, -1.0F, -3.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 19.0F, -10.0F)
//      );
//      modelPartData.addChild(
//              EntityModelPartNames.BODY,
//              ModelPartBuilder.create()
//                      .uv(7, 37)
//                      .cuboid("shell", -9.5F, 3.0F, -10.0F, 19.0F, 20.0F, 6.0F)
//                      .uv(31, 1)
//                      .cuboid("belly", -5.5F, 3.0F, -13.0F, 11.0F, 18.0F, 3.0F),
//              ModelTransform.of(0.0F, 11.0F, -10.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
//      );
//      modelPartData.addChild(
//              "egg_belly",
//              ModelPartBuilder.create().uv(70, 33).cuboid(-4.5F, 3.0F, -14.0F, 9.0F, 18.0F, 1.0F),
//              ModelTransform.of(0.0F, 11.0F, -10.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
//      );
//      int i = 1;
//      modelPartData.addChild(
//              EntityModelPartNames.RIGHT_HIND_LEG,
//              ModelPartBuilder.create().uv(1, 23).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 10.0F),
//              ModelTransform.pivot(-3.5F, 22.0F, 11.0F)
//      );
//      modelPartData.addChild(
//              EntityModelPartNames.LEFT_HIND_LEG,
//              ModelPartBuilder.create().uv(1, 12).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 10.0F),
//              ModelTransform.pivot(3.5F, 22.0F, 11.0F)
//      );
//      modelPartData.addChild(
//              EntityModelPartNames.RIGHT_FRONT_LEG,
//              ModelPartBuilder.create().uv(27, 30).cuboid(-13.0F, 0.0F, -2.0F, 13.0F, 1.0F, 5.0F),
//              ModelTransform.pivot(-5.0F, 21.0F, -4.0F)
//      );
//      modelPartData.addChild(
//              EntityModelPartNames.LEFT_FRONT_LEG,
//              ModelPartBuilder.create().uv(27, 24).cuboid(0.0F, 0.0F, -2.0F, 13.0F, 1.0F, 5.0F),
//              ModelTransform.pivot(5.0F, 21.0F, -4.0F)
//      );
      return TexturedModelData.of(modelData, 128, 64);
   }

   @Override
   public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
      super.render(matrices, vertices, light, overlay, red, green, blue, alpha);
   }
}
