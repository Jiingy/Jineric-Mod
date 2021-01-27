package com.jingy.jineric;

import com.jingy.jineric.registry.Blocks;
import com.jingy.jineric.registry.Items;
import net.fabricmc.api.ModInitializer;

public class Jineric implements ModInitializer {

    public static final String MOD_ID = "jineric";

    @Override
    public void onInitialize() {
        Items.registerItems();
        Blocks.registerBlocks();
    }
}