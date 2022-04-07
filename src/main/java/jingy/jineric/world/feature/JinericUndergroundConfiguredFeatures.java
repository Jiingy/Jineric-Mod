package jingy.jineric.world.feature;

import jingy.jineric.registry.JinericBlocks;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class JinericUndergroundConfiguredFeatures {

   //FULL GRASS REPLACE GRASS
   public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>> FULL_GRASS_VEGETATION = ConfiguredFeatures.register(
           "full_grass_vegetation", Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                   new WeightedBlockStateProvider(
                           DataPool.<BlockState>builder()
                                   .add(Blocks.GRASS.getDefaultState(), 50)
                                   .add(Blocks.TALL_GRASS.getDefaultState(), 10)
                   )
           )
   );

   public static final RegistryEntry<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> FULL_GRASS_PATCH_BONEMEAL = ConfiguredFeatures.register(
           "full_grass_patch_bonemeal",
           Feature.VEGETATION_PATCH,
           new VegetationPatchFeatureConfig(
                   JinericBlockTags.FULL_GRASS_REPLACEABLE,
                   BlockStateProvider.of(JinericBlocks.FULL_GRASS_BLOCK),
                   PlacedFeatures.createEntry(FULL_GRASS_VEGETATION),
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
