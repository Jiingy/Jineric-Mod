package jingy.jineric.data.family;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

//TODO: ADD DUCK MIXIN, WITH A .pillar() METHOD
public class JinericBlockFamilies extends BlockFamilies {
   public static final BlockFamily PETRIFIED_OAK = register(JinericBlocks.PETRIFIED_OAK_PLANKS)
           .button(JinericBlocks.PETRIFIED_OAK_BUTTON)
           .fence(JinericBlocks.PETRIFIED_OAK_FENCE)
           .fenceGate(JinericBlocks.PETRIFIED_OAK_FENCE_GATE)
           .pressurePlate(JinericBlocks.PETRIFIED_OAK_PRESSURE_PLATE)
           .sign(JinericBlocks.PETRIFIED_OAK_SIGN, JinericBlocks.PETRIFIED_OAK_WALL_SIGN)
           .slab(JinericBlocks.PETRIFIED_OAK_SLAB)
           .stairs(JinericBlocks.PETRIFIED_OAK_STAIRS)
           .door(JinericBlocks.PETRIFIED_OAK_DOOR)
           .trapdoor(JinericBlocks.PETRIFIED_OAK_TRAPDOOR)
           .group("wooden").unlockCriterionName("has_planks")
           .build();

    public static final BlockFamily DRIPSTONE = register(Blocks.DRIPSTONE_BLOCK)
            .stairs(JinericBlocks.DRIPSTONE_STAIRS)
            .slab(JinericBlocks.DRIPSTONE_SLAB)
            .wall(JinericBlocks.DRIPSTONE_WALL)
            .build();

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

    public static final BlockFamily QUARTZ_BRICKS = register(Blocks.QUARTZ_BRICKS)
        .stairs(JinericBlocks.QUARTZ_BRICK_STAIRS)
        .slab(JinericBlocks.QUARTZ_BRICK_SLAB)
        .wall(JinericBlocks.QUARTZ_BRICK_WALL)
        .build();

    public static final BlockFamily OBSIDIAN = register(Blocks.OBSIDIAN)
        .stairs(JinericBlocks.OBSIDIAN_STAIRS)
        .slab(JinericBlocks.OBSIDIAN_SLAB)
        .wall(JinericBlocks.OBSIDIAN_WALL)
        .build();

    public static final BlockFamily CALCITE = register(Blocks.CALCITE)
        .stairs(JinericBlocks.CALCITE_STAIRS)
        .slab(JinericBlocks.CALCITE_SLAB)
        .wall(JinericBlocks.CALCITE_WALL)
        .build();

    public static final BlockFamily PACKED_ICE = register(Blocks.PACKED_ICE)
        .stairs(JinericBlocks.PACKED_ICE_STAIRS)
        .slab(JinericBlocks.PACKED_ICE_SLAB)
        .wall(JinericBlocks.PACKED_ICE_WALL)
        .build();

    public static final BlockFamily SNOW = register(Blocks.SNOW)
            .wall(JinericBlocks.SNOW_WALL)
            .build();

    public static final BlockFamily SNOW_BRICKS = register(JinericBlocks.SNOW_BRICKS)
            .stairs(JinericBlocks.SNOW_BRICK_STAIRS)
            .slab(JinericBlocks.SNOW_BRICK_SLAB)
            .wall(JinericBlocks.SNOW_BRICK_WALL)
            .build();

    public static final BlockFamily COBBLED_DRIPSTONE = register(JinericBlocks.COBBLED_DRIPSTONE)
            .stairs(JinericBlocks.COBBLED_DRIPSTONE_STAIRS)
            .slab(JinericBlocks.COBBLED_DRIPSTONE_SLAB)
            .wall(JinericBlocks.COBBLED_DRIPSTONE_WALL)
            .build();

    public static final BlockFamily POLISHED_DRIPSTONE = register(JinericBlocks.POLISHED_DRIPSTONE)
            .stairs(JinericBlocks.POLISHED_DRIPSTONE_STAIRS)
            .slab(JinericBlocks.POLISHED_DRIPSTONE_SLAB)
            .wall(JinericBlocks.POLISHED_DRIPSTONE_WALL)
            .build();

    public static final BlockFamily DRIPSTONE_BRICKS = register(JinericBlocks.DRIPSTONE_BRICKS)
            .stairs(JinericBlocks.DRIPSTONE_BRICK_STAIRS)
            .slab(JinericBlocks.DRIPSTONE_BRICK_SLAB)
            .wall(JinericBlocks.DRIPSTONE_BRICK_WALL)
            .chiseled(JinericBlocks.CHISELED_DRIPSTONE_BRICKS)
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

    public static final BlockFamily POLISHED_SANDSTONE = register(JinericBlocks.POLISHED_SANDSTONE)
            .stairs(JinericBlocks.POLISHED_SANDSTONE_STAIRS)
            .slab(JinericBlocks.POLISHED_SANDSTONE_SLAB)
            .wall(JinericBlocks.POLISHED_SANDSTONE_WALL)
            .build();

    public static final BlockFamily WAVY_SANDSTONE = register(JinericBlocks.WAVY_SANDSTONE)
        .stairs(JinericBlocks.WAVY_SANDSTONE_STAIRS)
        .slab(JinericBlocks.WAVY_SANDSTONE_SLAB)
        .wall(JinericBlocks.WAVY_SANDSTONE_WALL)
        .build();

    public static final BlockFamily POLISHED_RED_SANDSTONE = register(JinericBlocks.POLISHED_RED_SANDSTONE)
            .stairs(JinericBlocks.POLISHED_RED_SANDSTONE_STAIRS)
            .slab(JinericBlocks.POLISHED_RED_SANDSTONE_SLAB)
            .wall(JinericBlocks.POLISHED_RED_SANDSTONE_WALL)
            .build();

    public static final BlockFamily WAVY_RED_SANDSTONE = register(JinericBlocks.WAVY_RED_SANDSTONE)
        .stairs(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS)
        .slab(JinericBlocks.WAVY_RED_SANDSTONE_SLAB)
        .wall(JinericBlocks.WAVY_RED_SANDSTONE_WALL)
        .build();


    public static final BlockFamily SOUL_SANDSTONE = register(JinericBlocks.SOUL_SANDSTONE)
            .stairs(JinericBlocks.SOUL_SANDSTONE_STAIRS)
            .slab(JinericBlocks.SOUL_SANDSTONE_SLAB)
            .wall(JinericBlocks.SOUL_SANDSTONE_WALL)
            .chiseled(JinericBlocks.CHISELED_SOUL_SANDSTONE)
            .build();

    public static final BlockFamily SMOOTH_SOUL_SANDSTONE = register(JinericBlocks.SMOOTH_SOUL_SANDSTONE)
            .stairs(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS)
            .slab(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB)
            .wall(JinericBlocks.SMOOTH_SOUL_SANDSTONE_WALL)
            .build();

    public static final BlockFamily CUT_SOUL_SANDSTONE = register(JinericBlocks.CUT_SOUL_SANDSTONE)
            .stairs(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS)
            .slab(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB)
            .wall(JinericBlocks.CUT_SOUL_SANDSTONE_WALL)
            .build();

    public static final BlockFamily POLISHED_SOUL_SANDSTONE = register(JinericBlocks.POLISHED_SOUL_SANDSTONE)
            .stairs(JinericBlocks.POLISHED_SOUL_SANDSTONE_STAIRS)
            .slab(JinericBlocks.POLISHED_SOUL_SANDSTONE_SLAB)
            .wall(JinericBlocks.POLISHED_SOUL_SANDSTONE_WALL)
            .build();

    public static final BlockFamily WAVY_SOUL_SANDSTONE = register(JinericBlocks.WAVY_SOUL_SANDSTONE)
        .stairs(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS)
        .slab(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB)
        .wall(JinericBlocks.WAVY_SOUL_SANDSTONE_WALL)
        .build();

    public static void initialize() {}
}
