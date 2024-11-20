package jingy.jineric.data.family;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.mixin.access.BaseBlocksToFamiliesAccess;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

public class JinericBlockFamilies {

//    public static final BlockFamily  = register(JinericBlocks.)
//            .stairs(JinericBlocks._STAIRS)
//            .slab(JinericBlocks._SLAB)
//            .wall(JinericBlocks._WALL)
//            .build();


    public static final BlockFamily SMOOTH_STONE = register(Blocks.SMOOTH_STONE)
            .stairs(JinericBlocks.SMOOTH_STONE_STAIRS)
            .slab(Blocks.SMOOTH_STONE_SLAB)
            .wall(JinericBlocks.SMOOTH_STONE_WALL)
            .build();

    public static final BlockFamily CRACKED_STONE_BRICKS = register(Blocks.CRACKED_STONE_BRICKS)
            .stairs(JinericBlocks.CRACKED_STONE_BRICK_STAIRS)
            .slab(JinericBlocks.CRACKED_STONE_BRICK_SLAB)
            .wall(JinericBlocks.CRACKED_STONE_BRICK_WALL)
            .build();

    public static final BlockFamily CRACKED_DEEPSLATE_BRICKS = register(Blocks.CRACKED_DEEPSLATE_BRICKS)
            .stairs(JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS)
            .slab(JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB)
            .wall(JinericBlocks.CRACKED_DEEPSLATE_BRICK_WALL)
            .build();

    public static final BlockFamily CRACKED_DEEPSLATE_TILES = register(Blocks.CRACKED_DEEPSLATE_TILES)
            .stairs(JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS)
            .slab(JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB)
            .wall(JinericBlocks.CRACKED_DEEPSLATE_TILE_WALL)
            .build();

    public static final BlockFamily DRIPSTONE_BLOCK = register(Blocks.DRIPSTONE_BLOCK)
            .stairs(JinericBlocks.DRIPSTONE_STAIRS)
            .slab(JinericBlocks.DRIPSTONE_SLAB)
            .wall(JinericBlocks.DRIPSTONE_WALL)
            .polished(JinericBlocks.POLISHED_DRIPSTONE)
            .build();

    public static final BlockFamily CRACKED_NETHER_BRICKS = register(Blocks.CRACKED_NETHER_BRICKS)
            .stairs(JinericBlocks.CRACKED_NETHER_BRICK_STAIRS)
            .slab(JinericBlocks.CRACKED_NETHER_BRICK_SLAB)
            .wall(JinericBlocks.CRACKED_NETHER_BRICK_WALL)
            .build();

    public static final BlockFamily CRACKED_POLISHED_BLACKSTONE_BRICKS = register(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)
            .stairs(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS)
            .slab(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB)
            .wall(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL)
            .build();

    public static final BlockFamily SMOOTH_BASALT = register(Blocks.SMOOTH_BASALT)
            .stairs(JinericBlocks.SMOOTH_BASALT_STAIRS)
            .slab(JinericBlocks.SMOOTH_BASALT_SLAB)
            .wall(JinericBlocks.SMOOTH_BASALT_WALL)
            .build();




    public static final BlockFamily COBBLED_DRIPSTONE = register(JinericBlocks.COBBLED_DRIPSTONE)
            .stairs(JinericBlocks.COBBLED_DRIPSTONE_STAIRS)
            .slab(JinericBlocks.COBBLED_DRIPSTONE_SLAB)
            .wall(JinericBlocks.COBBLED_DRIPSTONE_WALL)
            .build();

    public static final BlockFamily DRIPSTONE_BRICKS = register(JinericBlocks.DRIPSTONE_BRICKS)
            .stairs(JinericBlocks.DRIPSTONE_BRICK_STAIRS)
            .slab(JinericBlocks.DRIPSTONE_BRICK_SLAB)
            .wall(JinericBlocks.DRIPSTONE_BRICK_WALL)
            .chiseled(JinericBlocks.CHISELED_DRIPSTONE)
            .cracked(JinericBlocks.CRACKED_DRIPSTONE_BRICKS)
            .build();

    public static final BlockFamily CRACKED_DRIPSTONE_BRICKS = register(JinericBlocks.CRACKED_DRIPSTONE_BRICKS)
            .stairs(JinericBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS)
            .slab(JinericBlocks.CRACKED_DRIPSTONE_BRICK_SLAB)
            .wall(JinericBlocks.CRACKED_DRIPSTONE_BRICK_WALL)
            .build();

    public static final BlockFamily DRIPSTONE_TILES = register(JinericBlocks.DRIPSTONE_TILES)
            .stairs(JinericBlocks.DRIPSTONE_TILE_STAIRS)
            .slab(JinericBlocks.DRIPSTONE_TILE_SLAB)
            .wall(JinericBlocks.DRIPSTONE_TILE_WALL)
            .cracked(JinericBlocks.CRACKED_DRIPSTONE_TILES)
            .build();

    public static final BlockFamily CRACKED_DRIPSTONE_TILES = register(JinericBlocks.CRACKED_DRIPSTONE_TILES)
            .stairs(JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS)
            .slab(JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB)
            .wall(JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL)
            .build();

    public static final BlockFamily SMOOTH_DRIPSTONE = register(JinericBlocks.SMOOTH_DRIPSTONE)
            .stairs(JinericBlocks.SMOOTH_DRIPSTONE_STAIRS)
            .slab(JinericBlocks.SMOOTH_DRIPSTONE_SLAB)
            .wall(JinericBlocks.SMOOTH_DRIPSTONE_WALL)
            .build();


    public static final BlockFamily POLISHED_STONE = register(JinericBlocks.POLISHED_STONE)
        .stairs(JinericBlocks.POLISHED_STONE_STAIRS)
        .slab(JinericBlocks.POLISHED_STONE_SLAB)
        .wall(JinericBlocks.POLISHED_STONE_WALL)
        .build();

    public static final BlockFamily STONE_TILES = register(JinericBlocks.STONE_TILES)
        .stairs(JinericBlocks.STONE_TILE_STAIRS)
        .slab(JinericBlocks.STONE_TILE_SLAB)
        .wall(JinericBlocks.STONE_TILE_WALL)
        .build();

    public static final BlockFamily CRACKED_STONE_TILES = register(JinericBlocks.CRACKED_STONE_TILES)
            .stairs(JinericBlocks.CRACKED_STONE_TILE_STAIRS)
            .slab(JinericBlocks.CRACKED_STONE_TILE_SLAB)
            .wall(JinericBlocks.CRACKED_STONE_TILE_WALL)
            .build();

    public static final BlockFamily SMOOTH_DEEPSLATE = register(JinericBlocks.SMOOTH_DEEPSLATE)
            .stairs(JinericBlocks.SMOOTH_DEEPSLATE_STAIRS)
            .slab(JinericBlocks.SMOOTH_DEEPSLATE_SLAB)
            .wall(JinericBlocks.SMOOTH_DEEPSLATE_WALL)
            .build();

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BaseBlocksToFamiliesAccess.getBASE_BLOCKS_TO_FAMILIES().put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }

    public static void registerBlockFamilies() {}
}
