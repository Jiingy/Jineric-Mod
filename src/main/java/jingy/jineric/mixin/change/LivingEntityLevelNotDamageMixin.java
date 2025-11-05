package jingy.jineric.mixin.change;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.config.JmConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityLevelNotDamageMixin {
	
	@WrapOperation(
			method = "damageEquipment",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;isDamageable()Z"
			)
	)
	private boolean levelEquipmentSlotsOnDamage(ItemStack instance, Operation<Boolean> original) {
		if (!JmConfig.MODE_UPGRADE) {
			return instance.isDamageable();
		}
		return instance.jineric$isUpgradable();
	}
}
