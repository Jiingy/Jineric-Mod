package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.block.WoodenChestBlock;
import jingy.jineric.block.WoodenTrappedChestBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.jineric_mod.block.entity.state.JinericChestBlockEntityRenderStateVariant;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.block.entity.state.ChestBlockEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(ChestBlockEntityRenderer.class)
public abstract class ChestBlockEntityRendererMixin<T extends BlockEntity & LidOpenable> implements BlockEntityRenderer<T, ChestBlockEntityRenderState> {
	
	@ModifyReturnValue(
			method = "getVariant",
			at = @At(value = "RETURN", ordinal = 4)
	)
	private ChestBlockEntityRenderState.Variant getIdsForJinericChests(ChestBlockEntityRenderState.Variant original, BlockEntity blockEntity, boolean christmas) {
		if (blockEntity.getCachedState().getBlock() instanceof WoodenTrappedChestBlock trappedChestBlock) {
			return switch (trappedChestBlock.getWoodType().name()) {
//				case "oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_OAK;
				case "spruce" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_SPRUCE;
				case "birch" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_BIRCH;
				case "jungle" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_JUNGLE;
				case "acacia" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_ACACIA;
				case "dark_oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_DARK_OAK;
				case "mangrove" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_MANGROVE;
				case "cherry" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_CHERRY;
//				case "pale_oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_PALE_OAK;
				case "bamboo" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_BAMBOO;
				case "crimson" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_CRIMSON;
				case "warped" -> JinericChestBlockEntityRenderStateVariant.JINERIC_TRAPPED_WARPED;
				default -> throw new IllegalStateException("Unexpected value: " + trappedChestBlock.getWoodType().name());
			};
		} else if (blockEntity.getCachedState().getBlock() instanceof WoodenChestBlock chestBlock) {
			return switch (chestBlock.getWoodType().name()) {
//				case "oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_OAK;
				case "spruce" -> JinericChestBlockEntityRenderStateVariant.JINERIC_SPRUCE;
				case "birch" -> JinericChestBlockEntityRenderStateVariant.JINERIC_BIRCH;
				case "jungle" -> JinericChestBlockEntityRenderStateVariant.JINERIC_JUNGLE;
				case "acacia" -> JinericChestBlockEntityRenderStateVariant.JINERIC_ACACIA;
				case "dark_oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_DARK_OAK;
				case "mangrove" -> JinericChestBlockEntityRenderStateVariant.JINERIC_MANGROVE;
				case "cherry" -> JinericChestBlockEntityRenderStateVariant.JINERIC_CHERRY;
//				case "pale_oak" -> JinericChestBlockEntityRenderStateVariant.JINERIC_PALE_OAK;
				case "bamboo" -> JinericChestBlockEntityRenderStateVariant.JINERIC_BAMBOO;
				case "crimson" -> JinericChestBlockEntityRenderStateVariant.JINERIC_CRIMSON;
				case "warped" -> JinericChestBlockEntityRenderStateVariant.JINERIC_WARPED;
				default -> throw new IllegalStateException("Unexpected value: " + chestBlock.getWoodType().name());
			};
		} else {
			return original;
		}
	}
}