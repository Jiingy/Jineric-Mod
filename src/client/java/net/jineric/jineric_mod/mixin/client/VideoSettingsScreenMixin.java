package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.jineric.jineric_mod.option.JmGameOptions;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Arrays;

@Mixin(VideoSettingsScreen.class)
public abstract class VideoSettingsScreenMixin {
	
	@ModifyReturnValue(
			method = "preferenceOptions",
			at = @At("RETURN")
	)
	private static OptionInstance<?>[] addModdedGameOptions(OptionInstance<?>[] original, Options options) {
		//  Add modded options to specific indexes of the vanilla GameOptions array
		return ArrayUtils
				.insert(
						putAfter(original, options.attackIndicator()), original, JmGameOptions.getItemLevelBarMode()
				);
	}
	
	@Unique
	private static int putAfter(OptionInstance<?>[] original, OptionInstance<?> option) {
		return Arrays.stream(original).toList().indexOf(option) + 1;
	}
}
