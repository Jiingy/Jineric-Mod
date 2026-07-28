package jingy.jineric.base.injected_interfaces;

public interface JmItemStack {
	
	default boolean jineric$isLeveled() {
		throw new RuntimeException("ItemStackAccess.jineric$isLeveled failed");
	}
	
	default boolean jineric$isUpgradable() {
		throw new RuntimeException("ItemStackAccess.jineric$isUpgradable failed");
	}
	
	default void jineric$setLevel(int level) {
		throw new RuntimeException("ItemStackAccess.jineric$getLevel failed");
	}
	
	default int jineric$getLevel() {
		throw new RuntimeException("ItemStackAccess.jineric$getLevel failed");
	}
	
	default int jineric$getMaxLevel() {
		throw new RuntimeException("ItemStackAccess.jineric$getMaxLevel failed");
	}
	
	default int jineric$getRemainingLevel() {
		throw new RuntimeException("ItemStackAccess.jineric$getRemainingLevel failed");
	}
}
