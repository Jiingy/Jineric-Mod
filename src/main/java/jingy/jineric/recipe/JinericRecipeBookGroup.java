package jingy.jineric.recipe;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.recipebook.RecipeBookGroup;

import java.util.List;

public class JinericRecipeBookGroup {
   private static final RecipeBookGroup JINERIC_REFINERY_SEARCH = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_SEARCH");
   private static final RecipeBookGroup JINERIC_REFINERY_BUILDING = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_BUILDING");
   private static final RecipeBookGroup JINERIC_REFINERY_MISC = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_MISC");
   public static final List<RecipeBookGroup> JINERIC_REFINERY = ImmutableList.of(JINERIC_REFINERY_SEARCH, JINERIC_REFINERY_BUILDING, JINERIC_REFINERY_MISC);
}
