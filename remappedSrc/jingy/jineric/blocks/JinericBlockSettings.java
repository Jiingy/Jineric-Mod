package jingy.jineric.blocks;

import jingy.jineric.JinericSounds;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.enchantment.SilkTouchEnchantment;
import net.minecraft.sound.BlockSoundGroup;

public class JinericBlockSettings {

    public static Block StoneSettings() {
        return new Block(FabricBlockSettings
                .of(Material.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool()
                .strength(1.5f, 30.0f)
                .sounds(BlockSoundGroup.STONE));
    }

    public static Block JinericSoulSandstoneSettings() {
        return new Block(FabricBlockSettings
                .of(Material.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool()
                .strength(0.8f, 4f)
                .sounds(JinericSounds.SOUL_SANDSTONE));
    }
    public static Block SandstoneSettings() {
        return new Block(FabricBlockSettings
                .of(Material.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool()
                .strength(0.8f, 4f)
                .sounds(BlockSoundGroup.STONE));
    }
    public static Block JinericPackedIceSettings() {
        return new Block(FabricBlockSettings
                .of(Material.DENSE_ICE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool()
                .strength(0.5f, 0.5f)
                .sounds(BlockSoundGroup.GLASS));

    }
    public static Block JinericSnowWallSettings() {
        return new Block(FabricBlockSettings
                .of(Material.STONE)
                .breakByTool(FabricToolTags.SHOVELS, 0)
                .requiresTool()
                .strength(0.5f, 0.5f)
                .sounds(BlockSoundGroup.SNOW));
    }
}
