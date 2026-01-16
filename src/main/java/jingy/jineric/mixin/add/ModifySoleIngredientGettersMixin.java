package jingy.jineric.mixin.add;

import com.google.common.collect.ImmutableMap;
import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.world.item.crafting.RecipeAccess;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(RecipeManager.class)
public abstract class ModifySoleIngredientGettersMixin extends SimplePreparableReloadListener<RecipeMap> implements RecipeAccess {
	@Mutable
	@Shadow
	@Final
	private static Map<ResourceKey<RecipePropertySet>, RecipeManager.IngredientExtractor> RECIPE_PROPERTY_SETS;
	
	static {
		RECIPE_PROPERTY_SETS = ImmutableMap.<ResourceKey<RecipePropertySet>, RecipeManager.IngredientExtractor>builder()
				.putAll(RECIPE_PROPERTY_SETS)
				.put(
						JinericRecipePropertySet.REFINERY_INPUT,
						forSingleInput(JinericRecipeTypes.REFINING)
				)
				.build();
	}
	
	@Shadow
	private static RecipeManager.IngredientExtractor forSingleInput(RecipeType<? extends SingleItemRecipe> expectedType) {
		return null;
	}
}
