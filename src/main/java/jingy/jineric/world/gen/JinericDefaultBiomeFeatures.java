package jingy.jineric.world.gen;

import jingy.jineric.world.feature.JinericVegetationPlacedFeatures;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;

public class JinericDefaultBiomeFeatures {
   public static void addForestFlowers(GenerationSettings.Builder builder) {
      builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.BOREAL_FOREST_FLOWERS);
   }
}
