package net.jineric.jineric_mod.option;

import com.mojang.serialization.Codec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;

@Environment(EnvType.CLIENT)
public enum ItemLevelBarMode implements StringRepresentable {
	ALWAYS("always", "options.jineric.itemLevelBar.always"),
	HOVER("hover", "options.jineric.itemLevelBar.hover"),
	NEVER("never", "options.jineric.itemLevelBar.never")
	;
	
	public static final Codec<ItemLevelBarMode> CODEC = StringRepresentable.fromEnum(ItemLevelBarMode::values);
	private final String serializedName;
	private final Component caption;
	
	ItemLevelBarMode(final String serializedName, final String caption) {
		this.serializedName = serializedName;
		this.caption = Component.translatable(caption);
	}
	
	public Component caption() {
		return this.caption;
	}
	
	@Override
	public String getSerializedName() {
		return serializedName;
	}
}
