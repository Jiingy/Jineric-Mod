package jingy.jineric.data.generators.tag;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.tag.JinericBlockSoundTags;
import jingy.jineric.tag.JinericBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static jingy.jineric.block.JinericBlocks.*;

public class JinericBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
	public Map<TagKey<Block>, Block> blockTagMap = new HashMap<>();
	
	public JinericBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider holderLookupProvider) {
		this.blockFamiliesToFamilyVariantTag(BlockTags.BUTTONS, BlockFamily.Variant.BUTTON);
		this.blockFamiliesToFamilyVariantTag(BlockTags.DOORS, BlockFamily.Variant.DOOR);
		this.blockFamiliesToFamilyVariantTag(BlockTags.FENCES, BlockFamily.Variant.FENCE);
		this.blockFamiliesToFamilyVariantTag(BlockTags.FENCES, BlockFamily.Variant.CUSTOM_FENCE);
		this.blockFamiliesToFamilyVariantTag(BlockTags.FENCE_GATES, BlockFamily.Variant.FENCE_GATE);
		this.blockFamiliesToFamilyVariantTag(BlockTags.SIGNS, BlockFamily.Variant.SIGN);
		this.blockFamiliesToFamilyVariantTag(BlockTags.SLABS, BlockFamily.Variant.SLAB);
		this.blockFamiliesToFamilyVariantTag(BlockTags.STAIRS, BlockFamily.Variant.STAIRS);
		this.blockFamiliesToFamilyVariantTag(BlockTags.PRESSURE_PLATES, BlockFamily.Variant.PRESSURE_PLATE);
		this.blockFamiliesToFamilyVariantTag(BlockTags.TRAPDOORS, BlockFamily.Variant.TRAPDOOR);
		this.blockFamiliesToFamilyVariantTag(BlockTags.WALLS, BlockFamily.Variant.WALL);
		this.blockFamiliesToFamilyVariantTag(BlockTags.WALL_SIGNS, BlockFamily.Variant.WALL_SIGN);
		// Needs Tool
		this.valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
		this.valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL).forceAddTag(ConventionalBlockTags.COAL_ORES);
		this.valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
				.add(CUT_COPPER_WALL, EXPOSED_CUT_COPPER_WALL, WEATHERED_CUT_COPPER_WALL, OXIDIZED_CUT_COPPER_WALL)
				.add(WAXED_CUT_COPPER_WALL, WAXED_EXPOSED_CUT_COPPER_WALL, WAXED_WEATHERED_CUT_COPPER_WALL, WAXED_OXIDIZED_CUT_COPPER_WALL);
		// Incorrect for Tool
		this.valueLookupBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
		this.valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
		this.valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL);
		this.valueLookupBuilder(BlockTags.INCORRECT_FOR_COPPER_TOOL);
		this.valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
				.forceAddTag(BlockTags.IRON_ORES);
		this.valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
				.add(CUT_COPPER_WALL, EXPOSED_CUT_COPPER_WALL, WEATHERED_CUT_COPPER_WALL, OXIDIZED_CUT_COPPER_WALL)
				.add(WAXED_CUT_COPPER_WALL, WAXED_EXPOSED_CUT_COPPER_WALL, WAXED_WEATHERED_CUT_COPPER_WALL, WAXED_OXIDIZED_CUT_COPPER_WALL);
		this.valueLookupBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
				.add(CUT_COPPER_WALL, EXPOSED_CUT_COPPER_WALL, WEATHERED_CUT_COPPER_WALL, OXIDIZED_CUT_COPPER_WALL)
				.add(WAXED_CUT_COPPER_WALL, WAXED_EXPOSED_CUT_COPPER_WALL, WAXED_WEATHERED_CUT_COPPER_WALL, WAXED_OXIDIZED_CUT_COPPER_WALL);
		// AXE
		this.valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
				.addTag(JinericBlockTags.WOODEN_CHESTS)
				.addTag(JinericBlockTags.WOODEN_TRAPPED_CHESTS)
				.addTag(JinericBlockTags.WOODEN_LADDERS)
				.addTag(JinericBlockTags.WOODEN_BOOKSHELVES)
				.add(STICK_BLOCK)
				.add(SOUL_JACK_O_LANTERN)
				.add(REDSTONE_CAMPFIRE);
		// HOE
		this.valueLookupBuilder(BlockTags.MINEABLE_WITH_HOE)
				.add(ROTTEN_FLESH_BLOCK)
				.add(PAPER_BLOCK);
		// PICKAXE
		this.putBlocksToTag(BlockTags.MINEABLE_WITH_PICKAXE,
				JinericBlocks.CUT_COPPER_WALL, JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.OXIDIZED_CUT_COPPER_WALL,
				JinericBlocks.WAXED_CUT_COPPER_WALL, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL,
				JinericBlocks.BLAZE_ROD_BLOCK, JinericBlocks.EGG_BLOCK, JinericBlocks.PRISMARINE_CRYSTAL_BLOCK, JinericBlocks.BONE_MEAL_BLOCK, JinericBlocks.FLINT_BLOCK, JinericBlocks.CHARCOAL_BLOCK,
				JinericBlocks.STONE_BRICK_PILLAR, JinericBlocks.TUFF_BRICK_PILLAR, JinericBlocks.DRIPSTONE_BRICK_PILLAR,
				JinericBlocks.REDSTONE_LANTERN,
				JinericBlocks.REFINERY
		);
		this.blockFamiliesToTag(BlockTags.MINEABLE_WITH_PICKAXE,
				JinericBlockFamilies.STONE, JinericBlockFamilies.SMOOTH_STONE,
				JinericBlockFamilies.POLISHED_STONE,
				JinericBlockFamilies.CRACKED_STONE_BRICKS,
				JinericBlockFamilies.STONE_TILES, JinericBlockFamilies.CRACKED_STONE_TILES,
				JinericBlockFamilies.SMOOTH_DEEPSLATE, JinericBlockFamilies.CRACKED_DEEPSLATE_BRICKS, JinericBlockFamilies.CRACKED_DEEPSLATE_TILES,
				JinericBlockFamilies.SMOOTH_TUFF,
				JinericBlockFamilies.CRACKED_TUFF_BRICKS,
				JinericBlockFamilies.TUFF_TILES, JinericBlockFamilies.CRACKED_TUFF_TILES,
				JinericBlockFamilies.DRIPSTONE_BLOCK, JinericBlockFamilies.SMOOTH_DRIPSTONE,
				JinericBlockFamilies.POLISHED_DRIPSTONE, JinericBlockFamilies.DRIPSTONE_BRICKS, JinericBlockFamilies.CRACKED_DRIPSTONE_BRICKS,
				JinericBlockFamilies.DRIPSTONE_TILES, JinericBlockFamilies.CRACKED_DRIPSTONE_TILES,
				JinericBlockFamilies.SMOOTH_SANDSTONE, JinericBlockFamilies.CUT_SANDSTONE, JinericBlockFamilies.POLISHED_SANDSTONE, JinericBlockFamilies.WAVY_SANDSTONE,
				JinericBlockFamilies.SMOOTH_RED_SANDSTONE, JinericBlockFamilies.CUT_RED_SANDSTONE, JinericBlockFamilies.POLISHED_RED_SANDSTONE, JinericBlockFamilies.WAVY_RED_SANDSTONE,
				JinericBlockFamilies.SOUL_SANDSTONE, JinericBlockFamilies.SMOOTH_SOUL_SANDSTONE,
				JinericBlockFamilies.CUT_SOUL_SANDSTONE, JinericBlockFamilies.POLISHED_SOUL_SANDSTONE, JinericBlockFamilies.WAVY_SOUL_SANDSTONE,
				JinericBlockFamilies.PRISMARINE, JinericBlockFamilies.DARK_PRISMARINE,
				JinericBlockFamilies.POLISHED_GRANITE, JinericBlockFamilies.POLISHED_DIORITE, JinericBlockFamilies.POLISHED_ANDESITE,
				JinericBlockFamilies.CALCITE,
				JinericBlockFamilies.SNOW_BRICKS, JinericBlockFamilies.PACKED_ICE,
				JinericBlockFamilies.OBSIDIAN,
				JinericBlockFamilies.QUARTZ, JinericBlockFamilies.SMOOTH_QUARTZ, JinericBlockFamilies.QUARTZ_BRICKS,
				JinericBlockFamilies.CRACKED_NETHER_BRICKS, JinericBlockFamilies.RED_NETHER_BRICKS,
				JinericBlockFamilies.CRACKED_POLISHED_BLACKSTONE_BRICKS,
				JinericBlockFamilies.SMOOTH_BASALT,
				JinericBlockFamilies.PURPUR
		);
		// SHOVEL
		this.valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
				.add(GRASS_BLOCK)
				.add(SUGAR_BLOCK);
		// SWORD
		this.valueLookupBuilder(BlockTags.SWORD_EFFICIENT);
		// BLOCK FAMILY -> TAG
		this.blockFamiliesToTag(BlockTags.MINEABLE_WITH_SHOVEL, JinericBlockFamilies.SNOW_BRICKS);
		this.blockFamiliesToTag(BlockTags.SOUL_SPEED_BLOCKS,
				JinericBlockFamilies.CUT_SOUL_SANDSTONE,
				JinericBlockFamilies.POLISHED_SOUL_SANDSTONE,
				JinericBlockFamilies.SMOOTH_SOUL_SANDSTONE,
				JinericBlockFamilies.SOUL_SANDSTONE,
				JinericBlockFamilies.WAVY_SOUL_SANDSTONE
		);
		this.blockFamiliesToTag(BlockTags.DRAGON_IMMUNE, JinericBlockFamilies.OBSIDIAN);
		this.blockFamiliesToTag(BlockTags.NEEDS_DIAMOND_TOOL, JinericBlockFamilies.OBSIDIAN);
		
		// Vanilla Tags
//      this.valueLookupBuilder(BlockTags.WOOL);
//      this.valueLookupBuilder(BlockTags.PLANKS);
		this.valueLookupBuilder(BlockTags.STONE_BRICKS)
				.add(STONE_BRICK_PILLAR);
//      this.valueLookupBuilder(BlockTags.WOODEN_BUTTONS);
//      this.valueLookupBuilder(BlockTags.STONE_BUTTONS);
//      this.valueLookupBuilder(BlockTags.BUTTONS);
//      this.valueLookupBuilder(BlockTags.WOOL_CARPETS);
//      this.valueLookupBuilder(BlockTags.WOODEN_DOORS);
//      this.valueLookupBuilder(BlockTags.MOB_INTERACTABLE_DOORS);
//      this.valueLookupBuilder(BlockTags.WOODEN_STAIRS);
//      this.valueLookupBuilder(BlockTags.WOODEN_SLABS);
//      this.valueLookupBuilder(BlockTags.WOODEN_FENCES);
//      this.valueLookupBuilder(BlockTags.PRESSURE_PLATES);
//      this.valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES);
//      this.valueLookupBuilder(BlockTags.STONE_PRESSURE_PLATES);
//      this.valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS);
//      this.valueLookupBuilder(BlockTags.DOORS);
//      this.valueLookupBuilder(BlockTags.SAPLINGS);
//      this.valueLookupBuilder(BlockTags.LOGS_THAT_BURN);
//      this.valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS);
//      this.valueLookupBuilder(BlockTags.LOGS);
//      this.valueLookupBuilder(BlockTags.DARK_OAK_LOGS);
//      this.valueLookupBuilder(BlockTags.PALE_OAK_LOGS);
//      this.valueLookupBuilder(BlockTags.OAK_LOGS);
//      this.valueLookupBuilder(BlockTags.BIRCH_LOGS);
//      this.valueLookupBuilder(BlockTags.ACACIA_LOGS);
//      this.valueLookupBuilder(BlockTags.CHERRY_LOGS);
//      this.valueLookupBuilder(BlockTags.JUNGLE_LOGS);
//      this.valueLookupBuilder(BlockTags.SPRUCE_LOGS);
//      this.valueLookupBuilder(BlockTags.MANGROVE_LOGS);
//      this.valueLookupBuilder(BlockTags.CRIMSON_STEMS);
//      this.valueLookupBuilder(BlockTags.WARPED_STEMS);
//      this.valueLookupBuilder(BlockTags.BAMBOO_BLOCKS);
//      this.valueLookupBuilder(BlockTags.WART_BLOCKS);
//      this.valueLookupBuilder(BlockTags.BANNERS);
//      this.valueLookupBuilder(BlockTags.SAND);
//      this.valueLookupBuilder(BlockTags.SMELTS_TO_GLASS);
//      this.valueLookupBuilder(BlockTags.STAIRS);
//      this.valueLookupBuilder(BlockTags.SLABS);
//      this.valueLookupBuilder(BlockTags.WALLS);
//      this.valueLookupBuilder(BlockTags.ANVIL);
//      this.valueLookupBuilder(BlockTags.RAILS);
//      this.valueLookupBuilder(BlockTags.LEAVES);
//      this.valueLookupBuilder(BlockTags.TRAPDOORS);
//      this.valueLookupBuilder(BlockTags.SMALL_FLOWERS);
//      this.valueLookupBuilder(BlockTags.BEDS);
//      this.valueLookupBuilder(BlockTags.FENCES);
//      this.valueLookupBuilder(BlockTags.TALL_FLOWERS);
//      this.valueLookupBuilder(BlockTags.FLOWERS);
		this.valueLookupBuilder(BlockTags.PIGLIN_REPELLENTS)
				.add(SOUL_JACK_O_LANTERN);
//      this.valueLookupBuilder(BlockTags.GOLD_ORES);
//      this.valueLookupBuilder(BlockTags.IRON_ORES);
//      this.valueLookupBuilder(BlockTags.DIAMOND_ORES);
//      this.valueLookupBuilder(BlockTags.REDSTONE_ORES);
//      this.valueLookupBuilder(BlockTags.LAPIS_ORES);
//      this.valueLookupBuilder(BlockTags.COAL_ORES);
//      this.valueLookupBuilder(BlockTags.EMERALD_ORES);
//      this.valueLookupBuilder(BlockTags.COPPER_ORES);
//      this.valueLookupBuilder(BlockTags.CANDLES);
		this.valueLookupBuilder(BlockTags.DIRT)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.TERRACOTTA);
//      this.valueLookupBuilder(BlockTags.BADLANDS_TERRACOTTA);
//      this.valueLookupBuilder(BlockTags.CONCRETE_POWDER);
//      this.valueLookupBuilder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL);
//      this.valueLookupBuilder(BlockTags.SHULKER_BOXES);
//      this.valueLookupBuilder(BlockTags.FLOWER_POTS);
		this.valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.ICE);
		this.valueLookupBuilder(BlockTags.VALID_SPAWN)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.IMPERMEABLE);
//      this.valueLookupBuilder(BlockTags.UNDERWATER_BONEMEALS);
//      this.valueLookupBuilder(BlockTags.CORAL_BLOCKS);
//      this.valueLookupBuilder(BlockTags.WALL_CORALS);
//      this.valueLookupBuilder(BlockTags.CORAL_PLANTS);
//      this.valueLookupBuilder(BlockTags.CORALS);
		this.valueLookupBuilder(BlockTags.BAMBOO_PLANTABLE_ON)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.STANDING_SIGNS);
//      this.valueLookupBuilder(BlockTags.WALL_SIGNS);
//      this.valueLookupBuilder(BlockTags.SIGNS);
//      this.valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS);
//      this.valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS);
//      this.valueLookupBuilder(BlockTags.ALL_HANGING_SIGNS);
//      this.valueLookupBuilder(BlockTags.ALL_SIGNS);
//      this.valueLookupBuilder(BlockTags.DRAGON_IMMUNE);
//      this.valueLookupBuilder(BlockTags.DRAGON_TRANSPARENT);
//      this.valueLookupBuilder(BlockTags.WITHER_IMMUNE);
//      this.valueLookupBuilder(BlockTags.WITHER_SUMMON_BASE_BLOCKS);
//      this.valueLookupBuilder(BlockTags.BEEHIVES);
//      this.valueLookupBuilder(BlockTags.CROPS);
//      this.valueLookupBuilder(BlockTags.BEE_GROWABLES);
//      this.valueLookupBuilder(BlockTags.PORTALS);
//      this.valueLookupBuilder(BlockTags.FIRE);
//      this.valueLookupBuilder(BlockTags.NYLIUM);
//      this.valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS);
//      this.valueLookupBuilder(BlockTags.SOUL_SPEED_BLOCKS);
//      this.valueLookupBuilder(BlockTags.WALL_POST_OVERRIDE);
		this.valueLookupBuilder(BlockTags.CLIMBABLE)
				.addTag(JinericBlockTags.LADDERS);
//      this.valueLookupBuilder(BlockTags.FALL_DAMAGE_RESETTING);
//      this.valueLookupBuilder(BlockTags.HOGLIN_REPELLENTS);
//      this.valueLookupBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS);
//      this.valueLookupBuilder(BlockTags.STRIDER_WARM_BLOCKS);
		this.valueLookupBuilder(BlockTags.CAMPFIRES)
				.add(REDSTONE_CAMPFIRE);
		this.valueLookupBuilder(BlockTags.GUARDED_BY_PIGLINS)
				.addTag(JinericBlockTags.CHESTS);
//      this.valueLookupBuilder(BlockTags.PREVENT_MOB_SPAWNING_INSIDE);
//      this.valueLookupBuilder(BlockTags.FENCE_GATES);
//      this.valueLookupBuilder(BlockTags.UNSTABLE_BOTTOM_CENTER);
//      this.valueLookupBuilder(BlockTags.MUSHROOM_GROW_BLOCK);
//      this.valueLookupBuilder(BlockTags.INFINIBURN_OVERWORLD);
//      this.valueLookupBuilder(BlockTags.INFINIBURN_NETHER);
//      this.valueLookupBuilder(BlockTags.INFINIBURN_END);
//      this.valueLookupBuilder(BlockTags.BASE_STONE_OVERWORLD);
//      this.valueLookupBuilder(BlockTags.STONE_ORE_REPLACEABLES);
//      this.valueLookupBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
//      this.valueLookupBuilder(BlockTags.BASE_STONE_NETHER);
		this.valueLookupBuilder(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
				.add(GRASS_BLOCK);
		this.valueLookupBuilder(BlockTags.NETHER_CARVER_REPLACEABLES)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.CANDLE_CAKES);
//      this.valueLookupBuilder(BlockTags.CAULDRONS);
//      this.valueLookupBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS);
//      this.valueLookupBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS);
//      this.valueLookupBuilder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS);
//      this.valueLookupBuilder(BlockTags.CAMEL_SAND_STEP_SOUND_BLOCKS);
//      this.valueLookupBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS);
//      this.valueLookupBuilder(BlockTags.DAMPENS_VIBRATIONS);
//      this.valueLookupBuilder(BlockTags.DRIPSTONE_REPLACEABLE_BLOCKS);
//      this.valueLookupBuilder(BlockTags.CAVE_VINES);
		this.valueLookupBuilder(BlockTags.MOSS_REPLACEABLE)
				.add(GRASS_BLOCK);
		this.valueLookupBuilder(BlockTags.LUSH_GROUND_REPLACEABLE)
				.add(GRASS_BLOCK);
		this.valueLookupBuilder(BlockTags.AZALEA_ROOT_REPLACEABLE)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE);
		this.valueLookupBuilder(BlockTags.BIG_DRIPLEAF_PLACEABLE)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.SNOW);
//      this.valueLookupBuilder(BlockTags.FEATURES_CANNOT_REPLACE);
//      this.valueLookupBuilder(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE);
//      this.valueLookupBuilder(BlockTags.GEODE_INVALID_BLOCKS);
//      this.valueLookupBuilder(BlockTags.FROG_PREFER_JUMP_TO);
		this.valueLookupBuilder(BlockTags.SCULK_REPLACEABLE)
				.add(GRASS_BLOCK);
		this.valueLookupBuilder(BlockTags.SCULK_REPLACEABLE_WORLD_GEN)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.ANCIENT_CITY_REPLACEABLE);
//      this.valueLookupBuilder(BlockTags.VIBRATION_RESONATORS);
		this.valueLookupBuilder(BlockTags.ANIMALS_SPAWNABLE_ON)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.ARMADILLO_SPAWNABLE_ON);
//      this.valueLookupBuilder(BlockTags.AXOLOTLS_SPAWNABLE_ON);
//      this.valueLookupBuilder(BlockTags.GOATS_SPAWNABLE_ON);
//      this.valueLookupBuilder(BlockTags.MOOSHROOMS_SPAWNABLE_ON);
		this.valueLookupBuilder(BlockTags.PARROTS_SPAWNABLE_ON)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.POLAR_BEARS_SPAWNABLE_ON_ALTERNATE);
		this.valueLookupBuilder(BlockTags.RABBITS_SPAWNABLE_ON)
				.add(GRASS_BLOCK);
		this.valueLookupBuilder(BlockTags.FOXES_SPAWNABLE_ON)
				.add(GRASS_BLOCK);
		this.valueLookupBuilder(BlockTags.WOLVES_SPAWNABLE_ON)
				.add(GRASS_BLOCK);
		this.valueLookupBuilder(BlockTags.FROGS_SPAWNABLE_ON)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.BATS_SPAWNABLE_ON);
		this.valueLookupBuilder(BlockTags.AZALEA_GROWS_ON)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.CONVERTABLE_TO_MUD);
//      this.valueLookupBuilder(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH);
//      this.valueLookupBuilder(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH);
//      this.valueLookupBuilder(BlockTags.SNAPS_GOAT_HORN);
//      this.valueLookupBuilder(BlockTags.REPLACEABLE_BY_TREES);
//      this.valueLookupBuilder(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON);
//      this.valueLookupBuilder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON);
//      this.valueLookupBuilder(BlockTags.INVALID_SPAWN_INSIDE);
		this.valueLookupBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK)
				.add(GRASS_BLOCK);
//      this.valueLookupBuilder(BlockTags.SNIFFER_EGG_HATCH_BOOST);
//      this.valueLookupBuilder(BlockTags.TRAIL_RUINS_REPLACEABLE);
//      this.valueLookupBuilder(BlockTags.REPLACEABLE);
//      this.valueLookupBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER);
//      this.valueLookupBuilder(BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
//      this.valueLookupBuilder(BlockTags.MAINTAINS_FARMLAND);
//      this.valueLookupBuilder(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS);
//      this.valueLookupBuilder(BlockTags.DOES_NOT_BLOCK_HOPPERS);
		
		// JinericBlock Tags
		this.valueLookupBuilder(JinericBlockTags.NOT_PICKAXE_WALL)
				.add(SNOW_BRICK_WALL, SNOW_WALL);
		this.valueLookupBuilder(JinericBlockTags.LADDERS)
				.addTag(JinericBlockTags.WOODEN_LADDERS);
		this.valueLookupBuilder(JinericBlockTags.CHESTS)
				.addTag(JinericBlockTags.WOODEN_CHESTS);
		this.valueLookupBuilder(JinericBlockTags.TRAPPED_CHESTS)
				.addTag(JinericBlockTags.WOODEN_TRAPPED_CHESTS);
		this.valueLookupBuilder(JinericBlockTags.WOODEN_CHESTS)
				.add(SPRUCE_CHEST)
				.add(BIRCH_CHEST)
				.add(JUNGLE_CHEST)
				.add(ACACIA_CHEST)
				.add(DARK_OAK_CHEST)
				.add(MANGROVE_CHEST)
				.add(CHERRY_CHEST)
				.add(BAMBOO_CHEST)
				.add(CRIMSON_CHEST)
				.add(WARPED_CHEST);
		this.valueLookupBuilder(JinericBlockTags.WOODEN_TRAPPED_CHESTS)
				.add(TRAPPED_SPRUCE_CHEST)
				.add(TRAPPED_BIRCH_CHEST)
				.add(TRAPPED_JUNGLE_CHEST)
				.add(TRAPPED_ACACIA_CHEST)
				.add(TRAPPED_DARK_OAK_CHEST)
				.add(TRAPPED_MANGROVE_CHEST)
				.add(TRAPPED_CHERRY_CHEST)
				.add(TRAPPED_BAMBOO_CHEST)
				.add(TRAPPED_CRIMSON_CHEST)
				.add(TRAPPED_WARPED_CHEST);
		this.valueLookupBuilder(JinericBlockTags.WOODEN_LADDERS)
				.add(SPRUCE_LADDER)
				.add(BIRCH_LADDER)
				.add(JUNGLE_LADDER)
				.add(ACACIA_LADDER)
				.add(DARK_OAK_LADDER)
				.add(MANGROVE_LADDER)
				.add(CHERRY_LADDER)
				.add(BAMBOO_LADDER)
				.add(CRIMSON_LADDER)
				.add(WARPED_LADDER);
		this.valueLookupBuilder(JinericBlockTags.WOODEN_BOOKSHELVES)
				.add(SPRUCE_BOOKSHELF)
				.add(BIRCH_BOOKSHELF)
				.add(JUNGLE_BOOKSHELF)
				.add(ACACIA_BOOKSHELF)
				.add(DARK_OAK_BOOKSHELF)
				.add(MANGROVE_BOOKSHELF)
				.add(CHERRY_BOOKSHELF)
				.add(BAMBOO_BOOKSHELF)
				.add(CRIMSON_BOOKSHELF)
				.add(WARPED_BOOKSHELF);
		this.valueLookupBuilder(JinericBlockTags.JM_GRASS_BLOCK_REPLACEABLE).add(Blocks.GRASS_BLOCK);
		this.valueLookupBuilder(JinericBlockTags.SLIPPERY).add(PACKED_ICE_STAIRS, PACKED_ICE_SLAB, PACKED_ICE_WALL);
		// Sounds
		this.valueLookupBuilder(JinericBlockSoundTags.VEGETATION_SOUNDS)
				.addOptionalTag(BlockTags.FLOWERS)
				.add(Blocks.GRASS_BLOCK)
				.add(Blocks.SHORT_GRASS)
				.add(Blocks.TALL_GRASS)
				.add(Blocks.FERN)
				.add(Blocks.LARGE_FERN)
				.add(Blocks.GLOW_LICHEN)
				.add(Blocks.VINE)
				.add(GRASS_BLOCK);
	}
	
	private void putBlocksToTag(TagKey<Block> tagKey, Block... blocks) {
		for (Block block : blocks) {
			this.blockTagMap.put(tagKey, block);
		}
	}
	
	private void blockFamiliesToTag(TagKey<Block> tagKey, BlockFamily... blockFamiliesIn) {
		List<Block> blockToAdd = new ArrayList<>();
		Stream<Map.Entry<TagKey<Block>, Block>> list = this.blockTagMap.entrySet().stream()
				.filter(tagKeyBlockEntry -> tagKeyBlockEntry.getKey().equals(tagKey));
		list.forEach(tagKeyBlockEntry -> blockToAdd.add(tagKeyBlockEntry.getValue()));
		for (BlockFamily blockFamily : blockFamiliesIn) {
			blockToAdd.addAll(blockFamily.getVariants().values().stream().toList());
			blockToAdd.add(blockFamily.getBaseBlock());
		}
		blockToAdd.sort(Comparator.comparing(Block::toString));
		blockToAdd.stream()
				.filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("jineric") && !block.defaultBlockState().is(tagKey))
				.forEach(block -> this.valueLookupBuilder(tagKey).add(block));
	}
	
	private void blockListToTag(TagKey<Block> tagKey, Block... baseBlockIn) {
		for (Block block : baseBlockIn) {
			List<BlockFamily> blockFamilies = BlockFamilies.getAllFamilies().toList();
			blockFamilies.forEach(blockFamily -> {
				Map<BlockFamily.Variant, Block> variants = blockFamily.getVariants();
				if (blockFamily.getBaseBlock() == block) {
					variants.values().stream().filter(testBlock -> !testBlock.defaultBlockState().is(tagKey) && BuiltInRegistries.BLOCK.getKey(testBlock).getNamespace().equals("jineric"))
							.forEach((blockVariant) -> this.valueLookupBuilder(tagKey).add(blockVariant));
				}
			});
			if (BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("jineric")) {
				this.valueLookupBuilder(tagKey).add(block);
			}
		}
	}
	
	private void blockFamiliesToFamilyVariantTag(TagKey<Block> blockTag, BlockFamily.Variant familyVariantIn) {
		List<BlockFamily> familyList = new ArrayList<>(BlockFamilies.getAllFamilies().toList());
		familyList.sort(Comparator.comparing(blockFamily -> {
			Block familyVariant = blockFamily.get(familyVariantIn);
			return familyVariant != null ? blockFamily.get(familyVariantIn).toString() : blockFamily.getBaseBlock().toString();
		}));
		familyList.forEach(
				(blockFamily) -> {
					if (blockFamily.get(familyVariantIn) != null) {
						Block familyVariantBlock = blockFamily.get(familyVariantIn);
						if (BuiltInRegistries.BLOCK.getKey(familyVariantBlock).getNamespace().equals("jineric")) {
							this.valueLookupBuilder(blockTag).add(familyVariantBlock);
						}
					}
				}
		);
	}
	
	@Override
	public String getName() {
		return "Block Tags";
	}
}
