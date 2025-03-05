package jingy.jineric.data.generators.world;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.concurrent.CompletableFuture;

public class JinericConfiguredFeatureProvider extends FabricDynamicRegistryProvider {
	public JinericConfiguredFeatureProvider(FabricDataOutput generator, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
		super(generator, registries);
	}
	
	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> registry) {
		registry.register(JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL, JinericUndergroundConfiguredFeatures.createFullGrassPatchFeature(registry));
		registry.register(JinericUndergroundConfiguredFeatures.FULL_GRASS_VEGETATION, JinericUndergroundConfiguredFeatures.createFullGrassVegetation());
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
	}
	
	@Override
	public String getName() {
		return "Configured Features";
	}
}
