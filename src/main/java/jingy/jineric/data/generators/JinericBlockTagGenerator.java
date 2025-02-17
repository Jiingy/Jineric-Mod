package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.tag.JinericBlockSoundTags;
import jingy.jineric.tag.JinericBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static jingy.jineric.block.JinericBlocks.*;

public class JinericBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
   public Map<TagKey<Block>, Block> blockTagMap = new HashMap<>();

   public JinericBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
      super(output, registriesFuture);
   }

   @Override
   protected void configure(RegistryWrapper.WrapperLookup arg) {
      this.blockFamiliesToFamilyVariantTag(BlockTags.BUTTONS, BlockFamily.Variant.BUTTON);
      this.blockFamiliesToFamilyVariantTag(BlockTags.DOORS, BlockFamily.Variant.DOOR);
      this.blockFamiliesToFamilyVariantTag(BlockTags.FENCES, BlockFamily.Variant.FENCE);
      this.blockFamiliesToFamilyVariantTag(BlockTags.FENCE_GATES, BlockFamily.Variant.FENCE_GATE);
      this.blockFamiliesToFamilyVariantTag(BlockTags.SIGNS, BlockFamily.Variant.SIGN);
      this.blockFamiliesToFamilyVariantTag(BlockTags.SLABS, BlockFamily.Variant.SLAB);
      this.blockFamiliesToFamilyVariantTag(BlockTags.STAIRS, BlockFamily.Variant.STAIRS);
      this.blockFamiliesToFamilyVariantTag(BlockTags.PRESSURE_PLATES, BlockFamily.Variant.PRESSURE_PLATE);
      this.blockFamiliesToFamilyVariantTag(BlockTags.TRAPDOORS, BlockFamily.Variant.TRAPDOOR);
      this.blockFamiliesToFamilyVariantTag(BlockTags.WALLS, BlockFamily.Variant.WALL);
      this.blockFamiliesToFamilyVariantTag(BlockTags.WALL_SIGNS, BlockFamily.Variant.WALL_SIGN);
      // Needs Tool
      this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
      this.getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
      this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
              .add(CUT_COPPER_WALL, EXPOSED_CUT_COPPER_WALL, WEATHERED_CUT_COPPER_WALL, OXIDIZED_CUT_COPPER_WALL)
              .add(WAXED_CUT_COPPER_WALL, WAXED_EXPOSED_CUT_COPPER_WALL, WAXED_WEATHERED_CUT_COPPER_WALL, WAXED_OXIDIZED_CUT_COPPER_WALL);
      // Incorrect for Tool
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
              .add(CUT_COPPER_WALL, EXPOSED_CUT_COPPER_WALL, WEATHERED_CUT_COPPER_WALL, OXIDIZED_CUT_COPPER_WALL)
              .add(WAXED_CUT_COPPER_WALL, WAXED_EXPOSED_CUT_COPPER_WALL, WAXED_WEATHERED_CUT_COPPER_WALL, WAXED_OXIDIZED_CUT_COPPER_WALL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
              .add(CUT_COPPER_WALL, EXPOSED_CUT_COPPER_WALL, WEATHERED_CUT_COPPER_WALL, OXIDIZED_CUT_COPPER_WALL)
              .add(WAXED_CUT_COPPER_WALL, WAXED_EXPOSED_CUT_COPPER_WALL, WAXED_WEATHERED_CUT_COPPER_WALL, WAXED_OXIDIZED_CUT_COPPER_WALL);
      // AXE
      this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
              .forceAddTag(JinericBlockTags.WOODEN_CHESTS)
              .forceAddTag(JinericBlockTags.WOODEN_TRAPPED_CHESTS)
              .forceAddTag(JinericBlockTags.WOODEN_LADDERS)
              .forceAddTag(JinericBlockTags.WOODEN_BOOKSHELVES)
              .add(STICK_BLOCK)
              .add(SOUL_JACK_O_LANTERN)
              .add(REDSTONE_CAMPFIRE);
      // HOE
      this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
              .add(ROTTEN_FLESH_BLOCK)
              .add(PAPER_BLOCK);
      // PICKAXE
      this.putBlocksToTag(BlockTags.PICKAXE_MINEABLE,
              JinericBlocks.CUT_COPPER_WALL, JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.OXIDIZED_CUT_COPPER_WALL,
              JinericBlocks.WAXED_CUT_COPPER_WALL, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL,
              JinericBlocks.BLAZE_ROD_BLOCK, JinericBlocks.EGG_BLOCK, JinericBlocks.PRISMARINE_CRYSTAL_BLOCK, JinericBlocks.BONE_MEAL_BLOCK, JinericBlocks.FLINT_BLOCK, JinericBlocks.CHARCOAL_BLOCK,
              JinericBlocks.STONE_BRICK_PILLAR, JinericBlocks.TUFF_BRICK_PILLAR, JinericBlocks.DRIPSTONE_BRICK_PILLAR,
              JinericBlocks.REDSTONE_LANTERN,
              JinericBlocks.REFINERY
      );
      this.blockFamiliesToTag(BlockTags.PICKAXE_MINEABLE,
              JinericBlockFamilies.STONE, JinericBlockFamilies.SMOOTH_STONE,
              JinericBlockFamilies.POLISHED_STONE,
              JinericBlockFamilies.CRACKED_STONE_BRICKS,
              JinericBlockFamilies.STONE_TILES, JinericBlockFamilies.CRACKED_STONE_TILES,
              JinericBlockFamilies.SMOOTH_DEEPSLATE, JinericBlockFamilies.CRACKED_DEEPSLATE_BRICKS, JinericBlockFamilies.CRACKED_DEEPSLATE_TILES,
              JinericBlockFamilies.SMOOTH_TUFF,
              JinericBlockFamilies.CRACKED_TUFF_BRICKS,
              JinericBlockFamilies.TUFF_TILES, JinericBlockFamilies.CRACKED_TUFF_TILES,
              JinericBlockFamilies.DRIPSTONE, JinericBlockFamilies.SMOOTH_DRIPSTONE,
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
              JinericBlockFamilies.QUARTZ_BLOCK, JinericBlockFamilies.SMOOTH_QUARTZ, JinericBlockFamilies.QUARTZ_BRICKS,
              JinericBlockFamilies.CRACKED_NETHER_BRICKS, JinericBlockFamilies.RED_NETHER_BRICK,
              JinericBlockFamilies.CRACKED_POLISHED_BLACKSTONE_BRICKS,
              JinericBlockFamilies.SMOOTH_BASALT,
              JinericBlockFamilies.PURPUR
      );
      // SHOVEL
      this.getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
              .add(FULL_GRASS_BLOCK)
              .add(SUGAR_BLOCK);
      // SWORD
      this.getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT);
      // BLOCK FAMILY -> TAG
      this.blockFamiliesToTag(BlockTags.SHOVEL_MINEABLE, JinericBlockFamilies.SNOW_BRICKS);
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
//      this.getOrCreateTagBuilder(BlockTags.WOOL);
//      this.getOrCreateTagBuilder(BlockTags.PLANKS);
      this.getOrCreateTagBuilder(BlockTags.STONE_BRICKS)
              .add(STONE_BRICK_PILLAR);
//      this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS);
//      this.getOrCreateTagBuilder(BlockTags.STONE_BUTTONS);
//      this.getOrCreateTagBuilder(BlockTags.BUTTONS);
//      this.getOrCreateTagBuilder(BlockTags.WOOL_CARPETS);
//      this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS);
//      this.getOrCreateTagBuilder(BlockTags.MOB_INTERACTABLE_DOORS);
//      this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS);
//      this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS);
//      this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES);
//      this.getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES);
//      this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES);
//      this.getOrCreateTagBuilder(BlockTags.STONE_PRESSURE_PLATES);
//      this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS);
//      this.getOrCreateTagBuilder(BlockTags.DOORS);
//      this.getOrCreateTagBuilder(BlockTags.SAPLINGS);
//      this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN);
//      this.getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.LOGS);
//      this.getOrCreateTagBuilder(BlockTags.DARK_OAK_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.PALE_OAK_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.OAK_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.BIRCH_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.ACACIA_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.CHERRY_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.JUNGLE_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.SPRUCE_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS);
//      this.getOrCreateTagBuilder(BlockTags.CRIMSON_STEMS);
//      this.getOrCreateTagBuilder(BlockTags.WARPED_STEMS);
//      this.getOrCreateTagBuilder(BlockTags.BAMBOO_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.WART_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.BANNERS);
//      this.getOrCreateTagBuilder(BlockTags.SAND);
//      this.getOrCreateTagBuilder(BlockTags.SMELTS_TO_GLASS);
//      this.getOrCreateTagBuilder(BlockTags.STAIRS);
//      this.getOrCreateTagBuilder(BlockTags.SLABS);
//      this.getOrCreateTagBuilder(BlockTags.WALLS);
//      this.getOrCreateTagBuilder(BlockTags.ANVIL);
//      this.getOrCreateTagBuilder(BlockTags.RAILS);
//      this.getOrCreateTagBuilder(BlockTags.LEAVES);
//      this.getOrCreateTagBuilder(BlockTags.TRAPDOORS);
//      this.getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS);
//      this.getOrCreateTagBuilder(BlockTags.BEDS);
//      this.getOrCreateTagBuilder(BlockTags.FENCES);
//      this.getOrCreateTagBuilder(BlockTags.TALL_FLOWERS);
//      this.getOrCreateTagBuilder(BlockTags.FLOWERS);
      this.getOrCreateTagBuilder(BlockTags.PIGLIN_REPELLENTS)
              .add(SOUL_JACK_O_LANTERN);
//      this.getOrCreateTagBuilder(BlockTags.GOLD_ORES);
//      this.getOrCreateTagBuilder(BlockTags.IRON_ORES);
//      this.getOrCreateTagBuilder(BlockTags.DIAMOND_ORES);
//      this.getOrCreateTagBuilder(BlockTags.REDSTONE_ORES);
//      this.getOrCreateTagBuilder(BlockTags.LAPIS_ORES);
//      this.getOrCreateTagBuilder(BlockTags.COAL_ORES);
//      this.getOrCreateTagBuilder(BlockTags.EMERALD_ORES);
//      this.getOrCreateTagBuilder(BlockTags.COPPER_ORES);
//      this.getOrCreateTagBuilder(BlockTags.CANDLES);
      this.getOrCreateTagBuilder(BlockTags.DIRT)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.TERRACOTTA);
//      this.getOrCreateTagBuilder(BlockTags.BADLANDS_TERRACOTTA);
//      this.getOrCreateTagBuilder(BlockTags.CONCRETE_POWDER);
//      this.getOrCreateTagBuilder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL);
//      this.getOrCreateTagBuilder(BlockTags.SHULKER_BOXES);
//      this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS);
      this.getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.ICE);
      this.getOrCreateTagBuilder(BlockTags.VALID_SPAWN)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.IMPERMEABLE);
//      this.getOrCreateTagBuilder(BlockTags.UNDERWATER_BONEMEALS);
//      this.getOrCreateTagBuilder(BlockTags.CORAL_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.WALL_CORALS);
//      this.getOrCreateTagBuilder(BlockTags.CORAL_PLANTS);
//      this.getOrCreateTagBuilder(BlockTags.CORALS);
      this.getOrCreateTagBuilder(BlockTags.BAMBOO_PLANTABLE_ON)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS);
//      this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS);
//      this.getOrCreateTagBuilder(BlockTags.SIGNS);
//      this.getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS);
//      this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS);
//      this.getOrCreateTagBuilder(BlockTags.ALL_HANGING_SIGNS);
//      this.getOrCreateTagBuilder(BlockTags.ALL_SIGNS);
//      this.getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE);
//      this.getOrCreateTagBuilder(BlockTags.DRAGON_TRANSPARENT);
//      this.getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE);
//      this.getOrCreateTagBuilder(BlockTags.WITHER_SUMMON_BASE_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.BEEHIVES);
//      this.getOrCreateTagBuilder(BlockTags.CROPS);
//      this.getOrCreateTagBuilder(BlockTags.BEE_GROWABLES);
//      this.getOrCreateTagBuilder(BlockTags.PORTALS);
//      this.getOrCreateTagBuilder(BlockTags.FIRE);
//      this.getOrCreateTagBuilder(BlockTags.NYLIUM);
//      this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE);
      this.getOrCreateTagBuilder(BlockTags.CLIMBABLE)
              .forceAddTag(JinericBlockTags.LADDERS);
//      this.getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING);
//      this.getOrCreateTagBuilder(BlockTags.HOGLIN_REPELLENTS);
//      this.getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.STRIDER_WARM_BLOCKS);
      this.getOrCreateTagBuilder(BlockTags.CAMPFIRES)
              .add(REDSTONE_CAMPFIRE);
      this.getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
              .forceAddTag(JinericBlockTags.CHESTS);
//      this.getOrCreateTagBuilder(BlockTags.PREVENT_MOB_SPAWNING_INSIDE);
//      this.getOrCreateTagBuilder(BlockTags.FENCE_GATES);
//      this.getOrCreateTagBuilder(BlockTags.UNSTABLE_BOTTOM_CENTER);
//      this.getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD);
//      this.getOrCreateTagBuilder(BlockTags.INFINIBURN_NETHER);
//      this.getOrCreateTagBuilder(BlockTags.INFINIBURN_END);
//      this.getOrCreateTagBuilder(BlockTags.BASE_STONE_OVERWORLD);
//      this.getOrCreateTagBuilder(BlockTags.STONE_ORE_REPLACEABLES);
//      this.getOrCreateTagBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
//      this.getOrCreateTagBuilder(BlockTags.BASE_STONE_NETHER);
      this.getOrCreateTagBuilder(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
              .add(FULL_GRASS_BLOCK);
      this.getOrCreateTagBuilder(BlockTags.NETHER_CARVER_REPLACEABLES)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.CANDLE_CAKES);
//      this.getOrCreateTagBuilder(BlockTags.CAULDRONS);
//      this.getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.CAMEL_SAND_STEP_SOUND_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS);
//      this.getOrCreateTagBuilder(BlockTags.DAMPENS_VIBRATIONS);
//      this.getOrCreateTagBuilder(BlockTags.DRIPSTONE_REPLACEABLE_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.CAVE_VINES);
      this.getOrCreateTagBuilder(BlockTags.MOSS_REPLACEABLE)
              .add(FULL_GRASS_BLOCK);
      this.getOrCreateTagBuilder(BlockTags.LUSH_GROUND_REPLACEABLE)
              .add(FULL_GRASS_BLOCK);
      this.getOrCreateTagBuilder(BlockTags.AZALEA_ROOT_REPLACEABLE)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE);
      this.getOrCreateTagBuilder(BlockTags.BIG_DRIPLEAF_PLACEABLE)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.SNOW);
//      this.getOrCreateTagBuilder(BlockTags.FEATURES_CANNOT_REPLACE);
//      this.getOrCreateTagBuilder(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE);
//      this.getOrCreateTagBuilder(BlockTags.GEODE_INVALID_BLOCKS);
//      this.getOrCreateTagBuilder(BlockTags.FROG_PREFER_JUMP_TO);
      this.getOrCreateTagBuilder(BlockTags.SCULK_REPLACEABLE)
              .add(FULL_GRASS_BLOCK);
      this.getOrCreateTagBuilder(BlockTags.SCULK_REPLACEABLE_WORLD_GEN)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.ANCIENT_CITY_REPLACEABLE);
//      this.getOrCreateTagBuilder(BlockTags.VIBRATION_RESONATORS);
      this.getOrCreateTagBuilder(BlockTags.ANIMALS_SPAWNABLE_ON)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.ARMADILLO_SPAWNABLE_ON);
//      this.getOrCreateTagBuilder(BlockTags.AXOLOTLS_SPAWNABLE_ON);
//      this.getOrCreateTagBuilder(BlockTags.GOATS_SPAWNABLE_ON);
//      this.getOrCreateTagBuilder(BlockTags.MOOSHROOMS_SPAWNABLE_ON);
      this.getOrCreateTagBuilder(BlockTags.PARROTS_SPAWNABLE_ON)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.POLAR_BEARS_SPAWNABLE_ON_ALTERNATE);
      this.getOrCreateTagBuilder(BlockTags.RABBITS_SPAWNABLE_ON)
              .add(FULL_GRASS_BLOCK);
      this.getOrCreateTagBuilder(BlockTags.FOXES_SPAWNABLE_ON)
              .add(FULL_GRASS_BLOCK);
      this.getOrCreateTagBuilder(BlockTags.WOLVES_SPAWNABLE_ON)
              .add(FULL_GRASS_BLOCK);
      this.getOrCreateTagBuilder(BlockTags.FROGS_SPAWNABLE_ON)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.BATS_SPAWNABLE_ON);
      this.getOrCreateTagBuilder(BlockTags.AZALEA_GROWS_ON)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.CONVERTABLE_TO_MUD);
//      this.getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH);
//      this.getOrCreateTagBuilder(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH);
      this.getOrCreateTagBuilder(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.SNAPS_GOAT_HORN);
//      this.getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES);
//      this.getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON);
//      this.getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON);
//      this.getOrCreateTagBuilder(BlockTags.INVALID_SPAWN_INSIDE);
      this.getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK)
              .add(FULL_GRASS_BLOCK);
//      this.getOrCreateTagBuilder(BlockTags.SNIFFER_EGG_HATCH_BOOST);
//      this.getOrCreateTagBuilder(BlockTags.TRAIL_RUINS_REPLACEABLE);
//      this.getOrCreateTagBuilder(BlockTags.REPLACEABLE);
//      this.getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER);
//      this.getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
//      this.getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND);
//      this.getOrCreateTagBuilder(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS);
//      this.getOrCreateTagBuilder(BlockTags.DOES_NOT_BLOCK_HOPPERS);

      // JinericBlock Tags
      this.getOrCreateTagBuilder(JinericBlockTags.LADDERS)
              .forceAddTag(JinericBlockTags.WOODEN_LADDERS);
      this.getOrCreateTagBuilder(JinericBlockTags.NOT_PICKAXE_WALL)
              .add(SNOW_BRICK_WALL, SNOW_WALL);
      this.getOrCreateTagBuilder(JinericBlockTags.WOODEN_CHESTS)
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
      this.getOrCreateTagBuilder(JinericBlockTags.WOODEN_TRAPPED_CHESTS)
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
      this.getOrCreateTagBuilder(JinericBlockTags.WOODEN_LADDERS)
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
      this.getOrCreateTagBuilder(JinericBlockTags.WOODEN_BOOKSHELVES)
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
      this.getOrCreateTagBuilder(JinericBlockTags.CHESTS)
              .forceAddTag(JinericBlockTags.WOODEN_CHESTS)
              .forceAddTag(JinericBlockTags.WOODEN_TRAPPED_CHESTS);
      this.getOrCreateTagBuilder(JinericBlockTags.FULL_GRASS_REPLACEABLE).add(Blocks.GRASS_BLOCK);
      this.getOrCreateTagBuilder(JinericBlockTags.SLIPPERY).add(PACKED_ICE_STAIRS, PACKED_ICE_SLAB, PACKED_ICE_WALL);
         // Sounds
      this.getOrCreateTagBuilder(JinericBlockSoundTags.VEGETATION_SOUNDS)
              .forceAddTag(BlockTags.SMALL_FLOWERS)
              .add(FULL_GRASS_BLOCK)
              .add(Blocks.GRASS_BLOCK)
              .add(Blocks.SHORT_GRASS)
              .add(Blocks.TALL_GRASS)
              .add(Blocks.FERN)
              .add(Blocks.LARGE_FERN)
              .add(Blocks.GLOW_LICHEN)
              .add(Blocks.VINE);
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
      }
      blockToAdd.sort(Comparator.comparing(Block::toString));
      blockToAdd.stream()
              .filter(block -> Registries.BLOCK.getId(block).getNamespace().equals("jineric") && !block.getDefaultState().isIn(tagKey))
              .forEach(block -> this.getOrCreateTagBuilder(tagKey).add(block));
   }

   private void blockListToTag(TagKey<Block> tagKey, Block... baseBlockIn) {
      for (Block block : baseBlockIn) {
         List<BlockFamily> blockFamilies = BlockFamilies.getFamilies().toList();
         blockFamilies.forEach(blockFamily -> {
            Map<BlockFamily.Variant, Block> variants = blockFamily.getVariants();
            if (blockFamily.getBaseBlock() == block) {
               variants.values().stream().filter(testBlock -> !testBlock.getDefaultState().isIn(tagKey) && Registries.BLOCK.getId(testBlock).getNamespace().equals("jineric"))
                       .forEach((blockVariant) -> this.getOrCreateTagBuilder(tagKey).add(blockVariant));
            }
         });
         if (Registries.BLOCK.getId(block).getNamespace().equals("jineric")) {
            this.getOrCreateTagBuilder(tagKey).add(block);
         }
      }
   }

   private void blockFamiliesToFamilyVariantTag(TagKey<Block> blockTag, BlockFamily.Variant familyVariantIn) {
      List<BlockFamily> familyList = new ArrayList<>(BlockFamilies.getFamilies().toList());
      familyList.sort(Comparator.comparing(blockFamily -> {
         Block familyVariant = blockFamily.getVariant(familyVariantIn);
         return familyVariant != null ? blockFamily.getVariant(familyVariantIn).toString() : blockFamily.getBaseBlock().toString();
      }));
      familyList.forEach(
              (blockFamily) -> {
                 if (blockFamily.getVariant(familyVariantIn) != null) {
                    Block familyVariantBlock = blockFamily.getVariant(familyVariantIn);
                    if (Registries.BLOCK.getId(familyVariantBlock).getNamespace().equals("jineric")) {
                       this.getOrCreateTagBuilder(blockTag).add(familyVariantBlock);
                    }
                 }
              }
      );
   }

   @Override
   public String getName() {
      return "jineric_block_tags";
   }
}
