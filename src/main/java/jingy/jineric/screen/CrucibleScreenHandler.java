package jingy.jineric.screen;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.screen.AbstractCraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

import java.util.List;

public class CrucibleScreenHandler extends AbstractCraftingScreenHandler {
	private final ScreenHandlerContext context;
	
	private final Slot outputSlot;
	private final PlayerEntity player;
	
	private final Inventory inputs = new SimpleInventory(9) {
		@Override
		public void markDirty() {
			super.markDirty();
			CrucibleScreenHandler.this.onContentChanged(this);
		}
	};
	
	private final Inventory output = new SimpleInventory(1) {
		@Override
		public void markDirty() {
			super.markDirty();
		}
	};
	
	public CrucibleScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
	}
	
	public CrucibleScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
		super(JinericScreenHandlerType.CRUCIBLE_SCREEN_HANDLER, syncId, 3, 3);
		this.context = context;
		this.player = playerInventory.player;
		
		
		
		this.outputSlot = this.addSlot(new Slot(this.output, 0, 114, 33) {
			@Override
			public boolean canInsert(ItemStack stack) {
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
	
	private void addPlayerInventorySlots(PlayerInventory playerInventory) {
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
	public ItemStack quickMove(PlayerEntity player, int slot) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slotIndex = this.slots.get(slot);
		if (slotIndex.hasStack()) {
			ItemStack itemStackFromSlotIndex = slotIndex.getStack();
			itemStack = itemStackFromSlotIndex.copy();
		}
		return itemStack;
	}
	
	@Override
	public void onClosed(PlayerEntity player) {
		super.onClosed(player);
		this.context.run((world, pos) -> this.dropInventory(player, this.inputs));
	}
	
	public Slot getOutputSlot() {
		return outputSlot;
	}
	
	@Override
	public boolean canUse(PlayerEntity player) {
		return canUse(this.context, player, JinericBlocks.STONE_CRUCIBLE);
	}
	
	@Override
	public List<Slot> getInputSlots() {
		return this.slots.subList(1, 10);
	}
	
	@Override
	protected PlayerEntity getPlayer() {
		return this.player;
	}
	
	@Override
	public RecipeBookType getCategory() {
		return null;
	}
}
