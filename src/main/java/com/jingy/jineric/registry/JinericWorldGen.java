package com.jingy.jineric.registry;

import com.jingy.jineric.Jineric;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class JinericWorldGen {

    public static ConfiguredFeature<?, ?> BORITE_VEIN = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Jineric.MOD_ID, "borite_vein"), Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Registry.BLOCK.get(new Identifier(Jineric.MOD_ID, "borite")).getDefaultState(), 33)).rangeOf(80)).spreadHorizontally().repeat(10);
    public static final ConfiguredFeature<?, ?> borite = BORITE_VEIN;

    public static void init() {

    }
}
