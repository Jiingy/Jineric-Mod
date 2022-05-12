package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.FullGrassBlock;
import jingy.jineric.block.OxidizableWallBlock;
import jingy.jineric.block.RefineryBlock;
import jingy.jineric.block.ShulkerChestBlock;
import jingy.jineric.block.custom.JinericCampfireBlock;
import jingy.jineric.block.custom.JinericChestBlock;
import jingy.jineric.block.custom.JinericSaplingBlock;
import jingy.jineric.block.custom.JinericStairsBlock;
import jingy.jineric.block.enums.JinericChestType;
import jingy.jineric.block.sapling.BorealSaplingGenerator;
import jingy.jineric.util.JinericSignType;
import jingy.jineric.util.RegistryObject;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

import static net.minecraft.block.Blocks.*;

public class JinericBlocks {
	public static final List<RegistryObject<Block>> BLOCKS = new ArrayList<>();
/*
FORMAT:
	public static final Block _BLOCK = register("block", new Block(FabricBlockSettings.copy(BLOCK)));
	public static final Block _STAIRS = register("_stairs", new BaseJinericStairBlock(BLOCK.getDefaultState(),FabricBlockSettings.copy(BLOCK)));
	public static final Block _SLAB = register("_slab", new SlabBlock(FabricBlockSettings.copy(BLOCK)));
	public static final Block _WALL = register("_wall", new WallBlock(FabricBlockSettings.copy(BLOCK)));
 */

	//TODO:
	// --- General Blocks ---
	//	Grindstone recipes / Block Item tags
	//	FINISH RHYOLITE & NEW TUFFS

	//TODO: STORAGE BLOCKS
	//	PRISMARINE_CRYSTAL_BLOCK
	//	GUNPOWDER_BLOCK
	//	BLAZE_ROD_BLOCK
	//	EGG_BLOCK

//SANDSTONE
	public static final Block CUT_SANDSTONE_STAIRS = register(
			"cut_sandstone_stairs", new JinericStairsBlock(CUT_SANDSTONE.getDefaultState(), Block.Settings.copy(CUT_SANDSTONE))
	);
	public static final Block CUT_SANDSTONE_WALL = register(
			"cut_sandstone_wall", new WallBlock(Block.Settings.copy(CUT_SANDSTONE))
	);
	public static final Block POLISHED_SANDSTONE = register(
			"polished_sandstone", new Block(Block.Settings.copy(SANDSTONE))
	);
	public static final Block POLISHED_SANDSTONE_STAIRS = register(
			"polished_sandstone_stairs", new JinericStairsBlock(POLISHED_SANDSTONE.getDefaultState(), Block.Settings.copy(POLISHED_SANDSTONE))
	);
	public static final Block POLISHED_SANDSTONE_SLAB  = register(
			"polished_sandstone_slab", new SlabBlock(Block.Settings.copy(POLISHED_SANDSTONE))
	);
	public static final Block POLISHED_SANDSTONE_WALL = register(
			"polished_sandstone_wall", new WallBlock(Block.Settings.copy(POLISHED_SANDSTONE))
	);
	public static final Block CHISELED_SANDSTONE_STAIRS = register(
			"chiseled_sandstone_stairs", new JinericStairsBlock(CHISELED_SANDSTONE.getDefaultState(), Block.Settings.copy(CHISELED_SANDSTONE))
	);
	public static final Block CHISELED_SANDSTONE_SLAB  = register(
			"chiseled_sandstone_slab", new SlabBlock(Block.Settings.copy(CHISELED_SANDSTONE))
	);
	public static final Block CHISELED_SANDSTONE_WALL = register(
			"chiseled_sandstone_wall", new WallBlock(Block.Settings.copy(CHISELED_SANDSTONE))
	);
	public static final Block SMOOTH_SANDSTONE_WALL = register(
			"smooth_sandstone_wall", new WallBlock(Block.Settings.copy(SMOOTH_SANDSTONE))
	);
	public static final Block WAVY_SANDSTONE = register(
			"wavy_sandstone", new Block(Block.Settings.copy(SANDSTONE))
	);
	public static final Block WAVY_SANDSTONE_STAIRS = register(
			"wavy_sandstone_stairs", new JinericStairsBlock(WAVY_SANDSTONE.getDefaultState(), Block.Settings.copy(WAVY_SANDSTONE))
	);
	public static final Block WAVY_SANDSTONE_SLAB  = register(
			"wavy_sandstone_slab", new SlabBlock(Block.Settings.copy(WAVY_SANDSTONE))
	);
	public static final Block WAVY_SANDSTONE_WALL = register(
			"wavy_sandstone_wall", new WallBlock(Block.Settings.copy(WAVY_SANDSTONE))
	);
//RED SAND
	public static final Block CUT_RED_SANDSTONE_STAIRS = register("cut_red_sandstone_stairs", new JinericStairsBlock(RED_SANDSTONE.getDefaultState(), Block.Settings.copy(RED_SANDSTONE)));
	public static final Block CUT_RED_SANDSTONE_WALL = register("cut_red_sandstone_wall", new WallBlock(Block.Settings.copy(RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE = register("polished_red_sandstone", new Block(Block.Settings.copy(RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE_STAIRS = register("polished_red_sandstone_stairs", new JinericStairsBlock(POLISHED_RED_SANDSTONE.getDefaultState(), Block.Settings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE_SLAB  = register("polished_red_sandstone_slab", new SlabBlock(Block.Settings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block POLISHED_RED_SANDSTONE_WALL = register("polished_red_sandstone_wall", new WallBlock(Block.Settings.copy(POLISHED_RED_SANDSTONE)));
	public static final Block CHISELED_RED_SANDSTONE_STAIRS = register("chiseled_red_sandstone_stairs", new JinericStairsBlock(CHISELED_RED_SANDSTONE.getDefaultState(), Block.Settings.copy(CHISELED_SANDSTONE)));
	public static final Block CHISELED_RED_SANDSTONE_SLAB  = register("chiseled_red_sandstone_slab", new SlabBlock(Block.Settings.copy(CHISELED_RED_SANDSTONE)));
	public static final Block CHISELED_RED_SANDSTONE_WALL = register("chiseled_red_sandstone_wall", new WallBlock(Block.Settings.copy(CHISELED_RED_SANDSTONE)));
	public static final Block SMOOTH_RED_SANDSTONE_WALL = register("smooth_red_sandstone_wall", new WallBlock(Block.Settings.copy(RED_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new Block(Block.Settings.copy(RED_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new JinericStairsBlock(WAVY_RED_SANDSTONE.getDefaultState(), Block.Settings.copy(WAVY_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE_SLAB  = register("wavy_red_sandstone_slab", new SlabBlock(Block.Settings.copy(WAVY_RED_SANDSTONE)));
	public static final Block WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new WallBlock(Block.Settings.copy(WAVY_RED_SANDSTONE)));

//SOUL SAND
	public static final Block SOUL_SANDSTONE = register(
			"soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings())
	);
	public static final Block SOUL_SANDSTONE_STAIRS = register(
			"soul_sandstone_stairs", new JinericStairsBlock(SOUL_SANDSTONE.getDefaultState(), Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block SOUL_SANDSTONE_SLAB  = register(
			"soul_sandstone_slab", new SlabBlock(Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block SOUL_SANDSTONE_WALL = register(
			"soul_sandstone_wall", new WallBlock(Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block CUT_SOUL_SANDSTONE = register(
			"cut_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings())
	);
	public static final Block CUT_SOUL_SANDSTONE_STAIRS = register(
			"cut_soul_sandstone_stairs", new JinericStairsBlock(SOUL_SANDSTONE.getDefaultState(), Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block CUT_SOUL_SANDSTONE_SLAB  = register(
			"cut_soul_sandstone_slab", new SlabBlock(Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block CUT_SOUL_SANDSTONE_WALL = register(
			"cut_soul_sandstone_wall", new WallBlock(Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block POLISHED_SOUL_SANDSTONE = register(
			"polished_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings())
	);
	public static final Block POLISHED_SOUL_SANDSTONE_STAIRS = register(
			"polished_soul_sandstone_stairs", new JinericStairsBlock(POLISHED_SOUL_SANDSTONE.getDefaultState(), Block.Settings.copy(POLISHED_SOUL_SANDSTONE))
	);
	public static final Block POLISHED_SOUL_SANDSTONE_SLAB  = register(
			"polished_soul_sandstone_slab", new SlabBlock(Block.Settings.copy(POLISHED_SOUL_SANDSTONE))
	);
	public static final Block POLISHED_SOUL_SANDSTONE_WALL = register(
			"polished_soul_sandstone_wall", new WallBlock(Block.Settings.copy(POLISHED_SOUL_SANDSTONE))
	);
	public static final Block CHISELED_SOUL_SANDSTONE = register(
			"chiseled_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings())
	);
	public static final Block CHISELED_SOUL_SANDSTONE_STAIRS = register(
			"chiseled_soul_sandstone_stairs", new JinericStairsBlock(SOUL_SANDSTONE.getDefaultState(), Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block CHISELED_SOUL_SANDSTONE_SLAB  = register(
			"chiseled_soul_sandstone_slab", new SlabBlock(Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block CHISELED_SOUL_SANDSTONE_WALL = register(
			"chiseled_soul_sandstone_wall", new WallBlock(Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block SMOOTH_SOUL_SANDSTONE = register(
			"smooth_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings())
	);
	public static final Block SMOOTH_SOUL_SANDSTONE_STAIRS = register(
			"smooth_soul_sandstone_stairs", new JinericStairsBlock(SMOOTH_SANDSTONE.getDefaultState(),Block.Settings.copy(SMOOTH_SOUL_SANDSTONE))
	);
	public static final Block SMOOTH_SOUL_SANDSTONE_SLAB  = register(
			"smooth_soul_sandstone_slab", new SlabBlock(Block.Settings.copy(SMOOTH_SOUL_SANDSTONE))
	);
	public static final Block SMOOTH_SOUL_SANDSTONE_WALL = register(
			"smooth_soul_sandstone_wall", new WallBlock(Block.Settings.copy(SMOOTH_SOUL_SANDSTONE))
	);
	public static final Block WAVY_SOUL_SANDSTONE = register(
			"wavy_soul_sandstone", new Block(JinericBlockSettings.soulSandstoneSettings())
	);
	public static final Block WAVY_SOUL_SANDSTONE_STAIRS = register(
			"wavy_soul_sandstone_stairs", new JinericStairsBlock(SOUL_SANDSTONE.getDefaultState(), Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block WAVY_SOUL_SANDSTONE_SLAB  = register(
			"wavy_soul_sandstone_slab", new SlabBlock(Block.Settings.copy(SOUL_SANDSTONE))
	);
	public static final Block WAVY_SOUL_SANDSTONE_WALL = register(
			"wavy_soul_sandstone_wall", new WallBlock(Block.Settings.copy(SOUL_SANDSTONE))
	);

//STONE TYPE BLOCKS:
	//STONE & SMOOTH STONE
	public static final Block STONE_WALL = register(
			"stone_wall", new WallBlock(Block.Settings.copy(STONE))
	);
	public static final Block SMOOTH_STONE_STAIRS = register(
			"smooth_stone_stairs", new JinericStairsBlock(SMOOTH_STONE.getDefaultState(), Block.Settings.copy(SMOOTH_STONE))
	);
	public static final Block SMOOTH_STONE_WALL = register(
			"smooth_stone_wall", new WallBlock(Block.Settings.copy(SMOOTH_STONE))
	);

	//DEEPSLATE
	public static final Block SMOOTH_DEEPSLATE = register(
			"smooth_deepslate", new Block(Block.Settings.copy(DEEPSLATE))
	);
	public static final Block SMOOTH_DEEPSLATE_STAIRS = register(
			"smooth_deepslate_stairs", new StairsBlock(SMOOTH_DEEPSLATE.getDefaultState(), Block.Settings.copy(SMOOTH_DEEPSLATE))
	);
	public static final Block SMOOTH_DEEPSLATE_SLAB = register(
			"smooth_deepslate_slab", new SlabBlock(Block.Settings.copy(SMOOTH_DEEPSLATE))
	);
	public static final Block SMOOTH_DEEPSLATE_WALL = register(
			"smooth_deepslate_wall", new WallBlock(Block.Settings.copy(SMOOTH_DEEPSLATE))
	);

	//DIORITE, GRANITE, ANDESITE BLOCKS
	public static final Block POLISHED_GRANITE_WALL = register(
			"polished_granite_wall", new WallBlock(Block.Settings.copy(POLISHED_GRANITE))
	);
	public static final Block POLISHED_DIORITE_WALL = register(
			"polished_diorite_wall", new WallBlock(Block.Settings.copy(POLISHED_DIORITE))
	);
	public static final Block POLISHED_ANDESITE_WALL = register(
			"polished_andesite_wall", new WallBlock(Block.Settings.copy(POLISHED_ANDESITE))
	);

	//CRACKED STONE BRICK
	public static final Block CRACKED_STONE_BRICK_STAIRS = register(
			"cracked_stone_brick_stairs", new JinericStairsBlock(STONE.getDefaultState(), Block.Settings.copy(STONE))
	);
	public static final Block CRACKED_STONE_BRICK_SLAB  = register(
			"cracked_stone_brick_slab", new SlabBlock(Block.Settings.copy(STONE))
	);
	public static final Block CRACKED_STONE_BRICK_WALL = register(
			"cracked_stone_brick_wall", new WallBlock(Block.Settings.copy(STONE))
	);

	//TUFF
	public static final Block TUFF_STAIRS = register(
			"tuff_stairs", new JinericStairsBlock(TUFF.getDefaultState(), Block.Settings.copy(TUFF))
	);
	public static final Block TUFF_SLAB = register(
			"tuff_slab", new SlabBlock(Block.Settings.copy(TUFF))
	);
	public static final Block TUFF_WALL = register(
			"tuff_wall", new WallBlock(Block.Settings.copy(TUFF))
	);

	//POLISHED TUFF
	public static final Block POLISHED_TUFF = register(
			"polished_tuff", new Block(Block.Settings.copy(TUFF))
	);
	public static final Block POLISHED_TUFF_STAIRS = register(
			"polished_tuff_stairs", new JinericStairsBlock(POLISHED_TUFF.getDefaultState(), Block.Settings.copy(POLISHED_TUFF))
	);
	public static final Block POLISHED_TUFF_SLAB = register(
			"polished_tuff_slab", new SlabBlock(Block.Settings.copy(POLISHED_TUFF))
	);
	public static final Block POLISHED_TUFF_WALL = register(
			"polished_tuff_wall", new WallBlock(Block.Settings.copy(POLISHED_TUFF))
	);
	
	// Smooth
	public static final Block SMOOTH_TUFF = register(
			"smooth_tuff", new Block(Block.Settings.copy(TUFF))
	);
	public static final Block SMOOTH_TUFF_SLAB = register(
			"smooth_tuff_slab", new SlabBlock(Block.Settings.copy(SMOOTH_TUFF))
	);
	public static final Block SMOOTH_TUFF_STAIRS = register(
			"smooth_tuff_stairs", new JinericStairsBlock(SMOOTH_TUFF.getDefaultState(), Block.Settings.copy(SMOOTH_TUFF))
	);
	public static final Block SMOOTH_TUFF_WALL = register(
			"smooth_tuff_wall", new WallBlock(Block.Settings.copy(SMOOTH_TUFF))
	);
	// BRICKS
	public static final Block TUFF_BRICKS = register(
			"tuff_bricks", new Block(Block.Settings.copy(TUFF))
	);
	public static final Block TUFF_BRICK_SLAB = register(
			"tuff_brick_slab", new SlabBlock(Block.Settings.copy(TUFF_BRICKS))
	);
	public static final Block TUFF_BRICK_STAIRS = register(
			"tuff_brick_stairs", new JinericStairsBlock(TUFF_BRICKS.getDefaultState(), Block.Settings.copy(TUFF_BRICKS))
	);
	public static final Block TUFF_BRICK_WALL = register(
			"tuff_brick_wall", new WallBlock(Block.Settings.copy(TUFF_BRICKS))
	);

	//CALCITE
	public static final Block CALCITE_STAIRS = register(
			"calcite_stairs", new JinericStairsBlock(CALCITE.getDefaultState(), Block.Settings.copy(CALCITE))
	);
	public static final Block CALCITE_SLAB = register(
			"calcite_slab", new SlabBlock(Block.Settings.copy(CALCITE))
	);
	public static final Block CALCITE_WALL = register(
			"calcite_wall", new WallBlock(Block.Settings.copy(CALCITE))
	);
	public static final Block POLISHED_CALCITE = register(
			"polished_calcite", new Block(Block.Settings.copy(CALCITE))
	);
	public static final Block POLISHED_CALCITE_STAIRS = register(
			"polished_calcite_stairs", new JinericStairsBlock(POLISHED_CALCITE.getDefaultState(), Block.Settings.copy(POLISHED_CALCITE))
	);
	public static final Block POLISHED_CALCITE_SLAB = register(
			"polished_calcite_slab", new SlabBlock(Block.Settings.copy(POLISHED_CALCITE))
	);
	public static final Block POLISHED_CALCITE_WALL = register(
			"polished_calcite_wall", new WallBlock(Block.Settings.copy(POLISHED_CALCITE))
	);
	public static final Block CALCITE_BRICKS = register(
			"calcite_bricks", new Block(Block.Settings.copy(CALCITE))
	);
	public static final Block CALCITE_BRICK_STAIRS = register(
			"calcite_brick_stairs", new JinericStairsBlock(CALCITE_BRICKS.getDefaultState(), Block.Settings.copy(CALCITE_BRICKS))
	);
	public static final Block CALCITE_BRICK_SLAB = register(
			"calcite_brick_slab", new SlabBlock(Block.Settings.copy(CALCITE_BRICKS))
	);
	public static final Block CALCITE_BRICK_WALL = register(
			"calcite_brick_wall", new WallBlock(Block.Settings.copy(CALCITE_BRICKS))
	);
	public static final Block SMOOTH_CALCITE = register(
			"smooth_calcite", new Block(Block.Settings.copy(CALCITE))
	);
	public static final Block SMOOTH_CALCITE_STAIRS = register(
			"smooth_calcite_stairs", new JinericStairsBlock(SMOOTH_CALCITE.getDefaultState(), Block.Settings.copy(SMOOTH_CALCITE))
	);
	public static final Block SMOOTH_CALCITE_SLAB = register(
			"smooth_calcite_slab", new SlabBlock(Block.Settings.copy(SMOOTH_CALCITE))
	);
	public static final Block SMOOTH_CALCITE_WALL = register(
			"smooth_calcite_wall", new WallBlock(Block.Settings.copy(SMOOTH_CALCITE))
	);

	//DRIPSTONE
	public static final Block DRIPSTONE_SLAB  = register(
			"dripstone_slab", new SlabBlock(Block.Settings.copy(DRIPSTONE_BLOCK))
	);
	public static final Block DRIPSTONE_STAIRS = register(
			"dripstone_stairs", new JinericStairsBlock(STONE.getDefaultState(), Block.Settings.copy(DRIPSTONE_BLOCK))
	);
	public static final Block DRIPSTONE_WALL = register(
			"dripstone_wall", new WallBlock(Block.Settings.copy(DRIPSTONE_BLOCK))
	);
	public static final Block POLISHED_DRIPSTONE = register(
			"polished_dripstone", new Block(Block.Settings.copy(DRIPSTONE_BLOCK))
	);
	public static final Block POLISHED_DRIPSTONE_SLAB  = register(
			"polished_dripstone_slab", new SlabBlock(Block.Settings.copy(POLISHED_DRIPSTONE))
	);
	public static final Block POLISHED_DRIPSTONE_STAIRS = register(
			"polished_dripstone_stairs", new JinericStairsBlock(STONE.getDefaultState(), Block.Settings.copy(POLISHED_DRIPSTONE))
	);
	public static final Block POLISHED_DRIPSTONE_WALL = register(
			"polished_dripstone_wall", new WallBlock(Block.Settings.copy(POLISHED_DRIPSTONE))
	);

	//OBSIDIAN
	public static final Block OBSIDIAN_STAIRS = register(
			"obsidian_stairs", new JinericStairsBlock(OBSIDIAN.getDefaultState(), JinericBlockSettings.obsidianSettings().nonOpaque())
	);
	public static final Block OBSIDIAN_SLAB  = register(
			"obsidian_slab", new SlabBlock(JinericBlockSettings.obsidianSettings().nonOpaque())
	);
	public static final Block OBSIDIAN_WALL = register(
			"obsidian_wall", new WallBlock(JinericBlockSettings.obsidianSettings().nonOpaque())
	);

	//rhyolite
	public static final Block RHYOLITE = register(
			"rhyolite", new Block(Block.Settings.copy(STONE))
	);
	public static final Block RHYOLITE_STAIRS = register(
			"rhyolite_stairs", new JinericStairsBlock(STONE.getDefaultState(), Block.Settings.copy(STONE))
	);
	public static final Block RHYOLITE_SLAB  = register(
			"rhyolite_slab", new SlabBlock(Block.Settings.copy(STONE))
	);
	public static final Block RHYOLITE_WALL = register(
			"rhyolite_wall", new WallBlock(Block.Settings.copy(STONE))
	);

	//SILTSTONE
	public static final Block SILTSTONE = register(
			"siltstone", new Block(Block.Settings.copy(STONE))
	);
	public static final Block SILTSTONE_STAIRS = register(
			"siltstone_stairs", new JinericStairsBlock(STONE.getDefaultState(), Block.Settings.copy(STONE))
	);
	public static final Block SILTSTONE_SLAB  = register(
			"siltstone_slab", new SlabBlock(Block.Settings.copy(STONE))
	);
	public static final Block SILTSTONE_WALL = register(
			"siltstone_wall", new WallBlock(Block.Settings.copy(STONE))
	);

	//POLISHED_SILTSTONE
	public static final Block POLISHED_SILTSTONE = register(
			"polished_siltstone", new Block(Block.Settings.copy(STONE))
	);
	public static final Block POLISHED_SILTSTONE_STAIRS = register(
			"polished_siltstone_stairs", new JinericStairsBlock(STONE.getDefaultState(), Block.Settings.copy(STONE))
	);
	public static final Block POLISHED_SILTSTONE_SLAB  = register(
			"polished_siltstone_slab", new SlabBlock(Block.Settings.copy(STONE))
	);
	public static final Block POLISHED_SILTSTONE_WALL = register(
			"polished_siltstone_wall", new WallBlock(Block.Settings.copy(STONE))
	);

	//SLATE
	public static final Block SLATE = register(
			"slate", new Block(Block.Settings.copy(STONE))
	);
	public static final Block SLATE_STAIRS = register(
			"slate_stairs", new JinericStairsBlock(STONE.getDefaultState(), Block.Settings.copy(STONE))
	);
	public static final Block SLATE_SLAB = register(
			"slate_slab", new SlabBlock(Block.Settings.copy(STONE))
	);
	public static final Block SLATE_WALL = register(
			"slate_wall", new WallBlock(Block.Settings.copy(STONE))
	);

//MISCELLANEOUS
	//PACKED ITEM BLOCKS
	public static final Block SALT_BLOCK = register(
			"salt_block", new FallingBlock(Block.Settings.copy(CLAY).sounds(BlockSoundGroup.SAND))
	);
	public static final Block SUGAR_BLOCK = register(
			"sugar_block", new FallingBlock(Block.Settings.copy(CLAY).sounds(BlockSoundGroup.SAND))
	);
	public static final Block ROTTEN_FLESH_BLOCK = register(
			"rotten_flesh_block", new Block(Block.Settings.copy(HONEYCOMB_BLOCK))
	);
	public static final Block FLINT_BLOCK = register(
			"flint_block", new Block(Block.Settings.copy(STONE))
	);
	public static final Block CHARCOAL_BLOCK = register(
			"charcoal_block", new Block(Block.Settings.copy(COAL_BLOCK))
	);
	public static final Block BAMBOO_BLOCK = register(
			"bamboo_block", new PillarBlock(Block.Settings.copy(OAK_LOG).sounds(BlockSoundGroup.BAMBOO))
	);
	public static final Block TUMBLEWEED = register(
			"tumbleweed", JinericBlockSettings.JinericLeavesBlock(BlockSoundGroup.GRASS)
	);
	public static final Block BONE_MEAL_BLOCK = register(
			"bone_meal_block", new Block(FabricBlockSettings.copy(BONE_BLOCK))
	);
	public static final Block ENDER_PEARL_BLOCK = register(
			"ender_pearl_block", new Block(FabricBlockSettings.copy(HONEY_BLOCK))
	);
	//TODO: Finish implementing:
	public static final Block PRISMARINE_CRYSTAL_BLOCK = register(
			"prismarine_crystal_block", new Block(FabricBlockSettings.copy(SEA_LANTERN).luminance(state -> 15))
	);
	public static final Block GUNPOWDER_BLOCK = register(
			"gunpowder_block", new Block(FabricBlockSettings.copy(SAND))
	);
	public static final Block BLAZE_ROD_BLOCK = register(
			"blaze_rod_block", new Block(FabricBlockSettings.copy(COAL_BLOCK))
	);
	public static final Block EGG_BLOCK = register(
			"egg_block", new Block(FabricBlockSettings.copy(CALCITE))
	);

	//PACKED ICE
	public static final Block PACKED_ICE_STAIRS = register("packed_ice_stairs", new JinericStairsBlock(PACKED_ICE.getDefaultState(), FabricBlockSettings.copy(PACKED_ICE)));
	public static final Block PACKED_ICE_SLAB  = register("packed_ice_slab", new SlabBlock(FabricBlockSettings.copy(PACKED_ICE)));
	public static final Block PACKED_ICE_WALL = register("packed_ice_wall", new WallBlock(FabricBlockSettings.copy(PACKED_ICE)));

	//SNOW & POWDERED SNOW
	public static final Block SNOW_WALL = register("snow_wall", new WallBlock(FabricBlockSettings.copy(SNOW_BLOCK)));

	//DECORATION BLOCKS
	public static final Block SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new CarvedPumpkinBlock(FabricBlockSettings.copy(JACK_O_LANTERN)));
	public static final Block FULL_GRASS_BLOCK = register("full_grass_block", new FullGrassBlock(FabricBlockSettings.copy(GRASS_BLOCK)));

	public static final Block PRISMARINE_BRICK_WALL = register("prismarine_brick_wall", new WallBlock(FabricBlockSettings.copy(PRISMARINE_BRICKS)));
	public static final Block DARK_PRISMARINE_WALL = register("dark_prismarine_wall", new WallBlock(FabricBlockSettings.copy(DARK_PRISMARINE)));
	public static final Block CUT_COPPER_WALL = register("cut_copper_wall", new OxidizableWallBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copy(CUT_COPPER)));
	public static final Block EXPOSED_CUT_COPPER_WALL = register("exposed_cut_copper_wall", new OxidizableWallBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copy(EXPOSED_CUT_COPPER)));
	public static final Block WEATHERED_CUT_COPPER_WALL = register("weathered_cut_copper_wall", new OxidizableWallBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copy(WEATHERED_CUT_COPPER)));
	public static final Block OXIDIZED_CUT_COPPER_WALL = register("oxidized_cut_copper_wall", new OxidizableWallBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copy(OXIDIZED_CUT_COPPER)));
	public static final Block WAXED_CUT_COPPER_WALL = register("waxed_cut_copper_wall", new OxidizableWallBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copy(CUT_COPPER)));
	public static final Block WAXED_EXPOSED_CUT_COPPER_WALL = register("waxed_exposed_cut_copper_wall", new OxidizableWallBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copy(EXPOSED_CUT_COPPER)));
	public static final Block WAXED_WEATHERED_CUT_COPPER_WALL = register("waxed_weathered_cut_copper_wall", new OxidizableWallBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copy(WEATHERED_CUT_COPPER)));
	public static final Block WAXED_OXIDIZED_CUT_COPPER_WALL = register("waxed_oxidized_cut_copper_wall", new OxidizableWallBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copy(OXIDIZED_CUT_COPPER)));


	//TODO:
	//	Make sure shulker chest block format change works

	//CHESTS
	public static final Block ACACIA_CHEST = register(
			"acacia_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), JinericChestType.ACACIA)
	);

	public static final Block BIRCH_CHEST = register(
			"birch_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), JinericChestType.BIRCH)
	);

	public static final Block BOREAL_CHEST = register(
			"boreal_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), JinericChestType.BOREAL)
	);

	public static final Block CRIMSON_CHEST = register(
			"crimson_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), JinericChestType.CRIMSON)
	);

	public static final Block DARK_OAK_CHEST = register(
			"dark_oak_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), JinericChestType.DARK_OAK)
	);

	public static final Block JUNGLE_CHEST = register(
			"jungle_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), JinericChestType.JUNGLE)
	);

	public static final Block SHULKER_CHEST = register(
			"shulker_chest", new ShulkerChestBlock(FabricBlockSettings.of(Material.STONE), JinericChestType.SHULKER)
	);

	public static final Block SPRUCE_CHEST = register(
			"spruce_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), JinericChestType.SPRUCE)
	);

	public static final Block WARPED_CHEST = register(
			"warped_chest", new JinericChestBlock(FabricBlockSettings.copy(CHEST), JinericChestType.WARPED)
	);

	//	REFINERY
	public static final Block REFINERY = register(
			"refinery", new RefineryBlock(AbstractBlock.Settings
					.copy(FURNACE)
					.luminance(createLightLevelFromLitBlockState(13))
			)
	);

//REDSTONE
	public static final Block REDSTONE_LANTERN = register("redstone_lantern", new LanternBlock(JinericBlockSettings.redstoneLanternSettings()));
	public static final Block REDSTONE_CAMPFIRE = register("redstone_campfire", new JinericCampfireBlock(true, 1, JinericBlockSettings.redstoneCampfireSettings()));

//WOOD
	//BOREAL
	public static final Block BOREAL_WOOD = register("boreal_wood",
		new PillarBlock(FabricBlockSettings.copy(OAK_WOOD))
	);

	public static final Block BOREAL_LOG = register("boreal_log",
			new PillarBlock(FabricBlockSettings.copy(OAK_LOG))
	);

	public static final Block STRIPPED_BOREAL_WOOD = register("stripped_boreal_wood",
			new PillarBlock(FabricBlockSettings.copy(OAK_WOOD)));

	public static final Block STRIPPED_BOREAL_LOG = register("stripped_boreal_log",
			new PillarBlock(FabricBlockSettings.copy(OAK_LOG))
	);

	public static final Block BOREAL_PLANKS = register("boreal_planks",
			new Block(FabricBlockSettings.copy(OAK_PLANKS))
	);

	public static final Block BOREAL_STAIRS = register("boreal_stairs",
			new JinericStairsBlock(OAK_STAIRS.getDefaultState(), FabricBlockSettings.copy(OAK_STAIRS))
	);

	public static final Block BOREAL_SLAB = register("boreal_slab",
			new SlabBlock(FabricBlockSettings.copy(OAK_SLAB))
	);

	public static final Block BOREAL_BOOKSHELF = register("boreal_bookshelf",
			new Block(FabricBlockSettings.copy(BOOKSHELF))
	);

	public static final Block BOREAL_LADDER = register(
			"boreal_ladder", new LadderBlock(FabricBlockSettings.copy(LADDER))
	);

	public static final Block BOREAL_FENCE = register("boreal_fence",
			new FenceBlock(FabricBlockSettings.copy(OAK_FENCE))
	);

	public static final Block BOREAL_SIGN = register("boreal_sign",
			new SignBlock(FabricBlockSettings.copy(OAK_SIGN), JinericSignType.BOREAL)
	);

	public static final Block BOREAL_WALL_SIGN = register("boreal_wall_sign",
			new WallSignBlock(FabricBlockSettings.copy(OAK_WALL_SIGN), JinericSignType.BOREAL)
	);

	public static final Block BOREAL_BUTTON = register("boreal_button", new WoodenButtonBlock(FabricBlockSettings.copy((OAK_BUTTON))));
	public static final Block BOREAL_PRESSURE_PLATE = register("boreal_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.copy(OAK_PRESSURE_PLATE)));
	public static final Block BOREAL_DOOR = register("boreal_door", new DoorBlock(Block.Settings.copy(OAK_DOOR)));
	public static final Block BOREAL_TRAPDOOR = register("boreal_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(OAK_TRAPDOOR)));
	public static final Block BOREAL_FENCE_GATE = register("boreal_fence_gate", new FenceGateBlock(Block.Settings.copy(OAK_FENCE_GATE)));
	public static final Block BOREAL_SAPLING = register("boreal_sapling", new JinericSaplingBlock(new BorealSaplingGenerator(), FabricBlockSettings.copy(OAK_SAPLING)));
	public static final Block BOREAL_LEAVES = register("boreal_leaves", JinericBlockSettings.JinericLeavesBlock(BlockSoundGroup.GRASS));
/*
	//DRIED BAMBOO
	public static final Block DRIED_BAMBOO_WOOD = register("dried_bamboo_wood", new PillarBlock(FabricBlockSettings.copy(OAK_WOOD)));
	public static final Block DRIED_BAMBOO_LOG = register("dried_bamboo_log", new PillarBlock(FabricBlockSettings.copy(OAK_LOG)));
	public static final Block STRIPPED_DRIED_BAMBOO_WOOD = register("stripped_dried_bamboo_wood", new PillarBlock(FabricBlockSettings.copy(OAK_WOOD)));
	public static final Block STRIPPED_DRIED_BAMBOO_LOG = register("stripped_dried_bamboo_log", new PillarBlock(FabricBlockSettings.copy(OAK_LOG)));
	public static final Block DRIED_BAMBOO_PLANKS = register("dried_bamboo_planks", new Block(FabricBlockSettings.copy(OAK_PLANKS)));
	public static final Block DRIED_BAMBOO_STAIRS = register("dried_bamboo_stairs", new JinericStairsBlock(OAK_STAIRS.getDefaultState(), FabricBlockSettings.copy(OAK_STAIRS)));
	public static final Block DRIED_BAMBOO_SLAB = register("dried_bamboo_slab", new SlabBlock(FabricBlockSettings.copy(OAK_SLAB)));
	public static final Block DRIED_BAMBOO_FENCE = register("dried_bamboo_fence", new FenceBlock(FabricBlockSettings.copy(OAK_FENCE)));
	//public static final Block DRIED_BAMBOO_SIGN = register("dried_bamboo_sign", new SignBlock(FabricBlockSettings.copy(OAK_SIGN), JinericSignType.BOREAL));
	//public static final Block DRIED_BAMBOO_WALL_SIGN = register("dried_bamboo_wall_sign", new JinericWallSignBlock(FabricBlockSettings.copy(OAK_SIGN), JinericSignType.BOREAL));
	public static final Block DRIED_BAMBOO_BUTTON = register("dried_bamboo_button", new JinericWoodenButtonBlock(Boolean.getBoolean(String.valueOf(POWERED)), FabricBlockSettings.copy((OAK_BUTTON))));
	public static final Block DRIED_BAMBOO_PRESSURE_PLATE = register("dried_bamboo_pressure_plate", new JinericWoodenPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.copy(OAK_PRESSURE_PLATE)));
	public static final Block DRIED_BAMBOO_DOOR = register("dried_bamboo_door", new DoorBlock(Block.Settings.copy(OAK_DOOR)));
	public static final Block DRIED_BAMBOO_TRAPDOOR = register("dried_bamboo_trapdoor", new JinericWoodenTrapdoorBlock(OAK_TRAPDOOR.getDefaultState(), FabricBlockSettings.copy(OAK_TRAPDOOR).sounds(BlockSoundGroup.WOOD)));
	public static final Block DRIED_BAMBOO_FENCE_GATE = register("dried_bamboo_fence_gate", new FenceGateBlock(Block.Settings.copy(OAK_FENCE_GATE)));
	public static final Block DRIED_BAMBOO_SAPLING = register("dried_bamboo_sapling", new JinericSaplingBlock(new BorealSaplingGenerator(), FabricBlockSettings.copy(OAK_SAPLING)));
	public static final Block DRIED_BAMBOO_LEAVES = register("dried_bamboo_leaves", new LeavesBlock(JinericBlockSettings.JinericLeavesBlock(BlockSoundGroup.GRASS)));
*/

	//ICE SLIPPERINESS
	public static boolean isSlipperyBlock(BlockState state) {
		return state.isOf(PACKED_ICE_STAIRS) || state.isOf(PACKED_ICE_SLAB) || state.isOf(PACKED_ICE_WALL);
	}

	private static Block register(String id, Block block) {
		return Registry.register(Registry.BLOCK, new Identifier(JinericMain.MOD_ID, id), block);
	}

	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return state -> state.get(Properties.LIT) ? litLevel : 0;
	}

	public static void blockRegistry() {

	}
}