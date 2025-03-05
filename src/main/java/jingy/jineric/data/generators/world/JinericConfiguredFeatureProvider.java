package jingy.jineric.data.generators.world;

import jingy.jineric.world.gen.feature.JinericUndergroundConfiguredFeatures;
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
//		entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_002, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_002).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_0002, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_0002).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_005, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_005).value());
//		entries.add(JinericVegetationConfiguredFeatures.TREES_WISTFUL_FOREST, configuredFeatureRegistry.getOrThrow(JinericVegetationConfiguredFeatures.TREES_WISTFUL_FOREST).value());
//		entries.add(JinericVegetationConfiguredFeatures.CARVED_PATCH_PUMPKIN, configuredFeatureRegistry.getOrThrow(JinericVegetationConfiguredFeatures.CARVED_PATCH_PUMPKIN).value());
	}
	
	@Override
	public String getName() {
		return "Configured Features";
	}
}
