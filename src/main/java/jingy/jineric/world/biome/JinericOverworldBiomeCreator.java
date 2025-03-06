package jingy.jineric.world.biome;

import jingy.jineric.mixin.access.OverworldBiomeCreatorAccess;
import jingy.jineric.world.gen.feature.placed.JinericVegetationPlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.MusicType;
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
	
	public static Biome createWistfulForest(
			RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup
	) {
		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
		spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);
		DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
		
		MusicSound musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FOREST);
		
		OverworldBiomeCreatorAccess.invokeAddBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.TREES_WISTFUL_FOREST);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.PATCH_ROSE);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.PATCH_ROSES);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.PATCH_BLOSSOMED_DANDELION);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addJungleGrass(builder);
		DefaultBiomeFeatures.addPlainsTallGrass(builder);
		
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, JinericVegetationPlacedFeatures.CARVED_PUMPKIN_PATCH);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_SUGAR_CANE);
		
		
		return OverworldBiomeCreatorAccess.invokeCreateBiome(
				true,
				0.7F,
				0.8F,
				1201651,
				921191,
				7649089,
				7649089,
				spawnBuilder, builder, musicSound
		);
	}
}
