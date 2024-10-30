package jingy.jineric.mixin;

import jingy.jineric.recipe.JinericRecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(net.minecraft.client.recipebook.RecipeBookType.class)
public abstract class RecipeBookTypeMixin {
   @Shadow @Final private List<RecipeBookCategory> categories;

   @Inject(method = "getCategories", at = @At("HEAD"))
      private void addRefineryToCategories(CallbackInfoReturnable<List<RecipeBookCategory>> cir) {
      //TODO: BROKEN IN 1.21.3
//         categories.add(JinericRecipeBookCategories.REFINERY_BLOCKS);
//         categories.add(JinericRecipeBookCategories.REFINERY_MISC);
//         cir.setReturnValue(this.categories);
      }
}
