package jingy.jineric.screenhandlers;

import jingy.jineric.Jineric;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;


public class ShulkerChestScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private static final int INVENTORY_SIZE = 54; // 6 rows * 9 cols

    public ShulkerChestScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(INVENTORY_SIZE));
    }

    public ShulkerChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(Jineric.SHULKER_CHEST_SCREEN_HANDLER, syncId);
        checkSize(inventory, 54);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        // Creating Slots for GUI. A Slot is essentially a corresponding from inventory ItemStacks to the GUI position.
        int m;
        int l;

        // Chest Inventory
        for (m = 0; m < 6; m++) {
            for (l = 0; l < 9; l++) {
                this.addSlot(new Slot(inventory, m * 9 + l, 8 + l * 18, 18 + m * 18));
            }
        }
        // Player Inventory (27 storage + 9 hotbar)
        for (m = 0; m < 3; m++) {
            for (l = 0; l < 9; l++) {
                this.addSlot(new Slot(playerInventory, m * 9 + l + 9, 8 + l * 18, 18 + m * 18 + 103 + 18));
            }
        }
        for (l = 0; l < 9; l++) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 18 + 161 + 18));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }
    public static void init() {
    }
}

