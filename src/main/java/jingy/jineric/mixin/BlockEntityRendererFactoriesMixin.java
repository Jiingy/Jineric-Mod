package jingy.jineric.mixin;

import jingy.jineric.block.blockentity.sign.JinericSignBlockEntityRenderer;
import jingy.jineric.registry.JinericBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityRendererFactories.class)
public abstract class BlockEntityRendererFactoriesMixin {

   @Shadow
   private static <T extends BlockEntity> void register(BlockEntityType<? extends T> type, BlockEntityRendererFactory<T> blockEntityRendererFactory) {
      throw new Error("Mixin did not apply!");
   }

   @Inject(method = "<clinit>", at = @At("RETURN"))
   private static void registerJinericRenderers(CallbackInfo ci) {
      register(JinericBlockEntities.SIGN, JinericSignBlockEntityRenderer::new);
   }
}
