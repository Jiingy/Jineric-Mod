package jingy.jineric.block.custom;

import jingy.jineric.block.entity.custom.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.ChestType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class JinericChestBlockBase extends ChestBlock {

   private final JinericChestType type;

   public JinericChestBlockBase(Settings settings, JinericChestType type) {
      super(settings, type::getBlockEntityType);
      this.type = type;
   }

   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return this.type.getEntity(pos, state);
   }

   @Override
   public BlockState getPlacementState(ItemPlacementContext ctx) {
      ChestType chestType = ChestType.SINGLE;
      Direction direction = ctx.getPlayerFacing().getOpposite();
      FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
      boolean bl = ctx.shouldCancelInteraction();
      Direction direction2 = ctx.getSide();
      if (direction2.getAxis().isHorizontal() && bl) {
         Direction direction3 = this.getNeighborChestDirection(ctx, direction2.getOpposite());
         if (direction3 != null && direction3.getAxis() != direction2.getAxis()) {
            direction = direction3;
            chestType = direction3.rotateYCounterclockwise() == direction2.getOpposite() ? ChestType.RIGHT : ChestType.LEFT;
         }
      }

      if (chestType == ChestType.SINGLE && !bl) {
         if (direction == this.getNeighborChestDirection(ctx, direction.rotateYClockwise())) {
            chestType = ChestType.LEFT;
         } else if (direction == this.getNeighborChestDirection(ctx, direction.rotateYCounterclockwise())) {
            chestType = ChestType.RIGHT;
         }
      }

      return this.getDefaultState().with(FACING, direction).with(CHEST_TYPE, chestType).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
   }

   //TODO: Double Chest block name is improper

   @Nullable
   private Direction getNeighborChestDirection(ItemPlacementContext ctx, Direction dir) {
      BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir));
      return blockState.isOf(this) && blockState.get(CHEST_TYPE) == ChestType.SINGLE ? blockState.get(FACING) : null;
   }

   public JinericChestType getType() {
      return type;
   }

   public BlockEntityType<? extends JinericChestBlockEntity> getExpectedEntityType() {
      return (BlockEntityType)this.entityTypeRetriever.get();
   }

   @Nullable
   @Override
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
      return world.isClient ? checkType(type, this.getExpectedEntityType(), JinericChestBlockEntity::clientTick) : null;
   }
}
