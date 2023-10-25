package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JinericRecipeSerializers {
   public static RecipeSerializer<RefiningRecipe> REFINING;

   public static void registerRefiningRecipe() {
      REFINING = Registry.register(
              Registries.RECIPE_SERIALIZER,
              new Identifier(JinericMain.MOD_ID, "refining"),
              new CookingRecipeSerializer<>(RefiningRecipe::new, 100)
      );
   }
}
