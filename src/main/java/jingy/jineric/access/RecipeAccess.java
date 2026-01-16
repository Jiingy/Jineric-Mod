package jingy.jineric.access;

public interface RecipeAccess {
	default int jineric$getInputCount() {
		throw new RuntimeException();
	}
}
