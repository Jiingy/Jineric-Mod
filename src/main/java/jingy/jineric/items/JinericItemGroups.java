package jingy.jineric.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class JinericItemGroups {
	public static final ItemGroup JINERIC_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier("blocks", "jineric"),
			() -> new ItemStack(JinericItems.SILTSTONE));
	public static final ItemGroup JINERIC_BREWING = FabricItemGroupBuilder.build(
			new Identifier("brewing", "jineric"),

			() -> new ItemStack(JinericItems.GOLDEN_SWEET_BERRIES));
	public static final ItemGroup JINERIC_MISCELLANEOUS = FabricItemGroupBuilder.build(
			new Identifier("miscellaneous", "jineric"),

			() -> new ItemStack(JinericItems.SALT));

	public static Item.Settings jinericBlocks() {
		return new Item.Settings().group(JINERIC_BLOCKS);

	}

	public static Item.Settings jinericBrewing() {
		return new Item.Settings().group(JINERIC_BREWING);

	}

	public static Item.Settings jinericMiscellaneous() {
		return new Item.Settings().group(JINERIC_MISCELLANEOUS);

	/*}
	public static final ItemGroup JINERIC_BREWING = FabricItemGroupBuilder.build(
			new Identifier("brewing", "jineric"),

			() -> new ItemStack(JinericItems.GOLDEN_SWEET_BERRIES));
	public static Item.Settings jinericBrewing() {
		return new Item.Settings().group(JINERIC_BREWING);
*/

	}

	public static void init() {
	}

}
