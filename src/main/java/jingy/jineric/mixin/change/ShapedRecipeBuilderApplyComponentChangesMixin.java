package jingy.jineric.mixin.change;

import jingy.jineric.access.JmShapedRecipeBuilder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ShapedRecipeBuilder.class)
public abstract class ShapedRecipeBuilderApplyComponentChangesMixin implements RecipeBuilder, JmShapedRecipeBuilder {
    @Unique private DataComponentPatch componentChanges = DataComponentPatch.EMPTY;

    @Override
    public ShapedRecipeBuilder jineric$componentChanges(DataComponentPatch componentChanges) {
        this.componentChanges = componentChanges;
        return ((ShapedRecipeBuilder)(Object) this);
    }

    @ModifyArg(
            method = "save",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/crafting/ShapedRecipe;<init>(Ljava/lang/String;Lnet/minecraft/world/item/crafting/CraftingBookCategory;Lnet/minecraft/world/item/crafting/ShapedRecipePattern;Lnet/minecraft/world/item/ItemStack;Z)V"
            ),
            index = 3
    )
    private ItemStack applyComponentChanges(String group, CraftingBookCategory category, ShapedRecipePattern raw, ItemStack original, boolean showNotification) {
        if (!componentChanges.isEmpty()) {
			original.applyComponentsAndValidate(this.componentChanges);
        }
        return original;
    }
}
