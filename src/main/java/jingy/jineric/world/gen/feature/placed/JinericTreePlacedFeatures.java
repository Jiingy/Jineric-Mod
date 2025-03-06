package jingy.jineric.world.gen.feature.placed;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.world.gen.feature.configured.JinericTreeConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

public class JinericTreePlacedFeatures {
	
	public static final RegistryKey<PlacedFeature> PETRIFIED_OAK_CHECKED = JinericPlacedFeatures.of("petrified_oak_checked");
//   public static final RegistryKey<PlacedFeature> PETRIFIED_OAK_BEES_002 = JinericPlacedFeatures.of("petrified_oak_bees_002");
//   public static final RegistryKey<PlacedFeature> PETRIFIED_OAK_BEES_0002 = JinericPlacedFeatures.of("petrified_oak_bees_0002");
	
	public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
		RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
		RegistryEntry<ConfiguredFeature<?, ?>> petrifiedOakTree = registryLookup.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK);
//      RegistryEntry<ConfiguredFeature<?, ?>> petrifiedOakTreeBees002 = registryLookup.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_002);
//      RegistryEntry<ConfiguredFeature<?, ?>> petrifiedOakTreeBees0002 = registryLookup.getOrThrow(JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_0002);
		
		PlacedFeatures.register(featureRegisterable, PETRIFIED_OAK_CHECKED, petrifiedOakTree, (PlacedFeatures.wouldSurvive(JinericBlocks.PETRIFIED_OAK_SAPLING)));
//      PlacedFeatures.register(featureRegisterable, PETRIFIED_OAK_BEES_002, petrifiedOakTreeBees002, (PlacedFeatures.wouldSurvive(JinericBlocks.PETRIFIED_OAK_SAPLING)));
//      PlacedFeatures.register(featureRegisterable, PETRIFIED_OAK_BEES_0002, petrifiedOakTreeBees0002, (PlacedFeatures.wouldSurvive(JinericBlocks.PETRIFIED_OAK_SAPLING)));
	}
}
