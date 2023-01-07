package jingy.jineric.client.render;

import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class JinericElytraFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> implements LivingEntityFeatureRenderEvents.AllowCapeRender {
   private static final Identifier SKIN = new Identifier("jineric:textures/entity/frozen_elytra.png");
   private final ElytraEntityModel<T> elytra;

   public JinericElytraFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
      super(context);
      this.elytra = new ElytraEntityModel<>(loader.getModelPart(EntityModelLayers.ELYTRA));
   }

   @Override
   public void render(
           MatrixStack matrixStack, VertexConsumerProvider vertexConsumers,
           int light, T livingEntity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch
   ) {
      ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
      if (itemStack.isOf(JinericItems.FROZEN_ELYTRA)) {
         Identifier identifier;
         if (livingEntity instanceof AbstractClientPlayerEntity) {
            AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity)livingEntity;
            if (abstractClientPlayerEntity.canRenderElytraTexture() && abstractClientPlayerEntity.getElytraTexture() != null) {
               identifier = abstractClientPlayerEntity.getElytraTexture();
            } else if (abstractClientPlayerEntity.canRenderCapeTexture()
                    && abstractClientPlayerEntity.getCapeTexture() != null
                    && abstractClientPlayerEntity.isPartVisible(PlayerModelPart.CAPE)) {
               identifier = abstractClientPlayerEntity.getCapeTexture();
            } else {
               identifier = SKIN;
            }
         } else {
            identifier = SKIN;
         }

         matrixStack.push();
         matrixStack.translate(0.0, 0.0, 0.125);
         this.getContextModel().copyStateTo(this.elytra);
         this.elytra.setAngles(livingEntity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
         VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(
                 vertexConsumers, RenderLayer.getArmorCutoutNoCull(identifier), false, itemStack.hasGlint()
         );
         this.elytra.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
         matrixStack.pop();
      }
   }

   @Override
   public boolean allowCapeRender(AbstractClientPlayerEntity player) {
      return false;
   }
}
