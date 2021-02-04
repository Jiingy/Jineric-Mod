package jingy.jineric.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.*;

public class JinericBlocks {

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
    public static final Block WAVY_SANDSTONE = register("wavy_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SandstoneSettings())));
    public static final Block WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BaseJinericStairBlock(WAVY_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(WAVY_SANDSTONE)));
    public static final Block WAVY_SANDSTONE_SLAB  = register("wavy_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_SANDSTONE)));
    public static final Block WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_SANDSTONE)));

    //SMOOTH SANDSTONE
    public static final Block SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_SANDSTONE)));


//RED SAND
    //WAVY RED SANDSTONE
    public static final Block WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SandstoneSettings())));
    public static final Block WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BaseJinericStairBlock(WAVY_RED_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(WAVY_SANDSTONE)));
    public static final Block WAVY_RED_SANDSTONE_SLAB  = register("wavy_red_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(WAVY_RED_SANDSTONE)));
    public static final Block WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new WallBlock(FabricBlockSettings.copy(WAVY_RED_SANDSTONE)));

    //SMOOTH RED SANDSTONE
    public static final Block SMOOTH_RED_SANDSTONE_SLAB  = register("smooth_red_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(RED_SANDSTONE)));

//SOUL SAND
    //SOUL SANDSTONE
    public static final Block SOUL_SANDSTONE = register("soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SoulSandstoneSettings())));
    public static final Block SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block SOUL_SANDSTONE_SLAB  = register("soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

    //CUT SOUL SANDSTONE
    public static final Block CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SoulSandstoneSettings())));
    public static final Block CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block CUT_SOUL_SANDSTONE_SLAB  = register("cut_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

    //CHISELED SOUL SANDSTONE
    public static final Block CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SoulSandstoneSettings())));
    public static final Block CHISELED_SOUL_SANDSTONE_STAIRS = register("chiseled_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block CHISELED_SOUL_SANDSTONE_SLAB  = register("chiseled_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block CHISELED_SOUL_SANDSTONE_WALL = register("chiseled_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

    //SMOOTH SOUL SANDSTONE
    public static final Block SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SoulSandstoneSettings())));
    public static final Block SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block SMOOTH_SOUL_SANDSTONE_SLAB  = register("smooth_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

    //WAVY SOUL SANDSTONE
    public static final Block WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new Block(FabricBlockSettings.copy(JinericBlockSettings.SoulSandstoneSettings())));
    public static final Block WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BaseJinericStairBlock(SOUL_SANDSTONE.getDefaultState(),FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block WAVY_SOUL_SANDSTONE_SLAB  = register("wavy_soul_sandstone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));
    public static final Block WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SANDSTONE)));

//STONE TYPES:
    //SMOOTH STONE
    public static final Block SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", new BaseJinericStairBlock(SMOOTH_STONE.getDefaultState(),FabricBlockSettings.copy(SMOOTH_STONE)));
    public static final Block SMOOTH_STONE_WALL = register("smooth_stone_wall", new WallBlock(FabricBlockSettings.copy(SMOOTH_STONE)));

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

//STORAGE BLOCKS
    public static final Block SALT_BLOCK = register("salt_block", new SandBlock(14409422,FabricBlockSettings.copy(SAND)));
    public static final Block ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new Block(FabricBlockSettings.copy(HONEYCOMB_BLOCK)));
    public static final Block FLINT_BLOCK = register("flint_block", new Block(FabricBlockSettings.copy(STONE)));
    public static final Block CHARCOAL_BLOCK = register("charcoal_block", new Block(FabricBlockSettings.copy(COAL_BLOCK)));

//WOOD
    //BOREAL
    public static final Block BOREAL_PLANKS = register("boreal_planks", new Block(FabricBlockSettings.copy(OAK_PLANKS)));
    public static final Block BOREAL_SLAB = register("boreal_slab", new SlabBlock(FabricBlockSettings.copy(OAK_PLANKS)));
    public static final Block BOREAL_STAIRS = register("boreal_stairs", new BaseJinericStairBlock(OAK_PLANKS.getDefaultState(),FabricBlockSettings.copy(OAK_PLANKS)));

//DECORATION BLOCKS
    public static final Block SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new BaseJinericCarvedPumpkinBlock(FabricBlockSettings.copy(JACK_O_LANTERN)));
    public static final Block FULL_GRASS_BLOCK = register("full_grass_block", new GrassBlock(FabricBlockSettings.copy(GRASS_BLOCK)));



    //SHULKER CHEST
    public static final Block SHULKER_CHEST = register("shulker_chest", new Block(FabricBlockSettings.copy(SHULKER_BOX)));



    private static Block register(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier("jineric", name), block);
    }
    public static void init() {
    }
}