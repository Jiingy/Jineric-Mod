package jingy.jineric.recipe.book;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.recipe.book.RecipeBookType;

public class JinericRecipeBookType {
	public static final RecipeBookType JINERIC_REFINERY = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_REFINERY");
	public static final RecipeBookType JINERIC_FOUNDRY = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_FOUNDRY");
	public static final RecipeBookType JINERIC_KILN = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_KILN");
	
	public static void initialize() {
	}
}
