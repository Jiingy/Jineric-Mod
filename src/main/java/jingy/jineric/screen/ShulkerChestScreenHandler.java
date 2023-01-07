package jingy.jineric.screen;

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
		super(JinericScreenHandlerType.SHULKER_CHEST, syncId);
		checkSize(inventory, 81);
		this.inventory = inventory;
		this.inventory.onOpen(playerInventory.player);

		int x;
		int y;

		//BlockEntity
		for (x = 0; x < 9; ++x) {
			for (y = 0; y < 9; ++y) {
				this.addSlot(new Slot(this.inventory, y + x * 9, 8 + y * 18, 18 + x * 18));
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
	@Override
	public ItemStack quickMove(PlayerEntity player, int slot) {
		return null;
	}

	public Inventory getInventory() {
		return this.inventory;
	}
}
