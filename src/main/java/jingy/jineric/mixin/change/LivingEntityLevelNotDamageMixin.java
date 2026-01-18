package jingy.jineric.mixin.change;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.config.JmConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityLevelNotDamageMixin {
	
	@WrapOperation(
			method = "doHurtEquipment",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;isDamageableItem()Z"
			)
	)
	private boolean levelEquipmentSlotsOnDamage(ItemStack instance, Operation<Boolean> original) {
		if (!JmConfig.MODE_UPGRADE) {
			return instance.isDamageableItem();
		}
		return instance.jineric$isUpgradable();
	}
}
