package jingy.jineric.mixin;

import jingy.jineric.config.JmConfig;
import jingy.jineric.component.JmDataComponentTypes;
import net.minecraft.component.ComponentChanges;
import net.minecraft.item.Item;
import net.minecraft.recipe.TransmuteRecipeResult;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TransmuteRecipeResult.class)
public abstract class TransmuteRecipeResultMixin {
	
	@ModifyArg(//   DATAGEN MIXIN //    No clean way to make datagen create a smithing_transform recipe with a custom component output
			method = "<init>(Lnet/minecraft/item/Item;)V",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/recipe/TransmuteRecipeResult;<init>(Lnet/minecraft/registry/entry/RegistryEntry;ILnet/minecraft/component/ComponentChanges;)V"
			)
	)
	private static ComponentChanges modify(RegistryEntry<Item> itemEntry, int count, ComponentChanges components) {
		if (JmConfig.MODE_UPGRADE) {
			if (itemEntry.value().getDefaultStack().contains(JmDataComponentTypes.MAX_LEVEL)) {
				return ComponentChanges.builder().add(JmDataComponentTypes.LEVEL, 0).build();
			}
		}
		return components;
	}
}
