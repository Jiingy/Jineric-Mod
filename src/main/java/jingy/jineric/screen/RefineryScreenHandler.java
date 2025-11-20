package jingy.jineric.screen;

import jingy.jineric.recipe.book.JinericRecipeBookType;
import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class RefineryScreenHandler extends AbstractFurnaceScreenHandler {
	public RefineryScreenHandler(int syncId, PlayerInventory playerInventory) {
		super(
				JinericScreenHandlerType.REFINERY, JinericRecipeTypes.REFINING,
				JinericRecipePropertySet.REFINERY_INPUT, JinericRecipeBookType.JINERIC_REFINERY,
				syncId, playerInventory
		);
	}
	
	public RefineryScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
		super(JinericScreenHandlerType.REFINERY,
				JinericRecipeTypes.REFINING,
				JinericRecipePropertySet.REFINERY_INPUT,
				JinericRecipeBookType.JINERIC_REFINERY,
				syncId,
				playerInventory,
				inventory,
				propertyDelegate
		);
	}
}
