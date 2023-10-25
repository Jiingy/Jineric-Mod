package jingy.jineric.mixin.access;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SmithingTemplateItem.class)
public interface SmithingTemplateItemAccess {

   @Accessor("EMPTY_ARMOR_SLOT_HELMET_TEXTURE")
   static Identifier getEmptyHelmetTexture() {
      throw new IllegalStateException("Could not access EMPTY_ARMOR_SLOT_HELMET_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE")
   static Identifier getEmptyChestplateTexture() {
      throw new IllegalStateException("Could not access EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE")
   static Identifier getEmptyLeggingsTexture() {
      throw new IllegalStateException("Could not access EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_ARMOR_SLOT_BOOTS_TEXTURE")
   static Identifier getEmptyBootsTexture() {
      throw new IllegalStateException("Could not access EMPTY_ARMOR_SLOT_BOOTS_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_SLOT_PICKAXE_TEXTURE")
   static Identifier getEmptyPickaxeTexture() {
      throw new IllegalStateException("Could not access EMPTY_SLOT_PICKAXE_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_SLOT_SWORD_TEXTURE")
   static Identifier getEmptySwordTexture() {
      throw new IllegalStateException("Could not access EMPTY_SLOT_SWORD_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_SLOT_AXE_TEXTURE")
   static Identifier getEmptyAxeTexture() {
      throw new IllegalStateException("Could not access EMPTY_SLOT_AXE_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_SLOT_HOE_TEXTURE")
   static Identifier getEmptyHoeTexture() {
      throw new IllegalStateException("Could not access EMPTY_SLOT_HOE_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_SLOT_SHOVEL_TEXTURE")
   static Identifier getEmptyShovelTexture() {
      throw new IllegalStateException("Could not access EMPTY_SLOT_SHOVEL_TEXTURE in SmithingTemplateItem!");
   }
   @Accessor("EMPTY_SLOT_INGOT_TEXTURE")
   static Identifier getEmptySlotIngotTexture() {
      throw new IllegalStateException("Could not access EMPTY_SLOT_INGOT_TEXTURE in SmithingTemplateItem!");
   }
}
