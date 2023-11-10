package jingy.jineric.world.biome;

import jingy.jineric.mixin.access.OverworldBiomeCreatorAccess;
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

   public static Biome createWistfulForest(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup, boolean flower) {
      GenerationSettings.LookupBackedBuilder lookupBackedBuilder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);
      OverworldBiomeCreatorAccess.invokeAddBasicFeatures(lookupBackedBuilder);
      MusicSound musicSound;
      if (flower) {
         musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FLOWER_FOREST);
         lookupBackedBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_FOREST_FLOWERS);
      } else {
         musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FOREST);
         DefaultBiomeFeatures.addForestFlowers(lookupBackedBuilder);
      }

      DefaultBiomeFeatures.addDefaultOres(lookupBackedBuilder);
      DefaultBiomeFeatures.addDefaultDisks(lookupBackedBuilder);
      if (flower) {
         lookupBackedBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_FLOWER_FOREST);
         lookupBackedBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_FLOWER_FOREST);
         DefaultBiomeFeatures.addDefaultGrass(lookupBackedBuilder);
      } else {
         DefaultBiomeFeatures.addDefaultFlowers(lookupBackedBuilder);
         DefaultBiomeFeatures.addForestGrass(lookupBackedBuilder);
      }

      DefaultBiomeFeatures.addDefaultMushrooms(lookupBackedBuilder);
      DefaultBiomeFeatures.addDefaultVegetation(lookupBackedBuilder);
      SpawnSettings.Builder builder = new SpawnSettings.Builder();
      DefaultBiomeFeatures.addFarmAnimals(builder);
      DefaultBiomeFeatures.addBatsAndMonsters(builder);
      if (flower) {
         builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
      } else {
         builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
      }

      return OverworldBiomeCreatorAccess.invokeCreateBiome(true, 0.7F, 0.8F, builder, lookupBackedBuilder, musicSound);
   }
}
