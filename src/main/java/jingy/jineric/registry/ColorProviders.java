package jingy.jineric.registry;

import jingy.jineric.block.FullGrassBlock;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Items;

public class ColorProviders {

   public static void register() {
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
              world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getColor(0.5D, 1.0D), JinericBlocks.JUNGLE_LADDER
      );

      ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
              world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getColor(0.5D, 1.0D), JinericBlocks.PETRIFIED_OAK_LEAVES
      );

      ColorProviderRegistry.ITEM.register(((stack, tintIndex) ->
              GrassColors.getColor(0.5D, 1.0D)), JinericItems.FULL_GRASS_BLOCK
      );
      ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
              GrassColors.getColor(1.0D, 1.0D), JinericItems.PETRIFIED_OAK_LEAVES
      );
      ColorProviderRegistry.ITEM.register(((stack, tintIndex) ->
              tintIndex > 0 ? -1 : GrassColors.getColor(0.5D, 1.0D)), JinericItems.JUNGLE_LADDER);
      ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableItem)stack.getItem()).getColor(stack), Items.BUNDLE
      );
   }
}
