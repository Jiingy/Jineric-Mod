package jingy.jineric.block.entity;

import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JinericTrappedChestBlockEntity extends JinericChestBlockEntity {
	public JinericTrappedChestBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(JinericBlockEntityType.JINERIC_TRAPPED_CHEST, blockPos, blockState);
	}
	
	@Override
	protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
		super.onViewerCountUpdate(world, pos, state, oldViewerCount, newViewerCount);
		if (oldViewerCount != newViewerCount) {
			Block block = state.getBlock();
			world.updateNeighborsAlways(pos, block);
			world.updateNeighborsAlways(pos.down(), block);
		}
	}
}
