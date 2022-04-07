package jingy.jineric.util;


import jingy.jineric.base.JinericMain;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class JinericPlacedFeatureUtil {
   public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
      Identifier jinericID = JinericMain.createLocation(id);
      if (BuiltinRegistries.PLACED_FEATURE.getIds().contains(jinericID))
         throw new IllegalStateException("Placed Feature ID: \"" + jinericID.toString() + "\" already exists in the Placed Features registry!");

      return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, jinericID, new PlacedFeature(RegistryEntry.upcast(feature), List.copyOf(placementModifiers)));
   }
}