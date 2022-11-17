package jingy.jineric.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericPotions {
//TODO Finish adding
   public static final Potion GLOWING = register(
           "glowing", new Potion(new StatusEffectInstance(StatusEffects.GLOWING, 3600))
   );

   public static final Potion LONG_GLOWING = register(
           "long_glowing", new Potion("glowing", new StatusEffectInstance(StatusEffects.GLOWING, 9600))
   );

   public static Potion register(String name, Potion potion) {
      return Registry.register(Registry.POTION, new Identifier("jineric", name), potion);
   }

   public static void registerPotions() {
   }
}
