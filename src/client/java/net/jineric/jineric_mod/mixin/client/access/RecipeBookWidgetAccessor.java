package net.jineric.jineric_mod.mixin.client.access;

import net.minecraft.client.gui.screen.recipebook.GhostRecipe;
import net.minecraft.client.gui.screen.recipebook.RecipeBookResults;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(RecipeBookWidget.class)
public interface RecipeBookWidgetAccessor {
	@Accessor
	RecipeBookResults getRecipesArea();
	
	@Accessor
	GhostRecipe getGhostRecipe();
}
