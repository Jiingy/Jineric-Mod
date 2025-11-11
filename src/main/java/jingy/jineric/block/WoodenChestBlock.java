package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.function.Supplier;

public class WoodenChestBlock extends ChestBlock {
	public static final MapCodec<WoodenChestBlock> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
					createSettingsCodec(),
							WoodType.CODEC.fieldOf("wood_type").forGetter(WoodenChestBlock::getWoodType)
					)
					.apply(instance, WoodenChestBlock::new)
	);
	private final WoodType type;
	
	public WoodenChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityTypeSupplier, Settings settings, WoodType type) {
		super(blockEntityTypeSupplier, SoundEvents.BLOCK_CHEST_OPEN, SoundEvents.BLOCK_CHEST_CLOSE, settings);
		this.type = type;
	}
	
	public WoodenChestBlock(Settings settings, WoodType type) {
		super(() -> BlockEntityType.CHEST, SoundEvents.BLOCK_CHEST_OPEN, SoundEvents.BLOCK_CHEST_CLOSE, settings);
		this.type = type;
	}
	
	public WoodType getWoodType() {
		return this.type;
	}
	
	@Override
	protected BlockState getStateForNeighborUpdate(
			BlockState state, WorldView world, ScheduledTickView tickView,
			BlockPos pos, Direction direction, BlockPos neighborPos,
			BlockState neighborState, Random random
	) {
		BlockState blockState = super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
		if (this.canMergeWith(neighborState)) {
			ChestType chestType = blockState.get(ChestBlock.CHEST_TYPE);
			if (!chestType.equals(ChestType.SINGLE) && getFacing(blockState) == direction) {
				return neighborState.getBlock().getStateWithProperties(blockState);
			}
		}
		return blockState;
	}
	
	@Override
	protected boolean keepBlockEntityWhenReplacedWith(BlockState state) {
		return state.isIn(JinericBlockTags.WOODEN_CHESTS);
	}
	
	@Override
	public MapCodec<WoodenChestBlock> getCodec() {
		return CODEC;
	}
}
