package jingy.jineric.block;

import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class RedstoneCampfireBlock extends CampfireBlock {
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	
	public RedstoneCampfireBlock(boolean emitsParticles, int fireDamage, Properties settings) {
		super(emitsParticles, fireDamage, settings);
		this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, Boolean.FALSE));
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING, POWERED);
	}
	
	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}
	
	@Override
	public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof RedstoneCampfireBlockEntity redstoneCampfireBlockEntity) {
			if (state.getValue(POWERED) && state.getValue(LIT)) {
				return state.getValue(SIGNAL_FIRE) ? redstoneCampfireBlockEntity.getRedstoneOutput() * 2 : redstoneCampfireBlockEntity.getRedstoneOutput();
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new RedstoneCampfireBlockEntity(pos, state);
	}
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
		if (world instanceof ServerLevel serverWorld) {
			if (state.getValue(LIT)) {
				RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> matchGetter = RecipeManager.createCheck(RecipeType.CAMPFIRE_COOKING);
				return createTickerHelper(
						type,
						JinericBlockEntityType.REDSTONE_CAMPFIRE,
						(worldx, pos, tickerState, blockEntity) -> RedstoneCampfireBlockEntity.cookTick(serverWorld, pos, tickerState, blockEntity, matchGetter)
				);
			} else {
				return createTickerHelper(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::cooldownTick);
			}
		} else {
			return state.getValue(LIT) ? createTickerHelper(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::particleTick) : null;
		}
	}
}
