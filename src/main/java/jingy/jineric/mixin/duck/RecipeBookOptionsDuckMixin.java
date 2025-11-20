package jingy.jineric.mixin.duck;

import jingy.jineric.access.RecipeBookOptionsAccess;
import jingy.jineric.recipe.book.JinericRecipeBookTypes;
import net.minecraft.recipe.book.RecipeBookOptions;
import net.minecraft.recipe.book.RecipeBookType;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.UnaryOperator;

@Mixin(RecipeBookOptions.class)
public class RecipeBookOptionsDuckMixin implements RecipeBookOptionsAccess {
	//todo: BROKEN IN 1.21.7
	@Unique private RecipeBookOptions.CategoryOption refinery;
	@Unique private RecipeBookOptions.CategoryOption refineryConstructor;
	
	@Unique
	public void assignRefinery(RecipeBookOptions.CategoryOption refinery) {
		this.refinery = refinery;
	}
	
	@Shadow private RecipeBookOptions.CategoryOption crafting;
	@Shadow private RecipeBookOptions.CategoryOption furnace;
	@Shadow private RecipeBookOptions.CategoryOption blastFurnace;
	@Shadow private RecipeBookOptions.CategoryOption smoker;
	
	@Override
	public RecipeBookOptions.CategoryOption jineric_mod$getRefinery() {
		return this.refinery;
	}
	@Override
	public RecipeBookOptions.CategoryOption jineric_mod$getCrafting() {
		return this.crafting;
	}
	@Override
	public RecipeBookOptions.CategoryOption jineric_mod$getFurnace() {
		return this.furnace;
	}
	@Override
	public RecipeBookOptions.CategoryOption jineric_mod$getBlastFurnace() {
		return this.blastFurnace;
	}
	@Override
	public RecipeBookOptions.CategoryOption jineric_mod$getSmoker() {
		return this.smoker;
	}
	
	@Inject(
			method = "<init>(Lnet/minecraft/recipe/book/RecipeBookOptions$CategoryOption;Lnet/minecraft/recipe/book/RecipeBookOptions$CategoryOption;Lnet/minecraft/recipe/book/RecipeBookOptions$CategoryOption;Lnet/minecraft/recipe/book/RecipeBookOptions$CategoryOption;)V",
			at = @At("TAIL")
	)
	private void init(RecipeBookOptions.CategoryOption crafting, RecipeBookOptions.CategoryOption furnace, RecipeBookOptions.CategoryOption blastFurnace, RecipeBookOptions.CategoryOption smoker, CallbackInfo ci) {
//		this.refinery = this.assignRefinery(RecipeBookOptions.CategoryOption.DEFAULT);
	}
	
	@Inject(
			method = "getOption",
			at = @At(value = "HEAD"),
			cancellable = true
	)
	private void getRefineryOption(RecipeBookType type, CallbackInfoReturnable<RecipeBookOptions.CategoryOption> cir) {
		if (type.equals(JinericRecipeBookTypes.JINERIC_REFINERY)) {
			cir.setReturnValue(this.blastFurnace);
			cir.cancel();
		}
	}
	
	@Inject(
			method = "apply",
			at = @At(value = "HEAD"),
			cancellable = true
	)
	private void caseRefinery(RecipeBookType type, UnaryOperator<RecipeBookOptions.CategoryOption> modifier, CallbackInfo ci) {
		if (type.equals(JinericRecipeBookTypes.JINERIC_REFINERY)) {
//			this.refinery = modifier.apply(this.jineric_mod$getRefinery());
			ci.cancel();
		}
	}
	
		@Inject(
			method = "copyFrom",
			at = @At(
					value = "HEAD"
			)
	)
	private void copyRefinery(RecipeBookOptions other, CallbackInfo ci) {
//		this.refinery = other.jineric_mod$getRefinery();
	}
}