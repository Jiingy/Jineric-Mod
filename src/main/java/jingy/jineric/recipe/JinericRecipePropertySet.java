package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class JinericRecipePropertySet {
    public static final RegistryKey<RecipePropertySet> REFINERY_INPUT = register("refinery_input");

    private static RegistryKey<RecipePropertySet> register(String id) {
        return RegistryKey.of(RecipePropertySet.REGISTRY, JinericMain.ofJineric(id));
    }
}
