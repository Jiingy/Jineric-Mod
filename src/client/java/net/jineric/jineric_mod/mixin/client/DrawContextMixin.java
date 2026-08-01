package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.StaticMixinFields;
import net.jineric.jineric_mod.option.JmGameOptions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GuiGraphicsExtractor.class)
public abstract class DrawContextMixin {
	@Shadow @Final private Minecraft minecraft;
	
	@WrapOperation(
			method = "itemBar",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;isBarVisible()Z"
			)
	)
	private boolean applyItemLevelBarMode(ItemStack instance, Operation<Boolean> original) {
		if (instance.jineric$isUpgradable() && this.canShowLevelBar(instance) && this.minecraft.player != null) {
			LocalPlayer clientPlayer = this.minecraft.player;
			switch (JmGameOptions.getItemLevelBarMode().get()) {
				case ALWAYS -> {return true;}
				case HOVER -> {
					if (instance == clientPlayer.containerMenu.getCarried()
							|| instance == clientPlayer.getItemInHand(InteractionHand.MAIN_HAND)
							|| instance == clientPlayer.getItemInHand(InteractionHand.OFF_HAND)
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
