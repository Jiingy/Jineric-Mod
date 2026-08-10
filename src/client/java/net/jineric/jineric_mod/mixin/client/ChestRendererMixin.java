package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.block.WoodenChestBlock;
import jingy.jineric.block.WoodenTrappedChestBlock;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestRenderer.class)
public abstract class ChestRendererMixin<T extends BlockEntity & LidBlockEntity> implements BlockEntityRenderer<T, ChestRenderState> {
	//TODO: 26.2 Fix
	@ModifyReturnValue(
			method = "getChestMaterial",
			at = @At(
					value = "RETURN",
					ordinal = 3
			)
	)
	private static ChestRenderState.ChestMaterialType materialForJmTrappedChests(ChestRenderState.ChestMaterialType original, BlockEntity entity, boolean xmasTextures) {
		if (entity.getBlockState().getBlock() instanceof WoodenTrappedChestBlock trappedChestBlock) {
			return materialType(trappedChestBlock.getWoodType().name(), true);
		} else {
			return original;
		}

	}

	@ModifyReturnValue(
			method = "getChestMaterial",
			at = @At(
					value = "RETURN",
					ordinal = 4
			)
	)
	private static ChestRenderState.ChestMaterialType materialForJmChests(ChestRenderState.ChestMaterialType original, BlockEntity entity, boolean xmasTextures) {
		if (entity.getBlockState().getBlock() instanceof WoodenChestBlock chestBlock) {
			return materialType(chestBlock.getWoodType().name(), false);
		} else {
			return original;
		}
	}

	@Unique
    private static ChestRenderState.ChestMaterialType materialType(String woodType, boolean trapped) {
		ChestRenderState.ChestMaterialType returnType;
		returnType =  switch (woodType) {
//			case "oak" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_OAK : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_OAK;
			case "spruce" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_SPRUCE : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_SPRUCE;
			case "birch" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_BIRCH : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_BIRCH;
			case "jungle" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_JUNGLE : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_JUNGLE;
			case "acacia" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_ACACIA : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_ACACIA;
			case "dark_oak" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_DARK_OAK : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_DARK_OAK;
			case "mangrove" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_MANGROVE : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_MANGROVE;
			case "cherry" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_CHERRY : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_CHERRY;
//			case "pale_oak" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_PALE_OAK : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_PALE_OAK;
//			case "poplar" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_POPLAR : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_POPLAR;
			case "bamboo" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_BAMBOO : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_BAMBOO;
			case "crimson" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_CRIMSON : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_CRIMSON;
			case "warped" -> trapped ? ChestRenderState.ChestMaterialType.JINERIC_WOODEN_TRAPPED_WARPED : ChestRenderState.ChestMaterialType.JINERIC_WOODEN_WARPED;
			default -> trapped ? ChestRenderState.ChestMaterialType.TRAPPED : ChestRenderState.ChestMaterialType.REGULAR;
		};
		return returnType;
	}
}