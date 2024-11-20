package jingy.jineric.block.entity;

import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class JinericChestBlockEntity extends ChestBlockEntity {

   public JinericChestBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
      super(type, blockPos, blockState);
   }

   public JinericChestBlockEntity(BlockPos blockPos, BlockState state) {
      this(JinericBlockEntityType.JINERIC_CHEST, blockPos, state);
   }

   public Text getChestTypeKey(WoodType woodType) {
      return Text.translatable("container.chest_" + woodType.name() + "_double");
   }

   @Override
   protected Text getContainerName() {
      return Text.translatable(getCachedState().getBlock().getTranslationKey());
   }
}
