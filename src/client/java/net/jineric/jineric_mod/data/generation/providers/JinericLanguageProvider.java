package net.jineric.jineric_mod.data.generation.providers;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.EquipmentFamilies;
import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.loader.impl.util.StringUtil;
import net.minecraft.block.Block;
import net.minecraft.block.WoodType;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import org.apache.commons.lang3.text.WordUtils;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class JinericLanguageProvider extends FabricLanguageProvider {
	public JinericLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder builder) {
		this.tryExisting(builder);
		//Blocks
		this.addBlockFamilies(builder);
		this.addWoodenEquipmentFamilies(builder);
		builder.add(JinericBlocks.SOUL_JACK_O_LANTERN, "Soul Jack o'Lantern");
		builder.add(JinericBlocks.SUGAR_BLOCK, "Block of Sugar");
		builder.add(JinericBlocks.ROTTEN_FLESH_BLOCK, "Block of Rotten Flesh");
		builder.add(JinericBlocks.FLINT_BLOCK, "Block of Flint");
		builder.add(JinericBlocks.CHARCOAL_BLOCK, "Block of Charcoal");
		builder.add(JinericBlocks.STICK_BLOCK, "Bundle of Sticks");
		builder.add(JinericBlocks.PAPER_BLOCK, "Stack of Paper");
		builder.add(JinericBlocks.FULL_GRASS_BLOCK, "Full Grass Block");
		builder.add(JinericBlocks.BONE_MEAL_BLOCK, "Block of Bone Meal");
		builder.add(JinericBlocks.EGG_BLOCK, "Batch of Eggs");
		builder.add(JinericBlocks.ENDER_PEARL_BLOCK, "Block of Ender Pearls");
		builder.add(JinericBlocks.BLAZE_ROD_BLOCK, "Bundle of Blaze Rods");
		builder.add(JinericBlocks.REDSTONE_LANTERN, "Redstone Lantern");
		builder.add(JinericBlocks.REDSTONE_CAMPFIRE, "Redstone Campfire");
		builder.add(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK, "Sea Crystal Block");
		builder.add(JinericBlocks.REFINERY, "Refinery");
		//Items
		builder.add(JinericItems.GOLDEN_POTATO, "Golden Potato");
		builder.add(JinericItems.GOLDEN_SWEET_BERRIES, "Golden Sweet Berries");
		builder.add(JinericItems.GOLDEN_BEETROOT, "Golden Beetroot");
		builder.add(JinericItems.NETHERITE_HORSE_ARMOR, "Netherite Horse Armor");
		builder.add(JinericItems.STONE_UPGRADE_SMITHING_TEMPLATE, "Stone Upgrade");
		builder.add(JinericItems.COPPER_UPGRADE_SMITHING_TEMPLATE, "Copper Upgrade");
		builder.add(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE, "Iron Upgrade");
		builder.add(JinericItems.GOLD_UPGRADE_SMITHING_TEMPLATE, "Gold Upgrade");
		builder.add(JinericItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, "Diamond Upgrade");
		builder.add("item.jineric.smithing_template.stone_upgrade.applies_to", "Stone Equipment");
		builder.add("item.jineric.smithing_template.copper_upgrade.applies_to", "Copper Equipment");
		builder.add("item.jineric.smithing_template.iron_upgrade.applies_to", "Iron Equipment");
		builder.add("item.jineric.smithing_template.gold_upgrade.applies_to", "Gold Equipment");
		builder.add("item.jineric.smithing_template.diamond_upgrade.applies_to", "Diamond Equipment");
		builder.add("item.jineric.smithing_template.stone_upgrade.ingredients", "Stone");
		builder.add("item.jineric.smithing_template.copper_upgrade.ingredients", "Copper Ingot");
		builder.add("item.jineric.smithing_template.iron_upgrade.ingredients", "Iron Ingot");
		builder.add("item.jineric.smithing_template.gold_upgrade.ingredients", "Gold Ingot");
		builder.add("item.jineric.smithing_template.diamond_upgrade.ingredients", "Diamond");
		
		//  Other
		builder.add("container.jineric.campfire", "Campfire");
		builder.add("container.jineric.campfire.cooking_slot_description", "Add food, log, or clay ball");
		builder.add("container.jineric.work_bench", "Work Bench");
		builder.add("item.level", "Level: %s / %s");
		builder.add("item.level.max", "Level: Max");
		
		builder.add("item.jineric.smithing_template.stone_upgrade.base_slot_description", "Add wooden armor, weapon, or tool");
		builder.add("item.jineric.smithing_template.stone_upgrade.additions_slot_description", "Add Stone");
		builder.add("item.jineric.smithing_template.iron_upgrade.base_slot_description", "Add stone weapon or tool");
		builder.add("item.jineric.smithing_template.iron_upgrade.additions_slot_description", "Add Iron Ingot");
		builder.add("item.jineric.smithing_template.diamond_upgrade.base_slot_description", "Add iron armor, weapon, or tool");
		builder.add("item.jineric.smithing_template.diamond_upgrade.additions_slot_description", "Add Diamond");
		
		//  Game Options
		builder.add("options.jineric.itemLevelBarMode", "Item Level Bar");
		builder.add("options.jineric.itemLevelBar.always", "Always");
		builder.add("options.jineric.itemLevelBar.hover", "Hover");
		builder.add("options.jineric.itemLevelBar.never", "Never");
	}
	
	public void tryExisting(TranslationBuilder builder) {
		try {
			Path existingPath;
			if (dataOutput.getModContainer().findPath("assets/jineric/lang/en_us_existing.json").isPresent()) {
				existingPath = dataOutput.getModContainer().findPath("assets/jineric/lang/en_us_existing.json").get();
				builder.add(existingPath);
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to find existing language file!", e);
		}
	}
	
	public void addBlockFamilies(TranslationBuilder builder) {
		BlockFamilies.getFamilies().forEach(blockFamily -> {
			Block baseBlock = blockFamily.getBaseBlock();
			this.addJineric(builder, baseBlock);
			blockFamily.getVariants().forEach((variant, block) -> this.addJineric(builder, block));
		});
	}
	
	public void addWoodenEquipmentFamilies(TranslationBuilder builder) {
		EquipmentFamilies.WOODEN.getVariants().forEach((variant, item) -> {
			for (WoodType woodType : WoodType.stream().toList()) {
				String materialPath = woodType.name();
				String key = "item.jineric." + materialPath + "_" + variant;
				String value = WordUtils.capitalizeFully(materialPath.replace("_", " "));
				builder.add(key, value + " " + StringUtil.capitalize(variant.toString()));
			}
		});
	}
	
	public void addJineric(TranslationBuilder builder, Block block) {
		if (Registries.BLOCK.getId(block).getNamespace().equals("jineric")) {
			this.add(builder, block);
		}
	}
	
	// Rewrite to use RegistryEntry instead of generic Object
	public void add(TranslationBuilder translationBuilder, Object input) {
		String translationKey;
		if (input instanceof Block block) {
			translationKey = block.getTranslationKey();
			translationBuilder.add(block, this.parseString(translationKey));
		}
		else if (input instanceof Item item) {
			translationKey = item.getTranslationKey();
			translationBuilder.add(item, this.parseString(translationKey));
		}
	}
	
	public String parseString(String translationKey) {
		StringBuilder dirtyTranslationKey = new StringBuilder();
		StringBuilder translationKeyBuilder = new StringBuilder();
		boolean addPrevChar;
		for (char ch : translationKey.toCharArray()) {
			if (ch == '.') {
				dirtyTranslationKey = new StringBuilder();
				addPrevChar = false;
			} else {
				dirtyTranslationKey.append(ch);
				addPrevChar = true;
			}
			 if (addPrevChar) {
				 translationKeyBuilder = dirtyTranslationKey;
			}
		}
		translationKey = this.stripUnderscores(translationKeyBuilder.toString());
		return toTitleCase(translationKey);
	}
	
	public String stripUnderscores(String translationKey) {
		return translationKey.replace("_", " ");
	}
	
	public String toTitleCase(String translationKey) {
		StringBuilder convertedBlock = new StringBuilder();
		boolean capitalizeNext = false;
		boolean firstPass = true;
		for (char ch : translationKey.toCharArray()) {
			if (Character.isSpaceChar(ch)) {
				capitalizeNext = true;
			} else if (capitalizeNext || firstPass) {
				ch = Character.toTitleCase(ch);
				capitalizeNext = false;
				firstPass = false;
			} else {
				ch = Character.toLowerCase(ch);
			}
			convertedBlock.append(ch);
		}
		return convertedBlock.toString();
	}
	
	@Override
	public String getName() {
		return "Languages";
	}
}
