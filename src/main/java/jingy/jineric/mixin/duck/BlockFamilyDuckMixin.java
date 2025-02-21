package jingy.jineric.mixin.duck;

import jingy.jineric.access.BlockFamilyDuckAccess;
import net.minecraft.data.family.BlockFamily;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BlockFamily.class)
public class BlockFamilyDuckMixin implements BlockFamilyDuckAccess {
	@Unique
	boolean jineric_mod$modded = false;
	
	@Override
	public boolean jineric_mod$isModded() {
		return this.jineric_mod$modded;
	}
	
	@Override
	public void jineric_mod$setModded(boolean modded) {
		this.jineric_mod$modded = modded;
	}
}
