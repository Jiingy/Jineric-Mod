package jingy.jineric.mixin;

import jingy.jineric.potion.JinericPotions;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.recipe.BrewingRecipeRegistry.registerPotionRecipe;

@Mixin(BrewingRecipeRegistry.class)
public abstract class BrewingRecipeRegistryMixin {



   @Inject(at = @At("HEAD"), method = "registerDefaults()V")
   private static void jineric$registerDefaults(CallbackInfo ci) {
      //DARKNESS
      registerPotionRecipe(Potions.NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, JinericPotions.DARKNESS);
      registerPotionRecipe(JinericPotions.DARKNESS, Items.REDSTONE, JinericPotions.LONG_DARKNESS);
      registerPotionRecipe(Potions.LONG_NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, JinericPotions.LONG_DARKNESS);
      //GLOWING
      registerPotionRecipe(Potions.AWKWARD, Items.GLOW_BERRIES, JinericPotions.GLOWING);
      registerPotionRecipe(JinericPotions.GLOWING, Items.REDSTONE, JinericPotions.LONG_GLOWING);
      //INVISIBILITY
      registerPotionRecipe(JinericPotions.GLOWING, Items.FERMENTED_SPIDER_EYE, Potions.INVISIBILITY);
      registerPotionRecipe(JinericPotions.LONG_GLOWING, Items.FERMENTED_SPIDER_EYE, Potions.LONG_INVISIBILITY);
   }
}
