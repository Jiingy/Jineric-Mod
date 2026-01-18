package jingy.jineric.item.equipment;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public interface JmEquipmentAssetKeys {
	ResourceKey<EquipmentAsset> WOOD = EquipmentAssets.createId("wood");
	ResourceKey<EquipmentAsset> OAK_WOOD = EquipmentAssets.createId("oak_wood");
	ResourceKey<EquipmentAsset> SPRUCE_WOOD = EquipmentAssets.createId("spruce_wood");
	ResourceKey<EquipmentAsset> BIRCH_WOOD = EquipmentAssets.createId("birch_wood");
	ResourceKey<EquipmentAsset> JUNGLE_WOOD = EquipmentAssets.createId("jungle_wood");
	ResourceKey<EquipmentAsset> ACACIA_WOOD = EquipmentAssets.createId("acacia_wood");
	ResourceKey<EquipmentAsset> DARK_OAK_WOOD = EquipmentAssets.createId("dark_oak_wood");
	ResourceKey<EquipmentAsset> MANGROVE_WOOD = EquipmentAssets.createId("mangrove_wood");
	ResourceKey<EquipmentAsset> CHERRY_WOOD = EquipmentAssets.createId("cherry_wood");
	ResourceKey<EquipmentAsset> PALE_OAK_WOOD = EquipmentAssets.createId("pale_oak_wood");
	ResourceKey<EquipmentAsset> BAMBOO_WOOD = EquipmentAssets.createId("bamboo_wood");
	ResourceKey<EquipmentAsset> CRIMSON_WOOD = EquipmentAssets.createId("crimson_wood");
	ResourceKey<EquipmentAsset> WARPED_WOOD = EquipmentAssets.createId("warped_wood");
	ResourceKey<EquipmentAsset> EMERALD = EquipmentAssets.createId("emerald");
	
	static ResourceKey<EquipmentAsset> parseWoodenKey(String woodType) {
		ResourceKey<EquipmentAsset> assetKey;
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