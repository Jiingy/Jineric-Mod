package jingy.jineric.world;

import jingy.jineric.registry.JinericBlocks;
import jingy.jineric.world.biome.JinericBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;

import static jingy.jineric.mixin.access.MaterialRulesDataAccess.jineric$invokesurfaceNoiseThreshold;

public class JinericSurfaceRules extends VanillaSurfaceRules {

   public static final MaterialRules.MaterialCondition WATER_CHECK = MaterialRules.water(-1, 0);

   public static final MaterialRules.MaterialRule FULL_GRASS_BLOCK_SURFACE =
           MaterialRules.sequence(MaterialRules.condition(
                   WATER_CHECK, MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, MaterialRules.block(JinericBlocks.FULL_GRASS_BLOCK.getDefaultState()))),
                   MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRules.block(Blocks.DIRT.getDefaultState())));

   public static final MaterialRules.MaterialRule NOISE_FULL_GRASS_BLOCK = MaterialRules.condition(
           MaterialRules.biome(JinericBiomes.BOREAL_FOREST),
           MaterialRules.condition(jineric$invokesurfaceNoiseThreshold(-0.95D), FULL_GRASS_BLOCK_SURFACE));

   public static final MaterialRules.MaterialRule OVERWORLD_ABOVE_PRELIMINARY_SURFACE = MaterialRules.condition(
           MaterialRules.surface(),
           MaterialRules.sequence(NOISE_FULL_GRASS_BLOCK
           )
   );

   public static final MaterialRules.MaterialRule OVERWORLD_SURFACE_RULES = MaterialRules.sequence(OVERWORLD_ABOVE_PRELIMINARY_SURFACE);



   public static void registerSurfaceRules() {

   }
}
