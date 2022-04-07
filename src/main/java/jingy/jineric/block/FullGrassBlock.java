package jingy.jineric.block;

import jingy.jineric.world.feature.JinericUndergroundConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.GrassBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class FullGrassBlock extends GrassBlock implements Fertilizable {
	public FullGrassBlock(Settings settings) {
		super(settings);
	}

	@Override
	public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
		return world.getBlockState(pos.up()).isAir();
	}

	@Override
	public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		((ConfiguredFeature) JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL.value())
				.generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up());
	}
}