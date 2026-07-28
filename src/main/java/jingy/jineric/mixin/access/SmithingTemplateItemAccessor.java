package jingy.jineric.mixin.access;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.SmithingTemplateItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SmithingTemplateItem.class)
public interface SmithingTemplateItemAccessor {
	
	@Accessor("EMPTY_SLOT_HELMET")
	static Identifier getEmptyHelmetTexture() {
		throw new IllegalStateException("Could not access EMPTY_ARMOR_SLOT_HELMET_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_CHESTPLATE")
	static Identifier getEmptyChestplateTexture() {
		throw new IllegalStateException("Could not access EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_LEGGINGS")
	static Identifier getEmptyLeggingsTexture() {
		throw new IllegalStateException("Could not access EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_BOOTS")
	static Identifier getEmptyBootsTexture() {
		throw new IllegalStateException("Could not access EMPTY_ARMOR_SLOT_BOOTS_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_PICKAXE")
	static Identifier getEmptyPickaxeTexture() {
		throw new IllegalStateException("Could not access EMPTY_SLOT_PICKAXE_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_SWORD")
	static Identifier getEmptySwordTexture() {
		throw new IllegalStateException("Could not access EMPTY_SLOT_SWORD_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_AXE")
	static Identifier getEmptyAxeTexture() {
		throw new IllegalStateException("Could not access EMPTY_SLOT_AXE_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_HOE")
	static Identifier getEmptyHoeTexture() {
		throw new IllegalStateException("Could not access EMPTY_SLOT_HOE_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_SHOVEL")
	static Identifier getEmptyShovelTexture() {
		throw new IllegalStateException("Could not access EMPTY_SLOT_SHOVEL_TEXTURE in SmithingTemplateItem!");
	}
	
	@Accessor("EMPTY_SLOT_INGOT")
	static Identifier getEmptySlotIngotTexture() {
		throw new IllegalStateException("Could not access EMPTY_SLOT_INGOT_TEXTURE in SmithingTemplateItem!");
	}
}
