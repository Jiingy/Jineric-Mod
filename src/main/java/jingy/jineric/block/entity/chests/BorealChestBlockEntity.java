package jingy.jineric.block.entity.chests;

import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BorealChestBlockEntity extends JinericChestBlockEntity {
   public BorealChestBlockEntity(BlockPos blockPos, BlockState blockState) {
      super(JinericChestType.ACACIA, blockPos, blockState);
   }
}
