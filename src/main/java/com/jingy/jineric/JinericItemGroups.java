package com.jingy.jineric;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class JinericItemGroups {
    public static final ItemGroup JINERIC_BLOCKS = FabricItemGroupBuilder.build(
            new Identifier("blocks", "jineric"),
            () -> new ItemStack(JinericItems.SILTSTONE));

    public static Item.Settings jinericBlocks() {
        return new Item.Settings().group(JINERIC_BLOCKS);

    }
    public static final ItemGroup JINERIC_ITEMS = FabricItemGroupBuilder.build(
            new Identifier("items", "jineric"),

            () -> new ItemStack(JinericItems.GOLDEN_SWEET_BERRIES));
    public static Item.Settings jinericItems() {
        return new Item.Settings().group(JINERIC_ITEMS);
    }
    public static void init() {
    }

}
