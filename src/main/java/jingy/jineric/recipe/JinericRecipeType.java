package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JinericRecipeType {
   // RECIPE TYPES
   public static RecipeType<RefiningRecipe> REFINING_RECIPE_TYPE;

   public static void registerRecipeTypes() {
      REFINING_RECIPE_TYPE = Registry.register(
              Registries.RECIPE_TYPE,
              new Identifier(JinericMain.MOD_ID, "refining"),
              new RecipeType<RefiningRecipe>() {
         @Override
         public String toString() {return "refining";}
      });

   }
}

