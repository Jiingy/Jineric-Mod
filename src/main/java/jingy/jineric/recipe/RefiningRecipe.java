package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import jingy.jineric.item.JinericItems;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RefiningRecipe extends AbstractCookingRecipe {
   public RefiningRecipe(Identifier id, String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
      super(JinericRecipeType.REFINING, id, group, category, input, output, experience, cookTime);
   }

   @Override
   public ItemStack createIcon() {
      return new ItemStack(JinericItems.REFINERY);
   }

   @Override
   public RecipeType<?> getType() {
      return JinericRecipeType.REFINING;
   }

   @Override
   public RecipeSerializer<?> getSerializer() {
      return RefiningRecipe.REFINING_RECIPE_SERIALIZER;
   }

   public static final CookingRecipeSerializer<RefiningRecipe> REFINING_RECIPE_SERIALIZER = Registry.register(
           Registries.RECIPE_SERIALIZER,
           new Identifier(JinericMain.MOD_ID, "refining"),
           new CookingRecipeSerializer<>(RefiningRecipe::new, 100)
   );

   public static void registerRefiningRecipe() {
   }
}
