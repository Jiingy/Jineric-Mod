package net.jineric.jineric_mod.mixin.client;

import jingy.jineric.StaticMixinFields;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin {
	@Shadow @Nullable protected Slot focusedSlot;
	
	@Inject(
			method = "renderMain",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/screen/ingame/HandledScreen;drawSlotHighlightBack(Lnet/minecraft/client/gui/DrawContext;)V"
			)
	)
	private void getFocussedSlot(DrawContext context, int mouseX, int mouseY, float deltaTicks, CallbackInfo ci) {
		if (this.focusedSlot != null) {
			StaticMixinFields.FOCUSSED_HANDLED_SCREEN_ITEM_STACK = this.focusedSlot.getStack();
		} else {
			resetFocussedItem();
		}
	}
	
	@Inject(
			method = "close",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/screen/ingame/HandledScreen;resetTooltipSubmenus(Lnet/minecraft/screen/slot/Slot;)V"
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
