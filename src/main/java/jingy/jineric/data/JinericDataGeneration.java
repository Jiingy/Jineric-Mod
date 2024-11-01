package jingy.jineric.data;

import jingy.jineric.base.JinericMain;
import jingy.jineric.data.generators.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

public class JinericDataGeneration implements DataGeneratorEntrypoint {

   @Override
   public void onInitializeDataGenerator(FabricDataGenerator generator) {
      FabricDataGenerator.Pack fabricDataGenPack = generator.createPack();
//      fabricDataGenPack.addProvider(JinericGeneratedRecipes::new);
      fabricDataGenPack.addProvider(JinericModelGenerator::new);
      fabricDataGenPack.addProvider(JinericBlockLootTableGenerator::new);
      fabricDataGenPack.addProvider(JinericItemTagGenerator::new);
//      fabricDataGenPack.addProvider(JinericWorldGenerator::new);
   }

   @Override
   public void buildRegistry(RegistryBuilder registryBuilder) {
      //TODO: BROKEN IN 1.21.3
//      registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericWorldGenerator::bootstrap);
//      registryBuilder.addRegistry(RegistryKeys.PAINTING_VARIANT, JinericPaintingVariants::bootstrap);
   }

   @Override
   public String getEffectiveModId() {
      return JinericMain.MOD_ID;
   }
}


