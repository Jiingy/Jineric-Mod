package jingy.jineric.base.injected_interfaces;

public interface JmCampfireBlockEntity {
	
	default int jineric$getCookingTime(int index) {
		throw new RuntimeException("Failed to apply!");
	}
	
	default int[] jineric$getCookingTimes() {
		throw new RuntimeException("Failed to apply!");
	}
	
	default void jineric$setCookingTimes(int time) {
		throw new RuntimeException("Failed to apply!");
	}
	
	default void jineric$setCookingTime(int index, int cookingTimes) {
		throw new RuntimeException("Failed to apply!");
	}
	
	default int jineric$getCookingTotalTime(int index) {
		throw new RuntimeException("Failed to apply!");
	}
	
	default int[] jineric$getCookingTotalTimes() {
		throw new RuntimeException("Failed to apply!");
	}
	
	default void jineric$setCookingTotalTimes(int time) {
		throw new RuntimeException("Failed to apply!");
	}
	
	default void jineric$setCookingTotalTime(int index, int cookingTotalTimes) {
		throw new RuntimeException("Failed to apply!");
	}
}
