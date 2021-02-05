package jingy.jineric.blockentities;

import jingy.jineric.Jineric;
import jingy.jineric.inventory.ShulkerChestInventory;
import jingy.jineric.screenhandlers.ShulkerChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class ShulkerChestBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ShulkerChestInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(54, ItemStack.EMPTY);
    //private static final int INVENTORY_SIZE = 54;

    public ShulkerChestBlockEntity() {
        super(Jineric.SHULKER_CHEST_BLOCK_ENTITY);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ShulkerChestScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, this.inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        return tag;
    }
    public static void init() {
    }
}

