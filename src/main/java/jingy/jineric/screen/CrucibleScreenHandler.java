package jingy.jineric.screen;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractCraftingMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CrucibleScreenHandler extends AbstractCraftingMenu {
	private final ContainerLevelAccess containerLevelAccess;
	private final Slot outputSlot;
	private final Player player;
	
	private final Container inputs = new SimpleContainer(9) {
		@Override
		public void setChanged() {
			super.setChanged();
			CrucibleScreenHandler.this.slotsChanged(this);
		}
	};
	
	private final Container output = new SimpleContainer(1) {
		@Override
		public void setChanged() {
			super.setChanged();
		}
	};
	
	public CrucibleScreenHandler(int syncId, Inventory playerInventory) {
		this(syncId, playerInventory, ContainerLevelAccess.NULL);
	}
	
	public CrucibleScreenHandler(int syncId, Inventory playerInventory, ContainerLevelAccess containerLevelAccess) {
		super(JinericScreenHandlerType.CRUCIBLE_SCREEN_HANDLER, syncId, 3, 3);
		this.containerLevelAccess = containerLevelAccess;
		this.player = playerInventory.player;
		
		
		
		this.outputSlot = this.addSlot(new Slot(this.output, 0, 114, 33) {
			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		});
		
		this.addPlayerInventorySlots(playerInventory);
	}
	
	protected void addInputSlots(int x, int y) {
		for (int width = 0; width < 3; width++) {
			for (int height = 0; height < 3; height++) {
//				this.addSlot(new Slot(this.craftingInventory, height + width * 3, x + height * 18, y + width * 18));
			}
		}
	}
	
	private void addPlayerInventorySlots(Inventory playerInventory) {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public ItemStack quickMoveStack(Player player, int slot) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slotIndex = this.slots.get(slot);
		if (slotIndex.hasItem()) {
			ItemStack itemStackFromSlotIndex = slotIndex.getItem();
			itemStack = itemStackFromSlotIndex.copy();
		}
		return itemStack;
	}
	
	@Override
	public void removed(Player player) {
		super.removed(player);
		this.containerLevelAccess.execute((world, pos) -> this.clearContainer(player, this.inputs));
	}
	
	@Override
	public Slot getResultSlot() {
		return outputSlot;
	}
	
	@Override
	public List<Slot> getInputGridSlots() {
		return this.slots.subList(1, 10);
	}
	
	@Override
	protected Player owner() {
		return this.player;
	}
	
	@Override
	public RecipeBookType getRecipeBookType() {
		return null;
	}
	
	@Override
	public boolean stillValid(Player player) {
		return stillValid(this.containerLevelAccess, player, JinericBlocks.STONE_CRUCIBLE);
	}
}
