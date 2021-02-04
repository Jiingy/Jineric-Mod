package jingy.jineric.block;

import jingy.jineric.Jineric;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.awt.*;

public class JinericShulkerChestBlock extends BlockEntity {
    public JinericShulkerChestBlock(Settings settings) {
        super(settings);
    }

    // A side effect of extending BlockWithEntity is it changes the render type to INVISIBLE, so we have to revert this
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    // We will create the BlockEntity later.
    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new JinericShulkerChestBlockEntity();
    }

    @Override
    public void onPlace(World world, BlockPos pos, BlockState state, LivingEntity Placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof JinericShulkerChestBlockEntity) {
                ((JinericShulkerChestBlockEntity)blockEntity).setCustomName(itemStack.getName());
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof JinericShulkerChestBlockEntity) {
                ContainerProviderRegistry.INSTANCE.openContainer(JinericBlocks.SHULKER_CHEST, player, buf -> buf.writeBlockPos(pos));
            }
        }
        return ActionResult.SUCCESS;
    }

    // Scatter the items in the chest when it is removed.
    @Override
    public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof JinericShulkerChestBlock) {
                ItemScatterer.spawn(world, pos, (JinericShulkerChestBlockEntity)blockEntity); {
                    // update comparators
                    world.updateComparators(pos, this);
                }
                super.onBlockRemoved(state, world, pos, newState, moved);
            }
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return Container.c(world.getBlockEntity(pos));

    }
    public static void init () {
    }
}