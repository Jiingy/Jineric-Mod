package jingy.jineric.world.feature;

public class JinericTreeConfiguredFeatures {

//BOREAL TREE
//   public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BOREAL_TREE =
//           ConfiguredFeatures.register("boreal_tree", Feature.TREE, new TreeFeatureConfig.Builder(
//                   BlockStateProvider.of(JinericBlocks.BOREAL_LOG),
//                   new StraightTrunkPlacer(12, 8, 0),
//                   BlockStateProvider.of(JinericBlocks.BOREAL_LEAVES),
//                   new SpruceFoliagePlacer(UniformIntProvider.create(2, 2), UniformIntProvider.create(0, 3), UniformIntProvider.create(2, 4)),
//                   new TwoLayersFeatureSize(2, 0, 2)).build());
//
//   public static final RegistryEntry<PlacedFeature> BOREAL_CHECKED =
//           PlacedFeatures.register("boreal_checked", BOREAL_TREE,
//                   PlacedFeatures.wouldSurvive(JinericBlocks.BOREAL_SAPLING)
//           );
//
//   public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> BOREAL_SPAWN =
//           ConfiguredFeatures.register("boreal_spawn", Feature.RANDOM_SELECTOR,
//                   new RandomFeatureConfig(List.of(new RandomFeatureEntry(JinericTreeConfiguredFeatures.BOREAL_CHECKED, 0.33333334F)),
//                           JinericTreeConfiguredFeatures.BOREAL_CHECKED)
//           );

   public static void registerTreeConfiguredFeatures() {
   }
}
