package net.jineric.jineric_mod.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.block.entity.state.JinericChestBlockEntityRenderStateVariant;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(Sheets.class)
public abstract class TexturedRenderLayersMixin {
	@Shadow private static Material chooseMaterial(ChestType chestType, Material material, Material material2, Material material3) {
		return null;
	}
	
	@Inject(
			method = "chooseMaterial(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState$ChestMaterialType;Lnet/minecraft/world/level/block/state/properties/ChestType;)Lnet/minecraft/client/resources/model/Material;",
			at = @At("HEAD"),
			cancellable = true
	)
	private static void accountForJinericChestTextures(ChestRenderState.ChestMaterialType variant, ChestType type, CallbackInfoReturnable<Material> cir) {
		Map<ChestRenderState.ChestMaterialType, JinericChestBlockEntityRenderStateVariant> variantSpriteMap = JinericChestBlockEntityRenderStateVariant.VARIANT_TO_SPRITE_ID;
		if (variant.name().contains("JINERIC_")) {
			JinericChestBlockEntityRenderStateVariant stateVariant = variantSpriteMap.get(variant);
			cir.setReturnValue(chooseMaterial(type, stateVariant.normal(), stateVariant.left(), stateVariant.right()));
		}
	}
}
