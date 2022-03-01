package jingy.jineric.blocks;

import net.minecraft.block.Material;
import net.minecraft.block.TrapdoorBlock;

public class JinericTrapdoorBlock extends TrapdoorBlock {
	public JinericTrapdoorBlock(Settings settings) {
		super(Settings.of(Material.WOOD).nonOpaque());
	}
}
