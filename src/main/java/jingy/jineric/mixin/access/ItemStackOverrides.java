package jingy.jineric.mixin.access;

import jingy.jineric.access.ItemStackAccess;
import jingy.jineric.component.JmDataComponentTypes;
import net.minecraft.component.ComponentHolder;
import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public abstract class ItemStackOverrides implements ItemStackAccess, ComponentHolder {
	@Shadow @Nullable public abstract <T> T set(ComponentType<T> type, @Nullable T value);
	
	@Override
	public boolean jineric$isLeveled() {
		return this.jineric$isUpgradable() && this.getOrDefault(JmDataComponentTypes.LEVEL, 0) > 0;
	}
	
	@Override
	public boolean jineric$isUpgradable() {
		return this.contains(JmDataComponentTypes.MAX_LEVEL);
	}
	
	@Override
	public void jineric$setLevel(int level) {
		this.set(JmDataComponentTypes.LEVEL, MathHelper.clamp(level, 0, this.jineric$getMaxLevel()));
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
