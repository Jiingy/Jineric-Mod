package jingy.jineric.mixin.change;

import jingy.jineric.access.ShapedRecipeJsonBuilderAccess;
import net.minecraft.component.ComponentChanges;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RawShapedRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ShapedRecipeJsonBuilder.class)
public abstract class ShapedRecipeJsonBuilderApplyComponentChangesMixin implements CraftingRecipeJsonBuilder, ShapedRecipeJsonBuilderAccess {
    @Unique private ComponentChanges componentChanges = ComponentChanges.EMPTY;

    @Override
    public ShapedRecipeJsonBuilder jineric$componentChanges(ComponentChanges componentChanges) {
        this.componentChanges = componentChanges;
        return ((ShapedRecipeJsonBuilder)(Object) this);
    }

    @ModifyArg(
            method = "offerTo",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/recipe/ShapedRecipe;<init>(Ljava/lang/String;Lnet/minecraft/recipe/book/CraftingRecipeCategory;Lnet/minecraft/recipe/RawShapedRecipe;Lnet/minecraft/item/ItemStack;Z)V"
            ),
            index = 3
    )
    private ItemStack applyComponentChanges(String group, CraftingRecipeCategory category, RawShapedRecipe raw, ItemStack original, boolean showNotification) {
        if (!componentChanges.isEmpty()) {
			original.applyChanges(this.componentChanges);
        }
        return original;
    }
}
