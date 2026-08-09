package jingy.jineric.mixin.change;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.RecipeDisplayEntry;
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

	//TODO: 26.2 Fix or remove
	@ModifyReturnValue(
			method = "canCraft",
			at = @At(
					value = "RETURN"
			)
	)
	private boolean checkInputStackCountForResult(boolean original, StackedItemContents providedContents) {
//		if (this.display instanceof FoundryRecipeDisplay foundryRecipeDisplay) {
//			return this.craftingRequirements.filter(
//					ingredients -> ((RecipeFinderAccessor) providedContents).invokeCanCraft(ingredients, foundryRecipeDisplay.inputCount(), null)
//			).isPresent();
//		} else {
			return original;
//		}
	}
}
