package net.jineric.jineric_mod.access;

import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;

public interface RecipeBookScreenAccess {
	default RecipeBookWidget<?> jineric$recipeBookWidget() {
		throw new RuntimeException();
	}
}
