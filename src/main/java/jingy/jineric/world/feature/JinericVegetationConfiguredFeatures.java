package jingy.jineric.world.feature;

import jingy.jineric.registry.JinericBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class JinericVegetationConfiguredFeatures {

   public static final RegistryEntry<ConfiguredFeature<SimpleRandomFeatureConfig, ?>> FOREST_FLOWERS = ConfiguredFeatures.register(
           "boreal_forest_flowers",
           Feature.SIMPLE_RANDOM_SELECTOR,
           new SimpleRandomFeatureConfig(
                   RegistryEntryList.of(
                           PlacedFeatures.createEntry(
                                   Feature.RANDOM_PATCH,
                                   ConfiguredFeatures.createRandomPatchFeatureConfig(
                                           Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(JinericBlocks.FIREWEED)))
                           )
                   )
           )
   );
}
