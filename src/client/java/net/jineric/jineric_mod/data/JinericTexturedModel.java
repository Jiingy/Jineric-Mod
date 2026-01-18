package net.jineric.jineric_mod.data;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

@Environment(EnvType.CLIENT)
public class JinericTexturedModel {
	public static final TexturedModel.Provider CUBE_COLUMN_NO_SUFFIX = TexturedModel.createDefault(JinericTextureMap::bareSideEnd, ModelTemplates.CUBE_COLUMN);
}
