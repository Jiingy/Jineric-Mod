package jingy.jineric.entity.passive.manxloaghtan;

import jingy.jineric.client.render.entity.model.JinericEntityModelLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanWoolFeatureRenderer extends FeatureRenderer<ManxLoaghtan, ManxLoaghtanModel<ManxLoaghtan>> {
   private static final Identifier SKIN = new Identifier("jineric", "textures/entity/manx_loaghtan/manx_loaghtan_wool.png");
   private final ManxLoaghtanWoolModel<ManxLoaghtan> model;

   public ManxLoaghtanWoolFeatureRenderer(FeatureRendererContext<ManxLoaghtan, ManxLoaghtanModel<ManxLoaghtan>> context, EntityModelLoader entityModelLoader) {
      super(context);
      this.model = new ManxLoaghtanWoolModel<>(entityModelLoader.getModelPart(JinericEntityModelLayer.MANX_LOAGHTAN_WOOL));
   }

   public void render(
           MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, ManxLoaghtan manxLoaghtan, float f, float g, float h, float j, float k, float l
   ) {
      if (!manxLoaghtan.isSheared()) {
         if (manxLoaghtan.isInvisible()) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            boolean bl = minecraftClient.hasOutline(manxLoaghtan);
            if (bl) {
               this.getContextModel().copyStateTo(this.model);
               this.model.animateModel(manxLoaghtan, f, g, h);
               this.model.setAngles(manxLoaghtan, f, g, j, k, l);
               VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getOutline(SKIN));
               this.model.render(matrixStack, vertexConsumer, i, LivingEntityRenderer.getOverlay(manxLoaghtan, 0.0F), 0.0F, 0.0F, 0.0F, 1.0F);
            }
//JEB FUNCTIONALITY

         } else {
            float s;
            float t;
            float u;
            if (manxLoaghtan.hasCustomName() && "jeb_".equals(manxLoaghtan.getName().getString())) {
               int m = 25;
               int n = manxLoaghtan.age / 25 + manxLoaghtan.getId();
               int o = DyeColor.values().length;
               int p = n % o;
               int q = (n + 1) % o;
               float r = ((float)(manxLoaghtan.age % 25) + h) / 25.0F;
               float[] fs = ManxLoaghtan.getRgbColor(DyeColor.byId(p));
               float[] gs = ManxLoaghtan.getRgbColor(DyeColor.byId(q));
               s = fs[0] * (1.0F - r) + gs[0] * r;
               t = fs[1] * (1.0F - r) + gs[1] * r;
               u = fs[2] * (1.0F - r) + gs[2] * r;
            } else {
               float[] hs = ManxLoaghtan.getRgbColor(manxLoaghtan.getColor());
               s = hs[0];
               t = hs[1];
               u = hs[2];
            }

            render(this.getContextModel(), this.model, SKIN, matrixStack, vertexConsumerProvider, i, manxLoaghtan, f, g, j, k, l, h, s, t, u);
         }
      }
   }
}
   //}
//}
