package net.jineric.jineric_mod.mixin.client;

import net.jineric.jineric_mod.option.JmGameOptions;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Options.class)
public abstract class GameOptionsMixin {
	
	@Inject(
			method = "processDumpedOptions",
			at = @At(
					value = "HEAD"
			)
	)
	private void keepModdedGameOptionValues(Options.OptionAccess visitor, CallbackInfo ci) {
		visitor.process("jineric.itemLevelBarMode", JmGameOptions.getItemLevelBarMode());
	}
}
