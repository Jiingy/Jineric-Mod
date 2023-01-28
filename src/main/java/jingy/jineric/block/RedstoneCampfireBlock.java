package jingy.jineric.block;

import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
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

public class RedstoneCampfireBlock extends CampfireBlock {
   public static final BooleanProperty POWERED = Properties.POWERED;

   public RedstoneCampfireBlock(boolean emitsParticles, int fireDamage, Settings settings) {
      super(emitsParticles, fireDamage, settings);
      this.setDefaultState(
              this.stateManager.getDefaultState().with(POWERED, Boolean.valueOf(false))
      );
   }

   @Override
   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof RedstoneCampfireBlockEntity redstoneCampfireBlock) {
         ItemStack itemStack = player.getStackInHand(hand);
         Optional<CampfireCookingRecipe> optional = redstoneCampfireBlock.getRecipeFor(itemStack);
         if (optional.isPresent()) {
            if (!world.isClient
                    && redstoneCampfireBlock.addItem(player, player.getAbilities().creativeMode
                    ? itemStack.copy() : itemStack, ((CampfireCookingRecipe)optional.get()).getCookTime()
            )) {
               world.updateNeighborsAlways(pos, this);
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
         if (blockEntity instanceof RedstoneCampfireBlockEntity redstoneCampfireBlockEntity) {
            ItemScatterer.spawn(world, pos, redstoneCampfireBlockEntity.getItemsBeingCooked());
         }

         super.onStateReplaced(state, world, pos, newState, moved);
      }
   }

   public static void spawnRedstoneParticle(World world, BlockPos pos, boolean isSignal) {
      Random random = world.getRandom();
      world.addImportantParticle(
              DustParticleEffect.DEFAULT,
              true,
              (double)pos.getX() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1),
              (double)pos.getY() + random.nextDouble() + random.nextDouble(),
              (double)pos.getZ() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1),
              0.0,
              100.1,
              0.0
      );
   }

   @Override
   public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
      if (state.get(WATERLOGGED)) {
         world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
      }
      return direction == Direction.DOWN ?
              state.with(SIGNAL_FIRE, Boolean.valueOf(this.isSignalFireBaseBlock(neighborState)))
              : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
   }

   @Override
   public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
      world.updateNeighborsAlways(pos, this);
   }

   @Override
   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING, POWERED);
   }

   @Override
   public boolean emitsRedstonePower(BlockState state) {
      return true;
   }

   @Override
   public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof RedstoneCampfireBlockEntity redstoneCampfireBlockEntity) {
         if (state.get(POWERED) && state.get(LIT)) {
            return state.get(SIGNAL_FIRE) ? redstoneCampfireBlockEntity.getRedstoneOutput() * 2 : redstoneCampfireBlockEntity.getRedstoneOutput();
         }
         else {
            return 0;
         }
      }
      return 0;
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
}
