package jingy.jineric.access;

import net.minecraft.stats.RecipeBookSettings;

public interface RecipeBookOptionsAccess {
	//todo: BROKEN IN 1.21.7
//"net/minecraft/class_5411": [
	//           "jingy/jineric/access/RecipeBookOptionsAccess"
	//        ]
	default RecipeBookSettings.TypeSettings jineric_mod$getRefinery() {
		return null;
	}
	
	default RecipeBookSettings.TypeSettings jineric_mod$getCrafting() {
		return null;
	}
	default RecipeBookSettings.TypeSettings jineric_mod$getFurnace() {
		return null;
	}
	default RecipeBookSettings.TypeSettings jineric_mod$getBlastFurnace() {
		return null;
	}
	default RecipeBookSettings.TypeSettings jineric_mod$getSmoker() {
		return null;
	}
}
