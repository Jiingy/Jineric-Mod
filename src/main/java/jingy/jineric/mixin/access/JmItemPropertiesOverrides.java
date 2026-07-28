package jingy.jineric.mixin.access;

import jingy.jineric.base.injected_interfaces.JmItemProperties;
import jingy.jineric.component.JmDataComponentTypes;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.Properties.class)
public abstract class JmItemPropertiesOverrides implements JmItemProperties {
	@Shadow public abstract <T> Item.Properties component(DataComponentType<T> type, T value);
	
	@Override
	public Item.Properties jineric$maxLevel(int max) {
		this.component(JmDataComponentTypes.LEVEL, 0);
		this.component(JmDataComponentTypes.MAX_LEVEL, max);
		this.component(DataComponents.MAX_STACK_SIZE, 1);
		return ((Item.Properties) (Object) this);
	}
}
