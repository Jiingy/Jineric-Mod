package jingy.jineric.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookOptions;
import net.minecraft.recipe.book.RecipeBookType;
import org.spongepowered.asm.mixin.*;

import java.util.Map;

@Mixin(RecipeBookOptions.class)
public abstract class RecipeBookOptionsMixin {
   @Unique private static final RecipeBookType JINERIC_REFINERY = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_REFINERY");

   @Mutable
   @Final
   @Shadow
   private static Map<RecipeBookType, Pair<String, String>> CATEGORY_OPTION_NAMES;

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
              JINERIC_REFINERY,
              Pair.of("isRefineryGuiOpen", "isRefineryFilteringCraftable")
      );
   }
}
