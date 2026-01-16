package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.serialization.DataResult;
import jingy.jineric.config.JmConfig;
import jingy.jineric.access.ItemStackAccess;
import jingy.jineric.component.JmDataComponentTypes;
import jingy.jineric.item.WeaponUpgrader;
import net.minecraft.component.ComponentHolder;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Unit;
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
public abstract class ItemStackNowLevelMixin implements ItemStackAccess, ComponentHolder {
	@Shadow @Nullable public abstract <T> T set(ComponentType<T> type, @Nullable T value);
	@Shadow public abstract Item getItem();
	
	@WrapOperation(//   Disables items from taking damage and instead levels them if applicable
			method = "damage(ILnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;)V",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/server/world/ServerWorld;Lnet/minecraft/server/network/ServerPlayerEntity;Ljava/util/function/Consumer;)V"
			)
	)
	private void disableDamage(ItemStack instance, int amount, ServerWorld world, @Nullable ServerPlayerEntity player, Consumer<Item> breakCallback, Operation<Void> original) {
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
			method = "postDamageEntity",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;damage(ILnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/EquipmentSlot;)V"
			)
	)
	private void calculateWeaponLevelIncrease(
			ItemStack instance, int amount, LivingEntity user, EquipmentSlot slot, Operation<Void> original,
			@Local(name = "target", ordinal = 0, argsOnly = true)LivingEntity target
	) {
		if (target.canTakeDamage() && target.canHit() && target.isAttackable()) {
			if (instance.isIn(ItemTags.SWORDS)) {
				instance.damage(WeaponUpgrader.setLevelIncrease(target), user, slot);
			} else if (instance.isIn(ItemTags.AXES)) {
				instance.damage(WeaponUpgrader.setLevelIncrease(target) / 2, user, slot);
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
	private static void crossCheckDamageAndLevel(ComponentMap components, CallbackInfoReturnable<DataResult<Unit>> cir) {
		if (JmConfig.MODE_UPGRADE) {
			if (components.contains(DataComponentTypes.MAX_DAMAGE) && components.contains(JmDataComponentTypes.MAX_LEVEL)) {
				cir.setReturnValue(DataResult.error(() -> "Item cannot have both durability and a max level"));
			}
		}
	}
	
	@Inject(//  Adds an item's level to its tooltip
			method = "appendTooltip",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/item/tooltip/TooltipType;isAdvanced()Z"
			)
	)
	private void appendLevelTooltip(Item.TooltipContext context, TooltipDisplayComponent displayComponent, @Nullable PlayerEntity player, TooltipType type, Consumer<Text> textConsumer, CallbackInfo ci) {
		if (type.isAdvanced()) {
			if (this.jineric$isUpgradable() && displayComponent.shouldDisplay(JmDataComponentTypes.LEVEL)) {
				if (this.jineric$getLevel() == this.jineric$getMaxLevel()) {
					textConsumer.accept(Text.translatable("item.level.max"));
				} else {
					textConsumer.accept(Text.translatable("item.level", this.jineric$getLevel(), this.jineric$getMaxLevel()));
				}
			}
		}
	}
	
	
	
	@Unique
	public void level(int level, int amount, ServerWorld world, @Nullable ServerPlayerEntity player, Consumer<Item> breakCallback) {
		int i = this.calculateLevel(amount, world, player);
		if (i != 0) {
			this.jineric$setLevel(level + amount);
			if (player != null && this.jineric$getRemainingLevel() == 0) {
				player.playSoundToPlayer(SoundEvents.BLOCK_NOTE_BLOCK_CHIME.value(), SoundCategory.PLAYERS, 0.75f, 1.0f);
			}
		}
	}
	
	@Unique
	private int calculateLevel(int baseAmount, ServerWorld world, @Nullable ServerPlayerEntity player) {
		if (!this.jineric$isUpgradable()) {
			return 0;
		} else if (player != null && player.isInCreativeMode()) {
			return 0;
		} else {
			return baseAmount; //baseLevel > 0 ? EnchantmentHelper.getItemDamage(world, (ItemStack) (Object) this, baseLevel) : baseLevel;
		}
	}
}
