package net.jineric.jineric_mod.mixin.client;

import net.jineric.jineric_mod.access.RecipeBookScreenAccess;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(RecipeBookScreen.class)
public abstract class RecipeBookScreenMixin implements RecipeBookScreenAccess {
	
	@ModifyVariable(
			method = "<init>",
			at = @At(value = "CTOR_HEAD"),
			argsOnly = true
	)
	private RecipeBookWidget<?> returnJmWidgetIfPresent(RecipeBookWidget<?> original) {
		RecipeBookWidget<?> jineric$recipeBookWidget = this.jineric$recipeBookWidget();
		return jineric$recipeBookWidget != null ? jineric$recipeBookWidget : original;
	}
}