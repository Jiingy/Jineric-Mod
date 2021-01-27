package com.jingy.jineric.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BlockSettings {

    public static Block StoneSettings() {
        return new Block(FabricBlockSettings
                .of(Material.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool()
                .strength(1.5f, 30.0f)
                .sounds(BlockSoundGroup.STONE));
    }

    public static Block SandstoneSettings() {
        return new Block(FabricBlockSettings
                .of(Material.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool()
                .strength(0.8f, 4f)
                .sounds(BlockSoundGroup.SOUL_SAND));
    }

}
