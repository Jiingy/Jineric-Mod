package jingy.jineric.world.gen;

import jingy.jineric.world.feature.JinericVegetationPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class JinericTreeGeneration {
   public static void generateTrees() {
      BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.MOUNTAIN),
              GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.BOREAL_PLACED.getKey().get());


      //MODIFIES MOUNTAIN BIOME TO SPAWN TREES_BOREAL
      //BiomeModifications.addFeature(BiomeSelectors.categories(JinericConfiguredFeatures),
              //GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.TREES_BOREAL.getKey().get());
   }
}
