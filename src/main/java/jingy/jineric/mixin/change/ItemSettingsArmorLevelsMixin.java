package jingy.jineric.mixin.change;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.base.injected_interfaces.JmItemProperties;
import jingy.jineric.config.JmConfig;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Item.Properties.class)
public abstract class ItemSettingsArmorLevelsMixin implements JmItemProperties {
	
	//  GIVE ARMOR LEVELING
	@WrapOperation(
			method = "humanoidArmor",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/Item$Properties;durability(I)Lnet/minecraft/world/item/Item$Properties;"
			)
	)
	private Item.Properties removeMaxDamage(Item.Properties instance, int maxDamage, Operation<Item.Properties> original) {
		if (JmConfig.MODE_UPGRADE && JmConfig.UPGRADE_EQUIPMENT) {
			return instance.jineric$maxLevel(maxDamage);
		} else {
			return instance;
		}
	}
	
	//  GIVE ARMOR LEVELING
	@WrapOperation(
			method = "humanoidArmor",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/Item$Properties;repairable(Lnet/minecraft/tags/TagKey;)Lnet/minecraft/world/item/Item$Properties;"
			)
	)
	private Item.Properties removeRepairable(Item.Properties instance, TagKey<Item> repairIngredientsTag, Operation<Item.Properties> original) {
		if (JmConfig.MODE_UPGRADE && JmConfig.UPGRADE_EQUIPMENT) {
			return instance;
		} else {
			return original.call(instance, repairIngredientsTag);
		}
	}
}
