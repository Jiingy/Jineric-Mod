package jingy.jineric.recipe;

import jingy.jineric.base.JinericMain;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipePropertySet;

public class JinericRecipePropertySet {
	public static final ResourceKey<RecipePropertySet> REFINERY_INPUT = register("refinery_input");
	public static final ResourceKey<RecipePropertySet> FOUNDRY_INPUT = register("foundry_input");
	
	private static ResourceKey<RecipePropertySet> register(String id) {
		return ResourceKey.create(RecipePropertySet.TYPE_KEY, JinericMain.ofJineric(id));
	}
	
	public static void initialize() {
	}
}
