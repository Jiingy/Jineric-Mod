package jingy.jineric.item.template;

import jingy.jineric.base.JinericMain;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Util;

public class SmithingTemplateItemText {
	private static final ChatFormatting DESCRIPTION_FORMATTING = ChatFormatting.BLUE;
	
	//  Stone
	public static final Component STONE_UPGRADE_APPLIES_TO_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.stone_upgrade.applies_to"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component STONE_UPGRADE_INGREDIENTS_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.stone_upgrade.ingredients"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component STONE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.stone_upgrade.base_slot_description"))
	);
	public static final Component STONE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.stone_upgrade.additions_slot_description"))
	);
	
	//  Copper
	public static final Component COPPER_UPGRADE_APPLIES_TO_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.copper_upgrade.applies_to"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component COPPER_UPGRADE_INGREDIENTS_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.copper_upgrade.ingredients"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component COPPER_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.copper_upgrade.base_slot_description"))
	);
	public static final Component COPPER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.copper_upgrade.additions_slot_description"))
	);
	
	//  Iron
	public static final Component IRON_UPGRADE_APPLIES_TO_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.iron_upgrade.applies_to"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component IRON_UPGRADE_INGREDIENTS_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.iron_upgrade.ingredients"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.iron_upgrade.base_slot_description"))
	);
	public static final Component IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.iron_upgrade.additions_slot_description"))
	);
	
	//  Gold
	public static final Component GOLD_UPGRADE_APPLIES_TO_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.gold_upgrade.applies_to"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component GOLD_UPGRADE_INGREDIENTS_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.gold_upgrade.ingredients"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.gold_upgrade.base_slot_description"))
	);
	public static final Component GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.gold_upgrade.additions_slot_description"))
	);
	
	//  Diamond
	public static final Component DIAMOND_UPGRADE_APPLIES_TO_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.diamond_upgrade.applies_to"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component DIAMOND_UPGRADE_INGREDIENTS_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.diamond_upgrade.ingredients"))
	).withStyle(DESCRIPTION_FORMATTING);
	public static final Component DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.diamond_upgrade.base_slot_description"))
	);
	public static final Component DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.diamond_upgrade.additions_slot_description"))
	);
}
