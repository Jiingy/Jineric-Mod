package jingy.jineric.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FastFallingEffect extends StatusEffect {
   protected FastFallingEffect(StatusEffectCategory category, int color) {
      super(StatusEffectCategory.HARMFUL, color);
   }
}
