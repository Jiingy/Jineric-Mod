package jingy.jineric.item.equipment;

import com.google.common.collect.Maps;
import jingy.jineric.tag.JinericItemTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public class JmArmorMaterials {
	
	//1, 2, 3, 1, 3
	public static final ArmorMaterial WOODEN = new ArmorMaterial(
			6,
			createDefenseMap(2, 2, 3, 3, 3),
			12, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			0.0F, 0.0F,
			JinericItemTags.REPAIRS_WOODEN_ARMOR,
			JmEquipmentAssetKeys.WOOD
	);
	public static final ArmorMaterial EMERALD = new ArmorMaterial(
			6,
			createDefenseMap(2, 2, 3, 3, 3),
			12, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			0.0F, 0.0F,
			JinericItemTags.REPAIRS_EMERALD_ARMOR,
			JmEquipmentAssetKeys.EMERALD
	);
	
	private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
		return Maps.newEnumMap(
				Map.of(
						EquipmentType.BOOTS,
						bootsDefense,
						EquipmentType.LEGGINGS,
						leggingsDefense,
						EquipmentType.CHESTPLATE,
						chestplateDefense,
						EquipmentType.HELMET,
						helmetDefense,
						EquipmentType.BODY,
						bodyDefense
				)
		);
	}
}
