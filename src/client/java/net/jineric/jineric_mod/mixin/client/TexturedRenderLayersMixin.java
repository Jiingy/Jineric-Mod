package net.jineric.jineric_mod.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.block.entity.state.JinericChestBlockEntityRenderStateVariant;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.state.ChestBlockEntityRenderState;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(TexturedRenderLayers.class)
public abstract class TexturedRenderLayersMixin {
	@Shadow private static SpriteIdentifier getChestTextureId(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right) {
		return null;
	}
	
	@Inject(
			method = "getChestTextureId(Lnet/minecraft/client/render/block/entity/state/ChestBlockEntityRenderState$Variant;Lnet/minecraft/block/enums/ChestType;)Lnet/minecraft/client/util/SpriteIdentifier;",
			at = @At("HEAD"),
			cancellable = true
	)
	private static void accountForJinericChestTextures(ChestBlockEntityRenderState.Variant variant, ChestType type, CallbackInfoReturnable<SpriteIdentifier> cir) {
		Map<ChestBlockEntityRenderState.Variant, JinericChestBlockEntityRenderStateVariant> variantSpriteMap = JinericChestBlockEntityRenderStateVariant.VARIANT_TO_SPRITE_ID;
		if (variant.name().contains("JINERIC_")) {
			JinericChestBlockEntityRenderStateVariant stateVariant = variantSpriteMap.get(variant);
			cir.setReturnValue(getChestTextureId(type, stateVariant.normal(), stateVariant.left(), stateVariant.right()));
		}
	}
}
