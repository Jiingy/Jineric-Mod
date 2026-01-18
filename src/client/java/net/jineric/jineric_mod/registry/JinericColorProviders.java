package net.jineric.jineric_mod.registry;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.block.JmGrassBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;

@Environment(EnvType.CLIENT)
public class JinericColorProviders {
	
	public static void registerColorProviders() {
		// BLOCKS
		ColorProviderRegistry.BLOCK.register(
				((state, world, pos, tintIndex) -> {
					boolean snowy = state.getValue(JmGrassBlock.SNOWY);
					if (world != null && pos != null) {
						if (snowy) {
							return tintIndex > 0 ? -1 : BiomeColors.getAverageGrassColor(world, pos);
						} else {
							return tintIndex > 0 ? 1 : BiomeColors.getAverageGrassColor(world, pos);
						}
					} else {
						return GrassColor.get(0.5D, 1.0D);
					}
				}), JinericBlocks.GRASS_BLOCK
		);
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
				world != null && pos != null
						? BiomeColors.getAverageGrassColor(world, pos)
						: GrassColor.get(0.5D, 1.0D), JinericBlocks.JUNGLE_LADDER
		);
	}
}
