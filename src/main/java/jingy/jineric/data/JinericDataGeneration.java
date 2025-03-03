package jingy.jineric.data;

import jingy.jineric.base.JinericMain;
import jingy.jineric.data.generators.JinericBlockLootTableProvider;
import jingy.jineric.data.generators.JinericLanguageProvider;
import jingy.jineric.data.generators.JinericModelProvider;
import jingy.jineric.data.generators.JinericRecipeProvider;
import jingy.jineric.data.generators.tag.JinericBlockTagProvider;
import jingy.jineric.data.generators.tag.JinericItemTagProvider;
import jingy.jineric.data.generators.tag.JinericPaintingVariantTagProvider;
import jingy.jineric.data.generators.world.JinericWorldProvider;
import jingy.jineric.entity.JinericPaintingVariants;
import jingy.jineric.world.biome.JinericBiomesProvider;
import jingy.jineric.world.gen.feature.JinericConfiguredFeatures;
import jingy.jineric.world.gen.feature.JinericPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JinericDataGeneration implements DataGeneratorEntrypoint {
	
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
//      FabricDataGenerator.Pack jinericModPack = generator.createBuiltinResourcePack(JinericMain.ofJineric("jineric_mod_pack"));
//      jinericModPack.addProvider(JinericModPackModelGenerator::new);
		FabricDataGenerator.Pack fabricDataGenPack = generator.createPack();
		fabricDataGenPack.addProvider(JinericItemTagProvider::new);
		fabricDataGenPack.addProvider(JinericBlockTagProvider::new);
		fabricDataGenPack.addProvider(JinericPaintingVariantTagProvider::new);
		fabricDataGenPack.addProvider(JinericRecipeProvider::new);
		fabricDataGenPack.addProvider(JinericModelProvider::new);
		fabricDataGenPack.addProvider(JinericBlockLootTableProvider::new);
		fabricDataGenPack.addProvider(JinericWorldProvider::new);
		fabricDataGenPack.addProvider(JinericLanguageProvider::new);
	}
	
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.BIOME, JinericBiomesProvider::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PAINTING_VARIANT, JinericPaintingVariants::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, JinericPlacedFeatures::bootstrap);
	}
	
	@Override
	public String getEffectiveModId() {
		return JinericMain.MOD_ID;
	}
}


