package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface JinericRecipeTypes<T extends Recipe<?>> {
   RecipeType<RefiningRecipe> REFINING = register("refining");

    static <T extends Recipe<?>> RecipeType<T> register(String id) {
        return Registry.register(Registries.RECIPE_TYPE, JinericMain.ofJineric(id), new RecipeType<T>() {
            public String toString() {
                return id;
            }
        });
    }

    static void registerRecipeTypes() {}
}