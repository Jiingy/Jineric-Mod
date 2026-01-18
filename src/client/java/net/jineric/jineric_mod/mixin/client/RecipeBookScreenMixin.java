package net.jineric.jineric_mod.mixin.client;

import net.jineric.jineric_mod.access.RecipeBookScreenAccess;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(AbstractRecipeBookScreen.class)
public abstract class RecipeBookScreenMixin implements RecipeBookScreenAccess {
	
	@ModifyVariable(
			method = "<init>",
			at = @At(value = "CTOR_HEAD"),
			argsOnly = true
	)
	private RecipeBookComponent<?> returnJmWidgetIfPresent(RecipeBookComponent<?> original) {
		RecipeBookComponent<?> jineric$recipeBookWidget = this.jineric$recipeBookWidget();
		return jineric$recipeBookWidget != null ? jineric$recipeBookWidget : original;
	}
}