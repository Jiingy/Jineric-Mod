package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface JinericRecipeTypes {
	RecipeType<RefiningRecipe> REFINING = register("refining");
	RecipeType<FoundrySmeltingRecipe> FOUNDRY_SMELTING = register("foundry_smelting");
	
	static <T extends Recipe<?>> RecipeType<T> register(String id) {
		return Registry.register(BuiltInRegistries.RECIPE_TYPE, JinericMain.ofJineric(id), new RecipeType<T>() {
			public String toString() {
				return id;
			}
		});
	}
	
	static void initialize() {
	}
}