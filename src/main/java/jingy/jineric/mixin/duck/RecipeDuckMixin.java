package jingy.jineric.mixin.duck;

import jingy.jineric.access.RecipeAccess;
import net.minecraft.recipe.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Recipe.class)
public interface RecipeDuckMixin extends RecipeAccess {
	
	@Unique
	@Override
	default int jineric$getInputCount() {
		return 1;
	}
}
