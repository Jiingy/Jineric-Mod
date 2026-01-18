package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.config.JmConfig;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ToolMaterial.class)
public abstract class ToolMaterialMaxLevelMixin {
	
	@WrapOperation(
			method = "applyCommonProperties",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/Item$Properties;durability(I)Lnet/minecraft/world/item/Item$Properties;"
			)
	)
	private Item.Properties removeMaxDamage(Item.Properties instance, int maxDamage, Operation<Item.Properties> original) {
		if (JmConfig.MODE_UPGRADE && JmConfig.UPGRADE_EQUIPMENT) {
			return instance.jineric$maxLevel(maxDamage);
		} else {
			return original.call(instance, maxDamage);
		}
	}
}
