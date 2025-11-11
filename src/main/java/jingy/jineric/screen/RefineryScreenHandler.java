package jingy.jineric.screen;

import jingy.jineric.recipe.JinericRecipeBookTypes;
import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class RefineryScreenHandler extends AbstractFurnaceScreenHandler {
	public RefineryScreenHandler(int syncId, PlayerInventory playerInventory) {
		super(JinericScreenHandlerType.REFINERY, JinericRecipeTypes.REFINING, JinericRecipePropertySet.REFINERY_INPUT,
//  Broken in 1.21.7 - Hopefully shouldn't break anything...
//				JinericRecipeBookTypes.JINERIC_REFINERY,
				RecipeBookType.FURNACE,
				syncId, playerInventory);
	}
	
	public RefineryScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
		super(JinericScreenHandlerType.REFINERY,
				JinericRecipeTypes.REFINING,
				JinericRecipePropertySet.REFINERY_INPUT,
				JinericRecipeBookTypes.JINERIC_REFINERY,
				syncId,
				playerInventory,
				inventory,
				propertyDelegate
		);
	}
}
