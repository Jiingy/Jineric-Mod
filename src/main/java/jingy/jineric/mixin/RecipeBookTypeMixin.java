package jingy.jineric.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.JinericRecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookGroup;
import net.minecraft.recipe.book.RecipeBookType;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(net.minecraft.client.recipebook.RecipeBookType.class)
public abstract class RecipeBookTypeMixin implements RecipeBookGroup {
   @Shadow @Final private List<RecipeBookCategory> categories;

   private static final net.minecraft.client.recipebook.RecipeBookType JINERIC_REFINERY = ClassTinkerers.getEnum(net.minecraft.client.recipebook.RecipeBookType.class, "JINERIC_REFINERY");


   @Inject(method = "getCategories", at = @At("HEAD"), cancellable = true)
      private void addRefineryToCategories(CallbackInfoReturnable<List<RecipeBookCategory>> cir) {
//      if (RecipeBookType == JINERIC_REFINERY)
//      this.categories.add(RecipeBook)
//         cir.setReturnValue(this.categories);
      }
}
