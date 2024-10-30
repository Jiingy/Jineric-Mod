package jingy.jineric.screen;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.JinericRecipeBookCategories;
import jingy.jineric.recipe.JinericRecipeBookType;
import jingy.jineric.recipe.JinericRecipePropertySet;
import jingy.jineric.recipe.JinericRecipeTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class RefineryScreenHandler extends AbstractFurnaceScreenHandler {
   private static final RecipeBookType JINERIC_REFINERY = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_REFINERY");

   public RefineryScreenHandler(int syncId, PlayerInventory playerInventory) {
      super(
              JinericScreenHandlerType.REFINERY,
              JinericRecipeTypes.REFINING,
              JinericRecipePropertySet.REFINERY_INPUT,
              JINERIC_REFINERY,
              syncId,
              playerInventory
      );
   }

   public RefineryScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
      super(
              JinericScreenHandlerType.REFINERY,
              JinericRecipeTypes.REFINING,
              JinericRecipePropertySet.REFINERY_INPUT,
              JINERIC_REFINERY,
              syncId,
              playerInventory,
              inventory,
              propertyDelegate);
   }
}
