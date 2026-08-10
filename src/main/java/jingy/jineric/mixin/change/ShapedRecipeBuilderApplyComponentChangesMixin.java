package jingy.jineric.mixin.change;

import jingy.jineric.base.injected_interfaces.JmShapedRecipeBuilder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStackTemplate;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ShapedRecipeBuilder.class)
public abstract class ShapedRecipeBuilderApplyComponentChangesMixin implements RecipeBuilder, JmShapedRecipeBuilder {
    @Shadow @Final private ItemStackTemplate result;
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
                    target = "Lnet/minecraft/world/item/crafting/ShapedRecipe;<init>(Lnet/minecraft/world/item/crafting/Recipe$CommonInfo;Lnet/minecraft/world/item/crafting/CraftingRecipe$CraftingBookInfo;Lnet/minecraft/world/item/crafting/ShapedRecipePattern;Lnet/minecraft/world/item/ItemStackTemplate;)V"
            ),
            index = 3
    )
    private ItemStackTemplate applyComponentChanges(ItemStackTemplate result) {
        if (!componentChanges.isEmpty()) {
            return new ItemStackTemplate(this.result.item().value(), this.componentChanges);
        }
        return result;
    }
}
