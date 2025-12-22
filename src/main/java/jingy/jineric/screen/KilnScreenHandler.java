package jingy.jineric.screen;

import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.recipe.book.JinericRecipeBookType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class KilnScreenHandler extends AbstractFurnaceScreenHandler {
	public KilnScreenHandler(int syncId, PlayerInventory playerInventory) {
		super(
				JinericScreenHandlerType.KILN, JinericRecipeTypes.KILN_FIRING,
				JinericRecipePropertySet.KILN_INPUT, JinericRecipeBookType.JINERIC_KILN,
				syncId, playerInventory
		);
	}
	
	public KilnScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
		super(
				JinericScreenHandlerType.KILN, JinericRecipeTypes.KILN_FIRING,
				JinericRecipePropertySet.KILN_INPUT, JinericRecipeBookType.JINERIC_KILN,
				syncId, playerInventory, inventory, propertyDelegate
		);
	}
	
	@Override
	public RecipeBookType getCategory() {
		return JinericRecipeBookType.JINERIC_KILN;
	}
}
