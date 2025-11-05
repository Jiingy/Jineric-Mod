package net.jineric.jineric_mod.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.CampfireBlockEntityRenderer;
import net.minecraft.client.render.block.entity.state.CampfireBlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(CampfireBlockEntityRenderer.class)
public abstract class CampfireBlockEntityRendererMixin implements BlockEntityRenderer<CampfireBlockEntity, CampfireBlockEntityRenderState> {
	
	@WrapOperation(
			method = "updateRenderState(Lnet/minecraft/block/entity/CampfireBlockEntity;Lnet/minecraft/client/render/block/entity/state/CampfireBlockEntityRenderState;FLnet/minecraft/util/math/Vec3d;Lnet/minecraft/client/render/command/ModelCommandRenderer$CrumblingOverlayCommand;)V",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/util/collection/DefaultedList;size()I"
			)
	)
	private int updateRenderOfLogSlots(DefaultedList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	@WrapOperation(
			method = "render(Lnet/minecraft/client/render/block/entity/state/CampfireBlockEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V",
			at = @At(value = "INVOKE",
					target = "Ljava/util/List;size()I"
			)
	)
	private int renderOnlyLogSlots(List<ItemRenderState> instance, Operation<Integer> original) {
		return 4;
	}
}