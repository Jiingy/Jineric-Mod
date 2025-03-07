package jingy.jineric.world.biome;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;

public class JinericBiomeKeys {
	public static final RegistryKey<Biome> WISTFUL_FOREST = register("wistful_forest");
	
	private static RegistryKey<Biome> register(String id) {
		return RegistryKey.of(RegistryKeys.BIOME, JinericMain.ofJineric(id));
	}
	
	public static void initialize() {
	}
}
