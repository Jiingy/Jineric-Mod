package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.block.WoodenChestBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.block.entity.state.JinericChestBlockEntityRenderStateVariant;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.block.entity.state.ChestBlockEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(ChestBlockEntityRenderer.class)
public abstract class ChestBlockEntityRendererMixin<T extends BlockEntity & LidOpenable> implements BlockEntityRenderer<T, ChestBlockEntityRenderState> {
	
	@ModifyReturnValue(
			method = "getVariant",
			at = @At(
					value = "RETURN",
					ordinal = 4
			)
	)
	private ChestBlockEntityRenderState.Variant getIdsForJinericChests(ChestBlockEntityRenderState.Variant original, BlockEntity blockEntity, boolean christmas) {
		if (blockEntity.getCachedState().getBlock() instanceof WoodenChestBlock woodenChestBlock) {
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
				default -> ChestBlockEntityRenderState.Variant.REGULAR;
			};
		} else {
			return original;
		}
	}
	
	@ModifyReturnValue(
			method = "getVariant",
			at = @At(
					value = "RETURN",
					ordinal = 2
			)
	)
	private ChestBlockEntityRenderState.Variant idsForWoodenTrappedChests(ChestBlockEntityRenderState.Variant original, BlockEntity blockEntity, boolean christmas) {
		if (blockEntity.getCachedState().getBlock() instanceof WoodenChestBlock woodenChestBlock) {
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
				default -> ChestBlockEntityRenderState.Variant.TRAPPED;};
		} else {
			return original;
		}
	}
}