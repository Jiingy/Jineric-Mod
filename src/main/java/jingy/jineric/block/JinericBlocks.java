package jingy.jineric.block;

import jingy.jineric.base.JinericMain;
import jingy.jineric.registry.JinericBlockSettings;
import jingy.jineric.sound.JinericBlockSoundGroup;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ColorCode;

import java.util.function.Function;
import java.util.function.ToIntFunction;

import static net.minecraft.block.Blocks.*;

//TODO: INITIALIZE BLOCKS BEFORE THEY ARE NEEDED BY SETTING THEM STATICALLY ON LOAD
public class JinericBlocks {

//SANDSTONE
	public static final Block CUT_SANDSTONE_STAIRS = registerStairsBlock("cut_sandstone_stairs", CUT_SANDSTONE);
	public static final Block CUT_SANDSTONE_WALL = register("cut_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(CUT_SANDSTONE));
	//TODO: RENAME TO 'POLISHED_CUT_SANDSTONE' OR OTHER VARIANT, AS SANDSTONE IS ALREADY USED IN A VANILLA CRAFTING RECIPE. CURRENTLY CRAFTED WITH 'CUT' SANDSTONE
	public static final Block POLISHED_SANDSTONE = register("polished_sandstone", AbstractBlock.Settings.copy(SANDSTONE));
	public static final Block POLISHED_SANDSTONE_STAIRS = registerStairsBlock("polished_sandstone_stairs", POLISHED_SANDSTONE);
	public static final Block POLISHED_SANDSTONE_SLAB  = register("polished_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(POLISHED_SANDSTONE));
	public static final Block POLISHED_SANDSTONE_WALL = register("polished_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(POLISHED_SANDSTONE));
	public static final Block SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(SMOOTH_SANDSTONE));
	public static final Block WAVY_SANDSTONE = register("wavy_sandstone", AbstractBlock.Settings.copy(SANDSTONE));
	public static final Block WAVY_SANDSTONE_STAIRS = registerStairsBlock("wavy_sandstone_stairs", WAVY_SANDSTONE);
	public static final Block WAVY_SANDSTONE_SLAB  = register("wavy_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(WAVY_SANDSTONE));
	public static final Block WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(WAVY_SANDSTONE));
//RED SAND
	public static final Block CUT_RED_SANDSTONE_STAIRS = registerStairsBlock("cut_red_sandstone_stairs", RED_SANDSTONE);
	public static final Block CUT_RED_SANDSTONE_WALL = register("cut_red_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(RED_SANDSTONE));
	public static final Block POLISHED_RED_SANDSTONE = register("polished_red_sandstone", AbstractBlock.Settings.copy(RED_SANDSTONE));
	public static final Block POLISHED_RED_SANDSTONE_STAIRS = registerStairsBlock("polished_red_sandstone_stairs", POLISHED_RED_SANDSTONE);
	public static final Block POLISHED_RED_SANDSTONE_SLAB  = register("polished_red_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(POLISHED_RED_SANDSTONE));
	public static final Block POLISHED_RED_SANDSTONE_WALL = register("polished_red_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(POLISHED_RED_SANDSTONE));
	public static final Block SMOOTH_RED_SANDSTONE_WALL = register("smooth_red_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(RED_SANDSTONE));
	public static final Block WAVY_RED_SANDSTONE = register("wavy_red_sandstone", AbstractBlock.Settings.copy(RED_SANDSTONE));
	public static final Block WAVY_RED_SANDSTONE_STAIRS = registerStairsBlock("wavy_red_sandstone_stairs", WAVY_RED_SANDSTONE);
	public static final Block WAVY_RED_SANDSTONE_SLAB  = register("wavy_red_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(WAVY_RED_SANDSTONE));
	public static final Block WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(WAVY_RED_SANDSTONE));
//SOUL SAND
	public static final Block SOUL_SANDSTONE = register("soul_sandstone", AbstractBlock.Settings.copy(SANDSTONE).sounds(JinericBlockSoundGroup.SOUL_SANDSTONE));
	public static final Block SOUL_SANDSTONE_STAIRS = registerStairsBlock("soul_sandstone_stairs", SOUL_SANDSTONE);
	public static final Block SOUL_SANDSTONE_SLAB  = register("soul_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(SOUL_SANDSTONE));
	public static final Block SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(SOUL_SANDSTONE));
	public static final Block CUT_SOUL_SANDSTONE = register("cut_soul_sandstone",  JinericBlockSettings.soulSandstoneSettings());
	public static final Block CUT_SOUL_SANDSTONE_STAIRS = registerStairsBlock("cut_soul_sandstone_stairs", CUT_SOUL_SANDSTONE);
	public static final Block CUT_SOUL_SANDSTONE_SLAB  = register("cut_soul_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(CUT_SOUL_SANDSTONE));
	public static final Block CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(CUT_SOUL_SANDSTONE));
	public static final Block POLISHED_SOUL_SANDSTONE = register("polished_soul_sandstone",  JinericBlockSettings.soulSandstoneSettings());
	public static final Block POLISHED_SOUL_SANDSTONE_STAIRS = registerStairsBlock("polished_soul_sandstone_stairs", POLISHED_SOUL_SANDSTONE);
	public static final Block POLISHED_SOUL_SANDSTONE_SLAB  = register("polished_soul_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(POLISHED_SOUL_SANDSTONE));
	public static final Block POLISHED_SOUL_SANDSTONE_WALL = register("polished_soul_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(POLISHED_SOUL_SANDSTONE));
	public static final Block CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone",  JinericBlockSettings.soulSandstoneSettings());
	public static final Block SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone",  JinericBlockSettings.soulSandstoneSettings());
	public static final Block SMOOTH_SOUL_SANDSTONE_STAIRS = registerStairsBlock("smooth_soul_sandstone_stairs", SMOOTH_SOUL_SANDSTONE);
	public static final Block SMOOTH_SOUL_SANDSTONE_SLAB  = register("smooth_soul_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(SMOOTH_SOUL_SANDSTONE));
	public static final Block SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(SMOOTH_SOUL_SANDSTONE));
	public static final Block WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone",  JinericBlockSettings.soulSandstoneSettings().sounds(BlockSoundGroup.SOUL_SOIL));
	public static final Block WAVY_SOUL_SANDSTONE_STAIRS = registerStairsBlock("wavy_soul_sandstone_stairs", WAVY_SOUL_SANDSTONE);
	public static final Block WAVY_SOUL_SANDSTONE_SLAB  = register("wavy_soul_sandstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(WAVY_SOUL_SANDSTONE));
	public static final Block WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", WallBlock::new, AbstractBlock.Settings.copy(WAVY_SOUL_SANDSTONE));

	// --- STONE TYPE BLOCKS ---
//STONE
	public static final Block STONE_WALL = register("stone_wall", WallBlock::new, AbstractBlock.Settings.copy(STONE));
	public static final Block SMOOTH_STONE_STAIRS = registerStairsBlock("smooth_stone_stairs", SMOOTH_STONE);
	public static final Block SMOOTH_STONE_WALL = register("smooth_stone_wall", WallBlock::new, AbstractBlock.Settings.copy(SMOOTH_STONE));
	public static final Block POLISHED_STONE = register("polished_stone", AbstractBlock.Settings.copy(STONE));
	public static final Block POLISHED_STONE_STAIRS = registerStairsBlock("polished_stone_stairs", POLISHED_STONE);
	public static final Block POLISHED_STONE_SLAB = register("polished_stone_slab", SlabBlock::new, AbstractBlock.Settings.copy(POLISHED_STONE));
	public static final Block POLISHED_STONE_WALL = register("polished_stone_wall", WallBlock::new, AbstractBlock.Settings.copy(POLISHED_STONE));
	public static final Block CRACKED_STONE_BRICK_STAIRS = registerStairsBlock("cracked_stone_brick_stairs", STONE);
	public static final Block CRACKED_STONE_BRICK_SLAB  = register("cracked_stone_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(STONE));
	public static final Block CRACKED_STONE_BRICK_WALL = register("cracked_stone_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(STONE));
	public static final Block STONE_BRICK_PILLAR = register("stone_brick_pillar", PillarBlock::new, AbstractBlock.Settings.copy(STONE));
	public static final Block STONE_TILES = register("stone_tiles", AbstractBlock.Settings.copy(STONE_BRICKS).sounds(BlockSoundGroup.STONE));
	public static final Block STONE_TILE_STAIRS = registerStairsBlock("stone_tile_stairs", STONE_TILES);
	public static final Block STONE_TILE_SLAB = register("stone_tile_slab", SlabBlock::new, AbstractBlock.Settings.copy(STONE_TILES));
	public static final Block STONE_TILE_WALL = register("stone_tile_wall", WallBlock::new, AbstractBlock.Settings.copy(STONE_TILES));
	public static final Block CRACKED_STONE_TILES = register("cracked_stone_tiles", AbstractBlock.Settings.copy(STONE_TILES).sounds(BlockSoundGroup.STONE));
	public static final Block CRACKED_STONE_TILE_STAIRS = registerStairsBlock("cracked_stone_tile_stairs", CRACKED_STONE_TILES);
	public static final Block CRACKED_STONE_TILE_SLAB = register("cracked_stone_tile_slab", SlabBlock::new, AbstractBlock.Settings.copy(CRACKED_STONE_TILES));
	public static final Block CRACKED_STONE_TILE_WALL = register("cracked_stone_tile_wall", WallBlock::new, AbstractBlock.Settings.copy(CRACKED_STONE_TILES));

//DEEPSLATE
	public static final Block CRACKED_DEEPSLATE_BRICK_STAIRS = registerStairsBlock("cracked_deepslate_brick_stairs", CRACKED_DEEPSLATE_BRICKS);
	public static final Block CRACKED_DEEPSLATE_BRICK_SLAB = register("cracked_deepslate_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(CRACKED_DEEPSLATE_BRICKS));
	public static final Block CRACKED_DEEPSLATE_BRICK_WALL = register("cracked_deepslate_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(CRACKED_DEEPSLATE_BRICKS));
	public static final Block CRACKED_DEEPSLATE_TILE_STAIRS = registerStairsBlock("cracked_deepslate_tile_stairs", CRACKED_DEEPSLATE_TILES);
	public static final Block CRACKED_DEEPSLATE_TILE_SLAB = register("cracked_deepslate_tile_slab", SlabBlock::new, AbstractBlock.Settings.copy(CRACKED_DEEPSLATE_TILES));
	public static final Block CRACKED_DEEPSLATE_TILE_WALL = register("cracked_deepslate_tile_wall", WallBlock::new, AbstractBlock.Settings.copy(CRACKED_DEEPSLATE_TILES));
	public static final Block SMOOTH_DEEPSLATE = register("smooth_deepslate", AbstractBlock.Settings.copy(DEEPSLATE));
	public static final Block SMOOTH_DEEPSLATE_STAIRS = registerStairsBlock("smooth_deepslate_stairs", SMOOTH_DEEPSLATE);
	public static final Block SMOOTH_DEEPSLATE_SLAB = register("smooth_deepslate_slab", SlabBlock::new, AbstractBlock.Settings.copy(SMOOTH_DEEPSLATE));
	public static final Block SMOOTH_DEEPSLATE_WALL = register("smooth_deepslate_wall", WallBlock::new, AbstractBlock.Settings.copy(SMOOTH_DEEPSLATE));

//DIORITE, GRANITE, ANDESITE
	public static final Block POLISHED_GRANITE_WALL = register("polished_granite_wall", WallBlock::new, AbstractBlock.Settings.copy(POLISHED_GRANITE));
	public static final Block POLISHED_DIORITE_WALL = register("polished_diorite_wall", WallBlock::new, AbstractBlock.Settings.copy(POLISHED_DIORITE));
	public static final Block POLISHED_ANDESITE_WALL = register("polished_andesite_wall", WallBlock::new, AbstractBlock.Settings.copy(POLISHED_ANDESITE));

//TUFF
	public static final Block SMOOTH_TUFF = register("smooth_tuff", AbstractBlock.Settings.copy(TUFF));
	public static final Block SMOOTH_TUFF_SLAB = register("smooth_tuff_slab", SlabBlock::new, AbstractBlock.Settings.copy(SMOOTH_TUFF));
	public static final Block SMOOTH_TUFF_STAIRS = registerStairsBlock("smooth_tuff_stairs", SMOOTH_TUFF);
	public static final Block SMOOTH_TUFF_WALL = register("smooth_tuff_wall", WallBlock::new, AbstractBlock.Settings.copy(SMOOTH_TUFF));
	public static final Block TUFF_BRICK_PILLAR = register("tuff_brick_pillar", PillarBlock::new, Block.Settings.copy(TUFF_BRICKS));
	public static final Block CRACKED_TUFF_BRICKS = register("cracked_tuff_bricks", AbstractBlock.Settings.copy(TUFF_BRICKS));
	public static final Block CRACKED_TUFF_BRICK_SLAB = register("cracked_tuff_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(CRACKED_TUFF_BRICKS));
	public static final Block CRACKED_TUFF_BRICK_STAIRS = registerStairsBlock("cracked_tuff_brick_stairs", CRACKED_TUFF_BRICKS);
	public static final Block CRACKED_TUFF_BRICK_WALL = register("cracked_tuff_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(CRACKED_TUFF_BRICKS));
	//	TODO: RENAME TO TUFF BRICK PILLAR
	public static final Block TUFF_TILES = register("tuff_tiles",  Block.Settings.copy(STONE_TILES).sounds(BlockSoundGroup.TUFF));
	public static final Block TUFF_TILE_STAIRS = registerStairsBlock("tuff_tile_stairs", TUFF_TILES);
	public static final Block TUFF_TILE_SLAB = register("tuff_tile_slab", SlabBlock::new, Block.Settings.copy(TUFF_TILES));
	public static final Block TUFF_TILE_WALL = register("tuff_tile_wall", WallBlock::new, Block.Settings.copy(TUFF_TILES));
	public static final Block CRACKED_TUFF_TILES = register("cracked_tuff_tiles",  Block.Settings.copy(TUFF_TILES));
	public static final Block CRACKED_TUFF_TILE_STAIRS = registerStairsBlock("cracked_tuff_tile_stairs", CRACKED_TUFF_TILES);
	public static final Block CRACKED_TUFF_TILE_SLAB = register("cracked_tuff_tile_slab", SlabBlock::new, Block.Settings.copy(CRACKED_TUFF_TILES));
	public static final Block CRACKED_TUFF_TILE_WALL = register("cracked_tuff_tile_wall", WallBlock::new, Block.Settings.copy(CRACKED_TUFF_TILES));

	//CALCITE
	public static final Block CALCITE_STAIRS = registerStairsBlock("calcite_stairs", CALCITE);
	public static final Block CALCITE_SLAB = register("calcite_slab", SlabBlock::new, AbstractBlock.Settings.copy(CALCITE));
	public static final Block CALCITE_WALL = register("calcite_wall", WallBlock::new, AbstractBlock.Settings.copy(CALCITE));

//DRIPSTONE
	//TODO: RENAME TO 'DRIPSTONE_BLOCK[variant]'
	public static final Block DRIPSTONE_SLAB = register("dripstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_BLOCK));
	public static final Block DRIPSTONE_STAIRS = registerStairsBlock("dripstone_stairs", DRIPSTONE_BLOCK);
	public static final Block DRIPSTONE_WALL = register("dripstone_wall", WallBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_BLOCK));
	public static final Block DRIPSTONE_BRICKS = register("dripstone_bricks", AbstractBlock.Settings.copy(DRIPSTONE_BLOCK));
	public static final Block DRIPSTONE_BRICK_SLAB = register("dripstone_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_BRICKS));
	public static final Block DRIPSTONE_BRICK_STAIRS = registerStairsBlock("dripstone_brick_stairs", DRIPSTONE_BRICKS);
	public static final Block DRIPSTONE_BRICK_WALL = register("dripstone_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_BRICKS));
	public static final Block CRACKED_DRIPSTONE_BRICKS = register("cracked_dripstone_bricks", AbstractBlock.Settings.copy(DRIPSTONE_BLOCK));
	public static final Block CRACKED_DRIPSTONE_BRICK_SLAB = register("cracked_dripstone_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_BRICKS));
	public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS = registerStairsBlock("cracked_dripstone_brick_stairs", DRIPSTONE_BRICKS);
	public static final Block CRACKED_DRIPSTONE_BRICK_WALL = register("cracked_dripstone_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_BRICKS));
	public static final Block POLISHED_DRIPSTONE = register("polished_dripstone", AbstractBlock.Settings.copy(DRIPSTONE_BLOCK));
	public static final Block POLISHED_DRIPSTONE_SLAB  = register("polished_dripstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(POLISHED_DRIPSTONE));
	public static final Block POLISHED_DRIPSTONE_STAIRS = registerStairsBlock("polished_dripstone_stairs", STONE);
	public static final Block POLISHED_DRIPSTONE_WALL = register("polished_dripstone_wall", WallBlock::new, AbstractBlock.Settings.copy(POLISHED_DRIPSTONE));
	public static final Block DRIPSTONE_TILES = register("dripstone_tiles", AbstractBlock.Settings.copy(DRIPSTONE_BLOCK));
	public static final Block DRIPSTONE_TILE_SLAB = register("dripstone_tile_slab", SlabBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_TILES));
	public static final Block DRIPSTONE_TILE_STAIRS = registerStairsBlock("dripstone_tile_stairs", DRIPSTONE_TILES);
	public static final Block DRIPSTONE_TILE_WALL = register("dripstone_tile_wall", WallBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_TILES));
	public static final Block CRACKED_DRIPSTONE_TILES = register("cracked_dripstone_tiles", AbstractBlock.Settings.copy(DRIPSTONE_TILES));
	public static final Block CRACKED_DRIPSTONE_TILE_SLAB = register("cracked_dripstone_tile_slab", SlabBlock::new, AbstractBlock.Settings.copy(CRACKED_DRIPSTONE_TILES));
	public static final Block CRACKED_DRIPSTONE_TILE_STAIRS = registerStairsBlock("cracked_dripstone_tile_stairs", CRACKED_DRIPSTONE_TILES);
	public static final Block CRACKED_DRIPSTONE_TILE_WALL = register("cracked_dripstone_tile_wall", WallBlock::new, AbstractBlock.Settings.copy(CRACKED_DRIPSTONE_TILES));
	public static final Block SMOOTH_DRIPSTONE = register("smooth_dripstone", AbstractBlock.Settings.copy(DRIPSTONE_BLOCK));
	public static final Block SMOOTH_DRIPSTONE_SLAB  = register("smooth_dripstone_slab", SlabBlock::new, AbstractBlock.Settings.copy(SMOOTH_DRIPSTONE));
	public static final Block SMOOTH_DRIPSTONE_STAIRS = registerStairsBlock("smooth_dripstone_stairs", SMOOTH_DRIPSTONE);
	public static final Block SMOOTH_DRIPSTONE_WALL = register("smooth_dripstone_wall", WallBlock::new, AbstractBlock.Settings.copy(SMOOTH_DRIPSTONE));
	public static final Block CHISELED_DRIPSTONE_BRICKS = register("chiseled_dripstone_bricks", AbstractBlock.Settings.copy(DRIPSTONE_BRICKS));
	public static final Block DRIPSTONE_BRICK_PILLAR = register("dripstone_brick_pillar", PillarBlock::new, AbstractBlock.Settings.copy(DRIPSTONE_BLOCK));

//OBSIDIAN
	public static final Block OBSIDIAN_STAIRS = registerStairsBlock("obsidian_stairs", OBSIDIAN);
	public static final Block OBSIDIAN_SLAB  = register("obsidian_slab", SlabBlock::new, AbstractBlock.Settings.copy(OBSIDIAN));
	public static final Block OBSIDIAN_WALL = register("obsidian_wall", WallBlock::new, AbstractBlock.Settings.copy(OBSIDIAN));

//NETHER
	public static final Block QUARTZ_WALL = register("quartz_wall", WallBlock::new, AbstractBlock.Settings.copy(QUARTZ_BLOCK));
	public static final Block SMOOTH_QUARTZ_WALL = register("smooth_quartz_wall", WallBlock::new, AbstractBlock.Settings.copy(SMOOTH_QUARTZ));
	public static final Block QUARTZ_BRICK_SLAB = register("quartz_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(QUARTZ_BRICKS));
	public static final Block QUARTZ_BRICK_STAIRS = registerStairsBlock("quartz_brick_stairs", QUARTZ_BRICKS);
	public static final Block QUARTZ_BRICK_WALL = register("quartz_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(QUARTZ_BRICKS));
	public static final Block SMOOTH_BASALT_SLAB = register("smooth_basalt_slab", SlabBlock::new, AbstractBlock.Settings.copy(SMOOTH_BASALT));
	public static final Block SMOOTH_BASALT_STAIRS = registerStairsBlock("smooth_basalt_stairs", SMOOTH_BASALT);
	public static final Block SMOOTH_BASALT_WALL = register("smooth_basalt_wall", WallBlock::new, AbstractBlock.Settings.copy(SMOOTH_BASALT));
	public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = register("cracked_polished_blackstone_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(CRACKED_POLISHED_BLACKSTONE_BRICKS));
	public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = registerStairsBlock("cracked_polished_blackstone_brick_stairs", CRACKED_POLISHED_BLACKSTONE_BRICKS);
	public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = register("cracked_polished_blackstone_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(CRACKED_POLISHED_BLACKSTONE_BRICKS));
	public static final Block RED_NETHER_BRICK_FENCE = register("red_nether_brick_fence", FenceBlock::new, AbstractBlock.Settings.copy(NETHER_BRICK_FENCE));
	public static final Block CRACKED_NETHER_BRICK_SLAB = register("cracked_nether_brick_slab", SlabBlock::new, Block.Settings.copy(CRACKED_NETHER_BRICKS));
	public static final Block CRACKED_NETHER_BRICK_STAIRS = registerStairsBlock("cracked_nether_brick_stairs", CRACKED_NETHER_BRICKS);
	public static final Block CRACKED_NETHER_BRICK_WALL = register("cracked_nether_brick_wall", WallBlock::new, Block.Settings.copy(CRACKED_NETHER_BRICKS));

//END
	public static final Block PURPUR_WALL = register("purpur_wall", WallBlock::new, AbstractBlock.Settings.copy(PURPUR_BLOCK));

	// --- MISCELLANEOUS ---
//PACKED ITEM BLOCKS
	public static final Block SUGAR_BLOCK = register(
			"sugar_block", 
			settings -> new ColoredFallingBlock(new ColorCode(238238238), settings),
			AbstractBlock.Settings.create().mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND)
	);
	public static final Block ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", AbstractBlock.Settings.copy(HONEYCOMB_BLOCK).sounds(BlockSoundGroup.HONEY));
	public static final Block FLINT_BLOCK = register("flint_block", AbstractBlock.Settings.copy(STONE));
	public static final Block CHARCOAL_BLOCK = register("charcoal_block", AbstractBlock.Settings.copy(COAL_BLOCK));
	public static final Block BONE_MEAL_BLOCK = register("bone_meal_block", AbstractBlock.Settings.copy(BONE_BLOCK));
	public static final Block ENDER_PEARL_BLOCK = register("ender_pearl_block", AbstractBlock.Settings.copy(HONEY_BLOCK));
	public static final Block PRISMARINE_CRYSTAL_BLOCK = register("prismarine_crystal_block", AbstractBlock.Settings.copy(SEA_LANTERN).luminance(state -> 4).requiresTool());
	public static final Block BLAZE_ROD_BLOCK = register("blaze_rod_block", AbstractBlock.Settings.copy(CHARCOAL_BLOCK));
	public static final Block EGG_BLOCK = register("egg_block", AbstractBlock.Settings.copy(CALCITE).sounds(BlockSoundGroup.CALCITE).strength(0.50F));
	public static final Block STICK_BLOCK = register("stick_block", PillarBlock::new, AbstractBlock.Settings.copy(OAK_PLANKS));
	public static final Block PAPER_BLOCK = register("paper_block", AbstractBlock.Settings.copy(AZALEA_LEAVES).sounds(BlockSoundGroup.AZALEA_LEAVES));

	//TODO: FIX MIXIN THAT ADDS SLIDING TO NON-FULL BLOCKS 1.21.3
//PACKED ICE
	public static final Block PACKED_ICE_STAIRS = registerStairsBlock("packed_ice_stairs", PACKED_ICE);
	public static final Block PACKED_ICE_SLAB  = register("packed_ice_slab", SlabBlock::new, AbstractBlock.Settings.copy(PACKED_ICE));
	public static final Block PACKED_ICE_WALL = register("packed_ice_wall", WallBlock::new, AbstractBlock.Settings.copy(PACKED_ICE));

//SNOW & POWDERED SNOW
	public static final Block SNOW_WALL = register("snow_wall", WallBlock::new, AbstractBlock.Settings.copy(SNOW_BLOCK).strength(1.5F, 1.0F));
	public static final Block SNOW_BRICKS = register("snow_bricks",  JinericBlockSettings.snowBrickSettings());
	public static final Block SNOW_BRICK_STAIRS = registerStairsBlock("snow_brick_stairs", SNOW_BRICKS);
	public static final Block SNOW_BRICK_SLAB = register("snow_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(SNOW_BRICKS));
	public static final Block SNOW_BRICK_WALL = register("snow_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(SNOW_BRICKS));

//DECORATION BLOCKS
	public static final Block SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", CarvedPumpkinBlock::new, AbstractBlock.Settings.copy(JACK_O_LANTERN));
	// TODO: SPREADING/BONEMEALING IS BROKEN IN 1.21.3
	public static final Block FULL_GRASS_BLOCK = register("full_grass_block", FullGrassBlock::new, AbstractBlock.Settings.copy(GRASS_BLOCK));
	public static final Block PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(PRISMARINE_BRICKS));
	public static final Block DARK_PRISMARINE_WALL = register("dark_prismarine_wall", WallBlock::new, AbstractBlock.Settings.copy(DARK_PRISMARINE));
	public static final Block CUT_COPPER_WALL = register(
			"cut_copper_wall",
			settings -> new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings),
			AbstractBlock.Settings.copy(CUT_COPPER)
	);
	public static final Block EXPOSED_CUT_COPPER_WALL = register(
			"exposed_cut_copper_wall",
			settings -> new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.EXPOSED, settings),
			AbstractBlock.Settings.copy(EXPOSED_CUT_COPPER)
	);
	public static final Block WEATHERED_CUT_COPPER_WALL = register(
			"weathered_cut_copper_wall",
			settings -> new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.WEATHERED, settings),
			AbstractBlock.Settings.copy(WEATHERED_CUT_COPPER)
	);
	public static final Block OXIDIZED_CUT_COPPER_WALL = register(
			"oxidized_cut_copper_wall",
			settings -> new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.OXIDIZED, settings),
			AbstractBlock.Settings.copy(OXIDIZED_CUT_COPPER)
	);
	public static final Block WAXED_CUT_COPPER_WALL = register(
			"waxed_cut_copper_wall",
			settings -> new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings),
			AbstractBlock.Settings.copy(CUT_COPPER)
	);
	public static final Block WAXED_EXPOSED_CUT_COPPER_WALL = register(
			"waxed_exposed_cut_copper_wall",
			settings -> new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.EXPOSED, settings),
			AbstractBlock.Settings.copy(EXPOSED_CUT_COPPER)
	);
	public static final Block WAXED_WEATHERED_CUT_COPPER_WALL = register(
			"waxed_weathered_cut_copper_wall",
			settings -> new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.WEATHERED, settings),
			AbstractBlock.Settings.copy(WEATHERED_CUT_COPPER)
	);
	public static final Block WAXED_OXIDIZED_CUT_COPPER_WALL = register(
			"waxed_oxidized_cut_copper_wall",
			settings -> new OxidizableCopperWallBlock(Oxidizable.OxidationLevel.OXIDIZED, settings),
			AbstractBlock.Settings.copy(OXIDIZED_CUT_COPPER)
	);

	public static final Block REFINERY = register(
			"refinery",
            RefineryBlock::new,
			AbstractBlock.Settings.copy(FURNACE).luminance(createLightLevelFromLitBlockState(13)).sounds(BlockSoundGroup.DEEPSLATE)
	);

//REDSTONE
	public static final Block REDSTONE_LANTERN = register(
		"redstone_lantern",
		RedstoneLanternBlock::new,
		AbstractBlock.Settings.copy(LANTERN).luminance(state -> 7)
	);
	public static final Block REDSTONE_CAMPFIRE = register(
			"redstone_campfire",
			settings -> new RedstoneCampfireBlock(false, 1, settings),
			AbstractBlock.Settings.copy(CAMPFIRE).luminance(createLightLevelFromLitBlockState(7))
	);
//TODO: 1.21.3+ ADD PALE OAK WOODEN ADDITIONS
//WOOD
	public static final Block ACACIA_BOOKSHELF = register("acacia_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.CHISELED_BOOKSHELF));
	public static final Block BAMBOO_BOOKSHELF = register("bamboo_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.CHISELED_BOOKSHELF));
	public static final Block BIRCH_BOOKSHELF = register("birch_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.CHISELED_BOOKSHELF));
	public static final Block CHERRY_BOOKSHELF = register("cherry_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.CHISELED_BOOKSHELF));
	public static final Block CRIMSON_BOOKSHELF = register("crimson_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.NETHER_WOOD));
	public static final Block DARK_OAK_BOOKSHELF = register("dark_oak_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.CHISELED_BOOKSHELF));
	public static final Block JUNGLE_BOOKSHELF = register("jungle_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.CHISELED_BOOKSHELF));
	public static final Block MANGROVE_BOOKSHELF = register("mangrove_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.CHISELED_BOOKSHELF));
	public static final Block SPRUCE_BOOKSHELF = register("spruce_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.CHISELED_BOOKSHELF));
	public static final Block WARPED_BOOKSHELF = register("warped_bookshelf", AbstractBlock.Settings.copy(BOOKSHELF).sounds(BlockSoundGroup.NETHER_WOOD));
	public static final Block ACACIA_LADDER = register("acacia_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.WOODEN_LADDER));
	public static final Block BAMBOO_LADDER = register("bamboo_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.WOODEN_LADDER));
	public static final Block BIRCH_LADDER = register("birch_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.WOODEN_LADDER));
	public static final Block CHERRY_LADDER = register("cherry_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.WOODEN_LADDER));
	public static final Block DARK_OAK_LADDER = register("dark_oak_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.WOODEN_LADDER));
	public static final Block SPRUCE_LADDER = register("spruce_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.WOODEN_LADDER));
	public static final Block JUNGLE_LADDER = register("jungle_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.WOODEN_LADDER));
	public static final Block MANGROVE_LADDER = register("mangrove_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.WOODEN_LADDER));
	public static final Block WARPED_LADDER = register("warped_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.NETHER_WOODEN_LADDER));
	public static final Block CRIMSON_LADDER = register("crimson_ladder", LadderBlock::new, AbstractBlock.Settings.copy(LADDER).sounds(JinericBlockSoundGroup.NETHER_WOODEN_LADDER));
	public static final Block SPRUCE_CHEST = registerChest("spruce_chest", Blocks.CHEST, WoodType.SPRUCE);
	public static final Block BIRCH_CHEST = registerChest("birch_chest", Blocks.CHEST, WoodType.BIRCH);
	public static final Block JUNGLE_CHEST = registerChest("jungle_chest", Blocks.CHEST, WoodType.JUNGLE);
	public static final Block ACACIA_CHEST = registerChest("acacia_chest", Blocks.CHEST, WoodType.ACACIA);
	public static final Block DARK_OAK_CHEST = registerChest("dark_oak_chest", Blocks.CHEST, WoodType.DARK_OAK);
	public static final Block MANGROVE_CHEST = registerChest("mangrove_chest", Blocks.TRAPPED_CHEST, WoodType.MANGROVE);
	public static final Block CHERRY_CHEST = registerChest("cherry_chest", Blocks.CHEST, WoodType.CHERRY);
	public static final Block BAMBOO_CHEST = registerChest("bamboo_chest", Blocks.CHEST, WoodType.BAMBOO);
	public static final Block CRIMSON_CHEST = registerChest("crimson_chest", Blocks.CHEST, WoodType.CRIMSON);
	public static final Block WARPED_CHEST = registerChest("warped_chest", Blocks.CHEST, WoodType.WARPED);
	public static final Block TRAPPED_SPRUCE_CHEST = registerTrappedChest("trapped_spruce_chest", Blocks.TRAPPED_CHEST, WoodType.SPRUCE);
	public static final Block TRAPPED_BIRCH_CHEST = registerTrappedChest("trapped_birch_chest", Blocks.TRAPPED_CHEST, WoodType.BIRCH);
	public static final Block TRAPPED_JUNGLE_CHEST = registerTrappedChest("trapped_jungle_chest", Blocks.TRAPPED_CHEST, WoodType.JUNGLE);
	public static final Block TRAPPED_ACACIA_CHEST = registerTrappedChest("trapped_acacia_chest", Blocks.TRAPPED_CHEST, WoodType.ACACIA);
	public static final Block TRAPPED_DARK_OAK_CHEST = registerTrappedChest("trapped_dark_oak_chest", Blocks.TRAPPED_CHEST, WoodType.DARK_OAK);
	public static final Block TRAPPED_MANGROVE_CHEST = registerTrappedChest("trapped_mangrove_chest", Blocks.TRAPPED_CHEST, WoodType.MANGROVE);
	public static final Block TRAPPED_CHERRY_CHEST = registerTrappedChest("trapped_cherry_chest", Blocks.TRAPPED_CHEST, WoodType.CHERRY);
	public static final Block TRAPPED_BAMBOO_CHEST = registerTrappedChest("trapped_bamboo_chest", Blocks.TRAPPED_CHEST, WoodType.BAMBOO);
	public static final Block TRAPPED_CRIMSON_CHEST = registerTrappedChest("trapped_crimson_chest", Blocks.TRAPPED_CHEST, WoodType.CRIMSON);
	public static final Block TRAPPED_WARPED_CHEST = registerTrappedChest("trapped_warped_chest", Blocks.TRAPPED_CHEST, WoodType.WARPED);

	//ICE SLIPPERINESS
	public static boolean isSlipperyBlock(BlockState state) {
		return state.isIn(JinericBlockTags.SLIPPERY);
	}

	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return state -> state.get(Properties.LIT) ? litLevel : 0;
	}

	private static Block registerStairsBlock(String id, Block base) {
		return register(id, settings -> new StairsBlock(base.getDefaultState(), settings), AbstractBlock.Settings.copy(base));
	}

	private static Block registerChest(String id, Block base, WoodType woodType) {
		boolean notNether = (woodType != WoodType.WARPED || woodType != WoodType.CRIMSON);
		return register(id, settings -> new JinericChestBlock(settings, woodType), notNether ? AbstractBlock.Settings.copy(base) : AbstractBlock.Settings.copy(base).sounds(BlockSoundGroup.NETHER_WOOD));
	}

	private static Block registerTrappedChest(String id, Block base, WoodType woodType) {
		boolean notNether = (woodType != WoodType.WARPED || woodType != WoodType.CRIMSON);
		return register(id, settings -> new JinericTrappedChestBlock(settings, woodType), notNether ? AbstractBlock.Settings.copy(base) : AbstractBlock.Settings.copy(base).sounds(BlockSoundGroup.NETHER_WOOD));
	}
	public static Block register(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
		Block block = factory.apply(settings.registryKey(key));
		return Registry.register(Registries.BLOCK, key, block);
	}

	public static Block register(RegistryKey<Block> key, AbstractBlock.Settings settings) {
		return register(key, Block::new, settings);
	}

	private static RegistryKey<Block> keyOf(String id) {
		return RegistryKey.of(RegistryKeys.BLOCK, JinericMain.ofJineric(id));
	}

	private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
		return register(keyOf(id), factory, settings);
	}

	private static Block register(String id, AbstractBlock.Settings settings) {
		return register(id, Block::new, settings);
	}

	public static void initialize() {}
}
