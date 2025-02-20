package jingy.jineric.item;

import jingy.jineric.base.JinericMain;
import jingy.jineric.mixin.access.SmithingTemplateItemAccess;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class JinericSmithingTemplateItem extends SmithingTemplateItem {
	private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
	private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;
	
	private static final Text IRON_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
					Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.iron_upgrade.applies_to")))
			.formatted(DESCRIPTION_FORMATTING);
	
	private static final Text IRON_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
					Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.iron_upgrade.ingredients")))
			.formatted(DESCRIPTION_FORMATTING);
	
	private static final Text IRON_UPGRADE_TEXT = Text.translatable(
					Util.createTranslationKey("upgrade", JinericMain.ofJineric("iron_upgrade")))
			.formatted(TITLE_FORMATTING);
	
	private static final Text IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.iron_upgrade.base_slot_description"))
	);
	
	private static final Text IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
			Util.createTranslationKey("item", JinericMain.ofJineric("smithing_template.iron_upgrade.additions_slot_description"))
	);
	
	public JinericSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, Settings settings) {
		super(appliesToText, ingredientsText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures, settings);
	}
	
	
	public static SmithingTemplateItem createIronUpgrade(Item.Settings settings) {
		return new SmithingTemplateItem(
				IRON_UPGRADE_APPLIES_TO_TEXT,
				IRON_UPGRADE_INGREDIENTS_TEXT,
//              IRON_UPGRADE_TEXT,
				IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
				IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
				getIronUpgradeEmptyBaseSlotTextures(),
				getIronUpgradeEmptyAdditionsSlotTextures(),
				settings
		);
	}
	
	private static List<Identifier> getIronUpgradeEmptyBaseSlotTextures() {
		return List.of(
				SmithingTemplateItemAccess.getEmptySwordTexture(),
				SmithingTemplateItemAccess.getEmptyPickaxeTexture(),
				SmithingTemplateItemAccess.getEmptyAxeTexture(),
				SmithingTemplateItemAccess.getEmptyHoeTexture(),
				SmithingTemplateItemAccess.getEmptyShovelTexture()
		);
	}
	
	private static List<Identifier> getIronUpgradeEmptyAdditionsSlotTextures() {
		return List.of(SmithingTemplateItemAccess.getEmptySlotIngotTexture());
	}
}
