package jingy.jineric.block.entity;

import jingy.jineric.block.enums.JinericChestType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class JinericChestBlockEntity extends ChestBlockEntity {
   private final JinericChestType type;

   public JinericChestBlockEntity(JinericChestType type, BlockPos blockPos, BlockState blockState) {
      super(type.getBlockEntityType(), blockPos, blockState);
      this.type = type;
      this.setInvStackList(DefaultedList.ofSize(this.size(), ItemStack.EMPTY));
   }

   public JinericChestType getChestType() {
      return type;
   }

   @Override
   public int size() {
      return type.size;
   }

   public Text getChestTypeKey() {
      return switch (getChestType()) {
         case ACACIA -> Text.translatable("container.chestAcaciaDouble");
         case BIRCH -> Text.translatable("container.chestBirchDouble");
         case CRIMSON -> Text.translatable("container.chestCrimsonDouble");
         case DARK_OAK -> Text.translatable("container.chestDarkOakDouble");
         case JUNGLE -> Text.translatable("container.chestJungleDouble");
         case SPRUCE -> Text.translatable("container.chestSpruceDouble");
         case WARPED -> Text.translatable("container.chestWarpedDouble");
         case MANGROVE -> Text.translatable("container.chestMangroveDouble");
         case SHULKER -> null;
      };
   }

   @Override
   protected Text getContainerName() {
      return Text.translatable(getCachedState().getBlock().getTranslationKey());
   }
}
