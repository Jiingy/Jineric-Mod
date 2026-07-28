package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import jingy.jineric.screen.KilnScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.base.injected_interfaces.JmAbstractRecipeBookScreen;
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
public class KilnScreen extends AbstractFurnaceScreen<KilnScreenHandler> implements JmAbstractRecipeBookScreen {
	private static final Identifier LIT_PROGRESS_TEXTURE = JinericMain.ofJineric("container/kiln/lit_progress");
	private static final Identifier BURN_PROGRESS_TEXTURE = JinericMain.ofJineric("container/kiln/burn_progress");
	private static final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/kiln.png");
	private static final Component TOGGLE_KILN_SMELTABLE_TEXT = Component.translatable("gui.jineric.recipe_book.toggle_recipes.kiln_smeltable");
	
	private static final List<RecipeBookComponent.TabInfo> TABS = List.of(
			new RecipeBookComponent.TabInfo(JinericClientRecipeBookTypes.JINERIC_KILN),
			new RecipeBookComponent.TabInfo(Items.TERRACOTTA, JinericRecipeBookCategories.KILN)
	);
	
	public KilnScreen(KilnScreenHandler handler, Inventory playerInventory, Component title) {
		super(
				handler, playerInventory, title,
				TOGGLE_KILN_SMELTABLE_TEXT, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE, TABS
		);
	}
	
	@Override
	public RecipeBookComponent<?> jineric$recipeBookWidget() {
		return new FoundryRecipeBookWidget(this.menu, TOGGLE_KILN_SMELTABLE_TEXT, TABS);
	}
	
	
}
