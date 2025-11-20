package jingy.jineric.screen;

import jingy.jineric.item.JinericItems;
import jingy.jineric.screen.slot.CampfireLogSlog;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

public class CampfireScreenHandler extends ScreenHandler implements ScreenHandlerListener {
	private final PlayerEntity player;
	private final Inventory inventory;
	private final World world;
	private final ScreenHandlerContext context;
	private final PropertyDelegate propertyDelegate;
	
	public CampfireScreenHandler(int syncId, PlayerInventory inventory) {
		this(syncId, inventory, ScreenHandlerContext.EMPTY, new SimpleInventory(5), new ArrayPropertyDelegate(2));
	}
	
	public CampfireScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, Inventory inventory, PropertyDelegate propertyDelegate) {
		super(JinericScreenHandlerType.CAMPFIRE_SCREEN_HANDLER, syncId);
		checkSize(inventory, 5);
		checkDataCount(propertyDelegate, 2);
		this.inventory = inventory;
		this.propertyDelegate = propertyDelegate;
		this.player = playerInventory.player;
		this.world = player.getEntityWorld();
		this.context = context;
		
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
			public boolean canInsert(ItemStack stack) {
				return stack.isOf(JinericItems.TINDER);
			}
		});
		//  PLAYER SLOTS
		this.addPlayerSlots(playerInventory, 8, 84);
	}
	
	public boolean isCampfireRecipeItem(ItemStack itemStack) {
		return this.world.getRecipeManager().getPropertySet(RecipePropertySet.CAMPFIRE_INPUT).canUse(itemStack);
	}
	
	@Override
	public ItemStack quickMove(PlayerEntity player, int slotIndex) {
		ItemStack emptyStack = ItemStack.EMPTY;
		ItemStack movedSlotStack = emptyStack;
		Slot movingSlot = this.slots.get(slotIndex);
		if (movingSlot.hasStack()) {
			ItemStack movingSlotStack = movingSlot.getStack();
			movedSlotStack = movingSlotStack.copy();
			// Is one of the cooking slots
			int cookingIndexStart = 0;
			int cookingIndexEnd = 4;
			int playerIndexStart = 5;
			int inventoryIndexEnd = 31;
			int playerIndexEnd = 41;
			if (slotIndex >= 0 && slotIndex < cookingIndexEnd) {
				//  Try cooking slot to player inventory
				if (!this.insertItem(movingSlotStack, 5, playerIndexEnd, true)) {
					return emptyStack;
				}
			}
			//  Is player slot
			else if (slotIndex >= playerIndexStart) {
				//  Is cookable item
				if (this.isCampfireCookable(movingSlotStack)) {
					//  Try insert into a cooking slot
					if (!this.insertItem(movingSlotStack, cookingIndexStart, playerIndexStart, false)) {
						return emptyStack;
					}
				}
				//  Is inventory slot
				else if (slotIndex < inventoryIndexEnd) {
					//  Try insert to hotbar
					if (!this.insertItem(movingSlotStack, 32, playerIndexEnd, false)) {
						return emptyStack;
					}
				}
				//  Is hotbar slot
				else {
					//  Try insert to inventory
					if (!this.insertItem(movingSlotStack, playerIndexStart, inventoryIndexEnd, false)) {
						return emptyStack;
					}
				}
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
	
	private boolean isCampfireCookable(ItemStack checkedStack) {
		return this.world.getRecipeManager().getPropertySet(RecipePropertySet.CAMPFIRE_INPUT).canUse(checkedStack);
	}
	
	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}
	
	@Override
	public ScreenHandlerType<?> getType() {
		return JinericScreenHandlerType.CAMPFIRE_SCREEN_HANDLER;
	}
	
	@Override
	public void onClosed(PlayerEntity player) {
		super.onClosed(player);
		this.inventory.onClose(player);
	}
	
	@Override
	public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
	}
	
	@Override
	public void onPropertyUpdate(ScreenHandler handler, int property, int value) {
	}
}
