package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.registry.RegistryKey;

public class JinericRecipePropertySet {
    public static final RegistryKey<RecipePropertySet> REFINERY_INPUT = register("refinery_input");

    private static RegistryKey<RecipePropertySet> register(String id) {
        return RegistryKey.of(RecipePropertySet.REGISTRY, JinericMain.ofJineric(id));
    }

    public static void initialize() {
    }
}
