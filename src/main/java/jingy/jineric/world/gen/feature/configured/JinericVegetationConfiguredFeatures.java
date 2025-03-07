package jingy.jineric.world.gen.feature.configured;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.world.gen.feature.placed.JinericTreePlacedFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class JinericVegetationConfiguredFeatures {
	public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_WISTFUL_FOREST = JinericConfiguredFeatures.of("trees_wistful_forest");
	public static final RegistryKey<ConfiguredFeature<?, ?>> CARVED_PATCH_PUMPKIN = JinericConfiguredFeatures.of("carved_patch_pumpkin");
	public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_ROSE = JinericConfiguredFeatures.of("patch_rose");
	public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_ROSES = JinericConfiguredFeatures.of("patch_roses");
	public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_BLOSSOMED_DANDELION = JinericConfiguredFeatures.of("patch_dandelion");
	
	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
		RegistryEntryLookup<PlacedFeature> registryLookupPlaced = featureRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
		RegistryEntry<PlacedFeature> petrifiedOakChecked = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED);
//		RegistryEntry<PlacedFeature> petrifiedOakBees002 = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002);
//		RegistryEntry<PlacedFeature> petrifiedOakBees0002 = registryLookupPlaced.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_0002);
		ConfiguredFeatures.register(featureRegisterable,
				TREES_WISTFUL_FOREST, Feature.RANDOM_SELECTOR,
				new RandomFeatureConfig(List.of(new RandomFeatureEntry(petrifiedOakChecked, 0.1F)), petrifiedOakChecked)
		);
		ConfiguredFeatures.register(featureRegisterable,
				CARVED_PATCH_PUMPKIN, Feature.RANDOM_PATCH,
				ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
						new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.CARVED_PUMPKIN)),
						List.of(Blocks.GRASS_BLOCK)
				)
		);
		ConfiguredFeatures.register(
				featureRegisterable,
				PATCH_ROSE,
				Feature.FLOWER,
				new RandomPatchFeatureConfig(
						80, 9, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(JinericBlocks.ROSE)))
				)
		);
		ConfiguredFeatures.register(featureRegisterable,
				PATCH_ROSES,
				Feature.SIMPLE_RANDOM_SELECTOR,
				new SimpleRandomFeatureConfig(
						RegistryEntryList.of(
								PlacedFeatures.createEntry(
										Feature.RANDOM_PATCH,
										ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(JinericBlocks.ROSE)))
								),
								PlacedFeatures.createEntry(
										Feature.RANDOM_PATCH,
										ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.ROSE_BUSH)))
								)
						)
				)
		);
		ConfiguredFeatures.register(
				featureRegisterable,
				PATCH_BLOSSOMED_DANDELION,
				Feature.FLOWER,
				new RandomPatchFeatureConfig(
						80, 9, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(JinericBlocks.BLOSSOMED_DANDELION)))
				)
		);
	}
}
