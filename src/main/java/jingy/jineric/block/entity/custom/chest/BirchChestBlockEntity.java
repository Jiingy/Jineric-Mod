package jingy.jineric.block.entity.custom.chest;

import jingy.jineric.block.entity.custom.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BirchChestBlockEntity extends JinericChestBlockEntity {
   public BirchChestBlockEntity(BlockPos blockPos, BlockState blockState) {
      super(JinericChestType.BIRCH, blockPos, blockState);
   }
}