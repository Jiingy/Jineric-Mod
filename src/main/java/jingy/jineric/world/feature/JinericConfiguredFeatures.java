package jingy.jineric.world.feature;

import net.minecraft.util.Util;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.List;
import java.util.Random;

//Process of Features
//Configured Feature -> Placed Feature -> Configured Feature -> Placed Feature

public class JinericConfiguredFeatures {

   //CAN BONEMEAL FULL GRASS BLOCK
   public static RegistryEntry<? extends ConfiguredFeature<?, ?>> getDefaultConfiguredFeature() {
      List<RegistryEntry<? extends ConfiguredFeature<?, ?>>> list = List.of(
              JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL
      );
      return Util.getRandom(list, new Random());
   }
}
