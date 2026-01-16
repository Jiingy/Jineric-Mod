package net.jineric.jineric_mod.mixin.client.access.overrides;

import net.jineric.jineric_mod.access.RecipeBookScreenAccess;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(RecipeBookScreen.class)
public abstract class RecipeBookScreenOverrides implements RecipeBookScreenAccess {
	@Unique
	@Override
	public RecipeBookWidget<?> jineric$recipeBookWidget() {
		return null;
	}
}