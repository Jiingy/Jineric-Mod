package jingy.jineric.recipe;

import com.mojang.serialization.MapCodec;
import jingy.jineric.item.JinericItems;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;

public class FiringRecipe extends AbstractCookingRecipe {
    public static final MapCodec<FiringRecipe> MAP_CODEC = cookingMapCodec(FiringRecipe::new, 600);
    public static final StreamCodec<RegistryFriendlyByteBuf, FiringRecipe> STREAM_CODEC = cookingStreamCodec(FiringRecipe::new);
    public static final RecipeSerializer<FiringRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    public FiringRecipe(
            CommonInfo commonInfo,
            CookingBookInfo bookInfo,
            Ingredient ingredient,
            ItemStackTemplate result,
            float experience,
            int cookingTime
    ) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return JinericRecipeTypes.FIRING;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return switch (this.category()) {
            case FOOD, MISC -> JinericRecipeBookCategories.KILN_MISC;
            case BLOCKS -> JinericRecipeBookCategories.KILN_BLOCKS;
        };
    }

    @Override
    protected Item furnaceIcon() {
        return JinericItems.KILN;
    }
}
