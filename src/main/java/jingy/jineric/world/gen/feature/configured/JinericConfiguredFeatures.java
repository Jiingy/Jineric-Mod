package jingy.jineric.world.gen.feature.configured;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class JinericConfiguredFeatures {
	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> featureRegisterable) {
		JinericUndergroundConfiguredFeatures.bootstrap(featureRegisterable);
	}
}
