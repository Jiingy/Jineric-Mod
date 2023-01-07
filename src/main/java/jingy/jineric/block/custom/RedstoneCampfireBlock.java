package jingy.jineric.block.custom;

import jingy.jineric.block.entity.custom.RedstoneCampfireBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class RedstoneCampfireBlock extends CampfireBlock implements Waterloggable {

   public static final BooleanProperty SIGNAL_FIRE = Properties.SIGNAL_FIRE;
   public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

   public RedstoneCampfireBlock(boolean emitsParticles, int fireDamage, Settings settings) {
      super(emitsParticles, fireDamage, settings);
      this.setDefaultState(
           this.stateManager
                .getDefaultState()
                .with(LIT, Boolean.TRUE)
                .with(SIGNAL_FIRE, Boolean.FALSE)
                .with(WATERLOGGED, Boolean.FALSE)
                .with(FACING, Direction.NORTH)
      );
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

      if (state.get(LIT)) {
         this.scheduleTick(world, pos);
      }
      return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
   }

   private void scheduleTick(WorldAccess world, BlockPos pos) {
      if (!world.isClient() && !world.getBlockTickScheduler().isQueued(pos, this)) {
         world.scheduleBlockTick(pos, this, 2);
      }
   }

   @Override
   public boolean emitsRedstonePower(BlockState state) {
      return true;
   }

   @Override
   public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
      boolean isSignalFire = state.get(SIGNAL_FIRE);
      return state.get(LIT) ? (isSignalFire ? 15 : 8) : 0;
   }

   @Override
   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof RedstoneCampfireBlockEntity redstoneCampfireBlock) {
         ItemStack itemStack = player.getStackInHand(hand);
         Optional<CampfireCookingRecipe> optional = redstoneCampfireBlock.getRecipeFor(itemStack);
         if (optional.isPresent()) {
            if (!world.isClient
                    && redstoneCampfireBlock.addItem(
                            player, player.getAbilities().creativeMode ? itemStack.copy() : itemStack, ((CampfireCookingRecipe)optional.get()).getCookTime()
               )) {
               player.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
               return ActionResult.SUCCESS;
            }

            return ActionResult.CONSUME;
         }
      }

      return ActionResult.PASS;
   }

   @Override
   public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
      if (!state.isOf(newState.getBlock())) {
         BlockEntity blockEntity = world.getBlockEntity(pos);
         if (blockEntity instanceof RedstoneCampfireBlockEntity) {
            ItemScatterer.spawn(world, pos, ((RedstoneCampfireBlockEntity)blockEntity).getItemsBeingCooked());
         }

         super.onStateReplaced(state, world, pos, newState, moved);
      }
   }

   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return new RedstoneCampfireBlockEntity(pos, state);
   }

   @Nullable
   @Override
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
      if (world.isClient) {
         return state.get(LIT) ? checkType(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::clientTick) : null;
      } else {
         return state.get(LIT)
                 ? checkType(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::litServerTick)
                 : checkType(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::unlitServerTick);
      }
   }

//   @Override
//   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//      builder.add(LIT);
//   }
}
