package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.collect.ImmutableMap;

import java.util.Map;

public class JinericItemGroups {
//	public static final ItemGroup DONE = FabricItemGroupBuilder.build(
//			new Identifier("done", "jineric"),
//			() -> new ItemStack(JinericItems.DRIPSTONE_BRICKS));
//
//	public static final ItemGroup WIP = FabricItemGroupBuilder.build(
//			new Identifier("work_in_progress", "jineric"),
//			() -> new ItemStack(JinericItems.FIREWEED));
//
//	public static final ItemGroup UNKNOWN = FabricItemGroupBuilder.build(
//			new Identifier("unknown", "jineric"),
//			() -> new ItemStack(Items.APPLE));

	public static final ItemGroup MOD_ITEMS = FabricItemGroup.builder(new Identifier(JinericMain.MOD_ID, "mod_items"))
			.displayName(Text.literal("Jineric Mod Items"))
			.icon(() ->new ItemStack(JinericItems.POLISHED_DRIPSTONE))
			.entries((enabledFeatures, entries, operatorEnabled) -> {
				entries.add(
						JinericItems.POLISHED_DRIPSTONE
				);
			}).build();

	public static final Identifier MOD_ITEMS_ID = new Identifier("jineric:mod_items");

	public static final Map<ItemGroup, Identifier> GROUP_ID_MAP = new ImmutableMap.Builder<ItemGroup, Identifier>().put(MOD_ITEMS, MOD_ITEMS_ID).build();


	public static void onInitialize() {
//		ItemGroupEvents.modifyEntriesEvent(new Identifier(JinericMain.MOD_ID, "mod_items")).register();
	}
}
