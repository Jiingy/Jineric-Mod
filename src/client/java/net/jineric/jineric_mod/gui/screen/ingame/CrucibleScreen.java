package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.screen.CrucibleScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

@Environment(EnvType.CLIENT)
public class CrucibleScreen extends AbstractContainerScreen<CrucibleScreenHandler> {
	private final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/crucible.png");
	
	public CrucibleScreen(CrucibleScreenHandler handler, Inventory inventory, Component title) {
		super(handler, inventory, title);
	}
	
	@Override
	protected void renderBg(GuiGraphics context, float deltaTicks, int mouseX, int mouseY) {
		int x = this.leftPos;
		int y = (this.height - this.imageHeight) / 2;
		context.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
	}
	
}
