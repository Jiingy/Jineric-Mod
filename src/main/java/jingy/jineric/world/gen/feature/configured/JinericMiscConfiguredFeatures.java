package jingy.jineric.world.gen.feature.configured;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.LakeFeature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class JinericMiscConfiguredFeatures {
	public static final RegistryKey<ConfiguredFeature<?, ?>> LAKE_WATER = JinericConfiguredFeatures.of("lake_water");
	
	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
		ConfiguredFeatures.register(
				featureRegisterable,
				LAKE_WATER,
				Feature.LAKE,
				new LakeFeature.Config(
						BlockStateProvider.of(Blocks.WATER.getDefaultState()),
						BlockStateProvider.of(Blocks.MOSS_BLOCK.getDefaultState())
				)
		);
	}
}
