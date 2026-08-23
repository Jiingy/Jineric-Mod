package net.jineric.jineric_mod.gui.screen.ingame;

import jingy.jineric.base.JinericMain;
import jingy.jineric.screen.CampfireScreenHandler;
import jingy.jineric.screen.slot.CampfireLogSlog;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CyclingSlotBackground;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

@Environment(EnvType.CLIENT)
public class CampfireScreen extends AbstractContainerScreen<CampfireScreenHandler> {
	private static final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/campfire.png");
	private final CyclingSlotBackground logSlotIcon0 = new CyclingSlotBackground(0);
	private final CyclingSlotBackground logSlotIcon1 = new CyclingSlotBackground(1);
	private final CyclingSlotBackground logSlotIcon2 = new CyclingSlotBackground(2);
	private final CyclingSlotBackground logSlotIcon3 = new CyclingSlotBackground(3);
	
	private static final Identifier EMPTY_SLOT_LOG_TEXTURE = JinericMain.ofJineric("container/slot/log");
	private static final Identifier EMPTY_SLOT_CHICKEN_TEXTURE = JinericMain.ofJineric("container/slot/chicken");
	private static final Identifier EMPTY_SLOT_CLAY_BALL_TEXTURE = JinericMain.ofJineric("container/slot/clay_ball");
	private static final Identifier EMPTY_SLOT_CLAY_BRICK_TEXTURE = JinericMain.ofJineric("container/slot/clay_brick");
	
	private static final Component COOKING_SLOT_TEXT = Component.translatable("container.jineric.campfire.cooking_slot_description");
	private static final Component TINDER_SLOT_TEXT = Component.translatable("container.jineric.campfire.tinder_slot_description");
	
	private static final List<Identifier> COOKING_SLOTS = List.of(
			EMPTY_SLOT_LOG_TEXTURE,
			EMPTY_SLOT_CHICKEN_TEXTURE,
			EMPTY_SLOT_CLAY_BRICK_TEXTURE
	);
	
	public CampfireScreen(CampfireScreenHandler handler, Inventory inventory, Component title) {
		super(handler, inventory, title);
	}
	
	@Override
	protected void containerTick() {
		super.containerTick();
		this.logSlotIcon0.tick(COOKING_SLOTS);
		this.logSlotIcon1.tick(COOKING_SLOTS);
		this.logSlotIcon2.tick(COOKING_SLOTS);
		this.logSlotIcon3.tick(COOKING_SLOTS);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
		super.extractBackground(graphics, mouseX, mouseY, a);
		int x = this.leftPos;
		int y = (this.height - this.imageHeight) / 2;
		graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
		this.logSlotIcon0.extractRenderState(this.menu, graphics, a, this.leftPos, this.topPos);
		this.logSlotIcon1.extractRenderState(this.menu, graphics, a, this.leftPos, this.topPos);
		this.logSlotIcon2.extractRenderState(this.menu, graphics, a, this.leftPos, this.topPos);
		this.logSlotIcon3.extractRenderState(this.menu, graphics, a, this.leftPos, this.topPos);
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
		super.extractRenderState(graphics, mouseX, mouseY, a);
		this.renderSlotTooltip(graphics, mouseX, mouseY);
	}

	private void renderSlotTooltip(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
		if (this.hoveredSlot != null) {
			if (!this.hoveredSlot.hasItem()) {
				if (this.hoveredSlot instanceof CampfireLogSlog) {
					graphics.setTooltipForNextFrame(this.font, this.font.split(COOKING_SLOT_TEXT, 115), mouseX, mouseY);
				} else if (this.hoveredSlot.getContainerSlot() == 4) {
					graphics.setTooltipForNextFrame(this.font, this.font.split(TINDER_SLOT_TEXT, 115), mouseX, mouseY);
				}
			} else {
				this.extractTooltip(graphics, mouseX, mouseY);
			}
		}
	}
}
