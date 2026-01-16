package net.jineric.jineric_mod.recipe;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;

@Environment(EnvType.CLIENT)
public class JinericClientRecipeBookTypes {
	public static final SearchRecipeBookCategory JINERIC_REFINERY = ClassTinkerers.getEnum(SearchRecipeBookCategory.class, "JINERIC_REFINERY");
	
	public static void initialize() {}
}
