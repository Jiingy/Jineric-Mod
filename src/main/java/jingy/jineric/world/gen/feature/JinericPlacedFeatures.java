package jingy.jineric.world.gen.feature;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;

public class JinericPlacedFeatures {

   public static RegistryKey<PlacedFeature> of(String id) {
      return RegistryKey.of(RegistryKeys.PLACED_FEATURE, JinericMain.jinericId(id));
   }

   public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
      JinericTreePlacedFeatures.bootstrap(featureRegisterable);
      JinericVegetationPlacedFeatures.bootstrap(featureRegisterable);
   }
}
