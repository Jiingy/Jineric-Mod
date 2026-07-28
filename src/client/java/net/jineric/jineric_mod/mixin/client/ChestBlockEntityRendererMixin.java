package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.block.WoodenChestBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.block.entity.state.JinericChestBlockEntityRenderStateVariant;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(ChestRenderer.class)
public abstract class ChestBlockEntityRendererMixin<T extends BlockEntity & LidBlockEntity> implements BlockEntityRenderer<T, ChestRenderState> {
	
	@ModifyReturnValue(
			method = "getChestMaterial",
			at = @At(
					value = "RETURN",
					ordinal = 4
			)
	)
	private static ChestRenderState.ChestMaterialType getIdsForJinericChests(ChestRenderState.ChestMaterialType original, BlockEntity entity, boolean xmasTextures) {
		if (entity.getBlockState().getBlock() instanceof WoodenChestBlock woodenChestBlock) {
			return switch (woodenChestBlock.getWoodType().name()) {
//				case "oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_OAK;
				case "spruce" -> JinericChestBlockEntityRenderStateVariant.SPRUCE;
				case "birch" -> JinericChestBlockEntityRenderStateVariant.BIRCH;
				case "jungle" -> JinericChestBlockEntityRenderStateVariant.JUNGLE;
				case "acacia" -> JinericChestBlockEntityRenderStateVariant.ACACIA;
				case "dark_oak" -> JinericChestBlockEntityRenderStateVariant.DARK_OAK;
				case "mangrove" -> JinericChestBlockEntityRenderStateVariant.MANGROVE;
				case "cherry" -> JinericChestBlockEntityRenderStateVariant.CHERRY;
//				case "pale_oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_PALE_OAK;
				case "bamboo" -> JinericChestBlockEntityRenderStateVariant.BAMBOO;
				case "crimson" -> JinericChestBlockEntityRenderStateVariant.CRIMSON;
				case "warped" -> JinericChestBlockEntityRenderStateVariant.WARPED;
				default -> ChestRenderState.ChestMaterialType.REGULAR;
			};
		} else {
			return original;
		}
	}
	
	@ModifyReturnValue(
			method = "getChestMaterial",
			at = @At(
					value = "RETURN",
					ordinal = 2
			)
	)
	private static ChestRenderState.ChestMaterialType idsForWoodenTrappedChests(ChestRenderState.ChestMaterialType original, BlockEntity entity, boolean xmasTextures) {
		if (entity.getBlockState().getBlock() instanceof WoodenChestBlock woodenChestBlock) {
			return switch (woodenChestBlock.getWoodType().name()) {
//				case "oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_OAK;
				case "spruce" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_SPRUCE;
				case "birch" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_BIRCH;
				case "jungle" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_JUNGLE;
				case "acacia" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_ACACIA;
				case "dark_oak" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_DARK_OAK;
				case "mangrove" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_MANGROVE;
				case "cherry" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_CHERRY;
//				case "pale_oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_PALE_OAK;
				case "bamboo" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_BAMBOO;
				case "crimson" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_CRIMSON;
				case "warped" -> JinericChestBlockEntityRenderStateVariant.TRAPPED_WARPED;
				default -> ChestRenderState.ChestMaterialType.TRAPPED;};
		} else {
			return original;
		}
	}
}