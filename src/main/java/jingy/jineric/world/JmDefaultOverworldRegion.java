//package jingy.jineric.world;
//
//import net.minecraft.util.Identifier;
//import terrablender.api.Region;
//import terrablender.api.RegionType;
//
//public class JmDefaultOverworldRegion extends Region {
//
//   public JmDefaultOverworldRegion(Identifier name, int weight) {
//      super(name, RegionType.OVERWORLD, weight);
//   }
//
//   //TODO: FIX
//   @Override
//   public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
//      this.addBiomeSimilar(mapper, BiomeKeys.TAIGA, JinericBiomeKeys.BOREAL_FOREST);
//   }
//
// SURFACE RULES
//   @Override
//   public Optional<SurfaceRuleManager.RuleCategory> getOverworldSurfaceRules() {
//      return Optional.of(JinericSurfaceRuleData)
//   }
//
//
//   public static void init() {
//
//   }
//}
