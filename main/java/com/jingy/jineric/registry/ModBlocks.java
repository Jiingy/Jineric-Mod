package com.jingy.jineric.registry;

import com.jingy.jineric.Jineric;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

//STONE BLOCKS:
    public static final Block CORRITE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(1.5f, 30.0f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block BORITE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(1.5f, 30.0f)
            .sounds(BlockSoundGroup.STONE));

//SAND BLOCKS:
    public static final Block WAVY_SANDSTONE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.8f, 4f)
            .sounds(BlockSoundGroup.STONE));

//SOUL SAND BLOCKS:

    public static final Block SOUL_SANDSTONE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.8f, 4f)
            .sounds(BlockSoundGroup.SOUL_SAND));

    public static final Block CUT_SOUL_SANDSTONE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.8f, 4f)
            .sounds(BlockSoundGroup.SOUL_SAND));

    public static final Block CHISELED_SOUL_SANDSTONE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.8f, 4f)
            .sounds(BlockSoundGroup.SOUL_SAND));

    public static final Block WAVY_SOUL_SANDSTONE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.8f, 4f)
            .sounds(BlockSoundGroup.SOUL_SAND));

    public static final Block SMOOTH_SOUL_SANDSTONE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.8f, 4f)
            .sounds(BlockSoundGroup.SOUL_SAND));



    public static void registerBlocks() {
//STONES:
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "corrite"), CORRITE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "borite"), BORITE);

//SANDS:
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "wavy_sandstone"), WAVY_SANDSTONE);

//SOUL SANDS:
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "soul_sandstone"), SOUL_SANDSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "cut_soul_sandstone"), CUT_SOUL_SANDSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "chiseled_soul_sandstone"), CHISELED_SOUL_SANDSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "wavy_soul_sandstone"), WAVY_SOUL_SANDSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Jineric.MOD_ID, "smooth_soul_sandstone"), SMOOTH_SOUL_SANDSTONE);
    }
}
