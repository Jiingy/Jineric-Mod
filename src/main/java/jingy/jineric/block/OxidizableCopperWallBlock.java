package jingy.jineric.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class OxidizableCopperWallBlock extends WallBlock implements WeatheringCopper {
	private final WeatheringCopper.WeatherState oxidationLevel;
	
	public OxidizableCopperWallBlock(WeatheringCopper.WeatherState oxidationLevel, Properties settings) {
		super(settings);
		this.oxidationLevel = oxidationLevel;
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		this.changeOverTime(state, world, pos, random);
	}
	
	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return WeatheringCopper.getNext(state.getBlock()).isPresent();
	}
	
	public WeatheringCopper.WeatherState getAge() {
		return this.oxidationLevel;
	}
}
