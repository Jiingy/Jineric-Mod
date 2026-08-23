package net.jineric.jineric_mod.mixin.client;

import net.jineric.jineric_mod.render.JmSheets;
import net.minecraft.client.renderer.MultiblockChestResources;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.client.renderer.Sheets.*;

@Mixin(Sheets.class)
public abstract class SheetsMixin {

	// Note: The switch case has to be exhaustive, therefore I cannot run the original switch statement.
	@Inject(
			method = "chooseSprite",
			at = @At("HEAD"),
			cancellable = true
	)
	private static void jmChestSprites(
			ChestRenderState.ChestMaterialType materialType, ChestType type,
			CallbackInfoReturnable<SpriteId> cir
	) {
		cir.setReturnValue(
				switch (materialType) {
					case ENDER_CHEST -> ENDER_CHEST_LOCATION;
					case REGULAR -> (SpriteId) CHEST_REGULAR.select(type);
					case CHRISTMAS -> (SpriteId) CHEST_CHRISTMAS.select(type);
					case TRAPPED -> (SpriteId) CHEST_TRAPPED.select(type);
					case COPPER_UNAFFECTED ->
							(SpriteId) ((MultiblockChestResources<?>) CHEST_COPPER.unaffected()).select(type);
					case COPPER_EXPOSED ->
							(SpriteId) ((MultiblockChestResources<?>) CHEST_COPPER.exposed()).select(type);
					case COPPER_WEATHERED ->
							(SpriteId) ((MultiblockChestResources<?>) CHEST_COPPER.weathered()).select(type);
					case COPPER_OXIDIZED ->
							(SpriteId) ((MultiblockChestResources<?>) CHEST_COPPER.oxidized()).select(type);
					case JINERIC_WOODEN_SPRUCE -> JmSheets.CHEST_SPRUCE.select(type);
					case JINERIC_WOODEN_BIRCH -> JmSheets.CHEST_BIRCH.select(type);
					case JINERIC_WOODEN_JUNGLE -> JmSheets.CHEST_JUNGLE.select(type);
					case JINERIC_WOODEN_ACACIA -> JmSheets.CHEST_ACACIA.select(type);
					case JINERIC_WOODEN_DARK_OAK -> JmSheets.CHEST_DARK_OAK.select(type);
					case JINERIC_WOODEN_MANGROVE -> JmSheets.CHEST_MANGROVE.select(type);
					case JINERIC_WOODEN_CHERRY -> JmSheets.CHEST_CHERRY.select(type);
					case JINERIC_WOODEN_PALE_OAK -> JmSheets.CHEST_PALE_OAK.select(type);
					case JINERIC_WOODEN_BAMBOO -> JmSheets.CHEST_BAMBOO.select(type);
					case JINERIC_WOODEN_WARPED -> JmSheets.CHEST_WARPED.select(type);
					case JINERIC_WOODEN_CRIMSON -> JmSheets.CHEST_CRIMSON.select(type);
					case JINERIC_WOODEN_TRAPPED_SPRUCE -> JmSheets.CHEST_TRAPPED_SPRUCE.select(type);
					case JINERIC_WOODEN_TRAPPED_BIRCH -> JmSheets.CHEST_TRAPPED_BIRCH.select(type);
					case JINERIC_WOODEN_TRAPPED_JUNGLE -> JmSheets.CHEST_TRAPPED_JUNGLE.select(type);
					case JINERIC_WOODEN_TRAPPED_ACACIA -> JmSheets.CHEST_TRAPPED_ACACIA.select(type);
					case JINERIC_WOODEN_TRAPPED_DARK_OAK -> JmSheets.CHEST_TRAPPED_DARK_OAK.select(type);
					case JINERIC_WOODEN_TRAPPED_MANGROVE -> JmSheets.CHEST_TRAPPED_MANGROVE.select(type);
					case JINERIC_WOODEN_TRAPPED_CHERRY -> JmSheets.CHEST_TRAPPED_CHERRY.select(type);
					case JINERIC_WOODEN_TRAPPED_PALE_OAK -> JmSheets.CHEST_TRAPPED_PALE_OAK.select(type);
					case JINERIC_WOODEN_TRAPPED_BAMBOO -> JmSheets.CHEST_TRAPPED_BAMBOO.select(type);
					case JINERIC_WOODEN_TRAPPED_WARPED -> JmSheets.CHEST_TRAPPED_WARPED.select(type);
					case JINERIC_WOODEN_TRAPPED_CRIMSON -> JmSheets.CHEST_TRAPPED_CRIMSON.select(type);
				}
		);
	}
}
