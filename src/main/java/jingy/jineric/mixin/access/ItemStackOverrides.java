package jingy.jineric.mixin.access;

import jingy.jineric.base.injected_interfaces.JmItemStack;
import jingy.jineric.component.JmDataComponentTypes;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public abstract class ItemStackOverrides implements JmItemStack, DataComponentHolder {
	@Shadow @Nullable public abstract <T> T set(DataComponentType<T> type, @Nullable T value);
	
	@Override
	public boolean jineric$isLeveled() {
		return this.jineric$isUpgradable() && this.getOrDefault(JmDataComponentTypes.LEVEL, 0) > 0;
	}
	
	@Override
	public boolean jineric$isUpgradable() {
		return this.has(JmDataComponentTypes.MAX_LEVEL);
	}
	
	@Override
	public void jineric$setLevel(int level) {
		this.set(JmDataComponentTypes.LEVEL, Mth.clamp(level, 0, this.jineric$getMaxLevel()));
	}
	
	@Override
	public int jineric$getLevel() {
		return this.getOrDefault(JmDataComponentTypes.LEVEL, 0);
	}
	
	@Override
	public int jineric$getMaxLevel() {
		return this.getOrDefault(JmDataComponentTypes.MAX_LEVEL, 0);
	}
	
	@Override
	public int jineric$getRemainingLevel() {
		return this.jineric$getMaxLevel() - this.jineric$getLevel();
	}
}
