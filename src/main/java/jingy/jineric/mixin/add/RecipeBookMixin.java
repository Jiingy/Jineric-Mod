package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.access.RecipeBookAccess;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RecipeBook.class)
public abstract class RecipeBookMixin implements RecipeBookAccess {
	@Unique private final boolean moddedRecipeBook = true;
	
	@WrapOperation(
			method = "isOpen",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;isOpen(Lnet/minecraft/world/inventory/RecipeBookType;)Z"
			)
	)
	private boolean isJmGuiOpen(RecipeBookSettings instance, RecipeBookType category, Operation<Boolean> original) {
		if (this.moddedRecipeBook) {
			return this.jineric$getOptions().isGuiOpen(category);
		} else {
			return original.call(instance, category);
		}
	}
	
	@WrapOperation(
			method = "setOpen",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;setOpen(Lnet/minecraft/world/inventory/RecipeBookType;Z)V"
			)
	)
	private void setJmGuiOpen(RecipeBookSettings instance, RecipeBookType category, boolean guiOpen, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setGuiOpen(category, guiOpen);
		} else {
			original.call(instance, category, guiOpen);
		}
	}
	
	@WrapOperation(
			method = "isFiltering",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;isFiltering(Lnet/minecraft/world/inventory/RecipeBookType;)Z"
			)
	)
	private boolean isJmFilteringCraftable(RecipeBookSettings instance, RecipeBookType category, Operation<Boolean> original) {
		if (this.moddedRecipeBook) {
			return this.jineric$getOptions().isFilteringCraftable(category);
		} else {
			return original.call(instance, category);
		}
	}
	
	@WrapOperation(
			method = "setFiltering",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;setFiltering(Lnet/minecraft/world/inventory/RecipeBookType;Z)V"
			)
	)
	private void setJmFilteringCraftable(RecipeBookSettings instance, RecipeBookType category, boolean filtering, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setFilteringCraftable(category, filtering);
		} else {
			original.call(instance, category, filtering);
		}
	}
	
	@WrapOperation(
			method = "setBookSetting",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;setOpen(Lnet/minecraft/world/inventory/RecipeBookType;Z)V"
			)
	)
	private void setJmCategoryOptions$guiOpen(RecipeBookSettings instance, RecipeBookType category, boolean guiOpen, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setGuiOpen(category, guiOpen);
		} else {
			original.call(instance, category, guiOpen);
		}
	}
	
	@WrapOperation(
			method = "setBookSetting",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;setFiltering(Lnet/minecraft/world/inventory/RecipeBookType;Z)V"
			)
	)
	private void setJmCategoryOptions$filteringCraftable(RecipeBookSettings instance, RecipeBookType category, boolean filteringCraftable, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setFilteringCraftable(category, filteringCraftable);
		} else {
			original.call(instance, category, filteringCraftable);
		}
	}
}
