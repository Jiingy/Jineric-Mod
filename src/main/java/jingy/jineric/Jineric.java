package jingy.jineric;

import jingy.jineric.blockentities.ShulkerChestBlockEntity;
import jingy.jineric.blocks.JinericBlocks;
import jingy.jineric.blocks.ShulkerChestBlock;
import jingy.jineric.inventory.ShulkerChestInventory;
import jingy.jineric.items.JinericItemGroups;
import jingy.jineric.items.JinericItems;
import jingy.jineric.screenhandlers.ShulkerChestScreenHandler;
import jingy.jineric.sounds.JinericSounds;
import jingy.jineric.world.JinericWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import net.minecraft.util.registry.Registry;

public class Jineric implements ModInitializer {
    public static final String MOD_ID = "jineric";
    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    public static final ScreenHandlerType<ShulkerChestScreenHandler> SHULKER_CHEST_SCREEN_HANDLER;
    public static final Block SHULKER_CHEST_BLOCK;
    public static final BlockItem SHULKER_CHEST_BLOCK_ITEM;
    public static final BlockEntityType<ShulkerChestBlockEntity> SHULKER_CHEST_BLOCK_ENTITY;
    public static final Identifier SHULKER_CHEST_EXIST = new Identifier(MOD_ID, "shulker_chest_block");

    static {
        SHULKER_CHEST_BLOCK = Registry.register(Registry.BLOCK, SHULKER_CHEST_EXIST, new Block(FabricBlockSettings.copyOf(Blocks.CHEST)));
        SHULKER_CHEST_BLOCK_ITEM = Registry.register(Registry.ITEM, SHULKER_CHEST_EXIST, new BlockItem(SHULKER_CHEST_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        SHULKER_CHEST_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, SHULKER_CHEST_EXIST, BlockEntityType.Builder.create(ShulkerChestBlockEntity::new, SHULKER_CHEST_BLOCK).build(null));
        SHULKER_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(SHULKER_CHEST_EXIST, ShulkerChestScreenHandler::new);
    }

    @Override
    public void onInitialize() {
        JinericItems.init();
        JinericBlocks.init();
        JinericItemGroups.init();
        JinericWorldGen.init();
        JinericSounds.init();
        ShulkerChestBlockEntity.init();
        ShulkerChestInventory.init();
    }

}