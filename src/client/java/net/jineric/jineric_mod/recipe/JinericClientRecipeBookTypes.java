package net.jineric.jineric_mod.recipe;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;

@Environment(EnvType.CLIENT)
public class JinericClientRecipeBookTypes {
	private static final Class<SearchRecipeBookCategory> SEARCH_RECIPE_BOOK_CATEGORY_CLASS = SearchRecipeBookCategory.class;
	public static final SearchRecipeBookCategory JINERIC_REFINERY = ClassTinkerers.getEnum(SEARCH_RECIPE_BOOK_CATEGORY_CLASS, "JINERIC_REFINERY");

	public static void initialize() {}
}
