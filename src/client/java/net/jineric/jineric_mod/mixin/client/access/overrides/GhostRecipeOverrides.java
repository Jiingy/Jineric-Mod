package net.jineric.jineric_mod.mixin.client.access.overrides;

import net.jineric.jineric_mod.access.GhostRecipeAccess;
import net.minecraft.client.gui.screen.recipebook.GhostRecipe;
import net.minecraft.recipe.display.RecipeDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(GhostRecipe.class)
public class GhostRecipeOverrides implements GhostRecipeAccess {
	@Unique private RecipeDisplay recipeDisplay;
	
	@Override
	public RecipeDisplay jineric$getRecipeDisplay() {
		return this.recipeDisplay;
	}
	
	@Override
	public void jineric$setRecipeDisplay(RecipeDisplay recipeDisplay) {
		this.recipeDisplay = recipeDisplay;
	}
}
