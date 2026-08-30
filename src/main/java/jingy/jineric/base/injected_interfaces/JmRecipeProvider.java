package jingy.jineric.base.injected_interfaces;

import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public interface JmRecipeProvider {
	default RecipeBuilder bookshelfBuilder$jineric(Ingredient input, ItemLike output) {
		return null;
	}
	default RecipeBuilder chestBuilder$jineric(ItemLike input, ItemLike output) {
		return null;
	}
	default RecipeBuilder trappedChestBuilder$jineric(Ingredient input, ItemLike output) {
		return null;
	}
	default RecipeBuilder ladderBuilder$jineric(Ingredient input, ItemLike output) {
		return null;
	}
}
