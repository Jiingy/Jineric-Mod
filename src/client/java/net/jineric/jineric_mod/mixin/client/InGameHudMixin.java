package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.StaticMixinFields;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Hud.class)
public abstract class InGameHudMixin {
	
	@Inject(
			method = "extractItemHotbar",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/entity/player/Player;getOffhandItem()Lnet/minecraft/world/item/ItemStack;"
			)
	)
	private void activateLevelBarIfSelected(
			GuiGraphicsExtractor graphics, DeltaTracker deltaTracker, CallbackInfo ci,
			@Local(type = Player.class,name = "player") Player player
	) {
		this.setStaticSelectedSlot(player);
	}
	
	@Unique
	private void setStaticSelectedSlot(Player playerEntity) {
		StaticMixinFields.SELECTED_SLOT = playerEntity.getInventory().getSelectedSlot();
		StaticMixinFields.ACTIVE_HOTBAR_ITEM_STACK = playerEntity.getInventory().getSelectedItem();
	}
}
