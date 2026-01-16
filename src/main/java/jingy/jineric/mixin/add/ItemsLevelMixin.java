package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.config.JmConfig;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Item.class)
public abstract class ItemsLevelMixin implements ToggleableFeature, ItemConvertible, FabricItem {
	
	@WrapOperation(
			method = "postMine",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;)V"
			)
	)
	private void increaseToolLevelForMining(
			ItemStack instance, int amount, LivingEntity miner, EquipmentSlot slot, Operation<Void> original,
			@Local(index = 3, name = "state", ordinal = 0, argsOnly = true)BlockState state
	) {
		if (instance.isIn(ItemTags.PICKAXES) && state.isIn(ConventionalBlockTags.ORES)) {
			instance.damage(amount * 2, miner, EquipmentSlot.MAINHAND);
		} else {
			original.call(instance, amount, miner, slot);
		}
	}
	
	@WrapOperation(// Uses an item's level instead of damage for the bar rendering
			method = "getItemBarStep",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;getDamage()I")
	)
	private int getLevel(ItemStack instance, Operation<Integer> original) {
		if (JmConfig.MODE_UPGRADE) {
			if (instance.jineric$isUpgradable()) {
				return instance.jineric$getRemainingLevel();
			}
		}
		return original.call(instance);
	}
	
	@WrapOperation(// Uses an item's max level instead of max damage for the bar rendering
			method = "getItemBarStep",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;getMaxDamage()I"
			)
	)
	private int getMaxLevel(ItemStack instance, Operation<Integer> original) {
		if (JmConfig.MODE_UPGRADE) {
			if (instance.jineric$isUpgradable()) {
				return instance.jineric$getMaxLevel();
			}
		}
		return original.call(instance);
	}
	
	@WrapOperation(
			method = "getItemBarColor",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;getDamage()I"
			)
	)
	private int getLevelColor(ItemStack instance, Operation<Integer> original) {
		if (instance.jineric$isUpgradable()) {
			return instance.jineric$getRemainingLevel();
		}
		return original.call(instance);
	}
	
	@WrapOperation(
			method = "getItemBarColor",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;getMaxDamage()I"
			)
	)
	private int getMaxLevelColor(ItemStack instance, Operation<Integer> original) {
		if (instance.jineric$isUpgradable()) {
			return instance.jineric$getMaxLevel();
		}
		return original.call(instance);
	}
}
