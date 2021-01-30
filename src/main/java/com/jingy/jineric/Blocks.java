package com.jingy.jineric;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.enums.StairShape;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.*;

public class Blocks {

/*
    templates
    block:  public static final Block POLISHED_STONE = register("polished_stone", new Block(FabricBlockSettings.copy(STONE_BRICKS)));
    slab:   public static final Block POLISHED_STONE_SLAB  = register("polished_stone_slab", new SlabBlock(FabricBlockSettings.copy(STONE_BRICKS)));
    stairs: public static final Block POLISHED_STONE_STAIRS = register("polished_stone_stairs", new BaseConsistencyStairBlock(STONE_BRICKS.getDefaultState(),FabricBlockSettings.copy(STONE_BRICKS)));
    pillar: public static final Block STONE_BRICK_PILLAR = register("stone_brick_pillar", new PillarBlock(FabricBlockSettings.copy(STONE_BRICKS)));
    wall:   public static final Block STONE_WALL = register("stone_wall", new WallBlock(FabricBlockSettings.copy(STONE_BRICKS)));
*/

//SAND
    //CUT SANDSTONE
    public static final Block CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new BaseJinericStairBlock(CUT_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(CUT_SANDSTONE)));
    public static final Block CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new WallBlock(FabricBlockSettings.copy(CUT_SANDSTONE)));

    //CHISELED SOUL SANDSTONE
    public static final Block CHISELED_SANDSTONE_STAIRS = register("chiseled_sandstone_stairs", new BaseJinericStairBlock(CHISELED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(CHISELED_SANDSTONE)));
    public static final Block CHISELED_SANDSTONE_SLAB  = register("chiseled_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(CHISELED_SANDSTONE)));
    public static final Block CHISELED_SANDSTONE_WALL = register("chiseled_sandstone_wall", new WallBlock(FabricBlockSettings.copy(CHISELED_SANDSTONE)));

    //WAVY SANDSTONE
    public static final Block WAVY_SANDSTONE = register("wavy_sandstone", new Block(FabricBlockSettings.copy(BlockSettings.SandstoneSettings())));
    public static final Block WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BaseJinericStairBlock(WAVY_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(WAVY_SANDSTONE)));
    public static final Block WAVY_SANDSTONE_SLAB  = register("wavy_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_SANDSTONE)));
    public static final Block WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_SANDSTONE)));

    //SMOOTH SANDSTONE
    public static final Block SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_SANDSTONE)));


//RED SAND
    //WAVY RED SANDSTONE
    public static final Block WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new Block(FabricBlockSettings.copy(BlockSettings.SandstoneSettings())));
    public static final Block WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BaseJinericStairBlock(WAVY_RED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(WAVY_SANDSTONE)));
    public static final Block WAVY_RED_SANDSTONE_SLAB  = register("wavy_red_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_RED_SANDSTONE)));
    public static final Block WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_RED_SANDSTONE)));

//SOUL SAND
    //SOUL SANDSTONE
    public static final Block SOUL_SANDSTONE = register("soul_sandstone", new Block(FabricBlockSettings.copy(BlockSettings.SoulSandstoneSettings())));
    public static final Block SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block SOUL_SANDSTONE_SLAB  = register("soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

    //CUT SOUL SANDSTONE
    public static final Block CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new Block(FabricBlockSettings.copy(BlockSettings.SoulSandstoneSettings())));
    public static final Block CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block CUT_SOUL_SANDSTONE_SLAB  = register("cut_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

    //CHISELED SOUL SANDSTONE
    public static final Block CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new Block(FabricBlockSettings.copy(BlockSettings.SoulSandstoneSettings())));
    public static final Block CHISELED_SOUL_SANDSTONE_STAIRS = register("chiseled_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block CHISELED_SOUL_SANDSTONE_SLAB  = register("chiseled_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block CHISELED_SOUL_SANDSTONE_WALL = register("chiseled_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

    //SMOOTH SOUL SANDSTONE
    public static final Block SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new Block(FabricBlockSettings.copy(BlockSettings.SoulSandstoneSettings())));
    public static final Block SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block SMOOTH_SOUL_SANDSTONE_SLAB  = register("smooth_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

    //WAVY SOUL SANDSTONE
    public static final Block WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new Block(FabricBlockSettings.copy(BlockSettings.SoulSandstoneSettings())));
    public static final Block WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block WAVY_SOUL_SANDSTONE_SLAB  = register("wavy_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

//STONE TYPES:
    //CORRITE
    public static final Block CORRITE = register("corrite", new Block(FabricBlockSettings.copy(STONE)));
    public static final Block CORRITE_STAIRS = register("corrite_stairs", new BaseJinericStairBlock(STONE.getDefaultState(),FabricBlockSettings.copy(STONE)));
    public static final Block CORRITE_SLAB  = register("corrite_slab", new SlabBlock(FabricBlockSettings.copy(STONE)));
    public static final Block CORRITE_WALL = register("corrite_wall", new WallBlock(FabricBlockSettings.copy(STONE)));

    //BORITE
    public static final Block BORITE = register("borite", new Block(FabricBlockSettings.copy(STONE)));
    public static final Block BORITE_STAIRS = register("borite_stairs", new BaseJinericStairBlock(STONE.getDefaultState(),FabricBlockSettings.copy(STONE)));
    public static final Block BORITE_SLAB  = register("borite_slab", new SlabBlock(FabricBlockSettings.copy(STONE)));
    public static final Block BORITE_WALL = register("borite_wall", new WallBlock(FabricBlockSettings.copy(STONE)));

    //testing making a block
    public static final Block TEST_BLOCK = register("test_block", new Block(FabricBlockSettings.copy(ICE)));



    private static Block register(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier("jineric", name), block);
    }
    public static void init() {
    }
}