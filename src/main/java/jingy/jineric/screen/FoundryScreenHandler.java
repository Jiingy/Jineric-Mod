package jingy.jineric.screen;

import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.recipe.book.JinericRecipeBookType;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class FoundryScreenHandler extends AbstractFurnaceMenu {
	
	public FoundryScreenHandler(int syncId, Inventory playerInventory) {
		super(
				JinericScreenHandlerType.FOUNDRY, JinericRecipeTypes.FOUNDRY_SMELTING,
				JinericRecipePropertySet.FOUNDRY_INPUT, JinericRecipeBookType.JINERIC_FOUNDRY,
				syncId, playerInventory
		);
	}
	
	public FoundryScreenHandler(int syncId, Inventory playerInventory, Container inventory, ContainerData propertyDelegate) {
		super(
				JinericScreenHandlerType.FOUNDRY, JinericRecipeTypes.FOUNDRY_SMELTING,
				JinericRecipePropertySet.FOUNDRY_INPUT, JinericRecipeBookType.JINERIC_FOUNDRY,
				syncId, playerInventory, inventory, propertyDelegate
		);
	}
	
	@Override
	public ItemStack quickMoveStack(Player player, int slotIndex) {
		ItemStack emptyStack = ItemStack.EMPTY;
		ItemStack movedSlotStack = emptyStack;
		Slot movingSlot = this.slots.get(slotIndex);
		if (movingSlot.hasItem()) {
			ItemStack movingSlotStack = movingSlot.getItem();
			movedSlotStack = movingSlotStack.copy();
			if (slotIndex == 2) { // Is output slot
				//  Try output slot to player inventory
				if (!this.moveItemStackTo(movingSlotStack, 3, 39, true)) {
					return emptyStack;
				}
				movingSlot.onQuickCraft(movingSlotStack, movedSlotStack);
			}
			//  Is player slot (inventory + hotbar)
			else if (slotIndex != 0 && slotIndex != 1) {
				if (this.isFoundrySmeltable(movingSlotStack)) {
					//  Try insert to input slot
					if (!this.moveItemStackTo(movingSlotStack, 0, 1, false)) {
						return emptyStack;
					}
				}
				else if (movingSlotStack.is(Items.CHARCOAL)) {
					//  Try insert to fuel slot
					if (!this.moveItemStackTo(movingSlotStack, 1, 2, false)) {
						return emptyStack;
					}
				}
				//  Is inventory slot
				else if (slotIndex >= 3 && slotIndex < 30) {
					//  Try insert to hotbar
					if (!this.moveItemStackTo(movingSlotStack, 30, 39, false)) {
						return emptyStack;
					}
				}
				//  Is hotbar slot
				else if (slotIndex >= 30 && slotIndex < 39) {
					//  Try insert to inventory
					if (!this.moveItemStackTo(movingSlotStack, 3, 30, false)) {
						return emptyStack;
					}
				}
			} else if (!this.moveItemStackTo(movingSlotStack, 3, 39, false)) {
				return ItemStack.EMPTY;
			}
			
			//  If movingSlotStack has nothing in it on shift-click, do nothing
			//  Otherwise, mark the inventory as dirty (changed) due to slot changing
			if (movingSlotStack.isEmpty()) {
				movingSlot.setByPlayer(emptyStack);
			} else {
				movingSlot.setChanged();
			}
			
			if (movingSlotStack.getCount() == movedSlotStack.getCount()) {
				return emptyStack;
			}
			movingSlot.onTake(player, movingSlotStack);
		}
		return movedSlotStack;
	}
	
	private boolean isFoundrySmeltable(ItemStack checkedStack) {
		return this.level.recipeAccess().propertySet(JinericRecipePropertySet.FOUNDRY_INPUT).test(checkedStack);
	}
}
