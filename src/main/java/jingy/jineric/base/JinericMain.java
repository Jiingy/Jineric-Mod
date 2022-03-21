package jingy.jineric.base;

import jingy.jineric.block.tileentity.ShulkerChestBlockEntity;
import jingy.jineric.registry.JinericBlocks;
import jingy.jineric.registry.JinericItemGroups;
import jingy.jineric.registry.JinericItems;
import jingy.jineric.screen.ShulkerChestScreenHandler;
import jingy.jineric.sound.JinericSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JinericMain implements ModInitializer {

	//MOD
	public static final Logger LOGGER = LogManager.getLogger("Jineric Mod");
	public static final String MOD_ID = "jineric";
	public static Identifier id(String path) {
	return new Identifier(MOD_ID, path);
	}

	//SHULKER CHEST
	public static final Identifier SHULKERCHEST = new Identifier(MOD_ID, "shulker_chest");
	public static final ScreenHandlerType<ShulkerChestScreenHandler> SHULKER_CHEST_SCREEN_HANDLER;

	static {
		SHULKER_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(SHULKERCHEST, ShulkerChestScreenHandler::new);
	}

	// boreal boat
	//public static final EntityType<JinericBoatEntity> BOREAL_BOAT = Registry.register(
			//Registry.ENTITY_TYPE,
			//new Identifier("jineric", "boreal_boat"),
			//FabricEntityTypeBuilder.create(SpawnGroup.MISC, JinericBoatEntity::new).build());

	@Override
	public void onInitialize() {
	LOGGER.info("Jineric Mod Main - Starting initialization");

	JinericItems.init();
	JinericBlocks.init();
	JinericItemGroups.init();
	JinericSounds.init();

		//COMPOSTABLE BLOCKS
		CompostingChanceRegistry.INSTANCE.add(JinericItems.TUMBLEWEED, 0.5F);
		CompostingChanceRegistry.INSTANCE.add(JinericItems.BOREAL_LEAVES, 0.5F);

		//FLAMMABLE BLOCKS
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.STRIPPED_BOREAL_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.STRIPPED_BOREAL_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_TRAPDOOR, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_DOOR, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_PRESSURE_PLATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_BUTTON, 5, 20);
		//FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_SIGN, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.CHARCOAL_BLOCK, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BAMBOO_BLOCK, 60, 20);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.BOREAL_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(JinericBlocks.TUMBLEWEED, 30, 60);

		//STRIPPABLE BLOCKS
		StrippableBlockRegistry.register(JinericBlocks.BOREAL_LOG, JinericBlocks.STRIPPED_BOREAL_LOG);
		StrippableBlockRegistry.register(JinericBlocks.BOREAL_WOOD, JinericBlocks.STRIPPED_BOREAL_WOOD);


	Registry.register(Registry.BLOCK, new Identifier("jineric", "shulker_chest"), JinericBlocks.SHULKER_CHEST);
	JinericBlocks.SHULKER_CHEST_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "jineric:shulker_chest_entity", FabricBlockEntityTypeBuilder.create(ShulkerChestBlockEntity::new, JinericBlocks.SHULKER_CHEST).build(null));

	LOGGER.info("Jineric Mod Main - Finished initialization");
	}
}
