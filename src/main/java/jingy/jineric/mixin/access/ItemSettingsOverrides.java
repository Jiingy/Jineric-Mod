package jingy.jineric.mixin.access;

import jingy.jineric.access.ItemSettingsAccess;
import jingy.jineric.component.JmDataComponentTypes;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.Settings.class)
public abstract class ItemSettingsOverrides implements ItemSettingsAccess {
	@Shadow
	public abstract <T> Item.Settings component(ComponentType<T> type, T value);
	
	@Override
	public Item.Settings jineric$maxLevel(int max) {
		this.component(JmDataComponentTypes.LEVEL, 0);
		this.component(JmDataComponentTypes.MAX_LEVEL, max);
		this.component(DataComponentTypes.MAX_STACK_SIZE, 1);
		return ((Item.Settings) (Object) this);
	}
}
