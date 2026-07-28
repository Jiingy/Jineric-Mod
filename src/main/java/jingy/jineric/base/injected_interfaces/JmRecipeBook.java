package jingy.jineric.base.injected_interfaces;

import jingy.jineric.recipe.book.JmRecipeBookOptions;

public interface JmRecipeBook {
	default JmRecipeBookOptions jineric$getOptions() {
		throw new RuntimeException("getOptions$jineric() did not apply!");
	}
	
	default void jineric$setOptions(JmRecipeBookOptions options) {
		throw new RuntimeException("setOptions$jineric() did not apply!");
	}
}
