package jingy.jineric.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class JinericVegetationConfiguredFeatures {
   public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_WISTFUL_FOREST = JinericConfiguredFeatures.of("trees_wistful_forest");

   public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
      RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
      RegistryEntryLookup<PlacedFeature> registryLookupPlaced = featureRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

      RegistryEntry<PlacedFeature> petrifiedOakChecked = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED);
//      RegistryEntry<PlacedFeature> petrifiedOakBees002 = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002);
//      RegistryEntry<PlacedFeature> petrifiedOakBees0002 = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_0002);

      ConfiguredFeatures.register(featureRegisterable, TREES_WISTFUL_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(petrifiedOakChecked, 0.1F)), petrifiedOakChecked));
   }
}
