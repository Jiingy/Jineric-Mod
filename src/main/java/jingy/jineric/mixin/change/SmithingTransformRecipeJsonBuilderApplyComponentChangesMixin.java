package jingy.jineric.mixin.change;

import jingy.jineric.access.SmithingTransformRecipeJsonBuilderAccess;
import net.minecraft.component.ComponentChanges;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.TransmuteRecipeResult;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Optional;

@Mixin(SmithingTransformRecipeJsonBuilder.class)
public abstract class SmithingTransformRecipeJsonBuilderApplyComponentChangesMixin implements SmithingTransformRecipeJsonBuilderAccess {
	@Shadow @Final private Item result;
	@Unique private ComponentChanges componentChanges = ComponentChanges.EMPTY;

    @Override
    public SmithingTransformRecipeJsonBuilder jineric$componentChanges(ComponentChanges componentChanges) {
        this.componentChanges = componentChanges;
        return ((SmithingTransformRecipeJsonBuilder)(Object) this);
    }

    @ModifyArg(
            method = "offerTo(Lnet/minecraft/data/recipe/RecipeExporter;Lnet/minecraft/registry/RegistryKey;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/recipe/SmithingTransformRecipe;<init>(Ljava/util/Optional;Lnet/minecraft/recipe/Ingredient;Ljava/util/Optional;Lnet/minecraft/recipe/TransmuteRecipeResult;)V"
            ),
            index = 3
    )
    private TransmuteRecipeResult applyComponentChanges(Optional<Ingredient> template, Ingredient base, Optional<Ingredient> addition, TransmuteRecipeResult original) {
        if (!componentChanges.isEmpty()) {
			return new TransmuteRecipeResult(
					Registries.ITEM.getEntry(this.result), 1, this.componentChanges
			);
        } else {
	        return original;
        }
    }
}
