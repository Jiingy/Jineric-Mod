package jingy.jineric.recipe;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FoundryRecipeJsonBuilder implements CraftingRecipeJsonBuilder {
	private final RecipeCategory category;
	private final CookingRecipeCategory cookingCategory;
	private final Item output;
	private final Ingredient input;
	private final int inputCount;
	private final float experience;
	private final int cookingTime;
	private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap();
	@Nullable
	private String group;
	private final FoundrySmeltingRecipe.RecipeFactory recipeFactory;
	
	private FoundryRecipeJsonBuilder(
			RecipeCategory category,
			CookingRecipeCategory cookingCategory,
			ItemConvertible output,
			Ingredient input,
			int inputCount,
			float experience,
			int cookingTime,
			FoundrySmeltingRecipe.RecipeFactory recipeFactory
	) {
		this.category = category;
		this.cookingCategory = cookingCategory;
		this.output = output.asItem();
		this.input = input;
		this.inputCount = inputCount;
		this.experience = experience;
		this.cookingTime = cookingTime;
		this.recipeFactory = recipeFactory;
	}
	
	public static FoundryRecipeJsonBuilder create(
			Ingredient input,
			int inputCount,
			RecipeCategory category,
			ItemConvertible output,
			float experience,
			int cookingTime,
			FoundrySmeltingRecipe.RecipeFactory recipeFactory
	) {
		return new FoundryRecipeJsonBuilder(category, CookingRecipeCategory.MISC, output, input, inputCount, experience, cookingTime, recipeFactory);
	}
	
	public static FoundryRecipeJsonBuilder createFoundrySmelting(Ingredient input, int inputCount, RecipeCategory category, ItemConvertible output, float experience, int cookingTime) {
		return new FoundryRecipeJsonBuilder(category, CookingRecipeCategory.MISC, output, input, inputCount, experience, cookingTime, FoundrySmeltingRecipe::new);
	}
	
	public FoundryRecipeJsonBuilder criterion(String string, AdvancementCriterion<?> advancementCriterion) {
		this.criteria.put(string, advancementCriterion);
		return this;
	}
	
	public FoundryRecipeJsonBuilder group(@Nullable String string) {
		this.group = string;
		return this;
	}
	
	@Override
	public Item getOutputItem() {
		return this.output;
	}
	
	@Override
	public void offerTo(RecipeExporter exporter, RegistryKey<Recipe<?>> recipeKey) {
		this.validate(recipeKey);
		Advancement.Builder builder = exporter.getAdvancementBuilder()
				.criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeKey))
				.rewards(AdvancementRewards.Builder.recipe(recipeKey))
				.criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
		this.criteria.forEach(builder::criterion);
		FoundrySmeltingRecipe foundrySmeltingRecipe = this.recipeFactory
				.create(Objects.requireNonNullElse(this.group, ""), this.cookingCategory, this.input, this.inputCount, new ItemStack(this.output), this.experience, this.cookingTime);
		exporter.accept(recipeKey, foundrySmeltingRecipe, builder.build(recipeKey.getValue().withPrefixedPath("recipes/" + this.category.getName() + "/")));
	}
	
	private void validate(RegistryKey<Recipe<?>> recipeKey) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + recipeKey.getValue());
		}
	}
}
