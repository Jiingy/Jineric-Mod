package jingy.jineric.block.entity.custom.chest;

import jingy.jineric.block.entity.custom.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BorealChestBlockEntity extends JinericChestBlockEntity {
   public BorealChestBlockEntity(BlockPos blockPos, BlockState blockState) {
      //TODO: FIX WHEN READDING BOREAL

      super(JinericChestType.ACACIA, blockPos, blockState);
   }
}
