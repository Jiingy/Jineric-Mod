package net.jineric.jineric_mod.mixin.client.access.overrides;

import net.jineric.jineric_mod.access.JmAbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AbstractRecipeBookScreen.class)
public abstract class AbstractRecipeBookScreenOverrides implements JmAbstractRecipeBookScreen {

	@Unique
	@Override
	public RecipeBookComponent<?> jineric$recipeBookWidget() {
		return null;
	}
}