package com.jingy.jineric;

import net.fabricmc.api.ModInitializer;

public class Jineric implements ModInitializer {

    public static final String MOD_ID = "jineric";

    @Override
    public void onInitialize() {
        Items.init();
        Blocks.init();
        ItemGroups.init();
    }
}