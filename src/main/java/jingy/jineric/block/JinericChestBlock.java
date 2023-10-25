package jingy.jineric.block;

import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class JinericChestBlock extends ChestBlock {
   private final WoodType type;

   public JinericChestBlock(Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier, WoodType type) {
      super(settings, supplier);
      this.type = type;
   }

   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return new JinericChestBlockEntity(JinericBlockEntityType.JINERIC_CHEST, pos, state);
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
                  BlockState blockState = jinericChestBlockEntity.getCachedState();
                  WoodType woodType = JinericChestBlock.getWoodType(blockState.getBlock());
                  return (jinericChestBlockEntity2.hasCustomName() ? jinericChestBlockEntity2.getDisplayName() : jinericChestBlockEntity.getChestTypeKey(woodType));
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

   public WoodType getWoodType() {
      return this.type;
   }

   public static WoodType getWoodType(Block block) {
      WoodType woodType;
      if (block instanceof JinericChestBlock) {
         woodType = ((JinericChestBlock)block).getWoodType();
      }
      else {
         woodType = WoodType.OAK;
      }
      return woodType;
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
      return world.isClient ? validateTicker(type, this.getExpectedEntityType(), JinericChestBlockEntity::clientTick) : null;
   }
}
