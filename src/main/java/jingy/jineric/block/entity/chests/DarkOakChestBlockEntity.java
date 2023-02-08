package jingy.jineric.block.entity.chests;

import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class DarkOakChestBlockEntity extends JinericChestBlockEntity {
   public DarkOakChestBlockEntity(BlockPos blockPos, BlockState blockState) {
      super(JinericChestType.DARK_OAK, blockPos, blockState);
   }
}
