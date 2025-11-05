package jingy.jineric.data.family;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EquipmentVariants {
	public static final List<EquipmentFamily.Variant> EQUIPMENT_VARIANTS = new ArrayList<>();
	public static final EquipmentFamily.Variant HELMET = register("helmet", true, "MMM", "M M");
	public static final EquipmentFamily.Variant CHESTPLATE = register("chestplate", true, "M M", "MMM", "MMM");
	public static final EquipmentFamily.Variant LEGGINGS = register("leggings", true, "MMM", "M M", "M M");
	public static final EquipmentFamily.Variant BOOTS = register("boots", true, "M M", "M M");
	public static final EquipmentFamily.Variant PICKAXE = register("pickaxe", "MMM", " S ", " S ");
	public static final EquipmentFamily.Variant AXE = register("axe", "MM", "MS", " S");
	public static final EquipmentFamily.Variant SWORD = register("sword", "M", "M", "S");
	public static final EquipmentFamily.Variant SHOVEL = register("shovel", "M", "S", "S");
	public static final EquipmentFamily.Variant HOE = register("hoe", "MM", " S", " S");
	
	public static EquipmentFamily.Variant register(final String name, String... craftingLayout) {
		return register(name, false, craftingLayout);
	}
	
	public static EquipmentFamily.Variant register(final String name, boolean armor, String... craftingLayout) {
		EquipmentFamily.Variant variant = new EquipmentFamily.Variant(name, armor, craftingLayout);
		EQUIPMENT_VARIANTS.add(variant);
		return variant;
	}
	
	public static Stream<EquipmentFamily.Variant> stream() {
		return EQUIPMENT_VARIANTS.stream();
	}
}
