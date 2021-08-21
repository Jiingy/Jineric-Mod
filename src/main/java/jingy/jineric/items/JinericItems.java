package jingy.jineric.items;

import jingy.jineric.blocks.JinericBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


@SuppressWarnings("unused")
public class JinericItems {

/*
	templates:
	block item: public static final Item [NAME] = register("name", new BlockItem(Blocks.[NAME], ItemGroups.[ITEM_GROUP]()));
*/

// ITEMS:

	// GOLDEN FOODS
	public static final Item GOLDEN_POTATO = register("golden_potato", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build()).group(JinericItemGroups.JINERIC_BREWING)));
	public static final Item GOLDEN_SWEET_BERRIES = register("golden_sweet_berries", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(5).saturationModifier(8f).build()).group(JinericItemGroups.JINERIC_BREWING)));
	public static final Item GOLDEN_BEETROOT = register("golden_beetroot", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(4).saturationModifier(5f).build()).group(JinericItemGroups.JINERIC_BREWING)));

	// OTHER ITEMS
	public static final Item SALT = register("salt", new Item(JinericItemSettings.Misc().group(JinericItemGroups.JINERIC_MISCELLANEOUS)));
	public static final Item WARPED_NETHER_WART = register("warped_nether_wart", new Item(JinericItemSettings.Misc().group(JinericItemGroups.JINERIC_BREWING)));

// BLOCKS:

	// SAND
	// CUT SANDSTONE
	public static final Item CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new BlockItem(JinericBlocks.CUT_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// POLISHED SANDSTONE
	public static final Item POLISHED_SANDSTONE = register("polished_sandstone", new BlockItem(JinericBlocks.POLISHED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SANDSTONE_SLAB = register("polished_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SANDSTONE_STAIRS = register("polished_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SANDSTONE_WALL = register("polished_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// CHISELED SANDSTONE
	public static final Item CHISELED_SANDSTONE_SLAB = register("chiseled_sandstone_slab", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CHISELED_SANDSTONE_STAIRS = register("chiseled_sandstone_stairs", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CHISELED_SANDSTONE_WALL = register("chiseled_sandstone_wall", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// WAVY SANDSTONE
	public static final Item WAVY_SANDSTONE = register("wavy_sandstone", new BlockItem(JinericBlocks.WAVY_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_SANDSTONE_SLAB = register("wavy_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// SMOOTH SANDSTONE
	public static final Item SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

	// RED SAND
	// CUT RED SANDSTONE
	public static final Item CUT_RED_SANDSTONE_STAIRS = register("cut_red_sandstone_stairs", new BlockItem(JinericBlocks.CUT_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CUT_RED_SANDSTONE_WALL = register("cut_red_sandstone_wall", new BlockItem(JinericBlocks.CUT_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	// POLISHED RED SANDSTONE
	public static final Item POLISHED_RED_SANDSTONE = register("polished_red_sandstone", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_RED_SANDSTONE_SLAB = register("polished_red_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_RED_SANDSTONE_STAIRS = register("polished_red_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_RED_SANDSTONE_WALL = register("polished_red_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// WAVY RED SANDSTONE
	public static final Item WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_RED_SANDSTONE_SLAB = register("wavy_red_sandstone_slab", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// CHISELED RED SANDSTONE
	public static final Item CHISELED_RED_SANDSTONE_SLAB = register("chiseled_red_sandstone_slab", new BlockItem(JinericBlocks.CHISELED_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CHISELED_RED_SANDSTONE_STAIRS = register("chiseled_red_sandstone_stairs", new BlockItem(JinericBlocks.CHISELED_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CHISELED_RED_SANDSTONE_WALL = register("chiseled_red_sandstone_wall", new BlockItem(JinericBlocks.CHISELED_RED_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// SMOOTH RED SANDSTONE
	public static final Item SMOOTH_RED_SANDSTONE_WALL = register("smooth_red_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));

	// SOUL SAND
	// SOUL SOUL SANDSTONE
	public static final Item SOUL_SANDSTONE = register("soul_sandstone", new BlockItem(JinericBlocks.SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SOUL_SANDSTONE_SLAB = register("soul_sandstone_slab", new BlockItem(JinericBlocks.SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BlockItem(JinericBlocks.SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new BlockItem(JinericBlocks.SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// CUT SOUL SANDSTONE
	public static final Item CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CUT_SOUL_SANDSTONE_SLAB = register("cut_soul_sandstone_slab", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// POLISHED SOUL SANDSTONE
	public static final Item POLISHED_SOUL_SANDSTONE = register("polished_soul_sandstone", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SOUL_SANDSTONE_SLAB = register("polished_soul_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SOUL_SANDSTONE_STAIRS = register("polished_soul_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SOUL_SANDSTONE_WALL = register("polished_soul_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// CHISELED SOUL SANDSTONE
	public static final Item CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CHISELED_SOUL_SANDSTONE_SLAB = register("chiseled_soul_sandstone_slab", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CHISELED_SOUL_SANDSTONE_STAIRS = register("chiseled_soul_sandstone_stairs", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CHISELED_SOUL_SANDSTONE_WALL = register("chiseled_soul_sandstone_wall", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// SMOOTH SOUL SANDSTONE
	public static final Item SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SMOOTH_SOUL_SANDSTONE_SLAB = register("smooth_soul_sandstone_slab", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// WAVY SOUL SANDSTONE
	public static final Item WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_SOUL_SANDSTONE_SLAB = register("wavy_soul_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

	// STONES
	// STONE & SMOOTH STONE
	public static final Item STONE_WALL = register("stone_wall", new BlockItem(JinericBlocks.STONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", new BlockItem(JinericBlocks.SMOOTH_STONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SMOOTH_STONE_WALL = register("smooth_stone_wall", new BlockItem(JinericBlocks.SMOOTH_STONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// ITES
	public static final Item POLISHED_GRANITE_WALL = register("polished_granite_wall", new BlockItem(JinericBlocks.POLISHED_GRANITE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_DIORITE_WALL = register("polished_diorite_wall", new BlockItem(JinericBlocks.POLISHED_DIORITE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_ANDESITE_WALL = register("polished_andesite_wall", new BlockItem(JinericBlocks.POLISHED_ANDESITE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// OBSIDIAN
	public static final Item OBSIDIAN_SLAB = register("obsidian_slab", new BlockItem(JinericBlocks.OBSIDIAN_SLAB, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item OBSIDIAN_STAIRS = register("obsidian_stairs", new BlockItem(JinericBlocks.OBSIDIAN_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item OBSIDIAN_WALL = register("obsidian_wall", new BlockItem(JinericBlocks.OBSIDIAN_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// CRACKED STONE BRICK
	public static final Item CRACKED_STONE_BRICK_SLAB = register("cracked_stone_brick_slab", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CRACKED_STONE_BRICK_STAIRS = register("cracked_stone_brick_stairs", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CRACKED_STONE_BRICK_WALL = register("cracked_stone_brick_wall", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// BORITE
	public static final Item BORITE = register("borite", new BlockItem(JinericBlocks.BORITE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item BORITE_SLAB = register("borite_slab", new BlockItem(JinericBlocks.BORITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item BORITE_STAIRS = register("borite_stairs", new BlockItem(JinericBlocks.BORITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item BORITE_WALL = register("borite_wall", new BlockItem(JinericBlocks.BORITE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// SILTSTONE
	public static final Item SILTSTONE = register("siltstone", new BlockItem(JinericBlocks.SILTSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SILTSTONE_SLAB = register("siltstone_slab", new BlockItem(JinericBlocks.SILTSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SILTSTONE_STAIRS = register("siltstone_stairs", new BlockItem(JinericBlocks.SILTSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SILTSTONE_WALL = register("siltstone_wall", new BlockItem(JinericBlocks.SILTSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// SILTSTONE
	public static final Item POLISHED_SILTSTONE = register("polished_siltstone", new BlockItem(JinericBlocks.POLISHED_SILTSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SILTSTONE_SLAB = register("polished_siltstone_slab", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SILTSTONE_STAIRS = register("polished_siltstone_stairs", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item POLISHED_SILTSTONE_WALL = register("polished_siltstone_wall", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// SLATE
	public static final Item SLATE = register("slate", new BlockItem(JinericBlocks.SLATE, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SLATE_STAIRS = register("slate_stairs", new BlockItem(JinericBlocks.SLATE_STAIRS, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SLATE_SLAB = register("slate_slab", new BlockItem(JinericBlocks.SLATE_SLAB, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SLATE_WALL = register("slate_wall", new BlockItem(JinericBlocks.SLATE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

	// PRISMARINE
	// PRISMARINE BRICKS
	public static final Item PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", new BlockItem(JinericBlocks.PRISMARINE_BRICK_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// DARK PRISMARINE BRICKS
	public static final Item DARK_PRISMARINE_WALL = register("dark_prismarine_wall", new BlockItem(JinericBlocks.DARK_PRISMARINE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

	// WOOD TYPES
	// BOREAL
	public static final Item BOREAL_PLANKS = register("boreal_planks", new BlockItem(JinericBlocks.BOREAL_PLANKS, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item BOREAL_STAIRS = register("boreal_stairs", new BlockItem(JinericBlocks.BOREAL_STAIRS, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item BOREAL_SLAB = register("boreal_slab", new BlockItem(JinericBlocks.BOREAL_SLAB, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

	// MISCELLANEOUS
	// ICE
	public static final Item PACKED_ICE_STAIRS = register("packed_ice_stairs", new BlockItem(JinericBlocks.PACKED_ICE_STAIRS, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item PACKED_ICE_SLAB = register("packed_ice_slab", new BlockItem(JinericBlocks.PACKED_ICE_SLAB, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item PACKED_ICE_WALL = register("packed_ice_wall", new BlockItem(JinericBlocks.PACKED_ICE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// SNOW & POWDERED SNOW
	public static final Item SNOW_WALL = register("snow_wall", new BlockItem(JinericBlocks.SNOW_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
	// DECORATION
	public static final Item SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new BlockItem(JinericBlocks.SOUL_JACK_O_LANTERN, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item FULL_GRASS_BLOCK = register("full_grass_block", new BlockItem(JinericBlocks.FULL_GRASS_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	// STORAGE
	public static final Item SALT_BLOCK = register("salt_block", new BlockItem(JinericBlocks.SALT_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item SUGAR_BLOCK = register("sugar_block", new BlockItem(JinericBlocks.SUGAR_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new BlockItem(JinericBlocks.ROTTEN_FLESH_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item FLINT_BLOCK = register("flint_block", new BlockItem(JinericBlocks.FLINT_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item CHARCOAL_BLOCK = register("charcoal_block", new BlockItem(JinericBlocks.CHARCOAL_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
	public static final Item BAMBOO_BLOCK = register("bamboo_block", new BlockItem(JinericBlocks.BAMBOO_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));

	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier("jineric", name), item);
	}

	public static void init() {
	}
}

