package jingy.jineric.mixin.access;

import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BundleItem.class)
public interface GetBundleOccupancyAccess {
   @Invoker("getBundleOccupancy")
   static int getBundleOccupancy(ItemStack stack) {
      throw new AssertionError();
   }
}
