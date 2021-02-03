package jingy.jineric;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItemGroups;
import jingy.jineric.item.JinericItems;
import jingy.jineric.world.JinericWorldGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;


public class Jineric implements ModInitializer {
    public static final String MOD_ID = "jineric";

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        JinericItems.init();
        JinericBlocks.init();
        JinericItemGroups.init();
        JinericWorldGen.init();
        JinericSounds.init();
    }
}