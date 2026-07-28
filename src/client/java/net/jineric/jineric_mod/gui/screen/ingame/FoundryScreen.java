package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import jingy.jineric.screen.FoundryScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.access.JmAbstractRecipeBookScreen;
import net.jineric.jineric_mod.gui.screen.recipebook.FoundryRecipeBookWidget;
import net.jineric.jineric_mod.recipe.JinericClientRecipeBookTypes;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;

import java.util.List;

@Environment(EnvType.CLIENT)
public class FoundryScreen extends AbstractFurnaceScreen<FoundryScreenHandler> implements JmAbstractRecipeBookScreen {
	private static final Identifier LIT_PROGRESS_TEXTURE = JinericMain.ofJineric("container/foundry/lit_progress");
	private static final Identifier BURN_PROGRESS_TEXTURE = JinericMain.ofJineric("container/foundry/burn_progress");
	private static final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/foundry.png");
	private static final Component TOGGLE_FOUNDRY_SMELTABLE_TEXT = Component.translatable("gui.jineric.recipe_book.toggle_recipes.foundry_smeltable");
	
	private static final List<RecipeBookComponent.TabInfo> TABS = List.of(
			new RecipeBookComponent.TabInfo(JinericClientRecipeBookTypes.JINERIC_FOUNDRY),
			new RecipeBookComponent.TabInfo(Items.COPPER_INGOT, JinericRecipeBookCategories.FOUNDRY)
	);
	
	public FoundryScreen(FoundryScreenHandler handler, Inventory inventory, Component title) {
		super(handler, inventory, title, TOGGLE_FOUNDRY_SMELTABLE_TEXT, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE, TABS);
	}
	
	@Override
	public RecipeBookComponent<?> jineric$recipeBookWidget() {
		return new FoundryRecipeBookWidget(this.menu, TOGGLE_FOUNDRY_SMELTABLE_TEXT, TABS);
	}
}
