package net.jineric.jineric_mod.gui.screen.recipebook;

import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.base.injected_interfaces.JmGhostSlots;
import net.jineric.jineric_mod.mixin.client.accessor.GhostSlotsAccessor;
import net.jineric.jineric_mod.mixin.client.accessor.RecipeBookComponentAccessor;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.FurnaceRecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.GhostSlots;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Environment(EnvType.CLIENT)
public class FoundryRecipeBookWidget extends FurnaceRecipeBookComponent {
	private static final WidgetSprites FILTER_BUTTON_TEXTURES = new WidgetSprites(
			JinericMain.ofJineric("recipe_book/foundry/filter_enabled"),
			JinericMain.ofJineric("recipe_book/foundry/filter_disabled"),
			JinericMain.ofJineric("recipe_book/foundry/filter_enabled_highlighted"),
			JinericMain.ofJineric("recipe_book/foundry/filter_disabled_highlighted")
	);
	
	public FoundryRecipeBookWidget(AbstractFurnaceMenu screenHandler, Component toggleCraftableButtonText, List<TabInfo> tabs) {
		super(screenHandler, toggleCraftableButtonText, tabs);
	}
	
	@Override
	protected WidgetSprites getFilterButtonTextures() {
		return FILTER_BUTTON_TEXTURES;
	}
	
	@Override
	public void extractTooltip(GuiGraphicsExtractor graphics, int mouseX, int mouseY, @Nullable Slot hoveredSlot) {
		if (this.isVisible()) {
			((RecipeBookComponentAccessor)this).getRecipeBookPage().extractTooltip(graphics, mouseX	, mouseY);
			((RecipeBookComponentAccessor)this).getGhostSlots().extractTooltip(graphics, this.minecraft, mouseX, mouseY, hoveredSlot);
		}
	}

	@Override
	protected void selectMatchingRecipes(RecipeCollection recipeResultCollection, StackedItemContents recipeFinder) {
		recipeResultCollection.selectRecipes(recipeFinder, recipeDisplay -> recipeDisplay instanceof FoundryRecipeDisplay);
	}
	
	@Override
	protected void fillGhostRecipe(GhostSlots ghostRecipe, RecipeDisplay recipeDisplay, ContextMap context) {
		GhostSlotsAccessor ghostSlotsAccessor = ((GhostSlotsAccessor)ghostRecipe);
		ghostSlotsAccessor.callSetResult(this.menu.getResultSlot(), context, recipeDisplay.result());
		if (recipeDisplay instanceof FoundryRecipeDisplay foundryRecipeDisplay) {
			NonNullList<Slot> screenHandlerSlots = this.menu.slots;
			((JmGhostSlots)ghostRecipe).jineric$setRecipeDisplay(recipeDisplay);
			ghostSlotsAccessor.callSetInput(screenHandlerSlots.get(0), context, foundryRecipeDisplay.ingredient());
			Slot fuelSlot = screenHandlerSlots.get(1);
			if (fuelSlot.getItem().isEmpty()) {
				ghostSlotsAccessor.callSetInput(fuelSlot, context, foundryRecipeDisplay.fuel());
			}
		}
	}
}
