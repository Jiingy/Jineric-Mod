package jingy.jineric.base;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.entity.effect.JinericStatusEffects;
import jingy.jineric.item.JinericItems;
import jingy.jineric.item.JmCreativeModeTabs;
import jingy.jineric.network.packet.JmPlayPackets;
import jingy.jineric.potion.JinericPotions;
import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.recipe.book.JinericRecipeBookCategories;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.registry.JinericRegistries;
import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.stat.JinericStats;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JinericMain implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("Jineric Mod");
	public static final String MOD_ID = "jineric";
	
	public static Identifier ofJineric(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
	
	@Override
	public void onInitialize() {
		LOGGER.info("Jineric Mod Main - Starting initialization");
		this.initRegistries();
		System.out.println("Jineric Mod Main - Finished initialization");
	}
	
	private void initRegistries() {
		JmPlayPackets.initialize();
//		PayloadTypeRegistry.playS2C().register(JmRecipeBookSettingsS2CPacket.ID, JmRecipeBookSettingsS2CPacket.CODEC);
		JinericBlocks.initialize();
		JinericItems.initialize();
		JinericBlockFamilies.initialize();
		JinericScreenHandlerType.initialize();
		JinericItemTags.initialize();
		JinericRecipeTypes.initialize();
		JinericStats.initialize();
		JinericPotions.initialize();
		JinericRecipeBookCategories.initialize();
		JinericBlockEntityType.registerBlockEntityTypes();
		JinericStatusEffects.registerStatusEffects();
		JmCreativeModeTabs.registerJinericItemGroups();
		JmCreativeModeTabs.modifyVanillaGroups();
		JinericRegistries.initializeJinericRegistries();
	}
}
