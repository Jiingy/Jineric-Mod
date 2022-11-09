package jingy.jineric.world.feature;

import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.List;

//Process of Features
//Configured Feature -> Placed Feature -> Configured Feature -> Placed Feature

public class JinericConfiguredFeatures {

   //CAN BONEMEAL FULL GRASS BLOCK
   public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> getDefaultConfiguredFeature() {
      List<RegistryEntry<? extends ConfiguredFeature<?, ?>>> list = List.of(
              JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL
      );
      return Util.getRandom(list, Random.create());
   }
}
