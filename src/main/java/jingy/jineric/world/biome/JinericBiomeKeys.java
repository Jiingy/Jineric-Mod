package jingy.jineric.world.biome;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public abstract class JinericBiomeKeys extends BiomeKeys {
   public static final RegistryKey<Biome> BOREAL_FOREST = register("boreal_forest");

   private static RegistryKey<Biome> register(String name) {
      return RegistryKey.of(Registry.BIOME_KEY, new Identifier("jineric", name));
   }
}
