package jingy.jineric.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class JinericVegetationPlacedFeatures extends VegetationPlacedFeatures {

   public static final RegistryEntry<PlacedFeature> BOREAL_PLACED =
           PlacedFeatures.register("boreal_placed", JinericTreeConfiguredFeatures.BOREAL_SPAWN,
           modifiers(PlacedFeatures.createCountExtraModifier(5, 0.1F, 1)));

}
