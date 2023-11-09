package jingy.jineric.item;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.registry.JinericBoatTypes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

//@SuppressWarnings("unused")
public class JinericItems {

//DONE ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//DRIPSTONE
	public static final Item POLISHED_STONE = register("polished_stone", new BlockItem(JinericBlocks.POLISHED_STONE, new FabricItemSettings()));
	public static final Item POLISHED_STONE_STAIRS = register("polished_stone_stairs", new BlockItem(JinericBlocks.POLISHED_STONE_STAIRS, new FabricItemSettings()));
	public static final Item POLISHED_STONE_SLAB = register("polished_stone_slab", new BlockItem(JinericBlocks.POLISHED_STONE_SLAB, new FabricItemSettings()));
	public static final Item POLISHED_STONE_WALL = register("polished_stone_wall", new BlockItem(JinericBlocks.POLISHED_STONE_WALL, new FabricItemSettings()));
	public static final Item DRIPSTONE_STAIRS = register("dripstone_stairs", new BlockItem(JinericBlocks.DRIPSTONE_STAIRS, new FabricItemSettings()));
	public static final Item DRIPSTONE_SLAB = register("dripstone_slab", new BlockItem(JinericBlocks.DRIPSTONE_SLAB, new FabricItemSettings()));
	public static final Item DRIPSTONE_WALL = register("dripstone_wall", new BlockItem(JinericBlocks.DRIPSTONE_WALL, new FabricItemSettings()));
	public static final Item COBBLED_DRIPSTONE = register("cobbled_dripstone", new BlockItem(JinericBlocks.COBBLED_DRIPSTONE, new FabricItemSettings()));
	public static final Item COBBLED_DRIPSTONE_STAIRS = register("cobbled_dripstone_stairs", new BlockItem(JinericBlocks.COBBLED_DRIPSTONE_STAIRS, new FabricItemSettings()));
	public static final Item COBBLED_DRIPSTONE_SLAB = register("cobbled_dripstone_slab", new BlockItem(JinericBlocks.COBBLED_DRIPSTONE_SLAB, new FabricItemSettings()));
	public static final Item COBBLED_DRIPSTONE_WALL = register("cobbled_dripstone_wall", new BlockItem(JinericBlocks.COBBLED_DRIPSTONE_WALL, new FabricItemSettings()));
	public static final Item DRIPSTONE_BRICKS = register("dripstone_bricks", new BlockItem(JinericBlocks.DRIPSTONE_BRICKS, new FabricItemSettings()));
	public static final Item DRIPSTONE_BRICK_STAIRS = register("dripstone_brick_stairs", new BlockItem(JinericBlocks.DRIPSTONE_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item DRIPSTONE_BRICK_SLAB = register("dripstone_brick_slab", new BlockItem(JinericBlocks.DRIPSTONE_BRICK_SLAB, new FabricItemSettings()));
	public static final Item DRIPSTONE_BRICK_WALL = register("dripstone_brick_wall", new BlockItem(JinericBlocks.DRIPSTONE_BRICK_WALL, new FabricItemSettings()));
	public static final Item CRACKED_DRIPSTONE_BRICKS = register("cracked_dripstone_bricks", new BlockItem(JinericBlocks.CRACKED_DRIPSTONE_BRICKS, new FabricItemSettings()));
	public static final Item CRACKED_DRIPSTONE_BRICK_STAIRS = register("cracked_dripstone_brick_stairs", new BlockItem(JinericBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_DRIPSTONE_BRICK_SLAB = register("cracked_dripstone_brick_slab", new BlockItem(JinericBlocks.CRACKED_DRIPSTONE_BRICK_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_DRIPSTONE_BRICK_WALL = register("cracked_dripstone_brick_wall", new BlockItem(JinericBlocks.CRACKED_DRIPSTONE_BRICK_WALL, new FabricItemSettings()));
	public static final Item POLISHED_DRIPSTONE = register("polished_dripstone", new BlockItem(JinericBlocks.POLISHED_DRIPSTONE, new FabricItemSettings()));
	public static final Item POLISHED_DRIPSTONE_STAIRS = register("polished_dripstone_stairs", new BlockItem(JinericBlocks.POLISHED_DRIPSTONE_STAIRS, new FabricItemSettings()));
	public static final Item POLISHED_DRIPSTONE_SLAB = register("polished_dripstone_slab", new BlockItem(JinericBlocks.POLISHED_DRIPSTONE_SLAB, new FabricItemSettings()));
	public static final Item POLISHED_DRIPSTONE_WALL = register("polished_dripstone_wall", new BlockItem(JinericBlocks.POLISHED_DRIPSTONE_WALL, new FabricItemSettings()));
	public static final Item DRIPSTONE_TILES = register("dripstone_tiles", new BlockItem(JinericBlocks.DRIPSTONE_TILES, new FabricItemSettings()));
	public static final Item DRIPSTONE_TILE_SLAB = register("dripstone_tile_slab", new BlockItem(JinericBlocks.DRIPSTONE_TILE_SLAB, new FabricItemSettings()));
	public static final Item DRIPSTONE_TILE_STAIRS = register("dripstone_tile_stairs", new BlockItem(JinericBlocks.DRIPSTONE_TILE_STAIRS, new FabricItemSettings()));
	public static final Item DRIPSTONE_TILE_WALL = register("dripstone_tile_wall", new BlockItem(JinericBlocks.DRIPSTONE_TILE_WALL, new FabricItemSettings()));
	public static final Item CRACKED_DRIPSTONE_TILES = register("cracked_dripstone_tiles", new BlockItem(JinericBlocks.CRACKED_DRIPSTONE_TILES, new FabricItemSettings()));
	public static final Item CRACKED_DRIPSTONE_TILE_SLAB = register("cracked_dripstone_tile_slab", new BlockItem(JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_DRIPSTONE_TILE_STAIRS = register("cracked_dripstone_tile_stairs", new BlockItem(JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_DRIPSTONE_TILE_WALL = register("cracked_dripstone_tile_wall", new BlockItem(JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL, new FabricItemSettings()));
	public static final Item SMOOTH_DRIPSTONE = register("smooth_dripstone", new BlockItem(JinericBlocks.SMOOTH_DRIPSTONE, new FabricItemSettings()));
	public static final Item SMOOTH_DRIPSTONE_STAIRS = register("smooth_dripstone_stairs", new BlockItem(JinericBlocks.SMOOTH_DRIPSTONE_STAIRS, new FabricItemSettings()));
	public static final Item SMOOTH_DRIPSTONE_SLAB = register("smooth_dripstone_slab", new BlockItem(JinericBlocks.SMOOTH_DRIPSTONE_SLAB, new FabricItemSettings()));
	public static final Item SMOOTH_DRIPSTONE_WALL = register("smooth_dripstone_wall", new BlockItem(JinericBlocks.SMOOTH_DRIPSTONE_WALL, new FabricItemSettings()));
	public static final Item CHISELED_DRIPSTONE = register("chiseled_dripstone", new BlockItem(JinericBlocks.CHISELED_DRIPSTONE, new FabricItemSettings()));
	public static final Item DRIPSTONE_PILLAR = register("dripstone_pillar", new BlockItem(JinericBlocks.DRIPSTONE_PILLAR, new FabricItemSettings()));

//TUFF
	public static final Item COBBLED_TUFF = register("cobbled_tuff", new BlockItem(JinericBlocks.COBBLED_TUFF, new FabricItemSettings()));
	public static final Item COBBLED_TUFF_SLAB = register("cobbled_tuff_slab", new BlockItem(JinericBlocks.COBBLED_TUFF_SLAB, new FabricItemSettings()));
	public static final Item COBBLED_TUFF_STAIRS = register("cobbled_tuff_stairs", new BlockItem(JinericBlocks.COBBLED_TUFF_STAIRS, new FabricItemSettings()));
	public static final Item COBBLED_TUFF_WALL = register("cobbled_tuff_wall", new BlockItem(JinericBlocks.COBBLED_TUFF_WALL, new FabricItemSettings()));
	public static final Item SMOOTH_TUFF = register("smooth_tuff", new BlockItem(JinericBlocks.SMOOTH_TUFF, new FabricItemSettings()));
	public static final Item SMOOTH_TUFF_STAIRS = register("smooth_tuff_stairs", new BlockItem(JinericBlocks.SMOOTH_TUFF_STAIRS, new FabricItemSettings()));
	public static final Item SMOOTH_TUFF_SLAB = register("smooth_tuff_slab", new BlockItem(JinericBlocks.SMOOTH_TUFF_SLAB, new FabricItemSettings()));
	public static final Item SMOOTH_TUFF_WALL = register("smooth_tuff_wall", new BlockItem(JinericBlocks.SMOOTH_TUFF_WALL, new FabricItemSettings()));
	public static final Item POLISHED_TUFF = register("polished_tuff", new BlockItem(JinericBlocks.POLISHED_TUFF, new FabricItemSettings()));
	public static final Item POLISHED_TUFF_STAIRS = register("polished_tuff_stairs", new BlockItem(JinericBlocks.POLISHED_TUFF_STAIRS, new FabricItemSettings()));
	public static final Item POLISHED_TUFF_SLAB = register("polished_tuff_slab", new BlockItem(JinericBlocks.POLISHED_TUFF_SLAB, new FabricItemSettings()));
	public static final Item POLISHED_TUFF_WALL = register("polished_tuff_wall", new BlockItem(JinericBlocks.POLISHED_TUFF_WALL, new FabricItemSettings()));
	public static final Item TUFF_BRICKS = register("tuff_bricks", new BlockItem(JinericBlocks.TUFF_BRICKS, new FabricItemSettings()));
	public static final Item TUFF_BRICK_STAIRS = register("tuff_brick_stairs", new BlockItem(JinericBlocks.TUFF_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item TUFF_BRICK_SLAB = register("tuff_brick_slab", new BlockItem(JinericBlocks.TUFF_BRICK_SLAB, new FabricItemSettings()));
	public static final Item TUFF_BRICK_WALL = register("tuff_brick_wall", new BlockItem(JinericBlocks.TUFF_BRICK_WALL, new FabricItemSettings()));
	public static final Item CRACKED_TUFF_BRICKS = register("cracked_tuff_bricks", new BlockItem(JinericBlocks.CRACKED_TUFF_BRICKS, new FabricItemSettings()));
	public static final Item CRACKED_TUFF_BRICK_STAIRS = register("cracked_tuff_brick_stairs", new BlockItem(JinericBlocks.CRACKED_TUFF_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_TUFF_BRICK_SLAB = register("cracked_tuff_brick_slab", new BlockItem(JinericBlocks.CRACKED_TUFF_BRICK_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_TUFF_BRICK_WALL = register("cracked_tuff_brick_wall", new BlockItem(JinericBlocks.CRACKED_TUFF_BRICK_WALL, new FabricItemSettings()));
	public static final Item CHISELED_TUFF = register("chiseled_tuff", new BlockItem(JinericBlocks.CHISELED_TUFF, new FabricItemSettings()));
	public static final Item TUFF_PILLAR = register("tuff_pillar", new BlockItem(JinericBlocks.TUFF_PILLAR, new FabricItemSettings()));
	public static final Item TUFF_TILES = register("tuff_tiles", new BlockItem(JinericBlocks.TUFF_TILES, new FabricItemSettings()));
	public static final Item TUFF_TILE_SLAB = register("tuff_tile_slab", new BlockItem(JinericBlocks.TUFF_TILE_SLAB, new FabricItemSettings()));
	public static final Item TUFF_TILE_STAIRS = register("tuff_tile_stairs", new BlockItem(JinericBlocks.TUFF_TILE_STAIRS, new FabricItemSettings()));
	public static final Item TUFF_TILE_WALL = register("tuff_tile_wall", new BlockItem(JinericBlocks.TUFF_TILE_WALL, new FabricItemSettings()));
	public static final Item CRACKED_TUFF_TILES = register("cracked_tuff_tiles", new BlockItem(JinericBlocks.CRACKED_TUFF_TILES, new FabricItemSettings()));
	public static final Item CRACKED_TUFF_TILE_SLAB = register("cracked_tuff_tile_slab", new BlockItem(JinericBlocks.CRACKED_TUFF_TILE_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_TUFF_TILE_STAIRS = register("cracked_tuff_tile_stairs", new BlockItem(JinericBlocks.CRACKED_TUFF_TILE_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_TUFF_TILE_WALL = register("cracked_tuff_tile_wall", new BlockItem(JinericBlocks.CRACKED_TUFF_TILE_WALL, new FabricItemSettings()));

//SANDSTONE
	public static final Item SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new BlockItem(JinericBlocks.CUT_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item POLISHED_SANDSTONE = register("polished_sandstone", new BlockItem(JinericBlocks.POLISHED_SANDSTONE, new FabricItemSettings()));
	public static final Item POLISHED_SANDSTONE_SLAB = register("polished_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item POLISHED_SANDSTONE_STAIRS = register("polished_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item POLISHED_SANDSTONE_WALL = register("polished_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item WAVY_SANDSTONE = register("wavy_sandstone", new BlockItem(JinericBlocks.WAVY_SANDSTONE, new FabricItemSettings()));
	public static final Item WAVY_SANDSTONE_SLAB = register("wavy_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SANDSTONE_WALL, new FabricItemSettings()));

//RED SANDSTONE
	public static final Item SMOOTH_RED_SANDSTONE_WALL = register("smooth_red_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_RED_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item CUT_RED_SANDSTONE_STAIRS = register("cut_red_sandstone_stairs", new BlockItem(JinericBlocks.CUT_RED_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item CUT_RED_SANDSTONE_WALL = register("cut_red_sandstone_wall", new BlockItem(JinericBlocks.CUT_RED_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item POLISHED_RED_SANDSTONE = register("polished_red_sandstone", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE, new FabricItemSettings()));
	public static final Item POLISHED_RED_SANDSTONE_STAIRS = register("polished_red_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item POLISHED_RED_SANDSTONE_SLAB = register("polished_red_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item POLISHED_RED_SANDSTONE_WALL = register("polished_red_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_RED_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE, new FabricItemSettings()));
	public static final Item WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item WAVY_RED_SANDSTONE_SLAB = register("wavy_red_sandstone_slab", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_WALL, new FabricItemSettings()));

//SOUL SANDSTONE
	public static final Item SOUL_SANDSTONE = register("soul_sandstone", new BlockItem(JinericBlocks.SOUL_SANDSTONE, new FabricItemSettings()));
	public static final Item SOUL_SANDSTONE_SLAB = register("soul_sandstone_slab", new BlockItem(JinericBlocks.SOUL_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BlockItem(JinericBlocks.SOUL_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new BlockItem(JinericBlocks.SOUL_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE, new FabricItemSettings()));
	public static final Item CUT_SOUL_SANDSTONE_SLAB = register("cut_soul_sandstone_slab", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item POLISHED_SOUL_SANDSTONE = register("polished_soul_sandstone", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE, new FabricItemSettings()));
	public static final Item POLISHED_SOUL_SANDSTONE_SLAB = register("polished_soul_sandstone_slab", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item POLISHED_SOUL_SANDSTONE_STAIRS = register("polished_soul_sandstone_stairs", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item POLISHED_SOUL_SANDSTONE_WALL = register("polished_soul_sandstone_wall", new BlockItem(JinericBlocks.POLISHED_SOUL_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE, new FabricItemSettings()));
	public static final Item SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE, new FabricItemSettings()));
	public static final Item SMOOTH_SOUL_SANDSTONE_SLAB = register("smooth_soul_sandstone_slab", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_WALL, new FabricItemSettings()));
	public static final Item WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE, new FabricItemSettings()));
	public static final Item WAVY_SOUL_SANDSTONE_SLAB = register("wavy_soul_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB, new FabricItemSettings()));
	public static final Item WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS, new FabricItemSettings()));
	public static final Item WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_WALL, new FabricItemSettings()));

//MISC VANILLA
	//OVERWORLD
	public static final Item STONE_WALL = register("stone_wall", new BlockItem(JinericBlocks.STONE_WALL, new FabricItemSettings()));
	public static final Item CRACKED_STONE_BRICK_STAIRS = register("cracked_stone_brick_stairs", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_STONE_BRICK_SLAB = register("cracked_stone_brick_slab", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_STONE_BRICK_WALL = register("cracked_stone_brick_wall", new BlockItem(JinericBlocks.CRACKED_STONE_BRICK_WALL, new FabricItemSettings()));
	public static final Item STONE_TILES = register("stone_tiles", new BlockItem(JinericBlocks.STONE_TILES, new FabricItemSettings()));
	public static final Item STONE_TILE_STAIRS = register("stone_tile_stairs", new BlockItem(JinericBlocks.STONE_TILE_STAIRS, new FabricItemSettings()));
	public static final Item STONE_TILE_SLAB = register("stone_tile_slab", new BlockItem(JinericBlocks.STONE_TILE_SLAB, new FabricItemSettings()));
	public static final Item STONE_TILE_WALL = register("stone_tile_wall", new BlockItem(JinericBlocks.STONE_TILE_WALL, new FabricItemSettings()));
	public static final Item CRACKED_STONE_TILES = register("cracked_stone_tiles", new BlockItem(JinericBlocks.CRACKED_STONE_TILES, new FabricItemSettings()));
	public static final Item CRACKED_STONE_TILE_STAIRS = register("cracked_stone_tile_stairs", new BlockItem(JinericBlocks.CRACKED_STONE_TILE_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_STONE_TILE_SLAB = register("cracked_stone_tile_slab", new BlockItem(JinericBlocks.CRACKED_STONE_TILE_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_STONE_TILE_WALL = register("cracked_stone_tile_wall", new BlockItem(JinericBlocks.CRACKED_STONE_TILE_WALL, new FabricItemSettings()));
	public static final Item STONE_PILLAR = register("stone_pillar", new BlockItem(JinericBlocks.STONE_PILLAR, new FabricItemSettings()));
	public static final Item CRACKED_DEEPSLATE_BRICK_STAIRS = register("cracked_deepslate_brick_stairs", new BlockItem(JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_DEEPSLATE_BRICK_SLAB = register("cracked_deepslate_brick_slab", new BlockItem(JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_DEEPSLATE_BRICK_WALL = register("cracked_deepslate_brick_wall", new BlockItem(JinericBlocks.CRACKED_DEEPSLATE_BRICK_WALL, new FabricItemSettings()));
	public static final Item CRACKED_DEEPSLATE_TILE_STAIRS = register("cracked_deepslate_tile_stairs", new BlockItem(JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_DEEPSLATE_TILE_SLAB = register("cracked_deepslate_tile_slab", new BlockItem(JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_DEEPSLATE_TILE_WALL = register("cracked_deepslate_tile_wall", new BlockItem(JinericBlocks.CRACKED_DEEPSLATE_TILE_WALL, new FabricItemSettings()));
	public static final Item SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", new BlockItem(JinericBlocks.SMOOTH_STONE_STAIRS, new FabricItemSettings()));
	public static final Item SMOOTH_STONE_WALL = register("smooth_stone_wall", new BlockItem(JinericBlocks.SMOOTH_STONE_WALL, new FabricItemSettings()));
	public static final Item SMOOTH_DEEPSLATE = register("smooth_deepslate", new BlockItem(JinericBlocks.SMOOTH_DEEPSLATE, new FabricItemSettings()));
	public static final Item SMOOTH_DEEPSLATE_STAIRS = register("smooth_deepslate_stairs", new BlockItem(JinericBlocks.SMOOTH_DEEPSLATE_STAIRS, new FabricItemSettings()));
	public static final Item SMOOTH_DEEPSLATE_SLAB = register("smooth_deepslate_slab", new BlockItem(JinericBlocks.SMOOTH_DEEPSLATE_SLAB, new FabricItemSettings()));
	public static final Item SMOOTH_DEEPSLATE_WALL = register("smooth_deepslate_wall", new BlockItem(JinericBlocks.SMOOTH_DEEPSLATE_WALL, new FabricItemSettings()));
	public static final Item DARK_PRISMARINE_WALL = register("dark_prismarine_wall", new BlockItem(JinericBlocks.DARK_PRISMARINE_WALL, new FabricItemSettings()));
	public static final Item PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", new BlockItem(JinericBlocks.PRISMARINE_BRICK_WALL, new FabricItemSettings()));
	public static final Item POLISHED_GRANITE_WALL = register("polished_granite_wall", new BlockItem(JinericBlocks.POLISHED_GRANITE_WALL, new FabricItemSettings()));
	public static final Item POLISHED_DIORITE_WALL = register("polished_diorite_wall", new BlockItem(JinericBlocks.POLISHED_DIORITE_WALL, new FabricItemSettings()));
	public static final Item POLISHED_ANDESITE_WALL = register("polished_andesite_wall", new BlockItem(JinericBlocks.POLISHED_ANDESITE_WALL, new FabricItemSettings()));
	public static final Item TUFF_STAIRS = register("tuff_stairs", new BlockItem(JinericBlocks.TUFF_STAIRS, new FabricItemSettings()));
	public static final Item TUFF_SLAB = register("tuff_slab", new BlockItem(JinericBlocks.TUFF_SLAB, new FabricItemSettings()));
	public static final Item TUFF_WALL = register("tuff_wall", new BlockItem(JinericBlocks.TUFF_WALL, new FabricItemSettings()));
	public static final Item CALCITE_STAIRS = register("calcite_stairs", new BlockItem(JinericBlocks.CALCITE_STAIRS, new FabricItemSettings()));
	public static final Item CALCITE_SLAB = register("calcite_slab", new BlockItem(JinericBlocks.CALCITE_SLAB, new FabricItemSettings()));
	public static final Item CALCITE_WALL = register("calcite_wall", new BlockItem(JinericBlocks.CALCITE_WALL, new FabricItemSettings()));
	public static final Item SNOW_BRICKS = register("snow_bricks", new BlockItem(JinericBlocks.SNOW_BRICKS, new FabricItemSettings()));
	public static final Item SNOW_BRICK_STAIRS = register("snow_brick_stairs", new BlockItem(JinericBlocks.SNOW_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item SNOW_BRICK_SLAB = register("snow_brick_slab", new BlockItem(JinericBlocks.SNOW_BRICK_SLAB, new FabricItemSettings()));
	public static final Item SNOW_BRICK_WALL = register("snow_brick_wall", new BlockItem(JinericBlocks.SNOW_BRICK_WALL, new FabricItemSettings()));
	public static final Item SNOW_WALL = register("snow_wall", new BlockItem(JinericBlocks.SNOW_WALL, new FabricItemSettings()));
	public static final Item PACKED_ICE_STAIRS = register("packed_ice_stairs", new BlockItem(JinericBlocks.PACKED_ICE_STAIRS, new FabricItemSettings()));
	public static final Item PACKED_ICE_SLAB = register("packed_ice_slab", new BlockItem(JinericBlocks.PACKED_ICE_SLAB, new FabricItemSettings()));
	public static final Item PACKED_ICE_WALL = register("packed_ice_wall", new BlockItem(JinericBlocks.PACKED_ICE_WALL, new FabricItemSettings()));
	public static final Item OBSIDIAN_STAIRS = register("obsidian_stairs", new BlockItem(JinericBlocks.OBSIDIAN_STAIRS, new FabricItemSettings()));
	public static final Item OBSIDIAN_SLAB = register("obsidian_slab", new BlockItem(JinericBlocks.OBSIDIAN_SLAB, new FabricItemSettings()));
	public static final Item OBSIDIAN_WALL = register("obsidian_wall", new BlockItem(JinericBlocks.OBSIDIAN_WALL, new FabricItemSettings()));
	public static final Item FULL_GRASS_BLOCK = register("full_grass_block", new BlockItem(JinericBlocks.FULL_GRASS_BLOCK, new FabricItemSettings()));
	//NETHER
	public static final Item QUARTZ_WALL = register("quartz_wall", new BlockItem(JinericBlocks.QUARTZ_WALL, new FabricItemSettings()));
	public static final Item SMOOTH_QUARTZ_WALL = register("smooth_quartz_wall", new BlockItem(JinericBlocks.SMOOTH_QUARTZ_WALL, new FabricItemSettings()));
	public static final Item QUARTZ_BRICK_STAIRS = register("quartz_brick_stairs", new BlockItem(JinericBlocks.QUARTZ_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item QUARTZ_BRICK_SLAB = register("quartz_brick_slab", new BlockItem(JinericBlocks.QUARTZ_BRICK_SLAB, new FabricItemSettings()));
	public static final Item QUARTZ_BRICK_WALL = register("quartz_brick_wall", new BlockItem(JinericBlocks.QUARTZ_BRICK_WALL, new FabricItemSettings()));
	public static final Item CRACKED_NETHER_BRICK_STAIRS = register("cracked_nether_brick_stairs", new BlockItem(JinericBlocks.CRACKED_NETHER_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_NETHER_BRICK_SLAB = register("cracked_nether_brick_slab", new BlockItem(JinericBlocks.CRACKED_NETHER_BRICK_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_NETHER_BRICK_WALL = register("cracked_nether_brick_wall", new BlockItem(JinericBlocks.CRACKED_NETHER_BRICK_WALL, new FabricItemSettings()));
	public static final Item RED_NETHER_BRICK_FENCE = register("red_nether_brick_fence", new BlockItem(JinericBlocks.RED_NETHER_BRICK_FENCE, new FabricItemSettings()));
	public static final Item CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = register("cracked_polished_blackstone_brick_stairs", new BlockItem(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, new FabricItemSettings()));
	public static final Item CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = register("cracked_polished_blackstone_brick_slab", new BlockItem(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, new FabricItemSettings()));
	public static final Item CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = register("cracked_polished_blackstone_brick_wall", new BlockItem(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, new FabricItemSettings()));
	public static final Item SMOOTH_BASALT_STAIRS = register("smooth_basalt_stairs", new BlockItem(JinericBlocks.SMOOTH_BASALT_STAIRS, new FabricItemSettings()));
	public static final Item SMOOTH_BASALT_SLAB = register("smooth_basalt_slab", new BlockItem(JinericBlocks.SMOOTH_BASALT_SLAB, new FabricItemSettings()));
	public static final Item SMOOTH_BASALT_WALL = register("smooth_basalt_wall", new BlockItem(JinericBlocks.SMOOTH_BASALT_WALL, new FabricItemSettings()));
	//END
	public static final Item PURPUR_WALL = register("purpur_wall", new BlockItem(JinericBlocks.PURPUR_WALL, new FabricItemSettings()));

//COPPER
	//CUT
	public static final Item CUT_COPPER_WALL = register("cut_copper_wall", new BlockItem(JinericBlocks.CUT_COPPER_WALL, new FabricItemSettings()));
	public static final Item EXPOSED_CUT_COPPER_WALL = register("exposed_cut_copper_wall", new BlockItem(JinericBlocks.EXPOSED_CUT_COPPER_WALL, new FabricItemSettings()));
	public static final Item WEATHERED_CUT_COPPER_WALL = register("weathered_cut_copper_wall", new BlockItem(JinericBlocks.WEATHERED_CUT_COPPER_WALL, new FabricItemSettings()));
	public static final Item OXIDIZED_CUT_COPPER_WALL = register("oxidized_cut_copper_wall", new BlockItem(JinericBlocks.OXIDIZED_CUT_COPPER_WALL, new FabricItemSettings()));
	public static final Item WAXED_CUT_COPPER_WALL = register("waxed_cut_copper_wall", new BlockItem(JinericBlocks.WAXED_CUT_COPPER_WALL, new FabricItemSettings()));
	public static final Item WAXED_EXPOSED_CUT_COPPER_WALL = register("waxed_exposed_cut_copper_wall", new BlockItem(JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL, new FabricItemSettings()));
	public static final Item WAXED_WEATHERED_CUT_COPPER_WALL = register("waxed_weathered_cut_copper_wall", new BlockItem(JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL, new FabricItemSettings()));
	public static final Item WAXED_OXIDIZED_CUT_COPPER_WALL = register("waxed_oxidized_cut_copper_wall", new BlockItem(JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL, new FabricItemSettings()));
//ITEM STORAGE
	public static final Item CHARCOAL_BLOCK = register("charcoal_block", new BlockItem(JinericBlocks.CHARCOAL_BLOCK, new FabricItemSettings()));
	public static final Item FLINT_BLOCK = register("flint_block", new BlockItem(JinericBlocks.FLINT_BLOCK, new FabricItemSettings()));
	public static final Item BONE_MEAL_BLOCK = register("bone_meal_block", new BlockItem(JinericBlocks.BONE_MEAL_BLOCK, new FabricItemSettings()));
	public static final Item PRISMARINE_CRYSTAL_BLOCK = register("prismarine_crystal_block", new BlockItem(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK, new FabricItemSettings()));
	public static final Item SUGAR_BLOCK = register("sugar_block", new BlockItem(JinericBlocks.SUGAR_BLOCK, new FabricItemSettings()));
	public static final Item ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new BlockItem(JinericBlocks.ROTTEN_FLESH_BLOCK, new FabricItemSettings()));
	public static final Item STICK_BLOCK = register("stick_block", new BlockItem(JinericBlocks.STICK_BLOCK, new FabricItemSettings()));
	public static final Item EGG_BLOCK = register("egg_block", new BlockItem(JinericBlocks.EGG_BLOCK, new FabricItemSettings()));
	public static final Item ENDER_PEARL_BLOCK = register("ender_pearl_block", new BlockItem(JinericBlocks.ENDER_PEARL_BLOCK, new FabricItemSettings()));
	public static final Item PAPER_BLOCK = register("paper_block", new BlockItem(JinericBlocks.PAPER_BLOCK, new FabricItemSettings()));
	public static final Item BLAZE_ROD_BLOCK = register("blaze_rod_block", new BlockItem(JinericBlocks.BLAZE_ROD_BLOCK, new FabricItemSettings()));
//BOOKSHELVES
	public static final Item SPRUCE_BOOKSHELF = register("spruce_bookshelf", new BlockItem(JinericBlocks.SPRUCE_BOOKSHELF, new FabricItemSettings()));
	public static final Item BIRCH_BOOKSHELF = register("birch_bookshelf", new BlockItem(JinericBlocks.BIRCH_BOOKSHELF, new FabricItemSettings()));
	public static final Item JUNGLE_BOOKSHELF = register("jungle_bookshelf", new BlockItem(JinericBlocks.JUNGLE_BOOKSHELF, new FabricItemSettings()));
	public static final Item ACACIA_BOOKSHELF = register("acacia_bookshelf", new BlockItem(JinericBlocks.ACACIA_BOOKSHELF, new FabricItemSettings()));
	public static final Item DARK_OAK_BOOKSHELF = register("dark_oak_bookshelf", new BlockItem(JinericBlocks.DARK_OAK_BOOKSHELF, new FabricItemSettings()));
	public static final Item MANGROVE_BOOKSHELF = register("mangrove_bookshelf", new BlockItem(JinericBlocks.MANGROVE_BOOKSHELF, new FabricItemSettings()));
	public static final Item CHERRY_BOOKSHELF = register("cherry_bookshelf", new BlockItem(JinericBlocks.CHERRY_BOOKSHELF, new FabricItemSettings()));
	public static final Item BAMBOO_BOOKSHELF = register("bamboo_bookshelf", new BlockItem(JinericBlocks.BAMBOO_BOOKSHELF, new FabricItemSettings()));
	public static final Item CRIMSON_BOOKSHELF = register("crimson_bookshelf", new BlockItem(JinericBlocks.CRIMSON_BOOKSHELF, new FabricItemSettings()));
	public static final Item WARPED_BOOKSHELF = register("warped_bookshelf", new BlockItem(JinericBlocks.WARPED_BOOKSHELF, new FabricItemSettings()));
//CHESTS
	public static final Item BIRCH_CHEST = register("birch_chest", new BlockItem(JinericBlocks.BIRCH_CHEST, new FabricItemSettings()));
	public static final Item SPRUCE_CHEST = register("spruce_chest", new BlockItem(JinericBlocks.SPRUCE_CHEST, new FabricItemSettings()));
	public static final Item JUNGLE_CHEST = register("jungle_chest", new BlockItem(JinericBlocks.JUNGLE_CHEST, new FabricItemSettings()));
	public static final Item ACACIA_CHEST = register("acacia_chest", new BlockItem(JinericBlocks.ACACIA_CHEST, new FabricItemSettings()));
	public static final Item DARK_OAK_CHEST = register("dark_oak_chest", new BlockItem(JinericBlocks.DARK_OAK_CHEST, new FabricItemSettings()));
	public static final Item MANGROVE_CHEST = register("mangrove_chest", new BlockItem(JinericBlocks.MANGROVE_CHEST, new FabricItemSettings()));
	public static final Item CHERRY_CHEST = register("cherry_chest", new BlockItem(JinericBlocks.CHERRY_CHEST, new FabricItemSettings()));
	public static final Item BAMBOO_CHEST = register("bamboo_chest", new BlockItem(JinericBlocks.BAMBOO_CHEST, new FabricItemSettings()));
	public static final Item CRIMSON_CHEST = register("crimson_chest", new BlockItem(JinericBlocks.CRIMSON_CHEST, new FabricItemSettings()));
	public static final Item WARPED_CHEST = register("warped_chest", new BlockItem(JinericBlocks.WARPED_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_SPRUCE_CHEST = register("trapped_spruce_chest", new BlockItem(JinericBlocks.TRAPPED_SPRUCE_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_BIRCH_CHEST = register("trapped_birch_chest", new BlockItem(JinericBlocks.TRAPPED_BIRCH_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_JUNGLE_CHEST = register("trapped_jungle_chest", new BlockItem(JinericBlocks.TRAPPED_JUNGLE_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_ACACIA_CHEST = register("trapped_acacia_chest", new BlockItem(JinericBlocks.TRAPPED_ACACIA_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_DARK_OAK_CHEST = register("trapped_dark_oak_chest", new BlockItem(JinericBlocks.TRAPPED_DARK_OAK_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_MANGROVE_CHEST = register("trapped_mangrove_chest", new BlockItem(JinericBlocks.TRAPPED_MANGROVE_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_CHERRY_CHEST = register("trapped_cherry_chest", new BlockItem(JinericBlocks.TRAPPED_CHERRY_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_BAMBOO_CHEST = register("trapped_bamboo_chest", new BlockItem(JinericBlocks.TRAPPED_BAMBOO_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_CRIMSON_CHEST = register("trapped_crimson_chest", new BlockItem(JinericBlocks.TRAPPED_CRIMSON_CHEST, new FabricItemSettings()));
	public static final Item TRAPPED_WARPED_CHEST = register("trapped_warped_chest", new BlockItem(JinericBlocks.TRAPPED_WARPED_CHEST, new FabricItemSettings()));
//LADDERS
	public static final Item SPRUCE_LADDER = register("spruce_ladder", new BlockItem(JinericBlocks.SPRUCE_LADDER, new FabricItemSettings()));
	public static final Item BIRCH_LADDER = register("birch_ladder", new BlockItem(JinericBlocks.BIRCH_LADDER, new FabricItemSettings()));
	public static final Item JUNGLE_LADDER = register("jungle_ladder", new BlockItem(JinericBlocks.JUNGLE_LADDER, new FabricItemSettings()));
	public static final Item ACACIA_LADDER = register("acacia_ladder", new BlockItem(JinericBlocks.ACACIA_LADDER, new FabricItemSettings()));
	public static final Item DARK_OAK_LADDER = register("dark_oak_ladder", new BlockItem(JinericBlocks.DARK_OAK_LADDER, new FabricItemSettings()));
	public static final Item MANGROVE_LADDER = register("mangrove_ladder", new BlockItem(JinericBlocks.MANGROVE_LADDER, new FabricItemSettings()));
	public static final Item CHERRY_LADDER = register("cherry_ladder", new BlockItem(JinericBlocks.CHERRY_LADDER, new FabricItemSettings()));
	public static final Item BAMBOO_LADDER = register("bamboo_ladder", new BlockItem(JinericBlocks.BAMBOO_LADDER, new FabricItemSettings()));
	public static final Item WARPED_LADDER = register("warped_ladder", new BlockItem(JinericBlocks.WARPED_LADDER, new FabricItemSettings()));
	public static final Item CRIMSON_LADDER = register("crimson_ladder", new BlockItem(JinericBlocks.CRIMSON_LADDER, new FabricItemSettings()));
//REDSTONE
	public static final Item REDSTONE_LANTERN = register("redstone_lantern", new BlockItem(JinericBlocks.REDSTONE_LANTERN, new FabricItemSettings()));
//FOOD
	public static final Item GOLDEN_POTATO = register("golden_potato", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())));
	public static final Item GOLDEN_SWEET_BERRIES = register("golden_sweet_berries", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).build())));
	public static final Item GOLDEN_BEETROOT = register("golden_beetroot", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1.2f).build())));
//MISC JINERIC
	public static final Item SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new BlockItem(JinericBlocks.SOUL_JACK_O_LANTERN, new FabricItemSettings()));
	public static final Item NETHERITE_HORSE_ARMOR = register("netherite_horse_armor", new JinericHorseArmorItem(15, "netherite", new FabricItemSettings().fireproof().maxCount(1)));

//WIP OR UNKNOWN ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//	public static final Item STONE_UPGRADE_SMITHING_TEMPLATE = register("stone_upgrade_smithing_template", JinericSmithingTemplateItem.createStoneUpgrade());
	public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = register("iron_upgrade_smithing_template", JinericSmithingTemplateItem.createIronUpgrade());

	public static final Item REFINERY = register("refinery", new BlockItem(JinericBlocks.REFINERY, new FabricItemSettings()));
	public static final Item FIREWEED = register("fireweed", new BlockItem(JinericBlocks.FIREWEED, new FabricItemSettings()));
	public static final Item TUMBLEWEED = register("tumbleweed", new BlockItem(JinericBlocks.TUMBLEWEED, new FabricItemSettings()));
	public static final Item REDSTONE_CAMPFIRE = register("redstone_campfire", new BlockItem(JinericBlocks.REDSTONE_CAMPFIRE, new FabricItemSettings()));

//	public static final Item SHULKER_CHEST = register("shulker_chest", new BlockItem(JinericBlocks.SHULKER_CHEST, new FabricItemSettings()));
//	public static final Item MANX_LOAGHTAN_SPAWN_EGG = register("manx_loaghtan_spawn_egg", new SpawnEggItem(JinericEntities.MANX_LOAGHTAN, 0x3f4052, 0x12101d, new FabricItemSettings()));
//	public static final Item SALT = register("salt", new Item(new FabricItemSettings()));
//	public static final Item SALT_BLOCK = register("salt_block", new BlockItem(JinericBlocks.SALT_BLOCK, new FabricItemSettings()));
//	public static final Item FROZEN_ELYTRA = register("frozen_elytra", new JinericElytraItem(new FabricItemSettings().maxDamage(432).equipmentSlot(item -> CHEST).rarity(RARE)));

	// PETRIFIED_OAK
	public static final Item PETRIFIED_OAK_LOG = register("petrified_oak_log", new BlockItem(JinericBlocks.PETRIFIED_OAK_LOG, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_WOOD = register("petrified_oak_wood", new BlockItem(JinericBlocks.PETRIFIED_OAK_WOOD, new FabricItemSettings()));
	public static final Item STRIPPED_PETRIFIED_OAK_LOG = register("stripped_petrified_oak_log", new BlockItem(JinericBlocks.STRIPPED_PETRIFIED_OAK_LOG, new FabricItemSettings()));
	public static final Item STRIPPED_PETRIFIED_OAK_WOOD = register("stripped_petrified_oak_wood", new BlockItem(JinericBlocks.STRIPPED_PETRIFIED_OAK_WOOD, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_PLANKS = register("petrified_oak_planks", new BlockItem(JinericBlocks.PETRIFIED_OAK_PLANKS, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_STAIRS = register("petrified_oak_stairs", new BlockItem(JinericBlocks.PETRIFIED_OAK_STAIRS, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_SLAB = register("petrified_oak_slab", new BlockItem(JinericBlocks.PETRIFIED_OAK_SLAB, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_FENCE = register("petrified_oak_fence", new BlockItem(JinericBlocks.PETRIFIED_OAK_FENCE, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_FENCE_GATE = register("petrified_oak_fence_gate", new BlockItem(JinericBlocks.PETRIFIED_OAK_FENCE_GATE, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_DOOR = register("petrified_oak_door", new BlockItem(JinericBlocks.PETRIFIED_OAK_DOOR, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_TRAPDOOR = register("petrified_oak_trapdoor", new BlockItem(JinericBlocks.PETRIFIED_OAK_TRAPDOOR, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_PRESSURE_PLATE = register("petrified_oak_pressure_plate", new BlockItem(JinericBlocks.PETRIFIED_OAK_PRESSURE_PLATE, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_BUTTON = register("petrified_oak_button", new BlockItem(JinericBlocks.PETRIFIED_OAK_BUTTON, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_LEAVES = register("petrified_oak_leaves", new BlockItem(JinericBlocks.PETRIFIED_OAK_LEAVES, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_SAPLING = register("petrified_oak_sapling", new BlockItem(JinericBlocks.PETRIFIED_OAK_SAPLING, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_LADDER = register("petrified_oak_ladder", new BlockItem(JinericBlocks.PETRIFIED_OAK_LADDER, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_BOOKSHELF = register("petrified_oak_bookshelf", new BlockItem(JinericBlocks.PETRIFIED_OAK_BOOKSHELF, new FabricItemSettings()));
	public static final Item PETRIFIED_OAK_SIGN = register("petrified_oak_sign", new SignItem(new FabricItemSettings().maxCount(16), JinericBlocks.PETRIFIED_OAK_SIGN, JinericBlocks.PETRIFIED_OAK_WALL_SIGN));
	public static final Item PETRIFIED_OAK_HANGING_SIGN = register("petrified_oak_hanging_sign", new HangingSignItem(JinericBlocks.PETRIFIED_OAK_HANGING_SIGN, JinericBlocks.PETRIFIED_OAK_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
	public static final Item PETRIFIED_OAK_BOAT = register("petrified_oak_boat", new BoatItem(false, JinericBoatTypes.PETRIFIED_OAK, new FabricItemSettings().maxCount(1)));
	public static final Item PETRIFIED_OAK_CHEST_BOAT = register("petrified_oak_chest_boat", new BoatItem(true, JinericBoatTypes.PETRIFIED_OAK, new FabricItemSettings().maxCount(1)));

	//RHYOLITE
//	public static final Item RHYOLITE = register("rhyolite", new BlockItem(JinericBlocks.RHYOLITE, new FabricItemSettings()));
//	public static final Item RHYOLITE_STAIRS = register("rhyolite_stairs", new BlockItem(JinericBlocks.RHYOLITE_STAIRS, new FabricItemSettings()));
//	public static final Item RHYOLITE_SLAB = register("rhyolite_slab", new BlockItem(JinericBlocks.RHYOLITE_SLAB, new FabricItemSettings()));
//	public static final Item RHYOLITE_BRICKS = register("rhyolite_bricks", new BlockItem(JinericBlocks.RHYOLITE_BRICKS, new FabricItemSettings()));
//	public static final Item RHYOLITE_BRICK_STAIRS = register("rhyolite_brick_stairs", new BlockItem(JinericBlocks.RHYOLITE_BRICK_STAIRS, new FabricItemSettings()));
//	public static final Item RHYOLITE_BRICK_SLAB = register("rhyolite_brick_slab", new BlockItem(JinericBlocks.RHYOLITE_BRICK_SLAB, new FabricItemSettings()));
//	public static final Item CHISELED_RHYOLITE_BRICKS = register("chiseled_rhyolite_bricks", new BlockItem(JinericBlocks.CHISELED_RHYOLITE_BRICKS, new FabricItemSettings()));
//	public static final Item POLISHED_RHYOLITE = register("polished_rhyolite", new BlockItem(JinericBlocks.POLISHED_RHYOLITE, new FabricItemSettings()));
//	public static final Item POLISHED_RHYOLITE_STAIRS = register("polished_rhyolite_stairs", new BlockItem(JinericBlocks.POLISHED_RHYOLITE_STAIRS, new FabricItemSettings()));
//	public static final Item POLISHED_RHYOLITE_SLAB = register("polished_rhyolite_slab", new BlockItem(JinericBlocks.POLISHED_RHYOLITE_SLAB, new FabricItemSettings()));
//	public static final Item RHYOLITE_TILES = register("rhyolite_tiles", new BlockItem(JinericBlocks.RHYOLITE_TILES, new FabricItemSettings()));
//	public static final Item RHYOLITE_TILE_SLAB = register("rhyolite_tile_slab", new BlockItem(JinericBlocks.RHYOLITE_TILE_SLAB, new FabricItemSettings()));
//	public static final Item RHYOLITE_TILE_STAIRS = register("rhyolite_tile_stairs", new BlockItem(JinericBlocks.RHYOLITE_TILE_STAIRS, new FabricItemSettings()));
//	public static final Item SMOOTH_RHYOLITE = register("smooth_rhyolite", new BlockItem(JinericBlocks.SMOOTH_RHYOLITE, new FabricItemSettings()));
//	public static final Item SMOOTH_RHYOLITE_SLAB = register("smooth_rhyolite_slab", new BlockItem(JinericBlocks.SMOOTH_RHYOLITE_SLAB, new FabricItemSettings()));
//	public static final Item SMOOTH_RHYOLITE_STAIRS = register("smooth_rhyolite_stairs", new BlockItem(JinericBlocks.SMOOTH_RHYOLITE_STAIRS, new FabricItemSettings()));
//	public static final Item SMOOTH_RHYOLITE_WALL = register("smooth_rhyolite_wall", new BlockItem(JinericBlocks.SMOOTH_RHYOLITE_WALL, new FabricItemSettings()));
//	public static final Item RHYOLITE_WALL = register("rhyolite_wall", new BlockItem(JinericBlocks.RHYOLITE_WALL, new FabricItemSettings()));
//	public static final Item RHYOLITE_BRICK_WALL = register("rhyolite_brick_wall", new BlockItem(JinericBlocks.RHYOLITE_BRICK_WALL, new FabricItemSettings()));
//	public static final Item POLISHED_RHYOLITE_WALL = register("polished_rhyolite_wall", new BlockItem(JinericBlocks.POLISHED_RHYOLITE_WALL, new FabricItemSettings()));
//	public static final Item RHYOLITE_TILE_WALL = register("rhyolite_tile_wall", new BlockItem(JinericBlocks.RHYOLITE_TILE_WALL, new FabricItemSettings()));
	//CALCITE
//	public static final Item POLISHED_CALCITE = register("polished_calcite", new BlockItem(JinericBlocks.POLISHED_CALCITE, new FabricItemSettings()));
//	public static final Item POLISHED_CALCITE_STAIRS = register("polished_calcite_stairs", new BlockItem(JinericBlocks.POLISHED_CALCITE_STAIRS, new FabricItemSettings()));
//	public static final Item POLISHED_CALCITE_SLAB = register("polished_calcite_slab", new BlockItem(JinericBlocks.POLISHED_CALCITE_SLAB, new FabricItemSettings()));
//	public static final Item POLISHED_CALCITE_WALL = register("polished_calcite_wall", new BlockItem(JinericBlocks.POLISHED_CALCITE_WALL, new FabricItemSettings()));
//	public static final Item CALCITE_BRICKS = register("calcite_bricks", new BlockItem(JinericBlocks.CALCITE_BRICKS, new FabricItemSettings()));
//	public static final Item CALCITE_BRICK_STAIRS = register("calcite_brick_stairs", new BlockItem(JinericBlocks.CALCITE_BRICK_STAIRS, new FabricItemSettings()));
//	public static final Item CALCITE_BRICK_SLAB = register("calcite_brick_slab", new BlockItem(JinericBlocks.CALCITE_BRICK_SLAB, new FabricItemSettings()));
//	public static final Item CALCITE_BRICK_WALL = register("calcite_brick_wall", new BlockItem(JinericBlocks.CALCITE_BRICK_WALL, new FabricItemSettings()));
//	public static final Item SMOOTH_CALCITE = register("smooth_calcite", new BlockItem(JinericBlocks.SMOOTH_CALCITE, new FabricItemSettings()));
//	public static final Item SMOOTH_CALCITE_STAIRS = register("smooth_calcite_stairs", new BlockItem(JinericBlocks.SMOOTH_CALCITE_STAIRS, new FabricItemSettings()));
//	public static final Item SMOOTH_CALCITE_SLAB = register("smooth_calcite_slab", new BlockItem(JinericBlocks.SMOOTH_CALCITE_SLAB, new FabricItemSettings()));
//	public static final Item SMOOTH_CALCITE_WALL = register("smooth_calcite_wall", new BlockItem(JinericBlocks.SMOOTH_CALCITE_WALL, new FabricItemSettings()));

	private static Item register(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(JinericMain.MOD_ID, name), item);
	}
}

