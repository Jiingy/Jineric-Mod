package jingy.jineric.recipe;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookGroup;
import net.minecraft.recipe.book.RecipeBookType;

import java.util.List;

@Environment(EnvType.CLIENT)
public class JinericRecipeBookType implements RecipeBookGroup {



    private final List<RecipeBookCategory> jinericCategories;

    private JinericRecipeBookType(final RecipeBookCategory... categories) {
        this.jinericCategories = List.of(categories);
    }

    public List<RecipeBookCategory> getJinericCategories() {
        return this.jinericCategories;
    }

//    private static final RecipeBookType JINERIC_REFINERY_SEARCH = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_REFINERY_SEARCH");
//    private static final RecipeBookType JINERIC_REFINERY_BUILDING = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_REFINERY_BUILDING");
//    private static final RecipeBookType JINERIC_REFINERY_MISC = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_REFINERY_MISC");
//    public static final List<RecipeBookType> JINERIC_REFINERY = ImmutableList.of(JINERIC_REFINERY_SEARCH, JINERIC_REFINERY_BUILDING, JINERIC_REFINERY_MISC);

}
