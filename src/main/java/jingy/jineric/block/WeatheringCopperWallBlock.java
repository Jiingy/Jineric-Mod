package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperWallBlock extends WallBlock implements WeatheringCopper {
    public static final MapCodec<WeatheringCopperWallBlock> MAP_CODEC = RecordCodecBuilder.mapCodec(
            x -> x.group(WeatheringCopper.WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringCopperWallBlock::getAge), propertiesCodec())
                    .apply(x, WeatheringCopperWallBlock::new)
    );
    private final WeatherState weatherState;

    //  TODO: 26.2 - Requires MapCodec type of "WallBlock" but from my understanding the codec is not necessary yet
//    @Override
//    public MapCodec<WeatheringCopperWallBlock> codec() {
//        return MAP_CODEC;
//    }

    public WeatheringCopperWallBlock(final WeatheringCopper.WeatherState weatherState, final BlockBehaviour.Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, level, pos, random);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
