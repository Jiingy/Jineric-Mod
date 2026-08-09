package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.block.WoodenChestBlock;
import jingy.jineric.block.WoodenTrappedChestBlock;
import net.jineric.jineric_mod.renderer.blockentity.state.JmChestMaterialTypes;
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
//			case "oak" -> JmChestMaterialTypes.CHEST_TRAPPED_OAK;
			case "spruce" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_SPRUCE : JmChestMaterialTypes.CHEST_SPRUCE;
			case "birch" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_BIRCH : JmChestMaterialTypes.CHEST_BIRCH;
			case "jungle" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_JUNGLE : JmChestMaterialTypes.CHEST_JUNGLE;
			case "acacia" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_ACACIA : JmChestMaterialTypes.CHEST_ACACIA;
			case "dark_oak" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_DARK_OAK : JmChestMaterialTypes.CHEST_DARK_OAK;
			case "mangrove" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_MANGROVE : JmChestMaterialTypes.CHEST_MANGROVE;
			case "cherry" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_CHERRY : JmChestMaterialTypes.CHEST_CHERRY;
//			case "pale_oak" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_PALE_OAK : JmChestMaterialTypes.CHEST_PALE_OAK;
//			case "poplar" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_POPLAR : JmChestMaterialTypes.CHEST_POPLAR;
			case "bamboo" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_BAMBOO : JmChestMaterialTypes.CHEST_BAMBOO;
			case "crimson" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_CRIMSON : JmChestMaterialTypes.CHEST_CRIMSON;
			case "warped" -> trapped ? JmChestMaterialTypes.TRAPPED_CHEST_WARPED : JmChestMaterialTypes.CHEST_WARPED;
			default -> trapped ? ChestRenderState.ChestMaterialType.TRAPPED : ChestRenderState.ChestMaterialType.REGULAR;
		};
		return returnType;
	}
}