package jingy.jineric.data.generators.tag;

import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.references.JmBlockItemIds;
import jingy.jineric.tag.JinericBlockSoundTags;
import jingy.jineric.tag.JinericBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

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
		this.builder(BlockTags.NEEDS_DIAMOND_TOOL);
		this.builder(BlockTags.NEEDS_IRON_TOOL).forceAddTag(ConventionalBlockTags.COAL_ORES);
		this.builder(BlockTags.NEEDS_STONE_TOOL)
				.add(JmBlockItemIds.CUT_COPPER_WALL.weathering().unaffected(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().exposed(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().weathered(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().oxidized()
				).add(JmBlockItemIds.CUT_COPPER_WALL.waxed().unaffected(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().exposed(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().weathered(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().oxidized()
				);
		// Incorrect for Tool
		this.builder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
		this.builder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
		this.builder(BlockTags.INCORRECT_FOR_IRON_TOOL);
		this.builder(BlockTags.INCORRECT_FOR_COPPER_TOOL);
		this.builder(BlockTags.INCORRECT_FOR_STONE_TOOL)
				.forceAddTag(BlockTags.IRON_ORES);
		this.builder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
				.add(JmBlockItemIds.CUT_COPPER_WALL.weathering().unaffected(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().exposed(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().weathered(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().oxidized()
				).add(JmBlockItemIds.CUT_COPPER_WALL.waxed().unaffected(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().exposed(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().weathered(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().oxidized()
				);;
		this.builder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
				.add(JmBlockItemIds.CUT_COPPER_WALL.weathering().unaffected(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().exposed(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().weathered(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().oxidized()
				).add(JmBlockItemIds.CUT_COPPER_WALL.waxed().unaffected(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().exposed(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().weathered(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().oxidized()
				);
		// AXE
		this.builder(BlockTags.MINEABLE_WITH_AXE)
				.addTag(JinericBlockTags.WOODEN_CHESTS)
				.addTag(JinericBlockTags.WOODEN_TRAPPED_CHESTS)
				.addTag(JinericBlockTags.WOODEN_LADDERS)
				.addTag(JinericBlockTags.WOODEN_BOOKSHELVES)
				.add(JmBlockItemIds.STICK_BLOCK)
				.add(JmBlockItemIds.SOUL_JACK_O_LANTERN)
				.add(JmBlockItemIds.REDSTONE_CAMPFIRE);
		// HOE
		this.builder(BlockTags.MINEABLE_WITH_HOE)
				.add(JmBlockItemIds.ROTTEN_FLESH_BLOCK)
				.add(JmBlockItemIds.PAPER_BLOCK);
		// PICKAXE
		this.builder(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(JmBlockItemIds.BLAZE_ROD_BLOCK)
				.add(JmBlockItemIds.EGG_BLOCK)
				.add(JmBlockItemIds.PRISMARINE_CRYSTAL_BLOCK)
				.add(JmBlockItemIds.BONE_MEAL_BLOCK)
				.add(JmBlockItemIds.FLINT_BLOCK)
				.add(JmBlockItemIds.CHARCOAL_BLOCK)
				.add(JmBlockItemIds.STONE_BRICK_PILLAR)
				.add(JmBlockItemIds.TUFF_BRICK_PILLAR)
				.add(JmBlockItemIds.DRIPSTONE_BRICK_PILLAR)
				.add(JmBlockItemIds.REDSTONE_LANTERN)
				.add(JmBlockItemIds.REFINERY)
				.add(
						JmBlockItemIds.CUT_COPPER_WALL.weathering().unaffected(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().exposed(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().weathered(),
						JmBlockItemIds.CUT_COPPER_WALL.weathering().oxidized()
				).add(
						JmBlockItemIds.CUT_COPPER_WALL.waxed().unaffected(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().exposed(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().weathered(),
						JmBlockItemIds.CUT_COPPER_WALL.waxed().oxidized()
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
		this.builder(BlockTags.MINEABLE_WITH_SHOVEL)
				.add(JmBlockItemIds.GRASS_BLOCK)
				.add(JmBlockItemIds.SUGAR_BLOCK);
		// SWORD
		this.builder(BlockTags.SWORD_EFFICIENT);
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
//      this.builder(BlockTags.WOOL);
//      this.builder(BlockTags.PLANKS);
		this.builder(BlockTags.STONE_BRICKS)
				.add(JmBlockItemIds.STONE_BRICK_PILLAR);
//      this.builder(BlockTags.WOODEN_BUTTONS);
//      this.builder(BlockTags.STONE_BUTTONS);
//      this.builder(BlockTags.BUTTONS);
//      this.builder(BlockTags.WOOL_CARPETS);
//      this.builder(BlockTags.WOODEN_DOORS);
//      this.builder(BlockTags.MOB_INTERACTABLE_DOORS);
//      this.builder(BlockTags.WOODEN_STAIRS);
//      this.builder(BlockTags.WOODEN_SLABS);
//      this.builder(BlockTags.WOODEN_FENCES);
//      this.builder(BlockTags.PRESSURE_PLATES);
//      this.builder(BlockTags.WOODEN_PRESSURE_PLATES);
//      this.builder(BlockTags.STONE_PRESSURE_PLATES);
//      this.builder(BlockTags.WOODEN_TRAPDOORS);
//      this.builder(BlockTags.DOORS);
//      this.builder(BlockTags.LOGS_THAT_BURN);
//      this.builder(BlockTags.OVERWORLD_NATURAL_LOGS);
//      this.builder(BlockTags.LOGS);
//      this.builder(BlockTags.DARK_OAK_LOGS);
//      this.builder(BlockTags.PALE_OAK_LOGS);
//      this.builder(BlockTags.OAK_LOGS);
//      this.builder(BlockTags.BIRCH_LOGS);
//      this.builder(BlockTags.ACACIA_LOGS);
//      this.builder(BlockTags.CHERRY_LOGS);
//      this.builder(BlockTags.JUNGLE_LOGS);
//      this.builder(BlockTags.SPRUCE_LOGS);
//      this.builder(BlockTags.MANGROVE_LOGS);
//      this.builder(BlockTags.CRIMSON_STEMS);
//      this.builder(BlockTags.WARPED_STEMS);
//      this.builder(BlockTags.BAMBOO_BLOCKS);
//      this.builder(BlockTags.WART_BLOCKS);
//      this.builder(BlockTags.BANNERS);
//      this.builder(BlockTags.SAND);
//      this.builder(BlockTags.SMELTS_TO_GLASS);
//      this.builder(BlockTags.STAIRS);
//      this.builder(BlockTags.SLABS);
//      this.builder(BlockTags.WALLS);
//      this.builder(BlockTags.ANVIL);
//      this.builder(BlockTags.RAILS);
//      this.builder(BlockTags.LEAVES);
//      this.builder(BlockTags.TRAPDOORS);
//      this.builder(BlockTags.SMALL_FLOWERS);
//      this.builder(BlockTags.BEDS);
//      this.builder(BlockTags.FENCES);
//      this.builder(BlockTags.TALL_FLOWERS);
//      this.builder(BlockTags.FLOWERS);
		this.builder(BlockTags.PIGLIN_REPELLENTS)
				.add(JmBlockItemIds.SOUL_JACK_O_LANTERN);
//      this.builder(BlockTags.GOLD_ORES);
//      this.builder(BlockTags.IRON_ORES);
//      this.builder(BlockTags.DIAMOND_ORES);
//      this.builder(BlockTags.REDSTONE_ORES);
//      this.builder(BlockTags.LAPIS_ORES);
//      this.builder(BlockTags.COAL_ORES);
//      this.builder(BlockTags.EMERALD_ORES);
//      this.builder(BlockTags.COPPER_ORES);
//      this.builder(BlockTags.CANDLES);
		this.builder(BlockTags.DIRT)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.TERRACOTTA);
//      this.builder(BlockTags.BADLANDS_TERRACOTTA);
//      this.builder(BlockTags.CONCRETE_POWDER);
//      this.builder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL);
//      this.builder(BlockTags.SHULKER_BOXES);
//      this.builder(BlockTags.FLOWER_POTS);
		this.builder(BlockTags.ENDERMAN_HOLDABLE)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.ICE);
		this.builder(BlockTags.VALID_SPAWN)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.IMPERMEABLE);
//      this.builder(BlockTags.UNDERWATER_BONEMEALS);
//      this.builder(BlockTags.CORAL_BLOCKS);
//      this.builder(BlockTags.WALL_CORALS);
//      this.builder(BlockTags.CORAL_PLANTS);
//      this.builder(BlockTags.CORALS);
		this.builder(BlockTags.SUPPORTS_BAMBOO)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.STANDING_SIGNS);
//      this.builder(BlockTags.WALL_SIGNS);
//      this.builder(BlockTags.SIGNS);
//      this.builder(BlockTags.CEILING_HANGING_SIGNS);
//      this.builder(BlockTags.WALL_HANGING_SIGNS);
//      this.builder(BlockTags.ALL_HANGING_SIGNS);
//      this.builder(BlockTags.ALL_SIGNS);
//      this.builder(BlockTags.DRAGON_IMMUNE);
//      this.builder(BlockTags.DRAGON_TRANSPARENT);
//      this.builder(BlockTags.WITHER_IMMUNE);
//      this.builder(BlockTags.WITHER_SUMMON_BASE_BLOCKS);
//      this.builder(BlockTags.BEEHIVES);
//      this.builder(BlockTags.CROPS);
//      this.builder(BlockTags.BEE_GROWABLES);
//      this.builder(BlockTags.PORTALS);
//      this.builder(BlockTags.FIRE);
//      this.builder(BlockTags.NYLIUM);
//      this.builder(BlockTags.BEACON_BASE_BLOCKS);
//      this.builder(BlockTags.SOUL_SPEED_BLOCKS);
//      this.builder(BlockTags.WALL_POST_OVERRIDE);
		this.builder(BlockTags.CLIMBABLE)
				.addTag(JinericBlockTags.LADDERS);
//      this.builder(BlockTags.FALL_DAMAGE_RESETTING);
//      this.builder(BlockTags.HOGLIN_REPELLENTS);
//      this.builder(BlockTags.SOUL_FIRE_BASE_BLOCKS);
//      this.builder(BlockTags.STRIDER_WARM_BLOCKS);
		this.builder(BlockTags.CAMPFIRES)
				.add(JmBlockItemIds.REDSTONE_CAMPFIRE);
		this.builder(BlockTags.GUARDED_BY_PIGLINS)
				.addTag(JinericBlockTags.CHESTS);
//      this.builder(BlockTags.PREVENT_MOB_SPAWNING_INSIDE);
//      this.builder(BlockTags.FENCE_GATES);
//      this.builder(BlockTags.UNSTABLE_BOTTOM_CENTER);
//      this.builder(BlockTags.MUSHROOM_GROW_BLOCK);
//      this.builder(BlockTags.INFINIBURN_OVERWORLD);
//      this.builder(BlockTags.INFINIBURN_NETHER);
//      this.builder(BlockTags.INFINIBURN_END);
//      this.builder(BlockTags.BASE_STONE_OVERWORLD);
//      this.builder(BlockTags.STONE_ORE_REPLACEABLES);
//      this.builder(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
//      this.builder(BlockTags.BASE_STONE_NETHER);
		this.builder(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
				.add(JmBlockItemIds.GRASS_BLOCK);
		this.builder(BlockTags.NETHER_CARVER_REPLACEABLES)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.CANDLE_CAKES);
//      this.builder(BlockTags.CAULDRONS);
//      this.builder(BlockTags.CRYSTAL_SOUND_BLOCKS);
//      this.builder(BlockTags.INSIDE_STEP_SOUND_BLOCKS);
//      this.builder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS);
//      this.builder(BlockTags.CAMEL_SAND_STEP_SOUND_BLOCKS);
//      this.builder(BlockTags.OCCLUDES_VIBRATION_SIGNALS);
//      this.builder(BlockTags.DAMPENS_VIBRATIONS);
//      this.builder(BlockTags.DRIPSTONE_REPLACEABLE_BLOCKS);
//      this.builder(BlockTags.CAVE_VINES);
		this.builder(BlockTags.MOSS_REPLACEABLE)
				.add(JmBlockItemIds.GRASS_BLOCK);
		this.builder(BlockTags.LUSH_GROUND_REPLACEABLE)
				.add(JmBlockItemIds.GRASS_BLOCK);
		this.builder(BlockTags.AZALEA_ROOT_REPLACEABLE)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.SMALL_DRIPLEAF_PLACEABLE);
		this.builder(BlockTags.SUPPORTS_BIG_DRIPLEAF)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.SNOW);
//      this.builder(BlockTags.FEATURES_CANNOT_REPLACE);
//      this.builder(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE);
//      this.builder(BlockTags.GEODE_INVALID_BLOCKS);
//      this.builder(BlockTags.FROG_PREFER_JUMP_TO);
		this.builder(BlockTags.SCULK_REPLACEABLE)
				.add(JmBlockItemIds.GRASS_BLOCK);
		this.builder(BlockTags.SCULK_REPLACEABLE_WORLD_GEN)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.ANCIENT_CITY_REPLACEABLE);
//      this.builder(BlockTags.VIBRATION_RESONATORS);
		this.builder(BlockTags.ANIMALS_SPAWNABLE_ON)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.ARMADILLO_SPAWNABLE_ON);
//      this.builder(BlockTags.AXOLOTLS_SPAWNABLE_ON);
//      this.builder(BlockTags.GOATS_SPAWNABLE_ON);
//      this.builder(BlockTags.MOOSHROOMS_SPAWNABLE_ON);
		this.builder(BlockTags.PARROTS_SPAWNABLE_ON)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.POLAR_BEARS_SPAWNABLE_ON_ALTERNATE);
		this.builder(BlockTags.RABBITS_SPAWNABLE_ON)
				.add(JmBlockItemIds.GRASS_BLOCK);
		this.builder(BlockTags.FOXES_SPAWNABLE_ON)
				.add(JmBlockItemIds.GRASS_BLOCK);
		this.builder(BlockTags.WOLVES_SPAWNABLE_ON)
				.add(JmBlockItemIds.GRASS_BLOCK);
		this.builder(BlockTags.FROGS_SPAWNABLE_ON)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.BATS_SPAWNABLE_ON);
		this.builder(BlockTags.AZALEA_GROWS_ON)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.CONVERTABLE_TO_MUD);
//      this.builder(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH);
//      this.builder(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH);
//      this.builder(BlockTags.SNAPS_GOAT_HORN);
//      this.builder(BlockTags.REPLACEABLE_BY_TREES);
//      this.builder(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON);
//      this.builder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON);
//      this.builder(BlockTags.INVALID_SPAWN_INSIDE);
		this.builder(BlockTags.SNIFFER_DIGGABLE_BLOCK)
				.add(JmBlockItemIds.GRASS_BLOCK);
//      this.builder(BlockTags.SNIFFER_EGG_HATCH_BOOST);
//      this.builder(BlockTags.TRAIL_RUINS_REPLACEABLE);
//      this.builder(BlockTags.REPLACEABLE);
//      this.builder(BlockTags.ENCHANTMENT_POWER_PROVIDER);
//      this.builder(BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
//      this.builder(BlockTags.MAINTAINS_FARMLAND);
//      this.builder(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS);
//      this.builder(BlockTags.DOES_NOT_BLOCK_HOPPERS);

		// JinericBlock Tags
		this.builder(JinericBlockTags.NOT_PICKAXE_WALL)
				.add(JmBlockItemIds.SNOW_BRICK_WALL)
				.add(JmBlockItemIds.SNOW_WALL);
		this.builder(JinericBlockTags.LADDERS)
				.addTag(JinericBlockTags.WOODEN_LADDERS);
		this.builder(JinericBlockTags.CHESTS)
				.addTag(JinericBlockTags.WOODEN_CHESTS);
		this.builder(JinericBlockTags.TRAPPED_CHESTS)
				.addTag(JinericBlockTags.WOODEN_TRAPPED_CHESTS);
		this.builder(JinericBlockTags.WOODEN_CHESTS)
				.add(JmBlockItemIds.SPRUCE_CHEST)
				.add(JmBlockItemIds.BIRCH_CHEST)
				.add(JmBlockItemIds.JUNGLE_CHEST)
				.add(JmBlockItemIds.ACACIA_CHEST)
				.add(JmBlockItemIds.DARK_OAK_CHEST)
				.add(JmBlockItemIds.MANGROVE_CHEST)
				.add(JmBlockItemIds.CHERRY_CHEST)
				.add(JmBlockItemIds.PALE_OAK_CHEST)
				.add(JmBlockItemIds.BAMBOO_CHEST)
				.add(JmBlockItemIds.CRIMSON_CHEST)
				.add(JmBlockItemIds.WARPED_CHEST);
		this.builder(JinericBlockTags.WOODEN_TRAPPED_CHESTS)
				.add(JmBlockItemIds.TRAPPED_SPRUCE_CHEST)
				.add(JmBlockItemIds.TRAPPED_BIRCH_CHEST)
				.add(JmBlockItemIds.TRAPPED_JUNGLE_CHEST)
				.add(JmBlockItemIds.TRAPPED_ACACIA_CHEST)
				.add(JmBlockItemIds.TRAPPED_DARK_OAK_CHEST)
				.add(JmBlockItemIds.TRAPPED_MANGROVE_CHEST)
				.add(JmBlockItemIds.TRAPPED_CHERRY_CHEST)
				.add(JmBlockItemIds.TRAPPED_PALE_OAK_CHEST)
				.add(JmBlockItemIds.TRAPPED_BAMBOO_CHEST)
				.add(JmBlockItemIds.TRAPPED_CRIMSON_CHEST)
				.add(JmBlockItemIds.TRAPPED_WARPED_CHEST);
		this.builder(JinericBlockTags.WOODEN_LADDERS)
				.add(JmBlockItemIds.SPRUCE_LADDER)
				.add(JmBlockItemIds.BIRCH_LADDER)
				.add(JmBlockItemIds.JUNGLE_LADDER)
				.add(JmBlockItemIds.ACACIA_LADDER)
				.add(JmBlockItemIds.DARK_OAK_LADDER)
				.add(JmBlockItemIds.MANGROVE_LADDER)
				.add(JmBlockItemIds.CHERRY_LADDER)
				.add(JmBlockItemIds.PALE_OAK_LADDER)
				.add(JmBlockItemIds.BAMBOO_LADDER)
				.add(JmBlockItemIds.CRIMSON_LADDER)
				.add(JmBlockItemIds.WARPED_LADDER);
		this.builder(JinericBlockTags.WOODEN_BOOKSHELVES)
				.add(JmBlockItemIds.SPRUCE_BOOKSHELF)
				.add(JmBlockItemIds.BIRCH_BOOKSHELF)
				.add(JmBlockItemIds.JUNGLE_BOOKSHELF)
				.add(JmBlockItemIds.ACACIA_BOOKSHELF)
				.add(JmBlockItemIds.DARK_OAK_BOOKSHELF)
				.add(JmBlockItemIds.MANGROVE_BOOKSHELF)
				.add(JmBlockItemIds.CHERRY_BOOKSHELF)
				.add(JmBlockItemIds.PALE_OAK_BOOKSHELF)
				.add(JmBlockItemIds.BAMBOO_BOOKSHELF)
				.add(JmBlockItemIds.CRIMSON_BOOKSHELF)
				.add(JmBlockItemIds.WARPED_BOOKSHELF);
		this.builder(JinericBlockTags.JM_GRASS_BLOCK_REPLACEABLE).add(BlockItemIds.GRASS_BLOCK);
		this.builder(JinericBlockTags.SLIPPERY)
				.add(JmBlockItemIds.PACKED_ICE_STAIRS)
				.add(JmBlockItemIds.PACKED_ICE_SLAB)
				.add(JmBlockItemIds.PACKED_ICE_WALL);
		this.builder(JinericBlockTags.SAPLINGS)
				.add(BlockItemIds.ACACIA_SAPLING)
				.add(BlockItemIds.BIRCH_SAPLING)
				.add(BlockItemIds.CHERRY_SAPLING)
				.add(BlockItemIds.DARK_OAK_SAPLING)
				.add(BlockItemIds.JUNGLE_SAPLING)
				.add(BlockItemIds.OAK_SAPLING)
				.add(BlockItemIds.PALE_OAK_SAPLING)
				.add(BlockItemIds.SPRUCE_SAPLING);

		// Sounds
		this.builder(JinericBlockSoundTags.VEGETATION_SOUNDS)
				.addOptionalTag(BlockTags.FLOWERS)
				.add(BlockItemIds.GRASS_BLOCK)
				.add(BlockItemIds.SHORT_GRASS)
				.add(BlockItemIds.TALL_GRASS)
				.add(BlockItemIds.FERN)
				.add(BlockItemIds.LARGE_FERN)
				.add(BlockItemIds.GLOW_LICHEN)
				.add(BlockItemIds.VINE)
				.add(JmBlockItemIds.GRASS_BLOCK);
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
				.forEach(block -> {
					BlockItemId blockItemId = new BlockItemId(
							ResourceKey.create(
									Registries.BLOCK, BuiltInRegistries.BLOCK.getKey(block)
							),
							ResourceKey.create(
									Registries.ITEM, BuiltInRegistries.ITEM.getKey(block.asItem())
							)
					);
					this.builder(tagKey).add(blockItemId);
				});
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
							this.builder(blockTag).add(
									new BlockItemId(
											ResourceKey.create(Registries.BLOCK, BuiltInRegistries.BLOCK.getKey(familyVariantBlock)),
											ResourceKey.create(Registries.ITEM, BuiltInRegistries.ITEM.getKey(familyVariantBlock.asItem()))
									)
							);
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
