package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.client.gui.screen.recipebook.AbstractFurnaceRecipeBookScreen;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class RefineryRecipeBookScreen extends AbstractFurnaceRecipeBookScreen {
   protected static final Identifier REFINERY_TEXTURE = JinericMain.id("textures/gui/container/refinery_recipe_book.png");
   private static final Text TOGGLE_REFINABLE_RECIPES_TEXT = Text.translatable("gui.recipebook.toggleRecipes.refinable");

   @Override
   protected Text getToggleCraftableButtonText() {
      return TOGGLE_REFINABLE_RECIPES_TEXT;
   }

   protected void setBookButtonTexture() {
      this.toggleCraftableButton.setTextureUV(152, 182, 28, 18, REFINERY_TEXTURE);
   }

   @Override
   protected Set<Item> getAllowedFuels() {
      return AbstractFurnaceBlockEntity.createFuelTimeMap().keySet();
   }
}
