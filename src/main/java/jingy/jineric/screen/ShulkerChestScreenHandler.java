package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ShulkerChestScreenHandler extends ScreenHandler {
	private final Inventory inventory;

	public ShulkerChestScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, new SimpleInventory(81));
	}

	public ShulkerChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(JinericMain.SHULKER_CHEST_SCREEN_HANDLER, syncId);
		checkSize(inventory, 81);
		this.inventory = inventory;
		inventory.onOpen(playerInventory.player);

		//This will not render the background of the slots however, this is the Screens job
		int x;
		int y;

		//BlockEntity
		for (x = 0; x < 9; ++x) {
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

	public void close(PlayerEntity player) {
		super.close(player);
		this.inventory.onClose(player);
	}
}
