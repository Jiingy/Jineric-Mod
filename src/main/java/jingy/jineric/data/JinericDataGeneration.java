package jingy.jineric.data;

import com.google.common.collect.ImmutableList;
import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class JinericDataGeneration implements DataGeneratorEntrypoint {
   @Override
   public void onInitializeDataGenerator(FabricDataGenerator generator) {
      FabricDataGenerator.Pack pack = generator.createPack();
      pack.addProvider(JinericRecipeGenerator::new);
      pack.addProvider(JinericModelGenerator::new);
   }



   private static class JinericRecipeGenerator extends FabricRecipeProvider {
      public JinericRecipeGenerator(FabricDataOutput output) {
         super(output);
      }

      private static final ImmutableList<ItemConvertible> BASALT = ImmutableList.of(Items.BASALT);

      @Override
      public void generate(Consumer<RecipeJsonProvider> exporter) {
         //         RecipeProvider.createStairsRecipe(JinericBlocks., Ingredient.ofItems(Blocks.))
         //                 .criterion("has_block", conditionsFromItem(Blocks.)).offerTo(exporter);
         //         RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks., Blocks.);
         //         RecipeProvider.offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks., Blocks.);



         RecipeProvider.createStairsRecipe(JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS, Ingredient.ofItems(Blocks.CRACKED_DEEPSLATE_TILES))
                 .criterion("has_cracked_deepslate_tiles_block", conditionsFromItem(Blocks.CRACKED_DEEPSLATE_TILES)).offerTo(exporter);
         RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB, Blocks.CRACKED_DEEPSLATE_TILES);
         RecipeProvider.offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CRACKED_DEEPSLATE_TILE_WALL, Blocks.CRACKED_DEEPSLATE_TILES);

         RecipeProvider.createStairsRecipe(JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS, Ingredient.ofItems(Blocks.CRACKED_DEEPSLATE_BRICKS))
                 .criterion("has_cracked_deepslate_bricks_block", conditionsFromItem(Blocks.CRACKED_DEEPSLATE_BRICKS)).offerTo(exporter);
         RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB, Blocks.CRACKED_DEEPSLATE_BRICKS);
         RecipeProvider.offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CRACKED_DEEPSLATE_BRICK_WALL, Blocks.CRACKED_DEEPSLATE_BRICKS);

         RecipeProvider.createStairsRecipe(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, Ingredient.ofItems(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS))
                 .criterion("has_cracked_polished_blackstone_bricks_block", conditionsFromItem(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)).offerTo(exporter);
         RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
         RecipeProvider.offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);

         RecipeProvider.createStairsRecipe(JinericBlocks.CRACKED_NETHER_BRICK_STAIRS, Ingredient.ofItems(Blocks.CRACKED_NETHER_BRICKS))
                 .criterion("has_cracked_nether_bricks_block", conditionsFromItem(Blocks.CRACKED_NETHER_BRICKS)).offerTo(exporter);
         RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CRACKED_NETHER_BRICK_SLAB, Blocks.CRACKED_NETHER_BRICKS);
         RecipeProvider.offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CRACKED_NETHER_BRICK_WALL, Blocks.CRACKED_NETHER_BRICKS);

         RecipeProvider.createStairsRecipe(JinericBlocks.SMOOTH_BASALT_STAIRS, Ingredient.ofItems(Blocks.SMOOTH_BASALT))
                 .criterion("has_smooth_basalt_block", conditionsFromItem(Blocks.SMOOTH_BASALT)).offerTo(exporter);
         RecipeProvider.offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SMOOTH_BASALT_SLAB, Blocks.SMOOTH_BASALT);
         RecipeProvider.offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SMOOTH_BASALT_WALL, Blocks.SMOOTH_BASALT);


         RecipeProvider.offerSmelting(exporter, BASALT, RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_BASALT, 0.2F, 100, "smooth_basalt");


//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.STONE_WALL, Blocks.STONE);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SMOOTH_STONE_WALL, Blocks.SMOOTH_STONE);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
//         //COPPER
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CUT_COPPER_WALL, Blocks.CUT_COPPER, 1);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.EXPOSED_CUT_COPPER_WALL, Blocks.EXPOSED_CUT_COPPER, 1);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.WEATHERED_CUT_COPPER_WALL, Blocks.WEATHERED_CUT_COPPER, 1);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.OXIDIZED_CUT_COPPER_WALL, Blocks.OXIDIZED_CUT_COPPER, 1);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.WAXED_CUT_COPPER_WALL, Blocks.WAXED_CUT_COPPER, 1);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, Blocks.WAXED_EXPOSED_CUT_COPPER, 1);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, Blocks.WAXED_WEATHERED_CUT_COPPER, 1);
//         RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL, Blocks.WAXED_OXIDIZED_CUT_COPPER, 1);
      }
   }



   private static class JinericModelGenerator extends FabricModelProvider {

      public JinericModelGenerator(FabricDataOutput output) {
         super(output);
      }

      @Override
      public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
      }

      @Override
      public void generateItemModels(ItemModelGenerator itemModelGenerator) {

      }
   }
}


