package jingy.jineric.entity;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericStatusEffects extends StatusEffects {

   public static StatusEffect FAST_FALLING;

   private static StatusEffect register(String name) {
      return Registry.register(Registry.STATUS_EFFECT,  new Identifier("jineric", name),
              new FastFallingEffect(StatusEffectCategory.NEUTRAL, 16773073));
   }

   public static void RegisterEffects() {
      FAST_FALLING = register("fast_falling");
   }
}