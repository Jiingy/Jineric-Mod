package jingy.jineric.entity.passive.manxloaghtan;

import jingy.jineric.base.JinericMain;
import jingy.jineric.client.render.entity.state.ManxLoaghtanRenderState;
import jingy.jineric.registry.JinericEntityModelLayers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanWoolFeatureRenderer extends FeatureRenderer<ManxLoaghtanRenderState, ManxLoaghtanModel> {
   private static final Identifier SKIN = JinericMain.ofJineric("textures/entity/manx_loaghtan/manx_loaghtan_wool.png");
   private final ManxLoaghtanWoolModel model;

   public ManxLoaghtanWoolFeatureRenderer(FeatureRendererContext<ManxLoaghtanRenderState, ManxLoaghtanModel> context, EntityModelLoader entityModelLoader) {
      super(context);
      this.model = new ManxLoaghtanWoolModel(entityModelLoader.getModelPart(JinericEntityModelLayers.MANX_LOAGHTAN_WOOL));
   }

   //TODO: FIX FROM 1.21.3, IDC ABOUT THIS RIGHTN NOW
   public void render(
           MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, ManxLoaghtanRenderState manxLoaghtanRenderState, float f, float g
   ) {

   }
}
