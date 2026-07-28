package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.base.injected_interfaces.JmRecipeBook;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RecipeBook.class)
public abstract class RecipeBookMixin implements JmRecipeBook {
	@Unique private final boolean moddedRecipeBook = true;
	
	@WrapOperation(
			method = "isOpen",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;isOpen(Lnet/minecraft/world/inventory/RecipeBookType;)Z"
			)
	)
	private boolean isJmGuiOpen(RecipeBookSettings instance, RecipeBookType type, Operation<Boolean> original) {
		if (this.moddedRecipeBook) {
			return this.jineric$getOptions().isGuiOpen(type);
		} else {
			return original.call(instance, type);
		}
	}
	
	@WrapOperation(
			method = "setOpen",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;setOpen(Lnet/minecraft/world/inventory/RecipeBookType;Z)V"
			)
	)
	private void setJmGuiOpen(RecipeBookSettings instance, RecipeBookType type, boolean _open, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setGuiOpen(type, _open);
		} else {
			original.call(instance, type, _open);
		}
	}
	
	@WrapOperation(
			method = "isFiltering",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;isFiltering(Lnet/minecraft/world/inventory/RecipeBookType;)Z"
			)
	)
	private boolean isJmFilteringCraftable(RecipeBookSettings instance, RecipeBookType type, Operation<Boolean> original) {
		if (this.moddedRecipeBook) {
			return this.jineric$getOptions().isFilteringCraftable(type);
		} else {
			return original.call(instance, type);
		}
	}
	
	@WrapOperation(
			method = "setFiltering",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;setFiltering(Lnet/minecraft/world/inventory/RecipeBookType;Z)V"
			)
	)
	private void setJmFilteringCraftable(RecipeBookSettings instance, RecipeBookType type, boolean filtering, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setFilteringCraftable(type, filtering);
		} else {
			original.call(instance, type, filtering);
		}
	}
	
	@WrapOperation(
			method = "setBookSetting",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;setOpen(Lnet/minecraft/world/inventory/RecipeBookType;Z)V"
			)
	)
	private void setJmCategoryOptions$guiOpen(RecipeBookSettings instance, RecipeBookType type, boolean _open, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setGuiOpen(type, _open);
		} else {
			original.call(instance, type, _open);
		}
	}
	
	@WrapOperation(
			method = "setBookSetting",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/stats/RecipeBookSettings;setFiltering(Lnet/minecraft/world/inventory/RecipeBookType;Z)V"
			)
	)
	private void setJmCategoryOptions$filteringCraftable(RecipeBookSettings instance, RecipeBookType type, boolean filtering, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setFilteringCraftable(type, filtering);
		} else {
			original.call(instance, type, filtering);
		}
	}
}
