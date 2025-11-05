package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;

public class JinericItemTags {
	public static final TagKey<Item> CHESTS = registerItemTag("chests");
	public static final TagKey<Item> WOODEN_BOOKSHELVES = registerItemTag("wooden_bookshelves");
	public static final TagKey<Item> WOODEN_CHESTS = registerItemTag("wooden_chests");
	public static final TagKey<Item> WOODEN_LADDERS = registerItemTag("wooden_ladders");
	public static final TagKey<Item> WOODEN_TRAPPED_CHESTS = registerItemTag("wooden_trapped_chests");
	public static final TagKey<Item> TINDER_MATERIALS = registerItemTag("tinder_materials");
	
	public static final TagKey<Item> REPAIRS_WOODEN_ARMOR = registerItemTag("repairs_wooden_armor");
	public static final TagKey<Item> REPAIRS_EMERALD_ARMOR = registerItemTag("repairs_emerald_armor");
	public static final TagKey<Item> WOODEN_EQUIPMENT = registerItemTag("wooden_equipment");
	public static final TagKey<Item> STONE_EQUIPMENT = registerItemTag("stone_equipment");
	public static final TagKey<Item> COPPER_EQUIPMENT = registerItemTag("copper_equipment");
	public static final TagKey<Item> IRON_EQUIPMENT = registerItemTag("iron_equipment");
	public static final TagKey<Item> GOLD_EQUIPMENT = registerItemTag("gold_equipment");
	public static final TagKey<Item> DIAMOND_EQUIPMENT = registerItemTag("diamond_equipment");
	public static final TagKey<Item> UPGRADES_WOODEN_EQUIPMENT = registerItemTag("upgrades_wooden_equipment");
	public static final TagKey<Item> UPGRADES_STONE_EQUIPMENT = registerItemTag("upgrades_stone_equipment");
	public static final TagKey<Item> UPGRADES_COPPER_EQUIPMENT = registerItemTag("upgrades_copper_equipment");
	public static final TagKey<Item> UPGRADES_IRON_EQUIPMENT = registerItemTag("upgrades_iron_equipment");
	public static final TagKey<Item> UPGRADES_GOLD_EQUIPMENT = registerItemTag("upgrades_gold_equipment");
	public static final TagKey<Item> UPGRADES_EMERALD_EQUIPMENT = registerItemTag("upgrades_emerald_equipment");
	
	public static final TagKey<Item> EMERALD_TOOL_MATERIALS = registerItemTag("emerald_tool_materials");
	
	//  Vanilla
	public static final TagKey<Item> CUT_COPPER = registerItemTag("cut_copper");
	
	private static TagKey<Item> registerItemTag(String id) {
		return TagKey.of(Registries.ITEM.getKey(), JinericMain.ofJineric(id));
	}
	
	public static void initialize() {
	}
}
