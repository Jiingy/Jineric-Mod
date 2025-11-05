package jingy.jineric.item.template;

import jingy.jineric.base.JinericMain;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;

public class SmithingTemplateItemText {
	private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;
	
	//  Stone
	public static final Text STONE_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.stone_upgrade.applies_to"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text STONE_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.stone_upgrade.ingredients"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text STONE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.stone_upgrade.base_slot_description"))
	);
	public static final Text STONE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.stone_upgrade.additions_slot_description"))
	);
	
	//  Copper
	public static final Text COPPER_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.copper_upgrade.applies_to"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text COPPER_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.copper_upgrade.ingredients"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text COPPER_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.copper_upgrade.base_slot_description"))
	);
	public static final Text COPPER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.copper_upgrade.additions_slot_description"))
	);
	
	//  Iron
	public static final Text IRON_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.iron_upgrade.applies_to"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text IRON_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.iron_upgrade.ingredients"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.iron_upgrade.base_slot_description"))
	);
	public static final Text IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.iron_upgrade.additions_slot_description"))
	);
	
	//  Gold
	public static final Text GOLD_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.gold_upgrade.applies_to"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text GOLD_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.gold_upgrade.ingredients"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text GOLD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.gold_upgrade.base_slot_description"))
	);
	public static final Text GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.gold_upgrade.additions_slot_description"))
	);
	
	//  Diamond
	public static final Text DIAMOND_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.diamond_upgrade.applies_to"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text DIAMOND_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.diamond_upgrade.ingredients"))
	).formatted(DESCRIPTION_FORMATTING);
	public static final Text DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.diamond_upgrade.base_slot_description"))
	);
	public static final Text DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.diamond_upgrade.additions_slot_description"))
	);
}
