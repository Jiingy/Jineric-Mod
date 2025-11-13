package jingy.jineric.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jingy.jineric.item.JinericItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeBookCategory;

public class FoundrySmeltingRecipe extends AbstractCookingRecipe {
	private final int inputCount;
	
	public FoundrySmeltingRecipe(String group, CookingRecipeCategory category, Ingredient input, int inputCount, ItemStack output, float experience, int cookTime) {
		super(group, category, input, output, experience, cookTime);
		this.inputCount = inputCount;
	}
	
	public int getInputCount() {
		return inputCount;
	}
	
	@Override
	public RecipeSerializer<FoundrySmeltingRecipe> getSerializer() {
		return JinericRecipeSerializer.FOUNDRY_SMELTING;
	}
	
	@Override
	public RecipeType<FoundrySmeltingRecipe> getType() {
		return JinericRecipeTypes.FOUNDRY_SMELTING;
	}
	
	@Override
	protected Item getCookerItem() {
		return JinericItems.FOUNDRY;
	}
	
	@Override
	public RecipeBookCategory getRecipeBookCategory() {
		return JinericRecipeBookCategories.FOUNDRY;
	}
	
	@FunctionalInterface
	public interface RecipeFactory {
		FoundrySmeltingRecipe create(String group, CookingRecipeCategory category, Ingredient ingredient, int inputCount, ItemStack result, float experience, int cookingTime);
	}
	
	public static class Serializer implements RecipeSerializer<FoundrySmeltingRecipe> {
		private final MapCodec<FoundrySmeltingRecipe> codec;
		private final PacketCodec<RegistryByteBuf, FoundrySmeltingRecipe> packetCodec;
		
		public Serializer(FoundrySmeltingRecipe.RecipeFactory factory, int defaultCookingTime, int defaultInputCount) {
			this.codec = RecordCodecBuilder.mapCodec(
					instance -> instance.group(
									Codec.STRING.optionalFieldOf("group", "").forGetter(SingleStackRecipe::getGroup),
									CookingRecipeCategory.CODEC.fieldOf("category").orElse(CookingRecipeCategory.MISC).forGetter(AbstractCookingRecipe::getCategory),
									Ingredient.CODEC.fieldOf("ingredient").forGetter(SingleStackRecipe::ingredient),
									Codec.INT.fieldOf("input_count").orElse(defaultInputCount).forGetter(FoundrySmeltingRecipe::getInputCount),
									ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf("result").forGetter(SingleStackRecipe::result),
									Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(AbstractCookingRecipe::getExperience),
									Codec.INT.fieldOf("cookingtime").orElse(defaultCookingTime).forGetter(AbstractCookingRecipe::getCookingTime)
							)
							.apply(instance, factory::create)
			);
			this.packetCodec = PacketCodec.tuple(
					PacketCodecs.STRING, SingleStackRecipe::getGroup,
					CookingRecipeCategory.PACKET_CODEC, AbstractCookingRecipe::getCategory,
					Ingredient.PACKET_CODEC, SingleStackRecipe::ingredient,
					PacketCodecs.INTEGER, FoundrySmeltingRecipe::getInputCount,
					ItemStack.PACKET_CODEC, SingleStackRecipe::result,
					PacketCodecs.FLOAT, AbstractCookingRecipe::getExperience,
					PacketCodecs.INTEGER, AbstractCookingRecipe::getCookingTime,
					factory::create
			);
		}
		
		@Override
		public MapCodec<FoundrySmeltingRecipe> codec() {
			return this.codec;
		}
		
		@Override
		public PacketCodec<RegistryByteBuf, FoundrySmeltingRecipe> packetCodec() {
			return this.packetCodec;
		}
	}
}
