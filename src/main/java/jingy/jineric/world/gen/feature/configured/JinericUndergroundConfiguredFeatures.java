package jingy.jineric.world.gen.feature.configured;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class JinericUndergroundConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> JM_GRASS_BLOCK_VEGETATION = ResourceKey.create(Registries.CONFIGURED_FEATURE, JinericMain.ofJineric("jm_grass_block_vegetation"));
	public static final ResourceKey<ConfiguredFeature<?, ?>> JM_GRASS_BLOCK_PATCH_BONEMEAL = ResourceKey.create(Registries.CONFIGURED_FEATURE, JinericMain.ofJineric("jm_grass_block_patch_bonemeal"));
	
	protected static ConfiguredFeature<?, ?> createJmGrassBlockVegetation() {
		return new ConfiguredFeature<>(
				Feature.SIMPLE_BLOCK,
				new SimpleBlockConfiguration(
						new WeightedStateProvider(
								WeightedList.<BlockState>builder()
										.add(Blocks.SHORT_GRASS.defaultBlockState(), 40)
										.add(Blocks.TALL_GRASS.defaultBlockState(), 10)
										.add(Blocks.POPPY.defaultBlockState(), 5)
										.add(Blocks.DANDELION.defaultBlockState(), 5)
						)
				)
		);
	}
	
	protected static ConfiguredFeature<?, ?> createJmGrassBlockPatchFeature(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
		HolderGetter<ConfiguredFeature<?, ?>> registryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);
		return new ConfiguredFeature<>(
				Feature.VEGETATION_PATCH,
				new VegetationPatchConfiguration(
						blocks.getOrThrow(JinericBlockTags.JM_GRASS_BLOCK_REPLACEABLE),
						BlockStateProvider.simple(JinericBlocks.GRASS_BLOCK),
						PlacementUtils.inlinePlaced(registryEntryLookup.getOrThrow(JinericUndergroundConfiguredFeatures.JM_GRASS_BLOCK_VEGETATION)),
						CaveSurface.FLOOR,
						ConstantInt.of(1),
						0.0F,
						6,
						0.5F,
						UniformInt.of(1, 2),
						0.75F
				)
		);
	}
	
	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> featureRegisterable) {
		featureRegisterable.register(JinericUndergroundConfiguredFeatures.JM_GRASS_BLOCK_PATCH_BONEMEAL, JinericUndergroundConfiguredFeatures.createJmGrassBlockPatchFeature(featureRegisterable));
		featureRegisterable.register(JinericUndergroundConfiguredFeatures.JM_GRASS_BLOCK_VEGETATION, JinericUndergroundConfiguredFeatures.createJmGrassBlockVegetation());
	}
}
