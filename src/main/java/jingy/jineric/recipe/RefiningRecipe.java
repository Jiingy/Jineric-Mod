package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import jingy.jineric.registry.JinericItems;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RefiningRecipe extends AbstractCookingRecipe {
   public RefiningRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
      super(JinericRecipeType.REFINING, id, group, input, output, experience, cookTime);
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
           Registry.RECIPE_SERIALIZER,
           new Identifier(JinericMain.MOD_ID, "refining"),
           new CookingRecipeSerializer<>(RefiningRecipe::new, 100)
   );

   public static void registerRefiningRecipe() {
   }
}
