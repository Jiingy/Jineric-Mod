package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RefineryScreen extends AbstractFurnaceScreen<RefineryScreenHandler> {
   private static final Identifier TEXTURE = JinericMain.id("textures/gui/container/refinery.png");

   public RefineryScreen(RefineryScreenHandler handler, PlayerInventory inventory, Text title) {
      super(handler, new RefineryRecipeBookScreen(), inventory, title, TEXTURE);
   }

   @Override
   public void render(DrawContext context, int mouseX, int mouseY, float delta) {
      super.render(context, mouseX, mouseY, delta);
   }
}
