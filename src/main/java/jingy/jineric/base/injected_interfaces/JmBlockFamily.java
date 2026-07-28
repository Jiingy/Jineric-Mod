package jingy.jineric.base.injected_interfaces;


public interface JmBlockFamily {
	
	default boolean isModded$jineric() {
		return true;
	};
	
	default void setModded$jineric(boolean modded) {}
}
