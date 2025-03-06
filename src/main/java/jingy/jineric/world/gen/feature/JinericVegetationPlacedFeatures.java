package jingy.jineric.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.intprovider.ClampedIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class JinericVegetationPlacedFeatures {
	public static final RegistryKey<PlacedFeature> TREES_WISTFUL_FOREST = JinericPlacedFeatures.of("trees_wistful_forest");
	public static final RegistryKey<PlacedFeature> CARVED_PUMPKIN_PATCH = JinericPlacedFeatures.of("carved_pumpkin_patch");
	public static final RegistryKey<PlacedFeature> PATCH_ROSE = JinericPlacedFeatures.of("patch_rose");
	public static final RegistryKey<PlacedFeature> PATCH_ROSES = JinericPlacedFeatures.of("patch_roses");
	public static final RegistryKey<PlacedFeature> PATCH_BLOSSOMED_DANDELION = JinericPlacedFeatures.of("patch_blossomed_dandelion");
	
	
	public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
		RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
		RegistryEntry<ConfiguredFeature<?, ?>> treesWistfulForest = registryEntryLookup.getOrThrow(JinericVegetationConfiguredFeatures.TREES_WISTFUL_FOREST);
		RegistryEntry<ConfiguredFeature<?, ?>> carvedPumpkinPatch = registryEntryLookup.getOrThrow(JinericVegetationConfiguredFeatures.CARVED_PATCH_PUMPKIN);
		RegistryEntry<ConfiguredFeature<?, ?>> patchRose = registryEntryLookup.getOrThrow(JinericVegetationConfiguredFeatures.PATCH_ROSE);
		RegistryEntry<ConfiguredFeature<?, ?>> patchRoses = registryEntryLookup.getOrThrow(JinericVegetationConfiguredFeatures.PATCH_ROSES);
		RegistryEntry<ConfiguredFeature<?, ?>> patchBlossomedDandelion = registryEntryLookup.getOrThrow(JinericVegetationConfiguredFeatures.PATCH_BLOSSOMED_DANDELION);
		PlacedFeatures.register(featureRegisterable,
				TREES_WISTFUL_FOREST,
				treesWistfulForest,
				VegetationPlacedFeatures.treeModifiers(
						PlacedFeatures.createCountExtraModifier(10, 0.1F, 1)
				)
		);
		PlacedFeatures.register(featureRegisterable,
				CARVED_PUMPKIN_PATCH,
				carvedPumpkinPatch,
				RarityFilterPlacementModifier.of(300),
				SquarePlacementModifier.of(),
				PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
				BiomePlacementModifier.of()
		);
		PlacedFeatures.register(featureRegisterable,
				PATCH_ROSE,
				patchRose,
				RarityFilterPlacementModifier.of(5),
				SquarePlacementModifier.of(),
				PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
				CountPlacementModifier.of(ClampedIntProvider.create(UniformIntProvider.create(-1, 3), 0, 3)),
				BiomePlacementModifier.of()
		);
		PlacedFeatures.register(featureRegisterable,
				PATCH_ROSES,
				patchRoses,
				RarityFilterPlacementModifier.of(9),
				SquarePlacementModifier.of(),
				PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
				CountPlacementModifier.of(ClampedIntProvider.create(UniformIntProvider.create(-1, 3), 0, 3)),
				BiomePlacementModifier.of()
		);
		PlacedFeatures.register(featureRegisterable,
				PATCH_BLOSSOMED_DANDELION,
				patchBlossomedDandelion,
				RarityFilterPlacementModifier.of(5),
				SquarePlacementModifier.of(),
				PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
				CountPlacementModifier.of(ClampedIntProvider.create(UniformIntProvider.create(-1, 3), 0, 3)),
				BiomePlacementModifier.of()
		);
	}
}
