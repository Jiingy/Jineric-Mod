package jingy.jineric.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class JinericChestScreenHandler extends ScreenHandler {

   private final Inventory inventory;
   private final int rows;

   public JinericChestScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, int rows) {
      this(type, syncId, playerInventory, new SimpleInventory(9 * rows), rows);
   }

   public static JinericChestScreenHandler createGeneric9x9(int syncId, PlayerInventory playerInventory) {
      return new JinericChestScreenHandler(JinericScreenHandlerType.SHULKER_CHEST, syncId, playerInventory, 3);
   }

   public static JinericChestScreenHandler createGeneric9x9(int syncId, PlayerInventory playerInventory, Inventory inventory) {
      return new JinericChestScreenHandler(JinericScreenHandlerType.SHULKER_CHEST, syncId, playerInventory, inventory, 9);
   }

   public JinericChestScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory, int rows) {
      super(type, syncId);
      checkSize(inventory, rows * 9);
      this.inventory = inventory;
      this.rows = rows;
      inventory.onOpen(playerInventory.player);
      int z = (this.rows - 4) * 18;

      //This will not render the background of the slots however, this is the Screens job
      int x;
      int y;

      //BlockEntity
      for (x = 0; x < this.rows; ++x) {
         for (y = 0; y < 9; ++y) {
            this.addSlot(new Slot(inventory, y + x * 9, 8 + y * 18, 18 + x * 18));
         }
      }
      //The player inventory
      for (x = 0; x < 3; ++x) {
         for (y = 0; y < 9; ++y) {
            this.addSlot(new Slot(playerInventory, y + x * 9 + 9, 8 + y * 18, 194 + x * 18));
         }
      }
      //The player Hotbar
      for (x = 0; x < 9; ++x) {
         this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 252));
      }
   }

   @Override
   public ItemStack transferSlot(PlayerEntity player, int index) {
      ItemStack itemStack = ItemStack.EMPTY;
      return itemStack;
   }

   @Override
   public boolean canUse(PlayerEntity player) {
      return this.inventory.canPlayerUse(player);
   }

   public Inventory getInventory() {
      return this.inventory;
   }

   public int getRows() {
      return this.rows;
   }
}
