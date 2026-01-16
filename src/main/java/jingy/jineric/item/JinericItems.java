package jingy.jineric.item;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class JinericItems {

//DONE ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//DRIPSTONE
	public static final Item POLISHED_STONE = register(JinericBlocks.POLISHED_STONE);
	public static final Item POLISHED_STONE_STAIRS = register(JinericBlocks.POLISHED_STONE_STAIRS);
	public static final Item POLISHED_STONE_SLAB = register(JinericBlocks.POLISHED_STONE_SLAB);
	public static final Item POLISHED_STONE_WALL = register(JinericBlocks.POLISHED_STONE_WALL);
	public static final Item DRIPSTONE_STAIRS = register(JinericBlocks.DRIPSTONE_STAIRS);
	public static final Item DRIPSTONE_SLAB = register(JinericBlocks.DRIPSTONE_SLAB);
	public static final Item DRIPSTONE_WALL = register(JinericBlocks.DRIPSTONE_WALL);
	public static final Item DRIPSTONE_BRICKS = register(JinericBlocks.DRIPSTONE_BRICKS);
	public static final Item DRIPSTONE_BRICK_STAIRS = register(JinericBlocks.DRIPSTONE_BRICK_STAIRS);
	public static final Item DRIPSTONE_BRICK_SLAB = register(JinericBlocks.DRIPSTONE_BRICK_SLAB);
	public static final Item DRIPSTONE_BRICK_WALL = register(JinericBlocks.DRIPSTONE_BRICK_WALL);
	public static final Item CRACKED_DRIPSTONE_BRICKS = register(JinericBlocks.CRACKED_DRIPSTONE_BRICKS);
	public static final Item CRACKED_DRIPSTONE_BRICK_STAIRS = register(JinericBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS);
	public static final Item CRACKED_DRIPSTONE_BRICK_SLAB = register(JinericBlocks.CRACKED_DRIPSTONE_BRICK_SLAB);
	public static final Item CRACKED_DRIPSTONE_BRICK_WALL = register(JinericBlocks.CRACKED_DRIPSTONE_BRICK_WALL);
	public static final Item POLISHED_DRIPSTONE = register(JinericBlocks.POLISHED_DRIPSTONE);
	public static final Item POLISHED_DRIPSTONE_STAIRS = register(JinericBlocks.POLISHED_DRIPSTONE_STAIRS);
	public static final Item POLISHED_DRIPSTONE_SLAB = register(JinericBlocks.POLISHED_DRIPSTONE_SLAB);
	public static final Item POLISHED_DRIPSTONE_WALL = register(JinericBlocks.POLISHED_DRIPSTONE_WALL);
	public static final Item DRIPSTONE_TILES = register(JinericBlocks.DRIPSTONE_TILES);
	public static final Item DRIPSTONE_TILE_SLAB = register(JinericBlocks.DRIPSTONE_TILE_SLAB);
	public static final Item DRIPSTONE_TILE_STAIRS = register(JinericBlocks.DRIPSTONE_TILE_STAIRS);
	public static final Item DRIPSTONE_TILE_WALL = register(JinericBlocks.DRIPSTONE_TILE_WALL);
	public static final Item CRACKED_DRIPSTONE_TILES = register(JinericBlocks.CRACKED_DRIPSTONE_TILES);
	public static final Item CRACKED_DRIPSTONE_TILE_SLAB = register(JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB);
	public static final Item CRACKED_DRIPSTONE_TILE_STAIRS = register(JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS);
	public static final Item CRACKED_DRIPSTONE_TILE_WALL = register(JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL);
	public static final Item SMOOTH_DRIPSTONE = register(JinericBlocks.SMOOTH_DRIPSTONE);
	public static final Item SMOOTH_DRIPSTONE_STAIRS = register(JinericBlocks.SMOOTH_DRIPSTONE_STAIRS);
	public static final Item SMOOTH_DRIPSTONE_SLAB = register(JinericBlocks.SMOOTH_DRIPSTONE_SLAB);
	public static final Item SMOOTH_DRIPSTONE_WALL = register(JinericBlocks.SMOOTH_DRIPSTONE_WALL);
	public static final Item CHISELED_DRIPSTONE_BRICKS = register(JinericBlocks.CHISELED_DRIPSTONE_BRICKS);
	public static final Item DRIPSTONE_BRICK_PILLAR = register(JinericBlocks.DRIPSTONE_BRICK_PILLAR);
	
	//TUFF
	public static final Item SMOOTH_TUFF = register(JinericBlocks.SMOOTH_TUFF);
	public static final Item SMOOTH_TUFF_STAIRS = register(JinericBlocks.SMOOTH_TUFF_STAIRS);
	public static final Item SMOOTH_TUFF_SLAB = register(JinericBlocks.SMOOTH_TUFF_SLAB);
	public static final Item SMOOTH_TUFF_WALL = register(JinericBlocks.SMOOTH_TUFF_WALL);
	public static final Item CRACKED_TUFF_BRICKS = register(JinericBlocks.CRACKED_TUFF_BRICKS);
	public static final Item CRACKED_TUFF_BRICK_STAIRS = register(JinericBlocks.CRACKED_TUFF_BRICK_STAIRS);
	public static final Item CRACKED_TUFF_BRICK_SLAB = register(JinericBlocks.CRACKED_TUFF_BRICK_SLAB);
	public static final Item CRACKED_TUFF_BRICK_WALL = register(JinericBlocks.CRACKED_TUFF_BRICK_WALL);
	public static final Item TUFF_BRICK_PILLAR = register(JinericBlocks.TUFF_BRICK_PILLAR);
	public static final Item TUFF_TILES = register(JinericBlocks.TUFF_TILES);
	public static final Item TUFF_TILE_SLAB = register(JinericBlocks.TUFF_TILE_SLAB);
	public static final Item TUFF_TILE_STAIRS = register(JinericBlocks.TUFF_TILE_STAIRS);
	public static final Item TUFF_TILE_WALL = register(JinericBlocks.TUFF_TILE_WALL);
	public static final Item CRACKED_TUFF_TILES = register(JinericBlocks.CRACKED_TUFF_TILES);
	public static final Item CRACKED_TUFF_TILE_SLAB = register(JinericBlocks.CRACKED_TUFF_TILE_SLAB);
	public static final Item CRACKED_TUFF_TILE_STAIRS = register(JinericBlocks.CRACKED_TUFF_TILE_STAIRS);
	public static final Item CRACKED_TUFF_TILE_WALL = register(JinericBlocks.CRACKED_TUFF_TILE_WALL);
	
	//SANDSTONE
	public static final Item SMOOTH_SANDSTONE_WALL = register(JinericBlocks.SMOOTH_SANDSTONE_WALL);
	public static final Item CUT_SANDSTONE_STAIRS = register(JinericBlocks.CUT_SANDSTONE_STAIRS);
	public static final Item CUT_SANDSTONE_WALL = register(JinericBlocks.CUT_SANDSTONE_WALL);
	public static final Item POLISHED_SANDSTONE = register(JinericBlocks.POLISHED_SANDSTONE);
	public static final Item POLISHED_SANDSTONE_SLAB = register(JinericBlocks.POLISHED_SANDSTONE_SLAB);
	public static final Item POLISHED_SANDSTONE_STAIRS = register(JinericBlocks.POLISHED_SANDSTONE_STAIRS);
	public static final Item POLISHED_SANDSTONE_WALL = register(JinericBlocks.POLISHED_SANDSTONE_WALL);
	public static final Item WAVY_SANDSTONE = register(JinericBlocks.WAVY_SANDSTONE);
	public static final Item WAVY_SANDSTONE_SLAB = register(JinericBlocks.WAVY_SANDSTONE_SLAB);
	public static final Item WAVY_SANDSTONE_STAIRS = register(JinericBlocks.WAVY_SANDSTONE_STAIRS);
	public static final Item WAVY_SANDSTONE_WALL = register(JinericBlocks.WAVY_SANDSTONE_WALL);
	
	//RED SANDSTONE
	public static final Item SMOOTH_RED_SANDSTONE_WALL = register(JinericBlocks.SMOOTH_RED_SANDSTONE_WALL);
	public static final Item CUT_RED_SANDSTONE_STAIRS = register(JinericBlocks.CUT_RED_SANDSTONE_STAIRS);
	public static final Item CUT_RED_SANDSTONE_WALL = register(JinericBlocks.CUT_RED_SANDSTONE_WALL);
	public static final Item POLISHED_RED_SANDSTONE = register(JinericBlocks.POLISHED_RED_SANDSTONE);
	public static final Item POLISHED_RED_SANDSTONE_STAIRS = register(JinericBlocks.POLISHED_RED_SANDSTONE_STAIRS);
	public static final Item POLISHED_RED_SANDSTONE_SLAB = register(JinericBlocks.POLISHED_RED_SANDSTONE_SLAB);
	public static final Item POLISHED_RED_SANDSTONE_WALL = register(JinericBlocks.POLISHED_RED_SANDSTONE_WALL);
	public static final Item WAVY_RED_SANDSTONE = register(JinericBlocks.WAVY_RED_SANDSTONE);
	public static final Item WAVY_RED_SANDSTONE_STAIRS = register(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS);
	public static final Item WAVY_RED_SANDSTONE_SLAB = register(JinericBlocks.WAVY_RED_SANDSTONE_SLAB);
	public static final Item WAVY_RED_SANDSTONE_WALL = register(JinericBlocks.WAVY_RED_SANDSTONE_WALL);
	
	//SOUL SANDSTONE
	public static final Item SOUL_SANDSTONE = register(JinericBlocks.SOUL_SANDSTONE);
	public static final Item SOUL_SANDSTONE_SLAB = register(JinericBlocks.SOUL_SANDSTONE_SLAB);
	public static final Item SOUL_SANDSTONE_STAIRS = register(JinericBlocks.SOUL_SANDSTONE_STAIRS);
	public static final Item SOUL_SANDSTONE_WALL = register(JinericBlocks.SOUL_SANDSTONE_WALL);
	public static final Item CUT_SOUL_SANDSTONE = register(JinericBlocks.CUT_SOUL_SANDSTONE);
	public static final Item CUT_SOUL_SANDSTONE_SLAB = register(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB);
	public static final Item CUT_SOUL_SANDSTONE_STAIRS = register(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS);
	public static final Item CUT_SOUL_SANDSTONE_WALL = register(JinericBlocks.CUT_SOUL_SANDSTONE_WALL);
	public static final Item POLISHED_SOUL_SANDSTONE = register(JinericBlocks.POLISHED_SOUL_SANDSTONE);
	public static final Item POLISHED_SOUL_SANDSTONE_SLAB = register(JinericBlocks.POLISHED_SOUL_SANDSTONE_SLAB);
	public static final Item POLISHED_SOUL_SANDSTONE_STAIRS = register(JinericBlocks.POLISHED_SOUL_SANDSTONE_STAIRS);
	public static final Item POLISHED_SOUL_SANDSTONE_WALL = register(JinericBlocks.POLISHED_SOUL_SANDSTONE_WALL);
	public static final Item CHISELED_SOUL_SANDSTONE = register(JinericBlocks.CHISELED_SOUL_SANDSTONE);
	public static final Item SMOOTH_SOUL_SANDSTONE = register(JinericBlocks.SMOOTH_SOUL_SANDSTONE);
	public static final Item SMOOTH_SOUL_SANDSTONE_SLAB = register(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB);
	public static final Item SMOOTH_SOUL_SANDSTONE_STAIRS = register(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS);
	public static final Item SMOOTH_SOUL_SANDSTONE_WALL = register(JinericBlocks.SMOOTH_SOUL_SANDSTONE_WALL);
	public static final Item WAVY_SOUL_SANDSTONE = register(JinericBlocks.WAVY_SOUL_SANDSTONE);
	public static final Item WAVY_SOUL_SANDSTONE_SLAB = register(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB);
	public static final Item WAVY_SOUL_SANDSTONE_STAIRS = register(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS);
	public static final Item WAVY_SOUL_SANDSTONE_WALL = register(JinericBlocks.WAVY_SOUL_SANDSTONE_WALL);
	
	//MISC VANILLA
	//OVERWORLD
	public static final Item STONE_WALL = register(JinericBlocks.STONE_WALL);
	public static final Item CRACKED_STONE_BRICK_STAIRS = register(JinericBlocks.CRACKED_STONE_BRICK_STAIRS);
	public static final Item CRACKED_STONE_BRICK_SLAB = register(JinericBlocks.CRACKED_STONE_BRICK_SLAB);
	public static final Item CRACKED_STONE_BRICK_WALL = register(JinericBlocks.CRACKED_STONE_BRICK_WALL);
	public static final Item STONE_TILES = register(JinericBlocks.STONE_TILES);
	public static final Item STONE_TILE_STAIRS = register(JinericBlocks.STONE_TILE_STAIRS);
	public static final Item STONE_TILE_SLAB = register(JinericBlocks.STONE_TILE_SLAB);
	public static final Item STONE_TILE_WALL = register(JinericBlocks.STONE_TILE_WALL);
	public static final Item CRACKED_STONE_TILES = register(JinericBlocks.CRACKED_STONE_TILES);
	public static final Item CRACKED_STONE_TILE_STAIRS = register(JinericBlocks.CRACKED_STONE_TILE_STAIRS);
	public static final Item CRACKED_STONE_TILE_SLAB = register(JinericBlocks.CRACKED_STONE_TILE_SLAB);
	public static final Item CRACKED_STONE_TILE_WALL = register(JinericBlocks.CRACKED_STONE_TILE_WALL);
	public static final Item STONE_BRICK_PILLAR = register(JinericBlocks.STONE_BRICK_PILLAR);
	public static final Item CRACKED_DEEPSLATE_BRICK_STAIRS = register(JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS);
	public static final Item CRACKED_DEEPSLATE_BRICK_SLAB = register(JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB);
	public static final Item CRACKED_DEEPSLATE_BRICK_WALL = register(JinericBlocks.CRACKED_DEEPSLATE_BRICK_WALL);
	public static final Item CRACKED_DEEPSLATE_TILE_STAIRS = register(JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS);
	public static final Item CRACKED_DEEPSLATE_TILE_SLAB = register(JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB);
	public static final Item CRACKED_DEEPSLATE_TILE_WALL = register(JinericBlocks.CRACKED_DEEPSLATE_TILE_WALL);
	public static final Item SMOOTH_STONE_STAIRS = register(JinericBlocks.SMOOTH_STONE_STAIRS);
	public static final Item SMOOTH_STONE_WALL = register(JinericBlocks.SMOOTH_STONE_WALL);
	public static final Item SMOOTH_DEEPSLATE = register(JinericBlocks.SMOOTH_DEEPSLATE);
	public static final Item SMOOTH_DEEPSLATE_STAIRS = register(JinericBlocks.SMOOTH_DEEPSLATE_STAIRS);
	public static final Item SMOOTH_DEEPSLATE_SLAB = register(JinericBlocks.SMOOTH_DEEPSLATE_SLAB);
	public static final Item SMOOTH_DEEPSLATE_WALL = register(JinericBlocks.SMOOTH_DEEPSLATE_WALL);
	public static final Item DARK_PRISMARINE_WALL = register(JinericBlocks.DARK_PRISMARINE_WALL);
	public static final Item PRISMARINE_BRICK_WALL = register(JinericBlocks.PRISMARINE_BRICK_WALL);
	public static final Item POLISHED_GRANITE_WALL = register(JinericBlocks.POLISHED_GRANITE_WALL);
	public static final Item POLISHED_DIORITE_WALL = register(JinericBlocks.POLISHED_DIORITE_WALL);
	public static final Item POLISHED_ANDESITE_WALL = register(JinericBlocks.POLISHED_ANDESITE_WALL);
	public static final Item CALCITE_STAIRS = register(JinericBlocks.CALCITE_STAIRS);
	public static final Item CALCITE_SLAB = register(JinericBlocks.CALCITE_SLAB);
	public static final Item CALCITE_WALL = register(JinericBlocks.CALCITE_WALL);
	public static final Item SNOW_BRICKS = register(JinericBlocks.SNOW_BRICKS);
	public static final Item SNOW_BRICK_STAIRS = register(JinericBlocks.SNOW_BRICK_STAIRS);
	public static final Item SNOW_BRICK_SLAB = register(JinericBlocks.SNOW_BRICK_SLAB);
	public static final Item SNOW_BRICK_WALL = register(JinericBlocks.SNOW_BRICK_WALL);
	public static final Item SNOW_WALL = register(JinericBlocks.SNOW_WALL);
	public static final Item PACKED_ICE_STAIRS = register(JinericBlocks.PACKED_ICE_STAIRS);
	public static final Item PACKED_ICE_SLAB = register(JinericBlocks.PACKED_ICE_SLAB);
	public static final Item PACKED_ICE_WALL = register(JinericBlocks.PACKED_ICE_WALL);
	public static final Item OBSIDIAN_STAIRS = register(JinericBlocks.OBSIDIAN_STAIRS);
	public static final Item OBSIDIAN_SLAB = register(JinericBlocks.OBSIDIAN_SLAB);
	public static final Item OBSIDIAN_WALL = register(JinericBlocks.OBSIDIAN_WALL);
	public static final Item FULL_GRASS_BLOCK = register(JinericBlocks.GRASS_BLOCK);
	//NETHER
	public static final Item QUARTZ_WALL = register(JinericBlocks.QUARTZ_WALL);
	public static final Item SMOOTH_QUARTZ_WALL = register(JinericBlocks.SMOOTH_QUARTZ_WALL);
	public static final Item QUARTZ_BRICK_STAIRS = register(JinericBlocks.QUARTZ_BRICK_STAIRS);
	public static final Item QUARTZ_BRICK_SLAB = register(JinericBlocks.QUARTZ_BRICK_SLAB);
	public static final Item QUARTZ_BRICK_WALL = register(JinericBlocks.QUARTZ_BRICK_WALL);
	public static final Item CRACKED_NETHER_BRICK_STAIRS = register(JinericBlocks.CRACKED_NETHER_BRICK_STAIRS);
	public static final Item CRACKED_NETHER_BRICK_SLAB = register(JinericBlocks.CRACKED_NETHER_BRICK_SLAB);
	public static final Item CRACKED_NETHER_BRICK_WALL = register(JinericBlocks.CRACKED_NETHER_BRICK_WALL);
	public static final Item RED_NETHER_BRICK_FENCE = register(JinericBlocks.RED_NETHER_BRICK_FENCE);
	public static final Item CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = register(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);
	public static final Item CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = register(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);
	public static final Item CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = register(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);
	public static final Item SMOOTH_BASALT_STAIRS = register(JinericBlocks.SMOOTH_BASALT_STAIRS);
	public static final Item SMOOTH_BASALT_SLAB = register(JinericBlocks.SMOOTH_BASALT_SLAB);
	public static final Item SMOOTH_BASALT_WALL = register(JinericBlocks.SMOOTH_BASALT_WALL);
	//END
	public static final Item PURPUR_WALL = register(JinericBlocks.PURPUR_WALL);
	
	//COPPER
	//CUT
	public static final Item CUT_COPPER_WALL = register(JinericBlocks.CUT_COPPER_WALL);
	public static final Item EXPOSED_CUT_COPPER_WALL = register(JinericBlocks.EXPOSED_CUT_COPPER_WALL);
	public static final Item WEATHERED_CUT_COPPER_WALL = register(JinericBlocks.WEATHERED_CUT_COPPER_WALL);
	public static final Item OXIDIZED_CUT_COPPER_WALL = register(JinericBlocks.OXIDIZED_CUT_COPPER_WALL);
	public static final Item WAXED_CUT_COPPER_WALL = register(JinericBlocks.WAXED_CUT_COPPER_WALL);
	public static final Item WAXED_EXPOSED_CUT_COPPER_WALL = register(JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL);
	public static final Item WAXED_WEATHERED_CUT_COPPER_WALL = register(JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL);
	public static final Item WAXED_OXIDIZED_CUT_COPPER_WALL = register(JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL);
	//ITEM STORAGE
	public static final Item CHARCOAL_BLOCK = register(JinericBlocks.CHARCOAL_BLOCK);
	public static final Item FLINT_BLOCK = register(JinericBlocks.FLINT_BLOCK);
	public static final Item BONE_MEAL_BLOCK = register(JinericBlocks.BONE_MEAL_BLOCK);
	public static final Item PRISMARINE_CRYSTAL_BLOCK = register(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
	public static final Item SUGAR_BLOCK = register(JinericBlocks.SUGAR_BLOCK);
	public static final Item ROTTEN_FLESH_BLOCK = register(JinericBlocks.ROTTEN_FLESH_BLOCK);
	public static final Item STICK_BLOCK = register(JinericBlocks.STICK_BLOCK);
	public static final Item EGG_BLOCK = register(JinericBlocks.EGG_BLOCK);
	public static final Item ENDER_PEARL_BLOCK = register(JinericBlocks.ENDER_PEARL_BLOCK);
	public static final Item PAPER_BLOCK = register(JinericBlocks.PAPER_BLOCK);
	public static final Item BLAZE_ROD_BLOCK = register(JinericBlocks.BLAZE_ROD_BLOCK);
	//BOOKSHELVES
	public static final Item SPRUCE_BOOKSHELF = register(JinericBlocks.SPRUCE_BOOKSHELF);
	public static final Item BIRCH_BOOKSHELF = register(JinericBlocks.BIRCH_BOOKSHELF);
	public static final Item JUNGLE_BOOKSHELF = register(JinericBlocks.JUNGLE_BOOKSHELF);
	public static final Item ACACIA_BOOKSHELF = register(JinericBlocks.ACACIA_BOOKSHELF);
	public static final Item DARK_OAK_BOOKSHELF = register(JinericBlocks.DARK_OAK_BOOKSHELF);
	public static final Item MANGROVE_BOOKSHELF = register(JinericBlocks.MANGROVE_BOOKSHELF);
	public static final Item CHERRY_BOOKSHELF = register(JinericBlocks.CHERRY_BOOKSHELF);
	public static final Item BAMBOO_BOOKSHELF = register(JinericBlocks.BAMBOO_BOOKSHELF);
	public static final Item CRIMSON_BOOKSHELF = register(JinericBlocks.CRIMSON_BOOKSHELF);
	public static final Item WARPED_BOOKSHELF = register(JinericBlocks.WARPED_BOOKSHELF);
	//CHESTS
	public static final Item BIRCH_CHEST = register(JinericBlocks.BIRCH_CHEST);
	public static final Item SPRUCE_CHEST = register(JinericBlocks.SPRUCE_CHEST);
	public static final Item JUNGLE_CHEST = register(JinericBlocks.JUNGLE_CHEST);
	public static final Item ACACIA_CHEST = register(JinericBlocks.ACACIA_CHEST);
	public static final Item DARK_OAK_CHEST = register(JinericBlocks.DARK_OAK_CHEST);
	public static final Item MANGROVE_CHEST = register(JinericBlocks.MANGROVE_CHEST);
	public static final Item CHERRY_CHEST = register(JinericBlocks.CHERRY_CHEST);
	public static final Item BAMBOO_CHEST = register(JinericBlocks.BAMBOO_CHEST);
	public static final Item CRIMSON_CHEST = register(JinericBlocks.CRIMSON_CHEST);
	public static final Item WARPED_CHEST = register(JinericBlocks.WARPED_CHEST);
	public static final Item TRAPPED_SPRUCE_CHEST = register(JinericBlocks.TRAPPED_SPRUCE_CHEST);
	public static final Item TRAPPED_BIRCH_CHEST = register(JinericBlocks.TRAPPED_BIRCH_CHEST);
	public static final Item TRAPPED_JUNGLE_CHEST = register(JinericBlocks.TRAPPED_JUNGLE_CHEST);
	public static final Item TRAPPED_ACACIA_CHEST = register(JinericBlocks.TRAPPED_ACACIA_CHEST);
	public static final Item TRAPPED_DARK_OAK_CHEST = register(JinericBlocks.TRAPPED_DARK_OAK_CHEST);
	public static final Item TRAPPED_MANGROVE_CHEST = register(JinericBlocks.TRAPPED_MANGROVE_CHEST);
	public static final Item TRAPPED_CHERRY_CHEST = register(JinericBlocks.TRAPPED_CHERRY_CHEST);
	public static final Item TRAPPED_BAMBOO_CHEST = register(JinericBlocks.TRAPPED_BAMBOO_CHEST);
	public static final Item TRAPPED_CRIMSON_CHEST = register(JinericBlocks.TRAPPED_CRIMSON_CHEST);
	public static final Item TRAPPED_WARPED_CHEST = register(JinericBlocks.TRAPPED_WARPED_CHEST);
	//LADDERS
	public static final Item SPRUCE_LADDER = register(JinericBlocks.SPRUCE_LADDER);
	public static final Item BIRCH_LADDER = register(JinericBlocks.BIRCH_LADDER);
	public static final Item JUNGLE_LADDER = register(JinericBlocks.JUNGLE_LADDER);
	public static final Item ACACIA_LADDER = register(JinericBlocks.ACACIA_LADDER);
	public static final Item DARK_OAK_LADDER = register(JinericBlocks.DARK_OAK_LADDER);
	public static final Item MANGROVE_LADDER = register(JinericBlocks.MANGROVE_LADDER);
	public static final Item CHERRY_LADDER = register(JinericBlocks.CHERRY_LADDER);
	public static final Item BAMBOO_LADDER = register(JinericBlocks.BAMBOO_LADDER);
	public static final Item WARPED_LADDER = register(JinericBlocks.WARPED_LADDER);
	public static final Item CRIMSON_LADDER = register(JinericBlocks.CRIMSON_LADDER);
	//REDSTONE
	public static final Item REDSTONE_LANTERN = register(JinericBlocks.REDSTONE_LANTERN);
	//FOOD
	public static final Item GOLDEN_POTATO = register("golden_potato", new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.6f).build()));
	public static final Item GOLDEN_SWEET_BERRIES = register("golden_sweet_berries", new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.2f).build()));
	public static final Item GOLDEN_BEETROOT = register("golden_beetroot", new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(1.2f).build()));
	//MISC JINERIC
	public static final Item SOUL_JACK_O_LANTERN = register(JinericBlocks.SOUL_JACK_O_LANTERN);
	public static final Item NETHERITE_HORSE_ARMOR = register("netherite_horse_armor", new Item.Properties().horseArmor(ArmorMaterials.NETHERITE));
	public static final Item BOW_DRILL = register("bow_drill", BowDrillItem::new, new Item.Settings().maxCount(1));
	public static final Item TINDER = register(JinericBlocks.TINDER);
	public static final Item CLAY_BRICK = register("clay_brick");
	
	//EQUIPMENT
	//WOODEN
	public static final Item WOODEN_HELMET = register("wooden_helmet",
			new Item.Settings()
					.armor(JmArmorMaterials.WOODEN, EquipmentType.HELMET)
					.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.HEAD).model(JmEquipmentAssetKeys.WOOD).build())
	);
	public static final Item WOODEN_CHESTPLATE = register("wooden_chestplate",
			new Item.Settings()
					.armor(JmArmorMaterials.WOODEN, EquipmentType.CHESTPLATE)
					.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.CHEST).model(JmEquipmentAssetKeys.WOOD).build())
	);
	public static final Item WOODEN_LEGGINGS = register("wooden_leggings",
			new Item.Settings()
					.armor(JmArmorMaterials.WOODEN, EquipmentType.LEGGINGS)
					.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.LEGS).model(JmEquipmentAssetKeys.WOOD).build())
	);
	public static final Item WOODEN_BOOTS = register("wooden_boots",
			new Item.Settings()
					.armor(JmArmorMaterials.WOODEN, EquipmentType.BOOTS)
					.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.FEET).model(JmEquipmentAssetKeys.EMERALD).build())
	);
	//EMERALD
	public static final Item EMERALD_HELMET = register("emerald_helmet",
			new Item.Settings()
					.armor(JmArmorMaterials.EMERALD, EquipmentType.HELMET)
					.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.HEAD).model(JmEquipmentAssetKeys.EMERALD).build())
	);
	public static final Item EMERALD_CHESTPLATE = register("emerald_chestplate",
			new Item.Settings()
					.armor(JmArmorMaterials.EMERALD, EquipmentType.CHESTPLATE)
					.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.CHEST).model(JmEquipmentAssetKeys.EMERALD).build())
	);
	public static final Item EMERALD_LEGGINGS = register("emerald_leggings",
			new Item.Settings()
					.armor(JmArmorMaterials.EMERALD, EquipmentType.LEGGINGS)
					.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.LEGS).model(JmEquipmentAssetKeys.EMERALD).build())
	);
	public static final Item EMERALD_BOOTS = register("emerald_boots",
			new Item.Settings()
					.armor(JmArmorMaterials.EMERALD, EquipmentType.BOOTS)
					.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.FEET).model(JmEquipmentAssetKeys.EMERALD).build())
	);
	public static final Item EMERALD_SWORD = register("emerald_sword", new Item.Settings().sword(JmToolMaterials.EMERALD, 3.0F, -2.4F));
	public static final Item EMERALD_SHOVEL = register("emerald_shovel", settings -> new ShovelItem(JmToolMaterials.EMERALD, 1.5F, -3.0F, settings));
	public static final Item EMERALD_PICKAXE = register("emerald_pickaxe", new Item.Settings().pickaxe(JmToolMaterials.EMERALD, 1.0F, -2.8F));
	public static final Item EMERALD_AXE = register("emerald_axe", settings -> new AxeItem(JmToolMaterials.EMERALD, 5.0F, -3.0F, settings));
	public static final Item EMERALD_HOE = register("emerald_hoe", settings -> new HoeItem(JmToolMaterials.EMERALD, -3.0F, 0.0F, settings));
	
	public static final Item FLINT_PICKAXE = register("flint_pickaxe", new Item.Settings().pickaxe(JmToolMaterials.FLINT, 1.0F, -2.8F));
	public static final Item DEEPSLATE_PICKAXE = register("deepslate_pickaxe", new Item.Settings().pickaxe(JmToolMaterials.DEEPSLATE, 1.0F, -2.8F));
	public static final Item AMETHYST_PICKAXE = register("amethyst_pickaxe", new Item.Settings().pickaxe(JmToolMaterials.AMETHYST, 1.0F, -2.8F));
	
	//TEMPLATES
	public static final Item STONE_UPGRADE_SMITHING_TEMPLATE = register("stone_upgrade_smithing_template",
			JmSmithingTemplateItem::createStoneUpgrade,
			JmConfig.UPGRADE_TEMPLATE ? new Item.Settings().jineric$maxLevel(2) : new Item.Settings()
	);
	public static final Item COPPER_UPGRADE_SMITHING_TEMPLATE = register("copper_upgrade_smithing_template",
			JmSmithingTemplateItem::createCopperUpgrade,
			JmConfig.UPGRADE_TEMPLATE ? new Item.Settings().jineric$maxLevel(4) : new Item.Settings()
	);
	public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = register("iron_upgrade_smithing_template",
			JmSmithingTemplateItem::createIronUpgrade,
			JmConfig.UPGRADE_TEMPLATE ? new Item.Settings().jineric$maxLevel(8) : new Item.Settings()
	);
	public static final Item GOLD_UPGRADE_SMITHING_TEMPLATE = register("gold_upgrade_smithing_template",
			JmSmithingTemplateItem::createGoldUpgrade,
			JmConfig.UPGRADE_TEMPLATE ? new Item.Settings().jineric$maxLevel(16) : new Item.Settings()
	);
	public static final Item DIAMOND_UPGRADE_SMITHING_TEMPLATE = register("diamond_upgrade_smithing_template",
			JmSmithingTemplateItem::createDiamondUpgrade,
			JmConfig.UPGRADE_TEMPLATE ? new Item.Settings().jineric$maxLevel(32) : new Item.Settings()
	);
	
	//WIP OR UNKNOWN ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//	public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = register(
//			"iron_upgrade_smithing_template", JinericSmithingTemplateItem::createIronUpgrade, new Item.Properties().rarity(Rarity.COMMON)
//	);
	public static final Item REFINERY = register(JinericBlocks.REFINERY);
	public static final Item FOUNDRY = register(JinericBlocks.FOUNDRY);
	public static final Item REDSTONE_CAMPFIRE = register(JinericBlocks.REDSTONE_CAMPFIRE);
	public static final Item STONE_CRUCIBLE = register(JinericBlocks.STONE_CRUCIBLE);
	
	private static ResourceKey<Item> keyOf(String id) {
		return ResourceKey.create(Registries.ITEM, JinericMain.ofJineric(id));
	}
	
	private static ResourceKey<Item> keyOf(ResourceKey<Block> blockKey) {
		return ResourceKey.create(Registries.ITEM, blockKey.identifier());
	}
	
	private static Item register(Block block) {
		return register(block, BlockItem::new);
	}
	
	private static Item register(Block block, Item.Properties settings) {
		return register(block, BlockItem::new, settings);
	}
	
	private static Item register(Block block, UnaryOperator<Item.Properties> settingsOperator) {
		return register(block, (blockx, settings) -> new BlockItem(blockx, settingsOperator.apply(settings)));
	}
	
	private static Item register(Block block, Block... blocks) {
		Item item = register(block);
		
		for (Block block2 : blocks) {
			Item.BY_BLOCK.put(block2, item);
		}
		
		return item;
	}
	
	private static Item register(Block block, BiFunction<Block, Item.Properties, Item> factory) {
		return register(block, factory, new Item.Properties());
	}
	
	private static Item register(Block block, BiFunction<Block, Item.Properties, Item> factory, Item.Properties settings) {
		return register(
				keyOf(block.builtInRegistryHolder().key()), itemSettings -> factory.apply(block, itemSettings), settings.useBlockDescriptionPrefix()
		);
	}
	
	private static Item register(String id, Function<Item.Properties, Item> factory) {
		return register(keyOf(id), factory, new Item.Properties());
	}
	
	private static Item register(String id, Function<Item.Properties, Item> factory, Item.Properties settings) {
		return register(keyOf(id), factory, settings);
	}
	
	private static Item register(String id, Item.Properties settings) {
		return register(keyOf(id), Item::new, settings);
	}
	
	private static Item register(String id) {
		return register(keyOf(id), Item::new, new Item.Properties());
	}
	
	private static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory) {
		return register(key, factory, new Item.Properties());
	}
	
	private static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties settings) {
		Item item = factory.apply(settings.setId(key));
		if (item instanceof BlockItem blockItem) {
			blockItem.registerBlocks(Item.BY_BLOCK, item);
		}
		
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}
	
	public static void initialize() {
	}
}

