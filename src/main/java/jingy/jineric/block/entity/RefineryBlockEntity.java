package jingy.jineric.block.entity;

import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.RefineryScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;

public class RefineryBlockEntity extends AbstractFurnaceBlockEntity {
	private static final Component DEFAULT_NAME = Component.translatable("container.refinery");
	
	public RefineryBlockEntity(BlockPos blockPos, BlockState state) {
		super(JinericBlockEntityType.REFINERY, blockPos, state, JinericRecipeTypes.REFINING);
	}
	
	@Override
	protected Component getDefaultName() {
		return DEFAULT_NAME;
	}
	
	@Override
	public int getBurnDuration(FuelValues fuel, ItemStack stack) {
		return super.getBurnDuration(fuel, stack) / 2;
	}
	
	@Override
	protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
		return new RefineryScreenHandler(syncId, playerInventory, this, this.dataAccess);
	}
}
