package jingy.jineric;

import jingy.jineric.blocks.JinericBlocks;
import jingy.jineric.items.JinericItemGroups;
import jingy.jineric.items.JinericItems;
import jingy.jineric.sounds.JinericSounds;
///import jingy.jineric.world.JinericWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


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
///        JinericWorldGen.init();
        JinericSounds.init();
    }
}