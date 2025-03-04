package jingy.jineric.access;

import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;

public interface BlockFamilyBuilderDuckAccess {
	
	default BlockFamily.Builder modded$jineric() {
		return null;
	}
	
	default BlockFamily.Builder pillar$jineric(Block block) {
		return null;
	}
	
	default BlockFamily.Builder bookshelf$jineric(Block block) {
		return null;
	}
	
	default BlockFamily.Builder chest$jineric(Block block) {
		return null;
	}
	
	default BlockFamily.Builder trappedChest$jineric(Block block) {
		return null;
	}
	
	default BlockFamily.Builder ladder$jineric(Block block) {
		return null;
	}
	
	default BlockFamily.Builder hangingSign$jineric(Block hangingSign, Block wallHangingSign) {
		return null;
	}
}
