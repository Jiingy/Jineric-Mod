package jingy.jineric.block.entity;

import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.KilnScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {
	private static final Component DEFAULT_NAME = Component.translatable("container.jineric.kiln");
	
	public KilnBlockEntity(BlockPos pos, BlockState state) {
		super(JinericBlockEntityType.KILN, pos, state, JinericRecipeTypes.FIRING);
	}
	
	@Override
	protected Component getDefaultName() {
		return DEFAULT_NAME;
	}
	
	@Override
	protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
		return new KilnScreenHandler(syncId, playerInventory, this, this.dataAccess);
	}
}
