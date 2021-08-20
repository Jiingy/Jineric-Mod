package jingy.jineric.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class JinericItemSettings {
	public static Item.Settings BuildingBlocks() {
		return new Item.Settings().group(ItemGroup.BUILDING_BLOCKS);
	}
	public static Item.Settings Misc() {
		return new Item.Settings().group(ItemGroup.MISC);
	}
	public static Item.Settings Decoration() {
		return new Item.Settings().group(ItemGroup.DECORATIONS);
	}
	public static Item.Settings Food() {
		return new Item.Settings().group(ItemGroup.FOOD);
	}
}
