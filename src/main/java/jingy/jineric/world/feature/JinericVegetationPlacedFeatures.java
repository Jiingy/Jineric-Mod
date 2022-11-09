package jingy.jineric.world.feature;

import net.minecraft.util.math.intprovider.ClampedIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class JinericVegetationPlacedFeatures extends VegetationPlacedFeatures {

   public static final RegistryEntry<PlacedFeature> BOREAL_PLACED = PlacedFeatures.register(
           "boreal_placed",
           JinericTreeConfiguredFeatures.BOREAL_SPAWN,
           modifiers(PlacedFeatures.createCountExtraModifier(5, 0.1F, 1))
   );

   public static final RegistryEntry<PlacedFeature> BOREAL_FOREST_FLOWERS = PlacedFeatures.register(
           "boreal_forest_flowers",
           JinericVegetationConfiguredFeatures.FOREST_FLOWERS,
           RarityFilterPlacementModifier.of(7),
           SquarePlacementModifier.of(),
           PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
           CountPlacementModifier.of(ClampedIntProvider.create(UniformIntProvider.create(-1, 3), 0, 3)),
           BiomePlacementModifier.of()
   );
}
