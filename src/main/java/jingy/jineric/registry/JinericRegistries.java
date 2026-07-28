package jingy.jineric.registry;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.tag.JinericBlockTags;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
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
		FuelValueEvents.BUILD.register((builder, context) -> {
			builder.add(JinericItemTags.WOODEN_BOOKSHELVES, 300)
					.add(JinericItemTags.WOODEN_CHESTS, 300)
					.add(JinericItemTags.WOODEN_TRAPPED_CHESTS, 300)
					.add(JinericItemTags.WOODEN_LADDERS, 300);
		});
	}
	
	private static void registerCompostable() {
		CompostableRegistry registry = CompostableRegistry.INSTANCE;

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
		OxidizableBlocksRegistry.registerWeatheringCopperBlocks(JinericBlocks.CUT_COPPER_WALLS);
	}
	
	private static void registerWaxableBlockPairs() {
	}
}
