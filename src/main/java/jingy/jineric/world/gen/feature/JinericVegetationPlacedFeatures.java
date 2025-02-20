package jingy.jineric.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

public class JinericVegetationPlacedFeatures {
   public static final RegistryKey<PlacedFeature> TREES_WISTFUL_FOREST = JinericPlacedFeatures.of("trees_wistful_forest");
   public static final RegistryKey<PlacedFeature> CARVED_PUMPKIN_PATCH = JinericPlacedFeatures.of("carved_pumpkin_patch");

   public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
      RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
      RegistryEntry<ConfiguredFeature<?, ?>> treesWistfulForest = registryEntryLookup.getOrThrow(JinericVegetationConfiguredFeatures.TREES_WISTFUL_FOREST);
      RegistryEntry<ConfiguredFeature<?, ?>> carvedPumpkinPatch = registryEntryLookup.getOrThrow(JinericVegetationConfiguredFeatures.CARVED_PATCH_PUMPKIN);
//      PlacedFeatures.register(featureRegisterable,
//              TREES_WISTFUL_FOREST,
//              treesWistfulForest,
//              treeModifiers(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1))
//      );
//      PlacedFeatures.register(featureRegisterable,
//              CARVED_PUMPKIN_PATCH,
//              carvedPumpkinPatch,
//              RarityFilterPlacementModifier.of(300),
//              SquarePlacementModifier.of(),
//              PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
//              BiomePlacementModifier.of()
//      );
   }
}
