package jingy.jineric.mixin;

import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanRenderer;
import jingy.jineric.registry.JinericEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(EntityRenderers.class)
public abstract class EntityRenderersMixin {

   @Shadow
   private static <T extends Entity> void register(EntityType<? extends T> entityType, EntityRendererFactory<T> entityRendererFactory) {
      throw new Error("Mixin did not apply!");
   }

   @Inject(method = "<clinit>", at = @At("RETURN"))
   private static void registerJinericRenderers(CallbackInfo ci) {
      register(JinericEntities.MANX_LOAGHTAN, ManxLoaghtanRenderer::new);
   }
}
