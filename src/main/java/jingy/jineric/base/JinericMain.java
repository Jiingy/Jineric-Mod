package jingy.jineric.base;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.entity.effect.JinericStatusEffects;
import jingy.jineric.item.JinericItemGroups;
import jingy.jineric.item.JinericItems;
import jingy.jineric.potion.JinericPotions;
import jingy.jineric.recipe.JinericRecipeBookCategories;
import jingy.jineric.recipe.JinericRecipeSerializer;
import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.registry.JinericBiomeGeneration;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.registry.JinericRegistries;
import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.stat.JinericStats;
import jingy.jineric.tag.JinericBlockTags;
import jingy.jineric.tag.JinericEntityTypeTags;
import jingy.jineric.tag.JinericItemTags;
import jingy.jineric.world.biome.JinericBiomeKeys;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.ParameterUtils;

import java.util.List;

public class JinericMain implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("Jineric Mod");
	public static final String MOD_ID = "jineric";
	
	public static Identifier ofJineric(String path) {
		return Identifier.of(MOD_ID, path);
	}
	
	@Override
	public void onInitialize() {
		LOGGER.info("Jineric Mod Main - Starting initialization");
		this.initRegistries();
		System.out.println("Jineric Mod Main - Finished initialization");
	}
	
	private void initRegistries() {
		JinericBiomeGeneration.registerBiomeGeneration();
		JinericRegistries.initializeJinericRegistries();
		JinericBlocks.initialize();
		JinericItems.initialize();
		JinericBlockFamilies.initialize();
		JinericScreenHandlerType.initialize();
		JinericBlockTags.initialize();
		JinericItemTags.initialize();
		JinericEntityTypeTags.initialize();
		JinericRecipeTypes.initialize();
		JinericStats.initialize();
		JinericRecipeSerializer.initialize();
		JinericPotions.initialize();
		JinericRecipeBookCategories.initialize();
		JinericBlockEntityType.registerBlockEntityTypes();
		JinericStatusEffects.registerStatusEffects();
		JinericItemGroups.registerJinericItemGroups();
		JinericItemGroups.registerItemGroups();
		JinericBiomeKeys.initialize();
	}
}
