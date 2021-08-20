package jingy.jineric.world;

public class JinericWorldGen {

	public static final String MOD_ID = "jineric";

	//BLOCK VEINS
//	public static ConfiguredFeature<?, ?> BORITE_VEIN = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
//			JinericBlocks.BORITE.getDefaultState(), 33)).rangeOf(80).spreadHorizontally().repeat(10);
//
//	public static ConfiguredFeature<?, ?> SLATE_VEIN = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
//			JinericBlocks.SLATE.getDefaultState(), 33)).rangeOf(80).spreadHorizontally().repeat(10);

	public static void init() {
		//BLOCK VEINS
//		RegistryKey<ConfiguredFeature<?, ?>> borite_vein = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(JinericWorldGen.MOD_ID, "borite_vein"));
//		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, borite_vein.getValue(), JinericWorldGen.BORITE_VEIN);
//		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, borite_vein);
//
//		RegistryKey<ConfiguredFeature<?, ?>> slate_vein = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(JinericWorldGen.MOD_ID, "slate_vein"));
//		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, slate_vein.getValue(), JinericWorldGen.SLATE_VEIN);
//		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, slate_vein);
	}
}

