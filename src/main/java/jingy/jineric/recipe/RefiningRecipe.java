package jingy.jineric.recipe;

import jingy.jineric.item.JinericItems;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class RefiningRecipe extends AbstractCookingRecipe {
	public RefiningRecipe(String group, CookingBookCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
		super(group, category, input, output, experience, cookTime);
	}
	
	@Override
	protected Item furnaceIcon() {
		return JinericItems.REFINERY;
	}
	
	@Override
	public RecipeSerializer<RefiningRecipe> getSerializer() {
		return JinericRecipeSerializer.REFINING;
	}
	
	@Override
	public RecipeType<RefiningRecipe> getType() {
		return JinericRecipeTypes.REFINING;
	}
	
	@Override
	public RecipeBookCategory recipeBookCategory() {
		return switch (this.category()) {
			case BLOCKS -> JinericRecipeBookCategories.REFINERY_BLOCKS;
			case FOOD, MISC -> JinericRecipeBookCategories.REFINERY_MISC;
		};
	}
}
