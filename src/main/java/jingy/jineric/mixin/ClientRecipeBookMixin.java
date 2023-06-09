package jingy.jineric.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.JinericRecipeType;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.recipebook.RecipeBookGroup;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientRecipeBook.class)
public abstract class ClientRecipeBookMixin {
   private static final RecipeBookGroup JINERIC_REFINERY_BUILDING = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_BUILDING");
   private static final RecipeBookGroup JINERIC_REFINERY_MISC = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_MISC");

   @Inject(
           method = "getGroupForRecipe",
           at = @At(
                   value = "FIELD",
                   target = "Lnet/minecraft/recipe/RecipeType;SMELTING:Lnet/minecraft/recipe/RecipeType;"),
           cancellable = true
   )
   private static void jineric$addRefineryGroupForRecipe(Recipe<?> recipe, CallbackInfoReturnable<RecipeBookGroup> cir) {
      RecipeType<?> recipeType = recipe.getType();
      if (recipe instanceof AbstractCookingRecipe abstractCookingRecipe) {
         CookingRecipeCategory cookingRecipeCategory = abstractCookingRecipe.getCategory();
         if (recipeType == JinericRecipeType.REFINING) {
            if (cookingRecipeCategory == CookingRecipeCategory.BLOCKS) {
               cir.setReturnValue(JINERIC_REFINERY_BUILDING);
            } else {
               cir.setReturnValue(JINERIC_REFINERY_MISC);
            }
         }
      }
   }
}
