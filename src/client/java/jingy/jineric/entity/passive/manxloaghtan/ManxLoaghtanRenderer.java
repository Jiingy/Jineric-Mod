package jingy.jineric.entity.passive.manxloaghtan;

import jingy.jineric.base.JinericMain;
import jingy.jineric.client.render.entity.state.ManxLoaghtanRenderState;
import jingy.jineric.registry.JinericEntityModelLayers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanRenderer extends AgeableMobEntityRenderer<ManxLoaghtanEntity, ManxLoaghtanRenderState, ManxLoaghtanModel> {
   private static final Identifier TEXTURE = JinericMain.ofJineric("textures/entity/manx_loaghtan/manx_loaghtan.png");

   public ManxLoaghtanRenderer(EntityRendererFactory.Context context) {
      super(context, new ManxLoaghtanModel(context.getPart(JinericEntityModelLayers.MANX_LOAGHTAN)),
              //TODO: NEEDS TO BE 'MANX_LOAGHTAN_BABY'
              new ManxLoaghtanModel(context.getPart(JinericEntityModelLayers.MANX_LOAGHTAN)), 0.7F);
      this.addFeature(new ManxLoaghtanWoolFeatureRenderer(this, context.getModelLoader()));
   }

   public Identifier getTexture(ManxLoaghtanRenderState sheepEntityRenderState) {
      return TEXTURE;
   }

   public ManxLoaghtanRenderState createRenderState() {
      return new ManxLoaghtanRenderState();
   }

   public void updateRenderState(ManxLoaghtanEntity manxLoaghtanEntity, ManxLoaghtanRenderState manxLoaghtanRenderState, float f) {
      super.updateRenderState(manxLoaghtanEntity, manxLoaghtanRenderState, f);
      manxLoaghtanRenderState.headAngle = manxLoaghtanEntity.getHeadAngle(f);
      manxLoaghtanRenderState.neckAngle = manxLoaghtanEntity.getNeckAngle(f);
      manxLoaghtanRenderState.sheared = manxLoaghtanEntity.isSheared();
      manxLoaghtanRenderState.color = manxLoaghtanEntity.getColor();
      manxLoaghtanRenderState.id = manxLoaghtanEntity.getId();
   }
}
