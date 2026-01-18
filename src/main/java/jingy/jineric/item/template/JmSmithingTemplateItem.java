package jingy.jineric.item.template;

import jingy.jineric.base.JinericMain;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import java.util.List;

public class JmSmithingTemplateItem {
	//  Vanilla
	private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.withDefaultNamespace("container/slot/helmet");
	private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.withDefaultNamespace("container/slot/chestplate");
	private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.withDefaultNamespace("container/slot/leggings");
	private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.withDefaultNamespace("container/slot/boots");
	private static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.withDefaultNamespace("container/slot/hoe");
	private static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.withDefaultNamespace("container/slot/axe");
	private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.withDefaultNamespace("container/slot/sword");
	private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.withDefaultNamespace("container/slot/shovel");
	private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.withDefaultNamespace("container/slot/pickaxe");
	private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.withDefaultNamespace("container/slot/ingot");
	private static final Identifier EMPTY_SLOT_REDSTONE_DUST_TEXTURE = Identifier.withDefaultNamespace("container/slot/redstone_dust");
	private static final Identifier EMPTY_SLOT_QUARTZ_TEXTURE = Identifier.withDefaultNamespace("container/slot/quartz");
	private static final Identifier EMPTY_SLOT_EMERALD_TEXTURE = Identifier.withDefaultNamespace("container/slot/emerald");
	private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE = Identifier.withDefaultNamespace("container/slot/diamond");
	private static final Identifier EMPTY_SLOT_LAPIS_LAZULI_TEXTURE = Identifier.withDefaultNamespace("container/slot/lapis_lazuli");
	private static final Identifier EMPTY_SLOT_AMETHYST_SHARD_TEXTURE = Identifier.withDefaultNamespace("container/slot/amethyst_shard");
	//  Modded
	private static final Identifier EMPTY_SLOT_BLOCK_TEXTURE = JinericMain.ofJineric("container/slot/block");
	
	//  Stone
	public static SmithingTemplateItem createStoneUpgrade(Item.Properties settings) {
		return new SmithingTemplateItem(
				SmithingTemplateItemText.STONE_UPGRADE_APPLIES_TO_TEXT,
				SmithingTemplateItemText.STONE_UPGRADE_INGREDIENTS_TEXT,
				SmithingTemplateItemText.STONE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
				SmithingTemplateItemText.STONE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
				getStoneUpgradeEmptyBaseSlotTextures(),
				getStoneUpgradeEmptyAdditionsSlotTextures(),
				settings
		);
	}
	private static List<Identifier> getStoneUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}
	private static List<Identifier> getStoneUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_BLOCK_TEXTURE);
	}
	
	//  Copper
	public static SmithingTemplateItem createCopperUpgrade(Item.Properties settings) {
		return new SmithingTemplateItem(
				SmithingTemplateItemText.COPPER_UPGRADE_APPLIES_TO_TEXT,
				SmithingTemplateItemText.COPPER_UPGRADE_INGREDIENTS_TEXT,
				SmithingTemplateItemText.COPPER_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
				SmithingTemplateItemText.COPPER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
				getCopperUpgradeEmptyBaseSlotTextures(),
				getCopperUpgradeEmptyAdditionsSlotTextures(),
				settings
		);
	}
	private static List<Identifier> getCopperUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}
	private static List<Identifier> getCopperUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}
	
	//  Iron
	public static SmithingTemplateItem createIronUpgrade(Item.Properties settings) {
		return new SmithingTemplateItem(
				SmithingTemplateItemText.IRON_UPGRADE_APPLIES_TO_TEXT,
				SmithingTemplateItemText.IRON_UPGRADE_INGREDIENTS_TEXT,
				SmithingTemplateItemText.IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
				SmithingTemplateItemText.IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
				getIronUpgradeEmptyBaseSlotTextures(),
				getIronUpgradeEmptyAdditionsSlotTextures(),
				settings
		);
	}
	private static List<Identifier> getIronUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}
	private static List<Identifier> getIronUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}
	
	//  Gold
	public static SmithingTemplateItem createGoldUpgrade(Item.Properties settings) {
		return new SmithingTemplateItem(
				SmithingTemplateItemText.GOLD_UPGRADE_APPLIES_TO_TEXT,
				SmithingTemplateItemText.GOLD_UPGRADE_INGREDIENTS_TEXT,
				SmithingTemplateItemText.GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
				SmithingTemplateItemText.GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
				getGoldUpgradeEmptyBaseSlotTextures(),
				getGoldUpgradeEmptyAdditionsSlotTextures(),
				settings
		);
	}
	private static List<Identifier> getGoldUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}
	private static List<Identifier> getGoldUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}
	
	//  DIAMOND
	public static SmithingTemplateItem createDiamondUpgrade(Item.Properties settings) {
		return new SmithingTemplateItem(
				SmithingTemplateItemText.DIAMOND_UPGRADE_APPLIES_TO_TEXT,
				SmithingTemplateItemText.DIAMOND_UPGRADE_INGREDIENTS_TEXT,
				SmithingTemplateItemText.DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
				SmithingTemplateItemText.DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
				getDiamondUpgradeEmptyBaseSlotTextures(),
				getDiamondUpgradeEmptyAdditionsSlotTextures(),
				settings
		);
	}
	private static List<Identifier> getDiamondUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}
	private static List<Identifier> getDiamondUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_DIAMOND_TEXTURE);
	}
}
