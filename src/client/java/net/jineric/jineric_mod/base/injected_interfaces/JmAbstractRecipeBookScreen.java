package net.jineric.jineric_mod.base.injected_interfaces;

import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;

public interface JmAbstractRecipeBookScreen {
	default RecipeBookComponent<?> jineric$recipeBookWidget() {
		throw new RuntimeException();
	}
}
