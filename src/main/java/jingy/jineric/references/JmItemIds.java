package jingy.jineric.references;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class JmItemIds extends ItemIds {
    public static final ResourceKey<Item> WOODEN_HELMET = create("wooden_helmet");
    public static final ResourceKey<Item> WOODEN_CHESTPLATE = create("wooden_chestplate");
    public static final ResourceKey<Item> WOODEN_LEGGINGS = create("wooden_leggings");
    public static final ResourceKey<Item> WOODEN_BOOTS = create("wooden_boots");

    private static ResourceKey<Item> create(final String name) {
        return ResourceKey.create(Registries.ITEM, JinericMain.ofJineric(name));
    }
}
