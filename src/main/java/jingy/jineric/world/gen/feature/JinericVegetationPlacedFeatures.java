package jingy.jineric.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

import java.util.List;

public class JinericVegetationPlacedFeatures extends VegetationPlacedFeatures {
   public static final RegistryKey<PlacedFeature> TREES_PETRIFIED_OAK = PlacedFeatures.of("trees_petrified_oak");

   public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
      RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
      RegistryEntry<ConfiguredFeature<?, ?>> petrifiedOak = registryEntryLookup.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK);
      RegistryEntry<ConfiguredFeature<?, ?>> treesPetrifiedOak = registryEntryLookup.getOrThrow(JinericVegetationConfiguredFeatures.TREES_PETRIFIED_OAK);

      PlacedFeatures.register(featureRegisterable, TREES_PETRIFIED_OAK, treesPetrifiedOak, (List)treeModifiers(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1)));
   }
}
