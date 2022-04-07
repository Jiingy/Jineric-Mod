package jingy.jineric.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FastFallingEffect extends StatusEffect {
   public FastFallingEffect(StatusEffectCategory statusEffectCategory, int color) {
      super(statusEffectCategory, color);
   }

   @Override
   public void applyUpdateEffect(LivingEntity livingEntity, int amplifier) {
      super.applyUpdateEffect(livingEntity, amplifier);
   }

   @Override
   public boolean canApplyUpdateEffect(int Duration, int Amplifier) {
      return true;
   }
}
