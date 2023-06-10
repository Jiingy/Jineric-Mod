package jingy.jineric.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookOptions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(RecipeBookOptions.class)
public abstract class RecipeBookOptionsMixin {
   private static final RecipeBookCategory JINERIC_REFINERY = ClassTinkerers.getEnum(RecipeBookCategory.class, "JINERIC_REFINERY");

   @Mutable
   @Final
   @Shadow
   private static Map<RecipeBookCategory, Pair<String, String>> CATEGORY_OPTION_NAMES = ImmutableMap.of(
           RecipeBookCategory.CRAFTING,
           Pair.of("isGuiOpen", "isFilteringCraftable"),
           RecipeBookCategory.FURNACE,
           Pair.of("isFurnaceGuiOpen", "isFurnaceFilteringCraftable"),
           RecipeBookCategory.BLAST_FURNACE,
           Pair.of("isBlastingFurnaceGuiOpen", "isBlastingFurnaceFilteringCraftable"),
           RecipeBookCategory.SMOKER,
           Pair.of("isSmokerGuiOpen", "isSmokerFilteringCraftable"),
           JINERIC_REFINERY,
           Pair.of("isRefineryGuiOpen", "isRefineryFilteringCraftable")
   );
}
