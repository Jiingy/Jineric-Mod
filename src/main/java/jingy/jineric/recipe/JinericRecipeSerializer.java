package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class JinericRecipeSerializer {
	public static RecipeSerializer<RefiningRecipe> REFINING = register("refining", new AbstractCookingRecipe.Serializer<>(RefiningRecipe::new, 100));
	
	static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
		return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, JinericMain.ofJineric(id), serializer);
	}
	
	public static void initialize() {
	}
}
