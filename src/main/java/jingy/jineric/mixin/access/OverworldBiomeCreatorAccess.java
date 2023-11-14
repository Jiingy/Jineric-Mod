package jingy.jineric.mixin.access;

import net.minecraft.sound.MusicSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(OverworldBiomeCreator.class)
public interface OverworldBiomeCreatorAccess {

   @Invoker("addBasicFeatures")
   static void invokeAddBasicFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
      throw new IllegalStateException("Could not invoke addBasicFeatures() in OverworldBiomeCreator!");
   }

   @Invoker("createBiome")
   static Biome invokeCreateBiome(boolean precipitation, float temperature, float downfall, int waterColor, int waterFogColor, @Nullable Integer grassColor, @Nullable Integer foliageColor, SpawnSettings.Builder spawnSettings, GenerationSettings.LookupBackedBuilder generationSettings, @Nullable MusicSound music) {
      throw new IllegalStateException("Could not invoke createBiome() in OverworldBiomeCreator!");
   }
}
