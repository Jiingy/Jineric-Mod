package jingy.jineric.block;

import jingy.jineric.world.gen.feature.configured.JinericUndergroundConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class JmGrassBlock extends GrassBlock implements BonemealableBlock {
	public JmGrassBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
		world.registryAccess()
				.lookup(Registries.CONFIGURED_FEATURE)
				.flatMap(registry -> registry.get(JinericUndergroundConfiguredFeatures.JM_GRASS_BLOCK_PATCH_BONEMEAL))
				.ifPresent(entry -> entry.value().place(world, world.getChunkSource().getGenerator(), random, pos.above()));
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(state, world, pos, random);
	}
}