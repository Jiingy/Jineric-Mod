package net.jineric.jineric_mod.access;

import net.minecraft.world.item.crafting.display.RecipeDisplay;

public interface JmGhostSlots {
	default RecipeDisplay jineric$getRecipeDisplay() {
		throw new RuntimeException();
	}
	
	default void jineric$setRecipeDisplay(RecipeDisplay recipeDisplay) {}
}
