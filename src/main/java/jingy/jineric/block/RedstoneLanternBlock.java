package jingy.jineric.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class RedstoneLanternBlock extends LanternBlock {
   protected static final VoxelShape HANGING_SHAPE = VoxelShapes.union(
           Block.createCuboidShape(5.0, 1.0, 5.0, 11.0, 8.0, 11.0),
           Block.createCuboidShape(6.0, 8.0, 6.0, 10.0, 10.0, 10.0),
           Block.createCuboidShape(6.5, 10.0, 6.5, 9.5, 16.0, 9.5));

   public RedstoneLanternBlock(Settings settings) {
      super(settings);
   }

   @Override
   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return state.get(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
   }

   @Override
   public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
      for(Direction direction : Direction.values()) {
         world.updateNeighborsAlways(pos.offset(direction), this);
      }
      super.onStateReplaced(state, world, pos, newState, moved);
   }

   @Override
   public BlockState getStateForNeighborUpdate(
           BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos,
           Direction direction, BlockPos neighborPos, BlockState neighborState, Random random
   ) {
      if (state.get(WATERLOGGED)) {
         tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
      }
      return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
   }

   @Override
   public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
      for(Direction direction : Direction.values()) {
         world.updateNeighborsAlways(pos.offset(direction), this);
      }
   }

   @Override
   public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
      if (state.get(HANGING)) {
         return direction == attachedDirection(state) ? 15 : 0;
      } else if (!state.get(HANGING)) {
         return direction == attachedDirection(state) ? 15 : 0;
      }
      return 0;
   }

   @Override
   public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
      return direction != attachedDirection(state) || direction != attachedDirection(state).getOpposite() ? 15 : 0;
   }


   @Override
   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(HANGING, WATERLOGGED);
   }

   @Override
   public boolean emitsRedstonePower(BlockState state) {
      return true;
   }
}
