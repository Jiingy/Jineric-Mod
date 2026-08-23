package jingy.jineric.screen;

import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.book.JinericRecipeBookType;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;

public class KilnScreenHandler extends AbstractFurnaceMenu {
	public KilnScreenHandler(int syncId, Inventory playerInventory) {
		super(
				JinericScreenHandlerType.KILN,
                JinericRecipePropertySet.KILN_INPUT,
				JinericRecipeBookType.JINERIC_KILN,
				syncId, playerInventory
		);
	}
	
	public KilnScreenHandler(int syncId, Inventory playerInventory, Container inventory, ContainerData propertyDelegate) {
		super(
				JinericScreenHandlerType.KILN,
				JinericRecipePropertySet.KILN_INPUT,
				JinericRecipeBookType.JINERIC_KILN,
				syncId, playerInventory, inventory, propertyDelegate
		);
	}
}
