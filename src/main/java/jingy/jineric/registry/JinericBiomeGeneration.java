package jingy.jineric.registry;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import jingy.jineric.world.biome.JinericBiomeKeys;
import net.minecraft.world.biome.BiomeKeys;

public class JinericBiomeGeneration {
	
	public static void registerBiomeGeneration() {
		BiomePlacement.replaceOverworld(BiomeKeys.PLAINS, JinericBiomeKeys.WISTFUL_FOREST, 0.1D);
	}
}
