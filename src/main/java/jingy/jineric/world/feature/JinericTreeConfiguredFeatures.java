package jingy.jineric.world.feature;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.mixin.access.TreeConfiguredFeaturesAccess;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

import java.util.List;

public class JinericTreeConfiguredFeatures {
   public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_OAK_BEES_0002 = JinericTreeConfiguredFeatures.of("petrified_oak_bees_0002");
   public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_OAK_BEES_002 = JinericTreeConfiguredFeatures.of("petrified_oak_bees_002");
   public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_OAK_BEES_005 = JinericTreeConfiguredFeatures.of("petrified_oak_bees_005");
   public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_OAK = JinericTreeConfiguredFeatures.of("petrified_oak_tree");

   private static TreeFeatureConfig.Builder petrifiedOak() {
      return TreeConfiguredFeaturesAccess.initBuilder(JinericBlocks.PETRIFIED_OAK_LOG, JinericBlocks.PETRIFIED_OAK_LEAVES, 4, 2, 0, 2).ignoreVines();
   }

   public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
      return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, JinericMain.jinericId(id));
   }

   public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
      BeehiveTreeDecorator beehiveTreeDecorator0002 = new BeehiveTreeDecorator(0.002F);
      BeehiveTreeDecorator beehiveTreeDecorator002 = new BeehiveTreeDecorator(0.02F);
      BeehiveTreeDecorator beehiveTreeDecorator005 = new BeehiveTreeDecorator(0.05F);
      ConfiguredFeatures.register(featureRegisterable, PETRIFIED_OAK, Feature.TREE, petrifiedOak().build());
      ConfiguredFeatures.register(featureRegisterable, PETRIFIED_OAK_BEES_0002, Feature.TREE, petrifiedOak().decorators(List.of(beehiveTreeDecorator0002)).build());
      ConfiguredFeatures.register(featureRegisterable, PETRIFIED_OAK_BEES_002, Feature.TREE, petrifiedOak().decorators(List.of(beehiveTreeDecorator002)).build());
      ConfiguredFeatures.register(featureRegisterable, PETRIFIED_OAK_BEES_005, Feature.TREE, petrifiedOak().decorators(List.of(beehiveTreeDecorator005)).build());
   }
}
