package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.KilnBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.stat.JinericStats;
import jingy.jineric.world.level.block.state.properties.Deterioration;
import jingy.jineric.world.level.block.state.properties.JmBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

public class KilnBlock extends AbstractFurnaceBlock {
	public static final MapCodec<KilnBlock> CODEC = simpleCodec(KilnBlock::new);
	public static final EnumProperty<Deterioration> DETERIORATION = JmBlockStateProperties.DETERIORATION;

	public KilnBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new KilnBlockEntity(pos, state);
	}

	@Override
	public @org.jspecify.annotations.Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
		return createFurnaceTicker(level, type, JinericBlockEntityType.KILN);
	}

	@Override
	protected void openContainer(Level world, BlockPos pos, Player player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof KilnBlockEntity kilnBlockEntity) {
			player.openMenu(kilnBlockEntity);
			player.awardStat(JinericStats.INTERACT_WITH_KILN);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(DETERIORATION);
		super.createBlockStateDefinition(builder);
	}

	public static @Nullable BlockState damage(final BlockState blockState) {
		return switch (blockState.getValue(DETERIORATION)) {
			case NONE -> blockState.setValue(DETERIORATION, Deterioration.CHIPPED);
			case CHIPPED -> blockState.setValue(DETERIORATION, Deterioration.CRACKED);
			case CRACKED -> blockState.setValue(DETERIORATION, Deterioration.SHATTERED);
			case SHATTERED -> null;
		};
	}

	@Override
	public MapCodec<KilnBlock> codec() {
		return CODEC;
	}
}
