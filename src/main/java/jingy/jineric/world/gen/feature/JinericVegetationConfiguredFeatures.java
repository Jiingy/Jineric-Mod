package jingy.jineric.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class JinericVegetationConfiguredFeatures extends VegetationConfiguredFeatures {
   public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_PETRIFIED_OAK = JinericConfiguredFeatures.of("trees_petrified_oak");

   public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
      RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
      RegistryEntryLookup<PlacedFeature> registryLookupPlaced = featureRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

      RegistryEntry<PlacedFeature> petrifiedOakBees002 = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002);
      RegistryEntry<PlacedFeature> petrifiedOakBees0002 = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_0002);
      RegistryEntry<PlacedFeature> petrifiedOakChecked = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED);
      ConfiguredFeatures.register(featureRegisterable, TREES_PETRIFIED_OAK, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(petrifiedOakBees002, 0.1F)), petrifiedOakBees0002));
   }
}
