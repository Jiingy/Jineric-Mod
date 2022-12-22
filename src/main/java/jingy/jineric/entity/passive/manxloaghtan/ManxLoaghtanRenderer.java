package jingy.jineric.entity.passive.manxloaghtan;

import jingy.jineric.base.JinericMain;
import jingy.jineric.client.render.entity.model.JinericEntityModelLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanRenderer extends MobEntityRenderer<ManxLoaghtan, ManxLoaghtanModel<ManxLoaghtan>> {
   private static final Identifier TEXTURE = new Identifier(JinericMain.MOD_ID, "textures/entity/manx_loaghtan/manx_loaghtan.png");

   public ManxLoaghtanRenderer(EntityRendererFactory.Context context) {
      super(context, new ManxLoaghtanModel<>(context.getPart(JinericEntityModelLayer.MANX_LOAGHTAN)), 0.7F);
      this.addFeature(new ManxLoaghtanWoolFeatureRenderer(this, context.getModelLoader()));
   }

   public Identifier getTexture(ManxLoaghtan manxLoaghtan) {
      return TEXTURE;
   }
}
