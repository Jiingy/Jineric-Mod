package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.CampfireRenderer;
import net.minecraft.client.renderer.blockentity.state.CampfireRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(CampfireRenderer.class)
public abstract class CampfireBlockEntityRendererMixin implements BlockEntityRenderer<CampfireBlockEntity, CampfireRenderState> {
	
	@WrapOperation(
			method = "extractRenderState(Lnet/minecraft/world/level/block/entity/CampfireBlockEntity;Lnet/minecraft/client/renderer/blockentity/state/CampfireRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/core/NonNullList;size()I"
			)
	)
	private int updateRenderOfLogSlots(NonNullList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	@WrapOperation(
			method = "submit(Lnet/minecraft/client/renderer/blockentity/state/CampfireRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/CameraRenderState;)V",
			at = @At(value = "INVOKE",
					target = "Ljava/util/List;size()I"
			)
	)
	private int renderOnlyLogSlots(List<ItemStackRenderState> instance, Operation<Integer> original) {
		return 4;
	}
}