package jingy.jineric.block.entity;

import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.CrucibleScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class CrucibleBlockEntity extends LockableContainerBlockEntity {
	private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);
	
	public CrucibleBlockEntity(BlockPos pos, BlockState state) {
		super(JinericBlockEntityType.CRUCIBLE, pos, state);
	}
	
	@Override
	protected Text getContainerName() {
		return Text.translatable("container.crucible");
	}
	
	@Override
	protected DefaultedList<ItemStack> getHeldStacks() {
		return this.inventory;
	}
	
	@Override
	protected void setHeldStacks(DefaultedList<ItemStack> inventory) {
		this.inventory = inventory;
	}
	
	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new CrucibleScreenHandler(syncId, playerInventory);
	}
	
	@Override
	public int size() {
		return this.inventory.size();
	}
}
