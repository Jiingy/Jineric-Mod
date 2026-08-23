package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.KilnBlockEntity;
import jingy.jineric.stat.JinericStats;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class KilnBlock extends AbstractFurnaceBlock {
	public static final MapCodec<KilnBlock> CODEC = simpleCodec(KilnBlock::new);
	
	public KilnBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	public MapCodec<KilnBlock> codec() {
		return CODEC;
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new KilnBlockEntity(pos, state);
	}
	
	@Override
	protected void openContainer(Level world, BlockPos pos, Player player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof KilnBlockEntity kilnBlockEntity) {
			player.openMenu(kilnBlockEntity);
			player.awardStat(JinericStats.INTERACT_WITH_KILN);
		}
	}
}
