package jingy.jineric.recipe;

import jingy.jineric.item.JinericItems;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;

public class RefiningRecipe extends AbstractCookingRecipe {
   public RefiningRecipe(String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
      super(JinericRecipeTypes.REFINING, group, category, input, output, experience, cookTime);
   }

   public ItemStack createIcon() {
      return new ItemStack(JinericItems.REFINERY);
   }

   public RecipeType<?> getType() {
      return JinericRecipeTypes.REFINING;
   }

   public RecipeSerializer<?> getSerializer() {
      return JinericRecipeSerializers.REFINING;
   }
}
