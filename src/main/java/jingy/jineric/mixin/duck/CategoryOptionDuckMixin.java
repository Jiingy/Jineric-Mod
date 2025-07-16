package jingy.jineric.mixin.duck;

import com.mojang.serialization.MapCodec;
import jingy.jineric.access.CategoryOptionAccess;
import net.minecraft.recipe.book.RecipeBookOptions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RecipeBookOptions.CategoryOption.class)
public abstract class CategoryOptionDuckMixin implements CategoryOptionAccess {
	//todo: BROKEN IN 1.21.7
	@Shadow @Final public static MapCodec<RecipeBookOptions.CategoryOption> CRAFTING;
	
	@Shadow
	private static MapCodec<RecipeBookOptions.CategoryOption> createCodec(String guiOpenField, String filteringCraftableField) {
		return null;
	}
}
