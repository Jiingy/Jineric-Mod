package jingy.jineric.registry;

import jingy.jineric.item.JinericElytraItem;
import jingy.jineric.item.JinericHorseArmorItem;
import jingy.jineric.util.RegistryObject;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.entity.EquipmentSlot.CHEST;
import static net.minecraft.util.Rarity.RARE;

@SuppressWarnings("unused")
public class JinericItems {
	public static final List<RegistryObject<Item>> ITEMS = new ArrayList<>();

//DONE --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//DRIPSTONE
	public static final Item POLISHED_STONE = register("polished_stone", new BlockItem(JinericBlocks.POLISHED_STONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_STONE_SLAB = register("polished_stone_slab", new BlockItem(JinericBlocks.POLISHED_STONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_STONE_STAIRS = register("polished_stone_stairs", new BlockItem(JinericBlocks.POLISHED_STONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_STONE_WALL = register("polished_stone_wall", new BlockItem(JinericBlocks.POLISHED_STONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item STONE_TILES = register("stone_tiles", new BlockItem(JinericBlocks.STONE_TILES, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item STONE_TILE_SLAB = register("stone_tile_slab", new BlockItem(JinericBlocks.STONE_TILE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item STONE_TILE_STAIRS = register("stone_tile_stairs", new BlockItem(JinericBlocks.STONE_TILE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item STONE_TILE_WALL = register("stone_tile_wall", new BlockItem(JinericBlocks.STONE_TILE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_STAIRS = register("dripstone_stairs", new BlockItem(JinericBlocks.DRIPSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_SLAB = register("dripstone_slab", new BlockItem(JinericBlocks.DRIPSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_WALL = register("dripstone_wall", new BlockItem(JinericBlocks.DRIPSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item COBBLED_DRIPSTONE = register("cobbled_dripstone", new BlockItem(JinericBlocks.COBBLED_DRIPSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item COBBLED_DRIPSTONE_STAIRS = register("cobbled_dripstone_stairs", new BlockItem(JinericBlocks.COBBLED_DRIPSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item COBBLED_DRIPSTONE_SLAB = register("cobbled_dripstone_slab", new BlockItem(JinericBlocks.COBBLED_DRIPSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item COBBLED_DRIPSTONE_WALL = register("cobbled_dripstone_wall", new BlockItem(JinericBlocks.COBBLED_DRIPSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_BRICKS = register("dripstone_bricks", new BlockItem(JinericBlocks.DRIPSTONE_BRICKS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_BRICK_STAIRS = register("dripstone_brick_stairs", new BlockItem(JinericBlocks.DRIPSTONE_BRICK_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_BRICK_SLAB = register("dripstone_brick_slab", new BlockItem(JinericBlocks.DRIPSTONE_BRICK_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_BRICK_WALL = register("dripstone_brick_wall", new BlockItem(JinericBlocks.DRIPSTONE_BRICK_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_DRIPSTONE = register("polished_dripstone", new BlockItem(JinericBlocks.POLISHED_DRIPSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_DRIPSTONE_STAIRS = register("polished_dripstone_stairs", new BlockItem(JinericBlocks.POLISHED_DRIPSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_DRIPSTONE_SLAB = register("polished_dripstone_slab", new BlockItem(JinericBlocks.POLISHED_DRIPSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_DRIPSTONE_WALL = register("polished_dripstone_wall", new BlockItem(JinericBlocks.POLISHED_DRIPSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_TILES = register("dripstone_tiles", new BlockItem(JinericBlocks.DRIPSTONE_TILES, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_TILE_SLAB = register("dripstone_tile_slab", new BlockItem(JinericBlocks.DRIPSTONE_TILE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_TILE_STAIRS = register("dripstone_tile_stairs", new BlockItem(JinericBlocks.DRIPSTONE_TILE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_TILE_WALL = register("dripstone_tile_wall", new BlockItem(JinericBlocks.DRIPSTONE_TILE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_DRIPSTONE = register("smooth_dripstone", new BlockItem(JinericBlocks.SMOOTH_DRIPSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_DRIPSTONE_STAIRS = register("smooth_dripstone_stairs", new BlockItem(JinericBlocks.SMOOTH_DRIPSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_DRIPSTONE_SLAB = register("smooth_dripstone_slab", new BlockItem(JinericBlocks.SMOOTH_DRIPSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_DRIPSTONE_WALL = register("smooth_dripstone_wall", new BlockItem(JinericBlocks.SMOOTH_DRIPSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CHISELED_DRIPSTONE_BRICKS = register("chiseled_dripstone_bricks", new BlockItem(JinericBlocks.CHISELED_DRIPSTONE_BRICKS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DRIPSTONE_PILLAR = register("dripstone_pillar", new BlockItem(JinericBlocks.DRIPSTONE_PILLAR, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item FULL_GRASS_BLOCK = register("full_grass_block", new BlockItem(JinericBlocks.FULL_GRASS_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));

//SANDSTONE
	public static final Item SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new BlockItem(JinericBlocks.CUT_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_SANDSTONE = register("polished_sandstone", new BlockItem(JinericBlocks.POLISHED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_SANDSTONE_SLAB = register("polished_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_SANDSTONE_STAIRS = register("polished_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_SANDSTONE_WALL = register("polished_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_SANDSTONE = register("wavy_sandstone", new BlockItem(JinericBlocks.WAVY_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_SANDSTONE_SLAB = register("wavy_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));

//RED SANDSTONE
	public static final Item SMOOTH_RED_SANDSTONE_WALL = register("smooth_red_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CUT_RED_SANDSTONE_STAIRS = register("cut_red_sandstone_stairs", new BlockItem(JinericBlocks.CUT_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CUT_RED_SANDSTONE_WALL = register("cut_red_sandstone_wall", new BlockItem(JinericBlocks.CUT_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_RED_SANDSTONE = register("polished_red_sandstone", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_RED_SANDSTONE_STAIRS = register("polished_red_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_RED_SANDSTONE_SLAB = register("polished_red_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_RED_SANDSTONE_WALL = register("polished_red_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_RED_SANDSTONE_SLAB = register("wavy_red_sandstone_slab", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));

//SOUL SANDSTONE
	public static final Item SOUL_SANDSTONE = register("soul_sandstone", new BlockItem(JinericBlocks.SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SOUL_SANDSTONE_SLAB = register("soul_sandstone_slab", new BlockItem(JinericBlocks.SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BlockItem(JinericBlocks.SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new BlockItem(JinericBlocks.SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CUT_SOUL_SANDSTONE_SLAB = register("cut_soul_sandstone_slab", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_SOUL_SANDSTONE = register("polished_soul_sandstone", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_SOUL_SANDSTONE_SLAB = register("polished_soul_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_SOUL_SANDSTONE_STAIRS = register("polished_soul_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_SOUL_SANDSTONE_WALL = register("polished_soul_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_SOUL_SANDSTONE_SLAB = register("smooth_soul_sandstone_slab", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_SOUL_SANDSTONE_SLAB = register("wavy_soul_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));

//MISC VANILLA
	public static final Item STONE_WALL = register("stone_wall", new BlockItem(JinericBlocks.STONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CRACKED_STONE_BRICK_STAIRS = register("cracked_stone_brick_stairs", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CRACKED_STONE_BRICK_SLAB = register("cracked_stone_brick_slab", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CRACKED_STONE_BRICK_WALL = register("cracked_stone_brick_wall", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item STONE_PILLAR = register("stone_pillar", new BlockItem(JinericBlocks.STONE_PILLAR, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", new BlockItem(JinericBlocks.SMOOTH_STONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_STONE_WALL = register("smooth_stone_wall", new BlockItem(JinericBlocks.SMOOTH_STONE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_DEEPSLATE = register("smooth_deepslate", new BlockItem(JinericBlocks.SMOOTH_DEEPSLATE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_DEEPSLATE_STAIRS = register("smooth_deepslate_stairs", new BlockItem(JinericBlocks.SMOOTH_DEEPSLATE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_DEEPSLATE_SLAB = register("smooth_deepslate_slab", new BlockItem(JinericBlocks.SMOOTH_DEEPSLATE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SMOOTH_DEEPSLATE_WALL = register("smooth_deepslate_wall", new BlockItem(JinericBlocks.SMOOTH_DEEPSLATE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DARK_PRISMARINE_WALL = register("dark_prismarine_wall", new BlockItem(JinericBlocks.DARK_PRISMARINE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", new BlockItem(JinericBlocks.PRISMARINE_BRICK_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_GRANITE_WALL = register("polished_granite_wall", new BlockItem(JinericBlocks.POLISHED_GRANITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_DIORITE_WALL = register("polished_diorite_wall", new BlockItem(JinericBlocks.POLISHED_DIORITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item POLISHED_ANDESITE_WALL = register("polished_andesite_wall", new BlockItem(JinericBlocks.POLISHED_ANDESITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item TUFF_STAIRS = register("tuff_stairs", new BlockItem(JinericBlocks.TUFF_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item TUFF_SLAB = register("tuff_slab", new BlockItem(JinericBlocks.TUFF_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item TUFF_WALL = register("tuff_wall", new BlockItem(JinericBlocks.TUFF_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CALCITE_STAIRS = register("calcite_stairs", new BlockItem(JinericBlocks.CALCITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CALCITE_SLAB = register("calcite_slab", new BlockItem(JinericBlocks.CALCITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CALCITE_WALL = register("calcite_wall", new BlockItem(JinericBlocks.CALCITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SNOW_WALL = register("snow_wall", new BlockItem(JinericBlocks.SNOW_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item PACKED_ICE_STAIRS = register("packed_ice_stairs", new BlockItem(JinericBlocks.PACKED_ICE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item PACKED_ICE_SLAB = register("packed_ice_slab", new BlockItem(JinericBlocks.PACKED_ICE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item PACKED_ICE_WALL = register("packed_ice_wall", new BlockItem(JinericBlocks.PACKED_ICE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item OBSIDIAN_STAIRS = register("obsidian_stairs", new BlockItem(JinericBlocks.OBSIDIAN_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item OBSIDIAN_SLAB = register("obsidian_slab", new BlockItem(JinericBlocks.OBSIDIAN_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item OBSIDIAN_WALL = register("obsidian_wall", new BlockItem(JinericBlocks.OBSIDIAN_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
//COPPER
	//REGULAR

	//CUT
	public static final Item CUT_COPPER_WALL = register("cut_copper_wall", new BlockItem(JinericBlocks.CUT_COPPER_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
	public static final Item EXPOSED_CUT_COPPER_WALL = register("exposed_cut_copper_wall", new BlockItem(JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
	public static final Item WEATHERED_CUT_COPPER_WALL = register("weathered_cut_copper_wall", new BlockItem(JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
	public static final Item OXIDIZED_CUT_COPPER_WALL = register("oxidized_cut_copper_wall", new BlockItem(JinericBlocks.OXIDIZED_CUT_COPPER_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
	public static final Item WAXED_CUT_COPPER_WALL = register("waxed_cut_copper_wall", new BlockItem(JinericBlocks.WAXED_CUT_COPPER_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
	public static final Item WAXED_EXPOSED_CUT_COPPER_WALL = register("waxed_exposed_cut_copper_wall", new BlockItem(JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
	public static final Item WAXED_WEATHERED_CUT_COPPER_WALL = register("waxed_weathered_cut_copper_wall", new BlockItem(JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
	public static final Item WAXED_OXIDIZED_CUT_COPPER_WALL = register("waxed_oxidized_cut_copper_wall", new BlockItem(JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
//STORAGE
	public static final Item CHARCOAL_BLOCK = register("charcoal_block", new BlockItem(JinericBlocks.CHARCOAL_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item FLINT_BLOCK = register("flint_block", new BlockItem(JinericBlocks.FLINT_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item BONE_MEAL_BLOCK = register("bone_meal_block", new BlockItem(JinericBlocks.BONE_MEAL_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item PRISMARINE_CRYSTAL_BLOCK = register("prismarine_crystal_block", new BlockItem(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item BAMBOO_BLOCK = register("bamboo_block", new BlockItem(JinericBlocks.BAMBOO_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item SUGAR_BLOCK = register("sugar_block", new BlockItem(JinericBlocks.SUGAR_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new BlockItem(JinericBlocks.ROTTEN_FLESH_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item STICK_BUNDLE = register("stick_bundle", new BlockItem(JinericBlocks.STICK_BUNDLE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item EGG_BLOCK = register("egg_block", new BlockItem(JinericBlocks.EGG_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item ENDER_PEARL_BLOCK = register("ender_pearl_block", new BlockItem(JinericBlocks.ENDER_PEARL_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item STACK_OF_PAPER = register("stack_of_paper", new BlockItem(JinericBlocks.STACK_OF_PAPER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item BLAZE_ROD_BUNDLE = register("blaze_rod_bundle", new BlockItem(JinericBlocks.BLAZE_ROD_BUNDLE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));

	//BOOKSHELVES
	public static final Item SPRUCE_BOOKSHELF = register("spruce_bookshelf", new BlockItem(JinericBlocks.SPRUCE_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item BIRCH_BOOKSHELF = register("birch_bookshelf", new BlockItem(JinericBlocks.BIRCH_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item JUNGLE_BOOKSHELF = register("jungle_bookshelf", new BlockItem(JinericBlocks.JUNGLE_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item ACACIA_BOOKSHELF = register("acacia_bookshelf", new BlockItem(JinericBlocks.ACACIA_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DARK_OAK_BOOKSHELF = register("dark_oak_bookshelf", new BlockItem(JinericBlocks.DARK_OAK_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
	public static final Item MANGROVE_BOOKSHELF = register("mangrove_bookshelf", new BlockItem(JinericBlocks.MANGROVE_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CRIMSON_BOOKSHELF = register("crimson_bookshelf", new BlockItem(JinericBlocks.CRIMSON_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WARPED_BOOKSHELF = register("warped_bookshelf", new BlockItem(JinericBlocks.WARPED_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));
//CHESTS
	public static final Item SPRUCE_CHEST = register("spruce_chest", new BlockItem(JinericBlocks.SPRUCE_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item BIRCH_CHEST = register("birch_chest", new BlockItem(JinericBlocks.BIRCH_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item JUNGLE_CHEST = register("jungle_chest", new BlockItem(JinericBlocks.JUNGLE_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item ACACIA_CHEST = register("acacia_chest", new BlockItem(JinericBlocks.ACACIA_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DARK_OAK_CHEST = register("dark_oak_chest", new BlockItem(JinericBlocks.DARK_OAK_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item MANGROVE_CHEST = register("mangrove_chest", new BlockItem(JinericBlocks.MANGROVE_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CRIMSON_CHEST = register("crimson_chest", new BlockItem(JinericBlocks.CRIMSON_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WARPED_CHEST = register("warped_chest", new BlockItem(JinericBlocks.WARPED_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
//LADDER
	public static final Item SPRUCE_LADDER = register("spruce_ladder", new BlockItem(JinericBlocks.SPRUCE_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item BIRCH_LADDER = register("birch_ladder", new BlockItem(JinericBlocks.BIRCH_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item JUNGLE_LADDER = register("jungle_ladder", new BlockItem(JinericBlocks.JUNGLE_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item ACACIA_LADDER = register("acacia_ladder", new BlockItem(JinericBlocks.ACACIA_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item DARK_OAK_LADDER = register("dark_oak_ladder", new BlockItem(JinericBlocks.DARK_OAK_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item MANGROVE_LADDER = register("mangrove_ladder", new BlockItem(JinericBlocks.MANGROVE_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item WARPED_LADDER = register("warped_ladder", new BlockItem(JinericBlocks.WARPED_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item CRIMSON_LADDER = register("crimson_ladder", new BlockItem(JinericBlocks.CRIMSON_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
//MISC JINERIC
	public static final Item SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new BlockItem(JinericBlocks.SOUL_JACK_O_LANTERN, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.DONE)));
	public static final Item NETHERITE_HORSE_ARMOR = register("netherite_horse_armor", new JinericHorseArmorItem(15, "netherite", JinericItemSettings.Misc().fireproof().maxCount(1).group(JinericItemGroups.DONE)));


//WIP ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- WIP -----------------------------------------------------

	public static final Item TUMBLEWEED = register("tumbleweed", new BlockItem(JinericBlocks.TUMBLEWEED, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.WIP)));

//UNKNOWN ---------------------------------------------------------------------------------------------------------- UNKNOWN ---------------------------------------------------------------------------------------------------------------- UNKNOWN -----------------------------------------------------
	public static final Item REFINERY = register("refinery", new BlockItem(JinericBlocks.REFINERY, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	//BOREAL
	public static final Item BOREAL_WOOD = register("boreal_wood", new BlockItem(JinericBlocks.BOREAL_WOOD, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_LOG = register("boreal_log", new BlockItem(JinericBlocks.BOREAL_LOG, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item STRIPPED_BOREAL_WOOD = register("stripped_boreal_wood", new BlockItem(JinericBlocks.STRIPPED_BOREAL_WOOD, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item STRIPPED_BOREAL_LOG = register("stripped_boreal_log", new BlockItem(JinericBlocks.STRIPPED_BOREAL_LOG, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_PLANKS = register("boreal_planks", new BlockItem(JinericBlocks.BOREAL_PLANKS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_STAIRS = register("boreal_stairs", new BlockItem(JinericBlocks.BOREAL_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_SLAB = register("boreal_slab", new BlockItem(JinericBlocks.BOREAL_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_FENCE = register("boreal_fence", new BlockItem(JinericBlocks.BOREAL_FENCE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_FENCE_GATE = register("boreal_fence_gate", new BlockItem(JinericBlocks.BOREAL_FENCE_GATE, JinericItemSettings.Redstone().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_BOOKSHELF = register("boreal_bookshelf", new BlockItem(JinericBlocks.BOREAL_BOOKSHELF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_SIGN = register("boreal_sign", new SignItem(new FabricItemSettings().maxCount(16).group(JinericItemGroups.UNKNOWN), JinericBlocks.BOREAL_SIGN, JinericBlocks.BOREAL_WALL_SIGN));
	public static final Item BOREAL_LADDER = register("boreal_ladder", new BlockItem(JinericBlocks.BOREAL_LADDER, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_CHEST = register("boreal_chest", new BlockItem(JinericBlocks.BOREAL_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_BUTTON = register("boreal_button", new BlockItem(JinericBlocks.BOREAL_BUTTON, JinericItemSettings.Redstone().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_PRESSURE_PLATE = register("boreal_pressure_plate", new BlockItem(JinericBlocks.BOREAL_PRESSURE_PLATE, JinericItemSettings.Redstone().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_DOOR = register("boreal_door", new BlockItem(JinericBlocks.BOREAL_DOOR, JinericItemSettings.Redstone().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_TRAPDOOR = register("boreal_trapdoor", new BlockItem(JinericBlocks.BOREAL_TRAPDOOR, JinericItemSettings.Redstone().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_SAPLING = register("boreal_sapling", new BlockItem(JinericBlocks.BOREAL_SAPLING, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item BOREAL_LEAVES = register("boreal_leaves", new BlockItem(JinericBlocks.BOREAL_LEAVES, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item FIREWEED = register("fireweed", new BlockItem(JinericBlocks.FIREWEED, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	//RHYOLITE
	public static final Item RHYOLITE = register("rhyolite", new BlockItem(JinericBlocks.RHYOLITE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_STAIRS = register("rhyolite_stairs", new BlockItem(JinericBlocks.RHYOLITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_SLAB = register("rhyolite_slab", new BlockItem(JinericBlocks.RHYOLITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_BRICKS = register("rhyolite_bricks", new BlockItem(JinericBlocks.RHYOLITE_BRICKS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_BRICK_STAIRS = register("rhyolite_brick_stairs", new BlockItem(JinericBlocks.RHYOLITE_BRICK_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_BRICK_SLAB = register("rhyolite_brick_slab", new BlockItem(JinericBlocks.RHYOLITE_BRICK_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item CHISELED_RHYOLITE_BRICKS = register("chiseled_rhyolite_bricks", new BlockItem(JinericBlocks.CHISELED_RHYOLITE_BRICKS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_RHYOLITE = register("polished_rhyolite", new BlockItem(JinericBlocks.POLISHED_RHYOLITE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_RHYOLITE_STAIRS = register("polished_rhyolite_stairs", new BlockItem(JinericBlocks.POLISHED_RHYOLITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_RHYOLITE_SLAB = register("polished_rhyolite_slab", new BlockItem(JinericBlocks.POLISHED_RHYOLITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_TILES = register("rhyolite_tiles", new BlockItem(JinericBlocks.RHYOLITE_TILES, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_TILE_SLAB = register("rhyolite_tile_slab", new BlockItem(JinericBlocks.RHYOLITE_TILE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_TILE_STAIRS = register("rhyolite_tile_stairs", new BlockItem(JinericBlocks.RHYOLITE_TILE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_RHYOLITE = register("smooth_rhyolite", new BlockItem(JinericBlocks.SMOOTH_RHYOLITE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_RHYOLITE_SLAB = register("smooth_rhyolite_slab", new BlockItem(JinericBlocks.SMOOTH_RHYOLITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_RHYOLITE_STAIRS = register("smooth_rhyolite_stairs", new BlockItem(JinericBlocks.SMOOTH_RHYOLITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_RHYOLITE_WALL = register("smooth_rhyolite_wall", new BlockItem(JinericBlocks.SMOOTH_RHYOLITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_WALL = register("rhyolite_wall", new BlockItem(JinericBlocks.RHYOLITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_BRICK_WALL = register("rhyolite_brick_wall", new BlockItem(JinericBlocks.RHYOLITE_BRICK_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_RHYOLITE_WALL = register("polished_rhyolite_wall", new BlockItem(JinericBlocks.POLISHED_RHYOLITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item RHYOLITE_TILE_WALL = register("rhyolite_tile_wall", new BlockItem(JinericBlocks.RHYOLITE_TILE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	//TUFF
	public static final Item POLISHED_TUFF = register("polished_tuff", new BlockItem(JinericBlocks.POLISHED_TUFF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_TUFF_STAIRS = register("polished_tuff_stairs", new BlockItem(JinericBlocks.POLISHED_TUFF_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_TUFF_SLAB = register("polished_tuff_slab", new BlockItem(JinericBlocks.POLISHED_TUFF_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_TUFF_WALL = register("polished_tuff_wall", new BlockItem(JinericBlocks.POLISHED_TUFF_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_TUFF = register("smooth_tuff", new BlockItem(JinericBlocks.SMOOTH_TUFF, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_TUFF_STAIRS = register("smooth_tuff_stairs", new BlockItem(JinericBlocks.SMOOTH_TUFF_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_TUFF_SLAB = register("smooth_tuff_slab", new BlockItem(JinericBlocks.SMOOTH_TUFF_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_TUFF_WALL = register("smooth_tuff_wall", new BlockItem(JinericBlocks.SMOOTH_TUFF_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item TUFF_BRICKS = register("tuff_bricks", new BlockItem(JinericBlocks.TUFF_BRICKS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item TUFF_BRICK_STAIRS = register("tuff_brick_stairs", new BlockItem(JinericBlocks.TUFF_BRICK_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item TUFF_BRICK_SLAB = register("tuff_brick_slab", new BlockItem(JinericBlocks.TUFF_BRICK_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item TUFF_BRICK_WALL = register("tuff_brick_wall", new BlockItem(JinericBlocks.TUFF_BRICK_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
//CALCITE
	public static final Item POLISHED_CALCITE = register("polished_calcite", new BlockItem(JinericBlocks.POLISHED_CALCITE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_CALCITE_STAIRS = register("polished_calcite_stairs", new BlockItem(JinericBlocks.POLISHED_CALCITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_CALCITE_SLAB = register("polished_calcite_slab", new BlockItem(JinericBlocks.POLISHED_CALCITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item POLISHED_CALCITE_WALL = register("polished_calcite_wall", new BlockItem(JinericBlocks.POLISHED_CALCITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item CALCITE_BRICKS = register("calcite_bricks", new BlockItem(JinericBlocks.CALCITE_BRICKS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item CALCITE_BRICK_STAIRS = register("calcite_brick_stairs", new BlockItem(JinericBlocks.CALCITE_BRICK_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item CALCITE_BRICK_SLAB = register("calcite_brick_slab", new BlockItem(JinericBlocks.CALCITE_BRICK_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item CALCITE_BRICK_WALL = register("calcite_brick_wall", new BlockItem(JinericBlocks.CALCITE_BRICK_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_CALCITE = register("smooth_calcite", new BlockItem(JinericBlocks.SMOOTH_CALCITE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_CALCITE_STAIRS = register("smooth_calcite_stairs", new BlockItem(JinericBlocks.SMOOTH_CALCITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_CALCITE_SLAB = register("smooth_calcite_slab", new BlockItem(JinericBlocks.SMOOTH_CALCITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item SMOOTH_CALCITE_WALL = register("smooth_calcite_wall", new BlockItem(JinericBlocks.SMOOTH_CALCITE_WALL, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
//MISC
	public static final Item SHULKER_CHEST = register("shulker_chest", new BlockItem(JinericBlocks.SHULKER_CHEST, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item WARPED_NETHER_WART = register("warped_nether_wart", new Item(JinericItemSettings.Misc().group(JinericItemGroups.UNKNOWN)));
	public static final Item GOLDEN_POTATO = register("golden_potato", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build()).group(JinericItemGroups.UNKNOWN)));
	public static final Item GOLDEN_SWEET_BERRIES = register("golden_sweet_berries", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(5).saturationModifier(8f).build()).group(JinericItemGroups.UNKNOWN)));
	public static final Item GOLDEN_BEETROOT = register("golden_beetroot", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(4).saturationModifier(5f).build()).group(JinericItemGroups.UNKNOWN)));
	public static final Item DRIED_BAMBOO = register("dried_bamboo", new Item(JinericItemSettings.Misc().group(JinericItemGroups.UNKNOWN)));
	public static final Item MANX_LOAGHTAN_SPAWN_EGG = register("manx_loaghtan_spawn_egg", new SpawnEggItem(JinericEntities.MANX_LOAGHTAN, 0x3f4052, 0x12101d, JinericItemSettings.Misc().group(JinericItemGroups.UNKNOWN)));
	public static final Item SALT = register("salt", new Item(JinericItemSettings.Misc().group(JinericItemGroups.UNKNOWN)));
	public static final Item SALT_BLOCK = register("salt_block", new BlockItem(JinericBlocks.SALT_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item FROZEN_ELYTRA = register("frozen_elytra", new JinericElytraItem(new FabricItemSettings().maxDamage(432).group(JinericItemGroups.UNKNOWN).equipmentSlot(item -> CHEST).rarity(RARE)));
	public static final Item REDSTONE_LANTERN = register("redstone_lantern", new BlockItem(JinericBlocks.REDSTONE_LANTERN, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));
	public static final Item REDSTONE_CAMPFIRE = register("redstone_campfire", new BlockItem(JinericBlocks.REDSTONE_CAMPFIRE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.UNKNOWN)));


	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier("jineric", name), item);
	}

	public static <T extends Item> T createItem(T item, String id) {
		ITEMS.add(new RegistryObject<>(item, id));
		return item;
	}

	public static void itemRegistry() {
	}
}

