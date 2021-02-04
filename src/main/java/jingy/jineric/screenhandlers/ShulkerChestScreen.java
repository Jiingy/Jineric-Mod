package jingy.jineric.screenhandlers;

import com.mojang.blaze3d.systems.RenderSystem;
import jingy.jineric.Jineric;
import jingy.jineric.screenhandlers.ShulkerChestScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ShulkerChestScreen extends HandledScreen<ShulkerChestScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(Jineric.MOD_ID, "textures/gui/container/generic_54.png");

    public ShulkerChestScreen(ShulkerChestScreenHandler handler, PlayerInventory playerInventory, Text title) {
        super(handler, playerInventory, title);
        this.backgroundHeight = 114 + 6 * 18;
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        this.textRenderer.draw(matrices, this.title.asString(), 8.0F, 6.0F, 4210752);
        this.textRenderer.draw(matrices, this.playerInventory.getDisplayName().asString(), 8.0F, (float)(this.backgroundHeight - 96 + 2), 4210752);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {

    }

    protected void drawBackground(float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.client.getTextureManager().bindTexture(TEXTURE);
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        this.blit(i, j, 0, 0, this.backgroundWidth, 6 * 18 + 17);
        this.blit(i, j + 6 * 18 + 17, 0, 126, this.backgroundWidth, 96);
    }

    private void blit(int i, int j, int i1, int i2, int backgroundWidth, int i3) {
    }
}