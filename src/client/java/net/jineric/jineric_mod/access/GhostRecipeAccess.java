package net.jineric.jineric_mod.access;

import net.minecraft.recipe.display.RecipeDisplay;

public interface GhostRecipeAccess {
	default RecipeDisplay jineric$getRecipeDisplay() {
		throw new RuntimeException();
	}
	
	default void jineric$setRecipeDisplay(RecipeDisplay recipeDisplay) {}
}
