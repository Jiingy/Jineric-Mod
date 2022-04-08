package jingy.jineric.mixin;

import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtan;
import jingy.jineric.registry.JinericEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.IdentityHashMap;
import java.util.Map;

@Mixin(DefaultAttributeRegistry.class)
public class DefaultAttributeRegistryMixin {

   @Mutable
   @Shadow @Final private static Map<EntityType<? extends LivingEntity>, DefaultAttributeContainer> DEFAULT_ATTRIBUTE_REGISTRY;

   @Inject(method = "<clinit>", at = @At("RETURN"))
   private static void jineric$AddAttributes(CallbackInfo callbackInfo) {
      final IdentityHashMap<EntityType<? extends LivingEntity>, DefaultAttributeContainer> suppliers = new IdentityHashMap<>(DEFAULT_ATTRIBUTE_REGISTRY);
      suppliers.put(
              JinericEntities.MANX_LOAGHTAN, ManxLoaghtan.createManxLoaghtanAttributes().build()
      );
      DEFAULT_ATTRIBUTE_REGISTRY = suppliers;
   }
}
