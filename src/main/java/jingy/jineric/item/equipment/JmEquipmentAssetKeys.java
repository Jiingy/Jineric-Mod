package jingy.jineric.item.equipment;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;

public interface JmEquipmentAssetKeys {
	RegistryKey<EquipmentAsset> WOOD = EquipmentAssetKeys.register("wood");
	RegistryKey<EquipmentAsset> OAK_WOOD = EquipmentAssetKeys.register("oak_wood");
	RegistryKey<EquipmentAsset> SPRUCE_WOOD = EquipmentAssetKeys.register("spruce_wood");
	RegistryKey<EquipmentAsset> BIRCH_WOOD = EquipmentAssetKeys.register("birch_wood");
	RegistryKey<EquipmentAsset> JUNGLE_WOOD = EquipmentAssetKeys.register("jungle_wood");
	RegistryKey<EquipmentAsset> ACACIA_WOOD = EquipmentAssetKeys.register("acacia_wood");
	RegistryKey<EquipmentAsset> DARK_OAK_WOOD = EquipmentAssetKeys.register("dark_oak_wood");
	RegistryKey<EquipmentAsset> MANGROVE_WOOD = EquipmentAssetKeys.register("mangrove_wood");
	RegistryKey<EquipmentAsset> CHERRY_WOOD = EquipmentAssetKeys.register("cherry_wood");
	RegistryKey<EquipmentAsset> PALE_OAK_WOOD = EquipmentAssetKeys.register("pale_oak_wood");
	RegistryKey<EquipmentAsset> BAMBOO_WOOD = EquipmentAssetKeys.register("bamboo_wood");
	RegistryKey<EquipmentAsset> CRIMSON_WOOD = EquipmentAssetKeys.register("crimson_wood");
	RegistryKey<EquipmentAsset> WARPED_WOOD = EquipmentAssetKeys.register("warped_wood");
	RegistryKey<EquipmentAsset> EMERALD = EquipmentAssetKeys.register("emerald");
	
	static RegistryKey<EquipmentAsset> parseWoodenKey(String woodType) {
		RegistryKey<EquipmentAsset> assetKey;
		switch (woodType) {
			case "oak" -> assetKey = JmEquipmentAssetKeys.OAK_WOOD;
			case "spruce" -> assetKey = JmEquipmentAssetKeys.SPRUCE_WOOD;
			case "birch" -> assetKey = JmEquipmentAssetKeys.BIRCH_WOOD;
			case "jungle" -> assetKey = JmEquipmentAssetKeys.JUNGLE_WOOD;
			case "acacia" -> assetKey = JmEquipmentAssetKeys.ACACIA_WOOD;
			case "dark_oak" -> assetKey = JmEquipmentAssetKeys.DARK_OAK_WOOD;
			case "mangrove" -> assetKey = JmEquipmentAssetKeys.MANGROVE_WOOD;
			case "cherry" -> assetKey = JmEquipmentAssetKeys.CHERRY_WOOD;
			case "pale_oak" -> assetKey = JmEquipmentAssetKeys.PALE_OAK_WOOD;
			case "bamboo" -> assetKey = JmEquipmentAssetKeys.BAMBOO_WOOD;
			case "crimson" -> assetKey = JmEquipmentAssetKeys.CRIMSON_WOOD;
			case "warped" -> assetKey = JmEquipmentAssetKeys.WARPED_WOOD;
			default -> assetKey = JmEquipmentAssetKeys.WOOD;
		}
		return assetKey;
	}
}