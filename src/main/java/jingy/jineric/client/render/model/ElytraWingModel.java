package jingy.jineric.client.render.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class ElytraWingModel<T extends LivingEntity> extends AnimalModel<T> {
   private final ModelPart wing;
   private final boolean is_right_wing;


   public ElytraWingModel(ModelPart root, boolean is_right_wing) {
      if (is_right_wing) {
         this.wing = root.getChild("right_wing");
      } else {
         this.wing = root.getChild("left_wing");
      }
      this.is_right_wing = is_right_wing;
   }

   @Override
   protected Iterable<ModelPart> getHeadParts() {
      return ImmutableList.of();
   }

   @Override
   protected Iterable<ModelPart> getBodyParts() {
      return ImmutableList.of(wing);
   }

   @Override
   public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
      float k = 0.2617994F;
      float l = -0.2617994F;
      float m = 0.0F;
      float n = 0.0F;
      if (entity.isFallFlying()) {
         float o = 1.0F;
         Vec3d vec3d = entity.getVelocity();
         if (vec3d.y < 0.0D) {
            Vec3d vec3d2 = vec3d.normalize();
            o = 1.0F - (float) Math.pow(-vec3d2.y, 1.5D);
         }

         k = o * 0.34906584F + (1.0F - o) * k;
         l = o * -1.5707964F + (1.0F - o) * l;
      } else if (entity.isInSneakingPose()) {
         k = 0.6981317F;
         l = -0.7853982F;
         m = 3.0F;
         n = 0.08726646F;
      }

      this.wing.pivotX = 5.0F;
      this.wing.pivotY = m;
      if (entity instanceof AbstractClientPlayerEntity abstractClientPlayerEntity) {
         abstractClientPlayerEntity.elytraPitch = (float) ((double) abstractClientPlayerEntity.elytraPitch + (double) (k - abstractClientPlayerEntity.elytraPitch) * 0.1D);
         abstractClientPlayerEntity.elytraYaw = (float) ((double) abstractClientPlayerEntity.elytraYaw + (double) (n - abstractClientPlayerEntity.elytraYaw) * 0.1D);
         abstractClientPlayerEntity.elytraRoll = (float) ((double) abstractClientPlayerEntity.elytraRoll + (double) (l - abstractClientPlayerEntity.elytraRoll) * 0.1D);
         this.wing.pitch = abstractClientPlayerEntity.elytraPitch;
         this.wing.yaw = abstractClientPlayerEntity.elytraYaw;
         this.wing.roll = abstractClientPlayerEntity.elytraRoll;
      } else {
         this.wing.pitch = k;
         this.wing.roll = l;
         this.wing.yaw = n;
      }

      if (this.is_right_wing) {
         this.wing.pivotX = -this.wing.pivotX;
         this.wing.yaw = -this.wing.yaw;
         this.wing.roll = -this.wing.roll;
      }
   }
}
