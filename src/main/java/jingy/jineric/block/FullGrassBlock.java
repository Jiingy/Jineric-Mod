package jingy.jineric.block;

import jingy.jineric.world.gen.feature.JinericUndergroundConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.GrassBlock;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class FullGrassBlock extends GrassBlock implements Fertilizable {
	public FullGrassBlock(Settings settings) {
		super(settings);
	}

	@Override
	public void grow(ServerWorld world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
		world.getRegistryManager()
				.getOptional(RegistryKeys.CONFIGURED_FEATURE)
				.flatMap(registry -> registry.getEntry(JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL))
				.ifPresent(reference -> ((ConfiguredFeature)reference.value()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up()));
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		super.randomTick(state, world, pos, random);
	}
}