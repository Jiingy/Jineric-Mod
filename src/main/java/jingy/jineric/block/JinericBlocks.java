package jingy.jineric.block;

import jingy.jineric.base.JinericMain;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.registry.JinericBlockSettings;
import jingy.jineric.sound.JinericSoundGroups;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;

public class JinericBlocks {

//SANDSTONE
	public static final Block CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new StairsBlock(CUT_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(CUT_SANDSTONE)));
	public static final Block CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new WallBlock(FabricBlockSettings.copy(CUT_SANDSTONE)));
	public static final Block POLISHED_SANDSTONE = register("polished_sandstone", new Block(FabricBlockSettings.copy(SANDSTONE)));
	public static final Block POLISHED_SANDSTONE_STAIRS = register("polished_sandstone_stairs", new StairsBlock(POLISHED_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(POLISHED_SANDSTONE)));
	public static final Block POLISHED_SANDSTONE_SLAB  = register("polished_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_SANDSTONE)));
	public static final Block POLISHED_SANDSTONE_WALL = register("polished_sandstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_SANDSTONE)));
	public static final Block SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_SANDSTONE)));
	public static final Block WAVY_SANDSTONE = register("wavy_sandstone", new Block(FabricBlockSettings.copy(SANDSTONE)));
	public static final Block WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new StairsBlock(WAVY_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(WAVY_SANDSTONE)));
	public static final Block WAVY_SANDSTONE_SLAB  = register("wavy_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_SANDSTONE)));
	public static final Block WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_SANDSTONE)));
//RED SAND
	public static final Block CUT_RED_SANDSTONE_STAIRS = register("cut_red_sandstone_stairs", new StairsBlock(RED_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(RED_SANDSTONE)));
	public static final Block CUT_RED_SANDSTONE_WALL = register("cut_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE = register("polished_red_sandstone", new Block(FabricBlockSettings.copy(RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE_STAIRS = register("polished_red_sandstone_stairs", new StairsBlock(POLISHED_RED_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE_SLAB  = register("polished_red_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE_WALL = register("polished_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block SMOOTH_RED_SANDSTONE_WALL = register("smooth_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(RED_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new Block(FabricBlockSettings.copy(RED_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new StairsBlock(WAVY_RED_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(WAVY_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE_SLAB  = register("wavy_red_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_RED_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_RED_SANDSTONE)));
//SOUL SAND
	public static final Block SOUL_SANDSTONE = register("soul_sandstone", new Block(FabricBlockSettings.copy(SANDSTONE).sounds(JinericSoundGroups.SOUL_SANDSTONE)));
	public static final Block SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new StairsBlock(SOUL_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block SOUL_SANDSTONE_SLAB  = register("soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings()));
	public static final Block CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new StairsBlock(CUT_SOUL_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(CUT_SOUL_SANDSTONE)));
	public static final Block CUT_SOUL_SANDSTONE_SLAB  = register("cut_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(CUT_SOUL_SANDSTONE)));
	public static final Block CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(CUT_SOUL_SANDSTONE)));
	public static final Block POLISHED_SOUL_SANDSTONE = register("polished_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings()));
	public static final Block POLISHED_SOUL_SANDSTONE_STAIRS = register("polished_soul_sandstone_stairs", new StairsBlock(POLISHED_SOUL_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(POLISHED_SOUL_SANDSTONE)));
	public static final Block POLISHED_SOUL_SANDSTONE_SLAB  = register("polished_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_SOUL_SANDSTONE)));
	public static final Block POLISHED_SOUL_SANDSTONE_WALL = register("polished_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_SOUL_SANDSTONE)));
	public static final Block CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings()));
	public static final Block SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings()));
	public static final Block SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new StairsBlock(SMOOTH_SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SMOOTH_SOUL_SANDSTONE)));
	public static final Block SMOOTH_SOUL_SANDSTONE_SLAB  = register("smooth_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_SOUL_SANDSTONE)));
	public static final Block SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_SOUL_SANDSTONE)));
	public static final Block WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings().sounds(BlockSoundGroup.SOUL_SOIL)));
	public static final Block WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new StairsBlock(WAVY_SOUL_SANDSTONE.getDefaultState(), FabricBlockSettings.copy(WAVY_SOUL_SANDSTONE)));
	public static final Block WAVY_SOUL_SANDSTONE_SLAB  = register("wavy_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_SOUL_SANDSTONE)));
	public static final Block WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_SOUL_SANDSTONE)));

	// --- STONE TYPE BLOCKS ---
//STONE
	public static final Block STONE_WALL = register("stone_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	public static final Block SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", new StairsBlock(SMOOTH_STONE.getDefaultState(), FabricBlockSettings.copy(SMOOTH_STONE)));
	public static final Block SMOOTH_STONE_WALL = register("smooth_stone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_STONE)));
	public static final Block POLISHED_STONE = register("polished_stone", new Block(FabricBlockSettings.copy(STONE)));
	public static final Block POLISHED_STONE_STAIRS = register("polished_stone_stairs", new StairsBlock(POLISHED_STONE.getDefaultState(), FabricBlockSettings.copy(POLISHED_STONE)));
	public static final Block POLISHED_STONE_SLAB = register("polished_stone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_STONE)));
	public static final Block POLISHED_STONE_WALL = register("polished_stone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_STONE)));
	public static final Block CRACKED_STONE_BRICK_STAIRS = register("cracked_stone_brick_stairs", new StairsBlock(STONE.getDefaultState(), FabricBlockSettings.copy(STONE)));
	public static final Block CRACKED_STONE_BRICK_SLAB  = register("cracked_stone_brick_slab", new SlabBlock(FabricBlockSettings.copy(STONE)));
	public static final Block CRACKED_STONE_BRICK_WALL = register("cracked_stone_brick_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	public static final Block STONE_PILLAR = register("stone_pillar", new PillarBlock(FabricBlockSettings.copy(STONE)));
	public static final Block STONE_TILES = register("stone_tiles", new Block(FabricBlockSettings.copy(STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE_TILES)));
	public static final Block STONE_TILE_STAIRS = register("stone_tile_stairs", new StairsBlock(STONE_TILES.getDefaultState(), FabricBlockSettings.copy(STONE_TILES)));
	public static final Block STONE_TILE_SLAB = register("stone_tile_slab", new SlabBlock(FabricBlockSettings.copy(STONE_TILES)));
	public static final Block STONE_TILE_WALL = register("stone_tile_wall", new WallBlock(FabricBlockSettings.copy(STONE_TILES)));

//DEEPSLATE
	public static final Block CRACKED_DEEPSLATE_BRICK_STAIRS = register("cracked_deepslate_brick_stairs", new StairsBlock(CRACKED_DEEPSLATE_BRICKS.getDefaultState(), FabricBlockSettings.copy(CRACKED_DEEPSLATE_BRICKS)));
	public static final Block CRACKED_DEEPSLATE_BRICK_SLAB = register("cracked_deepslate_brick_slab", new SlabBlock(FabricBlockSettings.copy(CRACKED_DEEPSLATE_BRICKS)));
	public static final Block CRACKED_DEEPSLATE_BRICK_WALL = register("cracked_deepslate_brick_wall", new WallBlock(FabricBlockSettings.copy(CRACKED_DEEPSLATE_BRICKS)));
	public static final Block CRACKED_DEEPSLATE_TILE_STAIRS = register("cracked_deepslate_tile_stairs", new StairsBlock(CRACKED_DEEPSLATE_TILES.getDefaultState(), FabricBlockSettings.copy(CRACKED_DEEPSLATE_TILES)));
	public static final Block CRACKED_DEEPSLATE_TILE_SLAB = register("cracked_deepslate_tile_slab", new SlabBlock(FabricBlockSettings.copy(CRACKED_DEEPSLATE_TILES)));
	public static final Block CRACKED_DEEPSLATE_TILE_WALL = register("cracked_deepslate_tile_wall", new WallBlock(FabricBlockSettings.copy(CRACKED_DEEPSLATE_TILES)));
	public static final Block SMOOTH_DEEPSLATE = register("smooth_deepslate", new Block(FabricBlockSettings.copy(DEEPSLATE)));
	public static final Block SMOOTH_DEEPSLATE_STAIRS = register("smooth_deepslate_stairs", new StairsBlock(SMOOTH_DEEPSLATE.getDefaultState(), FabricBlockSettings.copy(SMOOTH_DEEPSLATE)));
	public static final Block SMOOTH_DEEPSLATE_SLAB = register("smooth_deepslate_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_DEEPSLATE)));
	public static final Block SMOOTH_DEEPSLATE_WALL = register("smooth_deepslate_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_DEEPSLATE)));

//DIORITE, GRANITE, ANDESITE
	public static final Block POLISHED_GRANITE_WALL = register("polished_granite_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_GRANITE)));
	public static final Block POLISHED_DIORITE_WALL = register("polished_diorite_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_DIORITE)));
	public static final Block POLISHED_ANDESITE_WALL = register("polished_andesite_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_ANDESITE)));

//TUFF
	public static final Block COBBLED_TUFF = register("cobbled_tuff", new Block(Block.Settings.copy(TUFF)));
	public static final Block COBBLED_TUFF_SLAB = register("cobbled_tuff_slab", new SlabBlock(Block.Settings.copy(COBBLED_TUFF)));
	public static final Block COBBLED_TUFF_STAIRS = register("cobbled_tuff_stairs", new StairsBlock(COBBLED_TUFF.getDefaultState(), Block.Settings.copy(COBBLED_TUFF)));
	public static final Block COBBLED_TUFF_WALL = register("cobbled_tuff_wall", new WallBlock(Block.Settings.copy(COBBLED_TUFF)));
	public static final Block TUFF_STAIRS = register("tuff_stairs", new StairsBlock(TUFF.getDefaultState(), FabricBlockSettings.copy(TUFF)));
	public static final Block TUFF_SLAB = register("tuff_slab", new SlabBlock(FabricBlockSettings.copy(TUFF)));
	public static final Block TUFF_WALL = register("tuff_wall", new WallBlock(FabricBlockSettings.copy(TUFF)));
	public static final Block SMOOTH_TUFF = register("smooth_tuff", new Block(FabricBlockSettings.copy(TUFF)));
	public static final Block SMOOTH_TUFF_SLAB = register("smooth_tuff_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_TUFF)));
	public static final Block SMOOTH_TUFF_STAIRS = register("smooth_tuff_stairs", new StairsBlock(SMOOTH_TUFF.getDefaultState(), FabricBlockSettings.copy(SMOOTH_TUFF)));
	public static final Block SMOOTH_TUFF_WALL = register("smooth_tuff_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_TUFF)));
	public static final Block POLISHED_TUFF = register("polished_tuff", new Block(FabricBlockSettings.copy(TUFF)));
	public static final Block POLISHED_TUFF_STAIRS = register("polished_tuff_stairs", new StairsBlock(POLISHED_TUFF.getDefaultState(), FabricBlockSettings.copy(POLISHED_TUFF)));
	public static final Block POLISHED_TUFF_SLAB = register("polished_tuff_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_TUFF)));
	public static final Block POLISHED_TUFF_WALL = register("polished_tuff_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_TUFF)));
	public static final Block TUFF_BRICKS = register("tuff_bricks", new Block(FabricBlockSettings.copy(TUFF)));
	public static final Block TUFF_BRICK_SLAB = register("tuff_brick_slab", new SlabBlock(FabricBlockSettings.copy(TUFF_BRICKS)));
	public static final Block TUFF_BRICK_STAIRS = register("tuff_brick_stairs", new StairsBlock(TUFF_BRICKS.getDefaultState(), FabricBlockSettings.copy(TUFF_BRICKS)));
	public static final Block TUFF_BRICK_WALL = register("tuff_brick_wall", new WallBlock(FabricBlockSettings.copy(TUFF_BRICKS)));
	public static final Block CRACKED_TUFF_BRICKS = register("cracked_tuff_bricks", new Block(FabricBlockSettings.copy(TUFF_BRICKS)));
	public static final Block CRACKED_TUFF_BRICK_SLAB = register("cracked_tuff_brick_slab", new SlabBlock(FabricBlockSettings.copy(CRACKED_TUFF_BRICKS)));
	public static final Block CRACKED_TUFF_BRICK_STAIRS = register("cracked_tuff_brick_stairs", new StairsBlock(CRACKED_TUFF_BRICKS.getDefaultState(), FabricBlockSettings.copy(CRACKED_TUFF_BRICKS)));
	public static final Block CRACKED_TUFF_BRICK_WALL = register("cracked_tuff_brick_wall", new WallBlock(FabricBlockSettings.copy(CRACKED_TUFF_BRICKS)));
	public static final Block CHISELED_TUFF = register("chiseled_tuff", new Block(Block.Settings.copy(TUFF_BRICKS)));
	public static final Block TUFF_PILLAR = register("tuff_pillar", new PillarBlock(Block.Settings.copy(TUFF_BRICKS)));
	public static final Block TUFF_TILES = register("tuff_tiles", new Block(Block.Settings.copy(STONE_TILES)));
	public static final Block TUFF_TILE_STAIRS = register("tuff_tile_stairs", new StairsBlock(TUFF_TILES.getDefaultState(), Block.Settings.copy(TUFF_TILES)));
	public static final Block TUFF_TILE_SLAB = register("tuff_tile_slab", new SlabBlock(Block.Settings.copy(TUFF_TILES)));
	public static final Block TUFF_TILE_WALL = register("tuff_tile_wall", new WallBlock(Block.Settings.copy(TUFF_TILES)));


	//CALCITE
	public static final Block CALCITE_STAIRS = register("calcite_stairs", new StairsBlock(CALCITE.getDefaultState(), FabricBlockSettings.copy(CALCITE))	);
	public static final Block CALCITE_SLAB = register("calcite_slab", new SlabBlock(FabricBlockSettings.copy(CALCITE)));
	public static final Block CALCITE_WALL = register("calcite_wall", new WallBlock(FabricBlockSettings.copy(CALCITE)));
//	public static final Block POLISHED_CALCITE = register("polished_calcite", new Block(FabricBlockSettings.copy(CALCITE)));
//	public static final Block POLISHED_CALCITE_STAIRS = register("polished_calcite_stairs", new StairsBlock(POLISHED_CALCITE.getDefaultState(), FabricBlockSettings.copy(POLISHED_CALCITE)));
//	public static final Block POLISHED_CALCITE_SLAB = register("polished_calcite_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_CALCITE)));
//	public static final Block POLISHED_CALCITE_WALL = register("polished_calcite_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_CALCITE)));
//	public static final Block CALCITE_BRICKS = register("calcite_bricks", new Block(FabricBlockSettings.copy(CALCITE)));
//	public static final Block CALCITE_BRICK_STAIRS = register("calcite_brick_stairs", new StairsBlock(CALCITE_BRICKS.getDefaultState(), FabricBlockSettings.copy(CALCITE_BRICKS)));
//	public static final Block CALCITE_BRICK_SLAB = register("calcite_brick_slab", new SlabBlock(FabricBlockSettings.copy(CALCITE_BRICKS)));
//	public static final Block CALCITE_BRICK_WALL = register("calcite_brick_wall", new WallBlock(FabricBlockSettings.copy(CALCITE_BRICKS)));
//	public static final Block SMOOTH_CALCITE = register("smooth_calcite", new Block(FabricBlockSettings.copy(CALCITE)));
//	public static final Block SMOOTH_CALCITE_STAIRS = register("smooth_calcite_stairs", new StairsBlock(SMOOTH_CALCITE.getDefaultState(), FabricBlockSettings.copy(SMOOTH_CALCITE)));
//	public static final Block SMOOTH_CALCITE_SLAB = register("smooth_calcite_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_CALCITE)));
//	public static final Block SMOOTH_CALCITE_WALL = register("smooth_calcite_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_CALCITE)));

//DRIPSTONE
	public static final Block DRIPSTONE_SLAB = register("dripstone_slab", new SlabBlock(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block DRIPSTONE_STAIRS = register("dripstone_stairs", new StairsBlock(DRIPSTONE_BLOCK.getDefaultState(), FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block DRIPSTONE_WALL = register("dripstone_wall", new WallBlock(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block COBBLED_DRIPSTONE = register("cobbled_dripstone", new Block(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block COBBLED_DRIPSTONE_SLAB  = register("cobbled_dripstone_slab", new SlabBlock(FabricBlockSettings.copy(COBBLED_DRIPSTONE)));
	public static final Block COBBLED_DRIPSTONE_STAIRS = register("cobbled_dripstone_stairs", new StairsBlock(COBBLED_DRIPSTONE.getDefaultState(), FabricBlockSettings.copy(COBBLED_DRIPSTONE)));
	public static final Block COBBLED_DRIPSTONE_WALL = register("cobbled_dripstone_wall", new WallBlock(FabricBlockSettings.copy(COBBLED_DRIPSTONE)));
	public static final Block DRIPSTONE_BRICKS = register("dripstone_bricks", new Block(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block DRIPSTONE_BRICK_SLAB = register("dripstone_brick_slab", new SlabBlock(FabricBlockSettings.copy(DRIPSTONE_BRICKS)));
	public static final Block DRIPSTONE_BRICK_STAIRS = register("dripstone_brick_stairs", new StairsBlock(DRIPSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(DRIPSTONE_BRICKS)));
	public static final Block DRIPSTONE_BRICK_WALL = register("dripstone_brick_wall", new WallBlock(FabricBlockSettings.copy(DRIPSTONE_BRICKS)));
	public static final Block CRACKED_DRIPSTONE_BRICKS = register("cracked_dripstone_bricks", new Block(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block CRACKED_DRIPSTONE_BRICK_SLAB = register("cracked_dripstone_brick_slab", new SlabBlock(FabricBlockSettings.copy(DRIPSTONE_BRICKS)));
	public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS = register("cracked_dripstone_brick_stairs", new StairsBlock(DRIPSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(DRIPSTONE_BRICKS)));
	public static final Block CRACKED_DRIPSTONE_BRICK_WALL = register("cracked_dripstone_brick_wall", new WallBlock(FabricBlockSettings.copy(DRIPSTONE_BRICKS)));
	public static final Block POLISHED_DRIPSTONE = register("polished_dripstone", new Block(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block POLISHED_DRIPSTONE_SLAB  = register("polished_dripstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_DRIPSTONE)));
	public static final Block POLISHED_DRIPSTONE_STAIRS = register("polished_dripstone_stairs", new StairsBlock(STONE.getDefaultState(), FabricBlockSettings.copy(POLISHED_DRIPSTONE)));
	public static final Block POLISHED_DRIPSTONE_WALL = register("polished_dripstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_DRIPSTONE)));
	public static final Block DRIPSTONE_TILES = register("dripstone_tiles", new Block(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block DRIPSTONE_TILE_SLAB = register("dripstone_tile_slab", new SlabBlock(FabricBlockSettings.copy(DRIPSTONE_TILES)));
	public static final Block DRIPSTONE_TILE_STAIRS = register("dripstone_tile_stairs", new StairsBlock(DRIPSTONE_TILES.getDefaultState(), FabricBlockSettings.copy(DRIPSTONE_TILES)));
	public static final Block DRIPSTONE_TILE_WALL = register("dripstone_tile_wall", new WallBlock(FabricBlockSettings.copy(DRIPSTONE_TILES)));
	public static final Block SMOOTH_DRIPSTONE = register("smooth_dripstone", new Block(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block SMOOTH_DRIPSTONE_SLAB  = register("smooth_dripstone_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_DRIPSTONE)));
	public static final Block SMOOTH_DRIPSTONE_STAIRS = register("smooth_dripstone_stairs", new StairsBlock(SMOOTH_DRIPSTONE.getDefaultState(), FabricBlockSettings.copy(SMOOTH_DRIPSTONE)));
	public static final Block SMOOTH_DRIPSTONE_WALL = register("smooth_dripstone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_DRIPSTONE)));
	public static final Block CHISELED_DRIPSTONE = register("chiseled_dripstone", new Block(FabricBlockSettings.copy(DRIPSTONE_BRICKS)));
	public static final Block DRIPSTONE_PILLAR = register("dripstone_pillar", new PillarBlock(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));

//OBSIDIAN
	public static final Block OBSIDIAN_STAIRS = register("obsidian_stairs", new StairsBlock(OBSIDIAN.getDefaultState(), JinericBlockSettings.obsidianSettings().nonOpaque()));
	public static final Block OBSIDIAN_SLAB  = register("obsidian_slab", new SlabBlock(JinericBlockSettings.obsidianSettings().nonOpaque()));
	public static final Block OBSIDIAN_WALL = register("obsidian_wall", new WallBlock(JinericBlockSettings.obsidianSettings().nonOpaque()));

//NETHER
	public static final Block QUARTZ_WALL = register("quartz_wall", new WallBlock(FabricBlockSettings.copy(QUARTZ_BLOCK)));
	public static final Block SMOOTH_QUARTZ_WALL = register("smooth_quartz_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_QUARTZ)));
	public static final Block QUARTZ_BRICK_SLAB = register("quartz_brick_slab", new SlabBlock(FabricBlockSettings.copy(QUARTZ_BRICKS)));
	public static final Block QUARTZ_BRICK_STAIRS = register("quartz_brick_stairs", new StairsBlock(QUARTZ_BRICKS.getDefaultState(), FabricBlockSettings.copy(QUARTZ_BRICKS)));
	public static final Block QUARTZ_BRICK_WALL = register("quartz_brick_wall", new WallBlock(FabricBlockSettings.copy(QUARTZ_BRICKS)));
	public static final Block SMOOTH_BASALT_SLAB = register("smooth_basalt_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_BASALT)));
	public static final Block SMOOTH_BASALT_STAIRS = register("smooth_basalt_stairs", new StairsBlock(SMOOTH_BASALT.getDefaultState(), FabricBlockSettings.copy(SMOOTH_BASALT)));
	public static final Block SMOOTH_BASALT_WALL = register("smooth_basalt_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_BASALT)));
	public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = register("cracked_polished_blackstone_brick_slab", new SlabBlock(FabricBlockSettings.copy(CRACKED_POLISHED_BLACKSTONE_BRICKS)));
	public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = register("cracked_polished_blackstone_brick_stairs", new StairsBlock(CRACKED_POLISHED_BLACKSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(CRACKED_POLISHED_BLACKSTONE_BRICKS)));
	public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = register("cracked_polished_blackstone_brick_wall", new WallBlock(FabricBlockSettings.copy(CRACKED_POLISHED_BLACKSTONE_BRICKS)));
	public static final Block RED_NETHER_BRICK_FENCE = register("red_nether_brick_fence", new FenceBlock(FabricBlockSettings.copy(NETHER_BRICK_FENCE)));
	public static final Block CRACKED_NETHER_BRICK_SLAB = register("cracked_nether_brick_slab", new SlabBlock(Block.Settings.copy(CRACKED_NETHER_BRICKS)));
	public static final Block CRACKED_NETHER_BRICK_STAIRS = register("cracked_nether_brick_stairs", new StairsBlock(CRACKED_NETHER_BRICKS.getDefaultState(), Block.Settings.copy(CRACKED_NETHER_BRICKS)));
	public static final Block CRACKED_NETHER_BRICK_WALL = register("cracked_nether_brick_wall", new WallBlock(Block.Settings.copy(CRACKED_NETHER_BRICKS)));

//END
	public static final Block PURPUR_WALL = register("purpur_wall", new WallBlock(FabricBlockSettings.copy(PURPUR_BLOCK)));

//RHYOLITE
//	public static final Block RHYOLITE = register("rhyolite", new Block(FabricBlockSettings.copy(STONE)));
//	public static final Block RHYOLITE_STAIRS = register("rhyolite_stairs", new StairsBlock(STONE.getDefaultState(), FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block RHYOLITE_SLAB  = register("rhyolite_slab", new SlabBlock(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block RHYOLITE_WALL = register("rhyolite_wall", new WallBlock(FabricBlockSettings.copy(RHYOLITE)));

	//COBBLED
//	public static final Block COBBLED_RHYOLITE = register("cobbled_rhyolite", new Block(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block COBBLED_RHYOLITE_STAIRS = register("cobbled_rhyolite_stairs", new StairsBlock(RHYOLITE.getDefaultState(), FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block COBBLED_RHYOLITE_SLAB  = register("cobbled_rhyolite_slab", new SlabBlock(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block COBBLED_RHYOLITE_WALL = register("cobbled_rhyolite_wall", new WallBlock(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block SMOOTH_RHYOLITE = register("smooth_rhyolite", new Block(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block SMOOTH_RHYOLITE_STAIRS = register("smooth_rhyolite_stairs", new StairsBlock(SMOOTH_RHYOLITE.getDefaultState(), FabricBlockSettings.copy(SMOOTH_RHYOLITE)));
//	public static final Block SMOOTH_RHYOLITE_SLAB  = register("smooth_rhyolite_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_RHYOLITE)));
//	public static final Block SMOOTH_RHYOLITE_WALL = register("smooth_rhyolite_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_RHYOLITE)));
//	public static final Block RHYOLITE_BRICKS = register("rhyolite_bricks", new Block(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block RHYOLITE_BRICK_STAIRS = register("rhyolite_brick_stairs", new StairsBlock(RHYOLITE_BRICKS.getDefaultState(), FabricBlockSettings.copy(RHYOLITE_BRICKS)));
//	public static final Block RHYOLITE_BRICK_SLAB  = register("rhyolite_brick_slab", new SlabBlock(FabricBlockSettings.copy(RHYOLITE_BRICKS)));
//	public static final Block RHYOLITE_BRICK_WALL = register("rhyolite_brick_wall", new WallBlock(FabricBlockSettings.copy(RHYOLITE_BRICKS)));
//	public static final Block CHISELED_RHYOLITE_BRICKS = register("chiseled_rhyolite_bricks", new Block(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block RHYOLITE_TILES = register("rhyolite_tiles", new Block(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block RHYOLITE_TILE_STAIRS = register("rhyolite_tile_stairs", new StairsBlock(RHYOLITE_TILES.getDefaultState(), FabricBlockSettings.copy(RHYOLITE_TILES)));
//	public static final Block RHYOLITE_TILE_SLAB  = register("rhyolite_tile_slab", new SlabBlock(FabricBlockSettings.copy(RHYOLITE_TILES)));
//	public static final Block RHYOLITE_TILE_WALL = register("rhyolite_tile_wall", new WallBlock(FabricBlockSettings.copy(RHYOLITE_TILES)));
//	public static final Block POLISHED_RHYOLITE = register("polished_rhyolite", new Block(FabricBlockSettings.copy(RHYOLITE)));
//	public static final Block POLISHED_RHYOLITE_STAIRS = register("polished_rhyolite_stairs", new StairsBlock(POLISHED_RHYOLITE.getDefaultState(), FabricBlockSettings.copy(POLISHED_RHYOLITE)));
//	public static final Block POLISHED_RHYOLITE_SLAB  = register("polished_rhyolite_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_RHYOLITE)));
//	public static final Block POLISHED_RHYOLITE_WALL = register("polished_rhyolite_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_RHYOLITE)));

	// --- MISCELLANEOUS ---
//PACKED ITEM BLOCKS
	public static final Block SUGAR_BLOCK = register("sugar_block", new FallingBlock(FabricBlockSettings.copy(CLAY).sounds(BlockSoundGroup.SAND)));
	public static final Block ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new Block(FabricBlockSettings.copy(HONEYCOMB_BLOCK).sounds(BlockSoundGroup.HONEY)));
	public static final Block FLINT_BLOCK = register("flint_block", new Block(FabricBlockSettings.copy(STONE)));
	public static final Block CHARCOAL_BLOCK = register("charcoal_block", new Block(FabricBlockSettings.copy(COAL_BLOCK)));
	public static final Block TUMBLEWEED = register("tumbleweed", JinericBlockSettings.JinericLeavesBlock(BlockSoundGroup.GRASS));
	public static final Block BONE_MEAL_BLOCK = register("bone_meal_block", new Block(FabricBlockSettings.copy(BONE_BLOCK)));
	public static final Block ENDER_PEARL_BLOCK = register("ender_pearl_block", new Block(FabricBlockSettings.copy(HONEY_BLOCK)));
	public static final Block PRISMARINE_CRYSTAL_BLOCK = register("prismarine_crystal_block", new Block(FabricBlockSettings.copy(SEA_LANTERN).luminance(state -> 4).requiresTool()));
//	public static final Block GUNPOWDER_BLOCK = register("gunpowder_block", new Block(FabricBlockSettings.copy(SAND)));
	public static final Block BLAZE_ROD_BLOCK = register("blaze_rod_block", new Block(FabricBlockSettings.copy(CHARCOAL_BLOCK)));
	public static final Block EGG_BLOCK = register("egg_block", new Block(FabricBlockSettings.copy(CALCITE).sounds(BlockSoundGroup.CALCITE).strength(0.50F)));
	public static final Block STICK_BLOCK = register("stick_block", new PillarBlock(FabricBlockSettings.copy(OAK_PLANKS)));
	public static final Block PAPER_BLOCK = register("paper_block", new Block(FabricBlockSettings.copy(AZALEA_LEAVES).sounds(BlockSoundGroup.AZALEA_LEAVES)));

//PACKED ICE
	public static final Block PACKED_ICE_STAIRS = register("packed_ice_stairs", new StairsBlock(PACKED_ICE.getDefaultState(), FabricBlockSettings.copy(PACKED_ICE)));
	public static final Block PACKED_ICE_SLAB  = register("packed_ice_slab", new SlabBlock(FabricBlockSettings.copy(PACKED_ICE)));
	public static final Block PACKED_ICE_WALL = register("packed_ice_wall", new WallBlock(FabricBlockSettings.copy(PACKED_ICE)));

//SNOW & POWDERED SNOW
	public static final Block SNOW_WALL = register("snow_wall", new WallBlock(FabricBlockSettings.copy(SNOW_BLOCK)));

//DECORATION BLOCKS
	public static final Block FIREWEED = register("fireweed", new TallFlowerBlock(FabricBlockSettings.copy(LILAC)));
	public static final Block SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new CarvedPumpkinBlock(FabricBlockSettings.copy(JACK_O_LANTERN)));
	public static final Block FULL_GRASS_BLOCK = register("full_grass_block", new FullGrassBlock(FabricBlockSettings.copy(GRASS_BLOCK)));
	public static final Block PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", new WallBlock(FabricBlockSettings.copy(PRISMARINE_BRICKS)));
	public static final Block DARK_PRISMARINE_WALL = register("dark_prismarine_wall", new WallBlock(FabricBlockSettings.copy(DARK_PRISMARINE)));
	public static final Block CUT_COPPER_WALL = register("cut_copper_wall", new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copy(CUT_COPPER)));
	public static final Block EXPOSED_CUT_COPPER_WALL = register("exposed_cut_copper_wall", new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copy(EXPOSED_CUT_COPPER)));
	public static final Block WEATHERED_CUT_COPPER_WALL = register("weathered_cut_copper_wall", new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copy(WEATHERED_CUT_COPPER)));
	public static final Block OXIDIZED_CUT_COPPER_WALL = register("oxidized_cut_copper_wall", new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copy(OXIDIZED_CUT_COPPER)));
	public static final Block WAXED_CUT_COPPER_WALL = register("waxed_cut_copper_wall", new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copy(CUT_COPPER)));
	public static final Block WAXED_EXPOSED_CUT_COPPER_WALL = register("waxed_exposed_cut_copper_wall", new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copy(EXPOSED_CUT_COPPER)));
	public static final Block WAXED_WEATHERED_CUT_COPPER_WALL = register("waxed_weathered_cut_copper_wall", new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copy(WEATHERED_CUT_COPPER)));
	public static final Block WAXED_OXIDIZED_CUT_COPPER_WALL = register("waxed_oxidized_cut_copper_wall", new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copy(OXIDIZED_CUT_COPPER)));

//CHESTS
	public static final Block ACACIA_CHEST = register("acacia_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.ACACIA));
	public static final Block BIRCH_CHEST = register("birch_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.BIRCH));
	public static final Block CRIMSON_CHEST = register("crimson_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.CRIMSON));
	public static final Block DARK_OAK_CHEST = register("dark_oak_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.DARK_OAK));
	public static final Block JUNGLE_CHEST = register("jungle_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.JUNGLE));
//	public static final Block SHULKER_CHEST = register("shulker_chest", new ShulkerChestBlock(FabricBlockSettings.of(Material.STONE), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.SHULKER));
	public static final Block SPRUCE_CHEST = register("spruce_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.SPRUCE));
	public static final Block WARPED_CHEST = register("warped_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.WARPED));
	public static final Block MANGROVE_CHEST = register("mangrove_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), () -> JinericBlockEntityType.JINERIC_CHEST, WoodType.MANGROVE));
	public static final Block TRAPPED_ACACIA_CHEST = register("trapped_acacia_chest", new JinericTrappedChestBlock(FabricBlockSettings.copy(CHEST), WoodType.ACACIA));
	public static final Block TRAPPED_BIRCH_CHEST = register("trapped_birch_chest", new JinericTrappedChestBlock(FabricBlockSettings.copy(CHEST), WoodType.BIRCH));
	public static final Block TRAPPED_CRIMSON_CHEST = register("trapped_crimson_chest", new JinericTrappedChestBlock(FabricBlockSettings.copy(CHEST), WoodType.CRIMSON));
	public static final Block TRAPPED_DARK_OAK_CHEST = register("trapped_dark_oak_chest", new JinericTrappedChestBlock(FabricBlockSettings.copy(CHEST), WoodType.DARK_OAK));
	public static final Block TRAPPED_JUNGLE_CHEST = register("trapped_jungle_chest", new JinericTrappedChestBlock(FabricBlockSettings.copy(CHEST), WoodType.JUNGLE));
	public static final Block TRAPPED_SPRUCE_CHEST = register("trapped_spruce_chest", new JinericTrappedChestBlock(FabricBlockSettings.copy(CHEST), WoodType.SPRUCE));
	public static final Block TRAPPED_WARPED_CHEST = register("trapped_warped_chest", new JinericTrappedChestBlock(FabricBlockSettings.copy(CHEST), WoodType.WARPED));
	public static final Block TRAPPED_MANGROVE_CHEST = register("trapped_mangrove_chest", new JinericTrappedChestBlock(FabricBlockSettings.copy(CHEST), WoodType.MANGROVE));


	public static final Block REFINERY = register("refinery", new RefineryBlock(FabricBlockSettings.copy(FURNACE).luminance(state -> 13)));

//REDSTONE
	public static final Block REDSTONE_LANTERN = register("redstone_lantern", new RedstoneLanternBlock(FabricBlockSettings.copy(LANTERN).luminance(state -> 7)));
	public static final Block REDSTONE_CAMPFIRE = register("redstone_campfire", new RedstoneCampfireBlock(false, 1, JinericBlockSettings.redstoneCampfireSettings()));

//WOOD
	public static final Block SPRUCE_BOOKSHELF = register("spruce_bookshelf",new Block(FabricBlockSettings.copy(BOOKSHELF)));
	public static final Block BIRCH_BOOKSHELF = register("birch_bookshelf",new Block(FabricBlockSettings.copy(BOOKSHELF)));
	public static final Block JUNGLE_BOOKSHELF = register("jungle_bookshelf",new Block(FabricBlockSettings.copy(BOOKSHELF)));
	public static final Block ACACIA_BOOKSHELF = register("acacia_bookshelf",new Block(FabricBlockSettings.copy(BOOKSHELF)));
	public static final Block DARK_OAK_BOOKSHELF = register("dark_oak_bookshelf",new Block(FabricBlockSettings.copy(BOOKSHELF)));
	public static final Block CRIMSON_BOOKSHELF = register("crimson_bookshelf",new Block(FabricBlockSettings.copy(BOOKSHELF)));
	public static final Block WARPED_BOOKSHELF = register("warped_bookshelf",new Block(FabricBlockSettings.copy(BOOKSHELF)));
	public static final Block MANGROVE_BOOKSHELF = register("mangrove_bookshelf",new Block(FabricBlockSettings.copy(BOOKSHELF)));

	//BOREAL
//	public static final Block BOREAL_WOOD = register("boreal_wood",	new PillarBlock(FabricBlockSettings.copy(OAK_WOOD))	);
//	public static final Block BOREAL_LOG = register("boreal_log", new PillarBlock(FabricBlockSettings.copy(OAK_LOG)));
//	public static final Block STRIPPED_BOREAL_WOOD = register("stripped_boreal_wood", new PillarBlock(FabricBlockSettings.copy(OAK_WOOD)));
//	public static final Block STRIPPED_BOREAL_LOG = register("stripped_boreal_log",	new PillarBlock(FabricBlockSettings.copy(OAK_LOG)));
//	public static final Block BOREAL_PLANKS = register("boreal_planks",	new Block(FabricBlockSettings.copy(OAK_PLANKS)));
//	public static final Block BOREAL_STAIRS = register("boreal_stairs", new StairsBlock(OAK_STAIRS.getDefaultState(), FabricBlockSettings.copy(OAK_STAIRS)));
//	public static final Block BOREAL_SLAB = register("boreal_slab",	new SlabBlock(FabricBlockSettings.copy(OAK_SLAB)));
//	public static final Block BOREAL_BOOKSHELF = register("boreal_bookshelf", new Block(FabricBlockSettings.copy(BOOKSHELF)));
//	public static final Block BOREAL_LADDER = register("boreal_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
//	public static final Block BOREAL_FENCE = register("boreal_fence", new FenceBlock(FabricBlockSettings.copy(OAK_FENCE)));
//	public static final Block BOREAL_SIGN = register("boreal_sign", new SignBlock(FabricBlockSettings.copy(OAK_SIGN), JinericSignType.BOREAL));
//	public static final Block BOREAL_WALL_SIGN = register("boreal_wall_sign", new WallSignBlock(FabricBlockSettings.copy(OAK_WALL_SIGN), JinericSignType.BOREAL));
//	public static final Block BOREAL_BUTTON = register("boreal_button", new ButtonBlock(FabricBlockSettings.copy((OAK_BUTTON))));
//	public static final Block BOREAL_PRESSURE_PLATE = register("boreal_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractFabricBlockSettings.copy(OAK_PRESSURE_PLATE)));
//	public static final Block BOREAL_DOOR = register("boreal_door", new DoorBlock(FabricBlockSettings.copy(OAK_DOOR)));
//	public static final Block BOREAL_TRAPDOOR = register("boreal_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(OAK_TRAPDOOR)));
//	public static final Block BOREAL_FENCE_GATE = register("boreal_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(OAK_FENCE_GATE)));
//	public static final Block BOREAL_SAPLING = register("boreal_sapling", new JinericSaplingBlock(new BorealSaplingGenerator(), FabricBlockSettings.copy(OAK_SAPLING)));
//	public static final Block BOREAL_LEAVES = register("boreal_leaves", JinericBlockSettings.JinericLeavesBlock(BlockSoundGroup.GRASS));
	public static final Block ACACIA_LADDER = register("acacia_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
	public static final Block BIRCH_LADDER = register("birch_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
	public static final Block DARK_OAK_LADDER = register("dark_oak_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
	public static final Block SPRUCE_LADDER = register("spruce_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
	public static final Block JUNGLE_LADDER = register("jungle_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
	public static final Block MANGROVE_LADDER = register("mangrove_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
	public static final Block WARPED_LADDER = register("warped_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
	public static final Block CRIMSON_LADDER = register("crimson_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER)));
//	public static final Block SALT_BLOCK = register("salt_block", new FallingBlock(FabricBlockSettings.copy(CLAY).sounds(BlockSoundGroup.SAND)));

	//ICE SLIPPERINESS
	public static boolean isSlipperyBlock(BlockState state) {
		return state.isOf(PACKED_ICE_STAIRS) || state.isOf(PACKED_ICE_SLAB) || state.isOf(PACKED_ICE_WALL);
	}

	private static Block register(String id, Block block) {
		return Registry.register(Registries.BLOCK, new Identifier(JinericMain.MOD_ID, id), block);
	}
}
