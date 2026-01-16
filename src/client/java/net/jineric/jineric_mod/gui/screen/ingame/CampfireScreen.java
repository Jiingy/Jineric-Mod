package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.screen.CampfireScreenHandler;
import jingy.jineric.screen.slot.CampfireLogSlog;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.CyclingSlotIcon;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class CampfireScreen extends HandledScreen<CampfireScreenHandler> {
	private static final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/campfire.png");
	private final CyclingSlotIcon logSlotIcon0 = new CyclingSlotIcon(0);
	private final CyclingSlotIcon logSlotIcon1 = new CyclingSlotIcon(1);
	private final CyclingSlotIcon logSlotIcon2 = new CyclingSlotIcon(2);
	private final CyclingSlotIcon logSlotIcon3 = new CyclingSlotIcon(3);
	
	private static final Identifier EMPTY_SLOT_LOG_TEXTURE = JinericMain.ofJineric("container/slot/log");
	private static final Identifier EMPTY_SLOT_CHICKEN_TEXTURE = JinericMain.ofJineric("container/slot/chicken");
	private static final Identifier EMPTY_SLOT_CLAY_BALL_TEXTURE = JinericMain.ofJineric("container/slot/clay_ball");
	private static final Identifier EMPTY_SLOT_CLAY_BRICK_TEXTURE = JinericMain.ofJineric("container/slot/clay_brick");
	
	private static final Text COOKING_SLOT_TEXT = Text.translatable("container.jineric.campfire.cooking_slot_description");
	private static final Text TINDER_SLOT_TEXT = Text.translatable("container.jineric.campfire.tinder_slot_description");
	
	private static final List<Identifier> COOKING_SLOTS = List.of(
			EMPTY_SLOT_LOG_TEXTURE,
			EMPTY_SLOT_CHICKEN_TEXTURE,
			EMPTY_SLOT_CLAY_BRICK_TEXTURE
	);
	
	public CampfireScreen(CampfireScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}
	
	@Override
	protected void handledScreenTick() {
		super.handledScreenTick();
		this.logSlotIcon0.updateTexture(COOKING_SLOTS);
		this.logSlotIcon1.updateTexture(COOKING_SLOTS);
		this.logSlotIcon2.updateTexture(COOKING_SLOTS);
		this.logSlotIcon3.updateTexture(COOKING_SLOTS);
	}
	
	@Override
	protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
		int x = this.x;
		int y = (this.height - this.backgroundHeight) / 2;
		context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, 256, 256);
		this.logSlotIcon0.render(this.handler, context, deltaTicks, this.x, this.y);
		this.logSlotIcon1.render(this.handler, context, deltaTicks, this.x, this.y);
		this.logSlotIcon2.render(this.handler, context, deltaTicks, this.x, this.y);
		this.logSlotIcon3.render(this.handler, context, deltaTicks, this.x, this.y);
	}
	
	@Override
	public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
		super.render(context, mouseX, mouseY, deltaTicks);
		this.renderSlotTooltip(context, mouseX, mouseY);
//		this.drawMouseoverTooltip(context, mouseX, mouseY);
	}
	
	private void renderSlotTooltip(DrawContext context, int mouseX, int mouseY) {
		if (this.focusedSlot != null) {
			if (!this.focusedSlot.hasStack()) {
				if (this.focusedSlot instanceof CampfireLogSlog) {
					context.drawOrderedTooltip(this.textRenderer, this.textRenderer.wrapLines(COOKING_SLOT_TEXT, 115), mouseX, mouseY);
				} else if (this.focusedSlot.getIndex() == 4) {
					context.drawOrderedTooltip(this.textRenderer, this.textRenderer.wrapLines(TINDER_SLOT_TEXT, 115), mouseX, mouseY);
				}
			} else {
				this.drawMouseoverTooltip(context, mouseX, mouseY);
			}
		}
	}
}
