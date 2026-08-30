package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.CharcoalPileBlockEntity;
import jingy.jineric.stat.JinericStats;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class CharcoalPileBlock extends AbstractFurnaceBlock {
    public static final MapCodec<CharcoalPileBlock> MAP_CODEC = simpleCodec(CharcoalPileBlock::new);

    public CharcoalPileBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends AbstractFurnaceBlock> codec() {
        return MAP_CODEC;
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CharcoalPileBlockEntity charcoalPileBlockEntity) {
            player.openMenu(charcoalPileBlockEntity);
            player.awardStat(JinericStats.INTERACT_WITH_CHARCOAL_PILE);
        }
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        //new CharcoalPileBlockEntity(worldPosition, blockState, JinericRecipeTypes.FOUNDRY_SMELTING)
        return null;
    }
}
