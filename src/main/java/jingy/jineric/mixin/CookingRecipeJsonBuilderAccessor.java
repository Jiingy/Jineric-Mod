package jingy.jineric.mixin;

import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CookingRecipeJsonBuilder.class)
public interface CookingRecipeJsonBuilderAccessor {

   @Invoker("<init>")
   static CookingRecipeJsonBuilder createCookingRecipeJsonBuilder(
           RecipeCategory category,
           CookingRecipeCategory cookingCategory,
           ItemConvertible output,
           Ingredient input,
           float experience,
           int cookingTime,
           AbstractCookingRecipe.RecipeFactory<?> recipeFactory
   ) {
      throw new UnsupportedOperationException();
   }
}
