package jingy.jineric.screen;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.JinericRecipeTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class RefineryScreenHandler extends AbstractFurnaceScreenHandler {
   private static final RecipeBookCategory REFINERY_CATEGORY = ClassTinkerers.getEnum(RecipeBookCategory.class, "JINERIC_REFINERY");

   public RefineryScreenHandler(int syncId, PlayerInventory playerInventory) {
      super(JinericScreenHandlerType.REFINERY, JinericRecipeTypes.REFINING, REFINERY_CATEGORY, syncId, playerInventory);
   }

   public RefineryScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
      super(JinericScreenHandlerType.REFINERY, JinericRecipeTypes.REFINING, REFINERY_CATEGORY, syncId, playerInventory, inventory, propertyDelegate);
   }
}
