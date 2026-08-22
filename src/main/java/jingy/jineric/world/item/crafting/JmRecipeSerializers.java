package jingy.jineric.world.item.crafting;

import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.RefiningRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class JmRecipeSerializers {
    public static void initialize() {
        Registry<RecipeSerializer<?>> registry = BuiltInRegistries.RECIPE_SERIALIZER;
        Registry.register(registry, JinericMain.ofJineric("refining"), RefiningRecipe.SERIALIZER);
    }
}
