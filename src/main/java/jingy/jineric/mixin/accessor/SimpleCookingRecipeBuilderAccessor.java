package jingy.jineric.mixin.accessor;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SimpleCookingRecipeBuilder.class)
public interface SimpleCookingRecipeBuilderAccessor {
	
	@Invoker("<init>")
	static SimpleCookingRecipeBuilder invokeInit(
			RecipeCategory category,
			CookingBookCategory cookingCategory,
			ItemLike output,
			Ingredient input,
			float experience,
			int cookingTime,
			AbstractCookingRecipe.Factory<?> recipeFactory
	) {
		throw new IllegalStateException("Could not invoke <init>() in WoodType!");
	}
}
