package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.access.RecipeBookAccess;
import net.minecraft.recipe.book.RecipeBook;
import net.minecraft.recipe.book.RecipeBookOptions;
import net.minecraft.recipe.book.RecipeBookType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RecipeBook.class)
public abstract class RecipeBookMixin implements RecipeBookAccess {
	@Unique private final boolean moddedRecipeBook = true;
	
	@WrapOperation(
			method = "isGuiOpen",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipe/book/RecipeBookOptions;isGuiOpen(Lnet/minecraft/recipe/book/RecipeBookType;)Z"
			)
	)
	private boolean isJmGuiOpen(RecipeBookOptions instance, RecipeBookType category, Operation<Boolean> original) {
		if (this.moddedRecipeBook) {
			return this.jineric$getOptions().isGuiOpen(category);
		} else {
			return original.call(instance, category);
		}
	}
	
	@WrapOperation(
			method = "setGuiOpen",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipe/book/RecipeBookOptions;setGuiOpen(Lnet/minecraft/recipe/book/RecipeBookType;Z)V"
			)
	)
	private void setJmGuiOpen(RecipeBookOptions instance, RecipeBookType category, boolean guiOpen, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setGuiOpen(category, guiOpen);
		} else {
			original.call(instance, category, guiOpen);
		}
	}
	
	@WrapOperation(
			method = "isFilteringCraftable",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipe/book/RecipeBookOptions;isFilteringCraftable(Lnet/minecraft/recipe/book/RecipeBookType;)Z"
			)
	)
	private boolean isJmFilteringCraftable(RecipeBookOptions instance, RecipeBookType category, Operation<Boolean> original) {
		if (this.moddedRecipeBook) {
			return this.jineric$getOptions().isFilteringCraftable(category);
		} else {
			return original.call(instance, category);
		}
	}
	
	@WrapOperation(
			method = "setFilteringCraftable",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipe/book/RecipeBookOptions;setFilteringCraftable(Lnet/minecraft/recipe/book/RecipeBookType;Z)V"
			)
	)
	private void setJmFilteringCraftable(RecipeBookOptions instance, RecipeBookType category, boolean filtering, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setFilteringCraftable(category, filtering);
		} else {
			original.call(instance, category, filtering);
		}
	}
	
	@WrapOperation(
			method = "setCategoryOptions",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipe/book/RecipeBookOptions;setGuiOpen(Lnet/minecraft/recipe/book/RecipeBookType;Z)V"
			)
	)
	private void setJmCategoryOptions$guiOpen(RecipeBookOptions instance, RecipeBookType category, boolean guiOpen, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setGuiOpen(category, guiOpen);
		} else {
			original.call(instance, category, guiOpen);
		}
	}
	
	@WrapOperation(
			method = "setCategoryOptions",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/recipe/book/RecipeBookOptions;setFilteringCraftable(Lnet/minecraft/recipe/book/RecipeBookType;Z)V"
			)
	)
	private void setJmCategoryOptions$filteringCraftable(RecipeBookOptions instance, RecipeBookType category, boolean filteringCraftable, Operation<Void> original) {
		if (this.moddedRecipeBook) {
			this.jineric$getOptions().setFilteringCraftable(category, filteringCraftable);
		} else {
			original.call(instance, category, filteringCraftable);
		}
	}
}
