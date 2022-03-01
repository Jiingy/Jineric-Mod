package jingy.jineric;

import jingy.jineric.blocks.JinericBlocks;
import jingy.jineric.items.JinericItemGroups;
import jingy.jineric.items.JinericItems;
import jingy.jineric.sounds.JinericSounds;
import jingy.jineric.world.JinericWorldGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;


public class Jineric implements ModInitializer {
		public static final String MOD_ID = "jineric";
		public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

		//public static final Block BOREAL_TRAPDOOR = new Block(FabricBlockSettings.of(Material.WOOD).strength(4.0f));

		@Override
		public void onInitialize() {
			//Registry.register(Registry.BLOCK, new Identifier("tutorial", "boreal_trapdoor"), BOREAL_TRAPDOOR);
			//Registry.register(Registry.ITEM, new Identifier("tutorial", "boreal_trapdoor"), new BlockItem(BOREAL_TRAPDOOR, new FabricItemSettings().group(ItemGroup.MISC)));

		JinericItems.init();
		JinericBlocks.init();
		JinericItemGroups.init();
		JinericWorldGen.init();
		JinericSounds.init();
	}
}
