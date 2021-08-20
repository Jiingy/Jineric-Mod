package jingy.jineric;

import jingy.jineric.blocks.JinericBlocks;
import jingy.jineric.items.JinericItemGroups;
import jingy.jineric.items.JinericItems;
import jingy.jineric.sounds.JinericSounds;
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
        ///JinericWorldGen.init();
        JinericSounds.init();
    }
}