package jingy.jineric.access;

import jingy.jineric.server.network.JmServerRecipeBook;

public interface ServerPlayerEntityAccess {
	default JmServerRecipeBook jineric$getRecipeBook() {
		throw new RuntimeException();
	}
	
	default void jineric$setRecipeBook(JmServerRecipeBook serverRecipeBook) {
		throw new RuntimeException();
	}
}
