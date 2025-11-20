package jingy.jineric.base.plugins;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.recipe.book.RecipeBookCategory;

public class EarlyRiser implements Runnable {
	
	@Override
	public void run() {
		//  Server
		MappingResolver mappingResolver = FabricLoader.getInstance().getMappingResolver();
		String recipeBookType = mappingResolver.mapClassName("intermediary", "net.minecraft.class_5421");
		ClassTinkerers.enumBuilder(recipeBookType)
				.addEnum("JINERIC_REFINERY")
				.addEnum("JINERIC_FOUNDRY")
				.build();
		
		String recipeCategory = mappingResolver.mapClassName("intermediary", "net.minecraft.class_7800");
		ClassTinkerers.enumBuilder(recipeCategory, String.class).addEnum("JINERIC_BLOCK_SETS", "jineric_block_sets").build();
		ClassTinkerers.enumBuilder(recipeCategory, String.class).addEnum("JINERIC_MISC_BLOCKS", "jineric_misc_blocks").build();
		
		String blockFamily$Variant = mappingResolver.mapClassName("intermediary", "net.minecraft.class_5794$class_5796");
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("PILLAR", "pillar").build();
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("BOOKSHELF", "bookshelf").build();
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("CHEST", "chest").build();
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("TRAPPED_CHEST", "trapped_chest").build();
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class).addEnum("LADDER", "ladder").build();
		
		// Client
		if (FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT)) {
			String recipeBookCategory = "[L" + mappingResolver.mapClassName("intermediary", "net.minecraft.class_10355") + ";";
			String recipeBookTypeClient = mappingResolver.mapClassName("intermediary", "net.minecraft.class_10331");
			ClassTinkerers.enumBuilder(recipeBookTypeClient, recipeBookCategory)
					.addEnum("JINERIC_REFINERY",
							() -> new Object[]{
									new RecipeBookCategory[]{
											JinericRecipeBookCategories.REFINERY_BLOCKS,
											JinericRecipeBookCategories.REFINERY_MISC
									}
							})
					.addEnum("JINERIC_FOUNDRY",
							() -> new Object[] {
									new RecipeBookCategory[] {
											JinericRecipeBookCategories.FOUNDRY
									}
							})
					.build();
			
			
			
			String chestBlockEntityRenderState$Variant = mappingResolver.mapClassName("intermediary", "net.minecraft.class_11959$class_11960");
			ClassTinkerers.enumBuilder(chestBlockEntityRenderState$Variant)
//					.addEnum("JINERIC_OAK")
					.addEnum("JINERIC_SPRUCE")
					.addEnum("JINERIC_BIRCH")
					.addEnum("JINERIC_JUNGLE")
					.addEnum("JINERIC_ACACIA")
					.addEnum("JINERIC_DARK_OAK")
					.addEnum("JINERIC_MANGROVE")
					.addEnum("JINERIC_CHERRY")
//					.addEnum("JINERIC_PALE_OAK")
					.addEnum("JINERIC_BAMBOO")
					.addEnum("JINERIC_CRIMSON")
					.addEnum("JINERIC_WARPED")
					.addEnum("JINERIC_TRAPPED_SPRUCE")
//					.addEnum("JINERIC_TRAPPED_OAK")
					.addEnum("JINERIC_TRAPPED_BIRCH")
					.addEnum("JINERIC_TRAPPED_JUNGLE")
					.addEnum("JINERIC_TRAPPED_ACACIA")
					.addEnum("JINERIC_TRAPPED_DARK_OAK")
					.addEnum("JINERIC_TRAPPED_MANGROVE")
					.addEnum("JINERIC_TRAPPED_CHERRY")
//					.addEnum("JINERIC_TRAPPED_PALE_OAK")
					.addEnum("JINERIC_TRAPPED_BAMBOO")
					.addEnum("JINERIC_TRAPPED_CRIMSON")
					.addEnum("JINERIC_TRAPPED_WARPED")
					.build();
		}
	}
}
