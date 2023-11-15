package jingy.jineric.block.entity;

import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class JinericHangingSignBlockEntity extends HangingSignBlockEntity {
   public JinericHangingSignBlockEntity(BlockPos pos, BlockState state) {
      super(pos, state);
   }

   @Override
   public BlockEntityType<?> getType() {
      return JinericBlockEntityType.JINERIC_HANGING_SIGN;
   }
}
