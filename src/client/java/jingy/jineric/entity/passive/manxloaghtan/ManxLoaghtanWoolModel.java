package jingy.jineric.entity.passive.manxloaghtan;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.render.entity.state.SheepEntityRenderState;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanWoolModel extends QuadrupedEntityModel<SheepEntityRenderState> {
   private float headAngle;

   public ManxLoaghtanWoolModel(ModelPart root) {
      super(root);
      //, false, 8.0F, 4.0F, 2.0F, 2.0F, 24
   }

   public static TexturedModelData getTexturedModelData() {
      ModelData modelData = new ModelData();
      ModelPartData modelPartData = modelData.getRoot();
      modelPartData.addChild(
              EntityModelPartNames.HEAD,
              ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -4.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.6F)),
              ModelTransform.pivot(0.0F, 6.0F, -8.0F)
      );
      modelPartData.addChild(
              EntityModelPartNames.BODY,
              ModelPartBuilder.create().uv(36, 0).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F, new Dilation(1.75F)),
              ModelTransform.of(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
      );
      ModelPartBuilder rightLegWoolPartBuilder = ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F));
      ModelPartBuilder leftLegWoolPartBuilder = ModelPartBuilder.create().uv(18, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F));
      modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, rightLegWoolPartBuilder, ModelTransform.pivot(-3.0F, 12.0F, -5.0F));
      modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, leftLegWoolPartBuilder, ModelTransform.pivot(3.0F, 12.0F, -5.0F));
      modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, rightLegWoolPartBuilder, ModelTransform.pivot(-3.0F, 12.0F, 7.0F));
      modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, leftLegWoolPartBuilder, ModelTransform.pivot(3.0F, 12.0F, 7.0F));
      return TexturedModelData.of(modelData, 64, 32);
   }

   //TODO: IF NEEDED, MAKE UNIQUE RENDER STATE FOR MANX 1.21.3
   public void setAngles(SheepEntityRenderState sheepEntityRenderState) {
      super.setAngles(sheepEntityRenderState);
      ModelPart var10000 = this.head;
      var10000.pivotY += sheepEntityRenderState.neckAngle * 9.0F * sheepEntityRenderState.ageScale;
      this.head.pitch = sheepEntityRenderState.headAngle;
   }
}
