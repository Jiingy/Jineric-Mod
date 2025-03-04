package jingy.jineric.access;

import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;

public interface BlockFamilyBuilderDuckAccess {
	
	default BlockFamily.Builder jineric_mod$modded() {
		return null;
	}
	
	default BlockFamily.Builder jineric_mod$pillar(Block block) {
		return null;
	}
	
	default BlockFamily.Builder jineric_mod$bookshelf(Block block) {
		return null;
	}
	
	default BlockFamily.Builder jineric_mod$chest(Block block) {
		return null;
	}
	
	default BlockFamily.Builder jineric_mod$trappedChest(Block block) {
		return null;
	}
	
	default BlockFamily.Builder jineric_mod$ladder(Block block) {
		return null;
	}
	
	default BlockFamily.Builder jineric_mod$hangingSign(Block hangingSign, Block wallHangingSign) {
		return null;
	}
}
