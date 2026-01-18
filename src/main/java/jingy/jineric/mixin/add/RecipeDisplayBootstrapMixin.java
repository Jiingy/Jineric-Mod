package jingy.jineric.mixin.add;

import jingy.jineric.recipe.display.FoundryRecipeDisplay;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.RecipeDisplays;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RecipeDisplays.class)
public abstract class RecipeDisplayBootstrapMixin {
	@Inject(
			method = "bootstrap",
			at = @At("HEAD")
	)
	private static void addJinericRecipeDisplays(Registry<RecipeDisplay.Type<?>> registry, CallbackInfoReturnable<RecipeDisplay.Type<?>> cir) {
		Registry.register(registry, "foundry_smelting", FoundryRecipeDisplay.SERIALIZER);
	}
}
