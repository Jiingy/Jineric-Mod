package jingy.jineric.mixin;

import jingy.jineric.mixin.access.GetBundleOccupancyAccess;
import net.minecraft.item.BundleItem;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleItem.class)
public abstract class BundleItemMixin implements DyeableItem {
   @Shadow @Final private static int ITEM_BAR_COLOR;
   private static final int ITEM_BAR_COLOR_FULL = MathHelper.packRgb(0.1F, 0.8F, 0.4F);

   @Inject(
           method = "getItemBarColor",
           at = @At("HEAD"),
           cancellable = true
   )
   private void jineric$changeFullBundleBarColor(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
      if (GetBundleOccupancyAccess.getBundleOccupancy(stack) >= 64) {
         cir.setReturnValue(ITEM_BAR_COLOR_FULL);
      }
   }
}
