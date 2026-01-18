package jingy.jineric.mixin;

import jingy.jineric.config.JmConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.TransmuteResult;
import jingy.jineric.component.JmDataComponentTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TransmuteResult.class)
public abstract class TransmuteRecipeResultMixin {
	
	@ModifyArg(//   DATAGEN MIXIN //    No clean way to make datagen create a smithing_transform recipe with a custom component output
			method = "<init>(Lnet/minecraft/world/item/Item;)V",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/item/crafting/TransmuteResult;<init>(Lnet/minecraft/core/Holder;ILnet/minecraft/core/component/DataComponentPatch;)V"
			)
	)
	private static DataComponentPatch modify(Holder<Item> itemEntry, int count, DataComponentPatch components) {
		if (JmConfig.MODE_UPGRADE) {
			if (itemEntry.value().getDefaultInstance().has(JmDataComponentTypes.MAX_LEVEL)) {
				return DataComponentPatch.builder().set(JmDataComponentTypes.LEVEL, 0).build();
			}
		}
		return components;
	}
}
