package jingy.jineric.data;

import jingy.jineric.base.JinericMain;
import jingy.jineric.data.generators.*;
import jingy.jineric.entity.JinericPaintingVariants;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JinericDataGeneration implements DataGeneratorEntrypoint {

   @Override
   public void onInitializeDataGenerator(FabricDataGenerator generator) {
      FabricDataGenerator.Pack jinericModPack = generator.createBuiltinResourcePack(JinericMain.ofJineric("jineric_mod_pack"));
      jinericModPack.addProvider(JinericModPackModelGenerator::new);
      FabricDataGenerator.Pack fabricDataGenPack = generator.createPack();
      fabricDataGenPack.addProvider(JinericItemTagGenerator::new);
      fabricDataGenPack.addProvider(JinericBlockTagGenerator::new);
      fabricDataGenPack.addProvider(JinericRecipeGenerator::new);
      fabricDataGenPack.addProvider(JinericModelGenerator::new);
      fabricDataGenPack.addProvider(JinericBlockLootTableGenerator::new);
//      fabricDataGenPack.addProvider(JinericWorldGenerator::new);
//      fabricDataGenPack.addProvider(JinericBiomeTagGen::new);
   }

   @Override
   public void buildRegistry(RegistryBuilder registryBuilder) {
      //TODO: FIX FEATURES, NOT WORKING RIGHT NOW
//      registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericWorldGenerator::bootstrap);
//      registryBuilder.addRegistry(RegistryKeys.BIOME, JinericBiomes::bootstrap);
//      registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, JinericPlacedFeatures::bootstrap);
      //TODO: PAINTINGS MOVED TO DATA GEN, NO LONGER WORK
      registryBuilder.addRegistry(RegistryKeys.PAINTING_VARIANT, JinericPaintingVariants::bootstrap);
   }

   @Override
   public String getEffectiveModId() {
      return JinericMain.MOD_ID;
   }
}


