package jingy.jineric.mixin.access;

import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CookingRecipeJsonBuilder.class)
public interface CookingRecipeJsonBuilderAccess {

   //TODO: ADD SPECIFIC FAIL MESSAGE FOR THROWN ERRORS
   @Invoker("<init>")
   static CookingRecipeJsonBuilder invokeInit(
           RecipeCategory category,
           CookingRecipeCategory cookingCategory,
           ItemConvertible output,
           Ingredient input,
           float experience,
           int cookingTime,
           RecipeSerializer<? extends AbstractCookingRecipe> serializer
   ) {
      throw new IllegalStateException("Mixin not applied!");
   }
}
