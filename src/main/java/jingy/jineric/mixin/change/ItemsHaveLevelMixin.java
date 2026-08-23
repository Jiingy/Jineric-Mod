package jingy.jineric.mixin.change;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.config.JmConfig;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Items.class)
public abstract class ItemsHaveLevelMixin {

	@WrapOperation(
			method = "<clinit>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/Item$Properties;durability(I)Lnet/minecraft/world/item/Item$Properties;"
			)
	)
	private static Item.Properties changeDurabilityToLevel(Item.Properties instance, int maxDamage, Operation<Item.Properties> original) {
		if (JmConfig.MODE_UPGRADE && JmConfig.UPGRADE_EQUIPMENT) {
			return instance.jineric$maxLevel(maxDamage);
		}
		return original.call(instance, maxDamage);
	}
}
