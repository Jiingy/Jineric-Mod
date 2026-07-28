package jingy.jineric.mixin.duck;

import jingy.jineric.access.JmBlockFamily;
import net.minecraft.data.BlockFamily;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BlockFamily.class)
public class BlockFamilyDuckMixin implements JmBlockFamily {
	@Unique
	boolean jineric_mod$modded = false;
	
	@Override
	public boolean isModded$jineric() {
		return this.jineric_mod$modded;
	}
	
	@Override
	public void setModded$jineric(boolean modded) {
		this.jineric_mod$modded = modded;
	}
}
