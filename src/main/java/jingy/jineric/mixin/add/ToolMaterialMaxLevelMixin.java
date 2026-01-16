package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.config.JmConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ToolMaterial.class)
public abstract class ToolMaterialMaxLevelMixin {
	
	@WrapOperation(
			method = "applyBaseSettings",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/item/Item$Settings;maxDamage(I)Lnet/minecraft/item/Item$Settings;"
			)
	)
	private Item.Settings removeMaxDamage(Item.Settings instance, int maxDamage, Operation<Item.Settings> original) {
		if (JmConfig.MODE_UPGRADE && JmConfig.UPGRADE_EQUIPMENT) {
			return instance.jineric$maxLevel(maxDamage);
		} else {
			return original.call(instance, maxDamage);
		}
	}
}
