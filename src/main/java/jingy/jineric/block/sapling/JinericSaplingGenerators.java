package jingy.jineric.block.sapling;

import jingy.jineric.world.gen.feature.JinericTreeConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class JinericSaplingGenerators {
   public static final SaplingGenerator PETRIFIED_OAK = new SaplingGenerator(
           "petrified_oak",
           0.1F,
           Optional.empty(),
           Optional.empty(),
           Optional.of(JinericTreeConfiguredFeatures.PETRIFIED_OAK),
           //TODO: UNFINISHED, USES VANILLA TREES
           Optional.of(JinericTreeConfiguredFeatures.FANCY_OAK),
           Optional.of(JinericTreeConfiguredFeatures.OAK_BEES_005),
           Optional.of(JinericTreeConfiguredFeatures.FANCY_OAK_BEES_005)
   );
}
