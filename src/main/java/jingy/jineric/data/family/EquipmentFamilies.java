package jingy.jineric.data.family;

import com.google.common.collect.Lists;
import jingy.jineric.item.JinericItems;
import jingy.jineric.tag.JinericItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.apache.commons.lang3.function.TriConsumer;

import java.util.List;
import java.util.stream.Stream;

public class EquipmentFamilies {
	public static List<EquipmentFamily> FAMILIES = Lists.newArrayList();
	
	public static final EquipmentFamily WOODEN = register(Items.AIR)
			.pickaxe(Items.WOODEN_PICKAXE)
			.axe(Items.WOODEN_AXE)
			.sword(Items.WOODEN_SWORD)
			.shovel(Items.WOODEN_SHOVEL)
			.hoe(Items.WOODEN_HOE)
			.helmet(JinericItems.WOODEN_HELMET)
			.chestplate(JinericItems.WOODEN_CHESTPLATE)
			.leggings(JinericItems.WOODEN_LEGGINGS)
			.boots(JinericItems.WOODEN_BOOTS)
			.upgradeMaterial(Items.STONE)
			.materialTag(ItemTags.PLANKS)
			.skipToolRecipes()
			.build();
	
	public static final EquipmentFamily LEATHER = register(Items.LEATHER)
			.helmet(Items.LEATHER_HELMET)
			.chestplate(Items.LEATHER_CHESTPLATE)
			.leggings(Items.LEATHER_LEGGINGS)
			.boots(Items.LEATHER_BOOTS)
			.genRecipes(false)
			.build();
	
	public static final EquipmentFamily STONE = register(Items.STONE)
			.pickaxe(Items.STONE_PICKAXE)
			.axe(Items.STONE_AXE)
			.sword(Items.STONE_SWORD)
			.shovel(Items.STONE_SHOVEL)
			.hoe(Items.STONE_HOE)
			.materialTag(JinericItemTags.STONE_EQUIPMENT_MATERIALS)
			.build();
	
	public static final EquipmentFamily COPPER = register(Items.COPPER_INGOT)
			.pickaxe(Items.COPPER_PICKAXE)
			.axe(Items.COPPER_AXE)
			.sword(Items.COPPER_SWORD)
			.shovel(Items.COPPER_SHOVEL)
			.hoe(Items.COPPER_HOE)
			.helmet(Items.COPPER_HELMET)
			.chestplate(Items.COPPER_CHESTPLATE)
			.leggings(Items.COPPER_LEGGINGS)
			.boots(Items.COPPER_BOOTS)
			.upgradeMaterial(Items.IRON_INGOT)
			.build();
	
	public static final EquipmentFamily IRON = register(Items.IRON_INGOT)
			.pickaxe(Items.IRON_PICKAXE)
			.axe(Items.IRON_AXE)
			.sword(Items.IRON_SWORD)
			.shovel(Items.IRON_SHOVEL)
			.hoe(Items.IRON_HOE)
			.helmet(Items.IRON_HELMET)
			.chestplate(Items.IRON_CHESTPLATE)
			.leggings(Items.IRON_LEGGINGS)
			.boots(Items.IRON_BOOTS)
			.upgradeMaterial(Items.GOLD_INGOT)
			.build();
	
	public static final EquipmentFamily GOLDEN = register(Items.GOLD_INGOT)
			.pickaxe(Items.GOLDEN_PICKAXE)
			.axe(Items.GOLDEN_AXE)
			.sword(Items.GOLDEN_SWORD)
			.shovel(Items.GOLDEN_SHOVEL)
			.hoe(Items.GOLDEN_HOE)
			.helmet(Items.GOLDEN_HELMET)
			.chestplate(Items.GOLDEN_CHESTPLATE)
			.leggings(Items.GOLDEN_LEGGINGS)
			.boots(Items.GOLDEN_BOOTS)
			.upgradeMaterial(Items.DIAMOND)
			.build();
	
	public static final EquipmentFamily DIAMOND = register(Items.DIAMOND)
			.smithingTemplate(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
			.pickaxe(Items.DIAMOND_PICKAXE)
			.axe(Items.DIAMOND_AXE)
			.sword(Items.DIAMOND_SWORD)
			.shovel(Items.DIAMOND_SHOVEL)
			.hoe(Items.DIAMOND_HOE)
			.helmet(Items.DIAMOND_HELMET)
			.chestplate(Items.DIAMOND_CHESTPLATE)
			.leggings(Items.DIAMOND_LEGGINGS)
			.boots(Items.DIAMOND_BOOTS)
			.upgradeMaterial(Items.NETHERITE_INGOT)
			.genRecipes(false)
			.build();
	
	private static EquipmentFamily.Builder register(Item material) {
		EquipmentFamily.Builder builder = new EquipmentFamily.Builder(material);
		FAMILIES.add(builder.build());
		return builder;
	}
	
	public static Stream<EquipmentFamily> stream() {
		return FAMILIES.stream();
	}
	
	public static void streamVariants(TriConsumer<EquipmentFamily, EquipmentFamily.Variant, Item> consumer) {
		FAMILIES.forEach(family -> family.getVariants().forEach((variant, item) -> consumer.accept(family, variant, item)));
	}
}
