package jingy.jineric.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.LuckEnchantment;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {

   @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
   private void jineric$allowOnMoreItems(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
      //Allows for LuckEnchantment to be put on more items
      if ((Enchantment)(Object)this instanceof LuckEnchantment) {
         if (stack.isOf(Items.BOW)
                 || stack.isOf(Items.CROSSBOW)
                 || stack.isOf(Items.TRIDENT)
                 || stack.getItem() instanceof AxeItem){
            cir.setReturnValue(true);
         }
      }
   }
}
