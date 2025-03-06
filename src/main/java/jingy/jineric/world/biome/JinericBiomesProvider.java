package jingy.jineric.world.biome;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public abstract class JinericBiomesProvider {
	
	public static void bootstrap(Registerable<Biome> biomeRegisterable) {
		RegistryEntryLookup<PlacedFeature> placedFeatureLookup = biomeRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
		RegistryEntryLookup<ConfiguredCarver<?>> configuredCarverLookup = biomeRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
		biomeRegisterable.register(JinericBiomeKeys.WISTFUL_FOREST, JinericOverworldBiomeCreator.createWistfulForest(placedFeatureLookup, configuredCarverLookup));
	}
}
