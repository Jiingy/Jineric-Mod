package jingy.jineric.blocks;

import static net.minecraft.block.Blocks.CALCITE;
import static net.minecraft.block.Blocks.CHISELED_RED_SANDSTONE;
import static net.minecraft.block.Blocks.CHISELED_SANDSTONE;
import static net.minecraft.block.Blocks.CLAY;
import static net.minecraft.block.Blocks.COAL_BLOCK;
import static net.minecraft.block.Blocks.CUT_SANDSTONE;
import static net.minecraft.block.Blocks.DARK_PRISMARINE;
import static net.minecraft.block.Blocks.DEAD_BUSH;
import static net.minecraft.block.Blocks.DRIPSTONE_BLOCK;
import static net.minecraft.block.Blocks.GRASS_BLOCK;
import static net.minecraft.block.Blocks.HONEYCOMB_BLOCK;
import static net.minecraft.block.Blocks.JACK_O_LANTERN;
import static net.minecraft.block.Blocks.OAK_FENCE;
import static net.minecraft.block.Blocks.OAK_FENCE_GATE;
import static net.minecraft.block.Blocks.OAK_LOG;
import static net.minecraft.block.Blocks.OAK_PLANKS;
import static net.minecraft.block.Blocks.OAK_SLAB;
import static net.minecraft.block.Blocks.OAK_STAIRS;
import static net.minecraft.block.Blocks.OAK_TRAPDOOR;
import static net.minecraft.block.Blocks.OAK_WOOD;
import static net.minecraft.block.Blocks.OBSIDIAN;
import static net.minecraft.block.Blocks.PACKED_ICE;
import static net.minecraft.block.Blocks.PRISMARINE_BRICKS;
import static net.minecraft.block.Blocks.RED_SANDSTONE;
import static net.minecraft.block.Blocks.SMOOTH_SANDSTONE;
import static net.minecraft.block.Blocks.SMOOTH_STONE;
import static net.minecraft.block.Blocks.SNOW_BLOCK;
import static net.minecraft.block.Blocks.STONE;
import static net.minecraft.block.Blocks.TUFF;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericBlocks {
/*FORMAT:
	public static final Block _BLOCK = register("block", new Block(FabricBlockSettings.copy(BLOCK)));
	public static final Block _STAIRS = register("_stairs", new BaseJinericStairBlock(BLOCK.getDefaultState(),FabricBlockSettings.copy(BLOCK)));
	public static final Block _SLAB = register("_slab", new SlabBlock(FabricBlockSettings.copy(BLOCK)));
	public static final Block _WALL = register("_wall", new WallBlock(FabricBlockSettings.copy(BLOCK)));
 */
//SANDSTONE
	public static final Block CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new BaseJinericStairBlock(CUT_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(CUT_SANDSTONE)));
	public static final Block CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new WallBlock(FabricBlockSettings.copy(CUT_SANDSTONE)));
	public static final Block POLISHED_SANDSTONE = register("polished_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SandstoneSettings())));
	public static final Block POLISHED_SANDSTONE_STAIRS = register("polished_sandstone_stairs", new BaseJinericStairBlock(POLISHED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(POLISHED_SANDSTONE)));
	public static final Block POLISHED_SANDSTONE_SLAB  = register("polished_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_SANDSTONE)));
	public static final Block POLISHED_SANDSTONE_WALL = register("polished_sandstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_SANDSTONE)));
	public static final Block CHISELED_SANDSTONE_STAIRS = register("chiseled_sandstone_stairs", new BaseJinericStairBlock(CHISELED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(CHISELED_SANDSTONE)));
	public static final Block CHISELED_SANDSTONE_SLAB  = register("chiseled_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(CHISELED_SANDSTONE)));
	public static final Block CHISELED_SANDSTONE_WALL = register("chiseled_sandstone_wall", new WallBlock(FabricBlockSettings.copy(CHISELED_SANDSTONE)));
	public static final Block SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_SANDSTONE)));
	public static final Block WAVY_SANDSTONE = register("wavy_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SandstoneSettings())));
	public static final Block WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BaseJinericStairBlock(WAVY_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(WAVY_SANDSTONE)));
	public static final Block WAVY_SANDSTONE_SLAB  = register("wavy_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_SANDSTONE)));
	public static final Block WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_SANDSTONE)));
//RED SAND
	public static final Block CUT_RED_SANDSTONE_STAIRS = register("cut_red_sandstone_stairs", new BaseJinericStairBlock(RED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(RED_SANDSTONE)));
	public static final Block CUT_RED_SANDSTONE_WALL = register("cut_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE = register("polished_red_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SandstoneSettings())));
	public static final Block POLISHED_RED_SANDSTONE_STAIRS = register("polished_red_sandstone_stairs", new BaseJinericStairBlock(POLISHED_RED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE_SLAB  = register("polished_red_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE_WALL = register("polished_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block CHISELED_RED_SANDSTONE_STAIRS = register("chiseled_red_sandstone_stairs", new BaseJinericStairBlock(CHISELED_RED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(CHISELED_SANDSTONE)));
	public static final Block CHISELED_RED_SANDSTONE_SLAB  = register("chiseled_red_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(CHISELED_RED_SANDSTONE)));
	public static final Block CHISELED_RED_SANDSTONE_WALL = register("chiseled_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(CHISELED_RED_SANDSTONE)));
	public static final Block SMOOTH_RED_SANDSTONE_WALL = register("smooth_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(RED_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SandstoneSettings())));
	public static final Block WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BaseJinericStairBlock(WAVY_RED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(WAVY_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE_SLAB  = register("wavy_red_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_RED_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_RED_SANDSTONE)));
//SOUL SAND
	public static final Block SOUL_SANDSTONE = register("soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.JinericSoulSandstoneSettings())));
	public static final Block SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block SOUL_SANDSTONE_SLAB  = register("soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.JinericSoulSandstoneSettings())));
	public static final Block CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block CUT_SOUL_SANDSTONE_SLAB  = register("cut_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block POLISHED_SOUL_SANDSTONE = register("polished_soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SandstoneSettings())));
	public static final Block POLISHED_SOUL_SANDSTONE_STAIRS = register("polished_soul_sandstone_stairs", new BaseJinericStairBlock(POLISHED_SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(POLISHED_SOUL_SANDSTONE)));
	public static final Block POLISHED_SOUL_SANDSTONE_SLAB  = register("polished_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_SOUL_SANDSTONE)));
	public static final Block POLISHED_SOUL_SANDSTONE_WALL = register("polished_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_SOUL_SANDSTONE)));
	public static final Block CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.JinericSoulSandstoneSettings())));
	public static final Block CHISELED_SOUL_SANDSTONE_STAIRS = register("chiseled_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block CHISELED_SOUL_SANDSTONE_SLAB  = register("chiseled_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block CHISELED_SOUL_SANDSTONE_WALL = register("chiseled_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new Block(FabricBlockSettings.copy(SMOOTH_SANDSTONE)));
	public static final Block SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BaseJinericStairBlock(SMOOTH_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SMOOTH_SANDSTONE)));
	public static final Block SMOOTH_SOUL_SANDSTONE_SLAB  = register("smooth_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_SANDSTONE)));
	public static final Block SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_SANDSTONE)));
	public static final Block WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.JinericSoulSandstoneSettings())));
	public static final Block WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block WAVY_SOUL_SANDSTONE_SLAB  = register("wavy_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
	public static final Block WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
//STONE TYPES:
	//STONE & SMOOTH STONE
	public static final Block STONE_WALL = register("stone_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	public static final Block SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", new BaseJinericStairBlock(SMOOTH_STONE.getDefaultState(),FabricBlockSettings.copy(SMOOTH_STONE)));
	public static final Block SMOOTH_STONE_WALL = register("smooth_stone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_STONE)));
	//'ITES'
	public static final Block POLISHED_GRANITE_WALL = register("polished_granite_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	public static final Block POLISHED_DIORITE_WALL = register("polished_diorite_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	public static final Block POLISHED_ANDESITE_WALL = register("polished_andesite_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	//DRIPSTONE
	public static final Block CRACKED_STONE_BRICK_STAIRS = register("cracked_stone_brick_stairs", new BaseJinericStairBlock(STONE.getDefaultState(),FabricBlockSettings.copy(STONE)));
	public static final Block CRACKED_STONE_BRICK_SLAB  = register("cracked_stone_brick_slab", new SlabBlock(FabricBlockSettings.copy(STONE)));
	public static final Block CRACKED_STONE_BRICK_WALL = register("cracked_stone_brick_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	//TUFF
	public static final Block TUFF_STAIRS = register("tuff_stairs", new BaseJinericStairBlock(TUFF.getDefaultState(),FabricBlockSettings.copy(TUFF)));
	public static final Block TUFF_SLAB = register("tuff_slab", new SlabBlock(FabricBlockSettings.copy(TUFF)));
	public static final Block TUFF_WALL = register("tuff_wall", new WallBlock(FabricBlockSettings.copy(TUFF)));
	//CALCITE
	public static final Block CALCITE_STAIRS = register("calcite_stairs", new BaseJinericStairBlock(CALCITE.getDefaultState(),FabricBlockSettings.copy(CALCITE)));
	public static final Block CALCITE_SLAB = register("calcite_slab", new SlabBlock(FabricBlockSettings.copy(CALCITE)));
	public static final Block CALCITE_WALL = register("calcite_wall", new WallBlock(FabricBlockSettings.copy(CALCITE)));
	//CRACKED STONE BRICK
	public static final Block DRIPSTONE_SLAB  = register("dripstone_slab", new SlabBlock(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block DRIPSTONE_STAIRS = register("dripstone_stairs", new BaseJinericStairBlock(STONE.getDefaultState(),FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	public static final Block DRIPSTONE_WALL = register("dripstone_wall", new WallBlock(FabricBlockSettings.copy(DRIPSTONE_BLOCK)));
	//OBSIDIAN
	public static final Block OBSIDIAN_STAIRS = register("obsidian_stairs", new BaseJinericStairBlock(OBSIDIAN.getDefaultState(),FabricBlockSettings.copy(OBSIDIAN)));
	public static final Block OBSIDIAN_SLAB  = register("obsidian_slab", new SlabBlock(FabricBlockSettings.copy(OBSIDIAN)));
	public static final Block OBSIDIAN_WALL = register("obsidian_wall", new WallBlock(FabricBlockSettings.copy(OBSIDIAN)));
	//BORITE
	public static final Block BORITE = register("borite", new Block(FabricBlockSettings.copy(STONE)));
	public static final Block BORITE_STAIRS = register("borite_stairs", new BaseJinericStairBlock(STONE.getDefaultState(),FabricBlockSettings.copy(STONE)));
	public static final Block BORITE_SLAB  = register("borite_slab", new SlabBlock(FabricBlockSettings.copy(STONE)));
	public static final Block BORITE_WALL = register("borite_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	//SILTSTONE
	public static final Block SILTSTONE = register("siltstone", new Block(FabricBlockSettings.copy(STONE)));
	public static final Block SILTSTONE_STAIRS = register("siltstone_stairs", new BaseJinericStairBlock(STONE.getDefaultState(),FabricBlockSettings.copy(STONE)));
	public static final Block SILTSTONE_SLAB  = register("siltstone_slab", new SlabBlock(FabricBlockSettings.copy(STONE)));
	public static final Block SILTSTONE_WALL = register("siltstone_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	//POLISHED_SILTSTONE
	public static final Block POLISHED_SILTSTONE = register("polished_siltstone", new Block(FabricBlockSettings.copy(STONE)));
	public static final Block POLISHED_SILTSTONE_STAIRS = register("polished_siltstone_stairs", new BaseJinericStairBlock(STONE.getDefaultState(),FabricBlockSettings.copy(STONE)));
	public static final Block POLISHED_SILTSTONE_SLAB  = register("polished_siltstone_slab", new SlabBlock(FabricBlockSettings.copy(STONE)));
	public static final Block POLISHED_SILTSTONE_WALL = register("polished_siltstone_wall", new WallBlock(FabricBlockSettings.copy(STONE)));
	//SLATE
	public static final Block SLATE = register("slate", new Block(FabricBlockSettings.copy(STONE)));
	public static final Block SLATE_STAIRS = register("slate_stairs", new BaseJinericStairBlock(STONE.getDefaultState(),FabricBlockSettings.copy(STONE)));
	public static final Block SLATE_SLAB = register("slate_slab", new SlabBlock(FabricBlockSettings.copy(STONE)));
	public static final Block SLATE_WALL = register("slate_wall", new WallBlock(FabricBlockSettings.copy(STONE)));

//MISCELLANEOUS
	//STORAGE BLOCKS
	public static final Block SALT_BLOCK = register("salt_block", new FallingBlock(FabricBlockSettings.copy(CLAY).sounds(BlockSoundGroup.SAND)));
	public static final Block SUGAR_BLOCK = register("sugar_block", new FallingBlock(FabricBlockSettings.copy(CLAY).sounds(BlockSoundGroup.SAND)));
	public static final Block ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new Block(FabricBlockSettings.copy(HONEYCOMB_BLOCK)));
	public static final Block FLINT_BLOCK = register("flint_block", new Block(FabricBlockSettings.copy(STONE)));
	public static final Block CHARCOAL_BLOCK = register("charcoal_block", new Block(FabricBlockSettings.copy(COAL_BLOCK)));
	public static final Block BAMBOO_BLOCK = register("bamboo_block", new PillarBlock(FabricBlockSettings.copy(OAK_LOG).sounds(BlockSoundGroup.BAMBOO)));
	public static final Block TUMBLEWEED = register("tumbleweed", new LeavesBlock(FabricBlockSettings.copy(DEAD_BUSH)));
	//PACKED ICE
	public static final Block PACKED_ICE_STAIRS = register("packed_ice_stairs", new BaseJinericStairBlock(PACKED_ICE.getDefaultState(),FabricBlockSettings.copy(PACKED_ICE)));
	public static final Block PACKED_ICE_SLAB  = register("packed_ice_slab", new SlabBlock(FabricBlockSettings.copy(PACKED_ICE)));
	public static final Block PACKED_ICE_WALL = register("packed_ice_wall", new WallBlock(FabricBlockSettings.copy(PACKED_ICE)));
	//SNOW & POWDERED SNOW
	public static final Block SNOW_WALL = register("snow_wall", new WallBlock(FabricBlockSettings.copy(SNOW_BLOCK)));
	//DECORATION BLOCKS
	public static final Block SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new BaseJinericCarvedPumpkinBlock(FabricBlockSettings.copy(JACK_O_LANTERN)));
	public static final Block FULL_GRASS_BLOCK = register("full_grass_block", new GrassBlock(FabricBlockSettings.copy(GRASS_BLOCK)));

	public static final Block PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", new WallBlock(FabricBlockSettings.copy(PRISMARINE_BRICKS)));
	public static final Block DARK_PRISMARINE_WALL = register("dark_prismarine_wall", new WallBlock(FabricBlockSettings.copy(DARK_PRISMARINE)));

	//SHULKER CHEST
	//public static final Block SHULKER_CHEST = register("shulker_chest", new Block(FabricBlockSettings.copy(SHULKER_BOX)));

//WOOD
	public static final Block BOREAL_WOOD = register("boreal_wood", new PillarBlock(FabricBlockSettings.copy(OAK_WOOD)));
	public static final Block BOREAL_LOG = register("boreal_log", new PillarBlock(FabricBlockSettings.copy(BOREAL_WOOD)));
	public static final Block STRIPPED_BOREAL_WOOD = register("stripped_boreal_wood", new PillarBlock(FabricBlockSettings.copy(BOREAL_WOOD)));
	public static final Block STRIPPED_BOREAL_LOG = register("stripped_boreal_log", new PillarBlock(FabricBlockSettings.copy(BOREAL_WOOD)));
	public static final Block BOREAL_PLANKS = register("boreal_planks", new Block(FabricBlockSettings.copy(OAK_PLANKS)));
	public static final Block BOREAL_SLAB = register("boreal_slab", new SlabBlock(FabricBlockSettings.copy(OAK_SLAB)));
	public static final Block BOREAL_STAIRS = register("boreal_stairs", new BaseJinericStairBlock(OAK_STAIRS.getDefaultState(),FabricBlockSettings.copy(OAK_STAIRS)));
	public static final Block BOREAL_FENCE = register("boreal_fence", new FenceBlock(FabricBlockSettings.copy(OAK_FENCE)));
	public static final Block BOREAL_FENCE_GATE = register("boreal_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(OAK_FENCE_GATE)));
	public static final Block BOREAL_TRAPDOOR = register("boreal_trapdoor", new JinericTrapdoorBlock(FabricBlockSettings.copy(OAK_TRAPDOOR)));
	//public static final Block BOREAL_PRESSURE_PLATE = register("boreal_pressure_plate", new PressurePlateBlock(FabricBlockSettings.copy(OAK_TRAPDOOR)));


	private static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, new Identifier("jineric", name), block);
	}
	public static void init() {
	}
}
