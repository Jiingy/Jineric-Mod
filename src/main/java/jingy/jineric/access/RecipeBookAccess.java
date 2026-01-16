package jingy.jineric.access;

import jingy.jineric.recipe.book.JmRecipeBookOptions;

public interface RecipeBookAccess {
	default JmRecipeBookOptions jineric$getOptions() {
		throw new RuntimeException("getOptions$jineric() did not apply!");
	}
	
	default void jineric$setOptions(JmRecipeBookOptions options) {
		throw new RuntimeException("setOptions$jineric() did not apply!");
	}
}
