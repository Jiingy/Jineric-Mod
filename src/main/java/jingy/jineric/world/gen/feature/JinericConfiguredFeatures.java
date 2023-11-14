package jingy.jineric.world.gen.feature;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class JinericConfiguredFeatures {

   public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
      return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, JinericMain.jinericId(id));
   }

   public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
      JinericTreeConfiguredFeatures.bootstrap(featureRegisterable);
      JinericVegetationConfiguredFeatures.bootstrap(featureRegisterable);
      JinericUndergroundConfiguredFeatures.bootstrap(featureRegisterable);
   }
}
