package jingy.jineric.structure;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BorealSaplingGenerator extends SaplingGenerator {
   private final ConfiguredFeature<TreeFeatureConfig, ?> feature;

   public BorealSaplingGenerator(ConfiguredFeature<?, ?> feature) {
      this.feature = (ConfiguredFeature<TreeFeatureConfig, ?>) feature;
   }
/*
   @Nullable
   @Override
   protected ConfiguredFeature<TreeFeatureConfig, ?> getFeature(Random random, boolean bees) {
      return feature;
   }
*/
   @Nullable
   @Override
   protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
      return null;
   }
}
