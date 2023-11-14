package jingy.jineric.data;

import jingy.jineric.base.JinericMain;
import jingy.jineric.data.generators.*;
import jingy.jineric.data.generators.world.JinericWorldGenerator;
import jingy.jineric.world.biome.JinericBiomes;
import jingy.jineric.world.gen.feature.JinericConfiguredFeatures;
import jingy.jineric.world.gen.feature.JinericPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JinericDataGeneration implements DataGeneratorEntrypoint {

   @Override
   public void onInitializeDataGenerator(FabricDataGenerator generator) {
      FabricDataGenerator.Pack fabricDataGenPack = generator.createPack();
      fabricDataGenPack.addProvider(JinericBlockLootTableGenerator::new);
      fabricDataGenPack.addProvider(JinericItemTagGenerator::new);
      fabricDataGenPack.addProvider(JinericBlockTagGenerator::new);
      fabricDataGenPack.addProvider(JinericModelGenerator::new);
      fabricDataGenPack.addProvider(JinericWorldGenerator::new);
      fabricDataGenPack.addProvider(JinericGeneratedRecipes::new);
      fabricDataGenPack.addProvider(JinericBiomeTagGen::new);
   }

   @Override
   public void buildRegistry(RegistryBuilder registryBuilder) {
      registryBuilder
              .addRegistry(RegistryKeys.BIOME, JinericBiomes::bootstrap)
              .addRegistry(RegistryKeys.PLACED_FEATURE, JinericPlacedFeatures::bootstrap)
              .addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericConfiguredFeatures::bootstrap)
      ;
   }

   @Override
   public String getEffectiveModId() {
      return JinericMain.MOD_ID;
   }
}


