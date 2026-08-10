package net.jineric.jineric_mod.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.renderer.special.JmChestSpecialRenderer;
import net.minecraft.client.renderer.MultiblockChestResources;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.sprite.SpriteId;

@Environment(EnvType.CLIENT)
public class JmSheets extends Sheets {
	public static final MultiblockChestResources<SpriteId> CHEST_SPRUCE = JmChestSpecialRenderer.SPRUCE.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_BIRCH = JmChestSpecialRenderer.BIRCH.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_JUNGLE = JmChestSpecialRenderer.JUNGLE.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_ACACIA = JmChestSpecialRenderer.ACACIA.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_DARK_OAK = JmChestSpecialRenderer.DARK_OAK.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_MANGROVE = JmChestSpecialRenderer.MANGROVE.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_CHERRY = JmChestSpecialRenderer.CHERRY.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_PALE_OAK = JmChestSpecialRenderer.PALE_OAK.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_POPLAR = JmChestSpecialRenderer.POPLAR.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_BAMBOO = JmChestSpecialRenderer.BAMBOO.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_WARPED = JmChestSpecialRenderer.WARPED.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_CRIMSON = JmChestSpecialRenderer.CRIMSON.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_SPRUCE = JmChestSpecialRenderer.TRAPPED_SPRUCE.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_BIRCH = JmChestSpecialRenderer.TRAPPED_BIRCH.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_JUNGLE = JmChestSpecialRenderer.TRAPPED_JUNGLE.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_ACACIA = JmChestSpecialRenderer.TRAPPED_ACACIA.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_DARK_OAK = JmChestSpecialRenderer.TRAPPED_DARK_OAK.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_MANGROVE = JmChestSpecialRenderer.TRAPPED_MANGROVE.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_CHERRY = JmChestSpecialRenderer.TRAPPED_CHERRY.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_PALE_OAK = JmChestSpecialRenderer.TRAPPED_PALE_OAK.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_POPLAR = JmChestSpecialRenderer.TRAPPED_POPLAR.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_BAMBOO = JmChestSpecialRenderer.TRAPPED_BAMBOO.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_WARPED = JmChestSpecialRenderer.TRAPPED_WARPED.map(CHEST_MAPPER::apply);
	public static final MultiblockChestResources<SpriteId> CHEST_TRAPPED_CRIMSON = JmChestSpecialRenderer.TRAPPED_CRIMSON.map(CHEST_MAPPER::apply);
}
