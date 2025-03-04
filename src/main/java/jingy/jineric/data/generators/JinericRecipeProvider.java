package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.item.JinericItems;
import jingy.jineric.mixin.access.CookingRecipeJsonBuilderAccessor;
import jingy.jineric.recipe.RefiningRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WoodType;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static jingy.jineric.data.family.JinericBlockFamilies.*;
import static net.minecraft.data.family.BlockFamily.Variant.*;

public class JinericRecipeProvider extends FabricRecipeProvider {
	public JinericRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
		return new RecipeGenerator(wrapperLookup, recipeExporter) {
			
			@Override
			public void generate() {
				BlockFamilies.getFamilies()
						.filter(blockFamily -> blockFamily.shouldGenerateRecipes() && blockFamily.jineric_mod$isModded())
						.forEach(blockFamily -> this.generateFamily(blockFamily, FeatureSet.of(FeatureFlags.VANILLA)));
				RegistryEntryLookup<Item> itemRegistryEntryLookup = registries.getOrThrow(RegistryKeys.ITEM);
// ITEMS
				this.genVanillaWoodFamilyAdditions();
				this.genVanillaFamilyAdditions();
				this.offerGildedNuggetItem(Items.POTATO, JinericItems.GOLDEN_POTATO);
				this.offerGildedNuggetItem(Items.SWEET_BERRIES, JinericItems.GOLDEN_SWEET_BERRIES);
				this.offerGildedNuggetItem(Items.BEETROOT, JinericItems.GOLDEN_BEETROOT);
				this.offerNetheriteUpgradeRecipe(Items.DIAMOND_HORSE_ARMOR, RecipeCategory.COMBAT, JinericItems.NETHERITE_HORSE_ARMOR);
// BLOCKS
				this.offerStairs(Blocks.SMOOTH_STONE, JinericBlocks.SMOOTH_STONE_STAIRS);
				this.offerWallRecipe(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_STONE_WALL, Blocks.SMOOTH_STONE);
				this.offerFenceRecipe(Blocks.RED_NETHER_BRICKS, Items.NETHER_BRICK, JinericBlocks.RED_NETHER_BRICK_FENCE);
				this.offerPolishedStoneRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_STONE, Blocks.STONE);
				this.offerPolishedStoneRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
				this.offerPolishedStoneRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_SANDSTONE, Blocks.CUT_SANDSTONE);
				this.offerPolishedStoneRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE);
				this.offerPolishedStoneRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.POLISHED_SOUL_SANDSTONE, JinericBlocks.CUT_SOUL_SANDSTONE);
				this.offer2x2To4Building(JinericBlocks.STONE_TILES, Blocks.STONE_BRICKS);
				this.offer2x2To4Building(JinericBlocks.POLISHED_DRIPSTONE, JinericBlocks.DRIPSTONE_BRICKS);
				this.offer2x2To4Building(JinericBlocks.DRIPSTONE_BRICKS, JinericBlocks.DRIPSTONE_TILES);
				this.offerPillar(JinericBlocks.DRIPSTONE_BRICKS, JinericBlocks.DRIPSTONE_BRICK_PILLAR);
				this.offerPillar(Blocks.TUFF_BRICKS, JinericBlocks.TUFF_BRICK_PILLAR);
				this.offerWavy(JinericBlocks.WAVY_SANDSTONE, Blocks.SANDSTONE);
				this.offerWavy(JinericBlocks.WAVY_RED_SANDSTONE, Blocks.RED_SANDSTONE);
				this.offerWavy(JinericBlocks.WAVY_SOUL_SANDSTONE, JinericBlocks.SOUL_SANDSTONE);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.BLAZE_ROD, RecipeCategory.BUILDING_BLOCKS, JinericItems.BLAZE_ROD_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.ENDER_PEARL_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.PAPER_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.PRISMARINE_CRYSTALS, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.STICK, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.STICK_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.FLINT, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.FLINT_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.ROTTEN_FLESH_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.BONE_MEAL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.BONE_MEAL_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.EGG, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.EGG_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SUGAR_BLOCK);
				this.offerReversibleCompactingRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CHARCOAL_BLOCK);
				// Smelting
				this.offerBlockSmelting(JinericBlocks.CRACKED_STONE_TILES, JinericBlocks.STONE_TILES);
				this.offerBlockSmelting(JinericBlocks.CRACKED_TUFF_TILES, JinericBlocks.TUFF_TILES);
				this.offerBlockSmelting(JinericBlocks.CRACKED_DRIPSTONE_BRICKS, JinericBlocks.DRIPSTONE_BRICKS);
				this.offerBlockSmelting(JinericBlocks.CRACKED_DRIPSTONE_TILES, JinericBlocks.DRIPSTONE_TILES);
				this.offerBlockSmelting(JinericBlocks.SMOOTH_DEEPSLATE, Blocks.DEEPSLATE);
				this.offerBlockSmelting(JinericBlocks.SMOOTH_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
				this.offerBlockSmelting(JinericBlocks.SMOOTH_SOUL_SANDSTONE, JinericBlocks.SOUL_SANDSTONE);
				this.offerBlockSmelting(JinericBlocks.SMOOTH_TUFF, Blocks.TUFF);
				// Refining
				this.offerRefiningBlockFamily(JinericBlockFamilies.COBBLESTONE, JinericBlockFamilies.STONE);
				this.offerRefiningBlockFamily(JinericBlockFamilies.STONE, JinericBlockFamilies.SMOOTH_STONE);
				this.offerRefiningBlockFamily(JinericBlockFamilies.TUFF, JinericBlockFamilies.SMOOTH_TUFF);
				this.offerRefiningBlockFamily(JinericBlockFamilies.SANDSTONE, JinericBlockFamilies.SMOOTH_SANDSTONE);
				this.offerRefiningBlockFamily(JinericBlockFamilies.RED_SANDSTONE, JinericBlockFamilies.SMOOTH_RED_SANDSTONE);
				this.offerRefiningBlockFamily(JinericBlockFamilies.SOUL_SANDSTONE, JinericBlockFamilies.SMOOTH_SOUL_SANDSTONE);
				this.offerRefiningBlockFamily(BlockFamilies.STONE_BRICK, JinericBlockFamilies.CRACKED_STONE_BRICKS);
				this.offerRefiningBlockFamily(JinericBlockFamilies.STONE_TILES, JinericBlockFamilies.CRACKED_STONE_TILES);
				this.offerRefiningBlockFamily(BlockFamilies.DEEPSLATE_BRICK, JinericBlockFamilies.CRACKED_DEEPSLATE_BRICKS);
				this.offerRefiningBlockFamily(BlockFamilies.DEEPSLATE_TILE, JinericBlockFamilies.CRACKED_DEEPSLATE_TILES);
				this.offerRefiningBlockFamily(JinericBlockFamilies.DRIPSTONE_BRICKS, JinericBlockFamilies.CRACKED_DRIPSTONE_BRICKS);
				this.offerRefiningBlockFamily(JinericBlockFamilies.DRIPSTONE_TILES, JinericBlockFamilies.CRACKED_DRIPSTONE_TILES);
				this.offerRefiningBlockFamily(JinericBlockFamilies.DRIPSTONE_BLOCK, JinericBlockFamilies.SMOOTH_DRIPSTONE);
				this.offerRefiningBlockFamily(BlockFamilies.NETHER_BRICK, JinericBlockFamilies.CRACKED_NETHER_BRICKS);
				this.offerRefiningBlockFamily(BlockFamilies.POLISHED_BLACKSTONE_BRICK, JinericBlockFamilies.CRACKED_POLISHED_BLACKSTONE_BRICKS);
				this.offerRefiningBlockFamily(JinericBlockFamilies.QUARTZ_BLOCK, JinericBlockFamilies.SMOOTH_QUARTZ);
				this.offerRefiningBlockFamily(JinericBlockFamilies.COBBLED_DEEPSLATE, JinericBlockFamilies.SMOOTH_DEEPSLATE, Blocks.DEEPSLATE);
				this.offerRefining(Blocks.SAND, Blocks.GLASS);
				this.offerRefining(Blocks.BASALT, Blocks.SMOOTH_BASALT);
				this.offerRefining(Blocks.CLAY, Blocks.TERRACOTTA);
				this.offerRefining(Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, "glazed_terracotta");
				this.offerRefining(Blocks.WET_SPONGE, Blocks.SPONGE, RecipeCategory.MISC, CookingRecipeCategory.MISC, 0.2F);
// STONECUTTING
				this.genStonecuttingFromFamilyBase(JinericBlocks.SNOW_BRICKS, SNOW_BRICKS);
				this.genStonecuttingFromFamilyBase(Blocks.SMOOTH_BASALT, SMOOTH_BASALT);
				this.genStonecuttingFromFamilyBase(JinericBlocks.SMOOTH_TUFF, SMOOTH_TUFF);
				this.genStonecuttingFromFamilyBase(Blocks.STONE, POLISHED_STONE, STONE_TILES);
				this.genStonecuttingFromFamilyBase(Blocks.SMOOTH_STONE, SMOOTH_STONE);
				this.genStonecuttingFromFamilyBase(Blocks.CRACKED_STONE_BRICKS, CRACKED_STONE_BRICKS);
				this.genStonecuttingFromFamilyBase(JinericBlocks.SMOOTH_DEEPSLATE, SMOOTH_DEEPSLATE);
				this.genStonecuttingFromFamilyBase(Blocks.DRIPSTONE_BLOCK, DRIPSTONE_BLOCK, POLISHED_DRIPSTONE, DRIPSTONE_BRICKS, DRIPSTONE_TILES);
				this.genStonecuttingFromFamilyBase(JinericBlocks.POLISHED_DRIPSTONE, POLISHED_DRIPSTONE, DRIPSTONE_BRICKS, DRIPSTONE_TILES);
				this.genStonecuttingFromFamilyBase(JinericBlocks.DRIPSTONE_BRICKS, DRIPSTONE_BRICKS, DRIPSTONE_TILES);
				this.genStonecuttingFromFamilyBase(JinericBlocks.DRIPSTONE_TILES, DRIPSTONE_TILES);
				this.genStonecuttingFromFamilyBase(Blocks.SANDSTONE, POLISHED_SANDSTONE, WAVY_SANDSTONE);
				this.genStonecuttingFromFamilyBase(Blocks.CUT_SANDSTONE, CUT_SANDSTONE, POLISHED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.POLISHED_SANDSTONE, POLISHED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.WAVY_SANDSTONE, WAVY_SANDSTONE);
				this.genStonecuttingFromFamilyBase(Blocks.RED_SANDSTONE, POLISHED_RED_SANDSTONE, WAVY_RED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(Blocks.CUT_RED_SANDSTONE, CUT_RED_SANDSTONE, POLISHED_RED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.POLISHED_RED_SANDSTONE, POLISHED_RED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.WAVY_RED_SANDSTONE, WAVY_RED_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.SOUL_SANDSTONE, SOUL_SANDSTONE, CUT_SOUL_SANDSTONE, POLISHED_SOUL_SANDSTONE, WAVY_SOUL_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.CUT_SOUL_SANDSTONE, CUT_SOUL_SANDSTONE, POLISHED_SOUL_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.POLISHED_SOUL_SANDSTONE, POLISHED_SOUL_SANDSTONE);
				this.genStonecuttingFromFamilyBase(JinericBlocks.WAVY_SOUL_SANDSTONE, WAVY_SOUL_SANDSTONE);
				this.genStonecuttingFromFamilyBase(Blocks.CRACKED_NETHER_BRICKS, CRACKED_NETHER_BRICKS);
				this.genStonecuttingFromFamilyBase(Blocks.QUARTZ_BLOCK, QUARTZ_BLOCK, QUARTZ_BRICKS);
				this.genStonecuttingFromFamilyBase(Blocks.QUARTZ_BRICKS, QUARTZ_BRICKS);
				this.genStonecuttingFromFamilyBase(Blocks.OBSIDIAN, OBSIDIAN);
				this.genStonecuttingFromFamilyBase(Blocks.CALCITE, CALCITE);
				this.genStonecuttingFromFamilyBase(Blocks.CUT_COPPER, CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.EXPOSED_CUT_COPPER, EXPOSED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WEATHERED_CUT_COPPER, WEATHERED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.OXIDIZED_CUT_COPPER, OXIDIZED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WAXED_CUT_COPPER, WAXED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WAXED_EXPOSED_CUT_COPPER, WAXED_EXPOSED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WAXED_WEATHERED_CUT_COPPER, WAXED_WEATHERED_CUT_COPPER);
				this.genStonecuttingFromFamilyBase(Blocks.WAXED_OXIDIZED_CUT_COPPER, WAXED_OXIDIZED_CUT_COPPER);
				this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CUT_SANDSTONE_STAIRS, Blocks.SANDSTONE);
				this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CUT_RED_SANDSTONE_STAIRS, Blocks.RED_SANDSTONE);
				this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.STONE_BRICK_PILLAR, Blocks.STONE);
				this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.STONE_BRICK_PILLAR, Blocks.STONE_BRICKS);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.CUT_SANDSTONE_WALL, Blocks.SANDSTONE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.CUT_RED_SANDSTONE_WALL, Blocks.RED_SANDSTONE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.STONE_WALL, Blocks.STONE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.PRISMARINE_BRICK_WALL, Blocks.PRISMARINE_BRICKS);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.DARK_PRISMARINE_WALL, Blocks.DARK_PRISMARINE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.POLISHED_GRANITE_WALL, Blocks.POLISHED_GRANITE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.POLISHED_DIORITE_WALL, Blocks.POLISHED_DIORITE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.POLISHED_ANDESITE_WALL, Blocks.POLISHED_ANDESITE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_SANDSTONE_WALL, Blocks.SMOOTH_SANDSTONE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_RED_SANDSTONE_WALL, Blocks.SMOOTH_RED_SANDSTONE);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_QUARTZ_WALL, Blocks.SMOOTH_QUARTZ);
				this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, JinericBlocks.PURPUR_WALL, Blocks.PURPUR_BLOCK);
				this.createShaped(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SOUL_JACK_O_LANTERN)
						.input('P', Blocks.CARVED_PUMPKIN)
						.input('T', Blocks.SOUL_TORCH)
						.pattern("P")
						.pattern("T")
						.group("jack_o_lantern")
						.criterion("has_carved_pumpkin", this.conditionsFromItem(Blocks.CARVED_PUMPKIN))
						.offerTo(this.exporter);
				this.createShaped(RecipeCategory.DECORATIONS, JinericBlocks.REDSTONE_CAMPFIRE)
						.input('S', Items.STICK)
						.input('R', Items.REDSTONE)
						.input('L', ItemTags.LOGS)
						.pattern(" S ")
						.pattern("SRS")
						.pattern("LLL")
						.criterion("has_stick", this.conditionsFromItem(Items.STICK))
						.criterion("has_coal", this.conditionsFromTag(ItemTags.COALS))
						.offerTo(recipeExporter);
				this.createShaped(RecipeCategory.DECORATIONS, JinericBlocks.REDSTONE_LANTERN)
						.input('#', Blocks.REDSTONE_TORCH)
						.input('X', Items.IRON_NUGGET)
						.pattern("XXX")
						.pattern("X#X")
						.pattern("XXX")
						.criterion("has_iron_nugget", this.conditionsFromItem(Items.IRON_NUGGET))
						.criterion("has_iron_ingot", this.conditionsFromItem(Items.IRON_INGOT))
						.offerTo(recipeExporter);
				this.createShaped(RecipeCategory.DECORATIONS, JinericBlocks.REFINERY)
						.input('P', Blocks.POLISHED_DEEPSLATE)
						.input('F', Blocks.FURNACE)
						.input('T', Blocks.DEEPSLATE_TILES)
						.pattern("PPP")
						.pattern("PFP")
						.pattern("TTT")
						.group("")
						.criterion("has_polished_deepslate", conditionsFromItem(Items.POLISHED_DEEPSLATE))
						.offerTo(recipeExporter);
				this.createShaped(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.FULL_GRASS_BLOCK, 3)
						.input('G', Blocks.GRASS_BLOCK)
						.pattern("GG")
						.pattern("GG")
						.criterion("has_grass_block", this.conditionsFromItem(Blocks.GRASS_BLOCK))
						.offerTo(recipeExporter);
			}
			
			public void genStonecuttingFromFamilyBase(Block input, BlockFamily... inputFamilies) {
				DefaultedRegistry<Block> blockRegistry = Registries.BLOCK;
				Arrays.stream(inputFamilies).iterator().forEachRemaining(blockFamily -> {
					Stream<Block> variant = blockFamily.getVariants().values().stream();
					if (input != blockFamily.getBaseBlock()) {
						this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, blockFamily.getBaseBlock(), input);
					}
					variant.filter(block -> blockRegistry.getId(block).getNamespace().equals("jineric"))
							.forEach(block -> {
								if (block == blockFamily.getVariant(STAIRS)) {
									this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, block, input);
								}
								if (block == blockFamily.getVariant(SLAB)) {
									this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, block, input, 2);
								}
								if (block == blockFamily.getVariant(WALL)) {
									this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, block, input);
								}
							});
				});
			}
			
			public void genVanillaFamilyAdditions() {
				Stream<BlockFamily> blockFamilies = BlockFamilies.getFamilies().filter(blockFamily -> !blockFamily.jineric_mod$isModded());
				blockFamilies.forEach(blockFamily -> {
					for (Block familyVariant : blockFamily.getVariants().values()) {
						if (Registries.BLOCK.getId(familyVariant).getNamespace().matches("jineric")) {
							if (familyVariant == blockFamily.getVariant(STAIRS)) {
								this.offerStairs(blockFamily.getBaseBlock(), familyVariant);
							} else if (familyVariant == blockFamily.getVariant(SLAB)) {
								this.offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, familyVariant, blockFamily.getBaseBlock());
							} else if (familyVariant == blockFamily.getVariant(WALL)) {
								// Walls are generated in 'DECORATIONS' because vanilla does it that way (I do not like this).
								this.offerWallRecipe(RecipeCategory.DECORATIONS, familyVariant, blockFamily.getBaseBlock());
							} else if (familyVariant == blockFamily.getVariant(CHISELED)) {
								this.offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, familyVariant, blockFamily.getVariant(SLAB));
							}
						}
					}
				});
			}
			
			public void genVanillaWoodFamilyAdditions() {
				DefaultedRegistry<Block> blockRegistry = Registries.BLOCK;
				List<WoodType> woodTypes = WoodType.stream().toList();
				woodTypes.forEach(woodType ->
						blockRegistry.stream().filter(block -> blockRegistry.getId(block).getNamespace().equals("jineric"))
						.forEach(block -> {
							Block plank = blockRegistry.get(Identifier.of(woodType.name() + "_planks"));
							String blockKey = block.getTranslationKey();
							String trimmedBlockKey = blockKey
									.replace("block.jineric.", "")
									.replace("_ladder", "")
									.replace("trapped_", "").replace("_chest", "")
									.replace("_bookshelf", "");
							if (trimmedBlockKey.equals(woodType.name())) {
								this.offerWoodTypeBlock(blockKey, plank, block);
							}
						})
				);
			}
			
			public void offerWoodTypeBlock(String blockKey, Block plank, Block checkedBlock) {
				if (blockKey.contains("_chest")) {
					if (blockKey.contains("trapped_")) {
						this.offerTrappedChest(plank, checkedBlock);
					} else {
						this.offerChest(plank, checkedBlock);
					}
				} else if (blockKey.contains("_ladder")) {
					this.offerLadder(plank, checkedBlock);
				} else if (blockKey.contains("_bookshelf")) {
					this.offerBookshelf(plank, checkedBlock);
				}
			}
			
			public void offerRefiningBlockFamily(BlockFamily blockFamilyIn, BlockFamily blockFamilyOut) {
				this.offerRefiningBlockFamily(blockFamilyIn, blockFamilyOut, null);
			}
			
			public void offerRefiningBlockFamily(BlockFamily blockFamilyIn, BlockFamily blockFamilyOut, Block uniqueBase) {
				String group = Registries.BLOCK.getId(blockFamilyOut.getBaseBlock()).getPath();
				if (uniqueBase != null) {
					this.offerRefining(uniqueBase, blockFamilyOut.getBaseBlock(), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, 0.1F, group);
				} else {
					this.offerRefining(blockFamilyIn.getBaseBlock(), blockFamilyOut.getBaseBlock(), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, 0.1F, group);
				}
				this.offerRefining(blockFamilyIn.getVariant(STAIRS), blockFamilyOut.getVariant(STAIRS), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, 0.1F, group);
				this.offerRefining(blockFamilyIn.getVariant(SLAB), blockFamilyOut.getVariant(SLAB), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, 0.1F, group);
				this.offerRefining(blockFamilyIn.getVariant(WALL), blockFamilyOut.getVariant(WALL), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, 0.1F, group);
			}
			
			public void offerBlockSmelting(ItemConvertible output, ItemConvertible input) {
				CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(input), RecipeCategory.BUILDING_BLOCKS, output.asItem(), 0.1F, 200)
						.criterion("has_" + input, this.conditionsFromItem(input))
						.offerTo(recipeExporter);
			}
			
			public void offerGildedNuggetItem(ItemConvertible input, ItemConvertible output) {
				this.createShaped(RecipeCategory.FOOD, output)
						.input('N', Items.GOLD_NUGGET)
						.input('I', input)
						.pattern("NNN")
						.pattern("NIN")
						.pattern("NNN")
						.group("nugget_gilded")
						.criterion("has_gold_nugget", this.conditionsFromItem(Items.GOLD_NUGGET))
						.offerTo(recipeExporter);
			}
			
			public void offerRefining(ItemConvertible input, ItemConvertible output) {
				this.offerRefining(input, output, RecipeCategory.MISC, CookingRecipeCategory.MISC, 0.1F);
			}
			
			public void offerRefining(ItemConvertible input, ItemConvertible output, String group) {
				this.offerRefining(input, output, RecipeCategory.MISC, CookingRecipeCategory.MISC, 0.1F, group);
			}
			
			public void offerRefining(ItemConvertible input, ItemConvertible output, RecipeCategory category, CookingRecipeCategory cookingRecipeCategory, float experience) {
				this.createRefining(Ingredient.ofItem(input), output, category, cookingRecipeCategory, experience, 100)
						.criterion(hasItem(input), this.conditionsFromItem(input))
						.offerTo(recipeExporter, getItemPath(output) + "_from_refining_" + getItemPath(input));
			}
			
			public void offerRefining(ItemConvertible input, ItemConvertible output, RecipeCategory category, CookingRecipeCategory cookingRecipeCategory, float experience, String group) {
				this.createRefining(Ingredient.ofItem(input), output, category, cookingRecipeCategory, experience, 100)
						.group(group)
						.criterion(hasItem(input), this.conditionsFromItem(input))
						.offerTo(recipeExporter, getItemPath(output) + "_from_refining_" + getItemPath(input));
			}
			
			public CookingRecipeJsonBuilder createRefining(Ingredient input, ItemConvertible output, RecipeCategory category, CookingRecipeCategory cookingRecipeCategory, float experience, int cookingTime) {
				return CookingRecipeJsonBuilderAccessor.invokeInit(category, cookingRecipeCategory, output, input, experience, cookingTime, RefiningRecipe::new);
			}
			
			public void offerStairs(ItemConvertible input, ItemConvertible output) {
				this.createStairsRecipe(output, Ingredient.ofItems(input))
						.criterion("has_" + input, this.conditionsFromItem(input))
						.offerTo(recipeExporter);
			}
			
			public void offerChest(ItemConvertible input, ItemConvertible output) {
				this.createShaped(RecipeCategory.DECORATIONS, output)
						.input('#', input)
						.pattern("###")
						.pattern("# #")
						.pattern("###")
						.group("chest")
						.criterion(
								"has_lots_of_items",
								Criteria.INVENTORY_CHANGED
										.create(
												new InventoryChangedCriterion.Conditions(
														Optional.empty(),
														new InventoryChangedCriterion.Conditions.Slots(NumberRange.IntRange.atLeast(10), NumberRange.IntRange.ANY, NumberRange.IntRange.ANY),
														List.of()
												)
										)
						).offerTo(recipeExporter);
			}
			
			public void offerTrappedChest(ItemConvertible input, ItemConvertible output) {
				this.createShapeless(RecipeCategory.REDSTONE, output)
						.input(input)
						.input(Blocks.TRIPWIRE_HOOK)
						.group("trapped_chest")
						.criterion("has_tripwire_hook", this.conditionsFromItem(Blocks.TRIPWIRE_HOOK))
						.offerTo(recipeExporter);
			}
			
			public void offerLadder(ItemConvertible input, ItemConvertible output) {
				this.createShaped(RecipeCategory.DECORATIONS, output, 6)
						.input('#', input)
						.input('/', Items.STICK)
						.pattern("# #")
						.pattern("#/#")
						.pattern("# #")
						.group("ladder")
						.criterion("has_stick", this.conditionsFromItem(Items.STICK))
						.offerTo(recipeExporter);
			}
			
			public void offerBookshelf(ItemConvertible input, ItemConvertible output) {
				this.createShaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
						.input('M', input)
						.input('B', Items.BOOK)
						.pattern("MMM")
						.pattern("BBB")
						.pattern("MMM")
						.group("bookshelf")
						.criterion("has_book", this.conditionsFromItem(Items.BOOK))
						.offerTo(recipeExporter);
			}
			
			public void offerFenceRecipe(ItemConvertible inputOuter, ItemConvertible inputInner, ItemConvertible output) {
				this.createShaped(RecipeCategory.DECORATIONS, output, 6)
						.input('#', inputOuter)
						.input('&', inputInner)
						.pattern("#&#")
						.pattern("#&#")
						.criterion("has_" + inputOuter, this.conditionsFromItem(inputOuter))
						.offerTo(recipeExporter);
			}
			
			public void offerWavy(ItemConvertible output, ItemConvertible input) {
				this.createShaped(RecipeCategory.BUILDING_BLOCKS, output, 3)
						.input('#', input)
						.pattern("# #")
						.pattern(" # ")
						.criterion("has_" + input, this.conditionsFromItem(input))
						.offerTo(recipeExporter);
			}
			
			public void offerPillar(ItemConvertible input, ItemConvertible output) {
				int count = input instanceof SlabBlock ? 1 : 2;
				this.createShaped(RecipeCategory.BUILDING_BLOCKS, output, count)
						.input('#', input)
						.pattern("#")
						.pattern("#")
						.criterion("has_" + input, this.conditionsFromItem(input))
						.offerTo(recipeExporter);
			}
			
			public void offer2x2To4Building(ItemConvertible input, ItemConvertible output) {
				this.createShaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
						.input('S', input)
						.pattern("SS")
						.pattern("SS")
						.criterion("has_" + input, this.conditionsFromItem(input))
						.offerTo(recipeExporter);
			}

//         public void offerIronUpgradeRecipe(Item input, RecipeCategory category, Item result) {
//         SmithingTransformRecipeJsonBuilder.create(
//                      Ingredient.ofItems(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE),
//                      Ingredient.ofItems(input),
//                      Ingredient.ofItems(Items.IRON_INGOT), category, result)
//              .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
//              .offerTo(recipeExporter, getItemPath(result) + "_smithing");
//         }
//
//         public void offerBrickRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
//            this.createShaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
//                    .input('#', input)
//                    .pattern("##")
//                    .pattern("##")
//                    .criterion("has_" + input, conditionsFromItem(input))
//                    .offerTo(exporter);
//         }
		};
	}
	
	@Override
	public String getName() {
		return "Recipes";
	}
}
