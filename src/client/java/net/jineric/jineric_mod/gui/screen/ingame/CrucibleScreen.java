package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.screen.CrucibleScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CrucibleScreen extends HandledScreen<CrucibleScreenHandler> {
	private final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/crucible.png");
	
	public CrucibleScreen(CrucibleScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}
	
	@Override
	protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
		int x = this.x;
		int y = (this.height - this.backgroundHeight) / 2;
		context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, 256, 256);
	}
	
}
