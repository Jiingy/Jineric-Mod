package net.jineric.jineric_mod.data.generation.providers;

import com.google.common.collect.ImmutableMap;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.data.family.JinericBlockFamilyVariants;
import jingy.jineric.item.JinericItems;
import jingy.jineric.mixin.access.CookingRecipeJsonBuilderAccessor;
import jingy.jineric.recipe.RefiningRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class JinericRecipeProvider extends FabricRecipeProvider {
	public JinericRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeOutput) {
		return new RecipeProvider(wrapperLookup, recipeOutput) {
			
			private static final Map<BlockFamily.Variant, RecipeProvider.FamilyRecipeProvider> SHAPE_BUILDERS = ImmutableMap.<BlockFamily.Variant, RecipeProvider.FamilyRecipeProvider>builder()
					.put(BlockFamily.Variant.BUTTON, (recipeProvider, output, input) -> recipeProvider.buttonBuilder(output, Ingredient.of(input)))
					.put(BlockFamily.Variant.CHISELED,
							(recipeProvider, output, input) -> recipeProvider.chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)))
					.put(BlockFamily.Variant.CUT, (recipeProvider, output, input) -> recipeProvider.cutBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)))
					.put(BlockFamily.Variant.DOOR, (recipeProvider, output, input) -> recipeProvider.doorBuilder(output, Ingredient.of(input)))
//					.put(BlockFamily.Variant.CUSTOM_FENCE, (recipeProvider, output, input) -> recipeProvider.FenceRecipe(output, Ingredient.of(input)))
					.put(BlockFamily.Variant.FENCE, (recipeProvider, output, input) -> recipeProvider.fenceBuilder(output, Ingredient.of(input)))
					.put(BlockFamily.Variant.CUSTOM_FENCE_GATE, (recipeProvider, output, input) -> recipeProvider.fenceGateBuilder(output, Ingredient.of(input)))
					.put(BlockFamily.Variant.FENCE_GATE, (recipeProvider, output, input) -> recipeProvider.fenceGateBuilder(output, Ingredient.of(input)))
					.put(BlockFamily.Variant.SIGN, (recipeProvider, output, input) -> recipeProvider.signBuilder(output, Ingredient.of(input)))
					.put(BlockFamily.Variant.SLAB, (recipeProvider, output, input) -> recipeProvider.slabBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)))
					.put(BlockFamily.Variant.STAIRS, (recipeProvider, output, input) -> recipeProvider.stairBuilder(output, Ingredient.of(input)))
					.put(BlockFamily.Variant.PRESSURE_PLATE,
							(recipeProvider, output, input) -> recipeProvider.pressurePlateBuilder(RecipeCategory.REDSTONE, output, Ingredient.of(input)))
					.put(BlockFamily.Variant.POLISHED,
							(recipeProvider, output, input) -> recipeProvider.polishedBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)))
					.put(BlockFamily.Variant.TRAPDOOR, (recipeProvider, output, input) -> recipeProvider.trapdoorBuilder(output, Ingredient.of(input)))
					.put(BlockFamily.Variant.WALL,
							(recipeProvider, output, input) -> recipeProvider.wallBuilder(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.of(input)))
					.put(JinericBlockFamilyVariants.BOOKSHELF, (recipeProvider, output, input) -> recipeProvider.bookshelfBuilder$jineric(Ingredient.of(input), output))
					.put(JinericBlockFamilyVariants.CHEST, (recipeProvider, output, input) -> recipeProvider.chestBuilder$jineric(Ingredient.of(input), output))
					.put(JinericBlockFamilyVariants.LADDER, (recipeProvider, output, input) -> recipeProvider.ladderBuilder$jineric(Ingredient.of(input), output))
					.build();
			
			@Override
			public void buildRecipes() {
				BlockFamilies.getAllFamilies()
						.filter(BlockFamily::shouldGenerateRecipe)
						.forEach(blockFamily -> this.generateRecipes(blockFamily, FeatureFlagSet.of(FeatureFlags.VANILLA)));
				this.waxingRecipes(FeatureFlagSet.of(FeatureFlags.VANILLA));
				
				// ITEMS
				this.gildedNuggetItem(Items.POTATO, JinericItems.GOLDEN_POTATO);
				this.gildedNuggetItem(Items.SWEET_BERRIES, JinericItems.GOLDEN_SWEET_BERRIES);
				this.gildedNuggetItem(Items.BEETROOT, JinericItems.GOLDEN_BEETROOT);
				
				// BLOCKS
				this.stairs(Blocks.SMOOTH_STONE, JinericBlocks.SMOOTH_STONE_STAIRS);
				this.wall(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_STONE_WALL, Blocks.SMOOTH_STONE);
				this.wall(RecipeCategory.DECORATIONS, JinericBlocks.PURPUR_WALL, Blocks.PURPUR_BLOCK);
				this.wall(RecipeCategory.DECORATIONS, JinericBlocks.QUARTZ_WALL, Blocks.QUARTZ_BLOCK);
				this.offerFenceRecipe(Blocks.RED_NETHER_BRICKS, Items.NETHER_BRICK, JinericBlocks.RED_NETHER_BRICK_FENCE);
				this.polished(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_STONE, Blocks.STONE);
				this.polished(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
				this.polished(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_SANDSTONE, Blocks.CUT_SANDSTONE);
				this.polished(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE);
				this.polished(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_SOUL_SANDSTONE, JinericBlocks.CUT_SOUL_SANDSTONE);
				this.offer2x2To4Building(JinericBlocks.STONE_TILES, Blocks.STONE_BRICKS);
				this.offer2x2To4Building(JinericBlocks.POLISHED_DRIPSTONE, JinericBlocks.DRIPSTONE_BRICKS);
				this.offer2x2To4Building(JinericBlocks.DRIPSTONE_BRICKS, JinericBlocks.DRIPSTONE_TILES);
				this.offerPillar(JinericBlocks.DRIPSTONE_BRICKS, JinericBlocks.DRIPSTONE_BRICK_PILLAR);
				this.offerPillar(Blocks.TUFF_BRICKS, JinericBlocks.TUFF_BRICK_PILLAR);
				this.offerWavy(JinericBlocks.WAVY_SANDSTONE, Blocks.SANDSTONE);
				this.offerWavy(JinericBlocks.WAVY_RED_SANDSTONE, Blocks.RED_SANDSTONE);
				this.offerWavy(JinericBlocks.WAVY_SOUL_SANDSTONE, JinericBlocks.SOUL_SANDSTONE);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.BLAZE_ROD, RecipeCategory.BUILDING_BLOCKS, JinericItems.BLAZE_ROD_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.ENDER_PEARL_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.PAPER_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.PRISMARINE_CRYSTALS, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.STICK, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.STICK_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.FLINT, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.FLINT_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.ROTTEN_FLESH_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.BONE_MEAL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.BONE_MEAL_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.EGG, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.EGG_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SUGAR_BLOCK);
				this.nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CHARCOAL_BLOCK);
				
				// Smelting
				this.blockSmelting(JinericBlocks.CRACKED_STONE_TILES, JinericBlocks.STONE_TILES);
				this.blockSmelting(JinericBlocks.CRACKED_TUFF_TILES, JinericBlocks.TUFF_TILES);
				this.blockSmelting(JinericBlocks.CRACKED_DRIPSTONE_BRICKS, JinericBlocks.DRIPSTONE_BRICKS);
				this.blockSmelting(JinericBlocks.CRACKED_DRIPSTONE_TILES, JinericBlocks.DRIPSTONE_TILES);
				this.blockSmelting(JinericBlocks.SMOOTH_DEEPSLATE, Blocks.DEEPSLATE);
				this.blockSmelting(JinericBlocks.SMOOTH_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
				this.blockSmelting(JinericBlocks.SMOOTH_SOUL_SANDSTONE, JinericBlocks.SOUL_SANDSTONE);
				this.blockSmelting(JinericBlocks.SMOOTH_TUFF, Blocks.TUFF);
				
				// Refining
				this.refiningBlockFamily(JinericBlockFamilies.COBBLESTONE, JinericBlockFamilies.STONE);
				this.refiningBlockFamily(JinericBlockFamilies.STONE, JinericBlockFamilies.SMOOTH_STONE);
				this.refiningBlockFamily(JinericBlockFamilies.TUFF, JinericBlockFamilies.SMOOTH_TUFF);
				this.refiningBlockFamily(JinericBlockFamilies.SANDSTONE, JinericBlockFamilies.SMOOTH_SANDSTONE);
				this.refiningBlockFamily(JinericBlockFamilies.RED_SANDSTONE, JinericBlockFamilies.SMOOTH_RED_SANDSTONE);
				this.refiningBlockFamily(JinericBlockFamilies.SOUL_SANDSTONE, JinericBlockFamilies.SMOOTH_SOUL_SANDSTONE);
				this.refiningBlockFamily(BlockFamilies.STONE_BRICK, JinericBlockFamilies.CRACKED_STONE_BRICKS);
				this.refiningBlockFamily(JinericBlockFamilies.STONE_TILES, JinericBlockFamilies.CRACKED_STONE_TILES);
				this.refiningBlockFamily(BlockFamilies.DEEPSLATE_BRICKS, JinericBlockFamilies.CRACKED_DEEPSLATE_BRICKS);
				this.refiningBlockFamily(BlockFamilies.DEEPSLATE_TILES, JinericBlockFamilies.CRACKED_DEEPSLATE_TILES);
				this.refiningBlockFamily(JinericBlockFamilies.DRIPSTONE_BRICKS, JinericBlockFamilies.CRACKED_DRIPSTONE_BRICKS);
				this.refiningBlockFamily(JinericBlockFamilies.DRIPSTONE_TILES, JinericBlockFamilies.CRACKED_DRIPSTONE_TILES);
				this.refiningBlockFamily(JinericBlockFamilies.DRIPSTONE_BLOCK, JinericBlockFamilies.SMOOTH_DRIPSTONE);
				this.refiningBlockFamily(BlockFamilies.NETHER_BRICKS, JinericBlockFamilies.CRACKED_NETHER_BRICKS);
				this.refiningBlockFamily(BlockFamilies.POLISHED_BLACKSTONE_BRICKS, JinericBlockFamilies.CRACKED_POLISHED_BLACKSTONE_BRICKS);
				this.refiningBlockFamily(JinericBlockFamilies.QUARTZ, JinericBlockFamilies.SMOOTH_QUARTZ);
				this.refiningBlockFamily(JinericBlockFamilies.COBBLED_DEEPSLATE, JinericBlockFamilies.SMOOTH_DEEPSLATE, Blocks.DEEPSLATE);
				this.refining(Blocks.SAND, Blocks.GLASS);
				this.refining(Blocks.BASALT, Blocks.SMOOTH_BASALT);
				this.refining(Blocks.CLAY, Blocks.TERRACOTTA);
				this.refining(Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA);
				this.refining(Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
				this.refining(Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA);
				this.refining(Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA);
				this.refining(Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA);
				this.refining(Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA);
				this.refining(Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA);
				this.refining(Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA);
				this.refining(Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA);
				this.refining(Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA);
				this.refining(Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA);
				this.refining(Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
				this.refining(Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA);
				this.refining(Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA);
				this.refining(Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA);
				this.refining(Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA);
				this.refining(Blocks.WET_SPONGE, Blocks.SPONGE, RecipeCategory.MISC, CookingBookCategory.MISC, 0.2F);
				
				// STONECUTTING
				this.genStonecuttingFromFamilyBase(JinericBlocks.SNOW_BRICKS, JinericBlockFamilies.SNOW_BRICKS);
				this.genStonecuttingFromFamilyBase(Blocks.SMOOTH_BASALT, JinericBlockFamilies.SMOOTH_BASALT);
				this.genStonecuttingFromFamilyBase(JinericBlocks.SMOOTH_TUFF, JinericBlockFamilies.SMOOTH_TUFF);
				this.genStonecuttingFromFamilyBase(Blocks.STONE, JinericBlockFamilies.POLISHED_STONE, JinericBlockFamilies.STONE_TILES);
				this.genStonecuttingFromFamilyBase(Blocks.SMOOTH_STONE, JinericBlockFamilies.SMOOTH_STONE);
				this.genStonecuttingFromFamilyBase(Blocks.CRACKED_STONE_BRICKS, JinericBlockFamilies.CRACKED_STONE_BRICKS);
				this.genStonecuttingFromFamilyBase(JinericBlocks.SMOOTH_DEEPSLATE, JinericBlockFamilies.SMOOTH_DEEPSLATE);
				this.genStonecuttingFromFamilyBase(Blocks.DRIPSTONE_BLOCK,
						JinericBlockFamilies.DRIPSTONE_BLOCK,
						JinericBlockFamilies.POLISHED_DRIPSTONE,
						JinericBlockFamilies.DRIPSTONE_BRICKS,
						JinericBlockFamilies.DRIPSTONE_TILES);
				this.genStonecuttingFromFamilyBase(JinericBlocks.POLISHED_DRIPSTONE,
						JinericBlockFamilies.POLISHED_DRIPSTONE,
						JinericBlockFamilies.DRIPSTONE_BRICKS,
						JinericBlockFamilies.DRIPSTONE_TILES);
				this.genStonecuttingFromFamilyBase(JinericBlocks.DRIPSTONE_BRICKS, JinericBlockFamilies.DRIPSTONE_BRICKS, JinericBlockFamilies.DRIPSTONE_TILES);
				this.genStonecuttingFromFamilyBase(JinericBlocks.DRIPSTONE_TILES, JinericBlockFamilies.DRIPSTONE_TILES);
				this.genStonecuttingFromFamilyBase(Blocks.SANDSTONE, JinericBlockFamilies.POLISHED_SANDSTONE, JinericBlockFamilies.WAVY_SANDSTONE);
				this.genStonecuttingFromFamilyBase(Blocks.CUT_SANDSTONE, JinericBlockFamilies.CUT_SANDSTONE, JinericBlockFamilies.POLISHED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.POLISHED_SANDSTONE, JinericBlockFamilies.POLISHED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.WAVY_SANDSTONE, JinericBlockFamilies.WAVY_SANDSTONE);
				this.genStonecuttingFromFamilyBase(Blocks.RED_SANDSTONE, JinericBlockFamilies.POLISHED_RED_SANDSTONE, JinericBlockFamilies.WAVY_RED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(Blocks.CUT_RED_SANDSTONE, JinericBlockFamilies.CUT_RED_SANDSTONE, JinericBlockFamilies.POLISHED_RED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.POLISHED_RED_SANDSTONE, JinericBlockFamilies.POLISHED_RED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.WAVY_RED_SANDSTONE, JinericBlockFamilies.WAVY_RED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.SOUL_SANDSTONE,
						JinericBlockFamilies.SOUL_SANDSTONE,
						JinericBlockFamilies.CUT_SOUL_SANDSTONE,
						JinericBlockFamilies.POLISHED_SOUL_SANDSTONE,
						JinericBlockFamilies.WAVY_SOUL_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.CUT_SOUL_SANDSTONE, JinericBlockFamilies.CUT_SOUL_SANDSTONE, JinericBlockFamilies.POLISHED_SOUL_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.POLISHED_SOUL_SANDSTONE, JinericBlockFamilies.POLISHED_SOUL_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.WAVY_SOUL_SANDSTONE, JinericBlockFamilies.WAVY_SOUL_SANDSTONE);
				this.genStonecuttingFromFamilyBase(Blocks.CRACKED_NETHER_BRICKS, JinericBlockFamilies.CRACKED_NETHER_BRICKS);
				this.genStonecuttingFromFamilyBase(Blocks.QUARTZ_BLOCK, JinericBlockFamilies.QUARTZ, JinericBlockFamilies.QUARTZ_BRICKS);
				this.genStonecuttingFromFamilyBase(Blocks.QUARTZ_BRICKS, JinericBlockFamilies.QUARTZ_BRICKS);
				this.genStonecuttingFromFamilyBase(Blocks.OBSIDIAN, JinericBlockFamilies.OBSIDIAN);
				this.genStonecuttingFromFamilyBase(Blocks.CALCITE, JinericBlockFamilies.CALCITE);
				this.genStonecuttingFromFamilyBase(Blocks.CUT_COPPER, JinericBlockFamilies.CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.EXPOSED_CUT_COPPER, JinericBlockFamilies.EXPOSED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WEATHERED_CUT_COPPER, JinericBlockFamilies.WEATHERED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.OXIDIZED_CUT_COPPER, JinericBlockFamilies.OXIDIZED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WAXED_CUT_COPPER, JinericBlockFamilies.WAXED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WAXED_EXPOSED_CUT_COPPER, JinericBlockFamilies.WAXED_EXPOSED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WAXED_WEATHERED_CUT_COPPER, JinericBlockFamilies.WAXED_WEATHERED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WAXED_OXIDIZED_CUT_COPPER, JinericBlockFamilies.WAXED_OXIDIZED_CUT_COPPER);
				this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CUT_SANDSTONE_STAIRS, Blocks.SANDSTONE);
				this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CUT_RED_SANDSTONE_STAIRS, Blocks.RED_SANDSTONE);
				this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.STONE_BRICK_PILLAR, Blocks.STONE);
				this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.STONE_BRICK_PILLAR, Blocks.STONE_BRICKS);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.CUT_SANDSTONE_WALL, Blocks.SANDSTONE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.CUT_RED_SANDSTONE_WALL, Blocks.RED_SANDSTONE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.STONE_WALL, Blocks.STONE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.PRISMARINE_BRICK_WALL, Blocks.PRISMARINE_BRICKS);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.DARK_PRISMARINE_WALL, Blocks.DARK_PRISMARINE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.POLISHED_GRANITE_WALL, Blocks.POLISHED_GRANITE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.POLISHED_DIORITE_WALL, Blocks.POLISHED_DIORITE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.POLISHED_ANDESITE_WALL, Blocks.POLISHED_ANDESITE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_SANDSTONE_WALL, Blocks.SMOOTH_SANDSTONE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_RED_SANDSTONE_WALL, Blocks.SMOOTH_RED_SANDSTONE);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_QUARTZ_WALL, Blocks.SMOOTH_QUARTZ);
				this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, JinericBlocks.PURPUR_WALL, Blocks.PURPUR_BLOCK);
				
				// CUSTOM
				this.shaped(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SOUL_JACK_O_LANTERN)
						.define('P', Blocks.CARVED_PUMPKIN)
						.define('T', Blocks.SOUL_TORCH)
						.pattern("P")
						.pattern("T")
						.group("jack_o_lantern")
						.unlockedBy("has_carved_pumpkin", this.has(Blocks.CARVED_PUMPKIN))
						.save(recipeOutput);
				this.shaped(RecipeCategory.DECORATIONS, JinericBlocks.REDSTONE_CAMPFIRE)
						.define('S', Items.STICK)
						.define('R', Items.REDSTONE)
						.define('L', ItemTags.LOGS)
						.pattern(" S ")
						.pattern("SRS")
						.pattern("LLL")
						.unlockedBy("has_stick", this.has(Items.STICK))
						.unlockedBy("has_coal", this.has(ItemTags.COALS))
						.save(recipeOutput);
				this.shaped(RecipeCategory.DECORATIONS, JinericBlocks.REDSTONE_LANTERN)
						.define('#', Blocks.REDSTONE_TORCH)
						.define('X', Items.IRON_NUGGET)
						.pattern("XXX")
						.pattern("X#X")
						.pattern("XXX")
						.unlockedBy("has_iron_nugget", this.has(Items.IRON_NUGGET))
						.unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
						.save(recipeOutput);
				this.shaped(RecipeCategory.DECORATIONS, JinericBlocks.REFINERY)
						.define('P', Blocks.POLISHED_DEEPSLATE)
						.define('F', Blocks.FURNACE)
						.define('T', Blocks.DEEPSLATE_TILES)
						.pattern("PPP")
						.pattern("PFP")
						.pattern("TTT")
						.group("")
						.unlockedBy("has_polished_deepslate", has(Items.POLISHED_DEEPSLATE))
						.save(recipeOutput);
				this.shaped(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.GRASS_BLOCK, 3)
						.define('G', Blocks.GRASS_BLOCK)
						.pattern("GG")
						.pattern("GG")
						.unlockedBy("has_grass_block", this.has(Blocks.GRASS_BLOCK))
						.save(recipeOutput);
			}
			
			@Override
			public void generateRecipes(BlockFamily blockFamily, FeatureFlagSet featureFlagSet) {
				blockFamily.getVariants()
						.forEach(
								(variant, block) -> {
									if (block.requiredFeatures().isSubsetOf(featureFlagSet) && BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("jineric")) {
										RecipeProvider.FamilyRecipeProvider blockFamilyRecipeFactory = SHAPE_BUILDERS.get(variant);
										ItemLike itemLike = this.getBaseBlock(blockFamily, variant);
										if (blockFamilyRecipeFactory != null) {
											RecipeBuilder craftingRecipeJsonBuilder = blockFamilyRecipeFactory.create(this, block, itemLike);
											blockFamily.getRecipeGroupPrefix().ifPresent(group -> craftingRecipeJsonBuilder.group(
													group + (variant == BlockFamily.Variant.CUT ? "" : "_" + variant.getRecipeGroup()))
											);
											craftingRecipeJsonBuilder.unlockedBy(
													blockFamily.getRecipeUnlockedBy().orElseGet(() -> getHasName(itemLike)), this.has(itemLike)
											);
											craftingRecipeJsonBuilder.save(recipeOutput);
										}
										
										if (variant == BlockFamily.Variant.CRACKED) {
											this.smeltingResultFromBase(block, itemLike);
										}
										if (variant == JinericBlockFamilyVariants.TRAPPED_CHEST) {
											this.offerTrappedChest(blockFamily.get(JinericBlockFamilyVariants.CHEST), blockFamily.get(JinericBlockFamilyVariants.TRAPPED_CHEST));
										}
									}
								}
						);
			}

			public void waxingRecipes(FeatureFlagSet featureFlagSet) {
				HoneycombItem.WAXABLES.get()
						.forEach(
								(unwaxed, waxed) -> {
									if (waxed.requiredFeatures().isSubsetOf(featureFlagSet) && BuiltInRegistries.BLOCK.getKey(unwaxed).getNamespace().equals("jineric")) {
										this.shapeless(RecipeCategory.BUILDING_BLOCKS, waxed)
												.requires(unwaxed)
												.requires(Items.HONEYCOMB)
												.group(getItemName(waxed))
												.unlockedBy(getHasName(unwaxed), this.has(unwaxed))
												.save(recipeOutput, getConversionRecipeName(waxed, Items.HONEYCOMB));
									}
								}
						);
			}
			
			public void genStonecuttingFromFamilyBase(Block input, BlockFamily... inputFamilies) {
				DefaultedRegistry<Block> blockRegistry = BuiltInRegistries.BLOCK;
				Arrays.stream(inputFamilies).iterator().forEachRemaining(blockFamily -> {
					Stream<Block> variant = blockFamily.getVariants().values().stream();
					if (input != blockFamily.getBaseBlock()) {
						this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, blockFamily.getBaseBlock(), input);
					}
					variant.filter(block -> blockRegistry.getKey(block).getNamespace().equals("jineric"))
							.forEach(block -> {
								if (block == blockFamily.get(BlockFamily.Variant.STAIRS)) {
									this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, block, input);
								}
								if (block == blockFamily.get(BlockFamily.Variant.SLAB)) {
									this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, block, input, 2);
								}
								if (block == blockFamily.get(BlockFamily.Variant.WALL)) {
									this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, block, input);
								}
							});
				});
			}
			
			public void refiningBlockFamily(BlockFamily blockFamilyIn, BlockFamily blockFamilyOut) {
				this.refiningBlockFamily(blockFamilyIn, blockFamilyOut, null);
			}
			
			public void refiningBlockFamily(BlockFamily blockFamilyIn, BlockFamily blockFamilyOut, Block uniqueBase) {
				String group = ""; //BuiltInRegistries.BLOCK.getKey(blockFamilyOut.getBaseBlock()).getPath()
				if (uniqueBase != null) {
					this.refining(uniqueBase, blockFamilyOut.getBaseBlock(), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, 0.1F, group);
				} else {
					this.refining(blockFamilyIn.getBaseBlock(), blockFamilyOut.getBaseBlock(), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, 0.1F, group);
				}
				this.refining(blockFamilyIn.get(BlockFamily.Variant.STAIRS), blockFamilyOut.get(BlockFamily.Variant.STAIRS), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, 0.1F, group);
				this.refining(blockFamilyIn.get(BlockFamily.Variant.SLAB), blockFamilyOut.get(BlockFamily.Variant.SLAB), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, 0.1F, group);
				this.refining(blockFamilyIn.get(BlockFamily.Variant.WALL), blockFamilyOut.get(BlockFamily.Variant.WALL), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, 0.1F, group);
			}
			
			public void blockSmelting(ItemLike output, ItemLike input) {
				SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output.asItem(), 0.1F, 200)
						.unlockedBy("has_" + input, this.has(input))
						.save(recipeOutput);
			}
			
			public void gildedNuggetItem(ItemLike input, ItemLike output) {
				this.shaped(RecipeCategory.FOOD, output)
						.define('N', Items.GOLD_NUGGET)
						.define('I', input)
						.pattern("NNN")
						.pattern("NIN")
						.pattern("NNN")
						.group("nugget_gilded")
						.unlockedBy("has_gold_nugget", this.has(Items.GOLD_NUGGET))
						.save(recipeOutput);
			}
			
			public void refining(ItemLike input, ItemLike output) {
				this.refining(input, output, RecipeCategory.MISC, CookingBookCategory.MISC, 0.1F);
			}
			
			public void refining(ItemLike input, ItemLike output, String group) {
				this.refining(input, output, RecipeCategory.MISC, CookingBookCategory.MISC, 0.1F, group);
			}
			
			public void refining(ItemLike input, ItemLike output, RecipeCategory category, CookingBookCategory cookingRecipeCategory, float experience) {
				this.createRefining(Ingredient.of(input), output, category, cookingRecipeCategory, experience, 100)
						.unlockedBy(getHasName(input), this.has(input))
						.save(recipeOutput, getItemName(output) + "_from_refining_" + getItemName(input));
			}
			
			public void refining(ItemLike input, ItemLike output, RecipeCategory category, CookingBookCategory cookingRecipeCategory, float experience, String group) {
				this.createRefining(Ingredient.of(input), output, category, cookingRecipeCategory, experience, 100)
						.group(group)
						.unlockedBy(getHasName(input), this.has(input))
						.save(recipeOutput, getItemName(output) + "_from_refining_" + getItemName(input));
			}
			
			public SimpleCookingRecipeBuilder createRefining(Ingredient input, ItemLike output, RecipeCategory category, CookingBookCategory cookingRecipeCategory, float experience, int cookingTime) {
				return CookingRecipeJsonBuilderAccessor.invokeInit(category, cookingRecipeCategory, output, input, experience, cookingTime, RefiningRecipe::new);
			}
			
			public void stairs(ItemLike input, ItemLike output) {
				this.stairBuilder(output, Ingredient.of(input))
						.unlockedBy("has_" + input, this.has(input))
						.save(recipeOutput);
			}
			
			public void offerChest(ItemLike input, ItemLike output) {
				this.shaped(RecipeCategory.DECORATIONS, output)
						.define('#', input)
						.pattern("###")
						.pattern("# #")
						.pattern("###")
						.group("chest")
						.unlockedBy(
								"has_lots_of_items",
								CriteriaTriggers.INVENTORY_CHANGED
										.createCriterion(
												new InventoryChangeTrigger.TriggerInstance(
														Optional.empty(),
														new InventoryChangeTrigger.TriggerInstance.Slots(MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY),
														List.of()
												)
										)
						).save(recipeOutput);
			}
			
			public void offerTrappedChest(ItemLike input, ItemLike output) {
				this.trappedChestBuilder$jineric(Ingredient.of(input), output)
						.group("wooden_" + getItemName(Blocks.TRAPPED_CHEST))
						.unlockedBy(getHasName(input), this.has(input))
						.unlockedBy(getHasName(Items.TRIPWIRE_HOOK), this.has(Items.TRIPWIRE_HOOK))
						.save(recipeOutput);
			}
			
			public void offerLadder(ItemLike input, ItemLike output) {
				this.shaped(RecipeCategory.DECORATIONS, output, 6)
						.define('#', input)
						.define('/', Items.STICK)
						.pattern("# #")
						.pattern("#/#")
						.pattern("# #")
						.group("ladder")
						.unlockedBy("has_stick", this.has(Items.STICK))
						.save(recipeOutput);
			}
			
			public void offerBookshelf(ItemLike input, ItemLike output) {
				this.shaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
						.define('M', input)
						.define('B', Items.BOOK)
						.pattern("MMM")
						.pattern("BBB")
						.pattern("MMM")
						.group("bookshelf")
						.unlockedBy("has_book", this.has(Items.BOOK))
						.save(recipeOutput);
			}
			
			public void offerFenceRecipe(ItemLike inputOuter, ItemLike inputInner, ItemLike output) {
				this.shaped(RecipeCategory.DECORATIONS, output, 6)
						.define('#', inputOuter)
						.define('&', inputInner)
						.pattern("#&#")
						.pattern("#&#")
						.unlockedBy("has_" + inputOuter, this.has(inputOuter))
						.save(recipeOutput);
			}
			
			public void offerWavy(ItemLike output, ItemLike input) {
				this.shaped(RecipeCategory.BUILDING_BLOCKS, output, 3)
						.define('#', input)
						.pattern("# #")
						.pattern(" # ")
						.unlockedBy("has_" + input, this.has(input))
						.save(recipeOutput);
			}
			
			public void offerPillar(ItemLike input, ItemLike output) {
				int count = input instanceof SlabBlock ? 1 : 2;
				this.shaped(RecipeCategory.BUILDING_BLOCKS, output, count)
						.define('#', input)
						.pattern("#")
						.pattern("#")
						.unlockedBy("has_" + input, this.has(input))
						.save(recipeOutput);
			}
			
			public void offer2x2To4Building(ItemLike input, ItemLike output) {
				this.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
						.define('S', input)
						.pattern("SS")
						.pattern("SS")
						.unlockedBy("has_" + input, this.has(input))
						.save(recipeOutput);
			}

//         public void offerIronUpgradeRecipe(Item input, RecipeCategory category, Item result) {
//         SmithingTransformRecipeJsonBuilder.create(
//                      Ingredient.of(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE),
//                      Ingredient.of(input),
//                      Ingredient.of(Items.IRON_INGOT), category, result)
//              .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
//              .save(recipeOutput, getItemName(result) + "_smithing");
//         }
		};
	}
	
	@Override
	public String getName() {
		return "Recipes";
	}
}
