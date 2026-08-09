package jingy.jineric.mixin.change;

import jingy.jineric.base.injected_interfaces.JmSmithingTransformRecipeBuilder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.ItemStackTemplate;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SmithingTransformRecipeBuilder.class)
public abstract class SmithingTransformRecipeBuilderApplyComponentChangesMixin implements JmSmithingTransformRecipeBuilder {
    @Shadow @Final private ItemStackTemplate result;

    @Unique private DataComponentPatch componentChanges = DataComponentPatch.EMPTY;

    @Override
    public SmithingTransformRecipeBuilder jineric$componentChanges(DataComponentPatch componentChanges) {
        this.componentChanges = componentChanges;
        return ((SmithingTransformRecipeBuilder)(Object) this);
    }

    @ModifyArg(
            method = "save(Lnet/minecraft/data/recipes/RecipeOutput;Lnet/minecraft/resources/ResourceKey;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/crafting/SmithingTransformRecipe;<init>(Lnet/minecraft/world/item/crafting/Recipe$CommonInfo;Ljava/util/Optional;Lnet/minecraft/world/item/crafting/Ingredient;Ljava/util/Optional;Lnet/minecraft/world/item/ItemStackTemplate;)V"
            ),
            index = 4
    )
    private ItemStackTemplate applyComponentChanges(ItemStackTemplate result) {
        if (!componentChanges.isEmpty()) {
            return new ItemStackTemplate(this.result.item().value(), this.componentChanges);
        }
        return result;
    }
}
