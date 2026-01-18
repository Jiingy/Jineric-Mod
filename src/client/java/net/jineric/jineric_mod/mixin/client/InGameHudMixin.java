package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.StaticMixinFields;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class InGameHudMixin {
	
	@Inject(
			method = "renderItemHotbar",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/entity/player/Player;getOffhandItem()Lnet/minecraft/world/item/ItemStack;"
			)
	)
	private void activateLevelBarIfSelected(GuiGraphics context, DeltaTracker tickCounter, CallbackInfo ci, @Local(ordinal = 0) Player playerEntity) {
		this.setStaticSelectedSlot(playerEntity);
	}
	
	@Unique
	private void setStaticSelectedSlot(Player playerEntity) {
		StaticMixinFields.SELECTED_SLOT = playerEntity.getInventory().getSelectedSlot();
		StaticMixinFields.ACTIVE_HOTBAR_ITEM_STACK = playerEntity.getInventory().getSelectedItem();
	}
}
