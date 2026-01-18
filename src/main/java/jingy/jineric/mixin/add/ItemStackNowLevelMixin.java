package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.serialization.DataResult;
import jingy.jineric.access.ItemStackAccess;
import jingy.jineric.component.JmDataComponentTypes;
import jingy.jineric.config.JmConfig;
import jingy.jineric.item.WeaponUpgrader;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackNowLevelMixin implements ItemStackAccess, DataComponentHolder {
	@Shadow @Nullable public abstract <T> T set(DataComponentType<T> type, @Nullable T value);
	@Shadow public abstract Item getItem();
	
	@WrapOperation(//   Disables items from taking damage and instead levels them if applicable
			method = "hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;)V",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V"
			)
	)
	private void disableDamage(ItemStack instance, int amount, ServerLevel world, @Nullable ServerPlayer player, Consumer<Item> breakCallback, Operation<Void> original) {
		if (instance.jineric$isUpgradable()) {
			int level = instance.jineric$getLevel();
			if (JmConfig.MODE_UPGRADE) {
				if (level < instance.jineric$getMaxLevel()) {
					this.level(level, amount, world, player, breakCallback);
				}
			}
		} else {
			original.call(instance, amount, world, player, breakCallback);
		}
	}
	
	@WrapOperation(//   Increase level of weapons on attack
			method = "postHurtEnemy",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;)V"
			)
	)
	private void calculateWeaponLevelIncrease(
			ItemStack instance, int amount, LivingEntity user, EquipmentSlot slot, Operation<Void> original,
			@Local(name = "target", ordinal = 0, argsOnly = true)LivingEntity target
	) {
		if (target.canBeSeenAsEnemy() && target.isPickable() && target.isAttackable()) {
			if (instance.is(ItemTags.SWORDS)) {
				instance.hurtAndBreak(WeaponUpgrader.setLevelIncrease(target), user, slot);
			} else if (instance.is(ItemTags.AXES)) {
				instance.hurtAndBreak(WeaponUpgrader.setLevelIncrease(target) / 2, user, slot);
			} else {
				original.call(instance, amount, user, slot);
			}
		}
		
	}
	
	@Inject(//  Disables items from having both durability and a max level
			method = "validateComponents",
			at = @At("HEAD"),
			cancellable = true
	)
	private static void crossCheckDamageAndLevel(DataComponentMap components, CallbackInfoReturnable<DataResult<Unit>> cir) {
		if (JmConfig.MODE_UPGRADE) {
			if (components.has(DataComponents.MAX_DAMAGE) && components.has(JmDataComponentTypes.MAX_LEVEL)) {
				cir.setReturnValue(DataResult.error(() -> "Item cannot have both durability and a max level"));
			}
		}
	}
	
	@Inject(//  Adds an item's level to its tooltip
			method = "addDetailsToTooltip",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/item/TooltipFlag;isAdvanced()Z"
			)
	)
	private void appendLevelTooltip(Item.TooltipContext context, TooltipDisplay displayComponent, @Nullable Player player, TooltipFlag type, Consumer<Component> textConsumer, CallbackInfo ci) {
		if (type.isAdvanced()) {
			if (this.jineric$isUpgradable() && displayComponent.shows(JmDataComponentTypes.LEVEL)) {
				if (this.jineric$getLevel() == this.jineric$getMaxLevel()) {
					textConsumer.accept(Component.translatable("item.level.max"));
				} else {
					textConsumer.accept(Component.translatable("item.level", this.jineric$getLevel(), this.jineric$getMaxLevel()));
				}
			}
		}
	}
	
	
	
	@Unique
	public void level(int level, int amount, ServerLevel serverLevel, @Nullable ServerPlayer player, Consumer<Item> breakCallback) {
		int i = this.calculateLevel(amount, serverLevel, player);
		if (i != 0) {
			this.jineric$setLevel(level + amount);
			if (player != null && this.jineric$getRemainingLevel() == 0) {
				serverLevel.playPlayerSound(SoundEvents.NOTE_BLOCK_CHIME.value(), SoundSource.PLAYERS, 0.75f, 1.0f);
			}
		}
	}
	
	@Unique
	private int calculateLevel(int baseAmount, ServerLevel serverLevel, @Nullable ServerPlayer player) {
		if (!this.jineric$isUpgradable()) {
			return 0;
		} else if (player != null && player.hasInfiniteMaterials()) {
			return 0;
		} else {
			return baseAmount; //baseLevel > 0 ? EnchantmentHelper.getItemDamage(serverLevel, (ItemStack) (Object) this, baseLevel) : baseLevel;
		}
	}
}
