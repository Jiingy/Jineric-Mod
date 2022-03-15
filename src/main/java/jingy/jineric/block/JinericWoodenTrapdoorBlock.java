package jingy.jineric.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.TrapdoorBlock;

public class JinericWoodenTrapdoorBlock extends TrapdoorBlock {
	public JinericWoodenTrapdoorBlock(BlockState blockState, Settings settings) {
		super(Settings.of(Material.WOOD).nonOpaque());
	}
}
