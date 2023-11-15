package jingy.jineric.world.biome;

import jingy.jineric.mixin.access.OverworldBiomeCreatorAccess;
import jingy.jineric.world.gen.feature.JinericVegetationPlacedFeatures;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class JinericOverworldBiomeCreator extends OverworldBiomeCreator {

   public static Biome create() {
      return new Biome.Builder().build();
   }

   public static Biome createWistfulForest(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup, boolean flower) {
      GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);
      OverworldBiomeCreatorAccess.invokeAddBasicFeatures(builder);
      MusicSound musicSound;
      if (flower) {
         musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FLOWER_FOREST);
         builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_FOREST_FLOWERS);
      } else {
         musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FOREST);
         DefaultBiomeFeatures.addForestFlowers(builder);
      }

      DefaultBiomeFeatures.addDefaultOres(builder);
      DefaultBiomeFeatures.addDefaultDisks(builder);
      if (flower) {
         builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_FLOWER_FOREST);
         builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_FLOWER_FOREST);
         DefaultBiomeFeatures.addDefaultGrass(builder);
         DefaultBiomeFeatures.addPlainsTallGrass(builder);
      } else {
         builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.TREES_WISTFUL_FOREST);
         DefaultBiomeFeatures.addDefaultFlowers(builder);
         DefaultBiomeFeatures.addForestGrass(builder);
         DefaultBiomeFeatures.addPlainsTallGrass(builder);
      }

      DefaultBiomeFeatures.addDefaultMushrooms(builder);
      builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.CARVED_PUMPKIN_PATCH);
      builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_SUGAR_CANE);

      SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
      DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
      DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
      if (flower) {
         spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
      } else {
         spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
      }

//      return OverworldBiomeCreatorAccess.invokeCreateBiome(true, 0.7F, 0.8F, spawnBuilder, builder, musicSound);
      return OverworldBiomeCreatorAccess.invokeCreateBiome(true, 0.7F, 0.8F, 1201651, 921191, 8310072, 8310072, spawnBuilder, builder, musicSound);
   }
}
