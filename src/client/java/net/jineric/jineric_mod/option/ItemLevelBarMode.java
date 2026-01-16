package net.jineric.jineric_mod.option;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.TranslatableOption;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

@Environment(EnvType.CLIENT)
public enum ItemLevelBarMode implements TranslatableOption {
	ALWAYS(0, "options.jineric.itemLevelBar.always"),
	HOVER(1, "options.jineric.itemLevelBar.hover"),
	NEVER(2, "options.jineric.itemLevelBar.never")
	;
	
	private static final IntFunction<ItemLevelBarMode> BY_ID = ValueLists.createIndexToValueFunction(ItemLevelBarMode::getId, values(), ValueLists.OutOfBoundsHandling.WRAP);
	private final int id;
	private final String translationKey;
	
	ItemLevelBarMode(int id, String translationKey) {
		this.id = id;
		this.translationKey = translationKey;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public String getTranslationKey() {
		return this.translationKey;
	}
	
	
	@Override
	public String toString() {
		return switch (this) {
			case ALWAYS -> "always";
			case HOVER -> "hover";
			case NEVER -> "never";
		};
	}
	
	public static ItemLevelBarMode get(int id) {
		return BY_ID.apply(id);
	}
}
