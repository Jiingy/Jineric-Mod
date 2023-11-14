package jingy.jineric.data.generators.world;

import jingy.jineric.base.JinericMain;
import jingy.jineric.world.biome.JinericBiomeKeys;
import jingy.jineric.world.gen.feature.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
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

   @Override
   protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
      final RegistryWrapper.Impl<Biome> biomeRegistry = registries.getWrapperOrThrow(RegistryKeys.BIOME);
      entries.add(JinericBiomeKeys.WISTFUL_FOREST, biomeRegistry.getOrThrow(JinericBiomeKeys.WISTFUL_FOREST).value());
      entries.add(JinericBiomeKeys.WISTFUL_FLOWER_FOREST, biomeRegistry.getOrThrow(JinericBiomeKeys.WISTFUL_FLOWER_FOREST).value());
      final RegistryWrapper.Impl<ConfiguredFeature<?, ?>> configuredFeatureRegistry = registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE);
      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_002, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_002).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_0002, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_0002).value());
//      entries.add(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_005, configuredFeatureRegistry.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_005).value());
      entries.add(JinericVegetationConfiguredFeatures.TREES_WISTFUL_FOREST, configuredFeatureRegistry.getOrThrow(JinericVegetationConfiguredFeatures.TREES_WISTFUL_FOREST).value());
      entries.add(JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL, configuredFeatureRegistry.getOrThrow(JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL).value());
      entries.add(JinericUndergroundConfiguredFeatures.FULL_GRASS_VEGETATION, configuredFeatureRegistry.getOrThrow(JinericUndergroundConfiguredFeatures.FULL_GRASS_VEGETATION).value());
      final RegistryWrapper.Impl<PlacedFeature> placedFeatureRegistry = registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
      entries.add(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED, placedFeatureRegistry.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED).value());
//      entries.add(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002, placedFeatureRegistry.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002).value());
      entries.add(JinericVegetationPlacedFeatures.TREES_WISTFUL_FOREST, placedFeatureRegistry.getOrThrow(JinericVegetationPlacedFeatures.TREES_WISTFUL_FOREST).value());
//      entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
//      entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
   }

   @Override
   public String getName() {
      return JinericMain.MOD_ID;
   }
}
