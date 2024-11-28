package jingy.jineric.data.generators.world;

import jingy.jineric.world.biome.JinericBiomeKeys;
import jingy.jineric.world.gen.feature.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.concurrent.CompletableFuture;

public class JinericWorldGenerator extends FabricDynamicRegistryProvider {
   public JinericWorldGenerator(FabricDataOutput generator, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
      super(generator, registries);
   }

   public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> registry) {
      registry.register(JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL, JinericUndergroundConfiguredFeatures.createFullGrassPatchFeature(registry));
      registry.register(JinericUndergroundConfiguredFeatures.FULL_GRASS_VEGETATION, JinericUndergroundConfiguredFeatures.createFullGrassVegetation());
   }

   @Override
   protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
      final RegistryWrapper.Impl<Biome> biomeRegistry = registries.getOrThrow(RegistryKeys.BIOME);
//      entries.add(JinericBiomeKeys.WISTFUL_FOREST, biomeRegistry.getOrThrow(JinericBiomeKeys.WISTFUL_FOREST).value());
//      entries.add(JinericBiomeKeys.WISTFUL_FLOWER_FOREST, biomeRegistry.getOrThrow(JinericBiomeKeys.WISTFUL_FLOWER_FOREST).value());

      final RegistryWrapper.Impl<ConfiguredFeature<?, ?>> configuredFeatureRegistry = registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE);
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_002, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_002).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_0002, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_0002).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_005, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_005).value());
      entries.add(JinericVegetationConfiguredFeatures.TREES_WISTFUL_FOREST, configuredFeatureRegistry.getOrThrow(JinericVegetationConfiguredFeatures.TREES_WISTFUL_FOREST).value());
      entries.add(JinericVegetationConfiguredFeatures.CARVED_PATCH_PUMPKIN, configuredFeatureRegistry.getOrThrow(JinericVegetationConfiguredFeatures.CARVED_PATCH_PUMPKIN).value());
      entries.add(JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL, configuredFeatureRegistry.getOrThrow(JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL).value());
      entries.add(JinericUndergroundConfiguredFeatures.FULL_GRASS_VEGETATION, configuredFeatureRegistry.getOrThrow(JinericUndergroundConfiguredFeatures.FULL_GRASS_VEGETATION).value());
      final RegistryWrapper.Impl<PlacedFeature> placedFeatureRegistry = registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
      entries.add(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED, placedFeatureRegistry.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED).value());
//      entries.add(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002, placedFeatureRegistry.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002).value());
      entries.add(JinericVegetationPlacedFeatures.TREES_WISTFUL_FOREST, placedFeatureRegistry.getOrThrow(JinericVegetationPlacedFeatures.TREES_WISTFUL_FOREST).value());
      entries.add(JinericVegetationPlacedFeatures.CARVED_PUMPKIN_PATCH, placedFeatureRegistry.getOrThrow(JinericVegetationPlacedFeatures.CARVED_PUMPKIN_PATCH).value());
      entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
      entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
   }

   @Override
   public String getName() {
      return "jineric_world";
   }
}
