package jingy.jineric.data;

import jingy.jineric.base.JinericMain;
import jingy.jineric.data.generators.*;
import jingy.jineric.data.generators.tag.*;
import jingy.jineric.entity.JinericPaintingVariants;
import jingy.jineric.world.biome.JinericBiomesProvider;
import jingy.jineric.world.gen.feature.configured.JinericConfiguredFeatures;
import jingy.jineric.world.gen.feature.placed.JinericPlacedFeatures;
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
		fabricDataGenPack.addProvider(JinericBiomeTagGen::new);
		fabricDataGenPack.addProvider(JinericBlockLootTableProvider::new);
		fabricDataGenPack.addProvider(JinericBlockTagProvider::new);
		fabricDataGenPack.addProvider(JinericEntityTypeTagProvider::new);
		fabricDataGenPack.addProvider(JinericItemTagProvider::new);
		fabricDataGenPack.addProvider(JinericLanguageProvider::new);
		fabricDataGenPack.addProvider(JinericModelProvider::new);
		fabricDataGenPack.addProvider(JinericPaintingVariantTagProvider::new);
		fabricDataGenPack.addProvider(JinericRecipeProvider::new);
		fabricDataGenPack.addProvider(JinericBuiltRegistryProvider::new);
	}
	
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, JinericPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, JinericBiomesProvider::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PAINTING_VARIANT, JinericPaintingVariants::bootstrap);
	}
	
	@Override
	public String getEffectiveModId() {
		return JinericMain.MOD_ID;
	}
}


