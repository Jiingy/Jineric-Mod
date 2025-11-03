package net.jineric.jineric_mod.data;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.mixin.client.access.TextureKeyAccess;
import net.minecraft.client.data.TextureKey;

@Environment(EnvType.CLIENT)
public class JinericTextureKey {
	
	public static final TextureKey SIDE_SHORT = of("side_short", TextureKey.SIDE);
	public static final TextureKey SIDE_LINE_END = of("side_line_end", TextureKey.END);
	
	public static TextureKey of(String name, TextureKey parent) {
		return TextureKeyAccess.initTextureKey(name, parent);
	}
	
	private static TextureKey of(String name) {
		return TextureKeyAccess.initTextureKey(name, null);
	}
	
	public static void initialize() {
	}
}
