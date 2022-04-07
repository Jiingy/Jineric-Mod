package jingy.jineric.registry;

import jingy.jineric.item.JinericElytraItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.entity.EquipmentSlot.CHEST;
import static net.minecraft.util.Rarity.RARE;


@SuppressWarnings("unused")
public class JinericItems {

/* TEMPLATES:
	public static final Item NAME = register("name", new Item(JinericItemSettings.ItemGroup().group(JinericItemGroups.ITEM_GROUP)));
	public static final Item NAME = register("name", new BlockItem(JinericBlocks.BLOCK, JinericItemSettings.ItemGroup().group(JinericItemGroups.ITEM_GROUP)));
*/

//BUILDING BLOCKS
	public static final Item SILTSTONE = register("siltstone", new BlockItem(JinericBlocks.SILTSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SILTSTONE_STAIRS = register("siltstone_stairs", new BlockItem(JinericBlocks.SILTSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SILTSTONE_SLAB = register("siltstone_slab", new BlockItem(JinericBlocks.SILTSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SILTSTONE = register("polished_siltstone", new BlockItem(JinericBlocks.POLISHED_SILTSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SILTSTONE_STAIRS = register("polished_siltstone_stairs", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SILTSTONE_SLAB = register("polished_siltstone_slab", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SLATE = register("slate", new BlockItem(JinericBlocks.SLATE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SLATE_STAIRS = register("slate_stairs", new BlockItem(JinericBlocks.SLATE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SLATE_SLAB = register("slate_slab", new BlockItem(JinericBlocks.SLATE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BORITE = register("borite", new BlockItem(JinericBlocks.BORITE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BORITE_STAIRS = register("borite_stairs", new BlockItem(JinericBlocks.BORITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BORITE_SLAB = register("borite_slab", new BlockItem(JinericBlocks.BORITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item FULL_GRASS_BLOCK = register("full_grass_block", new BlockItem(JinericBlocks.FULL_GRASS_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BOREAL_WOOD = register("boreal_wood", new BlockItem(JinericBlocks.BOREAL_WOOD, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BOREAL_LOG = register("boreal_log", new BlockItem(JinericBlocks.BOREAL_LOG, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item STRIPPED_BOREAL_WOOD = register("stripped_boreal_wood", new BlockItem(JinericBlocks.STRIPPED_BOREAL_WOOD, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item STRIPPED_BOREAL_LOG = register("stripped_boreal_log", new BlockItem(JinericBlocks.STRIPPED_BOREAL_LOG, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BOREAL_PLANKS = register("boreal_planks", new BlockItem(JinericBlocks.BOREAL_PLANKS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BOREAL_STAIRS = register("boreal_stairs", new BlockItem(JinericBlocks.BOREAL_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BOREAL_SLAB = register("boreal_slab", new BlockItem(JinericBlocks.BOREAL_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SOUL_SANDSTONE = register("soul_sandstone", new BlockItem(JinericBlocks.SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SOUL_SANDSTONE_SLAB = register("soul_sandstone_slab", new BlockItem(JinericBlocks.SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BlockItem(JinericBlocks.SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CUT_SOUL_SANDSTONE_SLAB = register("cut_soul_sandstone_slab", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SOUL_SANDSTONE = register("polished_soul_sandstone", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SOUL_SANDSTONE_SLAB = register("polished_soul_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SOUL_SANDSTONE_STAIRS = register("polished_soul_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CHISELED_SOUL_SANDSTONE_SLAB = register("chiseled_soul_sandstone_slab", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CHISELED_SOUL_SANDSTONE_STAIRS = register("chiseled_soul_sandstone_stairs", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SMOOTH_SOUL_SANDSTONE_SLAB = register("smooth_soul_sandstone_slab", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_SOUL_SANDSTONE_SLAB = register("wavy_soul_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new BlockItem(JinericBlocks.SOUL_JACK_O_LANTERN, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CALCITE_STAIRS = register("calcite_stairs", new BlockItem(JinericBlocks.CALCITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CALCITE_SLAB = register("calcite_slab", new BlockItem(JinericBlocks.CALCITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item TUFF_STAIRS = register("tuff_stairs", new BlockItem(JinericBlocks.TUFF_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item TUFF_SLAB = register("tuff_slab", new BlockItem(JinericBlocks.TUFF_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item DRIPSTONE_STAIRS = register("dripstone_stairs", new BlockItem(JinericBlocks.DRIPSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item DRIPSTONE_SLAB = register("dripstone_slab", new BlockItem(JinericBlocks.DRIPSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SANDSTONE = register("polished_sandstone", new BlockItem(JinericBlocks.POLISHED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SANDSTONE_STAIRS = register("polished_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_SANDSTONE_SLAB = register("polished_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_SANDSTONE = register("wavy_sandstone", new BlockItem(JinericBlocks.WAVY_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_SANDSTONE_SLAB = register("wavy_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CHISELED_SANDSTONE_STAIRS = register("chiseled_sandstone_stairs", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CHISELED_SANDSTONE_SLAB = register("chiseled_sandstone_slab", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_RED_SANDSTONE = register("polished_red_sandstone", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_RED_SANDSTONE_STAIRS = register("polished_red_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item POLISHED_RED_SANDSTONE_SLAB = register("polished_red_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item WAVY_RED_SANDSTONE_SLAB = register("wavy_red_sandstone_slab", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CHISELED_RED_SANDSTONE_STAIRS = register("chiseled_red_sandstone_stairs", new BlockItem(JinericBlocks.CHISELED_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CHISELED_RED_SANDSTONE_SLAB = register("chiseled_red_sandstone_slab", new BlockItem(JinericBlocks.CHISELED_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CUT_RED_SANDSTONE_STAIRS = register("cut_red_sandstone_stairs", new BlockItem(JinericBlocks.CUT_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item OBSIDIAN_STAIRS = register("obsidian_stairs", new BlockItem(JinericBlocks.OBSIDIAN_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item OBSIDIAN_SLAB = register("obsidian_slab", new BlockItem(JinericBlocks.OBSIDIAN_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CRACKED_STONE_BRICK_STAIRS = register("cracked_stone_brick_stairs", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CRACKED_STONE_BRICK_SLAB = register("cracked_stone_brick_slab", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", new BlockItem(JinericBlocks.SMOOTH_STONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item PACKED_ICE_STAIRS = register("packed_ice_stairs", new BlockItem(JinericBlocks.PACKED_ICE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item PACKED_ICE_SLAB = register("packed_ice_slab", new BlockItem(JinericBlocks.PACKED_ICE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));

	//DECORATION BLOCKS
	public static final Item BOREAL_SAPLING = register("boreal_sapling", new Item(JinericItemSettings.DecorationBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	//public static final Item BOREAL_SAPLING = register("boreal_sapling", new BlockItem(JinericBlocks.BOREAL_SAPLING, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item BOREAL_LEAVES = register("boreal_leaves", new BlockItem(JinericBlocks.BOREAL_LEAVES, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item TUMBLEWEED = register("tumbleweed", new BlockItem(JinericBlocks.TUMBLEWEED, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item BOREAL_FENCE = register("boreal_fence", new BlockItem(JinericBlocks.BOREAL_FENCE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item SILTSTONE_WALL = register("siltstone_wall", new BlockItem(JinericBlocks.SILTSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item POLISHED_SILTSTONE_WALL = register("polished_siltstone_wall", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item SLATE_WALL = register("slate_wall", new BlockItem(JinericBlocks.SLATE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item BORITE_WALL = register("borite_wall", new BlockItem(JinericBlocks.BORITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new BlockItem(JinericBlocks.SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item POLISHED_SOUL_SANDSTONE_WALL = register("polished_soul_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item CHISELED_SOUL_SANDSTONE_WALL = register("chiseled_soul_sandstone_wall", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item CALCITE_WALL = register("calcite_wall", new BlockItem(JinericBlocks.CALCITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item TUFF_WALL = register("tuff_wall", new BlockItem(JinericBlocks.TUFF_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item DRIPSTONE_WALL = register("dripstone_wall", new BlockItem(JinericBlocks.DRIPSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new BlockItem(JinericBlocks.CUT_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item POLISHED_SANDSTONE_WALL = register("polished_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item CHISELED_SANDSTONE_WALL = register("chiseled_sandstone_wall", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item CUT_RED_SANDSTONE_WALL = register("cut_red_sandstone_wall", new BlockItem(JinericBlocks.CUT_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item POLISHED_RED_SANDSTONE_WALL = register("polished_red_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item SMOOTH_RED_SANDSTONE_WALL = register("smooth_red_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item CHISELED_RED_SANDSTONE_WALL = register("chiseled_red_sandstone_wall", new BlockItem(JinericBlocks.CHISELED_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item STONE_WALL = register("stone_wall", new BlockItem(JinericBlocks.STONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item CRACKED_STONE_BRICK_WALL = register("cracked_stone_brick_wall", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item SMOOTH_STONE_WALL = register("smooth_stone_wall", new BlockItem(JinericBlocks.SMOOTH_STONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item POLISHED_GRANITE_WALL = register("polished_granite_wall", new BlockItem(JinericBlocks.POLISHED_GRANITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item POLISHED_DIORITE_WALL = register("polished_diorite_wall", new BlockItem(JinericBlocks.POLISHED_DIORITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item POLISHED_ANDESITE_WALL = register("polished_andesite_wall", new BlockItem(JinericBlocks.POLISHED_ANDESITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item OBSIDIAN_WALL = register("obsidian_wall", new BlockItem(JinericBlocks.OBSIDIAN_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item PACKED_ICE_WALL = register("packed_ice_wall", new BlockItem(JinericBlocks.PACKED_ICE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item SNOW_WALL = register("snow_wall", new BlockItem(JinericBlocks.SNOW_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item DARK_PRISMARINE_WALL = register("dark_prismarine_wall", new BlockItem(JinericBlocks.DARK_PRISMARINE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));
	public static final Item PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", new BlockItem(JinericBlocks.PRISMARINE_BRICK_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));

	public static final Item SHULKER_CHEST = register("shulker_chest", new BlockItem(JinericBlocks.SHULKER_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DECORATION_BLOCKS)));


	// REDSTONE
	public static final Item BOREAL_BUTTON = register("boreal_button", new BlockItem(JinericBlocks.BOREAL_BUTTON, JinericItemSettings.Redstone().group(JinericItemGroups.REDSTONE)));
	public static final Item BOREAL_PRESSURE_PLATE = register("boreal_pressure_plate", new BlockItem(JinericBlocks.BOREAL_PRESSURE_PLATE, JinericItemSettings.Redstone().group(JinericItemGroups.REDSTONE)));
	public static final Item BOREAL_DOOR = register("boreal_door", new BlockItem(JinericBlocks.BOREAL_DOOR, JinericItemSettings.Redstone().group(JinericItemGroups.REDSTONE)));
	public static final Item BOREAL_TRAPDOOR = register("boreal_trapdoor", new BlockItem(JinericBlocks.BOREAL_TRAPDOOR, JinericItemSettings.Redstone().group(JinericItemGroups.REDSTONE)));
	public static final Item BOREAL_FENCE_GATE = register("boreal_fence_gate", new BlockItem(JinericBlocks.BOREAL_FENCE_GATE, JinericItemSettings.Redstone().group(JinericItemGroups.REDSTONE)));

//TRANSPORTATION
	//public static final Item BOREAL_BOAT = register("BOREAL_BOAT", new Item(JinericItemSettings.Transportation().group(JinericItemGroups.TRANSPORTATION)));


	//MISCELLANEOUS
	public static final Item SALT = register("salt", new Item(JinericItemSettings.Misc().group(JinericItemGroups.MISCELLANEOUS)));
	public static final Item NETHERITE_HORSE_ARMOR = register("netherite_horse_armor", new JinericHorseArmorItem(15, "netherite", JinericItemSettings.Transportation().fireproof().maxCount(1)));
	public static final Item MANX_LOAGHTAN_SPAWN_EGG =register("manx_loaghtan_spawn_egg", new SpawnEggItem(JinericEntities.MANX_LOAGHTAN, 707594, 181629, JinericItemSettings.Misc()));

// FOODS

//TOOLS

//COMBAT

// BREWING
	public static final Item GOLDEN_POTATO = register("golden_potato", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build()).group(JinericItemGroups.BREWING)));
	public static final Item GOLDEN_SWEET_BERRIES = register("golden_sweet_berries", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(5).saturationModifier(8f).build()).group(JinericItemGroups.BREWING)));
	public static final Item GOLDEN_BEETROOT = register("golden_beetroot", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(4).saturationModifier(5f).build()).group(JinericItemGroups.BREWING)));
	public static final Item WARPED_NETHER_WART = register("warped_nether_wart", new Item(JinericItemSettings.Misc().group(JinericItemGroups.BREWING)));

	public static final Item SALT_BLOCK = register("salt_block", new BlockItem(JinericBlocks.SALT_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item SUGAR_BLOCK = register("sugar_block", new BlockItem(JinericBlocks.SUGAR_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new BlockItem(JinericBlocks.ROTTEN_FLESH_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item FLINT_BLOCK = register("flint_block", new BlockItem(JinericBlocks.FLINT_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item CHARCOAL_BLOCK = register("charcoal_block", new BlockItem(JinericBlocks.CHARCOAL_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));
	public static final Item BAMBOO_BLOCK = register("bamboo_block", new BlockItem(JinericBlocks.BAMBOO_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.BUILDING_BLOCKS)));

// ETC
	public static final Item FROZEN_ELYTRA = register("frozen_elytra", new JinericElytraItem(new FabricItemSettings().maxDamage(432).group(JinericItemGroups.TRANSPORTATION).equipmentSlot(item -> CHEST).rarity(RARE)));
//.Transportation().group(JinericItemGroups.TRANSPORTATION).maxCount(1).rarity(RARE).maxDamage(432)));


	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier("jineric", name), item);
	}

	public static void init() {
	}
}

