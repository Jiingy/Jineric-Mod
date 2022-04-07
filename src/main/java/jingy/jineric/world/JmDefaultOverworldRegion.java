package jingy.jineric.world;

import com.mojang.datafixers.util.Pair;
import jingy.jineric.world.biome.JinericBiomeKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class JmDefaultOverworldRegion extends Region {

   public JmDefaultOverworldRegion(Identifier name, int weight) {
      super(name, RegionType.OVERWORLD, weight);
   }

   @Override
   public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
      this.addBiomeSimilar(mapper, BiomeKeys.TAIGA, JinericBiomeKeys.BOREAL_FOREST);
   }

/* SURFACE RULES
   @Override
   public Optional<SurfaceRuleManager.RuleCategory> getOverworldSurfaceRules() {
      return Optional.of(JinericSurfaceRuleData.)
   }
*/

   public static void init() {

   }
}
