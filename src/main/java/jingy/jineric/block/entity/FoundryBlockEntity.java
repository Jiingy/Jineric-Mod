package jingy.jineric.block.entity;

import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.FoundryScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class FoundryBlockEntity extends AbstractFurnaceBlockEntity {
	private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
	
	public FoundryBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(JinericBlockEntityType.FOUNDRY, blockPos, blockState, JinericRecipeTypes.FOUNDRY_SMELTING);
	}
	
	@Override
	protected Text getContainerName() {
		return Text.of("container.foundry");
	}
	
	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new FoundryScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
}
