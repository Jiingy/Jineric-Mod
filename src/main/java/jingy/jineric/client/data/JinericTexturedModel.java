package jingy.jineric.client.data;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

@Environment(EnvType.CLIENT)
public class JinericTexturedModel {
   public static final TexturedModel.Factory CUBE_COLUMN_NO_SUFFIX = TexturedModel.makeFactory(JinericTextureMap::bareSideEnd, Models.CUBE_COLUMN);
}
