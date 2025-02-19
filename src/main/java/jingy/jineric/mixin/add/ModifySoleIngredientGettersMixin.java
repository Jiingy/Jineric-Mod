package jingy.jineric.mixin.add;

import com.google.common.collect.ImmutableMap;
import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;
import net.minecraft.recipe.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.resource.SinglePreparationResourceReloader;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(ServerRecipeManager.class)
public abstract class ModifySoleIngredientGettersMixin extends SinglePreparationResourceReloader<PreparedRecipes> implements RecipeManager {
	@Mutable
	@Shadow
	@Final
	private static Map<RegistryKey<RecipePropertySet>, ServerRecipeManager.SoleIngredientGetter> SOLE_INGREDIENT_GETTERS;
	
	static {
		SOLE_INGREDIENT_GETTERS = ImmutableMap.<RegistryKey<RecipePropertySet>, ServerRecipeManager.SoleIngredientGetter>builder()
				.putAll(SOLE_INGREDIENT_GETTERS)
				.put(
						JinericRecipePropertySet.REFINERY_INPUT,
						cookingIngredientGetter(JinericRecipeTypes.REFINING)
				)
				.build();
	}
	
	@Shadow
	private static ServerRecipeManager.SoleIngredientGetter cookingIngredientGetter(RecipeType<? extends SingleStackRecipe> expectedType) {
		return null;
	}
}
