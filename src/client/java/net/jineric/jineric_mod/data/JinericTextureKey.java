package net.jineric.jineric_mod.data;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.mixin.client.access.TextureSlotAccessor;
import net.minecraft.client.data.models.model.TextureSlot;

@Environment(EnvType.CLIENT)
public class JinericTextureKey {
	
	public static final TextureSlot SIDE_SHORT = of("side_short", TextureSlot.SIDE);
	public static final TextureSlot SIDE_LINE_END = of("side_line_end", TextureSlot.END);
	
	public static TextureSlot of(String name, TextureSlot parent) {
		return TextureSlotAccessor.invokeInit(name, parent);
	}
	
	private static TextureSlot of(String name) {
		return TextureSlotAccessor.invokeInit(name, null);
	}
	
	public static void initialize() {
	}
}
