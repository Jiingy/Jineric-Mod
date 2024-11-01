package jingy.jineric.mixin;

import jingy.jineric.data.generators.JinericItemTagGenerator;
import jingy.jineric.recipe.JinericRecipeSerializer;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CookingRecipeJsonBuilder.class)
public abstract class CookingRecipeJsonBuilderMixin implements CraftingRecipeJsonBuilder {

    @Inject(method = "getCookingRecipeCategory", at = @At(value = "HEAD"), cancellable = true)
    private static void addRefiningCategory(RecipeSerializer<? extends AbstractCookingRecipe> serializer, ItemConvertible output, CallbackInfoReturnable<CookingRecipeCategory> cir) {
        if (serializer == JinericRecipeSerializer.REFINING) {
            cir.setReturnValue(getRefiningRecipeCategory(output));
        } else {
            cir.setReturnValue(CookingRecipeCategory.FOOD);
        }
    }

    @Unique
    private static CookingRecipeCategory getRefiningRecipeCategory(ItemConvertible output) {
        return !output.asItem().getDefaultStack().isIn(JinericItemTagGenerator.REFINING_MISC) && output.asItem() instanceof BlockItem
                ? CookingRecipeCategory.BLOCKS
                : CookingRecipeCategory.MISC;
    }
}
