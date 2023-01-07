package jingy.jineric.potion;

import jingy.jineric.base.JinericMain;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JinericPotions {
   public static final Potion GLOWING = register("glowing", new Potion(new StatusEffectInstance(
           StatusEffects.GLOWING, 3600)));

   public static final Potion LONG_GLOWING = register("long_glowing", new Potion("glowing", new StatusEffectInstance(
           StatusEffects.GLOWING, 9600)));

   public static final Potion DARKNESS = register("darkness", new Potion(new StatusEffectInstance(
           StatusEffects.DARKNESS, 2160)));

   public static final Potion LONG_DARKNESS = register("long_darkness", new Potion(new StatusEffectInstance(
           StatusEffects.DARKNESS, 5760)));

//   public static final Potion THORNS = register("thorns", new Potion(new StatusEffectInstance(
//           ThornsStatusEffect.THORNS, 2160)));

//   public static final Potion LONG_THORNS = register("long_thorns", new Potion(new StatusEffectInstance(
//           ThornsStatusEffect.THORNS, 5760)));

   public static Potion register(String name, Potion potion) {
      return Registry.register(Registries.POTION, new Identifier("jineric", name), potion);
   }

   public static void registerPotions() {
   }
}
