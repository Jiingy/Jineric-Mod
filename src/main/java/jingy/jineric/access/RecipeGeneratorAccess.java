package jingy.jineric.access;

import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public interface RecipeGeneratorAccess {
	default RecipeBuilder bookshelfBuilder$jineric(Ingredient input, ItemLike output) {
		return null;
	}
	default RecipeBuilder chestBuilder$jineric(Ingredient input, ItemLike output) {
		return null;
	}
	default RecipeBuilder trappedChestBuilder$jineric(Ingredient input, ItemLike output) {
		return null;
	}
	default RecipeBuilder ladderBuilder$jineric(Ingredient input, ItemLike output) {
		return null;
	}
}
