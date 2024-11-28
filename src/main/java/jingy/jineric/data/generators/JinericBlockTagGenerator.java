package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
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
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static jingy.jineric.block.JinericBlocks.*;
import static net.minecraft.registry.tag.BlockTags.PICKAXE_MINEABLE;

public class JinericBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
   public JinericBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
      super(output, registriesFuture);
   }

   @Override
   protected void configure(RegistryWrapper.WrapperLookup arg) {
      this.genFamiliesToBlockTypeTags();
      // Needs Tool
      this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
      this.getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
      this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
              .add(JinericBlocks.CUT_COPPER_WALL, JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.OXIDIZED_CUT_COPPER_WALL)
              .add(JinericBlocks.WAXED_CUT_COPPER_WALL, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL);
      // Incorrect for Tool
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
              .add(JinericBlocks.CUT_COPPER_WALL, JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.OXIDIZED_CUT_COPPER_WALL)
              .add(JinericBlocks.WAXED_CUT_COPPER_WALL, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL);
      this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
              .add(JinericBlocks.CUT_COPPER_WALL, JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.OXIDIZED_CUT_COPPER_WALL)
              .add(JinericBlocks.WAXED_CUT_COPPER_WALL, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL);
      // AXE
      this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
              .forceAddTag(JinericBlockTags.WOODEN_CHESTS)
              .forceAddTag(JinericBlockTags.WOODEN_TRAPPED_CHESTS)
              .forceAddTag(JinericBlockTags.WOODEN_LADDERS)
              .forceAddTag(JinericBlockTags.WOODEN_BOOKSHELVES)
              .add(JinericBlocks.STICK_BLOCK)
              .add(JinericBlocks.SOUL_JACK_O_LANTERN)
              .add(JinericBlocks.REDSTONE_CAMPFIRE);
      // HOE
      this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
              .add(JinericBlocks.ROTTEN_FLESH_BLOCK)
              .add(JinericBlocks.PAPER_BLOCK);
      // PICKAXE
      this.getOrCreateTagBuilder(PICKAXE_MINEABLE)
              .add(JinericBlocks.CUT_COPPER_WALL, JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.OXIDIZED_CUT_COPPER_WALL)
              .add(JinericBlocks.WAXED_CUT_COPPER_WALL, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL)
              .add(JinericBlocks.BLAZE_ROD_BLOCK, JinericBlocks.EGG_BLOCK, JinericBlocks.PRISMARINE_CRYSTAL_BLOCK, JinericBlocks.BONE_MEAL_BLOCK, JinericBlocks.FLINT_BLOCK, JinericBlocks.CHARCOAL_BLOCK)
              .add(JinericBlocks.STONE_BRICK_PILLAR)
              .add(JinericBlocks.DRIPSTONE_BRICK_PILLAR)
              .add(JinericBlocks.REDSTONE_LANTERN)
              .add(JinericBlocks.PURPUR_WALL)
              .add(JinericBlocks.RED_NETHER_BRICK_FENCE)
              .add(JinericBlocks.STONE_WALL)
              .add(JinericBlocks.REFINERY);
      // SHOVEL
      this.getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
              .add(JinericBlocks.FULL_GRASS_BLOCK)
              .add(JinericBlocks.SUGAR_BLOCK);
      // SWORD
      this.getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT);
      // BLOCK FAMILY -> TAG
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, Blocks.SMOOTH_BASALT);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, Blocks.CRACKED_NETHER_BRICKS);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, SMOOTH_DEEPSLATE);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, Blocks.PACKED_ICE);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, POLISHED_STONE, Blocks.SMOOTH_STONE, Blocks.CRACKED_STONE_BRICKS, STONE_TILES, CRACKED_STONE_TILES);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, Blocks.CUT_SANDSTONE, POLISHED_SANDSTONE, WAVY_SANDSTONE);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, Blocks.CUT_RED_SANDSTONE, POLISHED_RED_SANDSTONE, WAVY_RED_SANDSTONE);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, SOUL_SANDSTONE, CUT_SOUL_SANDSTONE, POLISHED_SOUL_SANDSTONE, SMOOTH_SOUL_SANDSTONE, WAVY_SOUL_SANDSTONE, CHISELED_SOUL_SANDSTONE);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, Blocks.DRIPSTONE_BLOCK, COBBLED_DRIPSTONE, SMOOTH_DRIPSTONE, POLISHED_DRIPSTONE, DRIPSTONE_BRICKS, CRACKED_DRIPSTONE_BRICKS, DRIPSTONE_TILES, CRACKED_DRIPSTONE_TILES);
      this.blockFamilyToTag(BlockTags.PICKAXE_MINEABLE, TUFF_TILES, CRACKED_TUFF_TILES);
      this.blockFamilyToTag(PICKAXE_MINEABLE, Blocks.QUARTZ_BRICKS);
      this.blockFamilyToTag(BlockTags.SHOVEL_MINEABLE, SNOW_BRICKS);
      this.blockFamilyToTag(BlockTags.SOUL_SPEED_BLOCKS, SOUL_SANDSTONE, CUT_SOUL_SANDSTONE, POLISHED_SOUL_SANDSTONE, SMOOTH_SOUL_SANDSTONE, WAVY_SOUL_SANDSTONE, CHISELED_SOUL_SANDSTONE);
      this.blockFamilyToTag(BlockTags.DRAGON_IMMUNE, Blocks.OBSIDIAN);
      this.blockFamilyToTag(BlockTags.NEEDS_DIAMOND_TOOL, Blocks.OBSIDIAN);
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
              .forceAddTag(BlockTags.TALL_FLOWERS)
              .add(FULL_GRASS_BLOCK)
              .add(Blocks.GRASS_BLOCK)
              .add(Blocks.SHORT_GRASS)
              .add(Blocks.TALL_GRASS)
              .add(Blocks.FERN)
              .add(Blocks.LARGE_FERN)
              .add(Blocks.GLOW_LICHEN)
              .add(Blocks.VINE);
   }

   private void blockFamilyToTag(TagKey<Block> tagKey, Block... baseBlockIn) {
      for (Block block : baseBlockIn) {
         Stream<BlockFamily> blockFamilies = BlockFamilies.getFamilies();
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

//      Stream<BlockFamily> blockFamilies = BlockFamilies.getFamilies();
//      blockFamilies.forEach(blockFamily -> Arrays.stream(baseBlock).forEach(block -> {
//         if (blockFamily.getBaseBlock() == block) {
//            for (Block blockVariant : blockFamily.getVariants().values()) {
//               if (!blockVariant.getDefaultState().isIn(tagKey) && Registries.BLOCK.getId(blockVariant).getNamespace().equals("jineric")) {
//                  this.getOrCreateTagBuilder(tagKey).add(blockVariant);
//               }
//            }
//            if (!blockFamily.getBaseBlock().getDefaultState().isIn(tagKey)) {
//               this.getOrCreateTagBuilder(tagKey).add(blockFamily.getBaseBlock());
//            }
//         }
//      }));
   }

   private void genFamiliesToBlockTypeTags() {
      Stream<BlockFamily> blockFamilies = BlockFamilies.getFamilies();
      blockFamilies.forEach(
              (blockFamily) -> {
                 //TODO:
                 // ADD CASE HANDLING FOR 'WOODEN' VARIANT BLOCK TAGS
                 // ADD CASE HANDLING FOR EXTRA BLOCK TYPES (LIKE WALL SIGN)
                 // ADD CASE FOR 'SPECIALTY' WALLS (WALLS THAT ARE NOT MINED WITH PICKAXE)
                 this.genVariantTag(blockFamily, BlockFamily.Variant.BUTTON, BlockTags.BUTTONS);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.DOOR, BlockTags.DOORS);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.FENCE, BlockTags.FENCES);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.FENCE_GATE, BlockTags.FENCE_GATES);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.SIGN, BlockTags.SIGNS);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.SLAB, BlockTags.SLABS);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.STAIRS, BlockTags.STAIRS);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.PRESSURE_PLATE, BlockTags.PRESSURE_PLATES);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.TRAPDOOR, BlockTags.TRAPDOORS);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.WALL, BlockTags.WALLS);
                 this.genVariantTag(blockFamily, BlockFamily.Variant.WALL_SIGN, BlockTags.WALL_SIGNS);
              }
      );
   }

   private void genVariantTag(BlockFamily blockFamily, BlockFamily.Variant familyVariant, TagKey<Block> tagKey) {
      boolean jineric = getIdFamilyVariant(blockFamily, familyVariant).getNamespace().equals("jineric");
      Block variantBlock = blockFamily.getVariant(familyVariant);
      if (variantBlock != null && jineric) {
         if (variantBlock != JinericBlocks.SNOW_BRICK_WALL && variantBlock != JinericBlocks.SNOW_WALL)
//         if (!variantBlock.getDefaultState().isIn(JinericBlockTags.SPECIALTY_WALLS)) {
//            System.out.println("\nblock: " + variantBlock + "\ndefaultState:" + variantBlock.getDefaultState() + "\nboolean: " + variantBlock.getDefaultState().isIn(JinericBlockTags.SPECIALTY_WALLS));
            this.getTagBuilder(tagKey).add(getIdFamilyVariant(blockFamily, familyVariant));
//         }
      }
   }

   private static Identifier getIdFamilyVariant(BlockFamily blockFamily, BlockFamily.Variant variant) {
      return Registries.BLOCK.getId(blockFamily.getVariant(variant));
   }

   @Override
   public String getName() {
      return "jineric_block_tags";
   }
}
