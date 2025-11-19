package jingy.jineric.mixin.change;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.mixin.access.RecipeFinderAccessor;
import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeDisplayEntry;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.display.RecipeDisplay;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;
import java.util.Optional;

@Mixin(RecipeDisplayEntry.class)
public abstract class RecipeDisplayEntryMixin {
	@Shadow @Final private Optional<List<Ingredient>> craftingRequirements;
	@Shadow @Final private RecipeDisplay display;
	
	@ModifyReturnValue(
			method = "isCraftable",
			at = @At(
					value = "RETURN"
			)
	)
	private boolean checkInputStackCountForResult(boolean original, RecipeFinder finder) {
		if (this.display instanceof FoundryRecipeDisplay foundryRecipeDisplay) {
			return this.craftingRequirements.filter(
					ingredients -> ((RecipeFinderAccessor) finder).callIsCraftable(ingredients, foundryRecipeDisplay.inputCount(), null)
			).isPresent();
		} else {
			return original;
		}
	}
}
