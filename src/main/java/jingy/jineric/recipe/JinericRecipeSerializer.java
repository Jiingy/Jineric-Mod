package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface JinericRecipeSerializer {
	RecipeSerializer<RefiningRecipe> REFINING = register("refining", new AbstractCookingRecipe.Serializer<>(RefiningRecipe::new, 100));
	RecipeSerializer<FoundrySmeltingRecipe> FOUNDRY_SMELTING = register("foundry_smelting", new FoundrySmeltingRecipe.Serializer(FoundrySmeltingRecipe::new, 400, 1));
	
	static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
		return Registry.register(Registries.RECIPE_SERIALIZER, JinericMain.ofJineric(id), serializer);
	}
	
	static void initialize() {}
}
