package jingy.jineric.mixin;

import net.minecraft.item.BundleItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BundleItem.class)
public abstract class BundleItemMixin {
   @Shadow @Final private static int ITEM_BAR_COLOR;
   //TODO: REMOVE, DYABLE BUNDLES ARE VANILLA
//   private static final int ITEM_BAR_COLOR_FULL = MathHelper.packRgb(0.1F, 0.8F, 0.4F);

//   @Inject(
//           method = "getItemBarColor",
//           at = @At("HEAD"),
//           cancellable = true
//   )
//   private void jineric$changeFullBundleBarColor(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
//      if (GetBundleOccupancyAccess.getBundleOccupancy(stack) >= 64) {
//         cir.setReturnValue(ITEM_BAR_COLOR_FULL);
//      }
//   }
}
