package jingy.jineric.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.TrappedChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WoodenTrappedChestBlock extends WoodenChestBlock {
	public WoodenTrappedChestBlock(Properties settings, WoodType type) {
		super(() -> BlockEntityTypes.TRAPPED_CHEST, settings, type);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new TrappedChestBlockEntity(pos, state);
	}
	
	@Override
	protected Stat<Identifier> getOpenChestStat() {
		return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
	}
	
	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}
	
	@Override
	public int getSignal(BlockState state, BlockGetter blockGetter, BlockPos pos, Direction direction) {
		return Mth.clamp(ChestBlockEntity.getOpenCount(blockGetter, pos), 0, 15);
	}
	
	@Override
	public int getDirectSignal(BlockState state, BlockGetter blockGetter, BlockPos pos, Direction direction) {
		return direction == Direction.UP ? state.getSignal(blockGetter, pos, direction) : 0;
	}
}