package jingy.jineric.block.entity;

import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.RefineryScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class RefineryBlockEntity extends AbstractFurnaceBlockEntity {
   public RefineryBlockEntity(BlockPos blockPos, BlockState state) {
      super(JinericBlockEntityType.REFINERY, blockPos, state, JinericRecipeTypes.REFINING);
   }
   @Override
   protected Text getContainerName() {
      return Text.translatable("container.refinery");
   }

   @Override
   protected int getFuelTime(FuelRegistry fuel, ItemStack stack) {
      return super.getFuelTime(fuel, stack) / 2;
   }

   @Override
   protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
      return new RefineryScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
   }
}
