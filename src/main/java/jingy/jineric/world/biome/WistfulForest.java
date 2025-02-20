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

import java.util.function.Consumer;

public class WistfulForest extends Region {
	public WistfulForest(Identifier name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}
	
	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
//      VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
		this.addBiomeSimilar(mapper, BiomeKeys.FOREST, JinericBiomeKeys.WISTFUL_FOREST);
		this.addBiomeSimilar(mapper, BiomeKeys.FLOWER_FOREST, JinericBiomeKeys.WISTFUL_FLOWER_FOREST);
	}
}
