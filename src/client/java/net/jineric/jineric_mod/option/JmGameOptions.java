package net.jineric.jineric_mod.option;

import com.mojang.serialization.Codec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.SimpleOption;

import java.util.Arrays;

@Environment(EnvType.CLIENT)
public class JmGameOptions {
	
	private static final SimpleOption<ItemLevelBarMode> ITEM_LEVEL_BAR_MODE = new SimpleOption<>(
			"options.jineric.itemLevelBarMode",
			SimpleOption.emptyTooltip(),
			SimpleOption.enumValueText(),
			new SimpleOption.PotentialValuesBasedCallbacks<>(
					Arrays.asList(ItemLevelBarMode.values()),
					Codec.INT.xmap(ItemLevelBarMode::get, ItemLevelBarMode::getId)
			),
			ItemLevelBarMode.ALWAYS,
			itemLevelBarMode -> {}
	);
	
	public static SimpleOption<ItemLevelBarMode> getItemLevelBarMode() {
		return ITEM_LEVEL_BAR_MODE;
	}
}
