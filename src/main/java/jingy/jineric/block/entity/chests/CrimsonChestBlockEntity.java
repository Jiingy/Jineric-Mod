package jingy.jineric.block.entity.chests;

import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CrimsonChestBlockEntity extends JinericChestBlockEntity {
   public CrimsonChestBlockEntity(BlockPos blockPos, BlockState blockState) {
      super(JinericChestType.CRIMSON, blockPos, blockState);
   }
}
