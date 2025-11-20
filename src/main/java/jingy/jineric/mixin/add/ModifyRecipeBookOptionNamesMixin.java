package jingy.jineric.mixin.add;

import net.minecraft.recipe.book.RecipeBookOptions;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RecipeBookOptions.class)
public abstract class ModifyRecipeBookOptionNamesMixin {
	//todo: BROKEN IN 1.21.7
//	static {
//		CATEGORY_OPTION_NAMES = ImmutableMap.<RecipeBookType, Pair<String, String>>builder()
//				.putAll(CATEGORY_OPTION_NAMES)
//				.put(
//						JinericRecipeBookType.JINERIC_REFINERY,
//						Pair.of("isRefineryGuiOpen", "isRefineryFilteringCraftable")
//				)
//				.build();
//	}
}
