package jingy.jineric.data.family;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.mixin.access.BaseBlocksToFamiliesAccess;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

public class JinericBlockFamilies {

    public static final BlockFamily SMOOTH_STONE = register(Blocks.SMOOTH_STONE)
            .stairs(JinericBlocks.SMOOTH_STONE_STAIRS)
            .slab(Blocks.SMOOTH_STONE_SLAB)
            .wall(JinericBlocks.SMOOTH_STONE_WALL)
            .build();

    public static final BlockFamily SMOOTH_DEEPSLATE = register(JinericBlocks.SMOOTH_DEEPSLATE)
            .stairs(JinericBlocks.SMOOTH_DEEPSLATE_STAIRS)
            .slab(JinericBlocks.SMOOTH_DEEPSLATE_SLAB)
            .wall(JinericBlocks.SMOOTH_DEEPSLATE_WALL)
            .build();

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = (BlockFamily) BaseBlocksToFamiliesAccess.getBlockFamilies().put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }

    public static void registerBlockFamilies() {}
}
