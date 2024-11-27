package jingy.jineric.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;

import java.util.function.Supplier;

public class ShulkerChestBlock extends JinericChestBlock {
   public ShulkerChestBlock(Block.Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier, WoodType type) {
      super(supplier, settings, type);
   }

   @Override
   public BlockState getPlacementState(ItemPlacementContext ctx) {
      FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
      return this.getDefaultState()
              .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
              .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
   }

//   @Nullable
//   @Override
//   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
//      return world.isClient ? checkType(type, JinericBlockEntityType.SHULKER_CHEST, ShulkerChestBlockEntity::clientTick) : null;
//   }
}
