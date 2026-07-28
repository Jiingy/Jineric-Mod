package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.jineric.jineric_mod.base.injected_interfaces.JmGhostSlots;
import net.minecraft.client.gui.screens.recipebook.GhostSlots;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GhostSlots.class)
public abstract class GhostSlotsMixin implements JmGhostSlots {
	
	//  TODO RECIPE BOOK: This is hardcoded to only FoundryRecipe types and only the input slot.
	//   Ideally this should work for any station, and any recipe with a stack count.
	@Definition(id = "isResultSlot", field = "Lnet/minecraft/client/gui/screens/recipebook/GhostSlots$GhostSlot;isResultSlot:Z")
	@Expression("?.isResultSlot")
	@WrapOperation(
			method = "method_62030",
			at = @At(
					value = "MIXINEXTRAS:EXPRESSION",
					ordinal = 1
			)
	)
	private boolean showItemOverlayIfInputCountHigherThanOne(
			GhostSlots.GhostSlot instance, Operation<Boolean> original,
			@Local(type = Slot.class, argsOnly = true)Slot slot,
			@Local(type = ItemStack.class, ordinal = 0)ItemStack itemStackAtIndex
	) {
		boolean originalCall = original.call(instance);
		if (
				this.jineric$getRecipeDisplay() instanceof FoundryRecipeDisplay foundryRecipeDisplay
				&& foundryRecipeDisplay.inputCount() > 1 && slot.getContainerSlot() == 0
		) {
			itemStackAtIndex.setCount(foundryRecipeDisplay.inputCount());
		}
		return itemStackAtIndex.getCount() > 1 || originalCall;
	}
}
