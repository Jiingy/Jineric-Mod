package jingy.jineric.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.ExperimentalRedstoneUtils;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class RedstoneLanternBlock extends LanternBlock {
	private static final VoxelShape STANDING_SHAPE = Shapes.or(Block.column(4.0, 7.0, 9.0), Block.column(6.0, 0.0, 7.0));
	protected static final VoxelShape HANGING_SHAPE = Shapes.or(
			Block.box(5.0, 1.0, 5.0, 11.0, 8.0, 11.0),
			Block.box(6.0, 8.0, 6.0, 10.0, 10.0, 10.0),
			Block.box(6.5, 10.0, 6.5, 9.5, 16.0, 9.5)
	);
	
	public RedstoneLanternBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return state.getValue(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
	}
	
	@Override
	protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel world, BlockPos pos, boolean moved) {
		// TODO: THIS CODE JUST COPIES THE REDSTONE TORCH, NEEDS FURTHER TESTING AND INVESTIGATION
		Orientation wireOrientation = this.getEmissionOrientation(world, state);
		for (Direction direction : Direction.values()) {
			world.updateNeighborsAt(pos.relative(direction), this, ExperimentalRedstoneUtils.withFront( wireOrientation, direction));
		}
		super.affectNeighborsAfterRemoval(state, world, pos, moved);
	}
	
	@Override
	public BlockState updateShape(
			BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos,
			Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random
	) {
		if (state.getValue(WATERLOGGED)) {
			tickView.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
	}
	
	@Override
	public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
		this.update(world, pos, state);
	}
	
	private void update(Level world, BlockPos pos, BlockState state) {
		Orientation wireOrientation = this.getEmissionOrientation(world, state);
		for (Direction direction : Direction.values()) {
			world.updateNeighborsAt(pos.relative(direction), this, ExperimentalRedstoneUtils.withFront(wireOrientation, direction));
		}
	}
	
	@Override
	public int getDirectSignal(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
		if (state.getValue(HANGING)) {
			return direction == getConnectedDirection(state) ? 15 : 0;
		} else if (!state.getValue(HANGING)) {
			return direction == getConnectedDirection(state) ? 15 : 0;
		}
		return 0;
	}
	
	@Override
	public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
		return direction != getConnectedDirection(state) || direction != getConnectedDirection(state).getOpposite() ? 15 : 0;
	}
	
	protected boolean shouldUnpower(Level world, BlockPos pos, BlockState state) {
		return world.hasSignal(pos.above(), Direction.UP);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HANGING, WATERLOGGED);
	}
	
	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}
	
	@Nullable
	protected Orientation getEmissionOrientation(Level world, BlockState state) {
		return ExperimentalRedstoneUtils.initialOrientation(world, null, Direction.UP);
	}
}
