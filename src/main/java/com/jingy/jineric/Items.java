package com.jingy.jineric;

import com.jingy.jineric.Jineric;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {

/*
    templates:
    block item: public static final Item [NAME] = register("name", new BlockItem(Blocks.[NAME], ItemGroups.[ITEM_GROUP]()));
*/

//FOOD:
    //GOLDEN FOODS
    public static final Item GOLDEN_POTATO = register("golden_potato", new Item(ItemSettings.Food().food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build()).group(ItemGroups.JINERIC_ITEMS)));
    public static final Item GOLDEN_SWEET_BERRIES = register("golden_sweet_berries", new Item(ItemSettings.Food().food(new FoodComponent.Builder().hunger(5).saturationModifier(8f).build()).group(ItemGroups.JINERIC_ITEMS)));
    public static final Item GOLDEN_BEETROOT = register("golden_beetroot", new Item(ItemSettings.Food().food(new FoodComponent.Builder().hunger(4).saturationModifier(5f).build()).group(ItemGroups.JINERIC_ITEMS)));


//SAND
    //CUT SANDSTONE
    public static final Item CUT_SANDSTONE_STAIRS = register("cut_sandstone_stairs", new BlockItem(Blocks.CUT_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CUT_SANDSTONE_WALL = register("cut_sandstone_wall", new BlockItem(Blocks.CUT_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //CHISELED SOUL SANDSTONE
    public static final Item CHISELED_SANDSTONE_SLAB = register("chiseled_sandstone_slab", new BlockItem(Blocks.CHISELED_SANDSTONE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CHISELED_SANDSTONE_STAIRS = register("chiseled_sandstone_stairs", new BlockItem(Blocks.CHISELED_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CHISELED_SANDSTONE_WALL = register("chiseled_sandstone_wall", new BlockItem(Blocks.CHISELED_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //WAVY SANDSTONE
    public static final Item WAVY_SANDSTONE = register("wavy_sandstone", new BlockItem(Blocks.WAVY_SANDSTONE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_SANDSTONE_SLAB = register("wavy_sandstone_slab", new BlockItem(Blocks.WAVY_SANDSTONE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_SANDSTONE_STAIRS = register("wavy_sandstone_stairs", new BlockItem(Blocks.WAVY_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_SANDSTONE_WALL = register("wavy_sandstone_wall", new BlockItem(Blocks.WAVY_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //SMOOTH SANDSTONE
    public static final Item SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", new BlockItem(Blocks.SMOOTH_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));


//RED SAND
    //WAVY RED SANDSTONE
    public static final Item WAVY_RED_SANDSTONE = register("wavy_red_sandstone", new BlockItem(Blocks.WAVY_RED_SANDSTONE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_RED_SANDSTONE_SLAB = register("wavy_red_sandstone_slab", new BlockItem(Blocks.WAVY_RED_SANDSTONE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_RED_SANDSTONE_STAIRS = register("wavy_red_sandstone_stairs", new BlockItem(Blocks.WAVY_RED_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_RED_SANDSTONE_WALL = register("wavy_red_sandstone_wall", new BlockItem(Blocks.WAVY_RED_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));


//SOUL SAND
    //SOUL SOUL SANDSTONE
    public static final Item SOUL_SANDSTONE = register("soul_sandstone", new BlockItem(Blocks.SOUL_SANDSTONE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item SOUL_SANDSTONE_SLAB = register("soul_sandstone_slab", new BlockItem(Blocks.SOUL_SANDSTONE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item SOUL_SANDSTONE_STAIRS = register("soul_sandstone_stairs", new BlockItem(Blocks.SOUL_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item SOUL_SANDSTONE_WALL = register("soul_sandstone_wall", new BlockItem(Blocks.SOUL_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //CUT SOUL SANDSTONE
    public static final Item CUT_SOUL_SANDSTONE = register("cut_soul_sandstone", new BlockItem(Blocks.CUT_SOUL_SANDSTONE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CUT_SOUL_SANDSTONE_SLAB = register("cut_soul_sandstone_slab", new BlockItem(Blocks.CUT_SOUL_SANDSTONE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CUT_SOUL_SANDSTONE_STAIRS = register("cut_soul_sandstone_stairs", new BlockItem(Blocks.CUT_SOUL_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CUT_SOUL_SANDSTONE_WALL = register("cut_soul_sandstone_wall", new BlockItem(Blocks.CUT_SOUL_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //CHISELED SOUL SANDSTONE
    public static final Item CHISELED_SOUL_SANDSTONE = register("chiseled_soul_sandstone", new BlockItem(Blocks.CHISELED_SOUL_SANDSTONE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CHISELED_SOUL_SANDSTONE_SLAB = register("chiseled_soul_sandstone_slab", new BlockItem(Blocks.CHISELED_SOUL_SANDSTONE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CHISELED_SOUL_SANDSTONE_STAIRS = register("chiseled_soul_sandstone_stairs", new BlockItem(Blocks.CHISELED_SOUL_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CHISELED_SOUL_SANDSTONE_WALL = register("chiseled_soul_sandstone_wall", new BlockItem(Blocks.CHISELED_SOUL_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //SMOOTH SANDSTONE
    public static final Item SMOOTH_SOUL_SANDSTONE = register("smooth_soul_sandstone", new BlockItem(Blocks.SMOOTH_SOUL_SANDSTONE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item SMOOTH_SOUL_SANDSTONE_SLAB = register("smooth_soul_sandstone_slab", new BlockItem(Blocks.SMOOTH_SOUL_SANDSTONE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item SMOOTH_SOUL_SANDSTONE_STAIRS = register("smooth_soul_sandstone_stairs", new BlockItem(Blocks.SMOOTH_SOUL_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item SMOOTH_SOUL_SANDSTONE_WALL = register("smooth_soul_sandstone_wall", new BlockItem(Blocks.SMOOTH_SOUL_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //WAVY SOUL SANDSTONE
    public static final Item WAVY_SOUL_SANDSTONE = register("wavy_soul_sandstone", new BlockItem(Blocks.WAVY_SOUL_SANDSTONE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_SOUL_SANDSTONE_SLAB = register("wavy_soul_sandstone_slab", new BlockItem(Blocks.WAVY_SOUL_SANDSTONE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_SOUL_SANDSTONE_STAIRS = register("wavy_soul_sandstone_stairs", new BlockItem(Blocks.WAVY_SOUL_SANDSTONE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item WAVY_SOUL_SANDSTONE_WALL = register("wavy_soul_sandstone_wall", new BlockItem(Blocks.WAVY_SOUL_SANDSTONE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //test block
    public static final Item TEST_BLOCK = register("test_block", new BlockItem(Blocks.TEST_BLOCK, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));


//'-ITES'
    //CORRITE
    public static final Item CORRITE = register("corrite", new BlockItem(Blocks.CORRITE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CORRITE_SLAB = register("corrite_slab", new BlockItem(Blocks.CORRITE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CORRITE_STAIRS = register("corrite_stairs", new BlockItem(Blocks.CORRITE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item CORRITE_WALL = register("corrite_wall", new BlockItem(Blocks.CORRITE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    //BORITE
    public static final Item BORITE = register("borite", new BlockItem(Blocks.BORITE, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item BORITE_SLAB = register("borite_slab", new BlockItem(Blocks.BORITE_SLAB, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item BORITE_STAIRS = register("borite_stairs", new BlockItem(Blocks.BORITE_STAIRS, ItemSettings.BuildingBlocks().group(ItemGroups.JINERIC_BLOCKS)));
    public static final Item BORITE_WALL = register("borite_wall", new BlockItem(Blocks.BORITE_WALL, ItemSettings.Decoration().group(ItemGroups.JINERIC_BLOCKS)));

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier("jineric", name), item);
    }
    public static void init() {
    }
}

