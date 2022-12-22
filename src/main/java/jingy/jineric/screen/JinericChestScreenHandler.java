package jingy.jineric.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class JinericChestScreenHandler extends ScreenHandler {

   private final Inventory inventory;
   private final int rows;



   public JinericChestScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory, int rows) {
      super(type, syncId);
      checkSize(inventory, rows * 9);
      this.inventory = inventory;
      this.rows = rows;
      inventory.onOpen(playerInventory.player);

      int width;
      int height;

      //BlockEntity
      for (width = 0; width < this.rows; ++width) {
         for (height = 0; height < 9; ++height) {
            this.addSlot(new Slot(inventory, height + width * 9, 8 + height * 18, 18 + width * 18));
         }
      }
      //The player inventory
      for (width = 0; width < 3; ++width) {
         for (height = 0; height < 9; ++height) {
            this.addSlot(new Slot(playerInventory, height + width * 9 + 9, 8 + height * 18, 194 + width * 18));
         }
      }
      //The player Hotbar
      for (width = 0; width < 9; ++width) {
         this.addSlot(new Slot(playerInventory, width, 8 + width * 18, 252));
      }
   }

   @Override
   public ItemStack quickMove(PlayerEntity player, int slot) {
      return null;
   }

   @Override
   public boolean canUse(PlayerEntity player) {
      return this.inventory.canPlayerUse(player);
   }

   public Inventory getInventory() {
      return this.inventory;
   }
}
