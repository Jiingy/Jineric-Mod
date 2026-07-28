package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.config.JmConfig;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Item.class)
public abstract class ItemsLevelMixin implements FeatureElement, ItemLike, FabricItem {
	
	@WrapOperation(
			method = "mineBlock",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;)V"
			)
	)
	private void increaseToolLevelForMining(
			ItemStack instance, int amount, LivingEntity owner, EquipmentSlot slot, Operation<Void> original,
			@Local(index = 3, name = "state", ordinal = 0, argsOnly = true)BlockState state
	) {
		if (instance.is(ItemTags.PICKAXES) && state.is(ConventionalBlockTags.ORES)) {
			instance.hurtAndBreak(amount * 2, owner, EquipmentSlot.MAINHAND);
		} else {
			original.call(instance, amount, owner, slot);
		}
	}
	
	@WrapOperation(// Uses an item's level instead of damage for the bar rendering
			method = "getBarWidth",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;getDamageValue()I")
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
			method = "getBarWidth",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;getMaxDamage()I"
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
			method = "getBarColor",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;getDamageValue()I"
			)
	)
	private int getLevelColor(ItemStack instance, Operation<Integer> original) {
		if (instance.jineric$isUpgradable()) {
			return instance.jineric$getRemainingLevel();
		}
		return original.call(instance);
	}
	
	@WrapOperation(
			method = "getBarColor",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;getMaxDamage()I"
			)
	)
	private int getMaxLevelColor(ItemStack instance, Operation<Integer> original) {
		if (instance.jineric$isUpgradable()) {
			return instance.jineric$getMaxLevel();
		}
		return original.call(instance);
	}
}
