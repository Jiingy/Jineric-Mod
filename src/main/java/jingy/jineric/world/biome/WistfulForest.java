package jingy.jineric.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class WistfulForest extends Region {
   public WistfulForest(Identifier name, int weight) {
      super(name, RegionType.OVERWORLD, weight);
   }

   @Override
   public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
      VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
//
//      List<MultiNoiseUtil.NoiseHypercube> params = new ParameterUtils.ParameterPointListBuilder()
//              .temperature(Temperature.NEUTRAL)
//              .humidity(Humidity.NEUTRAL)
//              .continentalness(Continentalness.span(Continentalness.MID_INLAND, Continentalness.INLAND))
//              .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
//              .depth(Depth.SURFACE)
//              .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
//              .build().forEach(point -> builder.add(point, JinericBiomeKeys.WISTFUL_FOREST));
//
//      builder.build();
      this.addBiomeSimilar(mapper, BiomeKeys.FOREST, JinericBiomeKeys.WISTFUL_FOREST);
      this.addBiomeSimilar(mapper, BiomeKeys.FLOWER_FOREST, JinericBiomeKeys.WISTFUL_FLOWER_FOREST);
   }
}
