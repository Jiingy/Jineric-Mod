package net.jineric.jineric_mod.gui.screen.recipebook;

import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.access.GhostRecipeAccess;
import net.jineric.jineric_mod.mixin.client.access.GhostRecipeAccessor;
import net.jineric.jineric_mod.mixin.client.access.RecipeBookWidgetAccessor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookWidget;
import net.minecraft.client.gui.screen.recipebook.GhostRecipe;
import net.minecraft.client.gui.screen.recipebook.RecipeResultCollection;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.context.ContextParameterMap;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Environment(EnvType.CLIENT)
public class FoundryRecipeBookWidget extends FurnaceRecipeBookWidget {
	private static final ButtonTextures FILTER_BUTTON_TEXTURES = new ButtonTextures(
			JinericMain.ofJineric("recipe_book/foundry/filter_enabled"),
			JinericMain.ofJineric("recipe_book/foundry/filter_disabled"),
			JinericMain.ofJineric("recipe_book/foundry/filter_enabled_highlighted"),
			JinericMain.ofJineric("recipe_book/foundry/filter_disabled_highlighted")
	);
	
	public FoundryRecipeBookWidget(AbstractFurnaceScreenHandler screenHandler, Text toggleCraftableButtonText, List<Tab> tabs) {
		super(screenHandler, toggleCraftableButtonText, tabs);
	}
	
	@Override
	protected void setBookButtonTexture() {
		this.toggleCraftableButton.setTextures(FILTER_BUTTON_TEXTURES);
	}
	
	@Override
	public void drawTooltip(DrawContext context, int x, int y, @Nullable Slot slot) {
		if (this.isOpen()) {
			((RecipeBookWidgetAccessor)this).getRecipesArea().drawTooltip(context, x, y);
			((RecipeBookWidgetAccessor)this).getGhostRecipe().drawTooltip(context, this.client, x, y, slot);
		}
	}
	
	@Override
	protected void populateRecipes(RecipeResultCollection recipeResultCollection, RecipeFinder recipeFinder) {
		recipeResultCollection.populateRecipes(recipeFinder, recipeDisplay -> recipeDisplay instanceof FoundryRecipeDisplay);
	}
	
	@Override
	protected void showGhostRecipe(GhostRecipe ghostRecipe, RecipeDisplay recipeDisplay, ContextParameterMap context) {
		GhostRecipeAccessor ghostRecipeAccessor = ((GhostRecipeAccessor)ghostRecipe);
		ghostRecipeAccessor.callAddResults(this.craftingScreenHandler.getOutputSlot(), context, recipeDisplay.result());
		if (recipeDisplay instanceof FoundryRecipeDisplay foundryRecipeDisplay) {
			DefaultedList<Slot> screenHandlerSlots = this.craftingScreenHandler.slots;
			((GhostRecipeAccess)ghostRecipe).jineric$setRecipeDisplay(recipeDisplay);
			ghostRecipeAccessor.callAddInputs(screenHandlerSlots.get(0), context, foundryRecipeDisplay.ingredient());
			Slot fuelSlot = screenHandlerSlots.get(1);
			if (fuelSlot.getStack().isEmpty()) {
				ghostRecipeAccessor.callAddInputs(fuelSlot, context, foundryRecipeDisplay.fuel());
			}
		}
	}
}
