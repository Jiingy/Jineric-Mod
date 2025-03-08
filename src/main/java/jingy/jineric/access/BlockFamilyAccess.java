package jingy.jineric.access;


public interface BlockFamilyAccess {
	
	default boolean isModded$jineric() {
		return true;
	};
	
	default void setModded$jineric(boolean modded) {}
}
