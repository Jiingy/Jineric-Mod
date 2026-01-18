package net.jineric.jineric_mod.gui.screen.recipebook;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.FurnaceRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import java.util.List;

@Environment(EnvType.CLIENT)
public class RefineryRecipeBookWidget extends FurnaceRecipeBookComponent {
	private static final WidgetSprites FILTER_BUTTON_TEXTURES = new WidgetSprites(
			JinericMain.ofJineric("recipe_book/refinery/filter_enabled"),
			JinericMain.ofJineric("recipe_book/refinery/filter_disabled"),
			JinericMain.ofJineric("recipe_book/refinery/filter_enabled_highlighted"),
			JinericMain.ofJineric("recipe_book/refinery/filter_disabled_highlighted")
	);
	
	public RefineryRecipeBookWidget(AbstractFurnaceMenu screenHandler, Component toggleCraftableButtonText, List<TabInfo> tabs) {
		super(screenHandler, toggleCraftableButtonText, tabs);
	}
	
	@Override
	protected WidgetSprites getFilterButtonTextures() {
		return FILTER_BUTTON_TEXTURES;
	}
}
