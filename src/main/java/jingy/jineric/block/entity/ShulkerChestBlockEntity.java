package jingy.jineric.block.entity;

import jingy.jineric.block.enums.JinericChestType;
import jingy.jineric.screen.ShulkerChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestLidAnimator;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ShulkerChestBlockEntity extends JinericChestBlockEntity {
   private final ChestLidAnimator lidAnimator = new ChestLidAnimator();
//   @Nullable
//   private final DyeColor color;

   public ShulkerChestBlockEntity(
//           @Nullable DyeColor color,
           BlockPos blockPos, BlockState blockState) {
      super(JinericChestType.SHULKER, blockPos, blockState);
//      this.color = color;
      this.setInvStackList(DefaultedList.ofSize(this.size(), ItemStack.EMPTY));
   }

   private final ViewerCountManager stateManager = new ViewerCountManager() {

      @Override
      protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
         world.playSound(
                 (PlayerEntity) null,
                 (double) pos.getX() + 0.5,
                 (double) pos.getY() + 0.5,
                 (double) pos.getZ() + 0.5,
                 SoundEvents.BLOCK_SHULKER_BOX_OPEN,
                 SoundCategory.BLOCKS,
                 0.5F,
                 world.random.nextFloat() * 0.1F + 0.9F
         );
      }

      @Override
      protected void onContainerClose(World world, BlockPos pos, BlockState state) {
         world.playSound(
                 (PlayerEntity)null,
                 (double)pos.getX() + 0.5,
                 (double)pos.getY() + 0.5,
                 (double)pos.getZ() + 0.5,
                 SoundEvents.BLOCK_SHULKER_BOX_CLOSE,
                 SoundCategory.BLOCKS,
                 0.5F,
                 world.random.nextFloat() * 0.1F + 0.9F
         );
      }

      @Override
      protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
         ShulkerChestBlockEntity.this.onViewerCountUpdate(world, pos, state, oldViewerCount, newViewerCount);
      }

      @Override
      protected boolean isPlayerViewing(PlayerEntity player) {
         if (player.currentScreenHandler instanceof ShulkerChestScreenHandler) {
            Inventory inventory = ((ShulkerChestScreenHandler)player.currentScreenHandler).getInventory();
            return inventory == ShulkerChestBlockEntity.this;
         } else {
            return false;
         }
      }
   };

   @Override
   public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
      return new ShulkerChestScreenHandler(syncId, inventory, this);
   }

   @Override
   protected ScreenHandler createScreenHandler(int syncId, PlayerInventory inventory) {
      return new ShulkerChestScreenHandler(syncId, inventory, this);
   }

   public static void clientTick(World world, BlockPos pos, BlockState state, ShulkerChestBlockEntity blockEntity) {
      blockEntity.lidAnimator.step();
   }

   @Override
   public boolean onSyncedBlockEvent(int type, int data) {
      if (type == 1) {
         this.lidAnimator.setOpen(data > 0);
         return true;
      } else {
         return super.onSyncedBlockEvent(type, data);
      }
   }

   public void onOpen(PlayerEntity player) {
      if (!this.removed && !player.isSpectator()) {
         this.stateManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
      }

   }

   public void onClose(PlayerEntity player) {
      if (!this.removed && !player.isSpectator()) {
         this.stateManager.closeContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
      }

   }

   public void onScheduledTick() {
      if (!this.removed) {
         this.stateManager.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
      }

   }

   @Override
   protected Text getContainerName() {
      return Text.translatable("container.shulkerChest");
   }

   @Override
   public int size() {
      return 81;
   }

   @Override
   public float getAnimationProgress(float tickDelta) {
      return this.lidAnimator.getProgress(tickDelta);
   }
}
