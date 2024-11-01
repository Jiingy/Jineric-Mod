package jingy.jineric.data.generators;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class JinericItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> CHESTS = registerItemTag("chests");
    public static final TagKey<Item> WOODEN_BOOKSHELVES = registerItemTag("wooden_bookshelves");
    public static final TagKey<Item> WOODEN_CHESTS = registerItemTag("wooden_chests");
    public static final TagKey<Item> WOODEN_LADDERS = registerItemTag("wooden_ladders");
    public static final TagKey<Item> WOODEN_TRAPPED_CHESTS = registerItemTag("wooden_trapped_chests");
    //TODO: POOR IMPLEMENTATION FOR DATAGEN LOGIC
    public static final TagKey<Item> REFINING_MISC = registerItemTag("refining_misc");

    public JinericItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public JinericItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(REFINING_MISC)
                .add(Items.GLASS);
    }

    private static TagKey<Item> registerItemTag(String id) {
        return TagKey.of(Registries.ITEM.getKey(), JinericMain.ofJineric(id));
    }
}
