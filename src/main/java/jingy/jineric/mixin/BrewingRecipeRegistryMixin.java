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

   @Inject(method = "registerDefaults", at = @At("TAIL"))
   private static void jineric$registerDefaults(CallbackInfo ci) {
      registerPotionRecipe(Potions.AWKWARD, Items.GLOW_BERRIES, JinericPotions.GLOWING);
      registerPotionRecipe(JinericPotions.GLOWING, Items.REDSTONE, JinericPotions.LONG_GLOWING);
   }
}
