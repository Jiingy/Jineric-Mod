package net.jineric.jineric_mod.mixin.client;

import net.jineric.jineric_mod.base.injected_interfaces.JmAbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(AbstractRecipeBookScreen.class)
public abstract class AbstractRecipeBookScreenMixin implements JmAbstractRecipeBookScreen {

	//TODO: 26.2 Either fix or remove if unnecessary
	@ModifyVariable(
			method = "<init>",
			at = @At(value = "CTOR_HEAD"),
			name = "recipeBookComponent",
			argsOnly = true
	)
	private RecipeBookComponent<?> returnJmWidgetIfPresent(RecipeBookComponent<?> recipeBookComponent) {
		RecipeBookComponent<?> jineric$recipeBookWidget = this.jineric$recipeBookWidget();
		return recipeBookComponent;
//		return jineric$recipeBookWidget != null ? jineric$recipeBookWidget : recipeBookComponent;
	}
}