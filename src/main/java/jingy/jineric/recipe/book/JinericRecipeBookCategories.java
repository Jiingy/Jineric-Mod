package jingy.jineric.recipe.book;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

public class JinericRecipeBookCategories {
	public final static RecipeBookCategory REFINERY_BLOCKS = register("refinery_blocks");
	public final static RecipeBookCategory REFINERY_MISC = register("refinery_misc");
	public final static RecipeBookCategory FOUNDRY = register("foundry");
	
	private static RecipeBookCategory register(String id) {
		return Registry.register(BuiltInRegistries.RECIPE_BOOK_CATEGORY, JinericMain.ofJineric(id), new RecipeBookCategory());
	}
	
	public static void initialize() {
	}
}
