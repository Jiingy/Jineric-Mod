package jingy.jineric.base.plugins;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.world.item.crafting.RecipeBookCategory;

public class EarlyRiser implements Runnable {
	
	@Override
	public void run() {
		//  Server
		MappingResolver mappingResolver = FabricLoader.getInstance().getMappingResolver();
		
		String recipeBookType = mappingResolver.mapClassName("official", "net.minecraft.world.inventory.RecipeBookType");
		ClassTinkerers.enumBuilder(recipeBookType)
				.addEnum("JINERIC_REFINERY")
				.addEnum("JINERIC_FOUNDRY")
				.addEnum("JINERIC_KILN")
				.build();
		
		String recipeCategory = mappingResolver.mapClassName("official", "net.minecraft.data.recipes.RecipeCategory");
		ClassTinkerers.enumBuilder(recipeCategory, String.class)
				.addEnum("JINERIC_BLOCK_SETS", "jineric_block_sets")
				.addEnum("JINERIC_MISC_BLOCKS", "jineric_misc_blocks")
				.build();
		
		String blockFamily$Variant = mappingResolver.mapClassName("official", "net.minecraft.data.BlockFamily$Variant");
		ClassTinkerers.enumBuilder(blockFamily$Variant, String.class)
				.addEnum("BOOKSHELF", "bookshelf")
				.addEnum("CHEST", "chest")
				.addEnum("TRAPPED_CHEST", "trapped_chest")
				.addEnum("LADDER", "ladder")
				.build();
		
		//  Client
		if (FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT)) {
			String recipeBookCategory = "[L" + mappingResolver.mapClassName("official", "net.minecraft.world.item.crafting.RecipeBookCategory") + ";";
			String searchRecipeBookCategory = mappingResolver.mapClassName("official", "net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory");
			ClassTinkerers.enumBuilder(searchRecipeBookCategory, recipeBookCategory)
					.addEnum("JINERIC_REFINERY", () -> new Object[]{
							new RecipeBookCategory[]{
									JinericRecipeBookCategories.REFINERY_BLOCKS,
									JinericRecipeBookCategories.REFINERY_MISC
							}
					}).addEnum("JINERIC_FOUNDRY", () -> new Object[]{
							new RecipeBookCategory[]{
									JinericRecipeBookCategories.FOUNDRY
							}
					}).addEnum("JINERIC_KILN", () -> new Object[] {
							new RecipeBookCategory[] {
									JinericRecipeBookCategories.KILN
							}
					})
					.build();

			String ChestMaterialType = mappingResolver.mapClassName("official", "net.minecraft.client.renderer.blockentity.state.ChestRenderState.ChestMaterialType");
			ClassTinkerers.enumBuilder(ChestMaterialType)
//					.addEnum("JINERIC_OAK")
					.addEnum("JINERIC_WOODEN_SPRUCE")
					.addEnum("JINERIC_WOODEN_BIRCH")
					.addEnum("JINERIC_WOODEN_JUNGLE")
					.addEnum("JINERIC_WOODEN_ACACIA")
					.addEnum("JINERIC_WOODEN_DARK_OAK")
					.addEnum("JINERIC_WOODEN_MANGROVE")
					.addEnum("JINERIC_WOODEN_CHERRY")
//					.addEnum("JINERIC_WOODEN_PALE_OAK")
//					.addEnum("JINERIC_WOODEN_POPLAR")
					.addEnum("JINERIC_WOODEN_BAMBOO")
					.addEnum("JINERIC_WOODEN_CRIMSON")
					.addEnum("JINERIC_WOODEN_WARPED")
					.addEnum("JINERIC_WOODEN_TRAPPED_SPRUCE")
//					.addEnum("JINERIC_WOODEN_TRAPPED_OAK")
					.addEnum("JINERIC_WOODEN_TRAPPED_BIRCH")
					.addEnum("JINERIC_WOODEN_TRAPPED_JUNGLE")
					.addEnum("JINERIC_WOODEN_TRAPPED_ACACIA")
					.addEnum("JINERIC_WOODEN_TRAPPED_DARK_OAK")
					.addEnum("JINERIC_WOODEN_TRAPPED_MANGROVE")
					.addEnum("JINERIC_WOODEN_TRAPPED_CHERRY")
//					.addEnum("JINERIC_WOODEN_TRAPPED_PALE_OAK")
//					.addEnum("JINERIC_WOODEN_TRAPPED_POPLAR")
					.addEnum("JINERIC_WOODEN_TRAPPED_BAMBOO")
					.addEnum("JINERIC_WOODEN_TRAPPED_CRIMSON")
					.addEnum("JINERIC_WOODEN_TRAPPED_WARPED")
					.build();
		}
	}
}
