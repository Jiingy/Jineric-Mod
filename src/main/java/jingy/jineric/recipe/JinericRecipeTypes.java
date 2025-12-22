package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface JinericRecipeTypes {
	RecipeType<RefiningRecipe> REFINING = register("refining");
	RecipeType<FoundrySmeltingRecipe> FOUNDRY_SMELTING = register("foundry_smelting");
	RecipeType<FoundrySmeltingRecipe> KILN_FIRING = register("kiln_firing");
	
	static <T extends Recipe<?>> RecipeType<T> register(String id) {
		return Registry.register(Registries.RECIPE_TYPE, JinericMain.ofJineric(id), new RecipeType<T>() {
			public String toString() {
				return id;
			}
		});
	}
	
	static void initialize() {
	}
}