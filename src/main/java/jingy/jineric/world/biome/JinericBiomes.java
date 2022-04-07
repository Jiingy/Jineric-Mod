package jingy.jineric.world.biome;

import jingy.jineric.base.JinericMain;
import jingy.jineric.util.RegistryObject;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JinericBiomes {

   public static final List<RegistryObject<Biome>> BIOMES = new ArrayList<>();

   public static RegistryKey<Biome> BOREAL_FOREST = createBiome("boreal_forest", JinericOverworldBiomes.BorealForest(false));


   private static RegistryKey<Biome> createBiome(String id, Biome biome) {
      Identifier jinericID = JinericMain.createLocation(id);
      if (BuiltinRegistries.BIOME.getIds().contains(jinericID)) {
         throw new IllegalStateException("Biome ID: \"" + jinericID.toString() + "\"already exists in the Biome Registry!");
      }
      if (JinericMain.BIOMES) {
         BIOMES.add(new RegistryObject<>(biome, id));
      }

      return RegistryKey.of(Registry.BIOME_KEY, jinericID);
   }

   public static Collection<RegistryObject<Biome>> bootStrap() {
      return BIOMES;
   }
}
