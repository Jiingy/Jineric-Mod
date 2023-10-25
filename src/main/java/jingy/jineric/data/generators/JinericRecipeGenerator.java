package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import jingy.jineric.mixin.access.CookingRecipeJsonBuilderAccess;
import jingy.jineric.recipe.JinericRecipeSerializers;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class JinericRecipeGenerator extends FabricRecipeProvider {
   public JinericRecipeGenerator(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generate(Consumer<RecipeJsonProvider> exporter) {
      RecipeCategory blocks = RecipeCategory.BUILDING_BLOCKS;
      RecipeCategory misc = RecipeCategory.MISC;
      Item cookingNone = Items.AIR;
      CookingRecipeCategory cookingBlocks = CookingRecipeCategory.BLOCKS;
      CookingRecipeCategory cookingMisc = CookingRecipeCategory.MISC;

      offerRefining(exporter, Items.SMOOTH_QUARTZ, Items.QUARTZ_BLOCK, blocks, cookingBlocks, 0.2F, Items.SMOOTH_QUARTZ);
      offerRefining(exporter, Items.SMOOTH_QUARTZ_STAIRS, Items.QUARTZ_STAIRS, blocks, cookingBlocks, 0.2F, Items.SMOOTH_QUARTZ);
      offerRefining(exporter, Items.SMOOTH_QUARTZ_SLAB, Items.QUARTZ_SLAB, blocks, cookingBlocks, 0.2F, Items.SMOOTH_QUARTZ);
      offerRefining(exporter, JinericItems.SMOOTH_QUARTZ_WALL, JinericItems.QUARTZ_WALL, blocks, cookingBlocks, 0.2F, Items.SMOOTH_QUARTZ);

      offerCrackingRecipe(exporter, JinericItems.CRACKED_DRIPSTONE_TILES, JinericItems.DRIPSTONE_TILES);
      offerRefining(exporter, JinericItems.CRACKED_DRIPSTONE_TILES, JinericItems.DRIPSTONE_TILES, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_DRIPSTONE_TILES);
      offerRefining(exporter, JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS, JinericItems.DRIPSTONE_TILE_STAIRS, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_DRIPSTONE_TILES);
      offerRefining(exporter, JinericItems.CRACKED_DRIPSTONE_TILE_SLAB, JinericItems.DRIPSTONE_TILE_SLAB, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_DRIPSTONE_TILES);
      offerRefining(exporter, JinericItems.CRACKED_DRIPSTONE_TILE_WALL, JinericItems.DRIPSTONE_TILE_WALL, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_DRIPSTONE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB, JinericBlocks.CRACKED_DRIPSTONE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS, JinericBlocks.CRACKED_DRIPSTONE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL, JinericBlocks.CRACKED_DRIPSTONE_TILES);
      createSlabRecipe(blocks, JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB, Ingredient.ofItems(JinericBlocks.CRACKED_DRIPSTONE_TILES)).criterion("has_cracked_dripstone_tiles", conditionsFromItem(JinericBlocks.CRACKED_DRIPSTONE_TILES)).offerTo(exporter);
      createStairsRecipe(JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS, Ingredient.ofItems(JinericBlocks.CRACKED_DRIPSTONE_TILES)).criterion("has_cracked_dripstone_tiles", conditionsFromItem(JinericBlocks.CRACKED_DRIPSTONE_TILES)).offerTo(exporter);
      offerWallRecipe(exporter, RecipeCategory.DECORATIONS, JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL, JinericBlocks.CRACKED_DRIPSTONE_TILES);

      offerCrackingRecipe(exporter, JinericItems.CRACKED_TUFF_TILES, JinericItems.TUFF_TILES);
      offerRefining(exporter, JinericItems.CRACKED_TUFF_TILES, JinericItems.TUFF_TILES, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_TUFF_TILES);
      offerRefining(exporter, JinericItems.CRACKED_TUFF_TILE_STAIRS, JinericItems.TUFF_TILE_STAIRS, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_TUFF_TILES);
      offerRefining(exporter, JinericItems.CRACKED_TUFF_TILE_SLAB, JinericItems.TUFF_TILE_SLAB, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_TUFF_TILES);
      offerRefining(exporter, JinericItems.CRACKED_TUFF_TILE_WALL, JinericItems.TUFF_TILE_WALL, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_TUFF_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_TUFF_TILE_SLAB, JinericBlocks.CRACKED_TUFF_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_TUFF_TILE_STAIRS, JinericBlocks.CRACKED_TUFF_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_TUFF_TILE_WALL, JinericBlocks.CRACKED_TUFF_TILES);
      createSlabRecipe(blocks, JinericBlocks.CRACKED_TUFF_TILE_SLAB, Ingredient.ofItems(JinericBlocks.CRACKED_TUFF_TILES)).criterion("has_cracked_tuff_tiles", conditionsFromItem(JinericBlocks.CRACKED_TUFF_TILES)).offerTo(exporter);
      createStairsRecipe(JinericBlocks.CRACKED_TUFF_TILE_STAIRS, Ingredient.ofItems(JinericBlocks.CRACKED_TUFF_TILES)).criterion("has_cracked_tuff_tiles", conditionsFromItem(JinericBlocks.CRACKED_TUFF_TILES)).offerTo(exporter);
      offerWallRecipe(exporter, RecipeCategory.DECORATIONS, JinericBlocks.CRACKED_TUFF_TILE_WALL, JinericBlocks.CRACKED_TUFF_TILES);

      offerCrackingRecipe(exporter, JinericItems.CRACKED_STONE_TILES, JinericItems.STONE_TILES);
      offerRefining(exporter, JinericItems.CRACKED_STONE_TILES, JinericItems.STONE_TILES, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_STONE_TILES);
      offerRefining(exporter, JinericItems.CRACKED_STONE_TILE_STAIRS, JinericItems.STONE_TILE_STAIRS, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_STONE_TILES);
      offerRefining(exporter, JinericItems.CRACKED_STONE_TILE_SLAB, JinericItems.STONE_TILE_SLAB, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_STONE_TILES);
      offerRefining(exporter, JinericItems.CRACKED_STONE_TILE_WALL, JinericItems.STONE_TILE_WALL, blocks, cookingBlocks, 0.2F, JinericItems.CRACKED_STONE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_STONE_TILE_SLAB, JinericBlocks.CRACKED_STONE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_STONE_TILE_STAIRS, JinericBlocks.CRACKED_STONE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_STONE_TILE_WALL, JinericBlocks.CRACKED_STONE_TILES);
      createSlabRecipe(blocks, JinericBlocks.CRACKED_STONE_TILE_SLAB, Ingredient.ofItems(JinericBlocks.CRACKED_STONE_TILES)).criterion("has_cracked_stone_tiles", conditionsFromItem(JinericBlocks.CRACKED_STONE_TILES)).offerTo(exporter);
      createStairsRecipe(JinericBlocks.CRACKED_STONE_TILE_STAIRS, Ingredient.ofItems(JinericBlocks.CRACKED_STONE_TILES)).criterion("has_cracked_stone_tiles", conditionsFromItem(JinericBlocks.CRACKED_STONE_TILES)).offerTo(exporter);
      offerWallRecipe(exporter, RecipeCategory.DECORATIONS, JinericBlocks.CRACKED_STONE_TILE_WALL, JinericBlocks.CRACKED_STONE_TILES);

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

      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.SMOOTH_BASALT_SLAB, Blocks.SMOOTH_BASALT);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.SMOOTH_BASALT_STAIRS, Blocks.SMOOTH_BASALT);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.SMOOTH_BASALT_WALL, Blocks.SMOOTH_BASALT);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB, Blocks.CRACKED_DEEPSLATE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS, Blocks.CRACKED_DEEPSLATE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DEEPSLATE_TILE_WALL, Blocks.CRACKED_DEEPSLATE_TILES);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB, Blocks.CRACKED_DEEPSLATE_BRICKS);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS, Blocks.CRACKED_DEEPSLATE_BRICKS);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_DEEPSLATE_BRICK_WALL, Blocks.CRACKED_DEEPSLATE_BRICKS);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
      offerFenceRecipe(exporter, RecipeCategory.MISC, JinericBlocks.RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);

      ShapedRecipeJsonBuilder.create(blocks, JinericBlocks.SNOW_BRICKS, 4).input('#', Blocks.SNOW_BLOCK).pattern("##").pattern("##").criterion("has_snow", conditionsFromItem(Blocks.SNOW)).offerTo(exporter);
      createSlabRecipe(blocks, JinericBlocks.SNOW_BRICK_SLAB, Ingredient.ofItems(JinericBlocks.SNOW_BRICKS)).criterion("has_snow_bricks", conditionsFromItem(JinericBlocks.SNOW_BRICKS)).offerTo(exporter);
      createStairsRecipe(JinericBlocks.SNOW_BRICK_STAIRS, Ingredient.ofItems(JinericBlocks.SNOW_BRICKS)).criterion("has_snow_bricks", conditionsFromItem(JinericBlocks.SNOW_BRICKS)).offerTo(exporter);
      offerWallRecipe(exporter, RecipeCategory.DECORATIONS, JinericBlocks.SNOW_BRICK_WALL, JinericBlocks.SNOW_BRICKS);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.SNOW_BRICK_STAIRS, JinericBlocks.SNOW_BRICKS);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.SNOW_BRICK_SLAB, JinericBlocks.SNOW_BRICKS);
      offerStonecuttingRecipe(exporter, blocks, JinericBlocks.SNOW_BRICK_WALL, JinericBlocks.SNOW_BRICKS);

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
              .criterion("has_furnace", conditionsFromItem(Items.FURNACE))
              .offerTo(exporter);
   }

   public static void offerRefining(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, Item input, RecipeCategory category, CookingRecipeCategory cookingCategory, float xp, Item group) {
      Identifier outId = new Identifier(output.toString());
      createRefining(Ingredient.ofItems(input), category, cookingCategory, output, xp, 100, JinericRecipeSerializers.REFINING)
              .group(group == Items.AIR ? null : group.toString())
              .criterion(hasItem(input), conditionsFromItem(input))
              .offerTo(exporter, outId + "_refining_" + input);
   }

   public static CookingRecipeJsonBuilder createRefining(Ingredient input, RecipeCategory category, CookingRecipeCategory cookingCategory, ItemConvertible output, float experience, int cookingTime, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
      return CookingRecipeJsonBuilderAccess.invokeInit(category, cookingCategory, output, input, experience, cookingTime, serializer);
   }
}
