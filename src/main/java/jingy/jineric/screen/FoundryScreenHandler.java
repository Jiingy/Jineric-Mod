package jingy.jineric.screen;

import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class FoundryScreenHandler extends AbstractFurnaceScreenHandler {
	public FoundryScreenHandler(int syncId, PlayerInventory playerInventory) {
		super(JinericScreenHandlerType.FOUNDRY, JinericRecipeTypes.FOUNDRY_SMELTING, JinericRecipePropertySet.FOUNDRY_INPUT, RecipeBookType.BLAST_FURNACE, syncId, playerInventory);
	}
	
	public FoundryScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
		super(
				JinericScreenHandlerType.FOUNDRY, JinericRecipeTypes.FOUNDRY_SMELTING,
				JinericRecipePropertySet.FOUNDRY_INPUT, RecipeBookType.BLAST_FURNACE,
				syncId, playerInventory, inventory, propertyDelegate
		);
	}
	
	@Override
	public ItemStack quickMove(PlayerEntity player, int slotIndex) {
		ItemStack emptyStack = ItemStack.EMPTY;
		ItemStack movedSlotStack = emptyStack;
		Slot movingSlot = this.slots.get(slotIndex);
		if (movingSlot.hasStack()) {
			ItemStack movingSlotStack = movingSlot.getStack();
			movedSlotStack = movingSlotStack.copy();
			if (slotIndex == 2) { // Is output slot
				//  Try output slot to player inventory
				if (!this.insertItem(movingSlotStack, 3, 39, true)) {
					return emptyStack;
				}
				movingSlot.onQuickTransfer(movingSlotStack, movedSlotStack);
			}
			//  Is player slot (inventory + hotbar)
			else if (slotIndex != 0 && slotIndex != 1) {
				if (movingSlotStack.isOf(Items.RAW_COPPER)) {
					//  Try insert to input slot
					if (!this.insertItem(movingSlotStack, 0, 1, false)) {
						return emptyStack;
					}
				}
				else if (movingSlotStack.isOf(Items.CHARCOAL)) {
					//  Try insert to fuel slot
					if (!this.insertItem(movingSlotStack, 1, 2, false)) {
						return emptyStack;
					}
				}
				//  Is inventory slot
				else if (slotIndex >= 3 && slotIndex < 30) {
					//  Try insert to hotbar
					if (!this.insertItem(movingSlotStack, 30, 39, false)) {
						return emptyStack;
					}
				}
				//  Is hotbar slot
				else if (slotIndex >= 30 && slotIndex < 39) {
					//  Try insert to inventory
					if (!this.insertItem(movingSlotStack, 3, 30, false)) {
						return emptyStack;
					}
				}
			} else if (!this.insertItem(movingSlotStack, 3, 39, false)) {
				return ItemStack.EMPTY;
			}
			
			//  If movingSlotStack has nothing in it on shift-click, do nothing
			//  Otherwise, mark the inventory as dirty (changed) due to slot changing
			if (movingSlotStack.isEmpty()) {
				movingSlot.setStack(emptyStack);
			} else {
				movingSlot.markDirty();
			}
			
			if (movingSlotStack.getCount() == movedSlotStack.getCount()) {
				return emptyStack;
			}
			movingSlot.onTakeItem(player, movingSlotStack);
		}
		return movedSlotStack;
	}
}
