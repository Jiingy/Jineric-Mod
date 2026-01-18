package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.RefineryBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.stat.JinericStats;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class RefineryBlock extends AbstractFurnaceBlock {
	public static final MapCodec<RefineryBlock> CODEC = simpleCodec(RefineryBlock::new);
	
	public RefineryBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected MapCodec<RefineryBlock> codec() {
		return CODEC;
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
		return new RefineryBlockEntity(blockPos, state);
	}
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		return RefineryBlock.createFurnaceTicker(level, type, JinericBlockEntityType.REFINERY);
	}
	
	@Override
	protected void openContainer(Level world, BlockPos pos, Player player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof RefineryBlockEntity) {
			player.openMenu((MenuProvider) blockEntity);
			player.awardStat(JinericStats.INTERACT_WITH_REFINERY);
		}
	}
	
	@Override
	public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
		if (state.getValue(LIT)) {
			double d = (double) pos.getX() + 0.5;
			double e = (double) pos.getY();
			double f = (double) pos.getZ() + 0.5;
			if (random.nextDouble() < 0.1) {
				world.playLocalSound(d, e, f, SoundEvents.BLASTFURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
			}
			
			Direction direction = state.getValue(FACING);
			Direction.Axis axis = direction.getAxis();
			double g = 0.52;
			double h = random.nextDouble() * 0.6 - 0.3;
			double i = axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52 : h;
			double j = random.nextDouble() * 9.0 / 16.0;
			double k = axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52 : h;
			world.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0, 0.0, 0.0);
			world.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, 0.0, 0.0, 0.0);
		}
	}
}
