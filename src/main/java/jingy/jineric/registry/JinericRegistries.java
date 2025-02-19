package jingy.jineric.registry;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.tag.JinericBlockTags;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;

public class JinericRegistries {
	public static void initializeJinericRegistries() {
		registerIsFuel();
		registerCompostable();
		registerStrippable();
		registerFlammable();
		registerOxidizableBlockPairs();
		registerWaxableBlockPairs();
	}
	
	private static void registerIsFuel() {
		FuelRegistryEvents.BUILD.register((builder, context) -> builder
				.add(JinericItemTags.WOODEN_BOOKSHELVES, 300)
				.add(JinericItemTags.WOODEN_CHESTS, 300)
				.add(JinericItemTags.WOODEN_TRAPPED_CHESTS, 300)
				.add(JinericItemTags.WOODEN_LADDERS, 300)
		);
	}
	
	private static void registerCompostable() {
		CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;
	}
	
	private static void registerStrippable() {
	}
	
	private static void registerFlammable() {
		FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();
		instance.add(JinericBlockTags.WOODEN_BOOKSHELVES, 30, 20);
		instance.add(JinericBlocks.PAPER_BLOCK, 5, 20);
		instance.add(JinericBlocks.STICK_BLOCK, 5, 20);
	}
	
	private static void registerOxidizableBlockPairs() {
		OxidizableBlocksRegistry.registerOxidizableBlockPair(JinericBlocks.CUT_COPPER_WALL, JinericBlocks.EXPOSED_CUT_COPPER_WALL);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WEATHERED_CUT_COPPER_WALL);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.OXIDIZED_CUT_COPPER_WALL);
	}
	
	private static void registerWaxableBlockPairs() {
		OxidizableBlocksRegistry.registerWaxableBlockPair(JinericBlocks.CUT_COPPER_WALL, JinericBlocks.WAXED_CUT_COPPER_WALL);
		OxidizableBlocksRegistry.registerWaxableBlockPair(JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL);
		OxidizableBlocksRegistry.registerWaxableBlockPair(JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL);
		OxidizableBlocksRegistry.registerWaxableBlockPair(JinericBlocks.OXIDIZED_CUT_COPPER_WALL, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL);
	}
}
