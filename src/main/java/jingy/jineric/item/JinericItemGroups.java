package jingy.jineric.item;

import jingy.jineric.registry.JinericItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class JinericItemGroups {
	public static final ItemGroup BUILDING_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier("building_blocks", "jineric"),
			() -> new ItemStack(JinericItems.SILTSTONE));

	public static final ItemGroup DECORATION_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier("decoration_blocks", "jineric"),
			() -> new ItemStack(JinericItems.BAMBOO_BLOCK));

	public static final ItemGroup REDSTONE = FabricItemGroupBuilder.build(
			new Identifier("redstone", "jineric"),
			() -> new ItemStack(Items.REDSTONE));

	public static final ItemGroup TRANSPORTATION = FabricItemGroupBuilder.build(
			new Identifier("transportation", "jineric"),
			() -> new ItemStack(Items.POWERED_RAIL));

	public static final ItemGroup MISCELLANEOUS = FabricItemGroupBuilder.build(
			new Identifier("miscellaneous", "jineric"),
			() -> new ItemStack(JinericItems.SALT));

	public static final ItemGroup FOODS = FabricItemGroupBuilder.build(
			new Identifier("foods", "jineric"),
			() -> new ItemStack(Items.APPLE));

	public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(
			new Identifier("tools", "jineric"),
			() -> new ItemStack(Items.IRON_AXE));

	public static final ItemGroup COMBAT = FabricItemGroupBuilder.build(
			new Identifier("combat", "jineric"),
			() -> new ItemStack(Items.GOLDEN_SWORD));

	public static final ItemGroup BREWING = FabricItemGroupBuilder.build(
			new Identifier("brewing", "jineric"),
			() -> new ItemStack(Items.POTION));

	public static void init() {
	}

}
