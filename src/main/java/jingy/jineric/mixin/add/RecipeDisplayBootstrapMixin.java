package jingy.jineric.mixin.add;

import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.RecipeDisplayBootstrap;
import net.minecraft.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RecipeDisplayBootstrap.class)
public abstract class RecipeDisplayBootstrapMixin {
	@Inject(
			method = "registerAndGetDefault",
			at = @At("HEAD")
	)
	private static void addJinericRecipeDisplays(Registry<RecipeDisplay.Serializer<?>> registry, CallbackInfoReturnable<RecipeDisplay.Serializer<?>> cir) {
		Registry.register(registry, "foundry_smelting", FoundryRecipeDisplay.SERIALIZER);
	}
}
