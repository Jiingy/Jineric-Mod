package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class JinericRecipeGenerator extends FabricRecipeProvider {
   public JinericRecipeGenerator(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generate(Consumer<RecipeJsonProvider> exporter) {
      //--- REMINDERS ---
      // - SLAB STONECUTTING RECIPES NEED 2 OUTPUT
      // - STAIRS NEED .offerTo(exporter);
      RecipeCategory building = RecipeCategory.BUILDING_BLOCKS;
      RecipeCategory misc = RecipeCategory.MISC;
      // offerStonecuttingRecipe(exporter, building, JinericBlocks., JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._SLAB, JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._STAIRS, JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._WALL, JinericBlocks.);
      offerTrappedChestReipce(exporter, JinericItems.TRAPPED_SPRUCE_CHEST, JinericItems.SPRUCE_CHEST);
      offerTrappedChestReipce(exporter, JinericItems.TRAPPED_BIRCH_CHEST, JinericItems.BIRCH_CHEST);
      offerTrappedChestReipce(exporter, JinericItems.TRAPPED_JUNGLE_CHEST, JinericItems.JUNGLE_CHEST);
      offerTrappedChestReipce(exporter, JinericItems.TRAPPED_ACACIA_CHEST, JinericItems.ACACIA_CHEST);
      offerTrappedChestReipce(exporter, JinericItems.TRAPPED_DARK_OAK_CHEST, JinericItems.DARK_OAK_CHEST);
      offerTrappedChestReipce(exporter, JinericItems.TRAPPED_MANGROVE_CHEST, JinericItems.MANGROVE_CHEST);
      offerTrappedChestReipce(exporter, JinericItems.TRAPPED_CRIMSON_CHEST, JinericItems.CRIMSON_CHEST);
      offerTrappedChestReipce(exporter, JinericItems.TRAPPED_WARPED_CHEST, JinericItems.WARPED_CHEST);


      offerStonecuttingRecipe(exporter, building, JinericBlocks.SMOOTH_BASALT_SLAB, Blocks.SMOOTH_BASALT);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.SMOOTH_BASALT_STAIRS, Blocks.SMOOTH_BASALT);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.SMOOTH_BASALT_WALL, Blocks.SMOOTH_BASALT);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB, Blocks.CRACKED_DEEPSLATE_TILES);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS, Blocks.CRACKED_DEEPSLATE_TILES);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_DEEPSLATE_TILE_WALL, Blocks.CRACKED_DEEPSLATE_TILES);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB, Blocks.CRACKED_DEEPSLATE_BRICKS);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS, Blocks.CRACKED_DEEPSLATE_BRICKS);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_DEEPSLATE_BRICK_WALL, Blocks.CRACKED_DEEPSLATE_BRICKS);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
      createCustomFenceRecipe(JinericBlocks.RED_NETHER_BRICK_FENCE, Ingredient.ofItems(Blocks.RED_NETHER_BRICKS));
   }

   public static void offerTrappedChestReipce(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
      ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
              .input(Blocks.TRIPWIRE_HOOK)
              .input(input)
              .group("trapped_chest")
              .criterion("has_chest", conditionsFromTag(JinericItemTags.WOODEN_CHESTS))
              .offerTo(exporter);
   }

   public static CraftingRecipeJsonBuilder createCustomFenceRecipe(ItemConvertible output, Ingredient input) {
      return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
              .input('#', input)
              .input('X', (ItemConvertible) Items.NETHER_BRICK)
              .pattern("#X#")
              .pattern("#X#");
   }
}
