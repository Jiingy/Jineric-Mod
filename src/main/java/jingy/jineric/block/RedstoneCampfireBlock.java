package jingy.jineric.block;

import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RedstoneCampfireBlock extends CampfireBlock {
	public static final BooleanProperty POWERED = Properties.POWERED;
	
	public RedstoneCampfireBlock(boolean emitsParticles, int fireDamage, Settings settings) {
		super(emitsParticles, fireDamage, settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, Boolean.FALSE));
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING, POWERED);
	}
	
	@Override
	public boolean emitsRedstonePower(BlockState state) {
		return true;
	}
	
	@Override
	public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof RedstoneCampfireBlockEntity redstoneCampfireBlockEntity) {
			if (state.get(POWERED) && state.get(LIT)) {
				return state.get(SIGNAL_FIRE) ? redstoneCampfireBlockEntity.getRedstoneOutput() * 2 : redstoneCampfireBlockEntity.getRedstoneOutput();
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new RedstoneCampfireBlockEntity(pos, state);
	}
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		if (world instanceof ServerWorld serverWorld) {
			if (state.get(LIT)) {
				ServerRecipeManager.MatchGetter<SingleStackRecipeInput, CampfireCookingRecipe> matchGetter = ServerRecipeManager.createCachedMatchGetter(RecipeType.CAMPFIRE_COOKING);
				return validateTicker(
						type,
						JinericBlockEntityType.REDSTONE_CAMPFIRE,
						(worldx, pos, tickerState, blockEntity) -> RedstoneCampfireBlockEntity.litServerTick(serverWorld, pos, tickerState, blockEntity, matchGetter)
				);
			} else {
				return validateTicker(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::unlitServerTick);
			}
		} else {
			return state.get(LIT) ? validateTicker(type, JinericBlockEntityType.REDSTONE_CAMPFIRE, RedstoneCampfireBlockEntity::clientTick) : null;
		}
	}
}
