package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.JinericRecipeBookCategories;
import jingy.jineric.screen.FoundryScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.recipe.JinericClientRecipeBookTypes;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class FoundryScreen extends AbstractFurnaceScreen<FoundryScreenHandler> {
	private static final Identifier LIT_PROGRESS_TEXTURE = JinericMain.ofJineric("container/foundry/lit_progress");
	private static final Identifier BURN_PROGRESS_TEXTURE = JinericMain.ofJineric("container/foundry/burn_progress");
	private static final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/foundry.png");
	private static final Text TOGGLE_FOUNDRY_SMELTABLE_TEXT = Text.translatable("gui.recipebook.toggleRecipes.foundry_smeltable");
	
	private static final List<RecipeBookWidget.Tab> TABS = List.of(
			new RecipeBookWidget.Tab(JinericClientRecipeBookTypes.JINERIC_FOUNDRY),
			new RecipeBookWidget.Tab(Items.COPPER_INGOT, JinericRecipeBookCategories.FOUNDRY)
	);
	
	public FoundryScreen(FoundryScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title, TOGGLE_FOUNDRY_SMELTABLE_TEXT, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE, TABS);
	}
}
