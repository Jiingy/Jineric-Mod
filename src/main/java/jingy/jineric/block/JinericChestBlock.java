package jingy.jineric.block;

import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;

public class JinericChestBlock extends ChestBlock {
   private final JinericChestType type;

   public JinericChestBlock(Settings settings, JinericChestType type) {
      super(settings, type::getBlockEntityType);
      this.type = type;
   }

   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return this.type.getEntity(pos, state);
   }

   private static final DoubleBlockProperties.PropertyRetriever<JinericChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {

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
                  return (Text) (jinericChestBlockEntity2.hasCustomName() ? jinericChestBlockEntity2.getDisplayName() : jinericChestBlockEntity.getChestTypeKey());
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

   public JinericChestType getType() {
      return type;
   }

   public BlockEntityType<? extends JinericChestBlockEntity> getExpectedEntityType() {
      return (BlockEntityType)this.entityTypeRetriever.get();
   }

   @Override
   public DoubleBlockProperties.PropertySource<? extends JinericChestBlockEntity> getBlockEntitySource(
           BlockState state, World world, BlockPos pos, boolean ignoreBlocked)
   {
      BiPredicate<WorldAccess, BlockPos> biPredicate;
      if (ignoreBlocked) {
         biPredicate = (worldx, posx) -> false;
      } else {
         biPredicate = JinericChestBlock::isChestBlocked;
      }

      return DoubleBlockProperties.toPropertySource(
              (BlockEntityType<? extends JinericChestBlockEntity>)this.entityTypeRetriever.get(),
              JinericChestBlock::getDoubleBlockType, JinericChestBlock::getFacing,
              FACING, state, world, pos, biPredicate
      );
   }

   @Nullable
   @Override
   public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
      return (NamedScreenHandlerFactory)((Optional)this.getBlockEntitySource(state, world, pos, false).apply(NAME_RETRIEVER)).orElse(null);
   }

   @Nullable
   @Override
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
      return world.isClient ? checkType(type, this.getExpectedEntityType(), JinericChestBlockEntity::clientTick) : null;
   }
}
