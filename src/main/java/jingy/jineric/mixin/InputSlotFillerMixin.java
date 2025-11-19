package jingy.jineric.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.recipe.FoundrySmeltingRecipe;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.stream.Stream;

@Mixin(InputSlotFiller.class)
public abstract class InputSlotFillerMixin<R extends Recipe<?>> {
	@Shadow @Final private PlayerInventory inventory;
	@Unique private Recipe<?> recipe;
	
	@Inject(
			method = "fill(Lnet/minecraft/recipe/RecipeEntry;Lnet/minecraft/recipe/RecipeFinder;)V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipe/RecipeGridAligner;alignRecipeToGrid(IILnet/minecraft/recipe/Recipe;Ljava/lang/Iterable;Lnet/minecraft/recipe/RecipeGridAligner$Filler;)V"
			)
	)
	private void setRecipeInstance(RecipeEntry<R> recipe, RecipeFinder finder, CallbackInfo ci) {
		this.recipe = recipe.value();
	}
	
	@WrapOperation(
			method = "tryFill",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipe/RecipeFinder;isCraftable(Lnet/minecraft/recipe/Recipe;Lnet/minecraft/recipe/RecipeMatcher$ItemCallback;)Z"
			)
	)
	private boolean isOnlyCraftableIfInputCountIsAvailable(RecipeFinder instance, Recipe<?> recipe, @Nullable RecipeMatcher.ItemCallback<RegistryEntry<Item>> itemCallback, Operation<Boolean> original) {
		if (recipe instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
			return instance.isCraftable(recipe, foundrySmeltingRecipe.jineric$getInputCount(), null);
		} else {
			return original.call(instance, recipe, null);
		}
	}
	
	@Definition(id = "itemStack2", local = @Local(type = ItemStack.class, ordinal = 1))
	@Expression("itemStack2")
	@Inject(
			method = "fillInputSlot",
			at = @At(
					value = "MIXINEXTRAS:EXPRESSION"
					
			), cancellable = true
	)
	private void failInputFillIfRecipeHasInputCount(
			Slot slot, RegistryEntry<Item> item, int count, CallbackInfoReturnable<Integer> cir,
			@Local(type = ItemStack.class, ordinal = 1)ItemStack fromSlotStack
	) {
		Stream<ItemStack> stacksMatchingFromStack = this.inventory.getMainStacks().stream().filter(itemStack -> itemStack.getItem() == fromSlotStack.getItem());
		int itemsMatchingFromStack = 0;
		for (ItemStack stack : stacksMatchingFromStack.toList()) {
			itemsMatchingFromStack += stack.getCount();
		}
		if (this.recipe instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
			if (itemsMatchingFromStack < foundrySmeltingRecipe.jineric$getInputCount()) {
				cir.setReturnValue(-1);
			}
		}
	}
}
