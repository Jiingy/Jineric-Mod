package jingy.jineric.mixin.duck.access;


public interface BlockFamilyDuckAccess {
	
	default boolean jineric_mod$isModded() {
		return true;
	};
	
	default void jineric_mod$setModded(boolean modded) {}
}
