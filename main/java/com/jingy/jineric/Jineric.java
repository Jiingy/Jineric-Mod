package com.jingy.jineric;

import com.jingy.jineric.registry.ModBlocks;
import com.jingy.jineric.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class Jineric implements ModInitializer {

    public static final String MOD_ID = "jineric";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}