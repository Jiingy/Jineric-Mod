package jingy.jineric.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.SmokerRecipeBookScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RefineryScreen extends AbstractFurnaceScreen<RefineryScreenHandler> {
   private static final Identifier RECIPE_BUTTON_TEXTURE = new Identifier("textures/gui/recipe_button.png");
   private static final Identifier TEXTURE = new Identifier("jineric", "textures/gui/container/refinery.png");

   public RefineryScreen(RefineryScreenHandler handler, PlayerInventory inventory, Text title) {
      super(handler, new SmokerRecipeBookScreen(), inventory, title, TEXTURE);
   }

   @Override
   public void init() {
      super.init();
      boolean narrow = this.width < 379;
      this.recipeBook.initialize(this.width, this.height, this.client, narrow, this.handler);
      this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
      this.addDrawableChild(new TexturedButtonWidget(this.x + 20, this.height / 2 - 49, 20, 18, 0, 0, 19, RECIPE_BUTTON_TEXTURE, button -> {
         this.recipeBook.toggleOpen();
         this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
         ((TexturedButtonWidget)button).setPos(this.x + 20, this.height / 2 - 49);
      }));
      this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
   }
}
