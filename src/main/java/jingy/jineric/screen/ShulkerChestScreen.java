package jingy.jineric.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

//CHANGED HERE HandledScreen<ShulkerChestScreenHandler>
public class ShulkerChestScreen extends HandledScreen<ShulkerChestScreenHandler>  {
	private static final Identifier TEXTURE = new Identifier("jineric", "textures/gui/container/shulker_chest_gui.png");
//	private final int rows;

	public ShulkerChestScreen(ShulkerChestScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
		this.passEvents = false;
		this.backgroundWidth = 176;
		this.backgroundHeight = 276;
		this.playerInventoryTitleY = 182;
//		this.rows = handler.getRows();

	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);
		this.drawMouseoverTooltip(matrices, mouseX, mouseY);
	}

	@Override
	protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - backgroundWidth) / 2;
		int y = (height - backgroundHeight) / 2;
		drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight, 256, 320);
	}
}
