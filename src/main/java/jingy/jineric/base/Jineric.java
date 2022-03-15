package jingy.jineric.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jingy.jineric.block.ShulkerChestBlock;
import jingy.jineric.block.tileentity.ShulkerChestBlockEntity;
import jingy.jineric.item.JinericItemGroups;
import jingy.jineric.registry.JinericBlocks;
import jingy.jineric.registry.JinericItems;
import jingy.jineric.screen.ShulkerChestScreenHandler;
import jingy.jineric.sound.JinericSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Jineric implements ModInitializer {

	//MOD
	public static final Logger LOGGER = LogManager.getLogger("Jineric Mod");
	public static final String MOD_ID = "jineric";
	public static Identifier id(String path) {
	return new Identifier(MOD_ID, path);
	}

	//SHULKER CHEST
	public static final Block SHULKER_CHEST = new ShulkerChestBlock(FabricBlockSettings.of(Material.SHULKER_BOX));
	public static BlockEntityType<ShulkerChestBlockEntity> SHULKER_CHEST_ENTITY;

	public static final Identifier SHULKERCHEST = new Identifier(MOD_ID, "shulker_chest");
	public static final ScreenHandlerType<ShulkerChestScreenHandler> SHULKER_CHEST_SCREEN_HANDLER;


	static {
		SHULKER_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(SHULKERCHEST, ShulkerChestScreenHandler::new);
	}

	@Override
	public void onInitialize() {
	LOGGER.info("Jineric Mod Main - Starting initialization");

	JinericItems.init();
	JinericBlocks.init();
	JinericItemGroups.init();
	JinericSounds.init();

	Registry.register(Registry.BLOCK, new Identifier("jineric", "shulker_chest"), SHULKER_CHEST);
	SHULKER_CHEST_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "jineric:shulker_chest_entity", FabricBlockEntityTypeBuilder.create(ShulkerChestBlockEntity::new, SHULKER_CHEST).build(null));

	LOGGER.info("Jineric Mod Main - Finished initialization");
	}
}
