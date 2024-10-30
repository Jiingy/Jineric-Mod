package jingy.jineric.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.JinericRecipeTypes;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientRecipeBook.class)
public abstract class ClientRecipeBookMixin {
   //TODO: CODE IS DRAMATICALLY CHANGED IN 1.21.3, SUPER BROKEN
//   @Unique private static final RecipeBookGroup JINERIC_REFINERY_BUILDING = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_BUILDING");
//   @Unique private static final RecipeBookGroup JINERIC_REFINERY_MISC = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_MISC");

//   @Inject(
//           method = "getGroupForRecipe",
//           at = @At(
//                   value = "FIELD",
//                   target = "Lnet/minecraft/recipe/RecipeType;SMELTING:Lnet/minecraft/recipe/RecipeType;"),
//           cancellable = true
//   )
//   private static void jineric$addRefineryGroupForRecipe(RecipeEntry<?> recipe, CallbackInfoReturnable<RecipeBookGroup> cir) {
//      Recipe<?> recipe2 = recipe.value();
//      RecipeType<?> recipeType = recipe2.getType();
//      if (recipe2 instanceof AbstractCookingRecipe) {
//         AbstractCookingRecipe abstractCookingRecipe = (AbstractCookingRecipe)recipe2;
//         CookingRecipeCategory cookingRecipeCategory = abstractCookingRecipe.getCategory();
//         if (recipeType == JinericRecipeTypes.REFINING) {
//            if (cookingRecipeCategory == CookingRecipeCategory.BLOCKS) {
//               cir.setReturnValue(JINERIC_REFINERY_BUILDING);
//            } else {
//               cir.setReturnValue(JINERIC_REFINERY_MISC);
//            }
//         }
//      }
//   }
}
