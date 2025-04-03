package jingy.jineric.registry;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import jingy.jineric.world.biome.JinericBiomeKeys;
import net.minecraft.world.biome.BiomeKeys;

public class JinericBiomeGeneration {
	
	public static void registerBiomeGeneration() {
		BiomePlacement.replaceOverworld(BiomeKeys.FOREST, JinericBiomeKeys.WISTFUL_FOREST, 0.15D);
		BiomePlacement.replaceOverworld(BiomeKeys.WINDSWEPT_FOREST, JinericBiomeKeys.WISTFUL_FOREST, 0.12D);
		BiomePlacement.replaceOverworld(BiomeKeys.BIRCH_FOREST, JinericBiomeKeys.WISTFUL_FOREST, 0.12D);
	}
}
