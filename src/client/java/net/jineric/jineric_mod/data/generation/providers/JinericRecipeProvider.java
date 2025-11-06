package net.jineric.jineric_mod.data.generation.providers;

import com.google.common.collect.ImmutableMap;
import jingy.jineric.access.ShapedRecipeJsonBuilderAccess;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.EquipmentFamilies;
import jingy.jineric.data.family.EquipmentFamily;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.data.family.JinericBlockFamilyVariants;
import jingy.jineric.item.JinericItems;
import jingy.jineric.item.equipment.JmEquipmentAssetKeys;
import jingy.jineric.mixin.access.CookingRecipeJsonBuilderAccessor;
import jingy.jineric.recipe.RefiningRecipe;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WoodType;
import net.minecraft.component.ComponentChanges;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BlockStateComponent;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.recipe.*;
import net.minecraft.item.*;
import net.minecraft.predicate.NumberRange;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class JinericRecipeProvider extends FabricRecipeProvider {
	public JinericRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
		return new RecipeGenerator(wrapperLookup, recipeExporter) {
			private static final Map<BlockFamily.Variant, BlockFamilyRecipeFactory> VARIANT_FACTORIES = ImmutableMap.<BlockFamily.Variant, RecipeGenerator.BlockFamilyRecipeFactory>builder()
					.put(BlockFamily.Variant.BUTTON, (generator, output, input) -> generator.createButtonRecipe(output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.CHISELED,
							(generator, output, input) -> generator.createChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.CUT, (generator, output, input) -> generator.createCutCopperRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.DOOR, (generator, output, input) -> generator.createDoorRecipe(output, Ingredient.ofItem(input)))
//					.put(BlockFamily.Variant.CUSTOM_FENCE, (generator, output, input) -> generator.createFenceRecipe(output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.FENCE, (generator, output, input) -> generator.createFenceRecipe(output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.CUSTOM_FENCE_GATE, (generator, output, input) -> generator.createFenceGateRecipe(output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.FENCE_GATE, (generator, output, input) -> generator.createFenceGateRecipe(output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.SIGN, (generator, output, input) -> generator.createSignRecipe(output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.SLAB, (generator, output, input) -> generator.createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.STAIRS, (generator, output, input) -> generator.createStairsRecipe(output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.PRESSURE_PLATE,
							(generator, output, input) -> generator.createPressurePlateRecipe(RecipeCategory.REDSTONE, output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.POLISHED,
							(generator, output, input) -> generator.createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.TRAPDOOR, (generator, output, input) -> generator.createTrapdoorRecipe(output, Ingredient.ofItem(input)))
					.put(BlockFamily.Variant.WALL, (generator, output, input) -> generator.getWallRecipe(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItem(input)))
					.put(JinericBlockFamilyVariants.BOOKSHELF, (generator, output, input) -> generator.createBookshelf$jineric(Ingredient.ofItem(input), output))
					.put(JinericBlockFamilyVariants.CHEST, (generator, output, input) -> generator.createChest$jineric(Ingredient.ofItem(input), output))
					.put(JinericBlockFamilyVariants.LADDER, (generator, output, input) -> generator.createLadder$jineric(Ingredient.ofItem(input), output))
					.build();
			
			@Override
			public void generate() {
				this.offerWoodTypeRecipes();
				BlockFamilies.getFamilies()
						.filter(BlockFamily::shouldGenerateRecipes)
						.forEach(blockFamily -> this.generateFamily(blockFamily, FeatureSet.of(FeatureFlags.VANILLA)));
//				EquipmentFamilies.stream().forEach(equipmentFamily -> this.offerEquipmentFamily());
				
				this.offerWaxingRecipes(FeatureSet.of(FeatureFlags.VANILLA));
				
				// ITEMS
				this.offerGildedNuggetItem(Items.POTATO, JinericItems.GOLDEN_POTATO);
				this.offerGildedNuggetItem(Items.SWEET_BERRIES, JinericItems.GOLDEN_SWEET_BERRIES);
				this.offerGildedNuggetItem(Items.BEETROOT, JinericItems.GOLDEN_BEETROOT);
				this.offerNetheriteUpgradeRecipe(Items.DIAMOND_HORSE_ARMOR, RecipeCategory.COMBAT, JinericItems.NETHERITE_HORSE_ARMOR);
				
				// BLOCKS
				this.offerStairs(Blocks.SMOOTH_STONE, JinericBlocks.SMOOTH_STONE_STAIRS);
				this.offerWallRecipe(RecipeCategory.DECORATIONS, JinericBlocks.SMOOTH_STONE_WALL, Blocks.SMOOTH_STONE);
				this.offerWallRecipe(RecipeCategory.DECORATIONS, JinericBlocks.PURPUR_WALL, Blocks.PURPUR_BLOCK);
				this.offerWallRecipe(RecipeCategory.DECORATIONS, JinericBlocks.QUARTZ_WALL, Blocks.QUARTZ_BLOCK);
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
				this.genStonecuttingFromFamilyBase(Blocks.QUARTZ_BLOCK, JinericBlockFamilies.QUARTZ_BLOCK, JinericBlockFamilies.QUARTZ_BRICKS);
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
				
				//  SMITHING
				this.offerEquipmentFamilyUpgrade(EquipmentFamilies.WOODEN, EquipmentFamilies.STONE);
				
				//  CUSTOM
				//  -> Modded
				this.offerCampfireRecipe();
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
						.input('B', Blocks.BRICKS)
						.input('b', Items.BRICK)
						.input('C', JinericBlocks.CHARCOAL_BLOCK)
						.pattern("BBB")
						.pattern("BbB")
						.pattern("BCB")
						.criterion("has_charcoal", conditionsFromItem(Items.CHARCOAL))
						.offerTo(recipeExporter);
				this.createShaped(RecipeCategory.BUILDING_BLOCKS, JinericBlocks.FULL_GRASS_BLOCK, 3)
						.input('G', Blocks.GRASS_BLOCK)
						.pattern("GG")
						.pattern("GG")
						.criterion("has_grass_block", this.conditionsFromItem(Blocks.GRASS_BLOCK))
						.offerTo(recipeExporter);
				this.createShaped(RecipeCategory.DECORATIONS, JinericItems.TINDER)
						.input('T', JinericItemTags.TINDER_MATERIALS)
						.pattern("TT")
						.pattern("TT")
						.criterion("has_tinder_material", this.conditionsFromTag(JinericItemTags.TINDER_MATERIALS))
						.offerTo(recipeExporter);
				this.createShaped(RecipeCategory.TOOLS, JinericItems.BOW_DRILL)
						.input('B', Items.BOW).input('S', Items.STICK).input('L', ItemTags.LOGS_THAT_BURN)
						.pattern("B")
						.pattern("S")
						.pattern("L")
						.criterion("has_flammable_log", this.conditionsFromTag(ItemTags.LOGS_THAT_BURN))
						.offerTo(recipeExporter);
				
				this.createShaped(RecipeCategory.MISC, JinericItems.STONE_UPGRADE_SMITHING_TEMPLATE, 1)
						.input('M', Items.SMOOTH_STONE).input('S', Items.STONE)
						.input('W', ConventionalItemTags.NATURAL_WOODS).input('L', ConventionalItemTags.NATURAL_LOGS)
						.pattern("LML")
						.pattern("LSL")
						.pattern("WWW")
						.criterion("has_cobblestone", this.conditionsFromItem(Items.COBBLESTONE))
						.offerTo(recipeExporter, getItemPath(JinericItems.STONE_UPGRADE_SMITHING_TEMPLATE));
				
				this.createShaped(RecipeCategory.MISC, JinericItems.COPPER_UPGRADE_SMITHING_TEMPLATE, 1)
						.input('F', Items.SMOOTH_STONE).input('T', JinericItemTags.CUT_COPPER).input('E', Items.STONE)
						.pattern("FTF")
						.pattern("FEF")
						.pattern("FFF")
						.criterion("has_copper_ingot", this.conditionsFromItem(Items.COPPER_INGOT))
						.offerTo(recipeExporter, getItemPath(JinericItems.COPPER_UPGRADE_SMITHING_TEMPLATE));
				
				this.createShaped(RecipeCategory.MISC, JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE, 1)
						.input('F', ItemTags.COPPER).input('T', Items.IRON_BLOCK).input('E', Items.DEEPSLATE)
						.pattern("FTF")
						.pattern("FEF")
						.pattern("FFF")
//						.group(getItemPath(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE))
						.criterion("has_iron_ingot", this.conditionsFromItem(Items.IRON_INGOT))
						.offerTo(recipeExporter, getItemPath(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE));
				
				this.createShaped(RecipeCategory.MISC, JinericItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, 1)
						.input('F', Items.IRON_INGOT).input('T', Items.DIAMOND_BLOCK).input('E', Items.DEEPSLATE)
						.pattern("FTF")
						.pattern("FEF")
						.pattern("FFF")
//						.group(getItemPath(JinericItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
						.criterion("has_" + getItemPath(Items.DIAMOND), this.conditionsFromItem(Items.DIAMOND))
						.offerTo(recipeExporter, getItemPath(JinericItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE));
				
				CookingRecipeJsonBuilder.createCampfireCooking(this.ingredientFromTag(ItemTags.LOGS_THAT_BURN), RecipeCategory.MISC, Items.CHARCOAL, 0.15F, 800)
						.criterion("has_log", this.conditionsFromTag(ItemTags.LOGS_THAT_BURN))
						.offerTo(recipeExporter, "charcoal_from_campfire_cooking");
				
				CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItem(JinericItems.CLAY_BRICK), RecipeCategory.MISC, Items.BRICK, 0.1F, 600)
						.criterion("has_clay_brick", this.conditionsFromItem(JinericItems.CLAY_BRICK))
						.offerTo(recipeExporter, "brick_from_campfire_cooking");
				
				this.createShaped(RecipeCategory.MISC, JinericItems.CLAY_BRICK)
						.input('C', Items.CLAY_BALL)
						.pattern("CC")
						.criterion(hasItem(Items.CLAY_BALL), this.conditionsFromItem(Items.CLAY_BALL))
						.offerTo(recipeExporter);
				
				this.createShapeless(RecipeCategory.MISC, Items.CLAY_BALL, 2)
						.input(JinericItems.CLAY_BRICK)
						.criterion(hasItem(Items.CLAY_BALL), this.conditionsFromItem(Items.CLAY_BALL))
						.offerTo(recipeExporter);
				
				//  -> Vanilla
				this.createShapeless(RecipeCategory.MISC, Items.STRING, 4)
						.input(ItemTags.WOOL)
						.criterion("has_wool", this.conditionsFromTag(ItemTags.WOOL))
						.group("string")
						.offerTo(recipeExporter);
				this.createShaped(RecipeCategory.DECORATIONS, Blocks.SMITHING_TABLE)
						.input('S', Items.SMOOTH_STONE)
						.input('W', ItemTags.PLANKS)
						.pattern("SS")
						.pattern("WW")
						.pattern("WW")
						.criterion("has_planks", this.conditionsFromTag(ItemTags.PLANKS))
						.offerTo(recipeExporter);
				this.createShaped(RecipeCategory.DECORATIONS, Blocks.TORCH, 4)
						.input('S', Items.STICK)
						.input('C', Ingredient.ofItems(Items.COAL, Items.CHARCOAL))
						.pattern("C")
						.pattern("S")
						.criterion("has_coal", this.conditionsFromTag(ItemTags.COALS))
						.offerTo(recipeExporter, replaceVanilla(Items.TORCH));
			}
			
			@Override
			public void generateFamily(BlockFamily family, FeatureSet enabledFeatures) {
				family.getVariants()
						.forEach(
								(variant, block) -> {
									if (block.getRequiredFeatures().isSubsetOf(enabledFeatures) && Registries.BLOCK.getId(block).getNamespace().equals("jineric")) {
										RecipeGenerator.BlockFamilyRecipeFactory blockFamilyRecipeFactory = VARIANT_FACTORIES.get(variant);
										ItemConvertible itemConvertible = this.getVariantRecipeInput(family, variant);
										if (blockFamilyRecipeFactory != null) {
											CraftingRecipeJsonBuilder craftingRecipeJsonBuilder = blockFamilyRecipeFactory.create(this, block, itemConvertible);
											family.getGroup().ifPresent(group -> craftingRecipeJsonBuilder.group(group + (variant == BlockFamily.Variant.CUT ? "" : "_" + variant.getName())));
											craftingRecipeJsonBuilder.criterion(
													family.getUnlockCriterionName().orElseGet(() -> hasItem(itemConvertible)), this.conditionsFromItem(itemConvertible)
											);
											craftingRecipeJsonBuilder.offerTo(this.exporter);
										}
										
										if (variant == BlockFamily.Variant.CRACKED) {
											this.offerCrackingRecipe(block, itemConvertible);
										}
										if (variant == JinericBlockFamilyVariants.TRAPPED_CHEST) {
											this.offerTrappedChest(family.getVariant(JinericBlockFamilyVariants.CHEST), family.getVariant(JinericBlockFamilyVariants.TRAPPED_CHEST));
										}
									}
								}
						);
			}

			@Override
			public void offerWaxingRecipes(FeatureSet enabledFeatures) {
				HoneycombItem.UNWAXED_TO_WAXED_BLOCKS.get()
						.forEach(
								(unwaxed, waxed) -> {
									if (waxed != null && unwaxed != null) {
										if (waxed.getRequiredFeatures().isSubsetOf(enabledFeatures) && Registries.BLOCK.getId(unwaxed).getNamespace().equals("jineric")) {
											this.createShapeless(RecipeCategory.BUILDING_BLOCKS, waxed)
													.input(unwaxed)
													.input(Items.HONEYCOMB)
													.group(getItemPath(waxed))
													.criterion(hasItem(unwaxed), this.conditionsFromItem(unwaxed))
													.offerTo(this.exporter, convertBetween(waxed, Items.HONEYCOMB));
										}
									}
								}
						);
			}
			
			public void offerWoodTypeRecipes() {
				WoodType.stream().forEach(this::offerWoodenEquipmentVariants);
			}
			
			public void offerWoodenEquipmentVariants(WoodType woodType) {
				EquipmentFamily equipmentFamily = EquipmentFamilies.WOODEN;
				equipmentFamily.getVariants().forEach((variant, item) -> {
					String woodTypeName =  woodType.name();
					String itemPath = getItemPath(item);
					String woodTypeVariant = woodTypeName + "_" + variant;
					Item plank = Registries.ITEM.get(Identifier.of(woodTypeName + "_planks"));
					String woodenRecipeKey = woodTypeName + "_" + itemPath;
					ShapedRecipeJsonBuilder recipeBuilder = createEquipmentVariantBase(equipmentFamily, variant, item);
					recipeBuilder.input('M', plank);
					ComponentChanges.Builder componentChangesBuilder = ComponentChanges.builder();
					if (variant.isArmor()) {
						componentChangesBuilder.add(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(variant.equipmentSlot()).model(JmEquipmentAssetKeys.parseWoodenKey(woodTypeName)).build());
					}
					componentChangesBuilder
							.add(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(List.of(), List.of(), List.of(woodTypeVariant), List.of()))
							.add(DataComponentTypes.ITEM_NAME, Text.translatable("item.jineric." + woodTypeVariant));
					((ShapedRecipeJsonBuilderAccess)recipeBuilder).jineric$componentChanges(componentChangesBuilder.build());
					recipeBuilder.criterion("has_" + getItemPath(plank), this.conditionsFromItem(plank));
					recipeBuilder.group("wooden_" + variant);
					recipeBuilder.offerTo(recipeExporter, woodenRecipeKey);
				});
			}
			
			public void offerEquipmentFamilyUpgrade(EquipmentFamily inputFamily, EquipmentFamily resultFamily) {
				inputFamily.getVariants().forEach((variant, item) -> {
					if (resultFamily.getVariants().containsKey(variant)) {
						Item resultVariantItem = resultFamily.getVariantItem(variant);
						String recipeId = getItemPath(resultVariantItem) + "_smithing";
						if (Registries.ITEM.getId(item).getNamespace().equals("minecraft")) {
							recipeId = replaceVanilla(resultVariantItem);
						}
						this.offerSmithingUpgradeRecipe(
								inputFamily.getSmithingTemplate(),
								item,
								resultFamily.getMaterialTag(),
								resultVariantItem,
								equipmentRecipeCategory(variant),
								recipeId
						);
					}
				});
			}
			
			public ShapedRecipeJsonBuilder createEquipmentVariantBase(EquipmentFamily family, EquipmentFamily.Variant variant, Item item) {
				ShapedRecipeJsonBuilder recipeBuilder = this.createShaped(variant.isCombat() ? RecipeCategory.COMBAT : RecipeCategory.TOOLS, item);
				Item material = family.getMaterial();
				if (material != Items.AIR) {
					recipeBuilder.input('M', material);
				} else if (!variant.isArmor()) {
					recipeBuilder.input('S', Items.STICK);
				}
				for (String patternIndex : variant.getCraftingLayout()) {
					recipeBuilder.pattern(patternIndex);
				}
				return recipeBuilder;
			}
			
			public void offerVanillaSmithingUpgradeRecipe(Item template, Item input, TagKey<Item> material, Item result, RecipeCategory category) {
				this.offerSmithingUpgradeRecipe(template, input, material, result, category, replaceVanilla(result));
			}
			
			public void offerSmithingUpgradeRecipe(Item template, Item input, TagKey<Item> material, Item result, RecipeCategory category) {
				this.offerSmithingUpgradeRecipe(template, input, material, result, category, getItemPath(result) + "_smithing");
			}
			
			public void offerSmithingUpgradeRecipe(Item template, Item input, TagKey<Item> material, Item result, RecipeCategory category, String recipeId) {
				SmithingTransformRecipeJsonBuilder builder = SmithingTransformRecipeJsonBuilder.create(
						Ingredient.ofItem(template),
						Ingredient.ofItem(input),
						this.ingredientFromTag(material),
						category,
						result
				);
				if (template.equals(JinericItems.STONE_UPGRADE_SMITHING_TEMPLATE)) {
					builder.jineric$componentChanges(ComponentChanges.builder()
							.add(DataComponentTypes.ITEM_NAME, Text.translatable(Registries.ITEM.getId(result).toTranslationKey("item")))
							.remove(DataComponentTypes.CUSTOM_MODEL_DATA)
							.build()
					);
				}
				builder.criterion("has_" + getItemPath(input), this.conditionsFromTag(material));
				builder.offerTo(this.exporter, recipeId);
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
								if (block == blockFamily.getVariant(BlockFamily.Variant.STAIRS)) {
									this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, block, input);
								}
								if (block == blockFamily.getVariant(BlockFamily.Variant.SLAB)) {
									this.offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, block, input, 2);
								}
								if (block == blockFamily.getVariant(BlockFamily.Variant.WALL)) {
									this.offerStonecuttingRecipe(RecipeCategory.DECORATIONS, block, input);
								}
							});
				});
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
				this.offerRefining(blockFamilyIn.getVariant(BlockFamily.Variant.STAIRS), blockFamilyOut.getVariant(BlockFamily.Variant.STAIRS), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, 0.1F, group);
				this.offerRefining(blockFamilyIn.getVariant(BlockFamily.Variant.SLAB), blockFamilyOut.getVariant(BlockFamily.Variant.SLAB), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, 0.1F, group);
				this.offerRefining(blockFamilyIn.getVariant(BlockFamily.Variant.WALL), blockFamilyOut.getVariant(BlockFamily.Variant.WALL), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, 0.1F, group);
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
				this.createTrappedChest$jineric(Ingredient.ofItem(input), output)
						.group("wooden_" + getItemPath(Blocks.TRAPPED_CHEST))
						.criterion(hasItem(input), this.conditionsFromItem(input))
						.criterion(hasItem(Items.TRIPWIRE_HOOK), this.conditionsFromItem(Items.TRIPWIRE_HOOK))
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
			
			private void offerCampfireRecipe() {
				ShapedRecipeJsonBuilder builder = this.createShaped(RecipeCategory.DECORATIONS, Blocks.CAMPFIRE);
				((ShapedRecipeJsonBuilderAccess) builder).jineric$componentChanges(
						ComponentChanges.builder()
								.add(DataComponentTypes.BLOCK_STATE, BlockStateComponent.DEFAULT.with(Properties.LIT, false))
								.build()
				);
				builder.input('S', Items.STICK).input('T', JinericItems.TINDER).input('L', ItemTags.LOGS)
						.pattern("SSS")
						.pattern("LTL")
						.pattern("LLL")
						.criterion("has_stick", this.conditionsFromItem(Items.STICK))
						.criterion("has_tinder", this.conditionsFromItem(JinericItems.TINDER))
						.offerTo(recipeExporter, replaceVanilla(Items.CAMPFIRE));
			}
		};
	}
	
	public static RecipeCategory equipmentRecipeCategory(EquipmentFamily.Variant variant) {
		if (variant.isCombat()) {
			return RecipeCategory.COMBAT;
		} else {
			return RecipeCategory.TOOLS;
		}
	}
	
	public static String replaceVanilla(Item replacedResult) {
		return "jineric_replace_" + RecipeGenerator.getItemPath(replacedResult);
	}
	
	@Override
	protected Identifier getRecipeIdentifier(Identifier identifier) {
		if (identifier.getNamespace().equals("minecraft") && identifier.getPath().contains("jineric_replace_")) {
			return Identifier.ofVanilla(identifier.getPath().replace("jineric_replace_", ""));
		} else {
			return super.getRecipeIdentifier(identifier);
		}
	}
	
	@Override
	public String getName() {
		return "Recipes";
	}
}
