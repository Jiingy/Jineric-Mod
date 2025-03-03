package jingy.jineric.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class JinericForestRegion extends Region {
	public JinericForestRegion(Identifier name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}
	
	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
		VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
		new ParameterUtils.ParameterPointListBuilder()
				.temperature(ParameterUtils.Temperature.NEUTRAL)
				.humidity(ParameterUtils.Humidity.HUMID, ParameterUtils.Humidity.NEUTRAL)
				.continentalness(ParameterUtils.Continentalness.INLAND,
						ParameterUtils.Continentalness.NEAR_INLAND,
						ParameterUtils.Continentalness.MID_INLAND,
						ParameterUtils.Continentalness.FAR_INLAND)
				.erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1)
				.depth(ParameterUtils.Depth.SURFACE)
				.weirdness(ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_VARIANT_DESCENDING)
				.build().forEach(noiseHypercube -> builder.add(noiseHypercube, JinericBiomeKeys.WISTFUL_FOREST));
		builder.build().forEach(mapper);
		
		
//		this.addBiomeSimilar(mapper, BiomeKeys.FLOWER_FOREST, JinericBiomeKeys.WISTFUL_FLOWER_FOREST);
//		this.addBiomeSimilar(mapper, BiomeKeys.FOREST, JinericBiomeKeys.WISTFUL_FOREST);
	}
}
