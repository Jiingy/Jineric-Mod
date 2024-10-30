package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class JinericRecipeBookCategories {
    List<RecipeBookCategory> recipeBookCategories;

    public final static RecipeBookCategory REFINERY_BLOCKS = register("refinery_blocks");
    public final static RecipeBookCategory REFINERY_MISC = register("refinery_misc");

    private static RecipeBookCategory register(String id) {
        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, Identifier.of(JinericMain.MOD_ID, id), new RecipeBookCategory());
    }

    public static void registerRecipeBookCategories() {

    }
}
