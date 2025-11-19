package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.jineric.jineric_mod.access.GhostRecipeAccess;
import net.minecraft.client.gui.screen.recipebook.GhostRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GhostRecipe.class)
public abstract class GhostRecipeMixin implements GhostRecipeAccess {
	
	//  TODO RECIPE BOOK: This is hardcoded to only FoundryRecipe types and only the input slot.
	//   Ideally this should work for any station, and any recipe with a stack count.
	@Definition(id = "isResultSlot", field = "Lnet/minecraft/client/gui/screen/recipebook/GhostRecipe$CyclingItem;isResultSlot:Z")
	@Expression("?.isResultSlot")
	@WrapOperation(
			method = "method_62030",
			at = @At(
					value = "MIXINEXTRAS:EXPRESSION",
					ordinal = 1
			)
	)
	private boolean showItemOverlayIfInputCountHigherThanOne(
			GhostRecipe.CyclingItem instance, Operation<Boolean> original,
			@Local(type = Slot.class, argsOnly = true)Slot slot,
			@Local(type = ItemStack.class, ordinal = 0)ItemStack itemStackAtIndex
	) {
		boolean originalCall = original.call(instance);
		if (
				this.jineric$getRecipeDisplay() instanceof FoundryRecipeDisplay foundryRecipeDisplay
				&& foundryRecipeDisplay.inputCount() > 1 && slot.getIndex() == 0
		) {
			itemStackAtIndex.setCount(foundryRecipeDisplay.inputCount());
		}
		return itemStackAtIndex.getCount() > 1 || originalCall;
	}
}
