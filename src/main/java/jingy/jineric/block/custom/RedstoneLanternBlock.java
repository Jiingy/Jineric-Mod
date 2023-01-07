package jingy.jineric.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class RedstoneLanternBlock extends LanternBlock {
   public static final BooleanProperty LIT = Properties.LIT;
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
   public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
      this.updateNeighbors(world, pos, state);
   }

   protected void updateNeighbors(World world, BlockPos pos, BlockState state) {
      world.updateNeighborsAlways(pos, this);
   }

   @Override
   public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
      if (state.get(WATERLOGGED)) {
         world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
      }

//      if (state.get(LIT)) {
       this.scheduleTick(world, pos);
//      }
      return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);

//      // IF BLOCK ABOVE IS INVALID FOR PLACEMENT
//      return attachedDirection(state).getOpposite() == direction && !state.canPlaceAt(world, pos)
//              // IF BLOCK BELOW CAN BE PLACED ON
//              ? (attachedDirection(state) == direction && state.canPlaceAt(world, pos)
//                     // TRUE: RETURN HANGING FALSE // FALSE: RETURN AIR
//                     ? state.with(HANGING, Boolean.valueOf(false))
//                     : Blocks.AIR.getDefaultState())
//              : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
   }

   private void scheduleTick(WorldAccess world, BlockPos pos) {
      if (!world.isClient() && !world.getBlockTickScheduler().isQueued(pos, this)) {
         world.scheduleBlockTick(pos, this, 2);
      }
   }

   @Override
   public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
      return direction == Direction.UP || direction == Direction.DOWN ? 15 : 0;
   }
   //(Direction.NORTH != direction) && (Direction.EAST != direction) && (Direction.SOUTH != direction) && (Direction.WEST != direction)

   @Override
   public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
      return Direction.UP != direction && Direction.DOWN != direction ? 15 : 0;
   }

   @Override
   public boolean emitsRedstonePower(BlockState state) {
      return true;
   }
}
