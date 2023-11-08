package jingy.jineric.block.sign;

import jingy.jineric.block.entity.JinericHangingSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class JinericWallHangingSignBlock extends WallHangingSignBlock {
   public JinericWallHangingSignBlock(Settings settings, WoodType woodType) {
      super(settings, woodType);
   }

   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return new JinericHangingSignBlockEntity(pos, state);
   }
}
