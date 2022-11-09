package jingy.jineric.block.entity.custom;

import jingy.jineric.block.enums.JinericChestType;
import jingy.jineric.screen.JinericChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.ChestLidAnimator;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class JinericChestBlockEntity extends ChestBlockEntity {

   JinericChestType type;

   private final ViewerCountManager stateManager = new ViewerCountManager() {
      @Override
      protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
         JinericChestBlockEntity.playSound(world, pos, state, SoundEvents.BLOCK_CHEST_OPEN);
      }

      @Override
      protected void onContainerClose(World world, BlockPos pos, BlockState state) {
         JinericChestBlockEntity.playSound(world, pos, state, SoundEvents.BLOCK_CHEST_CLOSE);
      }

      @Override
      protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
         JinericChestBlockEntity.this.onInvOpenOrClose(world, pos, state, oldViewerCount, newViewerCount);
      }

      @Override
      protected boolean isPlayerViewing(PlayerEntity player) {
         if (player.currentScreenHandler instanceof JinericChestScreenHandler) {
            Inventory inventory = ((JinericChestScreenHandler)player.currentScreenHandler).getInventory();
            return inventory == JinericChestBlockEntity.this;
         } else {
            return false;
         }
      }
   };

   private final ChestLidAnimator lidAnimator = new ChestLidAnimator();

   public JinericChestBlockEntity(JinericChestType type, BlockPos blockPos, BlockState blockState) {
      super(type.getBlockEntityType(), blockPos, blockState);
      this.type = type;
      this.setInvStackList(DefaultedList.ofSize(this.size(), ItemStack.EMPTY));
   }

   public static void clientTick(World world, BlockPos pos, BlockState state, JinericChestBlockEntity blockEntity) {
      blockEntity.lidAnimator.step();
   }

   @Override
   public float getAnimationProgress(float tickDelta) {
      return this.lidAnimator.getProgress(tickDelta);
   }

   static void playSound(World world, BlockPos pos, BlockState state, SoundEvent soundEvent) {
      ChestType chestType = state.get(ChestBlock.CHEST_TYPE);
      if (chestType != ChestType.LEFT) {
         double d = (double)pos.getX() + 0.5;
         double e = (double)pos.getY() + 0.5;
         double f = (double)pos.getZ() + 0.5;
         if (chestType == ChestType.RIGHT) {
            Direction direction = ChestBlock.getFacing(state);
            d += (double)direction.getOffsetX() * 0.5;
            f += (double)direction.getOffsetZ() * 0.5;
         }

         world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
      }
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

   @Override
   protected Text getContainerName() {
      return Text.translatable(getCachedState().getBlock().getTranslationKey());
   }

   @Override
   public int size() {
      return type.size;
   }

   public JinericChestType type() {
      return type;
   }
}
