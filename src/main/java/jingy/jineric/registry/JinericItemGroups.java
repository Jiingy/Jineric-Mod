package jingy.jineric.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class JinericItemGroups {
	public static final ItemGroup DONE = FabricItemGroupBuilder.build(
			new Identifier("done", "jineric"),
			() -> new ItemStack(JinericItems.DRIPSTONE_BRICKS));

	public static final ItemGroup WIP = FabricItemGroupBuilder.build(
			new Identifier("work_in_progress", "jineric"),
			() -> new ItemStack(JinericItems.FIREWEED));

//	public static final ItemGroup REDSTONE = FabricItemGroupBuilder.build(
//			new Identifier("redstone", "jineric"),
//			() -> new ItemStack(Items.REDSTONE));
//
//	public static final ItemGroup TRANSPORTATION = FabricItemGroupBuilder.build(
//			new Identifier("transportation", "jineric"),
//			() -> new ItemStack(Items.ELYTRA));

	public static final ItemGroup UNKNOWN = FabricItemGroupBuilder.build(
			new Identifier("unknown", "jineric"),
			() -> new ItemStack(Items.APPLE));

//	public static final ItemGroup FOODS = FabricItemGroupBuilder.build(
//			new Identifier("foods", "jineric"),
//			() -> new ItemStack(Items.APPLE));
//
//	public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(
//			new Identifier("tools", "jineric"),
//			() -> new ItemStack(Items.IRON_AXE));
//
//	public static final ItemGroup COMBAT = FabricItemGroupBuilder.build(
//			new Identifier("combat", "jineric"),
//			() -> new ItemStack(Items.GOLDEN_SWORD));
//
//	public static final ItemGroup BREWING = FabricItemGroupBuilder.build(
//			new Identifier("brewing", "jineric"),
//			() -> new ItemStack(Items.POTION));

	public static void init() {
	}

}
