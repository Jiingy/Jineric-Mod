package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.jineric.jineric_mod.option.JmGameOptions;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Arrays;

@Mixin(VideoOptionsScreen.class)
public abstract class VideoOptionsScreenMixin {
	
	@ModifyReturnValue(
			method = "getOptions",
			at = @At("RETURN")
	)
	private static SimpleOption<?>[] addModdedGameOptions(SimpleOption<?>[] original, GameOptions gameOptions) {
		
		//  Add modded options to specific indexes of the vanilla GameOptions array
		SimpleOption<?>[] newOptionsArray = ArrayUtils
				.insert(
						putAfter(original, gameOptions.getAttackIndicator()),
						original,
						JmGameOptions.getItemLevelBarMode()
				)
		;
		return newOptionsArray;
	}
	
	@Unique
	private static int putAfter(SimpleOption<?>[] original, SimpleOption<?> option) {
		return Arrays.stream(original).toList().indexOf(option) + 1;
	}
}
