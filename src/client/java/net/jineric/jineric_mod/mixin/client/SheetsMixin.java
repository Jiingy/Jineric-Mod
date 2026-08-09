package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.jineric.jineric_mod.render.JmSheets;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Sheets.class)
public abstract class SheetsMixin {
	//TODO: 26.2 fix / The switch cannot use a string
	@ModifyReturnValue(
			method = "chooseSprite",
			at = @At("RETURN")
	)
	private static SpriteId accountForJinericChestTextures(
			SpriteId original,
			final ChestRenderState.ChestMaterialType materialType, final ChestType type
	) {
		String materialTypeName = materialType.name();
		System.out.println("materialType = " + materialType);
		System.out.println("materialTypeName = " + materialTypeName);
		if (materialTypeName.contains("JM")) {
			return switch(materialTypeName) {
				case "JM_WOODEN_CHEST_SPRUCE" -> JmSheets.CHEST_SPRUCE.select(type);
				case "JM_WOODEN_CHEST_BIRCH" -> JmSheets.CHEST_BIRCH.select(type);
				case "JM_WOODEN_CHEST_JUNGLE" -> JmSheets.CHEST_JUNGLE.select(type);
				case "JM_WOODEN_CHEST_ACACIA" -> JmSheets.CHEST_ACACIA.select(type);
				case "JM_WOODEN_CHEST_DARK_OAK" -> JmSheets.CHEST_DARK_OAK.select(type);
				case "JM_WOODEN_CHEST_MANGROVE" -> JmSheets.CHEST_MANGROVE.select(type);
				case "JM_WOODEN_CHEST_CHERRY" -> JmSheets.CHEST_CHERRY.select(type);
				case "JM_WOODEN_CHEST_PALE_OAK" -> JmSheets.CHEST_PALE_OAK.select(type);
				case "JM_WOODEN_CHEST_POPLAR" -> JmSheets.CHEST_POPLAR.select(type);
				case "JM_WOODEN_CHEST_BAMBOO" -> JmSheets.CHEST_BAMBOO.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_SPRUCE" -> JmSheets.CHEST_TRAPPED_SPRUCE.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_BIRCH" -> JmSheets.CHEST_TRAPPED_BIRCH.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_JUNGLE" -> JmSheets.CHEST_TRAPPED_JUNGLE.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_ACACIA" -> JmSheets.CHEST_TRAPPED_ACACIA.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_DARK_OAK" -> JmSheets.CHEST_TRAPPED_DARK_OAK.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_MANGROVE" -> JmSheets.CHEST_TRAPPED_MANGROVE.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_CHERRY" -> JmSheets.CHEST_TRAPPED_CHERRY.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_PALE_OAK" -> JmSheets.CHEST_TRAPPED_PALE_OAK.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_POPLAR" -> JmSheets.CHEST_TRAPPED_POPLAR.select(type);
				case "JM_WOODEN_TRAPPED_CHEST_BAMBOO" -> JmSheets.CHEST_TRAPPED_BAMBOO.select(type);
				default -> Sheets.CHEST_REGULAR.select(type);
			};
		} else {
			return original;
		}
	}
}
