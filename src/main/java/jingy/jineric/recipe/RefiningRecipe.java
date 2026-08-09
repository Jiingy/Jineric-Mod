package jingy.jineric.recipe;

import com.mojang.serialization.MapCodec;
import jingy.jineric.item.JinericItems;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;

public class RefiningRecipe extends AbstractCookingRecipe {
	public static final MapCodec<RefiningRecipe> MAP_CODEC = cookingMapCodec(RefiningRecipe::new, 100);
	public static final StreamCodec<RegistryFriendlyByteBuf, RefiningRecipe> STREAM_CODEC = cookingStreamCodec(RefiningRecipe::new);
	public static final RecipeSerializer<RefiningRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

	public RefiningRecipe(
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
		return JinericItems.REFINERY;
	}
	
	@Override
	public RecipeSerializer<RefiningRecipe> getSerializer() {
		return SERIALIZER;
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
