package com.jingy.jineric;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericItems {

/*
    templates:
    block item: public static final Item [NAME] = register("name", new BlockItem(Blocks.[NAME], ItemGroups.[ITEM_GROUP]()));
*/

//ITEMS
    //FOOD:
        //GOLDEN FOODS
        public static final Item GOLDEN_POTATO = register("golden_potato", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build()).group(JinericItemGroups.JINERIC_ITEMS)));
        public static final Item GOLDEN_SWEET_BERRIES = register("golden_sweet_berries", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(5).saturationModifier(8f).build()).group(JinericItemGroups.JINERIC_ITEMS)));
        public static final Item GOLDEN_BEETROOT = register("golden_beetroot", new Item(JinericItemSettings.Food().food(new FoodComponent.Builder().hunger(4).saturationModifier(5f).build()).group(JinericItemGroups.JINERIC_ITEMS)));

    //OTHER ITEMS
    public static final Item SALT = register("salt", new Item(JinericItemSettings.Misc().group(JinericItemGroups.JINERIC_ITEMS)));
    public static final Item WARPED_NETHER_WART = register("warped_nether_wart", new Item(JinericItemSettings.Misc().group(JinericItemGroups.JINERIC_ITEMS)));

//BLOCKS
    //SAND
        //CUT SANDSTONE
        public static final Item CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new BlockItem(JinericBlocks.CUT_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //CHISELED SOUL SANDSTONE
        public static final Item CHISELED_SANDSTONE_SLAB = register("chiseled_sandstone_slab", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CHISELED_SANDSTONE_STAIRS = register("chiseled_sandstone_stairs", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CHISELED_SANDSTONE_WALL = register("chiseled_sandstone_wall", new BlockItem(JinericBlocks.CHISELED_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //WAVY SANDSTONE
        public static final Item WAVY_SANDSTONE = register("wavy_sandstone", new BlockItem(JinericBlocks.WAVY_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_SANDSTONE_SLAB = register("wavy_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //SMOOTH SANDSTONE
        public static final Item SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));


    //RED SAND
        //WAVY RED SANDSTONE
        public static final Item WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_RED_SANDSTONE_SLAB = register("wavy_red_sandstone_slab", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new BlockItem(JinericBlocks.WAVY_RED_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));


    //SOUL SAND
        //SOUL SOUL SANDSTONE
        public static final Item SOUL_SANDSTONE = register("soul_sandstone", new BlockItem(JinericBlocks.SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SOUL_SANDSTONE_SLAB = register("soul_sandstone_slab", new BlockItem(JinericBlocks.SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BlockItem(JinericBlocks.SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new BlockItem(JinericBlocks.SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //CUT SOUL SANDSTONE
        public static final Item CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CUT_SOUL_SANDSTONE_SLAB = register("cut_soul_sandstone_slab", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new BlockItem(JinericBlocks.CUT_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //CHISELED SOUL SANDSTONE
        public static final Item CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CHISELED_SOUL_SANDSTONE_SLAB = register("chiseled_soul_sandstone_slab", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CHISELED_SOUL_SANDSTONE_STAIRS = register("chiseled_soul_sandstone_stairs", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CHISELED_SOUL_SANDSTONE_WALL = register("chiseled_soul_sandstone_wall", new BlockItem(JinericBlocks.CHISELED_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //SMOOTH SANDSTONE
        public static final Item SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SMOOTH_SOUL_SANDSTONE_SLAB = register("smooth_soul_sandstone_slab", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new BlockItem(JinericBlocks.SMOOTH_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //WAVY SOUL SANDSTONE
        public static final Item WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_SOUL_SANDSTONE_SLAB = register("wavy_soul_sandstone_slab", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new BlockItem(JinericBlocks.WAVY_SOUL_SANDSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));


    //STONES
        //BORITE
        public static final Item BORITE = register("borite", new BlockItem(JinericBlocks.BORITE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item BORITE_SLAB = register("borite_slab", new BlockItem(JinericBlocks.BORITE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item BORITE_STAIRS = register("borite_stairs", new BlockItem(JinericBlocks.BORITE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item BORITE_WALL = register("borite_wall", new BlockItem(JinericBlocks.BORITE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //SILTSTONE
        public static final Item SILTSTONE = register("siltstone", new BlockItem(JinericBlocks.SILTSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SILTSTONE_SLAB = register("siltstone_slab", new BlockItem(JinericBlocks.SILTSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SILTSTONE_STAIRS = register("siltstone_stairs", new BlockItem(JinericBlocks.SILTSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SILTSTONE_WALL = register("siltstone_wall", new BlockItem(JinericBlocks.SILTSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //SILTSTONE
        public static final Item POLISHED_SILTSTONE = register("polished_siltstone", new BlockItem(JinericBlocks.POLISHED_SILTSTONE, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item POLISHED_SILTSTONE_SLAB = register("polished_siltstone_slab", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_SLAB, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item POLISHED_SILTSTONE_STAIRS = register("polished_siltstone_stairs", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_STAIRS, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item POLISHED_SILTSTONE_WALL = register("polished_siltstone_wall", new BlockItem(JinericBlocks.POLISHED_SILTSTONE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //SLATE
        public static final Item SLATE = register("slate", new BlockItem(JinericBlocks.SLATE, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SLATE_STAIRS = register("slate_stairs", new BlockItem(JinericBlocks.SLATE_STAIRS, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SLATE_SLAB = register("slate_slab", new BlockItem(JinericBlocks.SLATE_SLAB, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item SLATE_WALL = register("slate_wall", new BlockItem(JinericBlocks.SLATE_WALL, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));

        //STORAGE BLOCKS
        public static final Item SALT_BLOCK = register("salt_block", new BlockItem(JinericBlocks.SALT_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", new BlockItem(JinericBlocks.ROTTEN_FLESH_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item FLINT_BLOCK = register("flint_block", new BlockItem(JinericBlocks.FLINT_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));
        public static final Item CHARCOAL_BLOCK = register("charcoal_block", new BlockItem(JinericBlocks.CHARCOAL_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));

    //WOOD TYPES
        //BOREAL
    public static final Item BOREAL_PLANKS = register("boreal", new BlockItem(JinericBlocks.BOREAL_PLANKS, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
    public static final Item BOREAL_STAIRS = register("boreal_stairs", new BlockItem(JinericBlocks.BOREAL_STAIRS, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));
    public static final Item BOREAL_SLAB = register("boreal_slab", new BlockItem(JinericBlocks.BOREAL_SLAB, JinericItemSettings.Decoration().group(JinericItemGroups.JINERIC_BLOCKS)));


    //DECORATION
        //SOUL JACK O'LANTERN
        public static final Item SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new BlockItem(JinericBlocks.SOUL_JACK_O_LANTERN, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));

        //FULL GRASS BLOCK
        public static final Item FULL_GRASS_BLOCK = register("full_grass_block", new BlockItem(JinericBlocks.FULL_GRASS_BLOCK, JinericItemSettings.BuildingBlocks().group(JinericItemGroups.JINERIC_BLOCKS)));



    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier("jineric", name), item);
    }
    public static void init() {
    }
}

