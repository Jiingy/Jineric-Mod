package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.StaticMixinFields;
import net.jineric.jineric_mod.option.JmGameOptions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DrawContext.class)
public abstract class DrawContextMixin {
	@Shadow @Final private MinecraftClient client;
	
	@WrapOperation(
			method = "drawItemBar",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;isItemBarVisible()Z"
			)
	)
	private boolean applyItemLevelBarMode(ItemStack instance, Operation<Boolean> original) {
		if (instance.jineric$isUpgradable() && this.canShowLevelBar(instance) && this.client.player != null) {
			ClientPlayerEntity clientPlayer = this.client.player;
			switch (JmGameOptions.getItemLevelBarMode().getValue()) {
				case ALWAYS -> {return true;}
				case HOVER -> {
					if (instance == clientPlayer.currentScreenHandler.getCursorStack()
							|| instance == clientPlayer.getStackInHand(Hand.MAIN_HAND)
							|| instance == clientPlayer.getStackInHand(Hand.OFF_HAND)
							|| instance == StaticMixinFields.FOCUSSED_HANDLED_SCREEN_ITEM_STACK
//							|| instance == this.client.player.getActiveItem()
					) {
						return true;
					}
				}
				case NEVER -> {return false;}
			}
		}
		return original.call(instance);
	}
	
	@Unique
	private boolean canShowLevelBar(ItemStack itemStack) {
		return itemStack.jineric$getLevel() >= 1 && itemStack.jineric$getLevel() < itemStack.jineric$getMaxLevel();
	}
}
