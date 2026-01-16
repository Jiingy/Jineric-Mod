package jingy.jineric.access;

import net.minecraft.item.Item;

public interface ItemSettingsAccess {
	
	default Item.Settings jineric$maxLevel(int max) {
		throw new RuntimeException("ItemSettingsAccess failed");
	}
}
