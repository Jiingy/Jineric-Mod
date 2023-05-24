package jingy.jineric.item;

import jingy.jineric.base.JinericMain;
import jingy.jineric.mixin.access.SmithingTemplateItemAccess;
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
           Util.createTranslationKey("item", new Identifier(JinericMain.MOD_ID, "smithing_template.iron_upgrade.applies_to")))
           .formatted(DESCRIPTION_FORMATTING);

   private static final Text IRON_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
           Util.createTranslationKey("item", new Identifier(JinericMain.MOD_ID, "smithing_template.iron_upgrade.ingredients")))
           .formatted(DESCRIPTION_FORMATTING);

   private static final Text IRON_UPGRADE_TEXT = Text.translatable(
           Util.createTranslationKey("upgrade", new Identifier(JinericMain.MOD_ID, "iron_upgrade")))
           .formatted(TITLE_FORMATTING);

   private static final Text IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
           Util.createTranslationKey("item", new Identifier(JinericMain.MOD_ID, "smithing_template.iron_upgrade.base_slot_description"))
   );

   private static final Text IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
           Util.createTranslationKey("item", new Identifier(JinericMain.MOD_ID, "smithing_template.iron_upgrade.additions_slot_description"))
   );

   public JinericSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
      super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
   }

   public static SmithingTemplateItem createIronUpgrade() {
      return new SmithingTemplateItem(
              IRON_UPGRADE_APPLIES_TO_TEXT,
              IRON_UPGRADE_INGREDIENTS_TEXT,
              IRON_UPGRADE_TEXT,
              IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
              IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
              getIronUpgradeEmptyBaseSlotTextures(),
              getIronUpgradeEmptyAdditionsSlotTextures()
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
