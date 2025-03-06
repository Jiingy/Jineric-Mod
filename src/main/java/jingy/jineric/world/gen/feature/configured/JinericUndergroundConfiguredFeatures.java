package jingy.jineric.world.gen.feature.configured;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class JinericUndergroundConfiguredFeatures {
	public static final RegistryKey<ConfiguredFeature<?, ?>> FULL_GRASS_VEGETATION = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, JinericMain.ofJineric("full_grass_vegetation"));
	public static final RegistryKey<ConfiguredFeature<?, ?>> FULL_GRASS_PATCH_BONEMEAL = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, JinericMain.ofJineric("full_grass_patch_bonemeal"));
	
	protected static ConfiguredFeature<?, ?> createFullGrassVegetation() {
		return new ConfiguredFeature<>(
				Feature.SIMPLE_BLOCK,
				new SimpleBlockFeatureConfig(
						new WeightedBlockStateProvider(
								DataPool.<BlockState>builder()
										.add(Blocks.SHORT_GRASS.getDefaultState(), 40)
										.add(Blocks.TALL_GRASS.getDefaultState(), 10)
										.add(Blocks.POPPY.getDefaultState(), 5)
										.add(Blocks.DANDELION.getDefaultState(), 5)
						)
				)
		);
	}
	
	public static ConfiguredFeature<?, ?> createFullGrassPatchFeature(Registerable<ConfiguredFeature<?, ?>> registry) {
		RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = registry.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
		return new ConfiguredFeature<>(
				Feature.VEGETATION_PATCH,
				new VegetationPatchFeatureConfig(
						JinericBlockTags.FULL_GRASS_REPLACEABLE,
						BlockStateProvider.of(JinericBlocks.FULL_GRASS_BLOCK),
						PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(JinericUndergroundConfiguredFeatures.FULL_GRASS_VEGETATION)),
						VerticalSurfaceType.FLOOR,
						ConstantIntProvider.create(1),
						0.0F,
						6,
						0.5F,
						UniformIntProvider.create(1, 2),
						0.75F
				)
		);
	}
	
	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
		featureRegisterable.register(JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL, JinericUndergroundConfiguredFeatures.createFullGrassPatchFeature(featureRegisterable));
		featureRegisterable.register(JinericUndergroundConfiguredFeatures.FULL_GRASS_VEGETATION, JinericUndergroundConfiguredFeatures.createFullGrassVegetation());
	}
}