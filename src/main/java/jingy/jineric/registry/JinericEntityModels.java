package jingy.jineric.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.BoatEntityModel;

@Environment(EnvType.CLIENT)
public class JinericEntityModels {
	
	public static void registerEntityModels() {
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.PETRIFIED_OAK_BOAT, BoatEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.PETRIFIED_OAK_CHEST_BOAT, BoatEntityModel::getChestTexturedModelData);
	}
}
