package jingy.jineric;

import jingy.jineric.blocks.JinericBlocks;
import jingy.jineric.items.JinericItemGroups;
import jingy.jineric.items.JinericItems;
import jingy.jineric.sounds.JinericSounds;
import jingy.jineric.world.JinericWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class Jineric implements ModInitializer {

    public static final String MOD_ID = "jineric";
    public static final BlockEntityType<?> SHULKER_CHEST_ENTITY_TYPE = ;

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    public static final Identifier SHULKER_CHEST = new Identifier(MOD_ID, "shulker_chest");
    public static final String SHULKER_CHEST_TRANSLATION_KEY = Util.createTranslationKey("shulker_chest", SHULKER_CHEST);


    @Override
    public void onInitialize() {

        ContainerProviderRegistry.INSTANCE.registerFactory(SHULKER_CHEST, (syncId, identifier, player, buf) -> {
            final World world = player.world;
            final BlockPos pos = buf.readBlockPos();
            return world.getBlockState(pos).createContainerFactory(player.world, pos).createMenu(syncId, player.inventory, player);
        });

        JinericItems.init();
        JinericBlocks.init();
        JinericItemGroups.init();
        JinericWorldGen.init();
        JinericSounds.init();
    }
}