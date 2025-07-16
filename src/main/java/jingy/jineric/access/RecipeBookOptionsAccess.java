package jingy.jineric.access;

import net.minecraft.recipe.book.RecipeBookOptions;

public interface RecipeBookOptionsAccess {
	//todo: BROKEN IN 1.21.7
//"net/minecraft/class_5411": [
	//           "jingy/jineric/access/RecipeBookOptionsAccess"
	//        ]
	default RecipeBookOptions.CategoryOption jineric_mod$getRefinery() {
		return null;
	}
	
	default RecipeBookOptions.CategoryOption jineric_mod$getCrafting() {
		return null;
	}
	default RecipeBookOptions.CategoryOption jineric_mod$getFurnace() {
		return null;
	}
	default RecipeBookOptions.CategoryOption jineric_mod$getBlastFurnace() {
		return null;
	}
	default RecipeBookOptions.CategoryOption jineric_mod$getSmoker() {
		return null;
	}
}
