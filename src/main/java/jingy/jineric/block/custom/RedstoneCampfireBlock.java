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
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
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
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class JinericCampfireBlock extends CampfireBlock implements Waterloggable {

   public static final BooleanProperty LIT = Properties.LIT;
   public static final BooleanProperty SIGNAL_FIRE = Properties.SIGNAL_FIRE;
   public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

   public JinericCampfireBlock(boolean emitsParticles, int fireDamage, Settings settings) {
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
   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof JinericCampfireBlockEntity JinericCampfireBlock) {
         ItemStack itemStack = player.getStackInHand(hand);
         Optional<CampfireCookingRecipe> optional = JinericCampfireBlock.getRecipeFor(itemStack);
         if (optional.isPresent()) {
            if (!world.isClient
                    && JinericCampfireBlock.addItem(player.getAbilities().creativeMode ? itemStack.copy() : itemStack, optional.get().getCookTime())) {
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
         if (blockEntity instanceof JinericCampfireBlockEntity) {
            ItemScatterer.spawn(world, pos, ((JinericCampfireBlockEntity)blockEntity).getItemsBeingCooked());
         }

         super.onStateReplaced(state, world, pos, newState, moved);
      }
   }

   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return new JinericCampfireBlockEntity(pos, state);
   }

   @Nullable
   @Override
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
      if (world.isClient) {
         return state.get(LIT) ? checkType(type, JinericBlockEntityType.CAMPFIRE, JinericCampfireBlockEntity::clientTick) : null;
      } else {
         return state.get(LIT)
                 ? checkType(type, JinericBlockEntityType.CAMPFIRE, JinericCampfireBlockEntity::litServerTick)
                 : checkType(type, JinericBlockEntityType.CAMPFIRE, JinericCampfireBlockEntity::unlitServerTick);
      }
   }
}
