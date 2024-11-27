package jingy.jineric.recipe;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class JinericClientRecipeBookTypes {
   public static final net.minecraft.client.recipebook.RecipeBookType JINERIC_REFINERY = ClassTinkerers.getEnum(net.minecraft.client.recipebook.RecipeBookType.class, "JINERIC_REFINERY");

   public static void initialize() {
   }
}
