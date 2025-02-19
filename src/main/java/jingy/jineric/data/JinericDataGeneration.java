package jingy.jineric.data;

import jingy.jineric.base.JinericMain;
import jingy.jineric.data.generators.*;
import jingy.jineric.data.generators.world.JinericWorldProvider;
import jingy.jineric.entity.JinericPaintingVariants;
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
   }

   @Override
   public void buildRegistry(RegistryBuilder registryBuilder) {
      registryBuilder.addRegistry(RegistryKeys.PAINTING_VARIANT, JinericPaintingVariants::bootstrap);
      registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, JinericWorldProvider::bootstrap);
   }

   @Override
   public String getEffectiveModId() {
      return JinericMain.MOD_ID;
   }
}


