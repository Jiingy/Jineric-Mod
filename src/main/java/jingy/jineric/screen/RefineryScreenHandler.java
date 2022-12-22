package jingy.jineric.screen;

import jingy.jineric.recipe.JinericRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class RefineryScreenHandler extends AbstractFurnaceScreenHandler {

   public RefineryScreenHandler(int syncId, PlayerInventory playerInventory) {
      super(JinericScreenHandlerType.REFINERY, JinericRecipeType.REFINING, RecipeBookCategory.FURNACE, syncId, playerInventory);
   }

   public RefineryScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
      super(JinericScreenHandlerType.REFINERY, JinericRecipeType.REFINING, RecipeBookCategory.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
   }
}
