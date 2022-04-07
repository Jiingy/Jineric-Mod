package jingy.jineric.block.sapling;

import jingy.jineric.world.feature.JinericTreeConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BorealSaplingGenerator extends SaplingGenerator {

   @Nullable
   @Override
   protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
      return JinericTreeConfiguredFeatures.BOREAL_TREE;
   }
}
