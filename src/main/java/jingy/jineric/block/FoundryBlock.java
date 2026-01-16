package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.FoundryBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FoundryBlock extends AbstractFurnaceBlock {
	public static final MapCodec<FoundryBlock> CODEC = createCodec(FoundryBlock::new);
	public static final VoxelShape FOUNDRY_SHAPE = Util.make(() -> {
				VoxelShape bottom = FoundryBlock.createColumnShape(14.0, 0, 13.0);
				VoxelShape top = FoundryBlock.createColumnShape(12.0, 13.0, 16.0);
		return VoxelShapes.union(top, bottom);
	});
	
	protected FoundryBlock(Settings settings) {
		super(settings);
	}
	
	@Override
	protected MapCodec<FoundryBlock> getCodec() {
		return CODEC;
	}
	
	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new FoundryBlockEntity(pos, state);
	}
	
	@Override
	protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof FoundryBlockEntity foundryBlockEntity) {
			player.openHandledScreen(foundryBlockEntity);
			player.incrementStat(Stats.INTERACT_WITH_BLAST_FURNACE);
		}
	}
	
	@Override
	protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return FOUNDRY_SHAPE;
	}
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return validateTicker(world, type, JinericBlockEntityType.FOUNDRY);
	}
	
	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> validateTicker(
			World world, BlockEntityType<T> givenType, BlockEntityType<? extends AbstractFurnaceBlockEntity> expectedType
	) {
		return world instanceof ServerWorld serverWorld
				? validateTicker(givenType, expectedType, (worldx, pos, state, blockEntity) -> FoundryBlockEntity.tick(serverWorld, pos, state, blockEntity))
				: null;
	}
}
