package jingy.jineric.client.render.entity.model;

import jingy.jineric.base.JinericMain;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class JinericEntityModelLayer {
   public static final EntityModelLayer MANX_LOAGHTAN = new EntityModelLayer(new Identifier("jineric", "manx_loaghtan"), "main");
   public static final EntityModelLayer MANX_LOAGHTAN_WOOL = new EntityModelLayer(new Identifier("jineric", "manx_loaghtan"), "wool");
   public static final EntityModelLayer TURTLE_SADDLE = new EntityModelLayer(JinericMain.id("turtle"), "saddle");
}
