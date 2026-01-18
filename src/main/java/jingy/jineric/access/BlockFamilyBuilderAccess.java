package jingy.jineric.access;

import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

public interface BlockFamilyBuilderAccess {
	
	default BlockFamily.Builder modded$Jineric() {
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
}
