package net.jineric.jineric_mod.registry;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

@Environment(EnvType.CLIENT)
public class JinericColorProviders extends BlockColors {

	public static void registerColorProviders() {
		BlockColorRegistry.register(
				List.of(jmGrassBlock()), JinericBlocks.GRASS_BLOCK
		);

		BlockColorRegistry.register(
				List.of(
						BlockTintSources.grass()
				),
				JinericBlocks.JUNGLE_LADDER
		);
	}

	public static BlockTintSource jmGrassBlock() {
		return new BlockTintSource() {
			@Override
			public int color(final BlockState state) {
				return GrassColor.getDefaultColor();
			}

			@Override
			public int colorInWorld(final BlockState state, final BlockAndTintGetter level, final BlockPos pos) {
				return BiomeColors.getAverageGrassColor(level, pos);
			}

			@Override
			public int colorAsTerrainParticle(final BlockState state, final BlockAndTintGetter level, final BlockPos pos) {
				return BiomeColors.getAverageGrassColor(level, pos);
			}
		};
	}
}
