package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

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
		builder.add(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");
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
