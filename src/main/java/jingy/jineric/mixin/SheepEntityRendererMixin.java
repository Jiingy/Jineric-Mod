//package jingy.jineric.mixin;
//
//import jingy.jineric.base.JinericMain;
//import net.minecraft.client.render.entity.SheepEntityRenderer;
//import net.minecraft.entity.passive.SheepEntity;
//import net.minecraft.util.Formatting;
//import net.minecraft.util.Identifier;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(SheepEntityRenderer.class)
//public abstract class SheepEntityRendererMixin {
//   private static final Identifier MANX_LOAGHTAN_TEXTURE = new Identifier(JinericMain.MOD_ID, "textures/entity/manx_loaghtan/manx_loaghtan.png");
//
// TODO: Texture does not properly apply to sheep due to the UV map not matching (Manx skin was made with a custom model in mind with horns)
//
//   @Inject(method = "getTexture(Lnet/minecraft/entity/passive/SheepEntity;)Lnet/minecraft/util/Identifier;", at = @At("HEAD"), cancellable = true)
//   private void jineric$manxLoaghtanSkin(SheepEntity sheepEntity, CallbackInfoReturnable<Identifier> cir) {
//      String string = Formatting.strip(sheepEntity.getName().getString());
//      if ("graac".equals(string)) {
//         cir.setReturnValue(MANX_LOAGHTAN_TEXTURE);
//      }
//   }
//}
