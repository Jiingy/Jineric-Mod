package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.WoodType;
import java.util.function.Supplier;

public class WoodenChestBlock extends ChestBlock {
	public static final MapCodec<WoodenChestBlock> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
					propertiesCodec(),
							WoodType.CODEC.fieldOf("wood_type").forGetter(WoodenChestBlock::getWoodType)
					)
					.apply(instance, WoodenChestBlock::new)
	);
	private final WoodType type;
	
	public WoodenChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityTypeSupplier, Properties settings, WoodType type) {
		super(blockEntityTypeSupplier, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, settings);
		this.type = type;
	}
	
	public WoodenChestBlock(Properties settings, WoodType type) {
		super(() -> BlockEntityTypes.CHEST, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, settings);
		this.type = type;
	}
	
	public WoodType getWoodType() {
		return this.type;
	}
	
	@Override
	protected BlockState updateShape(
			BlockState state, LevelReader world, ScheduledTickAccess tickView,
			BlockPos pos, Direction direction, BlockPos neighborPos,
			BlockState neighborState, RandomSource random
	) {
		BlockState blockState = super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
		if (this.chestCanConnectTo(neighborState)) {
			ChestType chestType = blockState.getValue(ChestBlock.TYPE);
			if (!chestType.equals(ChestType.SINGLE) && getConnectedDirection(blockState) == direction) {
				return neighborState.getBlock().withPropertiesOf(blockState);
			}
		}
		return blockState;
	}
	
	@Override
	protected boolean shouldChangedStateKeepBlockEntity(BlockState state) {
		return state.is(JinericBlockTags.WOODEN_CHESTS);
	}
	
	@Override
	public MapCodec<WoodenChestBlock> codec() {
		return CODEC;
	}
}
