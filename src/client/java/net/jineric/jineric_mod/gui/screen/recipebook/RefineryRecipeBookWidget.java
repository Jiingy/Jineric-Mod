package net.jineric.jineric_mod.gui.screen.recipebook;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookWidget;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.text.Text;

import java.util.List;

@Environment(EnvType.CLIENT)
public class RefineryRecipeBookWidget extends FurnaceRecipeBookWidget {
	private static final ButtonTextures FILTER_BUTTON_TEXTURES = new ButtonTextures(
			JinericMain.ofJineric("recipe_book/refinery/filter_enabled"),
			JinericMain.ofJineric("recipe_book/refinery/filter_disabled"),
			JinericMain.ofJineric("recipe_book/refinery/filter_enabled_highlighted"),
			JinericMain.ofJineric("recipe_book/refinery/filter_disabled_highlighted")
	);
	
	public RefineryRecipeBookWidget(AbstractFurnaceScreenHandler screenHandler, Text toggleCraftableButtonText, List<Tab> tabs) {
		super(screenHandler, toggleCraftableButtonText, tabs);
	}
	
	@Override
	protected void setBookButtonTexture() {
		this.toggleCraftableButton.setTextures(FILTER_BUTTON_TEXTURES);
	}
}
