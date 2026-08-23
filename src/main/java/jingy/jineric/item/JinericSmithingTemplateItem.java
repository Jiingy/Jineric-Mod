package jingy.jineric.item;

import jingy.jineric.base.JinericMain;
import jingy.jineric.mixin.accessor.SmithingTemplateItemAccessor;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import java.util.List;

public class JinericSmithingTemplateItem extends SmithingTemplateItem {
	private static final ChatFormatting TITLE_FORMATTING = ChatFormatting.GRAY;
	private static final ChatFormatting DESCRIPTION_FORMATTING = ChatFormatting.BLUE;
	
	private static final Component IRON_UPGRADE_APPLIES_TO_TEXT = Component.translatable(
					Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.iron_upgrade.applies_to")))
			.withStyle(DESCRIPTION_FORMATTING);
	
	private static final Component IRON_UPGRADE_INGREDIENTS_TEXT = Component.translatable(
					Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.iron_upgrade.ingredients")))
			.withStyle(DESCRIPTION_FORMATTING);
	
	private static final Component IRON_UPGRADE_TEXT = Component.translatable(
					Util.makeDescriptionId("upgrade", JinericMain.ofJineric("iron_upgrade")))
			.withStyle(TITLE_FORMATTING);
	
	private static final Component IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.iron_upgrade.base_slot_description"))
	);
	
	private static final Component IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(
			Util.makeDescriptionId("item", JinericMain.ofJineric("smithing_template.iron_upgrade.additions_slot_description"))
	);
	
	public JinericSmithingTemplateItem(Component appliesToText, Component ingredientsText, Component baseSlotDescriptionText, Component additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, Properties settings) {
		super(appliesToText, ingredientsText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures, settings);
	}
	
	
	public static SmithingTemplateItem createIronUpgrade(Item.Properties settings) {
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
				SmithingTemplateItemAccessor.getEmptySwordTexture(),
				SmithingTemplateItemAccessor.getEmptyPickaxeTexture(),
				SmithingTemplateItemAccessor.getEmptyAxeTexture(),
				SmithingTemplateItemAccessor.getEmptyHoeTexture(),
				SmithingTemplateItemAccessor.getEmptyShovelTexture()
		);
	}
	
	private static List<Identifier> getIronUpgradeEmptyAdditionsSlotTextures() {
		return List.of(SmithingTemplateItemAccessor.getEmptySlotIngotTexture());
	}
}
