package jingy.jineric.mixin;

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
public abstract class RecipeBookOptionsMixin {
   @Mutable @Final @Shadow private static Map<RecipeBookType, Pair<String, String>> CATEGORY_OPTION_NAMES;

   static {
      CATEGORY_OPTION_NAMES = ImmutableMap.of(
              RecipeBookType.CRAFTING,
              Pair.of("isGuiOpen", "isFilteringCraftable"),
              RecipeBookType.FURNACE,
              Pair.of("isFurnaceGuiOpen", "isFurnaceFilteringCraftable"),
              RecipeBookType.BLAST_FURNACE,
              Pair.of("isBlastingFurnaceGuiOpen", "isBlastingFurnaceFilteringCraftable"),
              RecipeBookType.SMOKER,
              Pair.of("isSmokerGuiOpen", "isSmokerFilteringCraftable"),
              JinericRecipeBookTypes.JINERIC_REFINERY,
              Pair.of("isRefineryGuiOpen", "isRefineryFilteringCraftable")
      );
   }
}
