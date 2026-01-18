package net.jineric.jineric_mod.access;

import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;

public interface RecipeBookScreenAccess {
	default RecipeBookComponent<?> jineric$recipeBookWidget() {
		throw new RuntimeException();
	}
}
