package jingy.jineric.recipe;

import jingy.jineric.item.JinericItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;

public class RefiningRecipe extends AbstractCookingRecipe {
   public RefiningRecipe(String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
      super(group, category, input, output, experience, cookTime);
   }

   @Override
   protected Item getCookerItem() {
      return JinericItems.REFINERY;
   }

   @Override
   public RecipeSerializer<RefiningRecipe> getSerializer() {
      return JinericRecipeSerializers.REFINING;
   }

   @Override
   public RecipeType<RefiningRecipe> getType() {
      return JinericRecipeTypes.REFINING;
   }

   @Override
   public RecipeBookCategory getRecipeBookCategory() {
      return switch (this.getCategory()) {
         case BLOCKS -> JinericRecipeBookCategories.REFINERY_BLOCKS;
         case FOOD, MISC -> JinericRecipeBookCategories.REFINERY_MISC;
      };
   }
}
