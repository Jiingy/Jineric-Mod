package jingy.jineric.screen;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.util.math.MatrixStack;
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
   public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
      drawTextWithShadow(matrices, textRenderer, "Ignore all non-block recipes", x + 10, y - 10, 0xFFFFFF);
      super.render(matrices, mouseX, mouseY, delta);
   }
}
