package jingy.jineric.block;

import jingy.jineric.block.entity.ShulkerChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import jingy.jineric.registry.JinericBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ShulkerChestBlock extends JinericChestBlock {
   public ShulkerChestBlock(FabricBlockSettings settings, JinericChestType type) {
      super(settings, type);
   }

   @Override
   public BlockState getPlacementState(ItemPlacementContext ctx) {
      FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
      return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite()).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
   }

   @Nullable
   @Override
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
      return world.isClient ? checkType(type, JinericBlockEntityType.SHULKER_CHEST, ShulkerChestBlockEntity::clientTick) : null;
   }
}
