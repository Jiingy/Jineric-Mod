package net.jineric.jineric_mod.mixin.client.duck;

import net.jineric.jineric_mod.base.injected_interfaces.JmAbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AbstractRecipeBookScreen.class)
public abstract class AbstractRecipeBookScreenDuckMixin implements JmAbstractRecipeBookScreen {

	@Unique
	@Override
	public RecipeBookComponent<?> jineric$recipeBookWidget() {
		return null;
	}
}