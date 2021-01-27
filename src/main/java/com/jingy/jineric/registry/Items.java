package com.jingy.jineric.registry;

import com.jingy.jineric.Jineric;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {

    //FOODS:
    public static final Item GOLDEN_POTATO = new Item(
            new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build()));

    public static final Item GOLDEN_SWEET_BERRIES = new Item(
            new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(8f).build()));

    public static final Item GOLDEN_BEETROOT = new Item(
            new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(5f).build()));



    //BLOCK ITEMS:
    public static final BlockItem CORRITE = new BlockItem(Blocks.CORRITE, ItemSettings.BuildingBlocks());
    public static final BlockItem BORITE = new BlockItem(Blocks.BORITE, ItemSettings.BuildingBlocks());
    public static final BlockItem WAVY_SANDSTONE = new BlockItem(Blocks.WAVY_SANDSTONE, ItemSettings.BuildingBlocks());
    public static final BlockItem SOUL_SANDSTONE = new BlockItem(Blocks.SOUL_SANDSTONE, ItemSettings.BuildingBlocks());
    public static final BlockItem CUT_SOUL_SANDSTONE = new BlockItem(Blocks.CUT_SOUL_SANDSTONE, ItemSettings.BuildingBlocks());
    public static final BlockItem CHISELED_SOUL_SANDSTONE = new BlockItem(Blocks.CHISELED_SOUL_SANDSTONE, ItemSettings.BuildingBlocks());
    public static final BlockItem WAVY_SOUL_SANDSTONE = new BlockItem(Blocks.WAVY_SOUL_SANDSTONE, ItemSettings.BuildingBlocks());
    public static final BlockItem SMOOTH_SOUL_SANDSTONE = new BlockItem(Blocks.SMOOTH_SOUL_SANDSTONE, ItemSettings.BuildingBlocks());


    public static void registerItems() {
        //ITEMS:
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "golden_potato"), GOLDEN_POTATO);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "golden_sweet_berries"), GOLDEN_SWEET_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "golden_beetroot"), GOLDEN_BEETROOT);

        //BLOCKS:
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "corrite"), CORRITE);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "borite"), BORITE);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "wavy_sandstone"), WAVY_SANDSTONE);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "soul_sandstone"), SOUL_SANDSTONE);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "cut_soul_sandstone"), CUT_SOUL_SANDSTONE);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "chiseled_soul_sandstone"), CHISELED_SOUL_SANDSTONE);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "wavy_soul_sandstone"), WAVY_SOUL_SANDSTONE);
        Registry.register(Registry.ITEM, new Identifier(Jineric.MOD_ID, "smooth_soul_sandstone"), SMOOTH_SOUL_SANDSTONE);
    }
}