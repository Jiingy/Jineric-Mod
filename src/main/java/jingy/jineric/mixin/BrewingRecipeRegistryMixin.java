package jingy.jineric.mixin;

import jingy.jineric.potion.JinericPotions;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(BrewingRecipeRegistry.class)
public abstract class BrewingRecipeRegistryMixin {

   @Inject(at = @At("HEAD"), method = "registerDefaults")
   private static void jineric$registerDefaults(BrewingRecipeRegistry.Builder builder, CallbackInfo ci) {
      //DARKNESS
      builder.registerPotionRecipe(Potions.NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, JinericPotions.DARKNESS);
      builder.registerPotionRecipe(JinericPotions.DARKNESS, Items.REDSTONE, JinericPotions.LONG_DARKNESS);
      builder.registerPotionRecipe(Potions.LONG_NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, JinericPotions.LONG_DARKNESS);
      //GLOWING
      builder.registerPotionRecipe(Potions.AWKWARD, Items.GLOW_BERRIES, JinericPotions.GLOWING);
      builder.registerPotionRecipe(JinericPotions.GLOWING, Items.REDSTONE, JinericPotions.LONG_GLOWING);
      //INVISIBILITY
      builder.registerPotionRecipe(JinericPotions.GLOWING, Items.FERMENTED_SPIDER_EYE, Potions.INVISIBILITY);
      builder.registerPotionRecipe(JinericPotions.LONG_GLOWING, Items.FERMENTED_SPIDER_EYE, Potions.LONG_INVISIBILITY);
   }
}
