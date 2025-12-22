package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import jingy.jineric.screen.KilnScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.access.RecipeBookScreenAccess;
import net.jineric.jineric_mod.gui.screen.recipebook.FoundryRecipeBookWidget;
import net.jineric.jineric_mod.recipe.JinericClientRecipeBookTypes;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class KilnScreen extends AbstractFurnaceScreen<KilnScreenHandler> implements RecipeBookScreenAccess {
	private static final Identifier LIT_PROGRESS_TEXTURE = JinericMain.ofJineric("container/kiln/lit_progress");
	private static final Identifier BURN_PROGRESS_TEXTURE = JinericMain.ofJineric("container/kiln/burn_progress");
	private static final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/kiln.png");
	private static final Text TOGGLE_KILN_SMELTABLE_TEXT = Text.translatable("gui.jineric.recipe_book.toggle_recipes.kiln_smeltable");
	
	private static final List<RecipeBookWidget.Tab> TABS = List.of(
			new RecipeBookWidget.Tab(JinericClientRecipeBookTypes.JINERIC_KILN),
			new RecipeBookWidget.Tab(Items.TERRACOTTA, JinericRecipeBookCategories.KILN)
	);
	
	public KilnScreen(KilnScreenHandler handler, PlayerInventory playerInventory, Text title) {
		super(
				handler, playerInventory, title,
				TOGGLE_KILN_SMELTABLE_TEXT, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE, TABS
		);
	}
	
	@Override
	public RecipeBookWidget<?> jineric$recipeBookWidget() {
		return new FoundryRecipeBookWidget(this.handler, TOGGLE_KILN_SMELTABLE_TEXT, TABS);
	}
	
	
}
