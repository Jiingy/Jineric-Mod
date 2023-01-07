package jingy.jineric.world.biome;

import jingy.jineric.world.feature.JinericTreePlacedFeature;
import jingy.jineric.world.gen.JinericDefaultBiomeFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.jetbrains.annotations.Nullable;

public class JinericOverworldBiomes extends OverworldBiomeCreator {

   @Nullable
   private static final MusicSound DEFAULT_MUSIC = null;

   private static Biome createBiome(
           Biome.Precipitation precipitation,
           float temperature,
           float downfall,
           SpawnSettings.Builder spawnSettings,
           GenerationSettings.Builder generationSettings,
           @Nullable MusicSound music
   ) {
      return createBiome(precipitation, temperature, downfall, 4159204, 329011, spawnSettings, generationSettings, music);
   }

   private static Biome createBiome(
           Biome.Precipitation precipitation,
           float temperature,
           float downfall,
           int waterColor,
           int waterFogColor,
           SpawnSettings.Builder spawnSettings,
           GenerationSettings.Builder generationSettings,
           @Nullable MusicSound music
   ) {
      return (new Biome.Builder())
              .precipitation(precipitation)
              .temperature(temperature)
              .downfall(downfall)
              .effects(
                      (new BiomeEffects.Builder())
                              .waterColor(waterColor)
                              .waterFogColor(waterFogColor)
                              .fogColor(12638463)
//                              .grassColor(0x27a361)
                              .skyColor(getSkyColor(temperature))
                              .moodSound(BiomeMoodSound.CAVE)
                              .music(music)
                              .build()
              )
              .spawnSettings(spawnSettings.build())
              .generationSettings(generationSettings.build())
              .build();
   }

   //TODO: FIX
   private static void addBasicFeatures(GenerationSettings.Builder builder) {
//      DefaultBiomeFeatures.addLandCarvers(builder);
//      DefaultBiomeFeatures.addAmethystGeodes(builder);
//      DefaultBiomeFeatures.addDungeons(builder);
//      DefaultBiomeFeatures.addMineables(builder);
//      DefaultBiomeFeatures.addSprings(builder);
//      DefaultBiomeFeatures.addFrozenTopLayer(builder);
   }

   public static Biome createBorealForest(boolean cold) {
      SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
      DefaultBiomeFeatures.addFarmAnimals(spawnSettings);

      spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 8, 4, 4))
              .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 4, 2, 3));
      DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);
      float f = cold ? -0.5F : 0.25F;

      GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
      addBasicFeatures(generationSettings);
      JinericDefaultBiomeFeatures.addForestFlowers(generationSettings);
//      DefaultBiomeFeatures.addDefaultOres(generationSettings);
//      DefaultBiomeFeatures.addDefaultDisks(generationSettings);
//      DefaultBiomeFeatures.addDefaultGrass(generationSettings);
//      DefaultBiomeFeatures.addDefaultVegetation(generationSettings);
      JinericTreePlacedFeature.addBorealTrees(generationSettings);

//      if (cold) {
//         DefaultBiomeFeatures.addTaigaGrass(generationSettings);
//      } else {
//         DefaultBiomeFeatures.addSweetBerryBushes(generationSettings);
//      }

      //return createBiome()
              //.precipitation(Biome.Precipitation.RAIN)
              //.category(Biome.Category.TAIGA)
              //.temperature(cold ? 0.25F : 0.3F)
              //.downfall(0.8F)
             // .effects((new BiomeEffects.Builder())
                      //.waterColor(4159204)
                     // .waterFogColor(329011)
                     // .fogColor(12638463)
                    //  .skyColor(getSkyColor(0.8F))
                     // .moodSound(BiomeMoodSound.CAVE)
                    //  .build()).spawnSettings(spawnSettings.build())
           //   .generationSettings(generationSettings.build());


      return createBiome(
              cold ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN,
              f,
              cold ? 0.4F : 0.8F,
              cold ? 4020182 : 4159204,
              329011,
              spawnSettings,
              generationSettings,
              DEFAULT_MUSIC
      );
   }
}
