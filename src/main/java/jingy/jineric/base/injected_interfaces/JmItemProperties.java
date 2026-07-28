package jingy.jineric.base.injected_interfaces;

import net.minecraft.world.item.Item;

public interface JmItemProperties {
	
	default Item.Properties jineric$maxLevel(int max) {
		throw new RuntimeException("ItemSettingsAccess failed");
	}
}
