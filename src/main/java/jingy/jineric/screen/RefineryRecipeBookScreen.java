package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.item.Item;
import net.minecraft.text.Text;

import java.util.Set;

//TODO: MAYBE USELESS IN 1.21.3
@Environment(EnvType.CLIENT)
public class RefineryRecipeBookScreen {
   private static final ButtonTextures REFINERY_TEXTURES = new ButtonTextures(
           JinericMain.ofJineric("recipe_book/refinery_filter_enabled"),
           JinericMain.ofJineric("recipe_book/refinery_filter_disabled"),
           JinericMain.ofJineric("recipe_book/refinery_filter_enabled_highlighted"),
           JinericMain.ofJineric("recipe_book/refinery_filter_disabled_highlighted")
   );
//   private static final Text TOGGLE_REFINABLE_RECIPES_TEXT = Text.translatable("gui.recipebook.toggleRecipes.refinable");

//   @Override
//   protected Text getToggleCraftableButtonText() {
//      return TOGGLE_REFINABLE_RECIPES_TEXT;
//   }
//
//   protected void setBookButtonTexture() {
//      this.toggleCraftableButton.setTextures(REFINERY_TEXTURES);
//   }
//
//   @Override
//   protected Set<Item> getAllowedFuels() {
//      return AbstractFurnaceBlockEntity.createFuelTimeMap().keySet();
//   }
}
