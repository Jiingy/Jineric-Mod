package com.jingy.jineric.registry;

import com.jingy.jineric.Jineric;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {

    //STONE BLOCKS:
    public static final Block CORRITE = BlockSettings.StoneSettings();
    public static final Block BORITE = BlockSettings.StoneSettings();

    //SAND BLOCKS:
    public static final Block WAVY_SANDSTONE = BlockSettings.SandstoneSettings();

    //SOUL SAND BLOCKS:

    public static final Block SOUL_SANDSTONE =  BlockSettings.SandstoneSettings();
    public static final Block CUT_SOUL_SANDSTONE = BlockSettings.SandstoneSettings();
    public static final Block CHISELED_SOUL_SANDSTONE = BlockSettings.SandstoneSettings();
    public static final Block WAVY_SOUL_SANDSTONE = BlockSettings.SandstoneSettings();
    public static final Block SMOOTH_SOUL_SANDSTONE = BlockSettings.SandstoneSettings();

    public static void registerBlocks() {

//STONES:

        //Corrite:
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "corrite"), CORRITE);

        //Borite:
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "borite"), BORITE);

        //SANDSTONES:
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "wavy_sandstone"), WAVY_SANDSTONE);

        //SOUL SANDSTONE:
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "cut_soul_sandstone"), CUT_SOUL_SANDSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "chiseled_soul_sandstone"), CHISELED_SOUL_SANDSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "wavy_soul_sandstone"), WAVY_SOUL_SANDSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "smooth_soul_sandstone"), SMOOTH_SOUL_SANDSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "soul_sandstone"), SOUL_SANDSTONE);
    }
}