package jingy.jineric.block.entity.custom.chest;

import jingy.jineric.block.entity.custom.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class WarpedChestBlockEntity extends JinericChestBlockEntity {
   public WarpedChestBlockEntity(BlockPos blockPos, BlockState blockState) {
      super(JinericChestType.WARPED, blockPos, blockState);
   }
}
