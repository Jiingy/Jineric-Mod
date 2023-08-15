package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ColoredBlocks {

    public static void genAllColoredFeatures() {
        genColoredBlocks("randomcolor", MapColor.BLACK);
        genColoredItems("randomcolor");
    }

    public static Block getColoredBlock(String color, String blockType) {
        return Registries.BLOCK.get(JinericMain.id(color + "_" + blockType));
    }

    public static Item getColoredItem(String color, String itemType) {
        return Registries.ITEM.get(JinericMain.id(color + "_" + itemType));
    }

    private static void genColoredBlocks(String color, MapColor mapColor) {
        registerBlock(color + "_" + "wool", new Block(AbstractBlock.Settings.create().mapColor(mapColor).instrument(Instrument.GUITAR).strength(0.8F).sounds(BlockSoundGroup.WOOL).burnable()));
    }

    private static void genColoredItems(String color) {
        registerItem(color + "_" + "wool", new BlockItem(getColoredBlock(color, "wool"), new FabricItemSettings()));
    }

    private static void registerBlock(String id, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(JinericMain.MOD_ID, id), block);
    }

    private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(JinericMain.MOD_ID, name), item);
    }
}
