package jingy.jineric.block.sapling;

import jingy.jineric.world.feature.JinericTreeConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class PetrifiedOakSaplingGenerator extends SaplingGenerator {
   protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
//      if (random.nextInt(10) == 0) {
//         return bees ? TreeConfiguredFeatures.FANCY_OAK_BEES_005 : TreeConfiguredFeatures.FANCY_OAK;
//      } else {
         return bees ? JinericTreeConfiguredFeatures.PETRIFIED_OAK_BEES_005 : JinericTreeConfiguredFeatures.PETRIFIED_OAK;
//      }
   }
}
