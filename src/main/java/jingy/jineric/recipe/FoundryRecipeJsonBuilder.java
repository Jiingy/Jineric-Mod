package jingy.jineric.recipe;

import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

public class FoundryRecipeJsonBuilder implements RecipeBuilder {
	private final RecipeCategory category;
	private final CookingBookCategory cookingCategory;
	private final Item output;
	private final Ingredient input;
	private final int inputCount;
	private final float experience;
	private final int cookingTime;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
	@Nullable
	private String group;
	private final FoundrySmeltingRecipe.RecipeFactory recipeFactory;
	
	private FoundryRecipeJsonBuilder(
			RecipeCategory category,
			CookingBookCategory cookingCategory,
			ItemLike output,
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
			ItemLike output,
			float experience,
			int cookingTime,
			FoundrySmeltingRecipe.RecipeFactory recipeFactory
	) {
		return new FoundryRecipeJsonBuilder(category, CookingBookCategory.MISC, output, input, inputCount, experience, cookingTime, recipeFactory);
	}
	
	public static FoundryRecipeJsonBuilder createFoundrySmelting(Ingredient input, int inputCount, RecipeCategory category, ItemLike output, float experience, int cookingTime) {
		return new FoundryRecipeJsonBuilder(category, CookingBookCategory.MISC, output, input, inputCount, experience, cookingTime, FoundrySmeltingRecipe::new);
	}
	
	public FoundryRecipeJsonBuilder unlockedBy(String string, Criterion<?> advancementCriterion) {
		this.criteria.put(string, advancementCriterion);
		return this;
	}
	
	public FoundryRecipeJsonBuilder group(@Nullable String string) {
		this.group = string;
		return this;
	}
	
	@Override
	public Item getResult() {
		return this.output;
	}
	
	@Override
	public void save(RecipeOutput exporter, ResourceKey<Recipe<?>> recipeKey) {
		this.validate(recipeKey);
		Advancement.Builder builder = exporter.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeKey))
				.rewards(AdvancementRewards.Builder.recipe(recipeKey))
				.requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(builder::addCriterion);
		FoundrySmeltingRecipe foundrySmeltingRecipe = this.recipeFactory
				.create(Objects.requireNonNullElse(this.group, ""), this.cookingCategory, this.input, this.inputCount, new ItemStack(this.output), this.experience, this.cookingTime);
		exporter.accept(recipeKey, foundrySmeltingRecipe, builder.build(recipeKey.identifier().withPrefix("recipes/" + this.category.getFolderName() + "/")));
	}
	
	private void validate(ResourceKey<Recipe<?>> recipeKey) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + recipeKey.identifier());
		}
	}
}
