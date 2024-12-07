package jingy.jineric.registry;

import jingy.jineric.block.FullGrassBlock;
import jingy.jineric.block.JinericBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.world.biome.GrassColors;

//TODO: SEPARATE INTO BLOCK AND ITEM VARIANT CLASSES
@Environment(EnvType.CLIENT)
public class JinericColorProviders {

   public static void registerColorProviders() {
      // BLOCKS
      ColorProviderRegistry.BLOCK.register(
              ((state, world, pos, tintIndex) -> {
                 boolean snowy = state.get(FullGrassBlock.SNOWY);
                 if (world != null && pos != null) {
                    if (snowy) {
                       return tintIndex > 0 ? -1 : BiomeColors.getGrassColor(world, pos);
                    } else {
                       return tintIndex > 0 ? 1 : BiomeColors.getGrassColor(world, pos);
                    }
                 } else {
                    return GrassColors.getColor(0.5D, 1.0D);
                 }
              }), JinericBlocks.FULL_GRASS_BLOCK
      );
      ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
              world != null && pos != null
                      ? BiomeColors.getGrassColor(world, pos)
                      : GrassColors.getColor(0.5D, 1.0D), JinericBlocks.JUNGLE_LADDER);
      // ITEMS
      //TODO 1.21.4: COLORS ARE NOW ADDED VIA DATA GEN?
//      ColorProviderRegistry.ITEM.register(((stack, tintIndex) ->
//              GrassColors.getColor(0.5D, 1.0D)), JinericItems.FULL_GRASS_BLOCK);
//      ColorProviderRegistry.ITEM.register((((stack, tintIndex) ->
//              tintIndex > 0 ? -1 : GrassColors.getColor(0.5D, 1.0D))), JinericItems.JUNGLE_LADDER);
   }
}
