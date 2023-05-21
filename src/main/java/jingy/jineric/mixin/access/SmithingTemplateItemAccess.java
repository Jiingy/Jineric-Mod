package jingy.jineric.mixin.access;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SmithingTemplateItem.class)
public interface SmithingTemplateItemAccess {

   @Accessor("EMPTY_ARMOR_SLOT_HELMET_TEXTURE")
   static Identifier getEmptyHelmetTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_SWORD_TEXTURE")
   static Identifier getEmptySwordTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_SWORD_TEXTURE")
   static Identifier getEmptyChestplateTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_PICKAXE_TEXTURE")
   static Identifier getEmptyPickaxeTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_SWORD_TEXTURE")
   static Identifier getEmptyLeggingsTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_AXE_TEXTURE")
   static Identifier getEmptyAxeTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_SWORD_TEXTURE")
   static Identifier getEmptyBootsTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_HOE_TEXTURE")
   static Identifier getEmptyHoeTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_SHOVEL_TEXTURE")
   static Identifier getEmptyShovelTexture() {
      throw new AssertionError();
   }
   @Accessor("EMPTY_SLOT_INGOT_TEXTURE")
   static Identifier getEmptySlotIngotTexture() {
      throw new AssertionError();
   }
}
