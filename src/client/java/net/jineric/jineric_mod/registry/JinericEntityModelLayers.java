package net.jineric.jineric_mod.registry;

import com.google.common.collect.Sets;
import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class JinericEntityModelLayers {
	private static final String MAIN = "main";
	private static final Set<ModelLayerLocation> LAYERS = Sets.newHashSet();
	
	private static ModelLayerLocation registerMain(String id) {
		return register(id, MAIN);
	}
	
	private static ModelLayerLocation register(String id, String layer) {
		ModelLayerLocation entityModelLayer = create(id, layer);
		if (!LAYERS.add(entityModelLayer)) {
			throw new IllegalStateException("Duplicate registration for " + entityModelLayer);
		} else {
			return entityModelLayer;
		}
	}
	
	private static ModelLayerLocation create(String id, String layer) {
		return new ModelLayerLocation(JinericMain.ofJineric(id), layer);
	}
}
