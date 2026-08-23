package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.FoundryBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.Util;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class FoundryBlock extends AbstractFurnaceBlock {
	public static final MapCodec<FoundryBlock> CODEC = simpleCodec(FoundryBlock::new);
	public static final VoxelShape FOUNDRY_SHAPE = Util.make(() -> {
				VoxelShape bottom = FoundryBlock.column(14.0, 0, 13.0);
				VoxelShape top = FoundryBlock.column(12.0, 13.0, 16.0);
		return Shapes.or(top, bottom);
	});
	
	protected FoundryBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected MapCodec<FoundryBlock> codec() {
		return CODEC;
	}
	
	@Override
	public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new FoundryBlockEntity(pos, state);
	}
	
	@Override
	protected void openContainer(Level level, BlockPos pos, Player player) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity instanceof FoundryBlockEntity foundryBlockEntity) {
			player.openMenu(foundryBlockEntity);
			player.awardStat(Stats.INTERACT_WITH_BLAST_FURNACE);
		}
	}
	
	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
		return FOUNDRY_SHAPE;
	}
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		return createFurnaceTicker(level, type, JinericBlockEntityType.FOUNDRY);
	}
	
	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(
			Level level, BlockEntityType<T> givenType, BlockEntityType<? extends AbstractFurnaceBlockEntity> expectedType
	) {
		return level instanceof ServerLevel serverWorld
				? createTickerHelper(givenType, expectedType, (worldx, pos, state, blockEntity) -> FoundryBlockEntity.serverTick(serverWorld, pos, state, blockEntity))
				: null;
	}
}
