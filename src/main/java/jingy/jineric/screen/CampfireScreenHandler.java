package jingy.jineric.screen;

import jingy.jineric.item.JinericItems;
import jingy.jineric.screen.slot.CampfireLogSlog;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.level.Level;

public class CampfireScreenHandler extends AbstractContainerMenu implements ContainerListener {
	private final Player player;
	private final Container inventory;
	private final Level level;
	private final ContainerLevelAccess containerLevelAccess;
	private final ContainerData containerData;
	
	public CampfireScreenHandler(int syncId, Inventory inventory) {
		this(syncId, inventory, ContainerLevelAccess.NULL, new SimpleContainer(5), new SimpleContainerData(2));
	}
	
	public CampfireScreenHandler(int syncId, Inventory playerInventory, ContainerLevelAccess context, Container inventory, ContainerData containerData) {
		super(JinericScreenHandlerType.CAMPFIRE_SCREEN_HANDLER, syncId);
		checkContainerSize(inventory, 5);
		checkContainerDataCount(containerData, 2);
		this.inventory = inventory;
		this.containerData = containerData;
		this.player = playerInventory.player;
		this.level = player.level();
		this.containerLevelAccess = context;
		
		//  Tinder Slot
		for (int index = 0; index < 4; index++) {
			//  4 Firing Slots
			int logSlotIndex = index + 1;
			this.addSlot(
					new CampfireLogSlog(
							this, player, context, inventory, index,
							logSlotIndex == 1 || logSlotIndex == 4 ? 100 : 60, // X
							logSlotIndex == 1 || logSlotIndex == 2 ? 55 : 15 // Y
					)
			);
		}
		//  TINDER SLOT
		this.addSlot(new Slot(inventory, 4, 80, 35) {
			@Override
			public boolean mayPlace(ItemStack stack) {
				return stack.is(JinericItems.TINDER);
			}
		});
		//  PLAYER SLOTS
		this.addStandardInventorySlots(playerInventory, 8, 84);
	}
	
	public boolean isCampfireRecipeItem(ItemStack itemStack) {
		return this.level.recipeAccess().propertySet(RecipePropertySet.CAMPFIRE_INPUT).test(itemStack);
	}
	
	@Override
	public ItemStack quickMoveStack(Player player, int slotIndex) {
		ItemStack emptyStack = ItemStack.EMPTY;
		ItemStack movedSlotStack = emptyStack;
		Slot movingSlot = this.slots.get(slotIndex);
		if (movingSlot.hasItem()) {
			ItemStack movingSlotStack = movingSlot.getItem();
			movedSlotStack = movingSlotStack.copy();
			// Is one of the cooking slots
			int cookingIndexStart = 0;
			int cookingIndexEnd = 4;
			int playerIndexStart = 5;
			int inventoryIndexEnd = 31;
			int playerIndexEnd = 41;
			if (slotIndex >= 0 && slotIndex < cookingIndexEnd) {
				//  Try cooking slot to player inventory
				if (!this.moveItemStackTo(movingSlotStack, 5, playerIndexEnd, true)) {
					return emptyStack;
				}
			}
			//  Is player slot
			else if (slotIndex >= playerIndexStart) {
				//  Is cookable item
				if (this.isCampfireCookable(movingSlotStack)) {
					//  Try insert into a cooking slot
					if (!this.moveItemStackTo(movingSlotStack, cookingIndexStart, playerIndexStart, false)) {
						return emptyStack;
					}
				}
				//  Is inventory slot
				else if (slotIndex < inventoryIndexEnd) {
					//  Try insert to hotbar
					if (!this.moveItemStackTo(movingSlotStack, 32, playerIndexEnd, false)) {
						return emptyStack;
					}
				}
				//  Is hotbar slot
				else {
					//  Try insert to inventory
					if (!this.moveItemStackTo(movingSlotStack, playerIndexStart, inventoryIndexEnd, false)) {
						return emptyStack;
					}
				}
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
	
	@Override
	public boolean stillValid(Player player) {
		return this.inventory.stillValid(player);
	}
	
	private boolean isCampfireCookable(ItemStack checkedStack) {
		return this.level.recipeAccess().propertySet(RecipePropertySet.CAMPFIRE_INPUT).test(checkedStack);
	}
	
	@Override
	public MenuType<?> getType() {
		return JinericScreenHandlerType.CAMPFIRE_SCREEN_HANDLER;
	}
	
	@Override
	public void removed(Player player) {
		super.removed(player);
		this.inventory.stopOpen(player);
	}
	
	@Override
	public void slotChanged(AbstractContainerMenu abstractContainerMenu, int i, ItemStack itemStack) {
	
	}
	
	@Override
	public void dataChanged(AbstractContainerMenu abstractContainerMenu, int i, int j) {
	
	}
}
