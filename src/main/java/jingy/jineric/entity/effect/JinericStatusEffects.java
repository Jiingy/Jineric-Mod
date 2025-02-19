package jingy.jineric.entity.effect;

import jingy.jineric.base.JinericMain;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class JinericStatusEffects {
   public static final StatusEffect THORNS = new ThornsStatusEffect(StatusEffectCategory.HARMFUL, 0);
   public static final StatusEffect FAST_FALLING = new FastFallingEffect(StatusEffectCategory.HARMFUL, 0);

   public static void registerStatusEffects() {
      Registry.register(Registries.STATUS_EFFECT, JinericMain.ofJineric("thorns"), THORNS);
      Registry.register(Registries.STATUS_EFFECT, JinericMain.ofJineric("fast_falling"), FAST_FALLING);
   }
}
