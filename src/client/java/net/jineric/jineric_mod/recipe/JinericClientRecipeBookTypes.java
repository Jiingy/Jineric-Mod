package net.jineric.jineric_mod.recipe;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class JinericClientRecipeBookTypes {
	private static final Class<net.minecraft.client.recipebook.RecipeBookType> RECIPE_BOOK_TYPE_CLASS = net.minecraft.client.recipebook.RecipeBookType.class;
	public static final net.minecraft.client.recipebook.RecipeBookType JINERIC_REFINERY = ClassTinkerers.getEnum(RECIPE_BOOK_TYPE_CLASS, "JINERIC_REFINERY");
	public static final net.minecraft.client.recipebook.RecipeBookType JINERIC_FOUNDRY = ClassTinkerers.getEnum(RECIPE_BOOK_TYPE_CLASS, "JINERIC_FOUNDRY");
	public static final net.minecraft.client.recipebook.RecipeBookType JINERIC_KILN = ClassTinkerers.getEnum(RECIPE_BOOK_TYPE_CLASS, "JINERIC_KILN");
	
	public static void initialize() {}
}
