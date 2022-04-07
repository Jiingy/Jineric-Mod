package jingy.jineric.entity.passive.manxloaghtan;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanModel<T extends ManxLoaghtan> extends QuadrupedEntityModel<T> {
   private float headPitchModifier;

   public ManxLoaghtanModel(ModelPart modelPart) {
      super(modelPart, false, 8.0F, 4.0F, 2.0F, 2.0F, 24);
   }

   public static TexturedModelData getTexturedModelData() {
      ModelData modelData = QuadrupedEntityModel.getModelData(12, Dilation.NONE);
      ModelPartData modelPartData = modelData.getRoot();
      modelPartData.addChild(
              EntityModelPartNames.HEAD,
              ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F),
              ModelTransform.pivot(0.0F, 6.0F, -8.0F)
      );
      modelPartData.addChild(
              EntityModelPartNames.BODY,
              ModelPartBuilder.create().uv(28, 8).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F),
              ModelTransform.of(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
      );
      return TexturedModelData.of(modelData, 64, 32);
   }

   public void animateModel(T manxLoaghtanEntity, float f, float g, float h) {
      super.animateModel(manxLoaghtanEntity, f, g, h);
      this.head.pivotY = 6.0F + manxLoaghtanEntity.getNeckAngle(h) * 9.0F;
      this.headPitchModifier = manxLoaghtanEntity.getHeadAngle(h);
   }

   public void setAngles(T manxLoaghtanEntity, float f, float g, float h, float i, float j) {
      super.setAngles(manxLoaghtanEntity, f, g, h, i, j);
      this.head.pitch = this.headPitchModifier;
   }
}
