package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.KilnBlockEntity;
import jingy.jineric.stat.JinericStats;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KilnBlock extends AbstractFurnaceBlock {
	public static final MapCodec<KilnBlock> CODEC = createCodec(KilnBlock::new);
	
	@Override
	public MapCodec<KilnBlock> getCodec() {
		return CODEC;
	}
	
	public KilnBlock(Settings settings) {
		super(settings);
	}
	
	@Override
	protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof KilnBlockEntity kilnBlockEntity) {
			player.openHandledScreen(kilnBlockEntity);
			player.incrementStat(JinericStats.INTERACT_WITH_KILN);
		}
	}
	
	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new KilnBlockEntity(pos, state);
	}
}
