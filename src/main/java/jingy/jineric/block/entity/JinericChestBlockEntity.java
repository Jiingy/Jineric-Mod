package jingy.jineric.block.entity;

import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.block.WoodType.*;

public class JinericChestBlockEntity extends ChestBlockEntity {
   public JinericChestBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
      super(type, blockPos, blockState);
      this.setInvStackList(DefaultedList.ofSize(this.size(), ItemStack.EMPTY));
   }

   public JinericChestBlockEntity(BlockPos blockPos, BlockState state) {
      super(JinericBlockEntityType.JINERIC_CHEST, blockPos, state);
   }

   @Override
   public int size() {
      return 27;
   }

   public Text getChestTypeKey(WoodType woodType) {
      if (woodType == ACACIA) {
         return Text.translatable("container.chestAcaciaDouble");
      } else if (woodType == BIRCH) {
         return Text.translatable("container.chestBirchDouble");
      } else if (woodType == CRIMSON) {
         return Text.translatable("container.chestCrimsonDouble");
      } else if (woodType == DARK_OAK) {
         return Text.translatable("container.chestDarkOakDouble");
      } else if (woodType == JUNGLE) {
         return Text.translatable("container.chestJungleDouble");
      } else if (woodType == SPRUCE) {
         return Text.translatable("container.chestSpruceDouble");
      } else if (woodType == WARPED) {
         return Text.translatable("container.chestWarpedDouble");
      } else if (woodType == MANGROVE) {
         return Text.translatable("container.chestMangroveDouble");
      } else {
         return Text.literal("No Display Name Set");
      }
   }

   @Override
   protected Text getContainerName() {
      return Text.translatable(getCachedState().getBlock().getTranslationKey());
   }
}
