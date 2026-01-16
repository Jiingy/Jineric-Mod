package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.StaticMixinFields;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
	
	@Inject(
			method = "renderHotbar",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/entity/player/PlayerEntity;getOffHandStack()Lnet/minecraft/item/ItemStack;"
			)
	)
	private void activateLevelBarIfSelected(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci, @Local(ordinal = 0) PlayerEntity playerEntity) {
		this.setStaticSelectedSlot(playerEntity);
	}
	
	@Unique
	private void setStaticSelectedSlot(PlayerEntity playerEntity) {
		StaticMixinFields.SELECTED_SLOT = playerEntity.getInventory().getSelectedSlot();
		StaticMixinFields.ACTIVE_HOTBAR_ITEM_STACK = playerEntity.getInventory().getSelectedStack();
	}
}
