package jingy.jineric.access;

import net.minecraft.data.family.BlockFamily;

public interface BlockFamilyBuilderDuckAccess {
	
	default BlockFamily.Builder jineric_mod$modded() {
		return null;
	}
}
