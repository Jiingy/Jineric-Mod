package net.jineric.jineric_mod.render.block;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltInBlockModelsCallback;
import net.jineric.jineric_mod.renderer.special.JmChestSpecialRenderer;
import net.minecraft.client.renderer.block.BuiltInBlockModels;

public class JmBuiltInBlockModels extends BuiltInBlockModels {

    public static void addJmDefaults() {
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.SPRUCE), JinericBlocks.SPRUCE_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.BIRCH), JinericBlocks.BIRCH_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.JUNGLE), JinericBlocks.JUNGLE_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.ACACIA), JinericBlocks.ACACIA_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.DARK_OAK), JinericBlocks.DARK_OAK_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.MANGROVE), JinericBlocks.MANGROVE_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.CHERRY), JinericBlocks.CHERRY_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.PALE_OAK), JinericBlocks.PALE_OAK_CHEST));
//        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.POPLAR), JinericBlocks.POPLAR_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.BAMBOO), JinericBlocks.BAMBOO_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.CRIMSON), JinericBlocks.CRIMSON_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.WARPED), JinericBlocks.WARPED_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_SPRUCE), JinericBlocks.TRAPPED_SPRUCE_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_BIRCH), JinericBlocks.TRAPPED_BIRCH_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_JUNGLE), JinericBlocks.TRAPPED_JUNGLE_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_ACACIA), JinericBlocks.TRAPPED_ACACIA_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_DARK_OAK), JinericBlocks.TRAPPED_DARK_OAK_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_MANGROVE), JinericBlocks.TRAPPED_MANGROVE_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_CHERRY), JinericBlocks.TRAPPED_CHERRY_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_PALE_OAK), JinericBlocks.TRAPPED_PALE_OAK_CHEST));
//        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_POPLAR), JinericBlocks.TRAPPED_POPLAR_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_BAMBOO), JinericBlocks.TRAPPED_BAMBOO_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_CRIMSON), JinericBlocks.TRAPPED_CRIMSON_CHEST));
        BuiltInBlockModelsCallback.EVENT.register(builder -> builder.put(createXmasChest(JmChestSpecialRenderer.TRAPPED_WARPED), JinericBlocks.TRAPPED_WARPED_CHEST));
    }
}
