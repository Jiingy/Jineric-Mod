package jingy.jineric.mixin;

import jingy.jineric.entity.effect.JinericStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LivingEntity.class)
public abstract class LivingEntityFastFallingMixin extends Entity {

   @Shadow public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

   public LivingEntityFastFallingMixin(EntityType<?> type, World world) {
      super(type, world);
   }

   //TODO: BROKEN IN 1.21.3, NEEDS TO TARGET 'this.setVelocity(vec3d.x, d, vec3d.z);'
   // INSIDE OF travelMidAir()
//   @ModifyConstant(
//           method = "travel",
//           constant = @Constant(
//                   doubleValue = 0.08,
//                   ordinal = 0
//           )
//   )
//   private double jineric$alterTravel(double constant, Vec3d movementInput) {
//      boolean bl = getVelocity().y <= 0.0;
//      if (bl && hasStatusEffect(JinericStatusEffects.FAST_FALLING)) {
//         return 0.64;
//      } else {
//         return constant;
//      }
//   }
   // TODO: CHANGE TO ModifyExpressionValue
   // DISCORD https://discord.com/channels/507304429255393322/807617700734042122/1069560661501296660
}
