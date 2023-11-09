package jingy.jineric.data;

import jingy.jineric.base.JinericMain;
import jingy.jineric.data.generators.*;
import jingy.jineric.data.generators.world.JinericWorldGenerator;
import jingy.jineric.world.feature.JinericTreeConfiguredFeatures;
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
   }

   @Override
   public void buildRegistry(RegistryBuilder registryBuilder) {
      registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericWorldGenerator::bootstrap).addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericTreeConfiguredFeatures::bootstrap);
   }

   @Override
   public String getEffectiveModId() {
      return JinericMain.MOD_ID;
   }
}


