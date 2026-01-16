package net.jineric.jineric_mod.data.generation.providers;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class JinericLanguageProvider extends FabricLanguageProvider {
	public JinericLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	@Override
	public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder builder) {
		this.tryExisting(builder);
		// Modded
			//  Blocks
		this.addBlockFamilies(builder);
		builder.add(JinericBlocks.SOUL_JACK_O_LANTERN, "Soul Jack o'Lantern");
		builder.add(JinericBlocks.SUGAR_BLOCK, "Block of Sugar");
		builder.add(JinericBlocks.ROTTEN_FLESH_BLOCK, "Block of Rotten Flesh");
		builder.add(JinericBlocks.FLINT_BLOCK, "Block of Flint");
		builder.add(JinericBlocks.CHARCOAL_BLOCK, "Block of Charcoal");
		builder.add(JinericBlocks.STICK_BLOCK, "Bundle of Sticks");
		builder.add(JinericBlocks.PAPER_BLOCK, "Stack of Paper");
		builder.add(JinericBlocks.GRASS_BLOCK, "Block of Grass");
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
		builder.add(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");
			// Containers
		builder.add("container.oak_chest", "Oak Chest");
		builder.add("container.spruce_chest", "Spruce Chest");
		builder.add("container.birch_chest", "Birch Chest");
		builder.add("container.jungle_chest", "Jungle Chest");
		builder.add("container.acacia_chest", "Acacia Chest");
		builder.add("container.dark_oak_chest", "Dark Oak Chest");
		builder.add("container.mangrove_chest", "Mangrove Chest");
		builder.add("container.cherry_chest", "Cherry Chest");
		builder.add("container.bamboo_chest", "Bamboo Chest");
		builder.add("container.pale_oak_chest", "Pale Oak Chest");
		builder.add("container.crimson_chest", "Crimson Chest");
		builder.add("container.warped_chest", "Warped Chest");
		
		builder.add("container.unaffected_copper_chest", "Copper Chest");
		builder.add("container.exposed_copper_chest", "Exposed Copper Chest");
		builder.add("container.weathered_copper_chest", "Weathered Copper Chest");
		builder.add("container.oxidized_copper_chest", "Oxidized Copper Chest");
		builder.add("container.double_unaffected_copper_chest", "Double Copper Chest");
		builder.add("container.double_exposed_copper_chest", "Double Exposed Copper Chest");
		builder.add("container.double_weathered_copper_chest", "Double Weathered Copper Chest");
		builder.add("container.double_oxidized_copper_chest", "Double Oxidized Copper Chest");
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
		BlockFamilies.getAllFamilies().forEach(blockFamily -> {
			Block baseBlock = blockFamily.getBaseBlock();
			this.addJineric(builder, baseBlock);
			blockFamily.getVariants().forEach((variant, block) -> this.addJineric(builder, block));
		});
	}
	
	public void addJineric(TranslationBuilder builder, Block block) {
		if (BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("jineric")) {
			this.add(builder, block);
		}
	}
	
	// Rewrite to use RegistryEntry instead of generic Object
	public void add(TranslationBuilder translationBuilder, Object input) {
		String translationKey;
		if (input instanceof Block block) {
			translationKey = block.getDescriptionId();
			translationBuilder.add(block, this.parseString(translationKey));
		}
		else if (input instanceof Item item) {
			translationKey = item.getDescriptionId();
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
