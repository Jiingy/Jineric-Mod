package jingy.jineric.access;

import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;

public interface RecipeGeneratorAccess {
	default CraftingRecipeJsonBuilder createBookshelf$jineric(Ingredient input, ItemConvertible output) {
		return null;
	}
	default CraftingRecipeJsonBuilder createChest$jineric(Ingredient input, ItemConvertible output) {
		return null;
	}
	default CraftingRecipeJsonBuilder createTrappedChest$jineric(Ingredient input, ItemConvertible output) {
		return null;
	}
	default CraftingRecipeJsonBuilder createLadder$jineric(Ingredient input, ItemConvertible output) {
		return null;
	}
}
