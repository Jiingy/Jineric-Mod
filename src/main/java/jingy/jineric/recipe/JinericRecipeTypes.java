package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class JinericRecipeTypes {
   public static RecipeType<RefiningRecipe> REFINING;

   public static void registerRecipeTypes() {
      String id = "refining";
      REFINING = Registry.register(
           Registries.RECIPE_TYPE, JinericMain.id(id), new RecipeType<RefiningRecipe>() {
              public String toString() {
                 return id;
              }
           }
      );
   }
}