package jingy.jineric.block.entity;

import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.CrucibleScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CrucibleBlockEntity extends BaseContainerBlockEntity {
	private NonNullList<ItemStack> inventory = NonNullList.withSize(10, ItemStack.EMPTY);
	
	public CrucibleBlockEntity(BlockPos pos, BlockState state) {
		super(JinericBlockEntityType.CRUCIBLE, pos, state);
	}
	
	@Override
	protected Component getDefaultName() {
		return Component.translatable("container.crucible");
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.inventory;
	}
	
	@Override
	protected void setItems(NonNullList<ItemStack> inventory) {
		this.inventory = inventory;
	}
	
	@Override
	protected AbstractContainerMenu createMenu(int syncId, Inventory inventory) {
		return new CrucibleScreenHandler(syncId, inventory);
	}
	
	@Override
	public int getContainerSize() {
		return this.inventory.size();
	}
}
