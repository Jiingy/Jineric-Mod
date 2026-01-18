package jingy.jineric.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.recipe.FoundrySmeltingRecipe;
import net.minecraft.core.Holder;
import net.minecraft.recipebook.ServerPlaceRecipe;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
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

@Mixin(ServerPlaceRecipe.class)
public abstract class InputSlotFillerMixin<R extends net.minecraft.world.item.crafting.Recipe<?>> {
	@Shadow @Final private Inventory inventory;
	@Unique private net.minecraft.world.item.crafting.Recipe<?> recipe;
	
	@Inject(
			method = "placeRecipe(Lnet/minecraft/world/item/crafting/RecipeHolder;Lnet/minecraft/world/entity/player/StackedItemContents;)V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipebook/PlaceRecipeHelper;placeRecipe(IILnet/minecraft/world/item/crafting/Recipe;Ljava/lang/Iterable;Lnet/minecraft/recipebook/PlaceRecipeHelper$Output;)V"
			)
	)
	private void setRecipeInstance(RecipeHolder<R> recipe, StackedItemContents finder, CallbackInfo ci) {
		this.recipe = recipe.value();
	}
	
	@WrapOperation(
			method = "tryPlaceRecipe",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/entity/player/StackedItemContents;canCraft(Lnet/minecraft/world/item/crafting/Recipe;Lnet/minecraft/world/entity/player/StackedContents$Output;)Z"
			)
	)
	private boolean isOnlyCraftableIfInputCountIsAvailable(StackedItemContents instance, net.minecraft.world.item.crafting.Recipe<?> recipe, @Nullable StackedContents.Output<Holder<Item>> itemCallback, Operation<Boolean> original) {
		if (recipe instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
			return instance.canCraft(recipe, foundrySmeltingRecipe.jineric$getInputCount(), null);
		} else {
			return original.call(instance, recipe, null);
		}
	}
	
	@Definition(id = "itemStack2", local = @Local(type = ItemStack.class, ordinal = 1))
	@Expression("itemStack2")
	@Inject(
			method = "moveItemToGrid",
			at = @At(
					value = "MIXINEXTRAS:EXPRESSION"
					
			), cancellable = true
	)
	private void failInputFillIfRecipeHasInputCount(
			Slot slot, Holder<Item> item, int count, CallbackInfoReturnable<Integer> cir,
			@Local(type = ItemStack.class, ordinal = 1)ItemStack fromSlotStack
	) {
		Stream<ItemStack> stacksMatchingFromStack = this.inventory.getNonEquipmentItems().stream().filter(itemStack -> itemStack.getItem() == fromSlotStack.getItem());
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
