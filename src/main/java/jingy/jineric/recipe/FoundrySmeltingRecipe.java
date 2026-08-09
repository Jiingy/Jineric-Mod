package jingy.jineric.recipe;

import com.mojang.serialization.MapCodec;
import jingy.jineric.item.JinericItems;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;

public class FoundrySmeltingRecipe extends AbstractCookingRecipe {
	public static final MapCodec<FoundrySmeltingRecipe> MAP_CODEC = cookingMapCodec(FoundrySmeltingRecipe::new, 100);
	public static final StreamCodec<RegistryFriendlyByteBuf, FoundrySmeltingRecipe> STREAM_CODEC = cookingStreamCodec(FoundrySmeltingRecipe::new);
	public static final RecipeSerializer<FoundrySmeltingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

	public FoundrySmeltingRecipe(
			CommonInfo commonInfo,
			CookingBookInfo bookInfo,
			Ingredient ingredient,
			ItemStackTemplate result,
			float experience,
			int cookTime
	) {
		super(commonInfo, bookInfo, ingredient, result, experience, cookTime);
	}
	
	@Override
	protected Item furnaceIcon() {
		return JinericItems.FOUNDRY;
	}

	@Override
	public RecipeSerializer<FoundrySmeltingRecipe> getSerializer() {
		return SERIALIZER;
	}

	@Override
	public RecipeType<FoundrySmeltingRecipe> getType() {
		return JinericRecipeTypes.FOUNDRY_SMELTING;
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return JinericRecipeBookCategories.FOUNDRY;
	}
	
	@FunctionalInterface
	public interface RecipeFactory {
		FoundrySmeltingRecipe create(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime);
	}
}
