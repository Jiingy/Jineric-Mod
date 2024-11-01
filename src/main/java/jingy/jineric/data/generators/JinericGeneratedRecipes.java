package jingy.jineric.data.generators;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JinericGeneratedRecipes extends JinericRecipeProviders {
   //TODO: BROKEN IN 1.21.3
   private static final RecipeCategory CATEGORY_BUILDING = RecipeCategory.BUILDING_BLOCKS;
   private static final RecipeCategory MISC = RecipeCategory.MISC;
   private static final CookingRecipeCategory COOKING_BLOCKS = CookingRecipeCategory.BLOCKS;
   private static final CookingRecipeCategory COOKING_MISC = CookingRecipeCategory.MISC;

   public JinericGeneratedRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
      super(output, registriesFuture);
   }

   public static void offerGeneralRecipes(RecipeExporter exporter) {
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_SPRUCE_CHEST, JinericItems.SPRUCE_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_BIRCH_CHEST, JinericItems.BIRCH_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_JUNGLE_CHEST, JinericItems.JUNGLE_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_ACACIA_CHEST, JinericItems.ACACIA_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_DARK_OAK_CHEST, JinericItems.DARK_OAK_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_MANGROVE_CHEST, JinericItems.MANGROVE_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_CHERRY_CHEST, JinericItems.CHERRY_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_BAMBOO_CHEST, JinericItems.BAMBOO_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_CRIMSON_CHEST, JinericItems.CRIMSON_CHEST);
//      offerTrappedChestRecipe(exporter, JinericItems.TRAPPED_WARPED_CHEST, JinericItems.WARPED_CHEST);
//      offerFenceRecipe(exporter, RecipeCategory.MISC, JinericBlocks.RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);
//      offerRefinery(exporter, JinericBlocks.REFINERY);
//      offerSimpleBrickSetRecipes(exporter, JinericItems.STONE_TILES, JinericItems.CRACKED_STONE_TILES, JinericItems.CRACKED_STONE_TILE_STAIRS, JinericItems.CRACKED_STONE_TILE_SLAB, JinericItems.CRACKED_STONE_TILE_WALL);
//      offerSimpleBrickSetRecipes(exporter, JinericItems.TUFF_TILES, JinericItems.CRACKED_TUFF_TILES, JinericItems.CRACKED_TUFF_TILE_STAIRS, JinericItems.CRACKED_TUFF_TILE_SLAB, JinericItems.CRACKED_TUFF_TILE_WALL);
//      offerSimpleBrickSetRecipes(exporter, JinericItems.DRIPSTONE_TILES, JinericItems.CRACKED_DRIPSTONE_TILES, JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS, JinericItems.CRACKED_DRIPSTONE_TILE_SLAB, JinericItems.CRACKED_DRIPSTONE_TILE_WALL);
//      offerSimpleBrickSetRecipes(exporter, Items.SNOW_BLOCK, JinericItems.SNOW_BRICKS, JinericItems.SNOW_BRICK_STAIRS, JinericItems.SNOW_BRICK_SLAB, JinericItems.SNOW_BRICK_WALL);
   }

   static void offerRefiningRecipes(RecipeExporter exporter) {
//      offerRefining(exporter, Items.SMOOTH_QUARTZ, Items.QUARTZ_BLOCK, Items.SMOOTH_QUARTZ);
//      offerRefining(exporter, Items.SMOOTH_QUARTZ_STAIRS, Items.QUARTZ_STAIRS, Items.SMOOTH_QUARTZ);
//      offerRefining(exporter, Items.SMOOTH_QUARTZ_SLAB, Items.QUARTZ_SLAB, Items.SMOOTH_QUARTZ);
//      offerRefining(exporter, JinericItems.SMOOTH_QUARTZ_WALL, JinericItems.QUARTZ_WALL, Items.SMOOTH_QUARTZ);
//      offerRefining(exporter, JinericItems.CRACKED_DRIPSTONE_TILES, JinericItems.DRIPSTONE_TILES, JinericItems.CRACKED_DRIPSTONE_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS, JinericItems.DRIPSTONE_TILE_STAIRS, JinericItems.CRACKED_DRIPSTONE_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_DRIPSTONE_TILE_SLAB, JinericItems.DRIPSTONE_TILE_SLAB, JinericItems.CRACKED_DRIPSTONE_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_DRIPSTONE_TILE_WALL, JinericItems.DRIPSTONE_TILE_WALL, JinericItems.CRACKED_DRIPSTONE_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_TUFF_TILES, JinericItems.TUFF_TILES, JinericItems.CRACKED_TUFF_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_TUFF_TILE_STAIRS, JinericItems.TUFF_TILE_STAIRS, JinericItems.CRACKED_TUFF_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_TUFF_TILE_SLAB, JinericItems.TUFF_TILE_SLAB, JinericItems.CRACKED_TUFF_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_TUFF_TILE_WALL, JinericItems.TUFF_TILE_WALL, JinericItems.CRACKED_TUFF_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_STONE_TILES, JinericItems.STONE_TILES, JinericItems.CRACKED_STONE_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_STONE_TILE_STAIRS, JinericItems.STONE_TILE_STAIRS, JinericItems.CRACKED_STONE_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_STONE_TILE_SLAB, JinericItems.STONE_TILE_SLAB, JinericItems.CRACKED_STONE_TILES);
//      offerRefining(exporter, JinericItems.CRACKED_STONE_TILE_WALL, JinericItems.STONE_TILE_WALL, JinericItems.CRACKED_STONE_TILES);
   }

   static void offerStoneCuttingRecipes(RecipeExporter exporter) {
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB, JinericBlocks.CRACKED_DRIPSTONE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS, JinericBlocks.CRACKED_DRIPSTONE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL, JinericBlocks.CRACKED_DRIPSTONE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_TUFF_TILE_SLAB, JinericBlocks.CRACKED_TUFF_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_TUFF_TILE_STAIRS, JinericBlocks.CRACKED_TUFF_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_TUFF_TILE_WALL, JinericBlocks.CRACKED_TUFF_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_STONE_TILE_SLAB, JinericBlocks.CRACKED_STONE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_STONE_TILE_STAIRS, JinericBlocks.CRACKED_STONE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_STONE_TILE_WALL, JinericBlocks.CRACKED_STONE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.SMOOTH_BASALT_SLAB, Blocks.SMOOTH_BASALT);
//      offerStonecuttingRecipe(exporter, JinericBlocks.SMOOTH_BASALT_STAIRS, Blocks.SMOOTH_BASALT);
//      offerStonecuttingRecipe(exporter, JinericBlocks.SMOOTH_BASALT_WALL, Blocks.SMOOTH_BASALT);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB, Blocks.CRACKED_DEEPSLATE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS, Blocks.CRACKED_DEEPSLATE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DEEPSLATE_TILE_WALL, Blocks.CRACKED_DEEPSLATE_TILES);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB, Blocks.CRACKED_DEEPSLATE_BRICKS);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS, Blocks.CRACKED_DEEPSLATE_BRICKS);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_DEEPSLATE_BRICK_WALL, Blocks.CRACKED_DEEPSLATE_BRICKS);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
//      offerStonecuttingRecipe(exporter, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
//      offerStonecuttingRecipe(exporter, JinericBlocks.SNOW_BRICK_STAIRS, JinericBlocks.SNOW_BRICKS);
//      offerStonecuttingRecipe(exporter, JinericBlocks.SNOW_BRICK_SLAB, JinericBlocks.SNOW_BRICKS);
//      offerStonecuttingRecipe(exporter, JinericBlocks.SNOW_BRICK_WALL, JinericBlocks.SNOW_BRICKS);
   }

   static void offerUpgradeRecipes(RecipeExporter exporter) {
//      offerNetheriteUpgradeRecipe(exporter, Items.DIAMOND_HORSE_ARMOR, RecipeCategory.COMBAT, JinericItems.NETHERITE_HORSE_ARMOR);
//      offerIronUpgradeRecipe(exporter, Items.STONE_SWORD, RecipeCategory.COMBAT, Items.IRON_SWORD);
//      offerIronUpgradeRecipe(exporter, Items.STONE_AXE, RecipeCategory.TOOLS, Items.IRON_AXE);
//      offerIronUpgradeRecipe(exporter, Items.STONE_PICKAXE, RecipeCategory.TOOLS, Items.IRON_PICKAXE);
//      offerIronUpgradeRecipe(exporter, Items.STONE_HOE, RecipeCategory.TOOLS, Items.IRON_HOE);
//      offerIronUpgradeRecipe(exporter, Items.STONE_SHOVEL, RecipeCategory.TOOLS, Items.IRON_SHOVEL);
   }
}
