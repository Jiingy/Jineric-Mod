package jingy.jineric.world.gen.feature.configured;

import net.minecraft.registry.Registerable;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class JinericConfiguredFeatures {
	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
		JinericUndergroundConfiguredFeatures.bootstrap(featureRegisterable);
	}
}
