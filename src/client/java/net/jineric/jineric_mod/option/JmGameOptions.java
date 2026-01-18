package net.jineric.jineric_mod.option;

import com.mojang.serialization.Codec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.OptionInstance;
import java.util.Arrays;

@Environment(EnvType.CLIENT)
public class JmGameOptions {
	
	private static final OptionInstance<ItemLevelBarMode> ITEM_LEVEL_BAR_MODE = new OptionInstance<>(
			"options.jineric.itemLevelBarMode",
			OptionInstance.noTooltip(),
			(component, itemLevelBarMode) -> itemLevelBarMode.caption(),
			new OptionInstance.Enum<>(
					Arrays.asList(ItemLevelBarMode.values()),
					Codec.withAlternative(ItemLevelBarMode.CODEC, Codec.BOOL, aBoolean -> aBoolean ? ItemLevelBarMode.ALWAYS : ItemLevelBarMode.NEVER)
			),
			ItemLevelBarMode.ALWAYS,
			itemLevelBarMode -> {}
	);
	
	public static OptionInstance<ItemLevelBarMode> getItemLevelBarMode() {
		return ITEM_LEVEL_BAR_MODE;
	}
}
