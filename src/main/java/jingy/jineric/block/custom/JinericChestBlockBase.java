package jingy.jineric.block.custom;

import jingy.jineric.block.entity.custom.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class JinericChestBlockBase extends ChestBlock {

   private final JinericChestType type;
   private static final Text ACACIA_DOUBLE = Text.translatable("container.acaciaDouble");
   private final Text BIRCH_DOUBLE = Text.translatable("container.birchDouble");

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

   private static final DoubleBlockProperties.PropertyRetriever<JinericChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<JinericChestBlockEntity, Optional<NamedScreenHandlerFactory>>() {

      public Optional<NamedScreenHandlerFactory> getFromBoth(JinericChestBlockEntity jinericChestBlockEntity, JinericChestBlockEntity jinericChestBlockEntity2) {
         final Inventory inventory = new DoubleInventory(jinericChestBlockEntity, jinericChestBlockEntity2);
         return Optional.of(new NamedScreenHandlerFactory() {
            @Nullable
            @Override
            public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
               if (jinericChestBlockEntity.checkUnlocked(playerEntity) && jinericChestBlockEntity2.checkUnlocked(playerEntity)) {
                  jinericChestBlockEntity.checkLootInteraction(playerInventory.player);
                  jinericChestBlockEntity2.checkLootInteraction(playerInventory.player);
                  return GenericContainerScreenHandler.createGeneric9x6(i, playerInventory, inventory);
               } else {
                  return null;
               }
            }

            @Override
            public net.minecraft.text.Text getDisplayName() {
               if (jinericChestBlockEntity.hasCustomName()) {
                  return jinericChestBlockEntity.getDisplayName();
               } else {
                  return (net.minecraft.text.Text)(jinericChestBlockEntity2.hasCustomName() ? jinericChestBlockEntity2.getDisplayName() : jinericChestBlockEntity.getChestTypeText());
               }
            }
         });
      }

      public Optional<NamedScreenHandlerFactory> getFrom(JinericChestBlockEntity chestBlockEntity) {
         return Optional.of(chestBlockEntity);
      }

      public Optional<NamedScreenHandlerFactory> getFallback() {
         return Optional.empty();
      }
   };

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

//   @Nullable
//   @Override
//   public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
//      return (NamedScreenHandlerFactory)((Optional)this.getBlockEntitySource(state, world, pos, false).apply(NAME_RETRIEVER)).orElse(null);
//   }

   @Nullable
   @Override
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
      return world.isClient ? checkType(type, this.getExpectedEntityType(), JinericChestBlockEntity::clientTick) : null;
   }
}
