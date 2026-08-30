package jingy.jineric.block.entity;

import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CharcoalPileBlockEntity extends AbstractFurnaceBlockEntity {

    public CharcoalPileBlockEntity(BlockPos worldPosition, BlockState blockState, RecipeType<? extends AbstractCookingRecipe> recipeType) {
        super(JinericBlockEntityType.CHARCOAL_PILE, worldPosition, blockState, recipeType);
    }

    @Override
    protected Component getDefaultName() {
        return null;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return null;
    }
}
