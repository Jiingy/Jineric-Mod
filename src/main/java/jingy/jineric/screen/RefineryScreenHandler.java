package jingy.jineric.screen;

import jingy.jineric.recipe.book.JinericRecipeBookType;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;

public class RefineryScreenHandler extends AbstractFurnaceMenu {
	public RefineryScreenHandler(int syncId, Inventory playerInventory) {
		super(JinericScreenHandlerType.REFINERY, JinericRecipeTypes.REFINING, JinericRecipePropertySet.REFINERY_INPUT,
//  Broken in 1.21.7 - Hopefully shouldn't break anything...
//				JinericRecipeBookType.JINERIC_REFINERY,
				RecipeBookType.FURNACE,
				syncId, playerInventory);
	}
	
	public RefineryScreenHandler(int syncId, Inventory playerInventory, Container inventory, ContainerData propertyDelegate) {
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
