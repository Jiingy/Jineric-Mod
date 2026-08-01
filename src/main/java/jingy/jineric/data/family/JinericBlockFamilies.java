package jingy.jineric.data.family;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Blocks;

public class JinericBlockFamilies extends BlockFamilies {
	public static final BlockFamily DRIPSTONE_BLOCK = familyBuilder(Blocks.DRIPSTONE_BLOCK)
			.stairs(JinericBlocks.DRIPSTONE_STAIRS)
			.slab(JinericBlocks.DRIPSTONE_SLAB)
			.wall(JinericBlocks.DRIPSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SMOOTH_STONE = familyBuilder(Blocks.SMOOTH_STONE)
			.stairs(JinericBlocks.SMOOTH_STONE_STAIRS)
			.slab(Blocks.SMOOTH_STONE_SLAB)
			.wall(JinericBlocks.SMOOTH_STONE_WALL)
			.dontGenerateCraftingRecipe()
			.dontGenerateModel()
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SMOOTH_TUFF = familyBuilder(JinericBlocks.SMOOTH_TUFF)
			.stairs(JinericBlocks.SMOOTH_TUFF_STAIRS)
			.slab(JinericBlocks.SMOOTH_TUFF_SLAB)
			.wall(JinericBlocks.SMOOTH_TUFF_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_TUFF_BRICKS = familyBuilder(JinericBlocks.CRACKED_TUFF_BRICKS)
			.stairs(JinericBlocks.CRACKED_TUFF_BRICK_STAIRS)
			.slab(JinericBlocks.CRACKED_TUFF_BRICK_SLAB)
			.wall(JinericBlocks.CRACKED_TUFF_BRICK_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily TUFF_TILES = familyBuilder(JinericBlocks.TUFF_TILES)
			.stairs(JinericBlocks.TUFF_TILE_STAIRS)
			.slab(JinericBlocks.TUFF_TILE_SLAB)
			.wall(JinericBlocks.TUFF_TILE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_TUFF_TILES = familyBuilder(JinericBlocks.CRACKED_TUFF_TILES)
			.stairs(JinericBlocks.CRACKED_TUFF_TILE_STAIRS)
			.slab(JinericBlocks.CRACKED_TUFF_TILE_SLAB)
			.wall(JinericBlocks.CRACKED_TUFF_TILE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_STONE_BRICKS = familyBuilder(Blocks.CRACKED_STONE_BRICKS)
			.stairs(JinericBlocks.CRACKED_STONE_BRICK_STAIRS)
			.slab(JinericBlocks.CRACKED_STONE_BRICK_SLAB)
			.wall(JinericBlocks.CRACKED_STONE_BRICK_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_DEEPSLATE_BRICKS = familyBuilder(Blocks.CRACKED_DEEPSLATE_BRICKS)
			.stairs(JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS)
			.slab(JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB)
			.wall(JinericBlocks.CRACKED_DEEPSLATE_BRICK_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_DEEPSLATE_TILES = familyBuilder(Blocks.CRACKED_DEEPSLATE_TILES)
			.stairs(JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS)
			.slab(JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB)
			.wall(JinericBlocks.CRACKED_DEEPSLATE_TILE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_NETHER_BRICKS = familyBuilder(Blocks.CRACKED_NETHER_BRICKS)
			.stairs(JinericBlocks.CRACKED_NETHER_BRICK_STAIRS)
			.slab(JinericBlocks.CRACKED_NETHER_BRICK_SLAB)
			.wall(JinericBlocks.CRACKED_NETHER_BRICK_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_POLISHED_BLACKSTONE_BRICKS = familyBuilder(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)
			.stairs(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS)
			.slab(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB)
			.wall(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SMOOTH_BASALT = familyBuilder(Blocks.SMOOTH_BASALT)
			.stairs(JinericBlocks.SMOOTH_BASALT_STAIRS)
			.slab(JinericBlocks.SMOOTH_BASALT_SLAB)
			.wall(JinericBlocks.SMOOTH_BASALT_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily QUARTZ_BRICKS = familyBuilder(Blocks.QUARTZ_BRICKS)
			.stairs(JinericBlocks.QUARTZ_BRICK_STAIRS)
			.slab(JinericBlocks.QUARTZ_BRICK_SLAB)
			.wall(JinericBlocks.QUARTZ_BRICK_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily OBSIDIAN = familyBuilder(Blocks.OBSIDIAN)
			.stairs(JinericBlocks.OBSIDIAN_STAIRS)
			.slab(JinericBlocks.OBSIDIAN_SLAB)
			.wall(JinericBlocks.OBSIDIAN_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CALCITE = familyBuilder(Blocks.CALCITE)
			.stairs(JinericBlocks.CALCITE_STAIRS)
			.slab(JinericBlocks.CALCITE_SLAB)
			.wall(JinericBlocks.CALCITE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily PACKED_ICE = familyBuilder(Blocks.PACKED_ICE)
			.stairs(JinericBlocks.PACKED_ICE_STAIRS)
			.slab(JinericBlocks.PACKED_ICE_SLAB)
			.wall(JinericBlocks.PACKED_ICE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SNOW = familyBuilder(Blocks.SNOW)
			.wall(JinericBlocks.SNOW_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SNOW_BRICKS = familyBuilder(JinericBlocks.SNOW_BRICKS)
			.stairs(JinericBlocks.SNOW_BRICK_STAIRS)
			.slab(JinericBlocks.SNOW_BRICK_SLAB)
			.wall(JinericBlocks.SNOW_BRICK_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily POLISHED_DRIPSTONE = familyBuilder(JinericBlocks.POLISHED_DRIPSTONE)
			.stairs(JinericBlocks.POLISHED_DRIPSTONE_STAIRS)
			.slab(JinericBlocks.POLISHED_DRIPSTONE_SLAB)
			.wall(JinericBlocks.POLISHED_DRIPSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily DRIPSTONE_BRICKS = familyBuilder(JinericBlocks.DRIPSTONE_BRICKS)
			.stairs(JinericBlocks.DRIPSTONE_BRICK_STAIRS)
			.slab(JinericBlocks.DRIPSTONE_BRICK_SLAB)
			.wall(JinericBlocks.DRIPSTONE_BRICK_WALL)
			.chiseled(JinericBlocks.CHISELED_DRIPSTONE_BRICKS)
			.pillar$jineric(JinericBlocks.DRIPSTONE_BRICK_PILLAR)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_DRIPSTONE_BRICKS = familyBuilder(JinericBlocks.CRACKED_DRIPSTONE_BRICKS)
			.stairs(JinericBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS)
			.slab(JinericBlocks.CRACKED_DRIPSTONE_BRICK_SLAB)
			.wall(JinericBlocks.CRACKED_DRIPSTONE_BRICK_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily DRIPSTONE_TILES = familyBuilder(JinericBlocks.DRIPSTONE_TILES)
			.stairs(JinericBlocks.DRIPSTONE_TILE_STAIRS)
			.slab(JinericBlocks.DRIPSTONE_TILE_SLAB)
			.wall(JinericBlocks.DRIPSTONE_TILE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_DRIPSTONE_TILES = familyBuilder(JinericBlocks.CRACKED_DRIPSTONE_TILES)
			.stairs(JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS)
			.slab(JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB)
			.wall(JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SMOOTH_DRIPSTONE = familyBuilder(JinericBlocks.SMOOTH_DRIPSTONE)
			.stairs(JinericBlocks.SMOOTH_DRIPSTONE_STAIRS)
			.slab(JinericBlocks.SMOOTH_DRIPSTONE_SLAB)
			.wall(JinericBlocks.SMOOTH_DRIPSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily POLISHED_STONE = familyBuilder(JinericBlocks.POLISHED_STONE)
			.stairs(JinericBlocks.POLISHED_STONE_STAIRS)
			.slab(JinericBlocks.POLISHED_STONE_SLAB)
			.wall(JinericBlocks.POLISHED_STONE_WALL)
			.dontGenerateModel()
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily STONE_TILES = familyBuilder(JinericBlocks.STONE_TILES)
			.stairs(JinericBlocks.STONE_TILE_STAIRS)
			.slab(JinericBlocks.STONE_TILE_SLAB)
			.wall(JinericBlocks.STONE_TILE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CRACKED_STONE_TILES = familyBuilder(JinericBlocks.CRACKED_STONE_TILES)
			.stairs(JinericBlocks.CRACKED_STONE_TILE_STAIRS)
			.slab(JinericBlocks.CRACKED_STONE_TILE_SLAB)
			.wall(JinericBlocks.CRACKED_STONE_TILE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SMOOTH_DEEPSLATE = familyBuilder(JinericBlocks.SMOOTH_DEEPSLATE)
			.stairs(JinericBlocks.SMOOTH_DEEPSLATE_STAIRS)
			.slab(JinericBlocks.SMOOTH_DEEPSLATE_SLAB)
			.wall(JinericBlocks.SMOOTH_DEEPSLATE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily POLISHED_SANDSTONE = familyBuilder(JinericBlocks.POLISHED_SANDSTONE)
			.stairs(JinericBlocks.POLISHED_SANDSTONE_STAIRS)
			.slab(JinericBlocks.POLISHED_SANDSTONE_SLAB)
			.wall(JinericBlocks.POLISHED_SANDSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily WAVY_SANDSTONE = familyBuilder(JinericBlocks.WAVY_SANDSTONE)
			.stairs(JinericBlocks.WAVY_SANDSTONE_STAIRS)
			.slab(JinericBlocks.WAVY_SANDSTONE_SLAB)
			.wall(JinericBlocks.WAVY_SANDSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily POLISHED_RED_SANDSTONE = familyBuilder(JinericBlocks.POLISHED_RED_SANDSTONE)
			.stairs(JinericBlocks.POLISHED_RED_SANDSTONE_STAIRS)
			.slab(JinericBlocks.POLISHED_RED_SANDSTONE_SLAB)
			.wall(JinericBlocks.POLISHED_RED_SANDSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily WAVY_RED_SANDSTONE = familyBuilder(JinericBlocks.WAVY_RED_SANDSTONE)
			.stairs(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS)
			.slab(JinericBlocks.WAVY_RED_SANDSTONE_SLAB)
			.wall(JinericBlocks.WAVY_RED_SANDSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SOUL_SANDSTONE = familyBuilder(JinericBlocks.SOUL_SANDSTONE)
			.stairs(JinericBlocks.SOUL_SANDSTONE_STAIRS)
			.slab(JinericBlocks.SOUL_SANDSTONE_SLAB)
			.wall(JinericBlocks.SOUL_SANDSTONE_WALL)
			.chiseled(JinericBlocks.CHISELED_SOUL_SANDSTONE)
			.dontGenerateModel()
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily SMOOTH_SOUL_SANDSTONE = familyBuilder(JinericBlocks.SMOOTH_SOUL_SANDSTONE)
			.stairs(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS)
			.slab(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB)
			.wall(JinericBlocks.SMOOTH_SOUL_SANDSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily CUT_SOUL_SANDSTONE = familyBuilder(JinericBlocks.CUT_SOUL_SANDSTONE)
			.stairs(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS)
			.slab(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB)
			.wall(JinericBlocks.CUT_SOUL_SANDSTONE_WALL)
			.dontGenerateModel()
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily POLISHED_SOUL_SANDSTONE = familyBuilder(JinericBlocks.POLISHED_SOUL_SANDSTONE)
			.stairs(JinericBlocks.POLISHED_SOUL_SANDSTONE_STAIRS)
			.slab(JinericBlocks.POLISHED_SOUL_SANDSTONE_SLAB)
			.wall(JinericBlocks.POLISHED_SOUL_SANDSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static final BlockFamily WAVY_SOUL_SANDSTONE = familyBuilder(JinericBlocks.WAVY_SOUL_SANDSTONE)
			.stairs(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS)
			.slab(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB)
			.wall(JinericBlocks.WAVY_SOUL_SANDSTONE_WALL)
			.modded$Jineric()
			.getFamily();
	
	public static void initialize() {
	}
}
