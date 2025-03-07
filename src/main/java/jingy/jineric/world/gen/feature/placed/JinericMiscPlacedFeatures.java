package jingy.jineric.world.gen.feature.placed;

import jingy.jineric.world.gen.feature.configured.JinericMiscConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class JinericMiscPlacedFeatures {
	public static final RegistryKey<PlacedFeature> LAKE_WATER_SURFACE = JinericPlacedFeatures.of("lake_water_surface");
	
	protected static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
		RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
		RegistryEntry<ConfiguredFeature<?, ?>> lakeWaterSurface = registryEntryLookup.getOrThrow(JinericMiscConfiguredFeatures.LAKE_WATER);
		PlacedFeatures.register(
				featureRegisterable,
				LAKE_WATER_SURFACE,
				lakeWaterSurface,
				RarityFilterPlacementModifier.of(150),
				SquarePlacementModifier.of(),
				PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
				BiomePlacementModifier.of()
		);
	}
}
