package jingy.jineric.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;
import terrablender.worldgen.RegionUtils;

import java.util.List;
import java.util.function.Consumer;

public class JinericCommonRegion extends Region {
	public JinericCommonRegion(Identifier name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}
	
	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
//		VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
//		new ParameterUtils.ParameterPointListBuilder()
//				.temperature(ParameterUtils.Temperature.NEUTRAL)
//				.humidity(
//						ParameterUtils.Humidity.HUMID,
//						ParameterUtils.Humidity.NEUTRAL
//				)
//				.continentalness(
//						ParameterUtils.Continentalness.INLAND,
//						ParameterUtils.Continentalness.NEAR_INLAND,
//						ParameterUtils.Continentalness.MID_INLAND,
//						ParameterUtils.Continentalness.FAR_INLAND
//				)
//				.erosion(
//						ParameterUtils.Erosion.EROSION_0,
//						ParameterUtils.Erosion.EROSION_1
//				)
//				.depth(ParameterUtils.Depth.SURFACE)
//				.weirdness(ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_VARIANT_DESCENDING)
//				.build().forEach(noiseHypercube -> builder.add(noiseHypercube, JinericBiomeKeys.WISTFUL_FOREST));
//		builder.build().forEach(mapper);
		
//		this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
//			List<MultiNoiseUtil.NoiseHypercube> points = new ParameterUtils.ParameterPointListBuilder()
//				.temperature(ParameterUtils.Temperature.NEUTRAL)
//				.humidity(
//						ParameterUtils.Humidity.HUMID,
//						ParameterUtils.Humidity.NEUTRAL
//				)
//				.continentalness(
//						ParameterUtils.Continentalness.span(
//								ParameterUtils.Continentalness.NEAR_INLAND,
//								ParameterUtils.Continentalness.MID_INLAND
//						),
//						ParameterUtils.Continentalness.span(
//								ParameterUtils.Continentalness.FAR_INLAND,
//								ParameterUtils.Continentalness.INLAND
//						)
//				)
//				.erosion(
//						ParameterUtils.Erosion.EROSION_0,
//						ParameterUtils.Erosion.EROSION_1
//				)
//				.depth(ParameterUtils.Depth.SURFACE)
//				.weirdness(
//						ParameterUtils.Weirdness.VALLEY,
//						ParameterUtils.Weirdness.LOW_SLICE_VARIANT_ASCENDING,
//						ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING,
//						ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_ASCENDING,
//						ParameterUtils.Weirdness.PEAK_VARIANT,
//						ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_DESCENDING,
//						ParameterUtils.Weirdness.MID_SLICE_VARIANT_DESCENDING
//				)
//				.build();
////					.forEach(noiseHypercube -> builder.add(noiseHypercube, JinericBiomeKeys.WISTFUL_FOREST));
//			points.forEach(point -> builder.replaceBiome(point, JinericBiomeKeys.WISTFUL_FOREST));
//		});
	}
}
