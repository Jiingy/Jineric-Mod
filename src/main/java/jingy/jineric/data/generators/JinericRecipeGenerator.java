package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
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
      RecipeCategory building = RecipeCategory.BUILDING_BLOCKS;
      // offerStonecuttingRecipe(exporter, building, JinericBlocks., JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._SLAB, JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._STAIRS, JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._WALL, JinericBlocks.);

//      offerRefining(exporter, Items.DRIPSTONE_BLOCK, RecipeCategory.BUILDING_BLOCKS, JinericItems.SMOOTH_DRIPSTONE, 0.2F);
//      offerRefining(exporter, JinericItems.DRIPSTONE_STAIRS, RecipeCategory.BUILDING_BLOCKS, JinericItems.SMOOTH_DRIPSTONE_STAIRS, 0.2F);
//      offerRefining(exporter, JinericItems.DRIPSTONE_SLAB, RecipeCategory.BUILDING_BLOCKS, JinericItems.SMOOTH_DRIPSTONE_SLAB, 0.2F);
//      offerRefining(exporter, JinericItems.DRIPSTONE_WALL, RecipeCategory.BUILDING_BLOCKS, JinericItems.SMOOTH_DRIPSTONE_WALL, 0.2F);

      offerIronUpgradeRecipe(exporter, Items.STONE_SWORD, RecipeCategory.COMBAT, Items.IRON_SWORD);
      offerIronUpgradeRecipe(exporter, Items.STONE_AXE, RecipeCategory.TOOLS, Items.IRON_AXE);
      offerIronUpgradeRecipe(exporter, Items.STONE_PICKAXE, RecipeCategory.TOOLS, Items.IRON_PICKAXE);
      offerIronUpgradeRecipe(exporter, Items.STONE_HOE, RecipeCategory.TOOLS, Items.IRON_HOE);
      offerIronUpgradeRecipe(exporter, Items.STONE_SHOVEL, RecipeCategory.TOOLS, Items.IRON_SHOVEL);
      offerNetheriteUpgradeRecipe(exporter, Items.DIAMOND_HORSE_ARMOR, RecipeCategory.COMBAT, JinericItems.NETHERITE_HORSE_ARMOR);

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
      offerFenceRecipe(exporter, RecipeCategory.MISC, JinericBlocks.RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);

      ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SNOW_BRICKS, 4).input('#', Blocks.SNOW_BLOCK).pattern("##").pattern("##").criterion("has_snow", conditionsFromItem(Blocks.SNOW)).offerTo(exporter);
      createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SNOW_BRICK_SLAB, Ingredient.ofItems(JinericBlocks.SNOW_BRICKS)).criterion("has_snow_bricks", conditionsFromItem(JinericBlocks.SNOW_BRICKS)).offerTo(exporter);
      createStairsRecipe(JinericBlocks.SNOW_BRICK_STAIRS, Ingredient.ofItems(JinericBlocks.SNOW_BRICKS)).criterion("has_snow_bricks", conditionsFromItem(JinericBlocks.SNOW_BRICKS)).offerTo(exporter);
      offerWallRecipe(exporter, RecipeCategory.DECORATIONS, JinericBlocks.SNOW_BRICK_WALL, JinericBlocks.SNOW_BRICKS);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.SNOW_BRICK_STAIRS, JinericBlocks.SNOW_BRICKS);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.SNOW_BRICK_SLAB, JinericBlocks.SNOW_BRICKS);
      offerStonecuttingRecipe(exporter, building, JinericBlocks.SNOW_BRICK_WALL, JinericBlocks.SNOW_BRICKS);

      offerRefinery(exporter, JinericBlocks.REFINERY);
   }

   public static void offerTrappedChestReipce(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
      ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
              .input(Blocks.TRIPWIRE_HOOK)
              .input(input)
              .group("trapped_chest")
              .criterion("has_chest", conditionsFromTag(JinericItemTags.WOODEN_CHESTS))
              .offerTo(exporter);
   }

   public static void offerFenceRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
      createFenceRecipe(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
   }

   public static CraftingRecipeJsonBuilder createFenceRecipe(RecipeCategory category, ItemConvertible output, Ingredient outerInput) {
      return ShapedRecipeJsonBuilder.create(category, output, 6).input('#', Items.NETHER_BRICK).input('%', outerInput).pattern("%#%").pattern("%#%");
   }

   public static void offerIronUpgradeRecipe(Consumer<RecipeJsonProvider> exporter, Item input, RecipeCategory category, Item result) {
      SmithingTransformRecipeJsonBuilder.create(
              Ingredient.ofItems(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                      Ingredient.ofItems(input),
                      Ingredient.ofItems(Items.IRON_INGOT), category, result)
              .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
              .offerTo(exporter, getItemPath(result) + "_smithing");
   }

   public static void offerRefinery(Consumer<RecipeJsonProvider> exporter, ItemConvertible output) {
      ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
              .input('P', Blocks.POLISHED_DEEPSLATE).input('T', Blocks.DEEPSLATE_TILES).input('F', Blocks.FURNACE)
              .pattern("PPP")
              .pattern("PFP")
              .pattern("TTT")
              .criterion("has_furnace", conditionsFromItem(Items.FURNACE)).offerTo(exporter);
   }
//
//   public static void offerRefining(Consumer<RecipeJsonProvider> exporter, Item input, RecipeCategory category, ItemConvertible output, float xp) {
//      createRefining(Ingredient.ofItems(input), category, output, xp, 100, RefiningRecipe.REFINING_RECIPE_SERIALIZER)
//              .criterion(hasItem(input), conditionsFromItem(input))
//              .offerTo(exporter, getItemPath(output) + "_from_refining");
//   }
//
//   public static CookingRecipeJsonBuilder createRefining(Ingredient input, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
//      return CookingRecipeJsonBuilderAccess.invokeInit(category, CookingRecipeJsonBuilderAccess.getBlastingRecipeCategory(output), output, input, experience, cookingTime, serializer);
//   }
}
