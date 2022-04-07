package jingy.jineric.entity.passive.manxloaghtan;

import jingy.jineric.registry.JinericEntityModelLayers;
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
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanWoolFeatureRenderer extends FeatureRenderer<ManxLoaghtan, ManxLoaghtanModel<ManxLoaghtan>> {
   private static final Identifier SKIN = new Identifier("jineric", "textures/entity/manx_loaghtan/manx_loaghtan_wool.png");
   private final ManxLoaghtanWoolModel<ManxLoaghtan> model;

   public ManxLoaghtanWoolFeatureRenderer(FeatureRendererContext<ManxLoaghtan, ManxLoaghtanModel<ManxLoaghtan>> context, EntityModelLoader entityModelLoader) {
      super(context);
      this.model = new ManxLoaghtanWoolModel<>(entityModelLoader.getModelPart(JinericEntityModelLayers.MANX_LOAGHTAN_WOOL));
   }

   public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, ManxLoaghtan manxLoaghtan, float f, float g, float h, float j, float k, float l) {
      MinecraftClient minecraftClient = MinecraftClient.getInstance();
      boolean bl = minecraftClient.hasOutline(manxLoaghtan);
      //if (!manxLoaghtanEntity.isSheared()) {
         if (manxLoaghtan.isInvisible() || bl) {
            VertexConsumer vertexConsumer;
            if (bl) {
               vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getOutline(SKIN));
               this.getContextModel().copyStateTo(this.model);
               this.model.animateModel(manxLoaghtan, f, g, h);
               this.model.setAngles(manxLoaghtan, f, g, j, k, l);
               this.model.render(matrixStack, vertexConsumer, i, LivingEntityRenderer.getOverlay(manxLoaghtan, 0.0F), 0.0F, 0.0F, 0.0F, 1.0F);
            }
//JEB FUNCTIONALITY
         /*
         } else {
            float s;
            float t;
            float u;
            if (manxLoaghtanEntity.hasCustomName() && "jeb_".equals(manxLoaghtanEntity.getName().asString())) {
               int m = 25;
               int n = manxLoaghtanEntity.age / 25 + manxLoaghtanEntity.getId();
               int o = DyeColor.values().length;
               int p = n % o;
               int q = (n + 1) % o;
               float r = ((float)(manxLoaghtanEntity.age % 25) + h) / 25.0F;
               float[] fs = SheepEntity.getRgbColor(DyeColor.byId(p));
               float[] gs = SheepEntity.getRgbColor(DyeColor.byId(q));
               s = fs[0] * (1.0F - r) + gs[0] * r;
               t = fs[1] * (1.0F - r) + gs[1] * r;
               u = fs[2] * (1.0F - r) + gs[2] * r;
            } else {
               float[] hs = SheepEntity.getRgbColor(manxLoaghtanEntity.getColor());
               s = hs[0];
               t = hs[1];
               u = hs[2];
            }*/

            //render(this.getContextModel(), this.model, SKIN, matrixStack, vertexConsumerProvider, i, manxLoaghtanEntity, f, g, j, k, l/*, h, s, t, u*/);
         }
      }
   }
//}
