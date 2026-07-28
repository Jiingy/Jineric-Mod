package jingy.jineric.access;


public interface JmBlockFamily {
	
	default boolean isModded$jineric() {
		return true;
	};
	
	default void setModded$jineric(boolean modded) {}
}
