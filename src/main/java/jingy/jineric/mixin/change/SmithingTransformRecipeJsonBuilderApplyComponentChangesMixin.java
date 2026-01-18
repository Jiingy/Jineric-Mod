package jingy.jineric.mixin.change;

import jingy.jineric.access.SmithingTransformRecipeJsonBuilderAccess;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.TransmuteResult;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Optional;

@Mixin(SmithingTransformRecipeBuilder.class)
public abstract class SmithingTransformRecipeJsonBuilderApplyComponentChangesMixin implements SmithingTransformRecipeJsonBuilderAccess {
	@Shadow @Final private Item result;
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
                    target = "Lnet/minecraft/world/item/crafting/SmithingTransformRecipe;<init>(Ljava/util/Optional;Lnet/minecraft/world/item/crafting/Ingredient;Ljava/util/Optional;Lnet/minecraft/world/item/crafting/TransmuteResult;)V"
            ),
            index = 3
    )
    private TransmuteResult applyComponentChanges(Optional<Ingredient> template, Ingredient base, Optional<Ingredient> addition, TransmuteResult original) {
        if (!componentChanges.isEmpty()) {
			return new TransmuteResult(
					BuiltInRegistries.ITEM.wrapAsHolder(this.result), 1, this.componentChanges
			);
        } else {
	        return original;
        }
    }
}
