package jingy.jineric.block.sign;

import jingy.jineric.block.entity.JinericSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class JinericSignBlock extends SignBlock {
   public JinericSignBlock(Settings settings, WoodType woodType) {
      super(woodType, settings);
   }

   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return new JinericSignBlockEntity(pos, state);
   }
}
