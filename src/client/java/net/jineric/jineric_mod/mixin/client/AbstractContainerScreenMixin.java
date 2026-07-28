package net.jineric.jineric_mod.mixin.client;

import jingy.jineric.StaticMixinFields;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerScreen.class)
public abstract class AbstractContainerScreenMixin {
	@Shadow @Nullable protected Slot hoveredSlot;
	
	@Inject(
			method = "renderContents",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;renderSlotHighlightBack(Lnet/minecraft/client/gui/GuiGraphics;)V"
			)
	)
	private void getFocussedSlot(GuiGraphics context, int mouseX, int mouseY, float deltaTicks, CallbackInfo ci) {
		if (this.hoveredSlot != null) {
			StaticMixinFields.FOCUSSED_HANDLED_SCREEN_ITEM_STACK = this.hoveredSlot.getItem();
		} else {
			resetFocussedItem();
		}
	}
	
	@Inject(
			method = "onClose",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;onStopHovering(Lnet/minecraft/world/inventory/Slot;)V"
			)
	)
	private void resetItemLevelBar(CallbackInfo ci) {
		resetFocussedItem();
	}
	
	@Unique
	private void resetFocussedItem() {
		StaticMixinFields.FOCUSSED_HANDLED_SCREEN_ITEM_STACK = ItemStack.EMPTY;
	}
}
