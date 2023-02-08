package jingy.jineric.block.entity.chests;

import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class SpruceChestBlockEntity extends JinericChestBlockEntity {
   public SpruceChestBlockEntity(BlockPos blockPos, BlockState blockState) {
      super(JinericChestType.SPRUCE, blockPos, blockState);
   }
}
