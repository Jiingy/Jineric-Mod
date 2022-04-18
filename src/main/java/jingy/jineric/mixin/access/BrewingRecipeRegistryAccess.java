package jingy.jineric.mixin.access;

import jingy.jineric.potion.JinericPotions;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryAccess {

   @Shadow
   private static void registerPotionRecipe(Potion input, Item item, Potion output) {
   }

   @Inject(at = @At("HEAD"), method = "registerDefaults()V")
   private static void jineric$registerDefaults(CallbackInfo ci) {
      registerPotionRecipe(Potions.AWKWARD, Items.GLOW_BERRIES, JinericPotions.GLOWING);
      registerPotionRecipe(JinericPotions.GLOWING, Items.REDSTONE, JinericPotions.LONG_GLOWING);

      //registerPotionRecipe(Potions.SLOW_FALLING, Items.FERMENTED_SPIDER_EYE, JinericPotions.FAST_FALLING);
      //registerPotionRecipe(JinericPotions.FAST_FALLING, Items.REDSTONE, JinericPotions.LONG_FAST_FALLING);
   }
}
