package jingy.jineric.screen;

import jingy.jineric.base.Jineric;
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
	//public static ShulkerChestScreenHandler createGeneric9x9(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		//return new ShulkerChestScreenHandler(ScreenHandlerType.GENERIC_9X9, syncId, playerInventory, inventory, 3);
	//}

	public ShulkerChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(Jineric.SHULKER_CHEST_SCREEN_HANDLER, syncId);
		checkSize(inventory, 81);
		this.inventory = inventory;
		inventory.onOpen(playerInventory.player);

		//This will not render the background of the slots however, this is the Screens job
		int m;
		int l;
		//Player inventory
		for (m = 0; m < 3; ++m) {
			for (l = 0; l < 9; ++l) {
				this.addSlot(new Slot(inventory, l + m * 9, 8 + l * 18, 18 + m * 18));
			}
		}
		//The player inventory
		for (m = 0; m < 3; ++m) {
			for (l = 0; l < 9; ++l) {
				this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
			}
		}
		//The player Hotbar
		for (m = 0; m < 9; ++m) {
			this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
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
