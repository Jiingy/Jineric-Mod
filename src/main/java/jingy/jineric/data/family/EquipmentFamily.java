package jingy.jineric.data.family;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipmentFamily {
	private final Map<Variant, Item> variants = new HashMap<>();
	private final Map<Item, List<String>> patterns = new HashMap<>();
	private final Map<Item, Boolean> generateRecipe = new HashMap<>();
	
	private final Item material;
	private Item upgradeMaterial;
	private Item smithingTemplate;
	private boolean genRecipes = true;
	private boolean skipToolRecipes = false;
	private TagKey<Item> materialTag;
	
	public EquipmentFamily(Item material) {
		this.material = material;
	}
	
	public Map<Variant, Item> getVariants() {
		return variants;
	}
	
	public Item getMaterial() {
		return material;
	}
	
	public Item getSmithingTemplate() {
		return smithingTemplate;
	}
	
	public Item getVariantItem(Variant variant) {
		return this.variants.get(variant);
	}
	
	public Item getUpgradeMaterial() {
		return this.upgradeMaterial;
	}
	
	public TagKey<Item> getMaterialTag() {
		return materialTag;
	}
	
	public boolean genRecipes() {
		return genRecipes;
	}
	
	public boolean skipToolRecipes() {
		return skipToolRecipes;
	}
	
	public static class Builder {
		public final EquipmentFamily equipmentFamily;
		
		public Builder(Item material) {
			this.equipmentFamily = new EquipmentFamily(material);
		}
		
		public final Builder smithingTemplate(Item smithingTemplate) {
			this.equipmentFamily.smithingTemplate = smithingTemplate;
			return this;
		}
		
		public final Builder upgradeMaterial(Item upgradeMaterial) {
			this.equipmentFamily.upgradeMaterial = upgradeMaterial;
			return this;
		}
		
		public final Builder materialTag(TagKey<Item> materials) {
			this.equipmentFamily.materialTag = materials;
			return this;
		}
		
		public final Builder genRecipes(boolean canGenerate) {
			this.equipmentFamily.genRecipes = canGenerate;
			return this;
		}
		
		public final Builder skipToolRecipes() {
			this.equipmentFamily.skipToolRecipes = true;
			return this;
		}
		
		public final Builder pickaxe(Item pickaxe) {
			this.equipmentFamily.variants.put(EquipmentVariants.PICKAXE, pickaxe);
			return this;
		}
		
		public final Builder axe(Item axe) {
			this.equipmentFamily.variants.put(EquipmentVariants.AXE, axe);
			return this;
		}
		
		public final Builder sword(Item sword) {
			this.equipmentFamily.variants.put(EquipmentVariants.SWORD, sword);
			return this;
		}
		
		public final Builder shovel(Item shovel) {
			this.equipmentFamily.variants.put(EquipmentVariants.SHOVEL, shovel);
			return this;
		}
		
		public final Builder hoe(Item hoe) {
			this.equipmentFamily.variants.put(EquipmentVariants.HOE, hoe);
			return this;
		}
		
		public final Builder helmet(Item helmet) {
			this.equipmentFamily.variants.put(EquipmentVariants.HELMET, helmet);
			return this;
		}
		
		public final Builder chestplate(Item chestplate) {
			this.equipmentFamily.variants.put(EquipmentVariants.CHESTPLATE, chestplate);
			return this;
		}
		
		public final Builder leggings(Item leggings) {
			this.equipmentFamily.variants.put(EquipmentVariants.LEGGINGS, leggings);
			return this;
		}
		
		public final Builder boots(Item boots) {
			this.equipmentFamily.variants.put(EquipmentVariants.BOOTS, boots);
			return this;
		}
		
		public final EquipmentFamily build() {
			return this.equipmentFamily;
		}
	}
	
	public static class Variant {
		private final String name;
		private final boolean armor;
		private final List<String> craftingLayout;
		
		public Variant(final String name, boolean armor, String... craftingLayout) {
			this.name = name;
			this.armor = armor;
			this.craftingLayout = List.of(craftingLayout);
		}
		
		public RecipeCategory variantCategory() {
			if (this.isArmor()) {
				return RecipeCategory.COMBAT;
			} else {
				return RecipeCategory.TOOLS;
			}
		}
		
		public EquipmentSlot equipmentSlot(Variant variant) {
			EquipmentSlot equipmentSlot;
			switch (variant.toString()) {
				case "helmet" -> equipmentSlot = EquipmentSlot.HEAD;
				case "chestplate" -> equipmentSlot = EquipmentSlot.CHEST;
				case "leggings" -> equipmentSlot = EquipmentSlot.LEGS;
				case "boots" -> equipmentSlot = EquipmentSlot.FEET;
				case "body" -> equipmentSlot = EquipmentSlot.BODY;
				case "saddle" -> equipmentSlot = EquipmentSlot.SADDLE;
				default -> equipmentSlot = EquipmentSlot.MAINHAND;
			}
			return equipmentSlot;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public List<String> getCraftingLayout() {
			return this.craftingLayout;
		}
		
		public boolean isArmor() {
			return this.armor;
		}
	}
}
