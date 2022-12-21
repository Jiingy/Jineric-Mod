package jingy.jineric.block;

import net.minecraft.block.Fertilizable;
import net.minecraft.block.GrassBlock;

public class FullGrassBlock extends GrassBlock implements Fertilizable {
	public FullGrassBlock(Settings settings) {
		super(settings);
	}

//	@Override
//	public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
//		return world.getBlockState(pos.up()).isAir();
//	}

//	@Override
//	public void grow(ServerWorld world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
//		((ConfiguredFeature) JinericUndergroundConfiguredFeatures.FULL_GRASS_PATCH_BONEMEAL.value())
//				.generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up());
//	}
}