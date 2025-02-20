package jingy.jineric.mixin.add;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import jingy.jineric.recipe.JinericRecipeBookTypes;
import net.minecraft.recipe.book.RecipeBookOptions;
import net.minecraft.recipe.book.RecipeBookType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(RecipeBookOptions.class)
public abstract class ModifyRecipeBookOptionNamesMixin {
	@Mutable
	@Final
	@Shadow
	private static Map<RecipeBookType, Pair<String, String>> CATEGORY_OPTION_NAMES;
	
	static {
		CATEGORY_OPTION_NAMES = ImmutableMap.<RecipeBookType, Pair<String, String>>builder()
				.putAll(CATEGORY_OPTION_NAMES)
				.put(
						JinericRecipeBookTypes.JINERIC_REFINERY,
						Pair.of("isRefineryGuiOpen", "isRefineryFilteringCraftable")
				)
				.build();
	}
}
