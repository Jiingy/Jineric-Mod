package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import jingy.jineric.screen.RefineryScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.gui.screen.recipebook.RefineryRecipeBookWidget;
import net.jineric.jineric_mod.recipe.JinericClientRecipeBookTypes;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;

import java.util.List;

@Environment(EnvType.CLIENT)
public class RefineryScreen extends AbstractFurnaceScreen<RefineryScreenHandler> {
	private static final Identifier LIT_PROGRESS_TEXTURE = JinericMain.ofJineric("container/refinery/lit_progress");
	private static final Identifier BURN_PROGRESS_TEXTURE = JinericMain.ofJineric("container/refinery/burn_progress");
	private static final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/refinery.png");
	private static final Component TOGGLE_REFINABLE_TEXT = Component.translatable("gui.jineric.recipe_book.toggle_recipes.refinable");
	private static final List<RecipeBookComponent.TabInfo> TABS = List.of(
			new RecipeBookComponent.TabInfo(JinericClientRecipeBookTypes.JINERIC_REFINERY),
			new RecipeBookComponent.TabInfo(Items.STONE, JinericRecipeBookCategories.REFINERY_BLOCKS),
			new RecipeBookComponent.TabInfo(Items.GLAZED_TERRACOTTA.cyan(), JinericRecipeBookCategories.REFINERY_MISC)
	);
	
	public RefineryScreen(RefineryScreenHandler container, Inventory inventory, Component title) {
		super(container, inventory, title, TOGGLE_REFINABLE_TEXT, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE, TABS);
	}
	
	@Override
	public RecipeBookComponent<?> jineric$recipeBookWidget() {
		return new RefineryRecipeBookWidget(this.menu, TOGGLE_REFINABLE_TEXT, TABS);
	}
}
