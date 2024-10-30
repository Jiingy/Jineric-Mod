package jingy.jineric.block;

import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
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
   public ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      if (world.getBlockEntity(pos) instanceof RedstoneCampfireBlockEntity redstoneCampfireBlockEntity) {
         ItemStack itemStack = player.getStackInHand(hand);
         if (world.getRecipeManager().getPropertySet(RecipePropertySet.CAMPFIRE_INPUT).canUse(itemStack)) {
            if (world instanceof ServerWorld serverWorld && redstoneCampfireBlockEntity.addItem(serverWorld, player, itemStack)) {
               //TODO: ADD STATISTIC FOR REDSTONE CAMPFIRE
//               player.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
               return ActionResult.SUCCESS_SERVER;
            }

            return ActionResult.CONSUME;
         }
      }

      return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
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
      if (world instanceof ServerWorld serverWorld) {
         if ((Boolean)state.get(LIT)) {
            ServerRecipeManager.MatchGetter<SingleStackRecipeInput, CampfireCookingRecipe> matchGetter = ServerRecipeManager.createCachedMatchGetter(
                    RecipeType.CAMPFIRE_COOKING
            );
            return validateTicker(
                    type,
                    JinericBlockEntityType.REDSTONE_CAMPFIRE,
                    (worldx, pos, statex, blockEntity) -> RedstoneCampfireBlockEntity.litServerTick(serverWorld, pos, statex, blockEntity, matchGetter)
            );
         } else {
            return validateTicker(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::unlitServerTick);
         }
      } else {
         return state.get(LIT) ? validateTicker(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::clientTick) : null;
      }
   }
}
