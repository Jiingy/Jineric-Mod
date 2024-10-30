package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JinericRecipeSerializers {
   public static RecipeSerializer<RefiningRecipe> REFINING;

   public static void registerRefiningRecipe() {
      REFINING = Registry.register(
              Registries.RECIPE_SERIALIZER,
              JinericMain.ofJineric("refining"),
              new AbstractCookingRecipe.Serializer<>(RefiningRecipe::new, 100)
      );
   }
}
