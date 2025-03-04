package jingy.jineric.base.plugins;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.JinericRecipeBookCategories;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.recipe.book.RecipeBookCategory;

public class EarlyRiser implements Runnable {
	
	@Override
	public void run() {
		MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
		String recipeBookType = remapper.mapClassName("intermediary", "net.minecraft.class_5421");
		ClassTinkerers.enumBuilder(recipeBookType).addEnum("JINERIC_REFINERY").build();
		String recipeCategory = remapper.mapClassName("intermediary", "net.minecraft.class_7800");
		ClassTinkerers.enumBuilder(recipeCategory, String.class).addEnum("JINERIC_BLOCK_SETS", "jineric_block_sets").build();
		ClassTinkerers.enumBuilder(recipeCategory, String.class).addEnum("JINERIC_MISC_BLOCKS", "jineric_misc_blocks").build();
		String blockFamily$Variant = remapper.mapClassName("intermediary", "net.minecraft.class_5794$class_5796");
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("PILLAR", "pillar").build();
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("BOOKSHELF", "bookshelf").build();
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("CHEST", "chest").build();
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("TRAPPED_CHEST", "trapped_chest").build();
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("LADDER", "ladder").build();
		
		// Client
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			String recipeBookCategory = "[L" + remapper.mapClassName("intermediary", "net.minecraft.class_10355") + ";";
			String clientRecipeBookType = remapper.mapClassName("intermediary", "net.minecraft.class_10331");
			
			ClassTinkerers.enumBuilder(clientRecipeBookType, recipeBookCategory).addEnum(
					"JINERIC_REFINERY",
					() -> new Object[]{
							new RecipeBookCategory[]{
									JinericRecipeBookCategories.REFINERY_BLOCKS,
									JinericRecipeBookCategories.REFINERY_MISC
							}
					}
			).build();
		}
	}
}
