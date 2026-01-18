package jingy.jineric.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jingy.jineric.access.RecipeAccess;
import jingy.jineric.item.JinericItems;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import java.util.List;

public class FoundrySmeltingRecipe extends AbstractCookingRecipe implements RecipeAccess {
	private final int inputCount;
	
	public FoundrySmeltingRecipe(String group, CookingBookCategory category, Ingredient input, int inputCount, ItemStack output, float experience, int cookTime) {
		super(group, category, input, output, experience, cookTime);
		this.inputCount = inputCount;
	}
	
	@Override
	public int jineric$getInputCount() {
		return inputCount;
	}
	
	@Override
	public net.minecraft.world.item.crafting.RecipeSerializer<FoundrySmeltingRecipe> getSerializer() {
		return JinericRecipeSerializer.FOUNDRY_SMELTING;
	}
	
	@Override
	public net.minecraft.world.item.crafting.RecipeType<FoundrySmeltingRecipe> getType() {
		return JinericRecipeTypes.FOUNDRY_SMELTING;
	}
	
	@Override
	protected Item furnaceIcon() {
		return JinericItems.FOUNDRY;
	}
	
	@Override
	public RecipeBookCategory recipeBookCategory() {
		return JinericRecipeBookCategories.FOUNDRY;
	}
	
	@Override
	public List<RecipeDisplay> display() {
		return List.of(
				new FoundryRecipeDisplay(
						this.input().display(),
						this.inputCount,
						SlotDisplay.AnyFuel.INSTANCE,
						new SlotDisplay.ItemStackSlotDisplay(this.result()),
						new SlotDisplay.ItemSlotDisplay(this.furnaceIcon()),
						this.cookingTime(),
						this.experience()
				)
		);
	}
	
	@FunctionalInterface
	public interface RecipeFactory {
		FoundrySmeltingRecipe create(String group, CookingBookCategory category, Ingredient ingredient, int inputCount, ItemStack result, float experience, int cookingTime);
	}
	
	public static class Serializer implements net.minecraft.world.item.crafting.RecipeSerializer<FoundrySmeltingRecipe> {
		private final MapCodec<FoundrySmeltingRecipe> codec;
		private final StreamCodec<RegistryFriendlyByteBuf, FoundrySmeltingRecipe> packetCodec;
		
		public Serializer(FoundrySmeltingRecipe.RecipeFactory factory, int defaultCookingTime, int defaultInputCount) {
			this.codec = RecordCodecBuilder.mapCodec(
					instance -> instance.group(
									Codec.STRING.optionalFieldOf("group", "").forGetter(SingleItemRecipe::group),
									CookingBookCategory.CODEC.fieldOf("category").orElse(CookingBookCategory.MISC).forGetter(AbstractCookingRecipe::category),
									Ingredient.CODEC.fieldOf("ingredient").forGetter(SingleItemRecipe::input),
									Codec.INT.fieldOf("input_count").orElse(defaultInputCount).forGetter(FoundrySmeltingRecipe::jineric$getInputCount),
									ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("result").forGetter(SingleItemRecipe::result),
									Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(AbstractCookingRecipe::experience),
									Codec.INT.fieldOf("cookingtime").orElse(defaultCookingTime).forGetter(AbstractCookingRecipe::cookingTime)
							)
							.apply(instance, factory::create)
			);
			this.packetCodec = StreamCodec.composite(
					ByteBufCodecs.STRING_UTF8, SingleItemRecipe::group,
					CookingBookCategory.STREAM_CODEC, AbstractCookingRecipe::category,
					Ingredient.CONTENTS_STREAM_CODEC, SingleItemRecipe::input,
					ByteBufCodecs.INT, FoundrySmeltingRecipe::jineric$getInputCount,
					ItemStack.STREAM_CODEC, SingleItemRecipe::result,
					ByteBufCodecs.FLOAT, AbstractCookingRecipe::experience,
					ByteBufCodecs.INT, AbstractCookingRecipe::cookingTime,
					factory::create
			);
		}
		
		@Override
		public MapCodec<FoundrySmeltingRecipe> codec() {
			return this.codec;
		}
		
		@Override
		public StreamCodec<RegistryFriendlyByteBuf, FoundrySmeltingRecipe> streamCodec() {
			return this.packetCodec;
		}
	}
}
