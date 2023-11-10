package jingy.jineric.data.generators;

import jingy.jineric.world.biome.JinericBiomeKeys;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class JinericBiomeTagGen extends FabricTagProvider<Biome> {
   public JinericBiomeTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
      super(output, RegistryKeys.BIOME, registriesFuture);
   }

   @Override
   protected void configure(RegistryWrapper.WrapperLookup arg) {
      this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(JinericBiomeKeys.WISTFUL_FOREST).add(JinericBiomeKeys.WISTFUL_FLOWER_FOREST);
      this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(JinericBiomeKeys.WISTFUL_FOREST).add(JinericBiomeKeys.WISTFUL_FLOWER_FOREST);
   }
}
