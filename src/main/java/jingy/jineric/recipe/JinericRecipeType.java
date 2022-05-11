package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericRecipeType {
   // RECIPE TYPES
   public static RecipeType<RefiningRecipe> REFINING;

   public static void register() {
      RefiningRecipe.registerRefiningRecipe();
      REFINING = Registry.register(
              Registry.RECIPE_TYPE,
              new Identifier(JinericMain.MOD_ID, "refining"),
              new RecipeType<RefiningRecipe>() {
         @Override
         public String toString() {return "refining";}
      });

   }
}

