package jingy.jineric.access;


public interface BlockFamilyDuckAccess {
	
	default boolean jineric_mod$isModded() {
		return true;
	};
	
	default void jineric_mod$setModded(boolean modded) {}
}
