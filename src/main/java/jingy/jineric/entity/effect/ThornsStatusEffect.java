package jingy.jineric.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ThornsStatusEffect extends StatusEffect {
   protected ThornsStatusEffect(StatusEffectCategory category, int color) {
      super(category, color);
   }


//   @Override
//   public boolean canApplyUpdateEffect(int duration, int amplifier) {
//      // In our case, we just make it return true so that it applies the status effect every tick.
//      return true;
//   }


//   @Override
//   public void applyUpdateEffect(LivingEntity entity, int amplifier) {
//      entity.slowMovement(Blocks.SWEET_BERRY_BUSH.getDefaultState(), new Vec3d(0.9F, 1.0F, 0.9F));
//
//      double d =
//              //Math.abs(
//              entity.getX()
//              //- entity.prevX)
//      ;
//      double e =
//              //Math.abs(
//              entity.getZ()
//              //- entity.prevZ)
//      ;
//      if (d != entity.prevX || e != entity.prevZ) {
//         entity.damage(DamageSource.SWEET_BERRY_BUSH, 1.0F);
//      }
//   }
//
}
