package jingy.jineric.access;

import net.minecraft.world.item.Item;

public interface ItemSettingsAccess {
	
	default Item.Properties jineric$maxLevel(int max) {
		throw new RuntimeException("ItemSettingsAccess failed");
	}
}
