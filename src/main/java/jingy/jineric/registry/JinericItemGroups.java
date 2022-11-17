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

	public static final ItemGroup UNKNOWN = FabricItemGroupBuilder.build(
			new Identifier("unknown", "jineric"),
			() -> new ItemStack(Items.APPLE));

	public static void init() {
	}
}
