package jingy.jineric.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.block.JinericChestBlock;
import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.client.render.JinericTextureRenderLayers;
import net.minecraft.block.BlockState;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestBlockEntityRenderer.class)
public abstract class ChestBlockEntityRendererMixin {

   @WrapOperation(
           method = "render(Lnet/minecraft/block/entity/BlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V",
           at = @At(value = "INVOKE",
           target = "Lnet/minecraft/client/render/TexturedRenderLayers;getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;")
   )
   private SpriteIdentifier jineric$getJinericChestTexture(BlockEntity blockEntity, ChestType type, boolean christmas, Operation<SpriteIdentifier> original) {
      BlockState blockState = blockEntity.getCachedState();
      WoodType woodType = JinericChestBlock.getWoodType(blockState.getBlock());
      if (blockEntity instanceof JinericChestBlockEntity) {
         return JinericTextureRenderLayers.getChestTexture(blockEntity, type, christmas, woodType);
      } else {
         return original.call(blockEntity, type, christmas);
      }
   }
}
